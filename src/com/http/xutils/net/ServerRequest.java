package com.http.xutils.net;


import com.http.xutils.R;
import com.http.xutils.interfaces.RequestListener;
import com.http.xutils.util.Constant;
import com.http.xutils.util.LogUtil;
import com.lidroid.xutils.HttpUtils;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.ResponseInfo;
import com.lidroid.xutils.http.callback.RequestCallBack;
import com.lidroid.xutils.http.client.HttpRequest.HttpMethod;

import android.app.PendingIntent.OnFinished;

/**
 * 通用Http接口请求
 * 
 * @author eric liu
 *
 */

public class ServerRequest {
	
	private static String baseUrl="http://" + Constant.HOST + ":" + Constant.PORT_HTTP + "/xxx/xxx";
	
	
	/**
	 * http的get请求
	 * 
	 * @param urlTypeId
	 * @param params
	 * @param listener
	 * @param obj
	 */
	public static void requestGet(final int urlTypeId,RequestParams params,final RequestListener listener,final Object obj){  
		
		if(listener!=null){
			listener.onStart(urlTypeId, obj);
		}
		
        HttpUtils http = new HttpUtils();  
        http.configCurrentHttpCacheExpiry(1000 * 10);//设置超时时间  
        final String url =getRequestUrl(urlTypeId);
        
        http.send(HttpMethod.GET, url, params, new RequestCallBack<String>() {//接口回调  
  
        	@Override
        	public void onStart() {
        		super.onStart();
        	}
        	
        	@Override
        	public void onLoading(long total, long current, boolean isUploading) {
        		if(listener!=null){
        			listener.onLoading(urlTypeId, total, current, isUploading, obj);
        		}
        		super.onLoading(total, current, isUploading);
        	}
        	
        	@Override
        	public void onSuccess(ResponseInfo<String> responseInfo) {
        		LogUtil.i("HttpRequest", "statusCode="+responseInfo.statusCode+",result="+responseInfo.result);
        		if(listener!=null){
        			listener.onSuccess(urlTypeId, responseInfo.result, obj);
        		}
        	}
        	
        	@Override
        	public void onFailure(HttpException error, String msg) {
        		LogUtil.e("HttpRequest", "msg="+msg+",error="+error);
        		if(listener!=null){
        			listener.onFailure(urlTypeId, error, msg, obj);
        		}
        	}
        	
        });  
    }  
	
	public static void requestPost(int urlTypeId, RequestParams params,final RequestListener listener,final Object obj) {  
  
        HttpUtils http = new HttpUtils();  
        http.configCurrentHttpCacheExpiry(1000 * 10);  
        final String url =getRequestUrl(urlTypeId);
        http.send(HttpMethod.POST, url, params, new RequestCallBack<String>() {

        	@Override
        	public void onStart() {
        		LogUtil.i("HttpRequest", "requestPost onStart");
        		super.onStart();
        	}
        	
        	@Override
        	public void onLoading(long total, long current, boolean isUploading) {
        		LogUtil.i("HttpRequest", "requestPost onLoading");
        		super.onLoading(total, current, isUploading);
        	}
        	
			@Override
			public void onSuccess(ResponseInfo<String> responseInfo) {
				LogUtil.i("HttpRequest", "requestPost onSuccess");
				
			}

			@Override
			public void onFailure(HttpException error, String msg) {
				LogUtil.i("HttpRequest", "requestPost onFailure");
				
			}  
  
             
        });  
    }  
	
	
	/**
	 * 根据url类型获取请求的完整地址
	 * 
	 * @param urlTypeId
	 * @return
	 */
	public static String getRequestUrl(int urlTypeId){
		String url="";
		
		if(urlTypeId==R.id.url_request_login){
			url=baseUrl+"/user/login/xxx";
		}else if(urlTypeId==R.id.url_request_register){
			url=baseUrl+"/user/register/xxx";
		}else if(urlTypeId==R.id.url_request_change_pwd){
			url=baseUrl+"/user/changepwd/xxx";
		}else if(urlTypeId==R.id.url_request_weather_query){
			url="http://www.myexist.cn/song.php";
		}
		
		/** 加token **/
//		if(MyApp.mUserVo != null && !TextUtils.isEmpty(MyApp.mUserVo.getToken())){
//			url = url.concat("?token=" + MyApp.mUserVo.getToken());
//		}
		
		return url;
	}
	

}
