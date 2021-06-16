package com.yc.biz;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import org.apache.ibatis.session.SqlSession;

import com.yc.bean.Option;
import com.yc.bean.User;
import com.yc.bean.Vote;
import com.yc.dao.OptionMapper;
import com.yc.dao.VoteMapper;
import com.yc.util.DbUtil;
import com.yc.util.VoteUtil;

public class VoteBiz {
	DbUtil db=new DbUtil();
	/**
	 * 添加投票信息
	 * @param vote
	 * @param option
	 * @return
	 * @throws Exception
	 */
	public int add(Vote vote,String[] options)throws Exception {
		//未传入选项
		if(null==options||options.length<=0) {
			return 0;
		}
		//添加vid
		vote.setVid(VoteUtil.genVid());
		SqlSession session=db.getSession();
		VoteMapper mapper=session.getMapper(VoteMapper.class);
		OptionMapper optionMapper=session.getMapper(OptionMapper.class);  
		List<String> ops =Arrays.asList(options);
		int i =mapper.add(vote);
		int j =optionMapper.addOptions(ops,vote.getVid());
		if(i>0 &&j>0) {
			System.out.println("adadad");
			session.commit();
			return 1;
		}
		db.closeSession();
		return 0;
	}
	/**
	 * 首页显示的主题信息  主题名称  主题编号，主题类型  开始时间  结束时间  参与用户数  选项数
	 * 存在一个map中多个主题就是一个list集合
	 * @return
	 * @throws Exception
	 */
	public List<Map<String,Object>> findAll()throws Exception{
//		List<Map<String,Object>> votes=new ArrayList<Map<String,Object>>();
//		//查看所有的主题信息
//		List<Vote> list=dao.findByTrem(new Vote());
//		//循环
//		for(Vote v:list) {
//			Map<String,Object> map=findByVid(v.getVid());
//			map.put("vid",v.getVid());
//			map.put("vname",v.getVname());
//			map.put("vtype",v.getVtype());
//			map.put("endDate",v.getEndDate());
//			map.put("startDate",v.getStartDate());
//			String str=VoteUtil.voteStatus(v.getStartDate(), v.getEndDate());//主题的状态
//			map.put("status",str);
//			votes.add(map);
//		}
//		return votes;//list即各个vote  map对应vote的中的各个属性
		return null;
	}
	/**
	 * 根据主题编号查看选项信息，将所需数据封装到Map中
	 * @param vid
	 * @return
	 * @throws Exception
	 */
	public Map<String,Object> findByVid(String vid)throws Exception{
//		Option op=new Option();
//		op.setVid(vid);
//		List<Option> list=optionDAO.findByTrem(op);
//		
//		if(null==list||list.size()<=0) {
//			return null;
//		}
//		Map<String,Object> map=new HashMap<String, Object>();//list里的属性名和值转为map键值对
//		map.put("options",list.size());//选项个数
//		int count=0;
//		StringBuffer sb=new StringBuffer();
//		for(Option o:list) {
//			if(null==o.getUsid()||"".equals(o.getUsid())) {
//				continue;
//			}
//			sb.append(o.getUsid());//字符串中的拼接1,2,1,2,3,4,5,
//			count+=o.getViews();//总票数
//		}
//		//防止出现空的
//		if(null==sb.toString()||"".equals(sb.toString())) {
//			map.put("count",count);//总票数
//			map.put("users",0);
//			return map;
//		}
//		//字符串分割
//		String []infos=sb.toString().split(",");
//		Set<String> set=new HashSet<String>();
//		if(null!=infos&&infos.length>=0) {
//			for(String info:infos) {
//				//不为空的字符串添加到set集合中
//				if(null!=info&&!"".equals(info)) {
//					set.add(info);
//				}
//			}
//		}
//		//相同用户可以投多票，但是只作为一个有效用户
//		map.put("count",count);//总票数
//		map.put("users",set.size());
//		
//		return map;
		return null;
	}
	public Vote findByTrem(Vote t) throws Exception {
//		List<Vote> list=dao.findByTrem(t);
//		if(null!=list&&list.size()>0) {
//			return list.get(0);
//		}
		return null;
	}
}
