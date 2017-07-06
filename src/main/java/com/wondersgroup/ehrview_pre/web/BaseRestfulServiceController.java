/**
 * BaseRestfulServiceController.java
 * 2015 ©版权所有 万达信息股份有限公司
 */
package com.wondersgroup.ehrview_pre.web;

import java.util.HashMap;
import java.util.Map;

import javax.annotation.PostConstruct;
import javax.servlet.http.HttpServletRequest;
import javax.ws.rs.core.Context;

import org.springframework.beans.factory.annotation.Value;

/**
 * 
 * <P>
 * <li>描述:Restful服务的基类</li>
 * <li>创建人： $Author: hutao $</li>
 * <li>创建时间: 2015年1月14日</li>
 * <li>最后修改人: $Author: hutao $</li>
 * <li>最后修改时间: $Date: 2015-12-17 18:06:00 +0800 (Thu, 17 Dec 2015) $</li>
 * <li>修改备注:</LI>
 * <li>SVN版本: $Revision: 6693 $</li>
 * 
 * @version 1.0
 *
 */
public abstract class BaseRestfulServiceController {
	/**
	 * 允许的IP，多个用逗号分隔
	 */
	@Value(value = "${allow_client_ips}")
	protected String allowClientIps;
	/**
	 * tokens，多个用逗号分隔
	 */
	@Value(value = "${client_access_tokens}")
	protected String clientAccessTokens;

	/**
	 * 客户端token对应Map
	 */
	protected static Map<String, String> CLIENT_TOKEN_MAP = new HashMap<String, String>();

	/**
	 * 初始化参数
	 */
	@PostConstruct
	public void initParams() {
		String[] ips = allowClientIps.split(",");
		String[] tokens = clientAccessTokens.split(",");
		if (ips != null && ips.length > 0 && tokens != null
				&& tokens.length == ips.length) {
			for (int i = 0; i < tokens.length; i++) {
				CLIENT_TOKEN_MAP.put(ips[i], tokens[i]);
			}
		}
	}

	/**
	 * HttpServletRequest
	 */
	@Context
	protected HttpServletRequest httpRequest;

	/**
	 * 判断是否有调用权限
	 * 
	 * @return
	 */
	public Boolean auth() {
//		String clientIp = httpRequest.getRemoteAddr();
//		String token = httpRequest.getHeader("token");
//		if (CLIENT_TOKEN_MAP.get(clientIp) != null
//				&& CLIENT_TOKEN_MAP.get(clientIp).equals(token)) {
//			return true;
//		} else {
//			//TODO 测试
//			return true;
//		}
		return true;
	}
}
