package com.wondersgroup.ehrview_pre.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="res")
@XmlAccessorType(XmlAccessType.FIELD)
public class ClinicalLabRes extends BaseResult{
	@XmlElementWrapper(name="clinicalLabs")
	@XmlElement(name="clinicalLab")
	List<ClinicalLabVo> ClinicalLabVos;
	int totalPage;
	public List<ClinicalLabVo> getClinicalLabVos() {
		return ClinicalLabVos;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setClinicalLabVos(List<ClinicalLabVo> clinicalLabVos) {
		ClinicalLabVos = clinicalLabVos;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	
}
