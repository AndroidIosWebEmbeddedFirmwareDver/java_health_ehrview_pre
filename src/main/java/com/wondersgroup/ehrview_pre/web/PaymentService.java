package com.wondersgroup.ehrview_pre.web;

import java.util.Map;

import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpStatus;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import com.wondersgroup.core.mapper.JaxbMapper;
import com.wondersgroup.ehrview_pre.service.PaymentPreService;
import com.wondersgroup.ehrview_pre.vo.Yljgdm;


@Service
@Path("/")
@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
public class PaymentService extends BaseRestfulServiceController {

	/**
	 * 日志
	 */
	private static Logger logger = LoggerFactory.getLogger(PaymentService.class);
	
	@Autowired
	private PaymentPreService paymentPreService;
	

	
	//连接超时时间 
	@Value(value = "${connectionTimeout}")
	protected String connectionTimeout;
	
	//读数据超时时间(单位毫秒)
	@Value(value = "${soTimeout}")
	protected String  soTimeout;
	
	@POST
	@Path(value = "/payment")
	@Produces({ MediaType.APPLICATION_JSON, MediaType.APPLICATION_XML})
	public String getData(@QueryParam(value="st") String st ,String body) {
		String response = "" ;
		
		Yljgdm yljgdm  = null;
		try {
			yljgdm  = JaxbMapper.fromXml(body, Yljgdm.class);
		} catch (Exception e) {
			response = "<response><resultcode>999</resultcode><resultmessage>请求格式错误</resultmessage></response>" ;
			logger.error("error:" + st +"-"+ e.getMessage());
			return response ;
		}
		
		logger.info("info接收到请求："+st+"-"+yljgdm.getYljgdm());
		Map<String, Object> paramMap = paymentPreService.getParams(yljgdm.getYljgdm());
		
		String url = (String)paramMap.get("url");
		if(StringUtils.isBlank(url)){
			response = "<response><resultcode>999</resultcode><resultmessage>此医疗机构代码不存在</resultmessage></response>" ;
		}else{
			HttpClient client = new HttpClient();
			// 创建POST方法的实例
			PostMethod postMethod=new PostMethod(url+"?st="+st);
			
			HttpConnectionManagerParams managerParams = client.getHttpConnectionManager().getParams();  
		    // 设置连接超时时间(单位毫秒)  
			managerParams.setConnectionTimeout(Integer.parseInt(connectionTimeout));  
			// 设置读数据超时时间(单位毫秒)  
			managerParams.setSoTimeout(Integer.parseInt(soTimeout));  
			try {
				postMethod.setRequestHeader("accept", "application/xml");
				postMethod.setRequestHeader("Content-Type", "application/xml");
				
				postMethod.getParams().setParameter(HttpMethodParams.HTTP_CONTENT_CHARSET,"utf-8");  
				postMethod.setRequestBody(body);

				int statusCode = client.executeMethod(postMethod);
				if (statusCode == HttpStatus.SC_OK) {
					response = postMethod.getResponseBodyAsString();  // new String(.getBytes("8859_1"));
				}else{
					response = "<response><resultcode>999</resultcode><resultmessage>目标地址返回状态码-" + statusCode + "</resultmessage></response>";
					logger.error("info:" + st +"-"+yljgdm.getYljgdm()+"-" + url +"---目标地址返回状态码-"+statusCode);
				}
			} catch (Exception e) {
				response = "<response><resultcode>999</resultcode><resultmessage>无法访问目标地址</resultmessage></response>" ;
				e.printStackTrace();
				logger.error("error:" + st +"-"+yljgdm.getYljgdm()+"-" + url +"---"+ e.getMessage());
			}finally{
				postMethod.releaseConnection();
			}
		}
		
		return response ; 
	}

}
