import java.util.Arrays;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.junit.Test;

import com.yc.bean.Vote;
import com.yc.dao.OptionMapper;
import com.yc.dao.VoteMapper;
import com.yc.util.DbUtil;
import com.yc.util.VoteUtil;

public class VoteDAOTest {
	DbUtil db=new DbUtil();
	@Test
	public void testAdd() throws Exception {
		SqlSession session=db.getSession();
		VoteMapper mapper=session.getMapper(VoteMapper.class);
		OptionMapper optionMapper=session.getMapper(OptionMapper.class);  
			Vote vote=new Vote();
			vote.setEndDate("2020-08-20");
			vote.setStartDate("2020-09-01");
			vote.setVtype(1);
			vote.setVname("开始三期项目");
			vote.setVid (VoteUtil.genVid());
			String []options =new String[]{"4月上旬","4月中旬","4月下旬","5月上旬"};
			List<String> ops =Arrays.asList(options);
			int i =mapper.add(vote);
			int j =optionMapper.addOptions(ops,vote.getVid());
			if(i>0 &&j>0) {
				session.commit();
			}
			db.closeSession();
			//dao.add(vote,options);
	}
}
