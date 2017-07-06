package com.wondersgroup.ehrview_pre.web;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.lang.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.wondersgroup.ehrview_pre.service.PaymentPreService;


@Service
@Path("/")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class LisRisService extends BaseRestfulServiceController {

	/**
	 * 日志
	 */
	private static Logger logger = LoggerFactory.getLogger(LisRisService.class);
	
	@Autowired
	private PaymentPreService paymentPreService;
	

	
	//连接超时时间 
	@Value(value = "${connectionTimeout}")
	protected String connectionTimeout;
	
	//读数据超时时间(单位毫秒)
	@Value(value = "${soTimeout}")
	protected String  soTimeout;
	
	@POST
	@Path(value = "/lisris")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String getData(@QueryParam(value="st") String st ,
						 @QueryParam(value="medicalOrgId") String medicalOrgId) {
	
		String response = "" ;
		logger.info("info接收到请求："+st+"-"+medicalOrgId);
	   
		Map<String, Object> paramMap = paymentPreService.getParams(medicalOrgId);
		
		String url = (String)paramMap.get("url");
		if(StringUtils.isBlank(url)){
			response = "<res><resultCode>999</resultCode><resultDesc>此医疗机构代码不存在</resultDesc></res>" ;
		}else{
			String method = (String)paramMap.get("method");
			PostMethod postMethod;
			if(method.equals("GET")){
			   Map map = httpRequest.getParameterMap();
			   Iterator entries = map.entrySet().iterator();  
			   String key = "" ;
			   String value =  "" ;
			   String str="";
			   String[] a = new String[10];
			   NameValuePair param ;
			   while (entries.hasNext()) {  
			       Map.Entry entry = (Map.Entry) entries.next();  
			       key = (String)entry.getKey();
			       a = (String[])entry.getValue();
			       value = a[0];
			       str += "&"+key+"="+value;

			   } 
			  postMethod=new PostMethod(url+"?st="+st+str);
			  
		   }else{
			 
			   postMethod=new PostMethod(url+"?st="+st);
			   List<NameValuePair> params = new ArrayList<NameValuePair>();
			   Map map = httpRequest.getParameterMap();
			   Iterator entries = map.entrySet().iterator();  
			   String key = "" ;
			   String value =  "" ;
			   String[] a = new String[10];
			   NameValuePair param ;
			   while (entries.hasNext()) {
			       Map.Entry entry = (Map.Entry) entries.next();  
			       key = (String)entry.getKey();
			       a = (String[])entry.getValue();
			       value = a[0];
			       param = new NameValuePair(key,value);
			       params.add(param);
			     } 
			    postMethod.setRequestBody(params.toArray(new NameValuePair[0]));
		   }
		   HttpClient client = new HttpClient();
		   HttpConnectionManagerParams managerParams = client.getHttpConnectionManager().getParams();  
	       // 设置连接超时时间(单位毫秒)  
		   managerParams.setConnectionTimeout(Integer.parseInt(connectionTimeout));  
		   // 设置读数据超时时间(单位毫秒)  
		   managerParams.setSoTimeout(Integer.parseInt(soTimeout));  
		   try {
			   postMethod.setRequestHeader("accept", "application/xml");
			   postMethod.setRequestHeader("Content-Type", "application/xml");
			   postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"utf-8");  
			  
			   int statusCode = client.executeMethod(postMethod);
			   if (statusCode == HttpStatus.SC_OK) {
				   response =   postMethod.getResponseBodyAsString();//  new String(.getBytes("8859_1"));
			   }else{
				   response = "<res><resultCode>999</resultCode><resultDesc>目标地址返回状态码-" + statusCode + "</resultDesc></res>";
				   logger.error("info:" + st +"-"+medicalOrgId+"-" + url +"---目标地址返回状态码-"+statusCode);
			   }
		   } catch (Exception e) {
			   response = "<res><resultCode>999</resultCode><resultDesc>无法访问目标地址</resultDesc></res>" ;
			   e.printStackTrace();
			   logger.error("error:" + st +"-"+medicalOrgId+"-" + url +"---"+ e.getMessage());
		   }finally{
			   postMethod.releaseConnection();
		   }
		}
		return response;  
	  }
		 
	
	
}
