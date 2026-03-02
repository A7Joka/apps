package com.HAKEEMO.PLAYER;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.content.*;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.blogspot.atifsoftwares.animatoolib.*;
import com.google.android.exoplayer2.*;
import com.google.android.exoplayer2.ui.*;
import com.google.android.gms.ads.MobileAds;
import com.google.android.material.button.*;
import com.google.firebase.FirebaseApp;
import dev.gerges.ParserM3U.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;
import android.view.ViewGroup.LayoutParams;

public class AccepttermsActivity extends AppCompatActivity {
	
	private boolean privacypolicy = false;
	private boolean isagree = false;
	private boolean isAgreed2Policy = false;
	private boolean isAgreed2Terms = false;
	
	private LinearLayout linear26;
	private LinearLayout linear_status_bar;
	private TextView textview3;
	private LinearLayout linear23;
	private LinearLayout linear6;
	private LinearLayout linear19;
	private LinearLayout linear7;
	private LinearLayout linear24;
	private LinearLayout linear25;
	private CheckBox checkbox1;
	private TextView textview1;
	private CheckBox checkbox2;
	private TextView textview5;
	private MaterialButton btn2;
	private MaterialButton btn1;
	
	private Intent in = new Intent();
	private SharedPreferences Sp;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.acceptterms);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		MobileAds.initialize(this);
		
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear26 = findViewById(R.id.linear26);
		linear_status_bar = findViewById(R.id.linear_status_bar);
		textview3 = findViewById(R.id.textview3);
		linear23 = findViewById(R.id.linear23);
		linear6 = findViewById(R.id.linear6);
		linear19 = findViewById(R.id.linear19);
		linear7 = findViewById(R.id.linear7);
		linear24 = findViewById(R.id.linear24);
		linear25 = findViewById(R.id.linear25);
		checkbox1 = findViewById(R.id.checkbox1);
		textview1 = findViewById(R.id.textview1);
		checkbox2 = findViewById(R.id.checkbox2);
		textview5 = findViewById(R.id.textview5);
		btn2 = findViewById(R.id.btn2);
		btn1 = findViewById(R.id.btn1);
		Sp = getSharedPreferences("Sp", Activity.MODE_PRIVATE);
		
		checkbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					isAgreed2Policy = true;
				}
				else {
					isAgreed2Policy = false;
				}
			}
		});
		
		textview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				in.setClass(getApplicationContext(), PrivacpolicyActivity.class);
				startActivity(in);
			}
		});
		
		checkbox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					isAgreed2Terms = true;
				}
				else {
					isAgreed2Terms = false;
				}
			}
		});
		
		textview5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				in.setClass(getApplicationContext(), ConditionActivity.class);
				startActivity(in);
			}
		});
		
		btn2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (isAgreed2Policy && isAgreed2Terms) {
					Sp.edit().putString("onetime", "true").commit();
					in.setClass(getApplicationContext(), HomeActivity.class);
					startActivity(in);
				}
				else {
					
				}
			}
		});
		
		btn1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SketchwareUtil.showMessage(getApplicationContext(), "Understood.");
				finishAffinity();
			}
		});
	}
	
	private void initializeLogic() {
		_TOP_BOTTOM_Gradient(linear26, "#072242", "#050A1A", 0, "#000000", 0, "#000000");
		int statusBarHeight = 0;
		        int resourceId = getResources().getIdentifier("status_bar_height", "dimen", "android");
		        if (resourceId > 0) {
			            statusBarHeight = getResources().getDimensionPixelSize(resourceId);
			        }
		
		///
		
		LinearLayout layout = findViewById(R.id.linear_status_bar);
		// Gets the layout params that will allow you to resize the layout
		LayoutParams params = layout.getLayoutParams();
		// Changes the height and width to the specified *pixels*
		params.height = statusBarHeight;
		params.width = 100;
		layout.setLayoutParams(params);
	}
	
	@Override
	public void onResume() {
		super.onResume();
		_setFullScreen();
	}
	
	
	@Override
	public void onBackPressed() {
		finishAffinity();
	}
	public void _sx2(final View _view, final double _radius, final double _shadow, final String _color, final boolean _ripple) {
		if (_ripple) {
			android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
			gd.setColor(Color.parseColor(_color));
			gd.setCornerRadius((int)_radius);
			_view.setElevation((int)_shadow);
			
			android.content.res.ColorStateList clrb = new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{Color.parseColor("#212121")});
			android.graphics.drawable.RippleDrawable ripdrb = new android.graphics.drawable.RippleDrawable(clrb , gd, null);
			_view.setClickable(true);
			_view.setBackground(ripdrb);
		}
		else {
			android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
			gd.setColor(Color.parseColor(_color));
			gd.setCornerRadius((int)_radius);
			_view.setBackground(gd);
			_view.setElevation((int)_shadow);
		}
	}
	
	
	public void _TOP_BOTTOM_Gradient(final View _view, final String _color1, final String _color2, final double _stroke, final String _colorstroke, final double _intr, final String _ripple) {
		int[] colors = { Color.parseColor(_color1), Color.parseColor(_color2) }; android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM, colors); gd.setCornerRadius((int)_intr);
		gd.setStroke((int) _stroke, Color.parseColor(_colorstroke));
		android.content.res.ColorStateList clrb = new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{Color.parseColor(_ripple)});
		android.graphics.drawable.RippleDrawable ripdrb = new android.graphics.drawable.RippleDrawable(clrb , gd, null);
		_view.setBackground(ripdrb);
	}
	
	
	public void _setFullScreen() {
		try{
				
				Window w = this.getWindow();
				
				w.getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN);
				
				w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
				
				w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS); 
				
				w.setStatusBarColor(Color.parseColor("#00000000"));
				
				w.setNavigationBarColor(Color.parseColor("#50000000"));
				
				{
						getWindow().
						getDecorView().
						setSystemUiVisibility
						(  
						View.SYSTEM_UI_FLAG_LAYOUT_STABLE
						| View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
						| View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
						|
						View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
						); 
				}
				
				
				
		}catch (Exception e){}
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