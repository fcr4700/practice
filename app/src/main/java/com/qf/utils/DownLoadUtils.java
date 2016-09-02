package com.qf.utils;
import java.io.IOException;
import android.util.Log;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
public class DownLoadUtils {
	public static String getJsonString(String url){
		String jString="";
		OkHttpClient ok=new OkHttpClient();
		Request request=new Request.Builder().url(url).build();
		try {
			Response response=ok.newCall(request).execute();
			jString=response.body().string();
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		Log.d("fcr", "下载json--"+jString);
		return jString;
	}
	public static byte[] getImage(String url){//图片下载
		byte[] b=null;
		OkHttpClient ok=new OkHttpClient();
		Request request=new Request.Builder().url(url).build();
		try {
			Response response=ok.newCall(request).execute();
			b=response.body().bytes();
			} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Log.d("fcr","下载byte：："+b);
		return b;
	}
}
