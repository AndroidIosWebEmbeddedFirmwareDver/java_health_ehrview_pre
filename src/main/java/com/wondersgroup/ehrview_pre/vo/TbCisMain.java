package com.wondersgroup.ehrview_pre.vo;

import java.util.Date;
import java.util.List;

/**
 * TbCisMain entity. @author MyEclipse Persistence Tools
 */

public class TbCisMain implements java.io.Serializable {

	// Fields

	private TbCisMainId id;//联合主键
	private String insName;//医疗机构名称
	private String admissionDept;//入院科别
	private String transDeptOne;//转科科别1
	private String transDeptTwo;//转科科别2
	private String transDeptThree;//转科科别3
	private String dischargeDept;//出院科别
	private String hospitalTime;//住院次数
	private String MedRecordNo;//病案号
	private String name;//年龄
	private String sex;//性别
	private String burnDate;//出生日期
	private String burnPlace;//出生地
	private String nationality;//国籍
	private String nation;//民族
	private String idCard;//身份证号
	private String professionCode;//职业编码
	private String marriage;//婚姻
	private String presentAddress;//现住地
	private String accoutPhone;//户口电话
	private String workUnit;//工作单位
	private String workUnitPhone;//工作单位电话
	private String contactName;//联系人姓名
	private String contactRelation;//联系人关系
	private String contactAddress;//联系人地址
	private String contactPhone;//联系人电话
	private String admissionType;//入院类型
	private Date admissionDate;//入院时间
	private String hospitalWard;//入院病房
	private Date dischargeTime;//出院时间
	private String dischargeWard;//出院病房
	private String hospitalDay;//住院天数
	private String injuryPoison;//损伤中毒
	private String drugAllergy;//药物过敏
	private String autopsy;//尸检
	private String bloodType;//血型
	private String directorName;//科主任姓名
	private String directorDoctor;//主任、副主任医师
	private String resident;//住院医师
	private String primaryNurse;//责任护士姓名
	private String advancedDoctor;//进修医师
	private String intern;//实习医师
	private String coder;//编码员
	private String medRecordQuality;//病案质量 
	private String qualityDoctor;//质控医师
	private String qualityNurse;//质控护士
	private Date qualityDate;//质控日期
	private String outMode;//离院方式
	private String againHospital;//再次住院
	private String beforeComaTime;//入院前昏迷时间
	private String afterComaTime;//入院后昏迷时间
	private Double totalCost;//总费用
	private Double medServiceFee;//医疗服务费
	private Double treatOperationCost;//治疗操作费
	private Double nursingCost;//护理费
	private Double togetherOhterFee;//综合其他费
	private Double pathologyFee;//病理诊断费
	private Double laboratoryFee;//实验室诊断费
	private Double imageFee;//影像学诊断费
	private Double noOperationFee;//非手术治疗费
	private Double physicalTherapyFee;//临床物理治疗费
	private Double operationTreatFee;//手术治疗费
	private Double anesthesiaFee;//麻醉费
	private Double operationFee;//手术费
	private Double rehabilitationFee;//康复费
	private Double chineseMedFee;//中医治疗费
	private Double westernMedFee;//西医费
	private Double antimicrobialFee;//抗菌药物费用
	private Double medHerbFee;//中草药费
	private Double patentMedFee;//中成药费
	private Double bloodFee;//血费
	private Double albuminFee;//白蛋白制品费
	private Double globulinFee;//球蛋白制品费
	private Double coagulationFee;//凝血因子类制品费
	private Double cellFee;//细胞因子类制品费  
	private Double checkOneFee;//检查用一次性医用材料费
	private Double treatOneFee;//治疗用一次性医用材料费
	private Double operationOneFee;//手术用一次性医用材料费
	private Double otherFee;//其他费
	private String pathologyNo;//病理号
	private List<HosHomeDiagVo> hosdiag;//诊断
	private List<HosHomeOperVo> hosoper;//手术
	// Constructors

	/** default constructor */
	public TbCisMain() {
	}

	/** minimal constructor */
	public TbCisMain(TbCisMainId id, Date admissionDate, Date dischargeTime) {
		this.id = id;
		this.admissionDate = admissionDate;
		this.dischargeTime = dischargeTime;
	}

	public TbCisMain(TbCisMainId id, String insName,String admissionDept, String transDeptOne,
			String transDeptTwo, String transDeptThree, String dischargeDept,
			String hospitalTime, String medRecordNo, String name, String sex,
			String burnDate, String burnPlace, String nationality,
			String nation, String idCard, String professionCode,
			String marriage, String presentAddress, String accoutPhone,
			String workUnit, String workUnitPhone, String contactName,
			String contactRelation, String contactAddress, String contactPhone,
			String admissionType, Date admissionDate, String hospitalWard,
			Date dischargeTime, String dischargeWard, String hospitalDay,
			String injuryPoison, String drugAllergy, String autopsy,
			String bloodType, String directorName, String directorDoctor,
			String resident, String primaryNurse, String advancedDoctor,
			String intern, String coder, String medRecordQuality,
			String qualityDoctor, String qualityNurse, Date qualityDate,
			String outMode, String againHospital, String beforeComaTime,
			String afterComaTime, Double totalCost, Double medServiceFee,
			Double treatOperationCost, Double nursingCost,
			Double togetherOhterFee, Double pathologyFee, Double laboratoryFee,
			Double imageFee, Double noOperationFee, Double physicalTherapyFee,
			Double operationTreatFee, Double anesthesiaFee,
			Double operationFee, Double rehabilitationFee,
			Double chineseMedFee, Double westernMedFee,
			Double antimicrobialFee, Double medHerbFee, Double patentMedFee,
			Double bloodFee, Double albuminFee, Double globulinFee,
			Double coagulationFee, Double cellFee, Double checkOneFee,
			Double treatOneFee, Double operationOneFee, Double otherFee,
			String pathologyNo,
			List<HosHomeDiagVo> hosdiag, List<HosHomeOperVo> hosoper) {
		super();
		this.id = id;
		this.insName = insName;
		this.admissionDept = admissionDept;
		this.transDeptOne = transDeptOne;
		this.transDeptTwo = transDeptTwo;
		this.transDeptThree = transDeptThree;
		this.dischargeDept = dischargeDept;
		this.hospitalTime = hospitalTime;
		MedRecordNo = medRecordNo;
		this.name = name;
		this.sex = sex;
		this.burnDate = burnDate;
		this.burnPlace = burnPlace;
		this.nationality = nationality;
		this.nation = nation;
		this.idCard = idCard;
		this.professionCode = professionCode;
		this.marriage = marriage;
		this.presentAddress = presentAddress;
		this.accoutPhone = accoutPhone;
		this.workUnit = workUnit;
		this.workUnitPhone = workUnitPhone;
		this.contactName = contactName;
		this.contactRelation = contactRelation;
		this.contactAddress = contactAddress;
		this.contactPhone = contactPhone;
		this.admissionType = admissionType;
		this.admissionDate = admissionDate;
		this.hospitalWard = hospitalWard;
		this.dischargeTime = dischargeTime;
		this.dischargeWard = dischargeWard;
		this.hospitalDay = hospitalDay;
		this.injuryPoison = injuryPoison;
		this.drugAllergy = drugAllergy;
		this.autopsy = autopsy;
		this.bloodType = bloodType;
		this.directorName = directorName;
		this.directorDoctor = directorDoctor;
		this.resident = resident;
		this.primaryNurse = primaryNurse;
		this.advancedDoctor = advancedDoctor;
		this.intern = intern;
		this.coder = coder;
		this.medRecordQuality = medRecordQuality;
		this.qualityDoctor = qualityDoctor;
		this.qualityNurse = qualityNurse;
		this.qualityDate = qualityDate;
		this.outMode = outMode;
		this.againHospital = againHospital;
		this.beforeComaTime = beforeComaTime;
		this.afterComaTime = afterComaTime;
		this.totalCost = totalCost;
		this.medServiceFee = medServiceFee;
		this.treatOperationCost = treatOperationCost;
		this.nursingCost = nursingCost;
		this.togetherOhterFee = togetherOhterFee;
		this.pathologyFee = pathologyFee;
		this.laboratoryFee = laboratoryFee;
		this.imageFee = imageFee;
		this.noOperationFee = noOperationFee;
		this.physicalTherapyFee = physicalTherapyFee;
		this.operationTreatFee = operationTreatFee;
		this.anesthesiaFee = anesthesiaFee;
		this.operationFee = operationFee;
		this.rehabilitationFee = rehabilitationFee;
		this.chineseMedFee = chineseMedFee;
		this.westernMedFee = westernMedFee;
		this.antimicrobialFee = antimicrobialFee;
		this.medHerbFee = medHerbFee;
		this.patentMedFee = patentMedFee;
		this.bloodFee = bloodFee;
		this.albuminFee = albuminFee;
		this.globulinFee = globulinFee;
		this.coagulationFee = coagulationFee;
		this.cellFee = cellFee;
		this.checkOneFee = checkOneFee;
		this.treatOneFee = treatOneFee;
		this.operationOneFee = operationOneFee;
		this.otherFee = otherFee;
		this.pathologyNo = pathologyNo;
		this.hosdiag = hosdiag;
		this.hosoper = hosoper;
	}



	public String getPathologyNo() {
		return pathologyNo;
	}

	public void setPathologyNo(String pathologyNo) {
		this.pathologyNo = pathologyNo;
	}

	public String getInsName() {
		return insName;
	}

	public void setInsName(String insName) {
		this.insName = insName;
	}

	public String getAdmissionDept() {
		return admissionDept;
	}

	public void setAdmissionDept(String admissionDept) {
		this.admissionDept = admissionDept;
	}

	public String getTransDeptOne() {
		return transDeptOne;
	}

	public void setTransDeptOne(String transDeptOne) {
		this.transDeptOne = transDeptOne;
	}

	public String getTransDeptTwo() {
		return transDeptTwo;
	}

	public void setTransDeptTwo(String transDeptTwo) {
		this.transDeptTwo = transDeptTwo;
	}

	public String getTransDeptThree() {
		return transDeptThree;
	}

	public void setTransDeptThree(String transDeptThree) {
		this.transDeptThree = transDeptThree;
	}

	public String getDischargeDept() {
		return dischargeDept;
	}

	public void setDischargeDept(String dischargeDept) {
		this.dischargeDept = dischargeDept;
	}

	public List<HosHomeOperVo> getHosoper() {
		return hosoper;
	}

	public void setHosoper(List<HosHomeOperVo> hosoper) {
		this.hosoper = hosoper;
	}

	public List<HosHomeDiagVo> getHosdiag() {
		return hosdiag;
	}

	public void setHosdiag(List<HosHomeDiagVo> hosdiag) {
		this.hosdiag = hosdiag;
	}

	public TbCisMainId getId() {
		return id;
	}

	public void setId(TbCisMainId id) {
		this.id = id;
	}

	public String getHospitalTime() {
		return hospitalTime;
	}

	public void setHospitalTime(String hospitalTime) {
		this.hospitalTime = hospitalTime;
	}

	public String getMedRecordNo() {
		return MedRecordNo;
	}

	public void setMedRecordNo(String medRecordNo) {
		MedRecordNo = medRecordNo;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getSex() {
		return sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getBurnDate() {
		return burnDate;
	}

	public void setBurnDate(String burnDate) {
		this.burnDate = burnDate;
	}

	public String getBurnPlace() {
		return burnPlace;
	}

	public void setBurnPlace(String burnPlace) {
		this.burnPlace = burnPlace;
	}

	public String getNationality() {
		return nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getNation() {
		return nation;
	}

	public void setNation(String nation) {
		this.nation = nation;
	}

	public String getIdCard() {
		return idCard;
	}

	public void setIdCard(String idCard) {
		this.idCard = idCard;
	}

	public String getProfessionCode() {
		return professionCode;
	}

	public void setProfessionCode(String professionCode) {
		this.professionCode = professionCode;
	}

	public String getMarriage() {
		return marriage;
	}

	public void setMarriage(String marriage) {
		this.marriage = marriage;
	}

	public String getPresentAddress() {
		return presentAddress;
	}

	public void setPresentAddress(String presentAddress) {
		this.presentAddress = presentAddress;
	}

	public String getAccoutPhone() {
		return accoutPhone;
	}

	public void setAccoutPhone(String accoutPhone) {
		this.accoutPhone = accoutPhone;
	}

	public String getWorkUnit() {
		return workUnit;
	}

	public void setWorkUnit(String workUnit) {
		this.workUnit = workUnit;
	}

	public String getWorkUnitPhone() {
		return workUnitPhone;
	}

	public void setWorkUnitPhone(String workUnitPhone) {
		this.workUnitPhone = workUnitPhone;
	}

	public String getContactName() {
		return contactName;
	}

	public void setContactName(String contactName) {
		this.contactName = contactName;
	}

	public String getContactRelation() {
		return contactRelation;
	}

	public void setContactRelation(String contactRelation) {
		this.contactRelation = contactRelation;
	}

	public String getContactAddress() {
		return contactAddress;
	}

	public void setContactAddress(String contactAddress) {
		this.contactAddress = contactAddress;
	}

	public String getContactPhone() {
		return contactPhone;
	}

	public void setContactPhone(String contactPhone) {
		this.contactPhone = contactPhone;
	}

	public String getAdmissionType() {
		return admissionType;
	}

	public void setAdmissionType(String admissionType) {
		this.admissionType = admissionType;
	}

	public Date getAdmissionDate() {
		return admissionDate;
	}

	public void setAdmissionDate(Date admissionDate) {
		this.admissionDate = admissionDate;
	}

	public String getHospitalWard() {
		return hospitalWard;
	}

	public void setHospitalWard(String hospitalWard) {
		this.hospitalWard = hospitalWard;
	}

	public Date getDischargeTime() {
		return dischargeTime;
	}

	public void setDischargeTime(Date dischargeTime) {
		this.dischargeTime = dischargeTime;
	}

	public String getDischargeWard() {
		return dischargeWard;
	}

	public void setDischargeWard(String dischargeWard) {
		this.dischargeWard = dischargeWard;
	}

	public String getHospitalDay() {
		return hospitalDay;
	}

	public void setHospitalDay(String hospitalDay) {
		this.hospitalDay = hospitalDay;
	}

	public String getInjuryPoison() {
		return injuryPoison;
	}

	public void setInjuryPoison(String injuryPoison) {
		this.injuryPoison = injuryPoison;
	}

	public String getDrugAllergy() {
		return drugAllergy;
	}

	public void setDrugAllergy(String drugAllergy) {
		this.drugAllergy = drugAllergy;
	}

	public String getAutopsy() {
		return autopsy;
	}

	public void setAutopsy(String autopsy) {
		this.autopsy = autopsy;
	}

	public String getBloodType() {
		return bloodType;
	}

	public void setBloodType(String bloodType) {
		this.bloodType = bloodType;
	}

	public String getDirectorName() {
		return directorName;
	}

	public void setDirectorName(String directorName) {
		this.directorName = directorName;
	}

	public String getDirectorDoctor() {
		return directorDoctor;
	}

	public void setDirectorDoctor(String directorDoctor) {
		this.directorDoctor = directorDoctor;
	}

	public String getResident() {
		return resident;
	}

	public void setResident(String resident) {
		this.resident = resident;
	}

	public String getPrimaryNurse() {
		return primaryNurse;
	}

	public void setPrimaryNurse(String primaryNurse) {
		this.primaryNurse = primaryNurse;
	}

	public String getAdvancedDoctor() {
		return advancedDoctor;
	}

	public void setAdvancedDoctor(String advancedDoctor) {
		this.advancedDoctor = advancedDoctor;
	}

	public String getIntern() {
		return intern;
	}

	public void setIntern(String intern) {
		this.intern = intern;
	}

	public String getCoder() {
		return coder;
	}

	public void setCoder(String coder) {
		this.coder = coder;
	}

	public String getMedRecordQuality() {
		return medRecordQuality;
	}

	public void setMedRecordQuality(String medRecordQuality) {
		this.medRecordQuality = medRecordQuality;
	}

	public String getQualityDoctor() {
		return qualityDoctor;
	}

	public void setQualityDoctor(String qualityDoctor) {
		this.qualityDoctor = qualityDoctor;
	}

	public String getQualityNurse() {
		return qualityNurse;
	}

	public void setQualityNurse(String qualityNurse) {
		this.qualityNurse = qualityNurse;
	}

	public Date getQualityDate() {
		return qualityDate;
	}

	public void setQualityDate(Date qualityDate) {
		this.qualityDate = qualityDate;
	}

	public String getOutMode() {
		return outMode;
	}

	public void setOutMode(String outMode) {
		this.outMode = outMode;
	}

	public String getAgainHospital() {
		return againHospital;
	}

	public void setAgainHospital(String againHospital) {
		this.againHospital = againHospital;
	}

	public String getBeforeComaTime() {
		return beforeComaTime;
	}

	public void setBeforeComaTime(String beforeComaTime) {
		this.beforeComaTime = beforeComaTime;
	}

	public String getAfterComaTime() {
		return afterComaTime;
	}

	public void setAfterComaTime(String afterComaTime) {
		this.afterComaTime = afterComaTime;
	}

	public Double getTotalCost() {
		return totalCost;
	}

	public void setTotalCost(Double totalCost) {
		this.totalCost = totalCost;
	}

	public Double getMedServiceFee() {
		return medServiceFee;
	}

	public void setMedServiceFee(Double medServiceFee) {
		this.medServiceFee = medServiceFee;
	}

	public Double getTreatOperationCost() {
		return treatOperationCost;
	}

	public void setTreatOperationCost(Double treatOperationCost) {
		this.treatOperationCost = treatOperationCost;
	}

	public Double getNursingCost() {
		return nursingCost;
	}

	public void setNursingCost(Double nursingCost) {
		this.nursingCost = nursingCost;
	}

	public Double getTogetherOhterFee() {
		return togetherOhterFee;
	}

	public void setTogetherOhterFee(Double togetherOhterFee) {
		this.togetherOhterFee = togetherOhterFee;
	}

	public Double getPathologyFee() {
		return pathologyFee;
	}

	public void setPathologyFee(Double pathologyFee) {
		this.pathologyFee = pathologyFee;
	}

	public Double getLaboratoryFee() {
		return laboratoryFee;
	}

	public void setLaboratoryFee(Double laboratoryFee) {
		this.laboratoryFee = laboratoryFee;
	}

	public Double getImageFee() {
		return imageFee;
	}

	public void setImageFee(Double imageFee) {
		this.imageFee = imageFee;
	}

	public Double getNoOperationFee() {
		return noOperationFee;
	}

	public void setNoOperationFee(Double noOperationFee) {
		this.noOperationFee = noOperationFee;
	}

	public Double getPhysicalTherapyFee() {
		return physicalTherapyFee;
	}

	public void setPhysicalTherapyFee(Double physicalTherapyFee) {
		this.physicalTherapyFee = physicalTherapyFee;
	}

	public Double getOperationTreatFee() {
		return operationTreatFee;
	}

	public void setOperationTreatFee(Double operationTreatFee) {
		this.operationTreatFee = operationTreatFee;
	}

	public Double getAnesthesiaFee() {
		return anesthesiaFee;
	}

	public void setAnesthesiaFee(Double anesthesiaFee) {
		this.anesthesiaFee = anesthesiaFee;
	}

	public Double getOperationFee() {
		return operationFee;
	}

	public void setOperationFee(Double operationFee) {
		this.operationFee = operationFee;
	}

	public Double getRehabilitationFee() {
		return rehabilitationFee;
	}

	public void setRehabilitationFee(Double rehabilitationFee) {
		this.rehabilitationFee = rehabilitationFee;
	}

	public Double getChineseMedFee() {
		return chineseMedFee;
	}

	public void setChineseMedFee(Double chineseMedFee) {
		this.chineseMedFee = chineseMedFee;
	}

	public Double getWesternMedFee() {
		return westernMedFee;
	}

	public void setWesternMedFee(Double westernMedFee) {
		this.westernMedFee = westernMedFee;
	}

	public Double getAntimicrobialFee() {
		return antimicrobialFee;
	}

	public void setAntimicrobialFee(Double antimicrobialFee) {
		this.antimicrobialFee = antimicrobialFee;
	}

	public Double getMedHerbFee() {
		return medHerbFee;
	}

	public void setMedHerbFee(Double medHerbFee) {
		this.medHerbFee = medHerbFee;
	}

	public Double getPatentMedFee() {
		return patentMedFee;
	}

	public void setPatentMedFee(Double patentMedFee) {
		this.patentMedFee = patentMedFee;
	}

	public Double getBloodFee() {
		return bloodFee;
	}

	public void setBloodFee(Double bloodFee) {
		this.bloodFee = bloodFee;
	}

	public Double getAlbuminFee() {
		return albuminFee;
	}

	public void setAlbuminFee(Double albuminFee) {
		this.albuminFee = albuminFee;
	}

	public Double getGlobulinFee() {
		return globulinFee;
	}

	public void setGlobulinFee(Double globulinFee) {
		this.globulinFee = globulinFee;
	}

	public Double getCoagulationFee() {
		return coagulationFee;
	}

	public void setCoagulationFee(Double coagulationFee) {
		this.coagulationFee = coagulationFee;
	}

	public Double getCellFee() {
		return cellFee;
	}

	public void setCellFee(Double cellFee) {
		this.cellFee = cellFee;
	}

	public Double getCheckOneFee() {
		return checkOneFee;
	}

	public void setCheckOneFee(Double checkOneFee) {
		this.checkOneFee = checkOneFee;
	}

	public Double getTreatOneFee() {
		return treatOneFee;
	}

	public void setTreatOneFee(Double treatOneFee) {
		this.treatOneFee = treatOneFee;
	}

	public Double getOperationOneFee() {
		return operationOneFee;
	}

	public void setOperationOneFee(Double operationOneFee) {
		this.operationOneFee = operationOneFee;
	}

	public Double getOtherFee() {
		return otherFee;
	}

	public void setOtherFee(Double otherFee) {
		this.otherFee = otherFee;
	}

	
	
}
	