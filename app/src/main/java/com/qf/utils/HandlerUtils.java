package com.qf.utils;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class HandlerUtils {
	Handler handler;
	
	//线程池
	public static ExecutorService executor=Executors.newFixedThreadPool(10);//创建一个固定数量线程的。。
	public HandlerUtils(Handler handler) {
		super();
		this.handler = handler;
	}



	public  void downLoadImage(final String url){
		//线程池分配一个子线程
		executor.execute(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				byte[] imageByte=DownLoadUtils.getImage(url);//下载成功
				//转换成一个bitmap
				Bitmap bitmap=BitmapFactory.decodeByteArray(imageByte, 0, imageByte.length);
				//用handler来处理
				Message msg=Message.obtain();
				//msg.what=1;
				msg.obj=bitmap;
				
				Bundle bundle=new Bundle();
				bundle.putString("url", url);
				msg.setData(bundle);
				//Handler.sen....
				handler.sendMessage(msg);
				
			}
		});
	}
}
