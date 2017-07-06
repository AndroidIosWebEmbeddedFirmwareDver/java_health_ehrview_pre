package com.wondersgroup.ehrview_pre.vo;

/**
 * TbCisMainId entity. @author MyEclipse Persistence Tools
 */

public class TbCisMainId implements java.io.Serializable {

	// Fields

	private String serialNo;
	private String insCode;

	// Constructors

	/** default constructor */
	public TbCisMainId() {
	}

	/** full constructor */
	public TbCisMainId(String serialNo, String insCode) {
		this.serialNo = serialNo;
		this.insCode = insCode;
	}

	// Property accessors



	public boolean equals(Object other) {
		if ((this == other))
			return true;
		if ((other == null))
			return false;
		if (!(other instanceof TbCisMainId))
			return false;
		TbCisMainId castOther = (TbCisMainId) other;

		return ((this.getSerialNo() == castOther.getSerialNo()) || (this.getSerialNo() != null
				&& castOther.getSerialNo() != null && this.getSerialNo().equals(
				castOther.getSerialNo())))
				&& ((this.getInsCode() == castOther.getInsCode()) || (this
						.getInsCode() != null
						&& castOther.getInsCode() != null && this.getInsCode()
						.equals(castOther.getInsCode())));
	}

	public String getSerialNo() {
		return serialNo;
	}

	public void setSerialNo(String serialNo) {
		this.serialNo = serialNo;
	}

	public String getInsCode() {
		return insCode;
	}

	public void setInsCode(String insCode) {
		this.insCode = insCode;
	}

	public int hashCode() {
		int result = 17;

		result = 37 * result
				+ (getSerialNo() == null ? 0 : this.getSerialNo().hashCode());
		result = 37 * result
				+ (getInsCode() == null ? 0 : this.getInsCode().hashCode());
		return result;
	}

}