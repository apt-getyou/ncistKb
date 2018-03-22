package cn.edu.ncist.kb.enums;

/**
 * @author banhujiu
 * @date 2018/3/17 0017 21:10
 */
public enum DSZEnum {
	单周(1, "单周") {
		@Override
		public boolean check(Integer week) {
			return week % 2 == 1;
		}
	},
	双周(2, "双周") {
		@Override
		public boolean check(Integer week) {
			return week % 2 == 0;
		}
	},
	全周(0, "全周") {
		@Override
		public boolean check(Integer week) {
			return true;
		}
	};

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

	public abstract boolean check(Integer week);

	public static DSZEnum get(String DSZ) {
		if (DSZ == null || DSZ.equals("")) {
			return 全周;
		}
		Integer val;
		try {
			val = Integer.valueOf(DSZ);
		} catch (NumberFormatException e) {
			return 全周;
		}
		for (DSZEnum dszEnum : DSZEnum.values()) {
			if (val.equals(dszEnum.val)) {
				return dszEnum;
			}
		}
		return 全周;
	}
}
