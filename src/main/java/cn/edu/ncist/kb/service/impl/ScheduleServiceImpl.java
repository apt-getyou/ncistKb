package cn.edu.ncist.kb.service.impl;

import cn.edu.ncist.kb.bean.ScheduleBean;
import cn.edu.ncist.kb.dao.ScheduleDao;
import cn.edu.ncist.kb.po.SchedulePO;
import cn.edu.ncist.kb.service.ScheduleService;
import cn.edu.ncist.kb.vo.ScheduleVO;

import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

/**
 * @author banhujiu
 * @date 2018/3/17 0017 21:31
 */
@Service("scheduleService")
public class ScheduleServiceImpl implements ScheduleService {
	@Resource
	private ScheduleDao scheduleDao;

	@Override
	public HashMap<Integer, List<List<String>>> getSchedule(List<String> xhs, ScheduleBean bean) {
		bean.setXhs(xhs);
		bean.setXN("2017");
		bean.setXQ_ID("0");
		List<SchedulePO> pos = scheduleDao.queryListByXHs(bean);

		Map<String, String> studentMap = getStudentMap(pos);
		Set<String> studentXHSet = getStudentXHSet(pos);
		Map<ScheduleVO, List<String>> map = getVOMap(pos);

		Integer maxWeek = getMaxWeek(pos);

		Map<ScheduleVO, List<String>> result = initResultMap(maxWeek);
		putNoScheduleStudent(studentXHSet, map, result);

		HashMap<Integer, List<List<String>>> reList = new HashMap<>();
		for (int section = 1; section <= 5; section++) {
			List<List<String>> sectionList = new ArrayList<>();
			for (int day = 1; day <= 7; day++) {
				List<String> list = getStrings(studentMap, maxWeek, result, section, day);
				sectionList.add(list);
			}
			reList.put(section, sectionList);
		}
		return reList;
	}

	@Override
	public List<String> getXhsFormExcel(List<String[]> listOb) {
		// 导入文件内，第一列为学号
		List<String> xhs = new ArrayList<>();
		for (String[] strings : listOb) {
			if (strings.length >= 1) {
				xhs.add(strings[0]);
			}
		}
		return xhs;
	}

	/**
	 * 获取一周内每一节课里没有课的人
	 */
	private List<String> getStrings(Map<String, String> studentMap, Integer maxWeek, Map<ScheduleVO, List<String>> result, int section, int day) {
		Map<String, List<Integer>> listMap = new HashMap<>();
		for (int week = 1; week <= maxWeek; week++) {
			ScheduleVO key = ScheduleVO.init(week, day, section);
			List<String> studentXHList = result.get(key);
			for (String xh : studentXHList) {
				listMap.computeIfAbsent(xh, k -> new ArrayList<>());
				listMap.get(xh).add(week);
			}
		}
		Map<List<Integer>, Set<String>> weekStuXHMap = new HashMap<>();
		for (Map.Entry<String, List<Integer>> entry : listMap.entrySet()) {
			weekStuXHMap.computeIfAbsent(entry.getValue(), k -> new HashSet<>());
			weekStuXHMap.get(entry.getValue()).add(entry.getKey());
		}
		List<String> list = new ArrayList<>();
		for (Map.Entry<List<Integer>, Set<String>> entry : weekStuXHMap.entrySet()) {
			String week = makeWeekListToString(entry.getKey());
			String stuName = getStuNameByXHMap(entry.getValue(), studentMap);
			list.add(week + ":" + stuName);
		}
		return list;
	}

	private String getStuNameByXHMap(Set<String> value, Map<String, String> studentMap) {
		StringBuilder sb = new StringBuilder();
		for (String s : value) {
			sb.append(studentMap.get(s)).append(",");
		}
		if (sb.length() >= 1) {
			sb.deleteCharAt(sb.length() - 1);
		}
		return sb.toString();
	}

	private String makeWeekListToString(List<Integer> key) {
		if (key == null || key.isEmpty()) {
			return "";
		}
		if (key.size() == 1) {
			return key.get(0).toString();
		}
		Integer max = Collections.max(key);
		Integer min = Collections.min(key);

		StringBuilder sb = new StringBuilder();
		for (int i = min; i <= max; i++) {
			if (key.contains(i)) {
				if (sb.length() == 0 || sb.charAt(sb.length() - 1) == ',') {
					sb.append(i);
				} else if (i == max) {
					sb.append("-").append(i);
				}
			} else {
				if (sb.charAt(sb.length() - 1) != ',') {
					sb.append("-").append(i - 1);
					if (i != max) {
						sb.append(",");
					}
				}
			}
		}
		sb.insert(0, "[");
		sb.append("周]");
		return sb.toString();
	}

	private void putNoScheduleStudent(Set<String> studentXHSet, Map<ScheduleVO, List<String>> map, Map<ScheduleVO, List<String>> result) {
		for (Map.Entry<ScheduleVO, List<String>> entry : result.entrySet()) {
			List<String> haveScheduleStu = map.get(entry.getKey());
			if (haveScheduleStu == null) {
				haveScheduleStu = new ArrayList<>();
			}
			for (String studentXH : studentXHSet) {
				if (!haveScheduleStu.contains(studentXH)) {
					entry.getValue().add(studentXH);
				}
			}
		}
	}

	private Set<String> getStudentXHSet(List<SchedulePO> pos) {
		Set<String> studentXHSet = new HashSet<>();
		for (SchedulePO po : pos) {
			studentXHSet.add(po.getUSER_XH());
		}
		return studentXHSet;
	}

	private Map<ScheduleVO, List<String>> initResultMap(Integer maxWeek) {
		Map<ScheduleVO, List<String>> result = new HashMap<>();
		for (int week = 1; week <= maxWeek; week++) {
			for (int day = 1; day <= 7; day++) {
				for (int section = 1; section <= 5; section++) {
					ScheduleVO key = ScheduleVO.init(week, day, section);
					result.put(key, new ArrayList<>());
				}
			}
		}
		return result;
	}

	private Integer getMaxWeek(List<SchedulePO> pos) {
		Set<Integer> allWeek = new HashSet<>();
		for (SchedulePO po : pos) {
			allWeek.addAll(makeWeekList(po.getSTIMEZC()));
		}
		Integer maxWeek = 1;
		for (Integer week : allWeek) {
			if (week > maxWeek) {
				maxWeek = week;
			}
		}
		return maxWeek;
	}

	private Map<ScheduleVO, List<String>> getVOMap(List<SchedulePO> pos) {
		Map<ScheduleVO, List<String>> map = new HashMap<>();

		for (SchedulePO po : pos) {
			List<Integer> weekList = makeWeekList(po.getSTIMEZC());
			Integer day = getDay(po.getJCZ());
			Integer section = getSection(po.getJCZ());
			for (Integer week : weekList) {
				ScheduleVO vo = ScheduleVO.init(week, day, section);
				map.computeIfAbsent(vo, k -> new ArrayList<>());
				map.get(vo).add(po.getUSER_XH());
			}
		}
		return map;
	}

	private Integer getSection(String jcz) {
		char[] chars = jcz.toCharArray();
		if (chars.length >= 3) {
			return (int) chars[2] - '0';
		}
		return 0;
	}

	private Integer getDay(String jcz) {
		char[] chars = jcz.toCharArray();
		if (chars.length >= 2) {
			return (int) chars[1] - '0';
		}
		return 0;
	}

	private List<Integer> makeWeekList(String stimezc) {
		List<Integer> weekList = new ArrayList<>();
		if (stimezc == null) {
			return weekList;
		}
		String[] split = stimezc.split(",");
		for (String s : split) {
			String[] weekArray = s.split("-");
			if (weekArray.length == 1) {
				weekList.add(new Integer(weekArray[0]));
			} else if (weekArray.length == 2) {
				int min = new Integer(weekArray[0]);
				int max = new Integer(weekArray[1]);
				for (int i = min; i <= max; i++) {
					weekList.add(i);
				}
			}
		}
		//XXX 单双周问题
		return weekList;
	}

	private Map<String, String> getStudentMap(List<SchedulePO> pos) {
		Map<String, String> studentMap = new HashMap<>();
		for (SchedulePO po : pos) {
			studentMap.put(po.getUSER_XH(), po.getXM());
		}
		return studentMap;
	}
}
