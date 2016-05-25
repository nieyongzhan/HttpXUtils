package com.http.xutils.ui;

import com.http.xutils.R;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;


public class MainActivity extends Activity {

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
		btn_get=(Button) findViewById(R.id.btn_get);
		
	}

	private void initListener() {
		btn_get.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				startActivity(new Intent(MainActivity.this,HttpUtilsActivity.class));
			}
		});
	}

	private void initData() {
		
	}

}
