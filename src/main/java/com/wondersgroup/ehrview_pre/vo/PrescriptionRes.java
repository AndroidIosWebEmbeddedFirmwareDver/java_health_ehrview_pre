package com.wondersgroup.ehrview_pre.vo;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name="res")
@XmlAccessorType(XmlAccessType.FIELD)
public class PrescriptionRes extends BaseResult{
	@XmlElementWrapper(name="Prescriptions")
	@XmlElement(name="Prescription")
	List<PrescriptionVo> Prescriptions;
	
	@XmlElementWrapper(name="PrescriptionRecords")
	@XmlElement(name="PrescriptionRecord")
	List<PrescriptionRecordVo> prescriptionRecord;
	int totalPage;
	
	public List<PrescriptionRecordVo> getPrescriptionRecord() {
		return prescriptionRecord;
	}
	public void setPrescriptionRecord(List<PrescriptionRecordVo> prescriptionRecord) {
		this.prescriptionRecord = prescriptionRecord;
	}
	public List<PrescriptionVo> getPrescriptions() {
		return Prescriptions;
	}
	public int getTotalPage() {
		return totalPage;
	}
	public void setPrescriptions(List<PrescriptionVo> prescriptions) {
		Prescriptions = prescriptions;
	}
	public void setTotalPage(int totalPage) {
		this.totalPage = totalPage;
	}
	
	
}
