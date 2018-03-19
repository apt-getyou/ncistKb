package cn.edu.ncist.kb.bean;

import cn.edu.ncist.kb.model.Schedule;

import java.util.List;

/**
 * @author banhujiu
 * @date 2018/3/17 0017 20:12
 */
public class ScheduleBean extends Schedule {
	private List<String> xhs;

	public List<String> getXhs() {
		return xhs;
	}

	public void setXhs(List<String> xhs) {
		this.xhs = xhs;
	}
}
