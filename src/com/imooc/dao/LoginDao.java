package com.imooc.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.transaction.annotation.Transactional;

import com.imooc.bean.Login;
import com.imooc.db.DBAccess;

public class LoginDao {
	/**
	 * 根据输入的帐号密码判断登录成功与否
	 * @param login_id
	 * @param login_password
	 * @return
	 */
	@Transactional
	public List<Login> queryLogin(String login_id,String login_password){
		DBAccess dbAccess = new DBAccess();
		List<Login> loginList = new ArrayList<Login>();
		SqlSession sqlSession = null;
		try {
			Login login = new Login();
			login.setId(Integer.parseInt(login_id));//获取输入的帐号id
			login.setL_password(login_password);//获取输入的密码
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlSession执行SQL语句
			loginList = sqlSession.selectList("Login.queryLoginList", login);
		} catch (Exception e) { 
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return loginList;
	}
	
	/**
	 * 单条删除
	 */
	@Transactional
	public void deleteOne(int _parameter) {
		System.out.println("传入的参数需要删除的id:"+_parameter);
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			// 通过sqlSession执行SQL语句
			sqlSession = dbAccess.getSqlSession();
			Login login =new Login();
			login.setId(_parameter);
			sqlSession.delete("Login.deleteOne",login);
			sqlSession.commit();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	
}
