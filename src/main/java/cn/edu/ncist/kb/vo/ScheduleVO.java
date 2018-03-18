package cn.edu.ncist.kb.vo;

/**
 * @author banhujiu
 * @date 2018/3/17 0017 22:18
 */
public class ScheduleVO {
	private Integer week;
	private Integer day;
	private Integer section;

	public Integer getWeek() {
		return week;
	}

	public void setWeek(Integer week) {
		this.week = week;
	}

	public Integer getDay() {
		return day;
	}

	public void setDay(Integer day) {
		this.day = day;
	}

	public Integer getSection() {
		return section;
	}

	public void setSection(Integer section) {
		this.section = section;
	}

	public static ScheduleVO init(Integer week, Integer day, Integer section) {
		ScheduleVO vo = new ScheduleVO();
		vo.week = week;
		vo.day = day;
		vo.section = section;
		return vo;
	}

	@Override
	public boolean equals(Object o) {
		if (this == o) return true;
		if (o == null || getClass() != o.getClass()) return false;

		ScheduleVO that = (ScheduleVO) o;

		if (week != null ? !week.equals(that.week) : that.week != null) return false;
		if (day != null ? !day.equals(that.day) : that.day != null) return false;
		if (section != null ? !section.equals(that.section) : that.section != null) return false;

		return true;
	}

	@Override
	public int hashCode() {
		int result = week != null ? week.hashCode() : 0;
		result = 31 * result + (day != null ? day.hashCode() : 0);
		result = 31 * result + (section != null ? section.hashCode() : 0);
		return result;
	}
}
