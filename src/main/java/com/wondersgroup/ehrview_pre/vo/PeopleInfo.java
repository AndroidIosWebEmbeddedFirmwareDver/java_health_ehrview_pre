package com.wondersgroup.ehrview_pre.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 获取被调阅人基本信息的返回类
 * @author lrz
 *
 */
@XmlRootElement(name = "res")
@XmlAccessorType(XmlAccessType.FIELD)
public class PeopleInfo extends BaseResult{
	private PeopleBaseInfoVO patient;
	private List<MedicalServiceVO> medicalServices;
	private String pid;
	
	public PeopleBaseInfoVO getPatient() {
		return patient;
	}
	public void setPatient(PeopleBaseInfoVO patient) {
		this.patient = patient;
	}
	public List<MedicalServiceVO> getMedicalServices() {
		return medicalServices;
	}
	public void setMedicalServices(List<MedicalServiceVO> medicalServices) {
		this.medicalServices = medicalServices;
	}
	public String getPid() {
		return pid;
	}
	public void setPid(String pid) {
		this.pid = pid;
	}
	
}
