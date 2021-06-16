package com.yc.biz;

import java.util.List;

import com.yc.bean.User;
import com.yc.dao.UserMapper;
import com.yc.util.DbUtil;

public class UserBiz {
	DbUtil db=new DbUtil();
	/**
	 * 用户登录
	 * @param user
	 * @return
	 * @throws Exception
	 */
	public User login(User user)throws Exception{
		UserMapper mapper=db.getMapper(UserMapper.class);
		List<User> list=mapper.findByTrem(user);
		db.closeSession();
		if(null!=list&&list.size()>0) {
			return list.get(0);
		}
		return null;
	}
	public int add(User user)throws Exception{
		UserMapper mapper=db.getMapper(UserMapper.class,true);
		int i=mapper.add(user);
		db.closeSession();
		return i;
	}
}
