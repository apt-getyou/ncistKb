package cn.edu.ncist.kb.param;

import cn.edu.ncist.kb.bean.ScheduleBean;

/**
 * @author banhujiu
 * @date 2018/3/17 0017 21:47
 */
public class ScheduleParam extends BaseParam<ScheduleBean> {
	private String XN; //学年	如，“2009”表示2009-2010学年
	private String XQ_ID; //学期ID	0第一学期，1第二学期，2第三学期

	public String getXN() {
		return XN;
	}

	public void setXN(String XN) {
		this.XN = XN;
	}

	public String getXQ_ID() {
		return XQ_ID;
	}

	public void setXQ_ID(String XQ_ID) {
		this.XQ_ID = XQ_ID;
	}
}
