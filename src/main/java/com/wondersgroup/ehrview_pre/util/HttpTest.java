package com.wondersgroup.ehrview_pre.util;

import java.util.HashMap;
import java.util.Map;

public class HttpTest {

	public static void main(String[] args) {
		Map<String,Map<String,String>> urlParam=new HashMap<String,Map<String,String>>();
		for(int i=0;i<48;i++){
			urlParam.put("http://192.168.1.140:8081/ehrview_cd/api/login.action?accessType=2&cardId=450820268100001393461&cardType="+i, null);
		}
		HttpDistributeThreadPoolClient client=new HttpDistributeThreadPoolClient(urlParam);
		client.getHashMapByUrls();
	}

}
