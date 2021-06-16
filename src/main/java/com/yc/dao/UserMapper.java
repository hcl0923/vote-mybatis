package com.yc.dao;

import java.util.List;

import com.yc.bean.User;
/**
 * 用户映射接口
 * @author hp
 *
 */
public interface UserMapper {
	public int add(User t);
	public List<User> findByTrem(User t);
}
