package com.wondersgroup.ehrview_pre.vo;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;

@XmlAccessorType(XmlAccessType.FIELD)
public class LabInspectionVo {
	private String inspectionName;//检测指标代码
	private String inspectionCode;//检测指标代码
	private String result;//检测结果
	private String unit;//单位
	private String value;//参考值
	public String getInspectionName() {
		return inspectionName;
	}
	public void setInspectionName(String inspectionName) {
		this.inspectionName = inspectionName;
	}
	public String getInspectionCode() {
		return inspectionCode;
	}
	public void setInspectionCode(String inspectionCode) {
		this.inspectionCode = inspectionCode;
	}
	public String getResult() {
		return result;
	}
	public void setResult(String result) {
		this.result = result;
	}
	public String getUnit() {
		return unit;
	}
	public void setUnit(String unit) {
		this.unit = unit;
	}
	public String getValue() {
		return value;
	}
	public void setValue(String value) {
		this.value = value;
	}
	
}
