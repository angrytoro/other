package mybatis.test;

import java.io.IOException;
import java.io.Reader;

import junit.framework.Assert;
import junit.framework.TestCase;
import mybatis.test.model.User;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MainTest extends TestCase {
	public void setUp() {
	}

	public void testResultMap() {
		try {
			String resource = "MyBatisConfig.xml";
			Reader reader = Resources.getResourceAsReader(resource);
			Assert.assertNotNull(reader);
			SqlSessionFactory fac = new SqlSessionFactoryBuilder()
					.build(reader);
			long beginTime = System.currentTimeMillis();
			SqlSession session = fac.openSession();
			User user = (User) session
					.selectOne("mybatis.test.model.UserMapper.selectUser");
			Assert.assertNotNull(user);
			session.close();
			long endTime = System.currentTimeMillis();
			System.out.println("Time in millis:" + (endTime - beginTime)
					+ "\t User:" + user);

		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
