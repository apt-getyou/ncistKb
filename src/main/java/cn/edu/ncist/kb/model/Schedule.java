package cn.edu.ncist.kb.model;

/**
 * @author banhujiu
 * @date 2018/3/17 0017 20:02
 */
public class Schedule {
	private String XN; //学年	如，“2009”表示2009-2010学年
	private String XQ_ID; //学期ID	0第一学期，1第二学期，2第三学期
	private String USER_KCDM; //课程代码
	private String KCMC; //课程名称
	private String SKBJ; //上课班级
	private String ZJJS_GH; //教师工号
	private String ZJJS_XM; //教师姓名
	private String STIMEZC; //周次	如：1-5,8-18
	private String DSZ; //单双周	1单周，2双周，0全周
	private String JCINFO; //节次	如：1-2
	private String ROOM; //上课地点
	private String USER_XH; //学生学号
	private String XM; //学生姓名
	private String JCZ; //上课周	K12---1代表周一,2代表3-4节

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

	public String getUSER_KCDM() {
		return USER_KCDM;
	}

	public void setUSER_KCDM(String USER_KCDM) {
		this.USER_KCDM = USER_KCDM;
	}

	public String getKCMC() {
		return KCMC;
	}

	public void setKCMC(String KCMC) {
		this.KCMC = KCMC;
	}

	public String getSKBJ() {
		return SKBJ;
	}

	public void setSKBJ(String SKBJ) {
		this.SKBJ = SKBJ;
	}

	public String getZJJS_GH() {
		return ZJJS_GH;
	}

	public void setZJJS_GH(String ZJJS_GH) {
		this.ZJJS_GH = ZJJS_GH;
	}

	public String getZJJS_XM() {
		return ZJJS_XM;
	}

	public void setZJJS_XM(String ZJJS_XM) {
		this.ZJJS_XM = ZJJS_XM;
	}

	public String getSTIMEZC() {
		return STIMEZC;
	}

	public void setSTIMEZC(String STIMEZC) {
		this.STIMEZC = STIMEZC;
	}

	public String getDSZ() {
		return DSZ;
	}

	public void setDSZ(String DSZ) {
		this.DSZ = DSZ;
	}

	public String getJCINFO() {
		return JCINFO;
	}

	public void setJCINFO(String JCINFO) {
		this.JCINFO = JCINFO;
	}

	public String getROOM() {
		return ROOM;
	}

	public void setROOM(String ROOM) {
		this.ROOM = ROOM;
	}

	public String getUSER_XH() {
		return USER_XH;
	}

	public void setUSER_XH(String USER_XH) {
		this.USER_XH = USER_XH;
	}

	public String getXM() {
		return XM;
	}

	public void setXM(String XM) {
		this.XM = XM;
	}

	public String getJCZ() {
		return JCZ;
	}

	public void setJCZ(String JCZ) {
		this.JCZ = JCZ;
	}
}
