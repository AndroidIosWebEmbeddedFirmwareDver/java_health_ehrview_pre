package com.wondersgroup.ehrview_pre.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wondersgroup.ehrview_pre.dao.PaymentPreDao;

@Service
@Transactional

public class PaymentPreService{
	
   @Autowired
   private PaymentPreDao paymentPreDao;
   
   public Map<String,Object> getParams(String  yljgdm){
		String url = "" ;
		String method = "" ;
		
		String sqlORG = " select url,method from TB_ORG_URL_MATCH where org_code = :yljgdm " ;
		Session s = paymentPreDao.getSessionFactory().openSession();
		s.createSQLQuery(sqlORG);
		
		SQLQuery queryORG = paymentPreDao.createSQLQuery(sqlORG, null, null, null);
		
		queryORG.setString("yljgdm", yljgdm);
		queryORG.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List<Map> resultORG = queryORG.list();
		if(resultORG != null && resultORG.size()>0){
			url = resultORG.get(0).get("URL").toString();
			method = resultORG.get(0).get("METHOD").toString();
		
		}
		Map<String,Object> paramMap = new HashMap<String,Object>();
		paramMap.put("url",url);
		paramMap.put("method",method);
		return paramMap ;
		
	}

}