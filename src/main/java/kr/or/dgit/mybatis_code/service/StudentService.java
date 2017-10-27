package kr.or.dgit.mybatis_code.service;

import java.util.List;

import org.apache.ibatis.session.SqlSession;

import kr.or.dgit.mybatis_code.dao.StudentDao;
import kr.or.dgit.mybatis_code.dto.Student;
import kr.or.dgit.mybatis_code.util.MyBatisSqlSessionFactory;

public class StudentService {
	public List<Student> selectAllStudent(){
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.getSqlsessionfactory().openSession();){
			StudentDao dao = sqlSession.getMapper(StudentDao.class);
			return dao.findAllstudents();
		}
		
		
	}
	
	public int createStudent(Student student) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			StudentDao dao = sqlSession.getMapper(StudentDao.class);
			int res = dao.insertStudent(student);
			sqlSession.commit(); //데이터베이스에 전송시켜 데이터를 저장할 수 있도록 한다.
			return res;
		}
	}
	
	public Student selectStudentByNo(int studId) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			return sqlSession.selectOne("kr.or.dgit.mybatis_code.dao.StudentDao.findStudentById", studId);
			
		}
	}
	
	public void deleteStudent(int studId) {
		try(SqlSession sqlSession = MyBatisSqlSessionFactory.openSession()){
			StudentDao dao = sqlSession.getMapper(StudentDao.class);
			int res = dao.deleteStudent(studId);
			sqlSession.commit(); //데이터베이스에 전송시켜 데이터를 삭할 수 있도록 한다.
		}
	}
}
