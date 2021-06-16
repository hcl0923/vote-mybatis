package com.yc.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

/**
 * 数据库操作的工具类
 * @author hp
 *
 */
public class DbUtil {
	static SqlSession session;
	public SqlSessionFactory getSqlSessionFactory() throws IOException {
		String config = "mybatis-config.xml";
		InputStream inputStream = Resources.getResourceAsStream(config);
		//1.获取sqlSessionFactory对象
		SqlSessionFactory factory = new SqlSessionFactoryBuilder().build(inputStream);
		return factory;
	}
	public SqlSession getSession(boolean autoCommit) throws IOException {
		SqlSessionFactory factory=getSqlSessionFactory();
		session=factory.openSession(autoCommit);
		return session;
	}
	public SqlSession getSession() throws IOException {
		SqlSessionFactory factory=getSqlSessionFactory();
		session=factory.openSession();
		return session;
	}
	/**
	 * 获取接口代理对象
	 * @param <T>
	 * @param c
	 * @return
	 * @throws IOException
	 */
	public <T> T getMapper(Class<T> c) throws IOException {
		getSession();
		T t=session.getMapper(c);
		return t;
	}
	/**
	 * 关闭会话
	 */
	public void closeSession() {
		if(null!=session) {
			session.close();
		}
	}
	public <T> T getMapper(Class<T> c, boolean autoCommit) throws IOException {
		session=getSession(autoCommit);
		T t=session.getMapper(c);
		return t;
	}
}
