package cn.edu.ncist.kb.dao;

import cn.edu.ncist.kb.po.SchedulePO;

import java.util.Collection;
import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

/**
 * @author banhujiu
 * @date 2018/3/17 0017 20:00
 */
@Mapper
public interface ScheduleDao {
	List<SchedulePO> queryListByXHs(@Param("xhs") Collection<String> xhs);
}
