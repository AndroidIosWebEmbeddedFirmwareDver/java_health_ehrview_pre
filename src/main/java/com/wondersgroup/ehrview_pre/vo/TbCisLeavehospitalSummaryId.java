package com.wondersgroup.ehrview_pre.vo;

/**
 * TbCisLeavehospitalSummaryId entity. @author MyEclipse Persistence Tools
 */

public class TbCisLeavehospitalSummaryId implements java.io.Serializable {

	// Fields

	private String serialNum;//就诊流水号
	private String medicalOrgId;//医疗机构代码

	// Constructors

	/** default constructor */
	public TbCisLeavehospitalSummaryId() {
	}

	/** full constructor */
	
	public TbCisLeavehospitalSummaryId(String serialNum, String medicalOrgId) {
		super();
		this.serialNum = serialNum;
		this.medicalOrgId = medicalOrgId;
	}
	// Property accessors

	

	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TbCisLeavehospitalSummaryId))
			return false;
		TbCisLeavehospitalSummaryId castOther = (TbCisLeavehospitalSummaryId) other;

		return ((this.getSerialNum() == castOther.getSerialNum()) || (this.getSerialNum() != null
				&& castOther.getSerialNum() != null && this.getSerialNum().equals(
				castOther.getSerialNum())))
				&& ((this.getMedicalOrgId() == castOther.getMedicalOrgId()) || (this
						.getMedicalOrgId() != null
						&& castOther.getMedicalOrgId() != null && this.getMedicalOrgId()
						.equals(castOther.getMedicalOrgId())));
	}

	

	
	public String getSerialNum() {
		return serialNum;
	}

	public void setSerialNum(String serialNum) {
		this.serialNum = serialNum;
	}

	public String getMedicalOrgId() {
		return medicalOrgId;
	}

	public void setMedicalOrgId(String medicalOrgId) {
		this.medicalOrgId = medicalOrgId;
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getSerialNum() == null ? 0 : this.getSerialNum().hashCode());
		result = 37 * result
				+ (getSerialNum() == null ? 0 : this.getSerialNum().hashCode());
		return result;
	}

}