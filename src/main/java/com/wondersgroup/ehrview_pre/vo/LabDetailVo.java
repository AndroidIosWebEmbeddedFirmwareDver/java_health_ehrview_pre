package com.wondersgroup.ehrview_pre.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
@XmlAccessorType(XmlAccessType.FIELD)
public class LabDetailVo {
	private String testNo;//检测编号 
	private String name;//姓名         
	private char sex;//性别          
	private String age;//年龄          
	private String dept;//科室       
	private String area;//病区           
	private String bedNo;//病床            
	private String specimen;//标本名称   
	private String inspectionDate;//送检日期    
	private String sampleTime;//采样时间    
	private String applyDoc;//申请医生    
	private String applyDate;//申请日期    
	private String printDate;//打印日期      
	private String audit;//审核医生    
	
	@XmlElementWrapper(name="inspections")
	@XmlElement(name="inspection")
	private List<LabInspectionVo> ins;//检测详情
	
	public String getTestNo() {
		return testNo;
	}
	public void setTestNo(String testNo) {
		this.testNo = testNo;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public char getSex() {
		return sex;
	}
	public void setSex(char sex) {
		this.sex = sex;
	}
	public String getAge() {
		return age;
	}
	public void setAge(String age) {
		this.age = age;
	}
	public String getDept() {
		return dept;
	}
	public void setDept(String dept) {
		this.dept = dept;
	}
	public String getArea() {
		return area;
	}
	public void setArea(String area) {
		this.area = area;
	}
	public String getBedNo() {
		return bedNo;
	}
	public void setBedNo(String bedNo) {
		this.bedNo = bedNo;
	}
	public String getSpecimen() {
		return specimen;
	}
	public void setSpecimen(String specimen) {
		this.specimen = specimen;
	}
	public String getInspectionDate() {
		return inspectionDate;
	}
	public void setInspectionDate(String inspectionDate) {
		this.inspectionDate = inspectionDate;
	}
	public String getSampleTime() {
		return sampleTime;
	}
	public void setSampleTime(String sampleTime) {
		this.sampleTime = sampleTime;
	}
	public String getApplyDoc() {
		return applyDoc;
	}
	public void setApplyDoc(String applyDoc) {
		this.applyDoc = applyDoc;
	}
	public String getApplyDate() {
		return applyDate;
	}
	public void setApplyDate(String applyDate) {
		this.applyDate = applyDate;
	}
	public String getPrintDate() {
		return printDate;
	}
	public void setPrintDate(String printDate) {
		this.printDate = printDate;
	}
	public String getAudit() {
		return audit;
	}
	public void setAudit(String audit) {
		this.audit = audit;
	}
	public List<LabInspectionVo> getIns() {
		return ins;
	}
	public void setIns(List<LabInspectionVo> ins) {
		this.ins = ins;
	}
	
}
