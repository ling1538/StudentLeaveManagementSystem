package com.imooc.service;

import java.util.ArrayList;
import java.util.List;

import com.imooc.bean.Login;
import com.imooc.dao.ApplyForInformationDao;
import com.imooc.dao.LoginDao;
import com.imooc.dao.MessageDao;

/**
 * 维护相关的业务功能
 */
public class MaintainService {
	/**
	 * 单条删除学生信息
	 */
	public void deleteOne(String id) {
		if(id != null && !"".equals(id.trim())) {
			int id1 = Integer.valueOf(id);
			//先删除信息表里面该生的信息
			ApplyForInformationDao applyForInformationDao = new ApplyForInformationDao();
			applyForInformationDao.deleteOneMessage(id1);
			//在删除该生的信息,最后删除登录表里面该生的信息
			MessageDao messageDao = new MessageDao();
			messageDao.deleteOne(id1);
		}else{
			System.out.println("删除目标ID出错！！！");
		}
	}
	
	
	/**
	 * 批量通过
	 * @param numbers 复选框选中 的id
	 */
	public void BatchPass(String[] numbers) {
		
		ApplyForInformationDao applyForInformationDao = new ApplyForInformationDao();
		List<Integer> numbersList = new ArrayList<Integer>();
		for(String id : numbers) {
			numbersList.add(Integer.valueOf(id));
		}
		applyForInformationDao.BatchPass(numbersList);
	}
	
	/**
	 * 添加一条信息
	 * @param name
	 * @param myclass
	 * @param sex
	 * @param remarks
	 * @param password
	 */
	public void AddOne(String name,String myclass,String sex,String remarks,String password) {
		MessageDao messageDao = new MessageDao();
		int myclass2 = Integer.valueOf(myclass);
		messageDao.AddOne(name,myclass2,sex,remarks,password);
	}
}
