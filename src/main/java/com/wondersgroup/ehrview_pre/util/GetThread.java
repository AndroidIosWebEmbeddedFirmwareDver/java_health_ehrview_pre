package com.wondersgroup.ehrview_pre.util;

import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.CountDownLatch;

public  class GetThread extends Thread{
    private final CountDownLatch threadSignal;
    private final ConcurrentHashMap<String,String> hashMap;
    private final String url;
    private final Map<String,String> params;
    //private static List<Thread> runningThreads = new ArrayList<Thread>();
    public GetThread( CountDownLatch threadSignal, ConcurrentHashMap<String, String> hashMap,String url,Map<String,String> params) {
        this.url=url;
        this.params=params;
        this.hashMap = hashMap;
        this.threadSignal = threadSignal;
    }
    @Override
    public void run(){
        System.out.println("ThreadName:"+Thread.currentThread().getName());
        hashMap.put(this.url, get());
        try{
            threadSignal.countDown();
        }catch (Exception e) {
        	e.printStackTrace();
        }
    }

    public String get() {
        Map<String,String> reStrMap = null;
        try {
        	reStrMap=HttpClientUtil.doHttpRequest(this.url, "UTF-8", params, null, null);
        	if("1".equals(reStrMap.get("code"))){
        		return reStrMap.get("data")==null?"":reStrMap.get("data");
        	}
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "";
    }

}