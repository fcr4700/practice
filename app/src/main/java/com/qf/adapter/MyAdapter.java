package com.qf.adapter;

import java.util.List;

import com.qf.day20handlerutils_06.R;
import com.qf.javaBean.Person;
import com.qf.listener.OnGetImageListener;
import com.qf.utils.HandlerUtils;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

public class MyAdapter extends BaseAdapter {
	Context context;
	List<Person> list;
	HandlerUtils handlerUtils;
	
	OnGetImageListener onGetImageListener;
	
	public MyAdapter(HandlerUtils handlerUtils,Context context, List<Person> list) {
		super();
		this.context = context;
		this.list = list;
		this.handlerUtils=handlerUtils;
		if (context instanceof OnGetImageListener) {
			onGetImageListener=(OnGetImageListener) context;
		}
	}

	@Override
	public int getCount() {
		// TODO Auto-generated method stub
		return list.size();
	}

	@Override
	public Object getItem(int position) {
		// TODO Auto-generated method stub
		return list.get(position);
	}

	@Override
	public long getItemId(int position) {
		// TODO Auto-generated method stub
		return position;
	}

	@Override
	public View getView(int position, View convertView, ViewGroup parent) {
		// TODO 
		ViewHodler vHodler=null;
		if (convertView==null) {
			convertView=LayoutInflater.from(context).inflate(R.layout.item_list, null);
			vHodler=new ViewHodler();
			vHodler.textView=(TextView) convertView.findViewById(R.id.nameId);
			vHodler.imageView=(ImageView) convertView.findViewById(R.id.imageId);
			convertView.setTag(vHodler);
		}else {
			vHodler=(ViewHodler) convertView.getTag();
		}
		vHodler.textView.setText(list.get(position).getName());
		//图片链接
		String imageUrlString=list.get(position).getImageUrl();//得到图片的URL  使用接口回调
		vHodler.imageView.setTag(imageUrlString);//设置标识  在MainActivity-->handler
		//
		handlerUtils.downLoadImage(imageUrlString);//调用的工具类的方法
		//vHodler.imageView.setImageResource(list.get(position).getImageUrl());
		return convertView;
	}
	class ViewHodler{
		TextView textView;
		ImageView imageView;
	}
}
