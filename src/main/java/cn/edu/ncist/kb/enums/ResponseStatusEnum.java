package cn.edu.ncist.kb.enums;

/**
 * @author banhujiu
 * @date 2018/3/19 0019 18:18
 */
public enum ResponseStatusEnum {
	SUCCESS(1),
	EXCEPTION(-1),
	NOPERMISSION(-2),
	FAIL(-3),
	PARAMETER_ERROR(-4),;

	private int val;

	ResponseStatusEnum(int val) {
		this.val = val;
	}

	public int getVal() {
		return val;
	}
}
