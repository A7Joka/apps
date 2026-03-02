package com.HAKEEMO.PLAYER;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
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
import android.widget.LinearLayout;
import android.widget.ScrollView;
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
import com.google.firebase.FirebaseApp;
import dev.gerges.ParserM3U.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;
import android.view.ViewGroup.LayoutParams;

public class PrivacpolicyActivity extends AppCompatActivity {
	
	private LinearLayout linear1;
	private LinearLayout linear_status_bar;
	private TextView textview1;
	private LinearLayout linear3;
	private LinearLayout linear4;
	private ScrollView vscroll1;
	private LinearLayout linear2;
	private TextView textview2;
	private TextView textview3;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.privacpolicy);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		MobileAds.initialize(this);
		
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		linear_status_bar = findViewById(R.id.linear_status_bar);
		textview1 = findViewById(R.id.textview1);
		linear3 = findViewById(R.id.linear3);
		linear4 = findViewById(R.id.linear4);
		vscroll1 = findViewById(R.id.vscroll1);
		linear2 = findViewById(R.id.linear2);
		textview2 = findViewById(R.id.textview2);
		textview3 = findViewById(R.id.textview3);
		
		textview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				Intent w = new Intent(Intent.ACTION_SENDTO);
				w.setType("plain");
				w.setData(Uri.parse("mailto:al.hkeem.tv@gmail.com"));
				startActivity(w);
			}
		});
	}
	
	private void initializeLogic() {
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
		_TOP_BOTTOM_Gradient(linear1, "#072242", "#050A1A", 0, "#000000", 0, "#000000");
	}
	
	
	@Override
	public void onResume() {
		super.onResume();
		_setFullScreen();
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