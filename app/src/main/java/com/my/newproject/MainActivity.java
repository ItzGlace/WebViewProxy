package com.my.newproject;

import android.app.Activity;
import android.app.*;
import android.os.*;
import android.view.*;
import android.view.View.*;
import android.widget.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.webkit.*;
import android.animation.*;
import android.view.animation.*;
import java.io.*;
import java.util.*;
import java.util.regex.*;
import java.text.*;
import org.json.*;
import android.widget.EditText;
import android.widget.Button;
import android.webkit.WebView;
import android.webkit.WebSettings;
import android.view.View;
import info.guardianproject.netcipher.webkit.*;
import android.app.Fragment;
import android.app.FragmentManager;
import android.app.DialogFragment;

public class MainActivity extends Activity {
	
	private String host = "";
	private String ip = "";
	
	private EditText edittext1;
	private EditText edittext2;
	private EditText edittext3;
	private Button button1;
	private WebView webview1;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		edittext1 = findViewById(R.id.edittext1);
		edittext2 = findViewById(R.id.edittext2);
		edittext3 = findViewById(R.id.edittext3);
		button1 = findViewById(R.id.button1);
		webview1 = findViewById(R.id.webview1);
		webview1.getSettings().setJavaScriptEnabled(true);
		webview1.getSettings().setSupportZoom(true);
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				host = edittext1.getText().toString();
				ip = edittext2.getText().toString();
				try {
					webview1.getSettings().setAppCacheMaxSize(5*1024*1024);
					webview1.getSettings().setAppCachePath(getApplicationContext().getCacheDir().getAbsolutePath());
					webview1.getSettings().setAllowFileAccess(true);
					webview1.getSettings().setAppCacheEnabled(true);
					webview1.getSettings().setCacheMode(WebSettings.LOAD_CACHE_ELSE_NETWORK);
					webview1.getSettings().setLoadWithOverviewMode(true);
					webview1.getSettings().setUseWideViewPort(true);
					webview1.getSettings().setLayoutAlgorithm(WebSettings.LayoutAlgorithm.SINGLE_COLUMN);
					webview1.getSettings().setDomStorageEnabled(true);
					webview1.getSettings().setSaveFormData(true);
					webview1.getSettings().setJavaScriptEnabled(true);
						webview1.getSettings().setJavaScriptCanOpenWindowsAutomatically(true);
						if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.JELLY_BEAN) {
								webview1.getSettings().setAllowFileAccessFromFileURLs(true); 
								webview1.getSettings().setAllowUniversalAccessFromFileURLs(true);
						}
						webview1.getSettings().setJavaScriptEnabled(true);
					if (WebkitProxy.setProxy(SketchApplication.class.getName(), getApplicationContext(), webview1,ip,Integer.valueOf(host))) {
						SketchwareUtil.showMessage(getApplicationContext(), "success");
					}
					else {
						SketchwareUtil.showMessage(getApplicationContext(), "failed");
					}
				} catch (Exception e) {
					SketchwareUtil.showMessage(getApplicationContext(), "failed");
				}
				webview1.loadUrl(edittext3.getText().toString());
			}
		});
		
		//no listener code
		
		//no listener code
		
		//no listener code
		
		webview1.setWebViewClient(new WebViewClient() {
			@Override
			public void onPageStarted(WebView _param1, String _param2, Bitmap _param3) {
				final String _url = _param2;
				
				super.onPageStarted(_param1, _param2, _param3);
			}
			
			@Override
			public void onPageFinished(WebView _param1, String _param2) {
				final String _url = _param2;
				
				super.onPageFinished(_param1, _param2);
			}
		});
	}
	
	private void initializeLogic() {
	}
	
	
	@Deprecated
	public void showMessage(String _s) {
		Toast.makeText(getApplicationContext(), _s, Toast.LENGTH_SHORT).show();
	}
	
	@Deprecated
	public int getLocationX(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[0];
	}
	
	@Deprecated
	public int getLocationY(View _v) {
		int _location[] = new int[2];
		_v.getLocationInWindow(_location);
		return _location[1];
	}
	
	@Deprecated
	public int getRandom(int _min, int _max) {
		Random random = new Random();
		return random.nextInt(_max - _min + 1) + _min;
	}
	
	@Deprecated
	public ArrayList<Double> getCheckedItemPositionsToArray(ListView _list) {
		ArrayList<Double> _result = new ArrayList<Double>();
		SparseBooleanArray _arr = _list.getCheckedItemPositions();
		for (int _iIdx = 0; _iIdx < _arr.size(); _iIdx++) {
			if (_arr.valueAt(_iIdx))
			_result.add((double)_arr.keyAt(_iIdx));
		}
		return _result;
	}
	
	@Deprecated
	public float getDip(int _input) {
		return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, _input, getResources().getDisplayMetrics());
	}
	
	@Deprecated
	public int getDisplayWidthPixels() {
		return getResources().getDisplayMetrics().widthPixels;
	}
	
	@Deprecated
	public int getDisplayHeightPixels() {
		return getResources().getDisplayMetrics().heightPixels;
	}
}