package com.wondersgroup.ehrview_pre.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class HosHomeVo {
	private String admissionType;//入院类型
	private String admissionWard;//入院病区
	private String admissionSituation;//入院情况
	private String dischargeWard;//出院病区
	private String dischargeMode;//出院方式
	private String hospitalDays;//住院天数
	private String insCode;//医疗机构代码
	private String serialNo;//就诊流水号
	
	public String getAdmissionType() {
		return admissionType;
	}
	public void setAdmissionType(String admissionType) {
		this.admissionType = admissionType;
	}
	public String getAdmissionWard() {
		return admissionWard;
	}
	public void setAdmissionWard(String admissionWard) {
		this.admissionWard = admissionWard;
	}
	public String getAdmissionSituation() {
		return admissionSituation;
	}
	public void setAdmissionSituation(String admissionSituation) {
		this.admissionSituation = admissionSituation;
	}
	public String getDischargeWard() {
		return dischargeWard;
	}
	public void setDischargeWard(String dischargeWard) {
		this.dischargeWard = dischargeWard;
	}
	public String getDischargeMode() {
		return dischargeMode;
	}
	public void setDischargeMode(String dischargeMode) {
		this.dischargeMode = dischargeMode;
	}
	public String getHospitalDays() {
		return hospitalDays;
	}
	public void setHospitalDays(String hospitalDays) {
		this.hospitalDays = hospitalDays;
	}
	public String getInsCode() {
		return insCode;
	}
	public void setInsCode(String insCode) {
		this.insCode = insCode;
	}
	public String getSerialNo() {
		return serialNo;
	}
	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}
	
}
