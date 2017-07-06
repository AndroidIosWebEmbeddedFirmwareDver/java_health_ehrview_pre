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
import com.wondersgroup.ehrview_pre.vo.HosMedicalInfoRes;
import com.wondersgroup.ehrview_pre.vo.HosMedicalInfoVo;
import com.wondersgroup.ehrview_pre.vo.HospitalRes;
import com.wondersgroup.ehrview_pre.web.EhrviewService;

@Service(value="inpatientService")
@Transactional
public class inpatientService {
 
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
				urlParam.put(area_pid_url.get(t).get("URL").toString()+"/api/inpatient/getMedicalRecord.action", temp);
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
					logger.info("inpatient.getMedicalRecord:"+it.getKey()+"--blank");
				}
			}
			
			List<String> dataList = new ArrayList<String>(result.values());
			HosMedicalInfoRes hosMedicalInfoRes = null ;
			List<HosMedicalInfoVo> hosMedicalInfoVoList =  null ;
			for(int i=0;i<dataList.size();i++){
				String value = dataList.get(i);
				if(StringUtils.isNotBlank(value)){
					HosMedicalInfoRes res = JaxbMapper.fromXml(value, HosMedicalInfoRes.class);
					if(hosMedicalInfoRes == null){
						hosMedicalInfoRes = res ;
						hosMedicalInfoVoList = hosMedicalInfoRes.getHosMedicalInfos();
						if(hosMedicalInfoVoList == null){
							hosMedicalInfoVoList = new ArrayList<HosMedicalInfoVo>();
						}
					}else{
						List<HosMedicalInfoVo> list =   res.getHosMedicalInfos();
						if(list != null){
							hosMedicalInfoVoList.addAll(list);
						}
					}
				}
			}
			
			if(param.get("pageSize") != null && 
					StringUtils.isNotBlank(param.get("pageSize").toString())
				 && hosMedicalInfoVoList != null){
				int pageSize = Integer.parseInt(param.get("pageSize").toString());
				if(hosMedicalInfoVoList.size()>pageSize){
					List<HosMedicalInfoVo>  a =  hosMedicalInfoVoList.subList(0, pageSize);
					hosMedicalInfoVoList = new ArrayList<HosMedicalInfoVo>(a);
					hosMedicalInfoRes.setHosMedicalInfos(hosMedicalInfoVoList);
				}
			}
			response = JaxbMapper.toXml(hosMedicalInfoRes);
		}
		return response ;
	}
	
	
	public String getDischargeAbstract(List<Map<String ,String>> area_pid_url ,Map<String ,String> param){
		
		String response = "" ;
		Map<String,Map<String,String>> urlParam=new HashMap<String,Map<String,String>>();
		
		if(area_pid_url != null && area_pid_url.size()>0){
			for(int t=0;t<area_pid_url.size();t++){
				Map<String ,String> temp = new HashMap<String ,String> (param);
				temp.put("pid", area_pid_url.get(t).get("PID").toString());
				urlParam.put(area_pid_url.get(t).get("URL").toString()+"/api/inpatient/getDischargeAbstract.action", temp);
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
					logger.info("inpatient.getDischargeAbstract:"+it.getKey()+"--blank");
				}
			}
			List<String> dataList = new ArrayList<String>(result.values());
			HospitalRes hospitalRes = null ;
			for(int i=0;i<dataList.size();i++){
				String value = dataList.get(i);
				if(StringUtils.isNotBlank(value)){
					HospitalRes res = JaxbMapper.fromXml(value, HospitalRes.class);
					if(res.getHosDischargeAbstractVo() != null){
						hospitalRes = res ;
					}
				}
			}
			response = JaxbMapper.toXml(hospitalRes);
		}
		return response ;
	}
	
}
