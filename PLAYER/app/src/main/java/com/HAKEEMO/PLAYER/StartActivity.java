package com.HAKEEMO.PLAYER;

import android.animation.*;
import android.animation.ObjectAnimator;
import android.app.*;
import android.content.*;
import android.content.Intent;
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
import android.view.View.*;
import android.view.animation.*;
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.webkit.*;
import android.widget.*;
import android.widget.ImageView;
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
import com.google.firebase.FirebaseApp;
import dev.gerges.ParserM3U.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;

public class StartActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private LinearLayout linear4;
	private LinearLayout linear5;
	private ImageView imageview1;
	private LinearLayout linear7;
	private TextView textview1;
	
	private Intent i = new Intent();
	private TimerTask t;
	private ObjectAnimator object = new ObjectAnimator();
	private ObjectAnimator object2 = new ObjectAnimator();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.start);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		MobileAds.initialize(this);
		
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear4 = findViewById(R.id.linear4);
		linear5 = findViewById(R.id.linear5);
		imageview1 = findViewById(R.id.imageview1);
		linear7 = findViewById(R.id.linear7);
		textview1 = findViewById(R.id.textview1);
	}
	
	private void initializeLogic() {
		_TOP_BOTTOM_Gradient(linear4, "#072242", "#050A1A", 0, "#000000", 0, "#000000");
		if (true) {
			if (true) {
				if (true) {
					t = new TimerTask() {
						@Override
						public void run() {
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									i.setClass(getApplicationContext(), HomeActivity.class);
									startActivity(i);
								}
							});
						}
					};
					_timer.schedule(t, (int)(2500));
				}
				else {
					i.setClass(getApplicationContext(), MainActivity.class);
					i.putExtra("URL", getIntent().getStringExtra("player"));
					i.putExtra("User_agent", getIntent().getStringExtra("user_agent"));
					i.putExtra("Referer", getIntent().getStringExtra("referer"));
					i.putExtra("exit", getIntent().getStringExtra("player"));
					startActivity(i);
				}
			}
			else {
				i.setClass(getApplicationContext(), ChannelActivity.class);
				i.putExtra("link", getIntent().getStringExtra("iptv"));
				i.putExtra("User_agent", getIntent().getStringExtra("user_agent"));
				i.putExtra("exit", getIntent().getStringExtra("user_agent"));
				startActivity(i);
			}
		}
		else {
			i.setClass(getApplicationContext(), ChannelActivity.class);
			i.putExtra("link", getIntent().getStringExtra("web"));
			startActivity(i);
		}
		t = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						t = new TimerTask() {
							@Override
							public void run() {
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										textview1.setText("Loading.");
									}
								});
							}
						};
						_timer.schedule(t, (int)(200));
						t = new TimerTask() {
							@Override
							public void run() {
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										textview1.setText("Loading..");
									}
								});
							}
						};
						_timer.schedule(t, (int)(400));
						t = new TimerTask() {
							@Override
							public void run() {
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										textview1.setText("Loading...");
									}
								});
							}
						};
						_timer.schedule(t, (int)(600));
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(t, (int)(0), (int)(1200));
		object.setTarget(imageview1);
		object.setPropertyName("alpha");
		object.setFloatValues((float)(0), (float)(1));
		object.setDuration((int)(1200));
		object.start();
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