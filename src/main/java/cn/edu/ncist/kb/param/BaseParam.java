package cn.edu.ncist.kb.param;

import org.springframework.beans.BeanUtils;

/**
 * @author banhujiu
 * @date 2018/3/19 0019 14:46
 */
public class BaseParam<T> {
	public T initBean(T t) {
		BeanUtils.copyProperties(this, t);
		return t;
	}
}
