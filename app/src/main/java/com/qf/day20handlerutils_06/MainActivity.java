package com.qf.day20handlerutils_06;


import java.util.ArrayList;
import java.util.List;

import com.qf.adapter.MyAdapter;
import com.qf.javaBean.Person;
import com.qf.listener.OnGetImageListener;
import com.qf.utils.HandlerUtils;

import android.os.Bundle;
import android.os.Handler;
import android.app.Activity;
import android.graphics.Bitmap;
import android.util.Log;
import android.view.Menu;
import android.widget.ImageView;
import android.widget.ListView;

public class MainActivity extends Activity implements OnGetImageListener{
	ListView listView;
	
	HandlerUtils handlerUtils;
	
	List<Person> data;//数据源
	MyAdapter adapter;	
	//定义一个Handler （回调完接收消息）  用来接收消息
	Handler handler=new Handler(){
		public void handleMessage(android.os.Message msg) {
			
			Bitmap bitmap=(Bitmap) msg.obj;
			Log.d("ddsd", ""+bitmap);
			String urlString=msg.getData().getString("url");
			ImageView imageView = (ImageView) listView.findViewWithTag(urlString); //从listview拿
			
			if (bitmap!=null&&imageView!=null) {
				imageView.setImageBitmap(bitmap);
			}
		};
	};
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initData();
       HandlerUtils handlerUtils=new HandlerUtils(handler);
        
        adapter=new MyAdapter(handlerUtils, this,data);
        listView.setAdapter(adapter);
    }
  
    String[] images={"http://img2.imgtn.bdimg.com/it/u=2059708553,255963759&fm=206&gp=0.jpg"
    			,"http://img0.imgtn.bdimg.com/it/u=3232463365,1553586369&fm=206&gp=0.jpg",
    			"http://img2.imgtn.bdimg.com/it/u=1023930876,2577057362&fm=206&gp=0.jpg",
    			"http://img4.imgtn.bdimg.com/it/u=2664351687,1345171687&fm=206&gp=0.jpg",
    			"http://img1.imgtn.bdimg.com/it/u=2749148122,2921708569&fm=206&gp=0.jpg",
    			"http://img1.imgtn.bdimg.com/it/u=1999548382,459746913&fm=206&gp=0.jpg",
    			"http://img1.imgtn.bdimg.com/it/u=3192461663,1356430848&fm=206&gp=0.jpg"};
    	


    private void initData() {
		// TODO Auto-generated method stub
		data=new ArrayList<Person>();
		Person name;
		for (int i = 0; i < 7; i++) {
			name=new Person("图片"+i,images[i]);
			data.add(name);
		}
	}


	private void initView() {
		// TODO Auto-generated method stub
		listView=(ListView) findViewById(R.id.listViewId);
	}


	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }


	@Override
	public void getImage(Bitmap bitmap) {
		// TODO 接口回调方法
		
	}
    
}
