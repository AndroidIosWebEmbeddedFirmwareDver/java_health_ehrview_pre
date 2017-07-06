package com.wondersgroup.ehrview_pre.util;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.apache.commons.httpclient.DefaultHttpMethodRetryHandler;
import org.apache.commons.httpclient.Header;
import org.apache.commons.httpclient.HttpClient;
import org.apache.commons.httpclient.HttpConnectionManager;
import org.apache.commons.httpclient.MultiThreadedHttpConnectionManager;
import org.apache.commons.httpclient.NameValuePair;
import org.apache.commons.httpclient.UsernamePasswordCredentials;
import org.apache.commons.httpclient.auth.AuthScope;
import org.apache.commons.httpclient.methods.PostMethod;
import org.apache.commons.httpclient.params.HttpConnectionManagerParams;
import org.apache.commons.httpclient.params.HttpMethodParams;
import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.wondersgroup.ehrview_pre.web.EhrviewService;

public class HttpClientUtil {
	/**
	 * 日志处理类
	 */
	private static Logger logger = LoggerFactory.getLogger(EhrviewService.class);
	// 读取超时
	private final static int SOCKET_TIMEOUT = 10000;
	// 连接超时
	private final static int CONNECTION_TIMEOUT = 10000;
	// 每个HOST的最大连接数量
	private final static int MAX_CONN_PRE_HOST = 120;
	// 连接池的最大连接数
	private final static int MAX_CONN = 120;
	// 连接池
	private final static HttpConnectionManager httpConnectionManager;
	//代理头
	private final static String REQUEST_HEADER = "x-forwarded-for";

	static {
		httpConnectionManager = new MultiThreadedHttpConnectionManager();
		HttpConnectionManagerParams params = httpConnectionManager.getParams();
		params.setConnectionTimeout(CONNECTION_TIMEOUT);
		params.setSoTimeout(SOCKET_TIMEOUT);
		params.setDefaultMaxConnectionsPerHost(MAX_CONN_PRE_HOST);
		params.setMaxTotalConnections(MAX_CONN);
		}

	public static Map<String,String> doHttpRequest(String url,String code,Map<String, String> queryParams,String userName,String password)throws Exception {
		BufferedReader in = null;
		Map<String,String> retMap=new HashMap<String ,String>();
		NameValuePair[] pairs = buildNameValuePairs(queryParams==null?new HashMap<String,String>():queryParams);//组装参数
		HttpClient httpClient = new HttpClient(httpConnectionManager);
		//resetRequestHeader(httpClient, "192.168.1.127");//代理服务器
		PostMethod postMethod = new PostMethod(url);//放地址
		if(StringUtils.isNotBlank(userName)&&StringUtils.isNotBlank(password)){
			UsernamePasswordCredentials localUsernamePasswordCredentials = new UsernamePasswordCredentials(userName, password);
			httpClient.getState().setCredentials(AuthScope.ANY, localUsernamePasswordCredentials);
			httpClient.getParams().setAuthenticationPreemptive(true);
			postMethod.getParams().setParameter(HttpMethodParams.RETRY_HANDLER,new DefaultHttpMethodRetryHandler());
			postMethod.setDoAuthentication(true);
		}
		postMethod.setRequestHeader("Content-type","application/x-www-form-urlencoded;charset=" + code);
		postMethod.setRequestHeader("accept", "application/xml");
		postMethod.setRequestBody(pairs);
		try {
			int stateCode=  httpClient.executeMethod(postMethod);
			in = new BufferedReader(new InputStreamReader(postMethod.getResponseBodyAsStream(), code));
			StringBuffer buffer = new StringBuffer();
			String line = "";
			while ((line = in.readLine()) != null) {
				buffer.append(line);
			}
			if(stateCode==200){
				retMap.put("data", buffer.toString());
				retMap.put("code", "1");
			}else{
				retMap.put("code", "0");
			}
		}finally {
			if (in != null) {
				try {
					in.close();
				} catch (IOException e) {
					e.printStackTrace();
				}
			}
			postMethod.releaseConnection();
		}
		return retMap;
	}
	
	private static void resetRequestHeader(HttpClient client, String ip) {
		List<Header> headers = new ArrayList<Header>();
		headers.add(new Header(REQUEST_HEADER, ip));
		client.getHostConfiguration().getParams().setParameter("http.default-headers", headers);
	}
	
	private static NameValuePair[] buildNameValuePairs(Map<String, String> queryParams) {
		if(queryParams==null) return new NameValuePair[0];
		Object[] keys = queryParams.keySet().toArray();
		NameValuePair[] pairs = new NameValuePair[keys.length];
		for (int i = 0; i < keys.length; i++) {
			String key = (String) keys[i];
			pairs[i] = new NameValuePair(key, queryParams.get(key));
		}
		return pairs;
	}
	
}