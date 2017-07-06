package com.wondersgroup.ehrview_pre.vo;

public class MedicalInfoVo {
	private String treatmentDate;//就诊日期
	private String treatmentHospital;//就诊医院
	private String treatmentDepartment;//就诊科室
	private String treatmentType;//就诊类型
	private String diagnosticDesc;//诊断描述
	private String chiefComplaint;//主诉
	private String diagnosticInstructions;//诊断说明
	private String ICD10;//诊断ICD10
	private String diagnosisName;//诊断名称
	private String doctorName;//医生姓名
	private String medicalOrgId;//医疗机构代码
	private String serialNum;//就诊流水号
	
	public String getTreatmentDate() {
		return treatmentDate;
	}
	public void setTreatmentDate(String treatmentDate) {
		this.treatmentDate = treatmentDate;
	}
	public String getTreatmentHospital() {
		return treatmentHospital;
	}
	public void setTreatmentHospital(String treatmentHospital) {
		this.treatmentHospital = treatmentHospital;
	}
	public String getTreatmentDepartment() {
		return treatmentDepartment;
	}
	public void setTreatmentDepartment(String treatmentDepartment) {
		this.treatmentDepartment = treatmentDepartment;
	}
	public String getTreatmentType() {
		return treatmentType;
	}
	public void setTreatmentType(String treatmentType) {
		this.treatmentType = treatmentType;
	}
	public String getDiagnosticDesc() {
		return diagnosticDesc;
	}
	public void setDiagnosticDesc(String diagnosticDesc) {
		this.diagnosticDesc = diagnosticDesc;
	}
	public String getChiefComplaint() {
		return chiefComplaint;
	}
	public void setChiefComplaint(String chiefComplaint) {
		this.chiefComplaint = chiefComplaint;
	}
	public String getDiagnosticInstructions() {
		return diagnosticInstructions;
	}
	public void setDiagnosticInstructions(String diagnosticInstructions) {
		this.diagnosticInstructions = diagnosticInstructions;
	}
	public String getICD10() {
		return ICD10;
	}
	public void setICD10(String iCD10) {
		ICD10 = iCD10;
	}
	public String getDoctorName() {
		return doctorName;
	}
	public void setDoctorName(String doctorName) {
		this.doctorName = doctorName;
	}
	public String getDiagnosisName() {
		return diagnosisName;
	}
	public void setDiagnosisName(String diagnosisName) {
		this.diagnosisName = diagnosisName;
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
