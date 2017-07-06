package com.wondersgroup.ehrview_pre.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class PrescriptionRecordVo {
	private String prescriptionTypes;//处方大类：治疗单，01:西药处方笺(含中成药)02:中药饮片处方笺03:检查申请单04:检验申请单05:手术申请单
	private String prescriptionType;//处方类型：01=普通处方，02=急诊处方，03=儿科处方，04=麻醉药品和第一类精神药品处方，05=第二类精神药品处方 ，99=无法归类处方 ,处方类型为01必须填写
	private String prescriptionAmount;//处方金额
	private String orgName; //医疗机构代码
	private String docName;//医生姓名
	private String patientName;//患者姓名
	private String Date;//开方日期
	private String prescriptionId;//处方id
	private String prescribeDept;//开方科室
	private String medicalDept;//就诊科室名称
	
	public String getPrescribeDept() {
		return prescribeDept;
	}
	public void setPrescribeDept(String prescribeDept) {
		this.prescribeDept = prescribeDept;
	}
	public String getMedicalDept() {
		return medicalDept;
	}
	public void setMedicalDept(String medicalDept) {
		this.medicalDept = medicalDept;
	}
	public String getOrgName() {
		return orgName;
	}
	public void setOrgName(String orgName) {
		this.orgName = orgName;
	}
	public String getPrescriptionTypes() {
		return prescriptionTypes;
	}
	public void setPrescriptionTypes(String prescriptionTypes) {
		this.prescriptionTypes = prescriptionTypes;
	}
	public String getPrescriptionType() {
		return prescriptionType;
	}
	public void setPrescriptionType(String prescriptionType) {
		this.prescriptionType = prescriptionType;
	}
	public String getPrescriptionAmount() {
		return prescriptionAmount;
	}
	public void setPrescriptionAmount(String prescriptionAmount) {
		this.prescriptionAmount = prescriptionAmount;
	}
	public String getDocName() {
		return docName;
	}
	public void setDocName(String docName) {
		this.docName = docName;
	}
	public String getPatientName() {
		return patientName;
	}
	public void setPatientName(String patientName) {
		this.patientName = patientName;
	}
	public String getDate() {
		return Date;
	}
	public void setDate(String date) {
		Date = date;
	}
	public String getPrescriptionId() {
		return prescriptionId;
	}
	public void setPrescriptionId(String prescriptionId) {
		this.prescriptionId = prescriptionId;
	}

	
}
