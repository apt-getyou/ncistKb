package cn.edu.ncist.kb.service;

import cn.edu.ncist.kb.bean.ScheduleBean;

import java.util.List;

/**
 * @author banhujiu
 * @date 2018/3/17 0017 20:02
 */
public interface ScheduleService {
	List<List<List<String>>> getSchedule(List<String> xhs, ScheduleBean bean);

	List<String> getXhsFormExcel(List<String[]> listOb);
}
