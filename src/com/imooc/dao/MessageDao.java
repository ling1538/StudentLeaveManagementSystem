package com.imooc.dao;

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.transaction.annotation.Transactional;

import com.imooc.bean.Login;
import com.imooc.bean.Message;
import com.imooc.db.DBAccess;

/**
 * 和message表相关的数据库操作
 */
public class MessageDao {
	
	
	/**
	 * 根据查询学生姓名或班级条件查询消息列表
	 */
	@Transactional//事务注解，需要在spring 配置文件中开启事务注解驱动
	public List<Message> queryMessageList(String m_name,String m_class) {
		DBAccess dbAccess = new DBAccess();
		List<Message> messageList = new ArrayList<Message>();
		SqlSession sqlSession = null;
		try {
			Message message = new Message();
			message.setM_name(m_name);
			message.setM_class(m_class);
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlSession执行SQL语句
			messageList = sqlSession.selectList("Message.queryMessageList", message);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return messageList;
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
			sqlSession.delete("Message.deleteOne", _parameter);
			sqlSession.commit();
			
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
	

	/**
	 * 按照学生id进行查找学生信息
	 * @param iD
	 * @return
	 */
	@Transactional
	public List<Message> querySingleMessage(String id) {
		DBAccess dbAccess = new DBAccess();
		List<Message> singleMessage = new ArrayList<Message>();
		SqlSession sqlSession = null;
		try {
			Message message = new Message();
			message.setId(id);
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlSession执行SQL语句
			singleMessage = sqlSession.selectList("Message.querySingleMessage", message);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return singleMessage;
	}
	/**
	 * 添加一条学生
	 * @param name
	 * @param valueOf
	 * @param sex
	 * @param remarks
	 * @param password
	 */
	@Transactional
	public void AddOne(String name, int myclass, String sex,
			String remarks, String password) {
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			Message message = new Message();
			message.setM_name(name);
			message.setM_teacherID(myclass);
			String myclass2;
			switch (myclass) {
			case 11:myclass2="高一1班";break;
			case 12:myclass2="高一2班";break;
			case 13:myclass2="高一3班";break;
			case 14:myclass2="高一4班";break;
			case 15:myclass2="高一5班";break;
			default:myclass2="未知";break;
			}
			message.setM_class(myclass2);
			message.setM_remarks(remarks);
			message.setM_sex(sex);
			
			Login login = new Login();
			login.setL_identity("学生");
			login.setL_password(password);
			
			
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlSession执行SQL语句,有外键约束，先插入登录表
			sqlSession.insert("Login.addOne", login);
			sqlSession.commit();
			
			System.out.println("插入数据---"+name+"+"+myclass+"+"+sex+"+"+remarks+"+"+password);
			//再插入新的信息
			sqlSession = dbAccess.getSqlSession();
			sqlSession.insert("Message.addOne", message);
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
