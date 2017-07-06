package com.wondersgroup.ehrview_pre.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class ExamDetailVo {
	private String name;//姓名
	private String sex;//性别
	private String serialNum;//就诊流水号
	private String dept;//科室
	private String imageID;//影像号
	private String checkDate;//检查日期
	private String checkType;//检查类型
	private String checkName;//检查名称
	private String examSite;//检查部位
	private String image;//影像表现
	private String imageDiagnosis;//影像诊断 yxzd
	private String reportDoc;//报告医生
	private String reportDate;//报告日期
	private String audit;//审核医生
	private String auditDate;//审核日期
	private String checkId;//检查号
	
	
	public String getSerialNum() {
		return serialNum;
	}
	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}
	public String getImageDiagnosis() {
		return imageDiagnosis;
	}
	public void setImageDiagnosis(String imageDiagnosis) {
		this.imageDiagnosis = imageDiagnosis;
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
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getImageID() {
		return imageID;
	}
	public void setImageID(String imageID) {
		this.imageID = imageID;
	}
	public String getCheckDate() {
		return checkDate;
	}
	public void setCheckDate(String checkDate) {
		this.checkDate = checkDate;
	}
	public String getCheckType() {
		return checkType;
	}
	public void setCheckType(String checkType) {
		this.checkType = checkType;
	}
	public String getCheckName() {
		return checkName;
	}
	public void setCheckName(String checkName) {
		this.checkName = checkName;
	}
	public String getExamSite() {
		return examSite;
	}
	public void setExamSite(String examSite) {
		this.examSite = examSite;
	}
	public String getImage() {
		return image;
	}
	public void setImage(String image) {
		this.image = image;
	}
	public String getReportDoc() {
		return reportDoc;
	}
	public void setReportDoc(String reportDoc) {
		this.reportDoc = reportDoc;
	}
	public String getReportDate() {
		return reportDate;
	}
	public void setReportDate(String reportDate) {
		this.reportDate = reportDate;
	}
	public String getAudit() {
		return audit;
	}
	public void setAudit(String audit) {
		this.audit = audit;
	}
	public String getAuditDate() {
		return auditDate;
	}
	public void setAuditDate(String auditDate) {
		this.auditDate = auditDate;
	}
	public String getCheckId() {
		return checkId;
	}
	public void setCheckId(String checkId) {
		this.checkId = checkId;
	}

}
