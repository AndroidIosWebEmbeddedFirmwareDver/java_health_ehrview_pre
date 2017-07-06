package com.wondersgroup.ehrview_pre.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="res")
@XmlAccessorType(XmlAccessType.FIELD)
public class HosMedicalInfoRes extends BaseResult{
	@XmlElementWrapper(name="hosMedicalInfos")
	@XmlElement(name="hosMedicalInfo")
	private List<HosMedicalInfoVo> hosMedicalInfos;
	private int totalPage = 0;
	public List<HosMedicalInfoVo> getHosMedicalInfos() {
		return hosMedicalInfos;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setHosMedicalInfos(List<HosMedicalInfoVo> hosMedicalInfos) {
		this.hosMedicalInfos = hosMedicalInfos;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	
}
