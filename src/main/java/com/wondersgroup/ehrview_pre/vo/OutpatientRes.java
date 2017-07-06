package com.wondersgroup.ehrview_pre.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 摘要返回消息
 */
@XmlRootElement(name = "res")
@XmlAccessorType(XmlAccessType.FIELD)
public class OutpatientRes extends BaseResult {
	
	@XmlElementWrapper(name="labDetails")
	@XmlElement(name="labDetail")
	List<LabDetailVo> labDetail;//检验报告详情
	
	@XmlElementWrapper(name="examDetails")
	@XmlElement(name="examDetail")
	List<ExamDetailVo> examDetail;//手术、检查报告详情

	public List<LabDetailVo> getLabDetail() {
		return labDetail;
	}
	public void setLabDetail(List<LabDetailVo> labDetail) {
		this.labDetail = labDetail;
	}
	public List<ExamDetailVo> getExamDetail() {
		return examDetail;
	}
	public void setExamDetail(List<ExamDetailVo> examDetail) {
		this.examDetail = examDetail;
	}
	
	
}
