package com.imooc.bean;

/**
 * 与消息表对应的实体类
 */
public class Message {
	/**
	 * 主键
	 */
	private String id;
	private String m_sex;//性别
	private int m_teacherID;//老师id
	private String m_name;//姓名
	private String m_class;//班级
	private String m_remarks;//特点
	public int getM_teacherID() {
		return m_teacherID;
	}
	public void setM_teacherID(int m_teacherID) {
		this.m_teacherID = m_teacherID;
	}
	public String getM_sex() {
		return m_sex;
	}
	public void setM_sex(String m_sex) {
		this.m_sex = m_sex;
	}
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getM_name() {
		return m_name;
	}
	public void setM_name(String m_name) {
		this.m_name = m_name;
	}
	public String getM_class() {
		return m_class;
	}
	public void setM_class(String m_class) {
		this.m_class = m_class;
	}
	public String getM_remarks() {
		return m_remarks;
	}
	public void setM_remarks(String m_remarks) {
		this.m_remarks = m_remarks;
	}
}
