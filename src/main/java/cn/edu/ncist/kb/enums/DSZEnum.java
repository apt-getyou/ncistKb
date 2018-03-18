package cn.edu.ncist.kb.enums;

/**
 * @author banhujiu
 * @date 2018/3/17 0017 21:10
 */
public enum DSZEnum {
	单周(1, "单周"),
	双周(2, "双周"),
	全周(0, "全周");

	private int val;
	private String msg;

	DSZEnum(int val, String msg) {
		this.val = val;
		this.msg = msg;
	}

	public int getVal() {
		return val;
	}

	public String getMsg() {
		return msg;
	}
}
