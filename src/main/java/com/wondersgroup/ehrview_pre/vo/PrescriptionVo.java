package com.wondersgroup.ehrview_pre.vo;

public class PrescriptionVo {
	private String drugName;//药品名称 drugName                            
	private String drugUse;//药品用法 drugUse                              
	private String grantDose;//发药量 grantDose                           
	private String frequencyUse;//用药频次 frequencyOfDrugUse                
	private String dosage;// 用药量 dosage        
	private String drugSpecification;// 药品规格
 
	public String getDrugSpecification() {
		return drugSpecification;
	}
	public void setDrugSpecification(String drugSpecification) {
		this.drugSpecification = drugSpecification;
	}
	public String getDrugName() {
		return drugName;
	}
	public void setDrugName(String drugName) {
		this.drugName = drugName;
	}
	public String getDrugUse() {
		return drugUse;
	}
	public void setDrugUse(String drugUse) {
		this.drugUse = drugUse;
	}
	public String getGrantDose() {
		return grantDose;
	}
	public void setGrantDose(String grantDose) {
		this.grantDose = grantDose;
	}
	public String getFrequencyUse() {
		return frequencyUse;
	}
	public void setFrequencyUse(String frequencyUse) {
		this.frequencyUse = frequencyUse;
	}
	public String getDosage() {
		return dosage;
	}
	public void setDosage(String dosage) {
		this.dosage = dosage;
	}
	
}
