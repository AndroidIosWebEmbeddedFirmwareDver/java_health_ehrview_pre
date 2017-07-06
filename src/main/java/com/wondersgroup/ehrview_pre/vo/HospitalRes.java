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
public class HospitalRes extends BaseResult{
	@XmlElementWrapper(name="hosHomes")
	@XmlElement(name="hosHome")
	List<HosHomeVo> hosHomeVO;//住院病案首页
	private TbCisMain hosHomeDetailVo;//病案首页详情
	private TbCisLeavehospitalSummary hosDischargeAbstractVo;//出院小结

	public TbCisLeavehospitalSummary getHosDischargeAbstractVo() {
		return hosDischargeAbstractVo;
	}
	public void setHosDischargeAbstractVo(
			TbCisLeavehospitalSummary hosDischargeAbstractVo) {
		this.hosDischargeAbstractVo = hosDischargeAbstractVo;
	}
	public TbCisMain getHosHomeDetailVo() {
		return hosHomeDetailVo;
	}
	public void setHosHomeDetailVo(TbCisMain hosHomeDetailVo) {
		this.hosHomeDetailVo = hosHomeDetailVo;
	}
	public List<HosHomeVo> getHosHomeVO() {
		return hosHomeVO;
	}
	public void setHosHomeVO(List<HosHomeVo> hosHomeVO) {
		this.hosHomeVO = hosHomeVO;
	}
}
