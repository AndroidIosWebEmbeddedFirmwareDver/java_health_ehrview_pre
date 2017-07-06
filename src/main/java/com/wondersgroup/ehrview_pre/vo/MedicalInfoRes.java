package com.wondersgroup.ehrview_pre.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="res")
@XmlAccessorType(XmlAccessType.FIELD)
public class MedicalInfoRes extends BaseResult{
	
	@XmlElementWrapper(name="MedicalInfos")
	@XmlElement(name="MedicalInfo")
	List<MedicalInfoVo> MedicalInfos;
	private int totalPage = 0;
	
	public int getTotalPage() {
		return totalPage;
	}

	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}

	public List<MedicalInfoVo> getMedicalInfos() {
		return MedicalInfos;
	}

	public void setMedicalInfos(List<MedicalInfoVo> medicalInfos) {
		MedicalInfos = medicalInfos;
	}
	
	
}
