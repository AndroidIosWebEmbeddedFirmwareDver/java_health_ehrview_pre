package com.wondersgroup.ehrview_pre.service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
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
import com.wondersgroup.ehrview_pre.vo.PeopleInfo;
import com.wondersgroup.ehrview_pre.web.EhrviewService;

@Service
@Transactional
public class EhrviewPreLoginService {
	
	private static Logger logger = LoggerFactory.getLogger(EhrviewService.class);
 
	@Autowired
	private EhrviewPreDao ehrviewPreDao;
	
	
	public List<Map<String ,String>> login(String cardNum ,String cardType,
			List<Map<String ,String>> area_url){
		Map<String,Map<String,String>> urlParam=new HashMap<String,Map<String,String>>();
		Map<String,String> param = new HashMap<String, String>();
		param.put("cardNum", cardNum);
		param.put("cardType", cardType);
		param.put("accessType", "2");
		if(area_url != null && area_url.size()>0){
			for(int t=0;t<area_url.size();t++){
				urlParam.put(area_url.get(t).get("URL").toString(), param);
			}
		}
		HttpDistributeThreadPoolClient client=new HttpDistributeThreadPoolClient(urlParam);
		ConcurrentHashMap<String,String>  result = client.getHashMapByUrls();
		String area = "" ;
		String url = "" ;
		String pid = "" ;
		String data = "" ;
		List<Map<String ,String>>  area_pid = new ArrayList<Map<String,String>>();
		if(result != null && result.size()>0){
			for(int t=0;t<area_url.size();t++){
				area = area_url.get(t).get("AREA").toString();
				url = area_url.get(t).get("URL").toString();
				if(result.containsKey(url)){
					data = result.get(url).toString();
					if(StringUtils.isNotBlank(data)){
						PeopleInfo p = JaxbMapper.fromXml(data, PeopleInfo.class);
						pid = p.getPid() ;
						if(StringUtils.isNotBlank(pid)){
							Map<String ,String> map = new HashMap<String ,String>();
							map.put("area", area);
							map.put("pid", pid);
							area_pid.add(map);
						}else{
							logger.info("login-thread:" + area +"--"+url+"--blank");
						}
					}else{
						logger.info("login-thread:" + area +"--"+url+"--blank");
					}
				}
			}
		}
		return area_pid ;
	}
 	
	
}
