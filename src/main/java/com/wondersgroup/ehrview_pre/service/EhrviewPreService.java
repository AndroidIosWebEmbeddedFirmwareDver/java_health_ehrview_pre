package com.wondersgroup.ehrview_pre.service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.hibernate.SQLQuery;
import org.hibernate.Session;
import org.hibernate.transform.Transformers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wondersgroup.ehrview_pre.dao.EhrviewPreDao;

@Service
@Transactional
public class EhrviewPreService {
 
	@Autowired
	private EhrviewPreDao ehrviewPreDao;
	
	public List<Map<String ,String>>  getLoginUrl(){
		String sql = " select  t.area, t.url || '/api/login.action' url from TB_AREA_MATCH t  " ;
		SQLQuery  query = ehrviewPreDao.createSQLQuery(sql, null, null,null);
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		List<Map<String,String>> resultList = query.list();
		return resultList ;
	}
	
	public void  savePersonInfo(String cardNum ,String cardType ,
								List<Map<String ,String>> area_pid){
		if(area_pid != null && area_pid.size() > 0){
			//删除此人以前的信息
			String sql = " delete TB_PERSON_INFO where cardnum = ? and cardtype = ? "  ;
			SQLQuery query = ehrviewPreDao.createSQLQuery(sql, null, null, new String[]{cardNum,cardType});
			query.executeUpdate();
			//保存此人信息
			for(int i = 0 ; i < area_pid.size() ; i++){
				sql = "insert into TB_PERSON_INFO (id ,cardnum ,cardtype ,area ,pid)"
						+ " values (sys_guid(),? ,? ,? ,?)" ;
				query =  ehrviewPreDao.createSQLQuery(sql, null, null,
						new String[]{cardNum,cardType,area_pid.get(i).get("area").toString()
									,area_pid.get(i).get("pid").toString()});
				query.executeUpdate();
			}
		}
	}
	
	public List<Map<String ,String>> getPersonInfo (String cardNum ,String cardType){
		String sql = "select t.area , t.pid ,a.url "
				+ " from TB_PERSON_INFO t join TB_AREA_MATCH a on t.area = a.area"
				+ "  where cardnum = ? and cardtype = ? ";
		SQLQuery query = ehrviewPreDao.createSQLQuery(sql, null, null,  new String[]{cardNum,cardType});
		query.setResultTransformer(Transformers.ALIAS_TO_ENTITY_MAP);
		return  query.list() ;
	}
	
	
}
