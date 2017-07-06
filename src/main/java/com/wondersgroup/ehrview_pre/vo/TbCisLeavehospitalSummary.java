package com.wondersgroup.ehrview_pre.vo;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * TbCisLeavehospitalSummary entity. @author MyEclipse Persistence Tools
 */

public class TbCisLeavehospitalSummary implements java.io.Serializable {

	// Fields

	private TbCisLeavehospitalSummaryId id;//联合主键
	private String department;//科室
	private String departmentName;//科室名称
	private String bedNo;//床号
	private String name;//姓名
	private String sex;//性别
	private String age;//年龄
	private String admissionTime;//入院时间
	private String dischargeTime;//出院时间
	private String hospitalDay;//住院天数
	private String chiefDoctor;//主治医师姓名
	private String hospitalDoctor;//住院医师
	private String clinicDiagnosis;//门诊诊断
	private String admissionDiagnosis;//入院诊断
	private String dischargeDiagnosis;//出院诊断
	private String admissionSign;//入院体征
	private String inspectConsultation;//检查会诊
	private String treatmentProcess;//诊疗过程
	private String complication;//合并症
	private String dischargeStatus;//出院情况
	private String dischargeOrder;//出院医嘱
	private String treatmentOutcome;//治疗结果

	// Constructors

	/** default constructor */
	public TbCisLeavehospitalSummary() {
	}

	/** minimal constructor */
	public TbCisLeavehospitalSummary(TbCisLeavehospitalSummaryId id) {
		this.id = id;
	}

	public TbCisLeavehospitalSummary(TbCisLeavehospitalSummaryId id,
			String department, String departmentName, String bedNo,
			String name, String sex, String age, String admissionTime,
			String dischargeTime, String hospitalDay, String chiefDoctor,
			String hospitalDoctor, String clinicDiagnosis,
			String admissionDiagnosis, String dischargeDiagnosis,
			String admissionSign, String inspectConsultation,
			String treatmentProcess, String complication,
			String dischargeStatus, String dischargeOrder,
			String treatmentOutcome) {
		super();
		this.id = id;
		this.department = department;
		this.departmentName = departmentName;
		this.bedNo = bedNo;
		this.name = name;
		this.sex = sex;
		this.age = age;
		this.admissionTime = admissionTime;
		this.dischargeTime = dischargeTime;
		this.hospitalDay = hospitalDay;
		this.chiefDoctor = chiefDoctor;
		this.hospitalDoctor = hospitalDoctor;
		this.clinicDiagnosis = clinicDiagnosis;
		this.admissionDiagnosis = admissionDiagnosis;
		this.dischargeDiagnosis = dischargeDiagnosis;
		this.admissionSign = admissionSign;
		this.inspectConsultation = inspectConsultation;
		this.treatmentProcess = treatmentProcess;
		this.complication = complication;
		this.dischargeStatus = dischargeStatus;
		this.dischargeOrder = dischargeOrder;
		this.treatmentOutcome = treatmentOutcome;
	}

	/** full constructor */
	
	// Property accessors
	
	public TbCisLeavehospitalSummaryId getId() {
		return id;
	}

	public String getChiefDoctor() {
		return chiefDoctor;
	}

	public void setChiefDoctor(String chiefDoctor) {
		this.chiefDoctor = chiefDoctor;
	}

	public String getHospitalDoctor() {
		return hospitalDoctor;
	}

	public void setHospitalDoctor(String hospitalDoctor) {
		this.hospitalDoctor = hospitalDoctor;
	}

	public void setId(TbCisLeavehospitalSummaryId id) {
		this.id = id;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	public String getDepartmentName() {
		return departmentName;
	}

	public void setDepartmentName(String departmentName) {
		this.departmentName = departmentName;
	}

	public String getBedNo() {
		return bedNo;
	}

	public void setBedNo(String bedNo) {
		this.bedNo = bedNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getAge() {
		return age;
	}

	public void setAge(String age) {
		this.age = age;
	}

	public String getAdmissionTime() {
		return admissionTime;
	}

	public void setAdmissionTime(String admissionTime) {
		this.admissionTime = admissionTime;
	}

	public String getDischargeTime() {
		return dischargeTime;
	}

	public void setDischargeTime(String dischargeTime) {
		this.dischargeTime = dischargeTime;
	}

	public String getHospitalDay() {
		return hospitalDay;
	}

	public void setHospitalDay(String hospitalDay) {
		this.hospitalDay = hospitalDay;
	}

	public String getClinicDiagnosis() {
		return clinicDiagnosis;
	}

	public void setClinicDiagnosis(String clinicDiagnosis) {
		this.clinicDiagnosis = clinicDiagnosis;
	}

	public String getAdmissionDiagnosis() {
		return admissionDiagnosis;
	}

	public void setAdmissionDiagnosis(String admissionDiagnosis) {
		this.admissionDiagnosis = admissionDiagnosis;
	}

	public String getDischargeDiagnosis() {
		return dischargeDiagnosis;
	}

	public void setDischargeDiagnosis(String dischargeDiagnosis) {
		this.dischargeDiagnosis = dischargeDiagnosis;
	}

	public String getAdmissionSign() {
		return admissionSign;
	}

	public void setAdmissionSign(String admissionSign) {
		this.admissionSign = admissionSign;
	}

	public String getInspectConsultation() {
		return inspectConsultation;
	}

	public void setInspectConsultation(String inspectConsultation) {
		this.inspectConsultation = inspectConsultation;
	}

	public String getTreatmentProcess() {
		return treatmentProcess;
	}

	public void setTreatmentProcess(String treatmentProcess) {
		this.treatmentProcess = treatmentProcess;
	}

	public String getComplication() {
		return complication;
	}

	public void setComplication(String complication) {
		this.complication = complication;
	}

	public String getDischargeStatus() {
		return dischargeStatus;
	}

	public void setDischargeStatus(String dischargeStatus) {
		this.dischargeStatus = dischargeStatus;
	}

	public String getDischargeOrder() {
		return dischargeOrder;
	}

	public void setDischargeOrder(String dischargeOrder) {
		this.dischargeOrder = dischargeOrder;
	}

	public String getTreatmentOutcome() {
		return treatmentOutcome;
	}

	public void setTreatmentOutcome(String treatmentOutcome) {
		this.treatmentOutcome = treatmentOutcome;
	}

}