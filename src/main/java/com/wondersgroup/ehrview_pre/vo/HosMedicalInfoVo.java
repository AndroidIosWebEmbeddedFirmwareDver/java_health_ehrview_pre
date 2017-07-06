package com.wondersgroup.ehrview_pre.vo;

public class HosMedicalInfoVo {
	private String admissionDate;//入院日期
	private String hospitalName;//医院名称
	private String admissionDepartment;//入院科室
	private String diagosisName;//诊断名称
	private String dischargeDate;//出院日期
	private String medicalOrgId;//医疗机构代码
	private String serialNum;//就诊流水号
	
	public String getAdmissionDate() {
		return admissionDate;
	}
	public void setAdmissionDate(String admissionDate) {
		this.admissionDate = admissionDate;
	}
	public String getHospitalName() {
		return hospitalName;
	}
	public void setHospitalName(String hospitalName) {
		this.hospitalName = hospitalName;
	}
	public String getAdmissionDepartment() {
		return admissionDepartment;
	}
	public void setAdmissionDepartment(String admissionDepartment) {
		this.admissionDepartment = admissionDepartment;
	}
	public String getDiagosisName() {
		return diagosisName;
	}
	public void setDiagosisName(String diagosisName) {
		this.diagosisName = diagosisName;
	}
	public String getDischargeDate() {
		return dischargeDate;
	}
	public void setDischargeDate(String dischargeDate) {
		this.dischargeDate = dischargeDate;
	}
	public String getMedicalOrgId() {
		return medicalOrgId;
	}
	public String getSerialNum() {
		return serialNum;
	}
	public void setMedicalOrgId(String medicalOrgId) {
		this.medicalOrgId = medicalOrgId;
	}
	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}

	
}
