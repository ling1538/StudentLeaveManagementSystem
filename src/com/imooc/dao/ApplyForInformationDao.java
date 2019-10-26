package com.imooc.dao;

import java.util.ArrayList;
import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.springframework.transaction.annotation.Transactional;

import com.imooc.bean.ApplyForInformation;
import com.imooc.db.DBAccess;

public class ApplyForInformationDao {
	/**
	 * 保存学生申请的请假信息
	 * @param ID
	 * @param l_name
	 * @param l_class
	 * @param l_state
	 * @param l_phone
	 * @param l_time
	 * @param l_reason
	 * @return
	 */
	@Transactional
	public void saveMessage(int ID,String l_name,String l_class,String l_state,String l_phone,String l_startTime,String l_endTime,String l_reason) {
		DBAccess dbAccess1 = new DBAccess();
		SqlSession sqlSession = null;
		try {
			ApplyForInformation applyForInformation = new ApplyForInformation();
			applyForInformation.setID(ID);
			applyForInformation.setL_class(l_class);
			applyForInformation.setL_name(l_name);
			applyForInformation.setL_phone(l_phone);
			applyForInformation.setL_resone(l_reason);
			applyForInformation.setL_state(l_state);
			applyForInformation.setL_startTime(l_startTime);
			applyForInformation.setL_endTime(l_endTime);
			sqlSession = dbAccess1.getSqlSession();
			// 通过sqlSession执行SQL语句
			sqlSession.insert("ApplyForInformation.saveMessage", applyForInformation);
			sqlSession.commit();//提交事务，否则会显示成功更新一条消息，但是数据库实际没有插入数据
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	
	/**
	 * 查找学生的请假信息
	 * @param id
	 * @return
	 */
	@Transactional
	public List<ApplyForInformation> queryleaveMessageList(int id) {
		DBAccess dbAccess = new DBAccess();
		List<ApplyForInformation> queryleaveMessage = new ArrayList<ApplyForInformation>();
		SqlSession sqlSession = null;
		try {
			ApplyForInformation applyForInformation = new ApplyForInformation();
			applyForInformation.setID(id);
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlSession执行SQL语句
			queryleaveMessage = sqlSession.selectList("ApplyForInformation.queryleaveMessage", applyForInformation);
			sqlSession.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return queryleaveMessage;
	}
	
	/**
	 * 按照学生的班级遍历学生的请假信息
	 * @param l_class
	 * @return
	 */
	@Transactional
	public List<ApplyForInformation> queryleaveMessageForClassList(String l_class) {
		DBAccess dbAccess = new DBAccess();
		List<ApplyForInformation> queryleaveMessageForClassList = new ArrayList<ApplyForInformation>();
		SqlSession sqlSession = null;
		try {
			ApplyForInformation applyForInformation = new ApplyForInformation();
			applyForInformation.setL_class(l_class);
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlSession执行SQL语句
			queryleaveMessageForClassList = sqlSession.selectList("ApplyForInformation.queryleaveMessageForClass", applyForInformation);
			sqlSession.commit();
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
		return queryleaveMessageForClassList;
	}
	/**
	 * 批准一条信息
	 * @param number
	 */
	@Transactional
	public void approvalSingleLeaveMessage(int number){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			ApplyForInformation applyForInformation = new ApplyForInformation();
			applyForInformation.setL_number(number);
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlSession执行SQL语句
			sqlSession.update("ApplyForInformation.approvalSingleLeaveMessage", applyForInformation);
			sqlSession.commit();//提交事务，否则会显示成功更新一条消息，但是数据库实际没有插入数据
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	/**
	 * 拒绝一条信息
	 * @param number
	 */
	@Transactional
	public void refuseSingleLeaveMessage(int number){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			ApplyForInformation applyForInformation = new ApplyForInformation();
			applyForInformation.setL_number(number);
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlSession执行SQL语句
			sqlSession.update("ApplyForInformation.refuseSingleLeaveMessage", applyForInformation);
			sqlSession.commit();//提交事务，否则会显示成功更新一条消息，但是数据库实际没有插入数据
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	/**
	 * 批量通过
	 * @param numbers
	 */
	@Transactional
	public void BatchPass(List<Integer> numbers){
		
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		List<Integer> number = numbers;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlSession执行SQL语句
			sqlSession.update("ApplyForInformation.approvalBatchLeaveMessage", number);
			sqlSession.commit();//提交事务，否则会显示成功更新一条消息，但是数据库实际没有插入数据
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
	}
	
	/**
	 * 按ID删除一条请假信息
	 * @param number
	 */
	@Transactional
	public void deleteOneMessage(int _parameter){
		DBAccess dbAccess = new DBAccess();
		SqlSession sqlSession = null;
		try {
			sqlSession = dbAccess.getSqlSession();
			// 通过sqlSession执行SQL语句
			sqlSession.update("ApplyForInformation.deleteOne", _parameter);
			sqlSession.commit();//提交事务，否则会显示成功更新一条消息，但是数据库实际没有插入数据
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			if(sqlSession != null) {
				sqlSession.close();
			}
		}
	}
}
