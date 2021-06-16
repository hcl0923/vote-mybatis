import java.io.IOException;
import java.util.List;

import org.junit.Test;

import com.yc.bean.User;
import com.yc.dao.UserMapper;
import com.yc.util.DbUtil;

public class UserDAOTest {
	DbUtil db=new DbUtil();
	@Test
	public void testFind() throws IOException {
		UserMapper mapper=db.getMapper(UserMapper.class);
		List<User> list=mapper.findByTrem(null);
		System.out.println(list);
	}
	
}
