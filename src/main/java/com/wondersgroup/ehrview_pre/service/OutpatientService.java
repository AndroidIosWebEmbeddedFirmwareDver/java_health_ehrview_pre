package com.wondersgroup.ehrview_pre.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wondersgroup.core.mapper.JaxbMapper;
import com.wondersgroup.ehrview_pre.dao.EhrviewPreDao;
import com.wondersgroup.ehrview_pre.util.HttpDistributeThreadPoolClient;
import com.wondersgroup.ehrview_pre.vo.ClinicalLabRes;
import com.wondersgroup.ehrview_pre.vo.ClinicalLabVo;
import com.wondersgroup.ehrview_pre.vo.LabDetailVo;
import com.wondersgroup.ehrview_pre.vo.MedicalInfoRes;
import com.wondersgroup.ehrview_pre.vo.MedicalInfoVo;
import com.wondersgroup.ehrview_pre.vo.OutpatientRes;
import com.wondersgroup.ehrview_pre.vo.PrescriptionRecordVo;
import com.wondersgroup.ehrview_pre.vo.PrescriptionRes;
import com.wondersgroup.ehrview_pre.vo.PrescriptionVo;
import com.wondersgroup.ehrview_pre.web.EhrviewService;

@Service(value="outpatientService")
@Transactional
public class OutpatientService {
 
	@Autowired
	private EhrviewPreDao ehrviewPreDao;
	
	private static Logger logger = LoggerFactory.getLogger(EhrviewService.class);
	
	
	public String getMedicalRecord(List<Map<String ,String>> area_pid_url ,Map<String ,String> param){
		
		String response = "" ;
		Map<String,Map<String,String>> urlParam=new HashMap<String,Map<String,String>>();
		
		if(area_pid_url != null && area_pid_url.size()>0){
			for(int t=0;t<area_pid_url.size();t++){
				Map<String ,String> temp = new HashMap<String ,String> (param);
				temp.put("pid", area_pid_url.get(t).get("PID").toString());
				urlParam.put(area_pid_url.get(t).get("URL").toString()+"/api/outpatient/getMedicalRecord.action", temp);
			}
		}
		HttpDistributeThreadPoolClient client=new HttpDistributeThreadPoolClient(urlParam);
		ConcurrentHashMap<String,String>  result = client.getHashMapByUrls();
		if(result != null && result.size()>0){
			//用于写日志
			Iterator<Entry<String, String>> its = result.entrySet().iterator();
			while(its.hasNext()){
				Entry<String, String> it = its.next();
				if(StringUtils.isBlank(it.getValue())){
					logger.info("outpatient.getMedicalRecord:"+it.getKey()+"--blank");
				}
			}
			
			List<String> dataList = new ArrayList<String>(result.values());
			MedicalInfoRes medicalInfoRes = null ;
			List<MedicalInfoVo> medicalInfoVoList =  null ;
			for(int i=0;i<dataList.size();i++){
				String value = dataList.get(i);
				if(StringUtils.isNotBlank(value)){
					MedicalInfoRes res = JaxbMapper.fromXml(value, MedicalInfoRes.class);
					if(medicalInfoRes == null){
						medicalInfoRes = res ;
						medicalInfoVoList = medicalInfoRes.getMedicalInfos();
						if(medicalInfoVoList == null){
							medicalInfoVoList = new ArrayList<MedicalInfoVo>();
						}
					}else{
						List<MedicalInfoVo> list =   res.getMedicalInfos() ;
						if(list != null){
							medicalInfoVoList.addAll(list);
						}
					}
				}
			}
			
			if(param.get("pageSize") != null && 
					StringUtils.isNotBlank(param.get("pageSize").toString())
				 && medicalInfoVoList != null){
				int pageSize = Integer.parseInt(param.get("pageSize").toString());
				if(medicalInfoVoList.size()>pageSize){
					List<MedicalInfoVo>  a =  medicalInfoVoList.subList(0, pageSize);
					medicalInfoVoList = new ArrayList<MedicalInfoVo>(a);
					medicalInfoRes.setMedicalInfos(medicalInfoVoList);
				}
			}
			response = JaxbMapper.toXml(medicalInfoRes);
		}
		return response ;
	}
 	
	
	
	public String getPrescriptionRecord(List<Map<String ,String>> area_pid_url ,Map<String ,String> param){
		
		String response = "" ;
		Map<String,Map<String,String>> urlParam=new HashMap<String,Map<String,String>>();
		
		if(area_pid_url != null && area_pid_url.size()>0){
			for(int t=0;t<area_pid_url.size();t++){
				Map<String ,String> temp = new HashMap<String ,String> (param);
				temp.put("pid", area_pid_url.get(t).get("PID").toString());
				urlParam.put(area_pid_url.get(t).get("URL").toString()+"/api/outpatient/getPrescriptionRecord.action", temp);
			}
		}
		HttpDistributeThreadPoolClient client=new HttpDistributeThreadPoolClient(urlParam);
		ConcurrentHashMap<String,String>  result = client.getHashMapByUrls();
		if(result != null && result.size()>0){
			//用于写日志
			Iterator<Entry<String, String>> its = result.entrySet().iterator();
			while(its.hasNext()){
				Entry<String, String> it = its.next();
				if(StringUtils.isBlank(it.getValue())){
					logger.info("outpatient.getPrescriptionRecord:"+it.getKey()+"--blank");
				}
			}
			
			List<String> dataList = new ArrayList<String>(result.values());
			PrescriptionRes prescriptionRes = null ;
			List<PrescriptionRecordVo> prescriptionRecordVoList =  null ;
			for(int i=0;i<dataList.size();i++){
				String value = dataList.get(i);
				if(StringUtils.isNotBlank(value)){
					PrescriptionRes res = JaxbMapper.fromXml(value, PrescriptionRes.class);
					if(prescriptionRes == null){
						prescriptionRes = res ;
						prescriptionRecordVoList = prescriptionRes.getPrescriptionRecord();
						if(prescriptionRecordVoList == null){
							prescriptionRecordVoList =  new ArrayList<PrescriptionRecordVo>(); 
						}
					}else{
						List<PrescriptionRecordVo> list =   res.getPrescriptionRecord();
						if(list != null ){
							prescriptionRecordVoList.addAll(list);
						}
					}
				}
			}
			
			if(param.get("pageSize") != null && 
					StringUtils.isNotBlank(param.get("pageSize").toString())
				 && prescriptionRecordVoList != null){
				int pageSize = Integer.parseInt(param.get("pageSize").toString());
				if(prescriptionRecordVoList.size()>pageSize){
					List<PrescriptionRecordVo>  a =  prescriptionRecordVoList.subList(0, pageSize);
					prescriptionRecordVoList = new ArrayList<PrescriptionRecordVo>(a);
					prescriptionRes.setPrescriptionRecord(prescriptionRecordVoList);
				}
			}
			response = JaxbMapper.toXml(prescriptionRes);
		}
		return response ;
	}
	
	
	
	public String getPrescriptionDetail(List<Map<String ,String>> area_pid_url ,Map<String ,String> param){
		
		String response = "" ;
		Map<String,Map<String,String>> urlParam=new HashMap<String,Map<String,String>>();
		
		if(area_pid_url != null && area_pid_url.size()>0){
			for(int t=0;t<area_pid_url.size();t++){
				Map<String ,String> temp = new HashMap<String ,String> (param);
				temp.put("pid", area_pid_url.get(t).get("PID").toString());
				urlParam.put(area_pid_url.get(t).get("URL").toString()+"/api/outpatient/getPrescriptionDetail.action", temp);
			}
		}
		HttpDistributeThreadPoolClient client=new HttpDistributeThreadPoolClient(urlParam);
		ConcurrentHashMap<String,String>  result = client.getHashMapByUrls();
		if(result != null && result.size()>0){
			
			//用于写日志
			Iterator<Entry<String, String>> its = result.entrySet().iterator();
			while(its.hasNext()){
				Entry<String, String> it = its.next();
				if(StringUtils.isBlank(it.getValue())){
					logger.info("outpatient.getPrescriptionDetail:"+it.getKey()+"--blank");
				}
			}
			
			List<String> dataList = new ArrayList<String>(result.values());
			PrescriptionRes prescriptionRes = null ;
			List<PrescriptionVo> prescriptionVoList =  null ;
			for(int i=0;i<dataList.size();i++){
				String value = dataList.get(i);
				if(StringUtils.isNotBlank(value)){
					PrescriptionRes res = JaxbMapper.fromXml(value, PrescriptionRes.class);
					if(prescriptionRes == null){
						prescriptionRes = res ;
						prescriptionVoList = prescriptionRes.getPrescriptions();
						if(prescriptionVoList == null){
							prescriptionVoList =  new ArrayList<PrescriptionVo>(); 
						}
					}else{
						List<PrescriptionVo> list =   res.getPrescriptions();
						if(list != null ){
							prescriptionVoList.addAll(list);
						}
					}
				}
			}
			
			if(param.get("pageSize") != null && 
					StringUtils.isNotBlank(param.get("pageSize").toString())
				 && prescriptionVoList != null){
				int pageSize = Integer.parseInt(param.get("pageSize").toString());
				if(prescriptionVoList.size()>pageSize){
					List<PrescriptionVo>  a =  prescriptionVoList.subList(0, pageSize);
					prescriptionVoList = new ArrayList<PrescriptionVo>(a);
					prescriptionRes.setPrescriptions(prescriptionVoList);
				}
			}
			response = JaxbMapper.toXml(prescriptionRes);
		}
		return response ;
	}

	
	public String getLisRecord(List<Map<String ,String>> area_pid_url ,Map<String ,String> param){
		
		String response = "" ;
		Map<String,Map<String,String>> urlParam=new HashMap<String,Map<String,String>>();
		
		if(area_pid_url != null && area_pid_url.size()>0){
			for(int t=0;t<area_pid_url.size();t++){
				Map<String ,String> temp = new HashMap<String ,String> (param);
				temp.put("pid", area_pid_url.get(t).get("PID").toString());
				urlParam.put(area_pid_url.get(t).get("URL").toString()+"/api/outpatient/getLisRecord.action", temp);
			}
		}
		HttpDistributeThreadPoolClient client=new HttpDistributeThreadPoolClient(urlParam);
		ConcurrentHashMap<String,String>  result = client.getHashMapByUrls();
		if(result != null && result.size()>0){
			
			//用于写日志
			Iterator<Entry<String, String>> its = result.entrySet().iterator();
			while(its.hasNext()){
				Entry<String, String> it = its.next();
				if(StringUtils.isBlank(it.getValue())){
					logger.info("outpatient.getLisRecord:"+it.getKey()+"--blank");
				}
			}
			
			List<String> dataList = new ArrayList<String>(result.values());
			ClinicalLabRes clinicalLabRes = null ;
			List<ClinicalLabVo> clinicalLabVoList =  null ;
			for(int i=0;i<dataList.size();i++){
				String value = dataList.get(i);
				if(StringUtils.isNotBlank(value)){
					ClinicalLabRes res = JaxbMapper.fromXml(value, ClinicalLabRes.class);
					if(clinicalLabRes == null){
						clinicalLabRes = res ;
						clinicalLabVoList = clinicalLabRes.getClinicalLabVos();
						if(clinicalLabVoList == null){
							clinicalLabVoList =  new ArrayList<ClinicalLabVo>(); 
						}
					}else{
						List<ClinicalLabVo> list =   res.getClinicalLabVos();
						if(list != null ){
							clinicalLabVoList.addAll(list);
						}
					}
				}
			}
			
			if(param.get("pageSize") != null && 
					StringUtils.isNotBlank(param.get("pageSize").toString())
				 && clinicalLabVoList != null){
				int pageSize = Integer.parseInt(param.get("pageSize").toString());
				if(clinicalLabVoList.size()>pageSize){
					List<ClinicalLabVo>  a =  clinicalLabVoList.subList(0, pageSize);
					clinicalLabVoList = new ArrayList<ClinicalLabVo>(a);
					clinicalLabRes.setClinicalLabVos(clinicalLabVoList);
				}
			}
			response = JaxbMapper.toXml(clinicalLabRes);
		}
		return response ;
	}
	
	
	
	public String getLisDetail(List<Map<String ,String>> area_pid_url ,Map<String ,String> param){
		
		String response = "" ;
		Map<String,Map<String,String>> urlParam=new HashMap<String,Map<String,String>>();
		
		if(area_pid_url != null && area_pid_url.size()>0){
			for(int t=0;t<area_pid_url.size();t++){
				Map<String ,String> temp = new HashMap<String ,String> (param);
				temp.put("pid", area_pid_url.get(t).get("PID").toString());
				urlParam.put(area_pid_url.get(t).get("URL").toString()+"/api/outpatient/getLisDetail.action", temp);
			}
		}
		HttpDistributeThreadPoolClient client=new HttpDistributeThreadPoolClient(urlParam);
		ConcurrentHashMap<String,String>  result = client.getHashMapByUrls();
		if(result != null && result.size()>0){
			
			//用于写日志
			Iterator<Entry<String, String>> its = result.entrySet().iterator();
			while(its.hasNext()){
				Entry<String, String> it = its.next();
				if(StringUtils.isBlank(it.getValue())){
					logger.info("outpatient.getLisDetail:"+it.getKey()+"--blank");
				}
			}
			
			List<String> dataList = new ArrayList<String>(result.values());
			OutpatientRes outpatientRes = null ;
			List<LabDetailVo> labDetailVoList =  null ;
			for(int i=0;i<dataList.size();i++){
				String value = dataList.get(i);
				if(StringUtils.isNotBlank(value)){
					OutpatientRes res = JaxbMapper.fromXml(value, OutpatientRes.class);
					if(outpatientRes == null){
						outpatientRes = res ;
						labDetailVoList = outpatientRes.getLabDetail();
						if(labDetailVoList == null){
							labDetailVoList =  new ArrayList<LabDetailVo>(); 
						}
					}else{
						List<LabDetailVo> list =   res.getLabDetail();
						if(list != null ){
							labDetailVoList.addAll(list);
						}
					}
				}
			}
			
			if(param.get("pageSize") != null && 
					StringUtils.isNotBlank(param.get("pageSize").toString())
				 && labDetailVoList != null){
				int pageSize = Integer.parseInt(param.get("pageSize").toString());
				if(labDetailVoList.size()>pageSize){
					List<LabDetailVo>  a =  labDetailVoList.subList(0, pageSize);
					labDetailVoList = new ArrayList<LabDetailVo>(a);
					outpatientRes.setLabDetail(labDetailVoList);
				}
			}
			response = JaxbMapper.toXml(outpatientRes);
		}
		return response ;
	}
}
