package com.wondersgroup.ehrview_pre.vo;


public class PeopleBaseInfoVO {
	private String name;//姓名
	private String gender;//性别
	private String birthday;//生日
	private String age;//年龄
	private String maritalStatus;//婚姻状况
	private String occu;//职业
	private String linkmanName; //联系人姓名
	private String linkmanRel;//联系人关系
	private String linkmanTel;//联系人电话

	
	public PeopleBaseInfoVO() {
		super();
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public String getGender() {
		return gender;
	}
	public void setGender(String gender) {
		this.gender = gender;
	}
	public String getBirthday() {
		return birthday;
	}
	public void setBirthday(String birthday) {
		this.birthday = birthday;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getMaritalStatus() {
		return maritalStatus;
	}
	public void setMaritalStatus(String maritalStatus) {
		this.maritalStatus = maritalStatus;
	}
	public String getOccu() {
		return occu;
	}
	public void setOccu(String occu) {
		this.occu = occu;
	}
	public String getLinkmanName() {
		return linkmanName;
	}
	public void setLinkmanName(String linkmanName) {
		this.linkmanName = linkmanName;
	}
	public String getLinkmanRel() {
		return linkmanRel;
	}
	public void setLinkmanRel(String linkmanRel) {
		this.linkmanRel = linkmanRel;
	}
	public String getLinkmanTel() {
		return linkmanTel;
	}
	public void setLinkmanTel(String linkmanTel) {
		this.linkmanTel = linkmanTel;
	}

	
}
