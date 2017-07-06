package com.wondersgroup.ehrview_pre.web;

import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.wondersgroup.core.utils.Reflections;
import com.wondersgroup.core.utils.spring.SpringContextHolder;
import com.wondersgroup.ehrview_pre.service.EhrviewPreLoginService;
import com.wondersgroup.ehrview_pre.service.EhrviewPreService;

@Service
@Path("/")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class EhrviewService extends BaseRestfulServiceController {

	private static Logger logger = LoggerFactory.getLogger(EhrviewService.class);
	
	/**
	 * 日志
	 */
	@Autowired
	private EhrviewPreService ehrviewPreService ;
	
	@Autowired
	private EhrviewPreLoginService ehrviewPreLoginService ;
	
	//连接超时时间 
	@Value(value = "${connectionTimeout}")
	protected String connectionTimeout;
	
	//读数据超时时间(单位毫秒)
	@Value(value = "${soTimeout}")
	protected String  soTimeout;
	
	@POST
	@Path(value = "/ehrview")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String getData( @QueryParam(value = "st") String st
			,@QueryParam(value="cardNum") String cardNum ,
			@QueryParam(value="cardType") String cardType) {
		
		logger.info("info接收到请求："+st+"-"+cardType+"-"+cardNum);
		
		String response = "" ;
		try {
			if(StringUtils.equals(st, "login")){
				// 保存用户的area，pid
				List<Map<String ,String>> area_url = ehrviewPreService.getLoginUrl();
				List<Map<String, String>> area_pid = ehrviewPreLoginService.login(cardNum, cardType, area_url);
				
				if(area_pid != null && area_pid.size()>0){
					ehrviewPreService.savePersonInfo(cardNum,cardType, area_pid);
					response = "<res><resultCode>0</resultCode><resultDesc>成功</resultDesc></res>" ;
				}else{
					response = "<res><resultCode>9998</resultCode><resultDesc>登录失败，无此人记录</resultDesc></res>" ;
				}
	 		}else{
	 			// 其它接口先查询area_pid
	 			List<Map<String ,String>> area_pid_url  = ehrviewPreService.getPersonInfo(cardNum, cardType);
	 			if(area_pid_url != null && area_pid_url.size()>0){

	 				Map<String, String> param = new HashMap<String, String>();
	 				Map map = this.httpRequest.getParameterMap();
	 				Iterator entries = map.entrySet().iterator();  
	 				String key = "" ;
	 				String value =  "" ;
	 				String[] a = new String[10];
	 				while (entries.hasNext()) {  
	 				    Map.Entry entry = (Map.Entry) entries.next();  
	 				    key = (String)entry.getKey();
	 				    a = (String[])entry.getValue();
	 				    value = a[0];
	 				   param.put(key, value);
	 				} 
	 				
	 				String[] servie_methoed =  StringUtils.split(st, ".");
	 				Object targetService = SpringContextHolder.getBean(servie_methoed[0]+"Service");
	 				Object result = null;
	 				result = Reflections.invokeMethodByName(targetService, servie_methoed[1], new Object[]{area_pid_url,param});
	 				response = result.toString();
	 			}
	 		}
		} catch (Exception e) {
			response = "<res><resultCode>9999</resultCode><resultDesc>无法访问目标地址</resultDesc></res>" ;
			e.printStackTrace();
			logger.error("error:" + st +"-"+cardType+"-"+cardNum  + "---"+ e.getMessage());
		}
		if(StringUtils.isBlank(response)){
			response =  "<res><resultCode>9998</resultCode><resultDesc>登录失败，无此人记录</resultDesc></res>" ;
			logger.info("info:" +st +"-"+cardType+"-"+cardNum  + "---登录失败，无此人记录");
		}
		
		return response ; 
	}

}
