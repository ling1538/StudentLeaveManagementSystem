package com.imooc.service;

import java.util.List;

import com.imooc.bean.ApplyForInformation;
import com.imooc.bean.Login;
import com.imooc.bean.Message;
import com.imooc.bean.Teacher;
import com.imooc.dao.ApplyForInformationDao;
import com.imooc.dao.LoginDao;
import com.imooc.dao.MessageDao;
import com.imooc.dao.TeacherDao;



public class QueryService {
	/**
	 * 根据帐号密码进行查询
	 * @param login_id
	 * @param login_password
	 * @return
	 */
	public List<Login> queryLogin(String login_id,String login_password){
		LoginDao loginDao = new LoginDao();
		return loginDao.queryLogin(login_id, login_password);
	}
	
	/**
	 * 根据学生姓名和班级进行查找列表
	 * @param m_name
	 * @param m_class
	 * @return 学生信息
	 */
	public List<Message> queryMessageList(String m_name,String m_class) {
		MessageDao messageDao = new MessageDao();
		return messageDao.queryMessageList(m_name, m_class);
	}
	
	/**
	 * 根据学生ID号进行查找列表
	 * @param ID
	 * @return 学生信息
	 */
	public List<Message> querySingleMessage(String id) {
		MessageDao messageDao = new MessageDao();
		return messageDao.querySingleMessage(id);
	}
	
	/**
	 * 保存学生请假的信息
	 * @param ID
	 * @param l_name
	 * @param l_class
	 * @param l_state
	 * @param l_phone
	 * @param l_time
	 * @param l_reason
	 */
	public void saveMessage(String id,String l_name,String l_class,String l_state,String l_phone,String l_startTime,String l_endTime,String l_reason){
		ApplyForInformationDao applyForInformationDao =new ApplyForInformationDao();
		int ID =Integer.parseInt(id);
		applyForInformationDao.saveMessage(ID, l_name, l_class, l_state, l_phone, l_startTime,l_endTime, l_reason);
	}
	
	/**
	 * 查找学生请假的信息列表
	 * @param id
	 * @return
	 */
	public List<ApplyForInformation> queryleaveMessageList(String id) {
		ApplyForInformationDao applyForInformationDao = new ApplyForInformationDao();
		int ID1 =Integer.parseInt(id);
		return applyForInformationDao.queryleaveMessageList(ID1);
	}
	
	/**
	 * 根据登录教师的ID来获取教师的信息
	 * @param id
	 * @return
	 */
	public List<Teacher> queryTeacherMessage(String id) {
		TeacherDao teacherDao = new TeacherDao();
		int ID2 =Integer.parseInt(id);
		return teacherDao.queryTeacherMessageList(ID2);
	}
	
	/**
	 * 按照学生的班级遍历学生的请假信息
	 * @param l_class
	 * @return
	 */
	public List<ApplyForInformation> queryleaveMessageForClassList(String l_class) {
		ApplyForInformationDao applyForInformationDao = new ApplyForInformationDao();
		return applyForInformationDao.queryleaveMessageForClassList(l_class);
	}
	/**
	 * 批准一条信息
	 * @param number
	 */
	public void approvalSingleLeaveMessage(String num){
		ApplyForInformationDao applyForInformationDao = new ApplyForInformationDao();
		int number = Integer.parseInt(num);
		applyForInformationDao.approvalSingleLeaveMessage(number);
	}
	
	/**
	 * 拒绝一条信息
	 * @param number
	 */
	public void refuseSingleLeaveMessage(String num){
		ApplyForInformationDao applyForInformationDao = new ApplyForInformationDao();
		int number = Integer.parseInt(num);
		applyForInformationDao.refuseSingleLeaveMessage(number);
	}
	
}
