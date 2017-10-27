package kr.or.dgit.mybatis_code;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.Test;

import kr.or.dgit.mybatis_code.dto.Student;
import kr.or.dgit.mybatis_code.util.MyBatisSqlSessionFactory;

public class MyBatisSqlSessionTest {
	private static SqlSessionFactory factory;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
		System.out.println("setupBeforClass()");
		factory = MyBatisSqlSessionFactory.getSqlsessionfactory();
	}
	
	@AfterClass
	public static void tearDownAfterClass() throws Exception {
		System.out.println("tearDownAfterClass()");
		factory = null;
	}

	@Test
	public void testSqlSessionFactory() {
		Assert.assertNotNull(factory);
	}
	
/*	@Test
	public void testSqlSession() {
		SqlSession ss = factory.openSession();
		List<Student> lists = ss.selectList("select * from student");
		Assert.assertNotNull(lists);
	}*/
}
