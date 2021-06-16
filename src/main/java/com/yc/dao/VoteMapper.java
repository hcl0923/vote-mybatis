package com.yc.dao;

import java.util.List;

import com.yc.bean.Vote;
import com.yc.bean.VoteVO;

public interface VoteMapper {
	public int add(Vote t);
	/**
	 * 多表查询
	 * @param t
	 * @return
	 * @throws Exception
	 */
	public List<VoteVO> findByTrem(VoteVO t);
	/**
	 * 单表查询
	 */
	public List<Vote> finds(Vote t);
}
