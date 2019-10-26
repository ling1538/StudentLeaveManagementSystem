package com.imooc.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.transaction.annotation.Transactional;

import com.imooc.bean.Teacher;
import com.imooc.db.DBAccess;

public class TeacherDao {
	/**
	 * 按照登录的ID获取登录的老师的信息
	 * @param id
	 * @return
	 */
	@Transactional
	public List<Teacher> queryTeacherMessageList(int id) {
		DBAccess dbAccess = new DBAccess();
		List<Teacher> queryTeacherMessage = new ArrayList<Teacher>();
		SqlSession sqlSession = null;
		try {
			Teacher teacher = new Teacher();
			teacher.setID(id);
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlSession执行SQL语句
			queryTeacherMessage = sqlSession.selectList("Teacher.queryTeacherMessage", teacher);
			sqlSession.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return queryTeacherMessage;
		
	}
}
