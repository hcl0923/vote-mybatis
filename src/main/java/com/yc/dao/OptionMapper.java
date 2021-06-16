package com.yc.dao;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yc.bean.Option;

public interface OptionMapper {
	public List<Option> findByTrem(Option t);
	public int addOptions(@Param("options")List<String> option,@Param("vid")String vid);
}
