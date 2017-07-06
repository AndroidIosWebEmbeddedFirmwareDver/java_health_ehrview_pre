package com.wondersgroup.ehrview_pre.util;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HttpDistributeThreadPoolClient {
    // 线程池
    private ExecutorService exe = null;
    // 线程池的容量
    private static int POOL_SIZE = 5;
    //分发请求地址列表
    private Map<String,Map<String,String>> mapUrlParam;
    
    public HttpDistributeThreadPoolClient(Map<String,Map<String,String>> mapUrlParam){
        this.mapUrlParam=mapUrlParam==null?new HashMap<String, Map<String,String>>():mapUrlParam;
    }
    
    //开始生成线程池并分发http请求方法
    private ConcurrentHashMap<String,String> start() throws Exception {
        int uSize = mapUrlParam.size();
        if(uSize>0 && uSize<=12){
            POOL_SIZE = 4;
        }
        if(uSize>30){
            POOL_SIZE = 20;
        }
        Date startDate = new Date();
        final CountDownLatch threadSignal = new CountDownLatch(uSize);
        final ConcurrentHashMap<String,String> hashMap = new ConcurrentHashMap<String,String>();
        exe = Executors.newFixedThreadPool(POOL_SIZE);        
        final Map<String,Map<String,String>> finalUriGet=this.mapUrlParam;
        for(String s:finalUriGet.keySet()){
        	 GetThread getThread = new GetThread(threadSignal,hashMap,s,finalUriGet.get(s));
             getThread.setName("线程" + s);
             exe.submit(getThread);
        }
        threadSignal.await();
        exe.shutdown();
        //System.out.println("Done");
        //System.out.println("毫秒："+(new Date().getTime()-startDate.getTime()));
        return hashMap;
    }
    public ConcurrentHashMap<String,String> getHashMapByUrls(){
        HttpDistributeThreadPoolClient threadPoolHttpClient = new HttpDistributeThreadPoolClient(this.mapUrlParam);
        try {
            ConcurrentHashMap<String,String> hashMap =threadPoolHttpClient.start();
            for(Map.Entry<String,String> e:hashMap.entrySet()){
                //System.out.println("key:"+e.getKey()+"_____||| value:"+e.getValue());
            }
            return  hashMap;
        } catch (Exception e) {
            e.printStackTrace();
        }
        return null;
    }
}