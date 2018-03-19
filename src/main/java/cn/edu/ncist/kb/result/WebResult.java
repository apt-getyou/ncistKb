package cn.edu.ncist.kb.result;

import cn.edu.ncist.kb.enums.ResponseStatusEnum;

import java.util.HashMap;

import com.google.gson.Gson;

/**
 * @author banhujiu
 * @date 2018/3/19 0019 16:51
 */
public class WebResult {
	private HashMap<String, String> data = new HashMap<>();
	private int status = ResponseStatusEnum.SUCCESS.getVal();
	private Gson gson = new Gson();

	public HashMap<String, String> getData() {
		return data;
	}

	public void setData(HashMap<String, String> data) {
		this.data = data;
	}

	public int getStatus() {
		return status;
	}

	public void setStatus(int status) {
		this.status = status;
	}

	public void addDataMap(String key, String value) {
		this.data.put(key, value);
	}

	public void addDataMap(String key, Object value) {
		this.data.put(key, gson.toJson(value));
	}
}
