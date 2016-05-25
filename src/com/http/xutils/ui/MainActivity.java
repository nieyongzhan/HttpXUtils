package com.http.xutils.ui;

import com.http.xutils.R;
import com.http.xutils.interfaces.RequestListener;
import com.http.xutils.net.ServerRequest;
import com.lidroid.xutils.exception.HttpException;
import com.lidroid.xutils.http.RequestParams;
import com.lidroid.xutils.http.client.HttpRequest;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.TextView;


public class MainActivity extends Activity implements RequestListener {

	TextView result;
	Button btn_get;
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initListener();
        initData();
    }

	private void initView() {
		result=(TextView) findViewById(R.id.result);
		btn_get=(Button) findViewById(R.id.btn_get);
		
	}

	private void initListener() {
		btn_get.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				RequestParams params=new RequestParams();
				params.addQueryStringParameter("user", "zs");
				ServerRequest.requestGet(R.id.url_request_weather_query, params, MainActivity.this, null);
			}
		});
	}

	private void initData() {
		
	}

	@Override
	public void onStart(int urlTypeId, Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onLoading(int urlTypeId, long total, long current, boolean isUploading, Object obj) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void onSuccess(int urlTypeId, String responseString, Object obj) {
		// TODO Auto-generated method stub
		result.setText("result:"+responseString);
	}

	@Override
	public void onFailure(int urlTypeId, HttpException error, String msg, Object obj) {
		// TODO Auto-generated method stub
		
	}



}
