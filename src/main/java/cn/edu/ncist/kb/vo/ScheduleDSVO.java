package cn.edu.ncist.kb.vo;

/**
 * @author banhujiu
 * @date 2018/3/18 0018 13:20
 */
public class ScheduleDSVO {
	private Integer day;
	private Integer section;

	public ScheduleDSVO(Integer day, Integer section) {
		this.day = day;
		this.section = section;
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
}
