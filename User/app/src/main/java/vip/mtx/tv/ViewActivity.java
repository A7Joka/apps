package vip.mtx.tv;

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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnAdapterChangeListener;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.google.android.exoplayer2.ui.*;
import com.google.firebase.FirebaseApp;
import com.monstertechno.adblocker.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import meorg.jsoup.*;
import org.json.*;

public class ViewActivity extends AppCompatActivity {
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear3;
	private ViewPager viewpager1;
	private LinearLayout linear;
	private LinearLayout linear9;
	private LinearLayout linear_theme;
	private LinearLayout linear_view;
	private LinearLayout linear_language;
	private TextView textview2;
	private TextView textview3;
	private TextView textview1;
	private LinearLayout linear7;
	private LinearLayout linear10;
	private ImageView imageview1;
	private ImageView imageview2;
	private ImageView imageview3;
	private ImageView imageview4;
	private ImageView imageview5;
	
	private FaFragmentAdapter fa;
	private Intent it = new Intent();
	private SharedPreferences settings;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.view);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		linear2 = findViewById(R.id.linear2);
		linear3 = findViewById(R.id.linear3);
		viewpager1 = findViewById(R.id.viewpager1);
		linear = findViewById(R.id.linear);
		linear9 = findViewById(R.id.linear9);
		linear_theme = findViewById(R.id.linear_theme);
		linear_view = findViewById(R.id.linear_view);
		linear_language = findViewById(R.id.linear_language);
		textview2 = findViewById(R.id.textview2);
		textview3 = findViewById(R.id.textview3);
		textview1 = findViewById(R.id.textview1);
		linear7 = findViewById(R.id.linear7);
		linear10 = findViewById(R.id.linear10);
		imageview1 = findViewById(R.id.imageview1);
		imageview2 = findViewById(R.id.imageview2);
		imageview3 = findViewById(R.id.imageview3);
		imageview4 = findViewById(R.id.imageview4);
		imageview5 = findViewById(R.id.imageview5);
		fa = new FaFragmentAdapter(getApplicationContext(), getSupportFragmentManager());
		settings = getSharedPreferences("settings", Activity.MODE_PRIVATE);
		
		viewpager1.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(int _position, float _positionOffset, int _positionOffsetPixels) {
				
			}
			
			@Override
			public void onPageSelected(int _position) {
				
			}
			
			@Override
			public void onPageScrollStateChanged(int _scrollState) {
				if (viewpager1.getCurrentItem() == 0) {
					_TransitionManager(linear1, 300);
					linear.setVisibility(View.GONE);
					linear3.setVisibility(View.VISIBLE);
					imageview1.setImageResource(R.drawable.circle_2);
					imageview2.setImageResource(R.drawable.circle_1);
					imageview3.setImageResource(R.drawable.circle_1);
					imageview4.setImageResource(R.drawable.circle_1);
					imageview5.setImageResource(R.drawable.circle_1);
				}
				if (viewpager1.getCurrentItem() == 1) {
					_TransitionManager(linear1, 300);
					linear.setVisibility(View.GONE);
					linear3.setVisibility(View.VISIBLE);
					imageview1.setImageResource(R.drawable.circle_1);
					imageview2.setImageResource(R.drawable.circle_2);
					imageview3.setImageResource(R.drawable.circle_1);
					imageview4.setImageResource(R.drawable.circle_1);
					imageview5.setImageResource(R.drawable.circle_1);
				}
				if (viewpager1.getCurrentItem() == 2) {
					_TransitionManager(linear1, 300);
					linear.setVisibility(View.GONE);
					linear3.setVisibility(View.VISIBLE);
					imageview1.setImageResource(R.drawable.circle_1);
					imageview2.setImageResource(R.drawable.circle_1);
					imageview3.setImageResource(R.drawable.circle_2);
					imageview4.setImageResource(R.drawable.circle_1);
					imageview5.setImageResource(R.drawable.circle_1);
				}
				if (viewpager1.getCurrentItem() == 3) {
					_TransitionManager(linear1, 300);
					linear.setVisibility(View.VISIBLE);
					linear3.setVisibility(View.VISIBLE);
					linear_theme.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)5, 0xFFEEEEEE));
					linear_language.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)5, 0xFFEEEEEE));
					linear_view.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)5, 0xFFEEEEEE));
					imageview1.setImageResource(R.drawable.circle_1);
					imageview2.setImageResource(R.drawable.circle_1);
					imageview3.setImageResource(R.drawable.circle_1);
					imageview4.setImageResource(R.drawable.circle_2);
					imageview5.setImageResource(R.drawable.circle_1);
				}
				if (viewpager1.getCurrentItem() == 4) {
					_TransitionManager(linear1, 300);
					linear.setVisibility(View.GONE);
					linear3.setVisibility(View.GONE);
					imageview1.setImageResource(R.drawable.circle_1);
					imageview2.setImageResource(R.drawable.circle_1);
					imageview3.setImageResource(R.drawable.circle_1);
					imageview4.setImageResource(R.drawable.circle_1);
					imageview5.setImageResource(R.drawable.circle_2);
				}
			}
		});
		
		linear_theme.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final AlertDialog dialog1 = new AlertDialog.Builder(ViewActivity.this).create();
				View inflate = getLayoutInflater().inflate(R.layout.dialog,null); 
				dialog1.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
				dialog1.setView(inflate);
				TextView text_1 = (TextView) inflate.findViewById(R.id.text_1);
				
				TextView text_ar = (TextView) inflate.findViewById(R.id.text_ar);
				
				TextView text_en = (TextView) inflate.findViewById(R.id.text_en);
				
				LinearLayout linear1 = (LinearLayout) inflate.findViewById(R.id.linear1);
				text_1.setText("الثيمات");
				text_ar.setText("الوضع الداكن - Dark Mode");
				text_en.setText("الوضع المضيء - Light Mode");
				text_ar.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
						SketchwareUtil.showMessage(getApplicationContext(), "Dark");
						settings.edit().putString("theme", "Dark").commit();
						dialog1.dismiss();
					}
				});
				text_en.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
						SketchwareUtil.showMessage(getApplicationContext(), "Light");
						settings.edit().putString("theme", "Light").commit();
						dialog1.dismiss();
					}
				});
				dialog1.setCancelable(true);
				dialog1.show();
				linear1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF78022C));
			}
		});
		
		linear_view.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final AlertDialog dialog1 = new AlertDialog.Builder(ViewActivity.this).create();
				View inflate = getLayoutInflater().inflate(R.layout.dialog,null); 
				dialog1.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
				dialog1.setView(inflate);
				TextView text_1 = (TextView) inflate.findViewById(R.id.text_1);
				
				TextView text_ar = (TextView) inflate.findViewById(R.id.text_ar);
				
				TextView text_en = (TextView) inflate.findViewById(R.id.text_en);
				
				LinearLayout linear1 = (LinearLayout) inflate.findViewById(R.id.linear1);
				text_1.setText("وضع المشاهدة");
				text_ar.setText("Mobile");
				text_en.setText("TV Box - Smart TV");
				text_ar.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
						SketchwareUtil.showMessage(getApplicationContext(), "Mobile");
						settings.edit().putString("view", "Mobile").commit();
						dialog1.dismiss();
					}
				});
				text_en.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
						SketchwareUtil.showMessage(getApplicationContext(), "TV Box - Smart TV");
						settings.edit().putString("view", "TV").commit();
						dialog1.dismiss();
					}
				});
				dialog1.setCancelable(true);
				dialog1.show();
				linear1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF78022C));
			}
		});
		
		linear_language.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final AlertDialog dialog1 = new AlertDialog.Builder(ViewActivity.this).create();
				View inflate = getLayoutInflater().inflate(R.layout.dialog,null); 
				dialog1.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
				dialog1.setView(inflate);
				TextView text_1 = (TextView) inflate.findViewById(R.id.text_1);
				
				TextView text_ar = (TextView) inflate.findViewById(R.id.text_ar);
				
				TextView text_en = (TextView) inflate.findViewById(R.id.text_en);
				
				LinearLayout linear1 = (LinearLayout) inflate.findViewById(R.id.linear1);
				text_1.setText("اللغات");
				text_ar.setText("العربية");
				text_en.setText("English");
				text_ar.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
						settings.edit().putString("language", "AR").commit();
						SketchwareUtil.showMessage(getApplicationContext(), "العربية");
						dialog1.dismiss();
					}
				});
				text_en.setOnClickListener(new View.OnClickListener(){ public void onClick(View v){
						settings.edit().putString("language", "EN").commit();
						SketchwareUtil.showMessage(getApplicationContext(), "English");
						dialog1.dismiss();
					}
				});
				dialog1.setCancelable(true);
				dialog1.show();
				linear1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF78022C));
			}
		});
	}
	
	private void initializeLogic() {
		fa.setTabCount(5);
		viewpager1.setAdapter(fa);
		if (viewpager1.getCurrentItem() == 0) {
			imageview1.setImageResource(R.drawable.circle_2);
			imageview2.setImageResource(R.drawable.circle_1);
			imageview3.setImageResource(R.drawable.circle_1);
			imageview4.setImageResource(R.drawable.circle_1);
			imageview5.setImageResource(R.drawable.circle_1);
			_TransitionManager(linear1, 300);
		}
		if (viewpager1.getCurrentItem() == 1) {
			imageview1.setImageResource(R.drawable.circle_1);
			imageview2.setImageResource(R.drawable.circle_2);
			imageview3.setImageResource(R.drawable.circle_1);
			imageview4.setImageResource(R.drawable.circle_1);
			imageview5.setImageResource(R.drawable.circle_1);
			_TransitionManager(linear1, 300);
		}
		if (viewpager1.getCurrentItem() == 2) {
			imageview1.setImageResource(R.drawable.circle_1);
			imageview2.setImageResource(R.drawable.circle_1);
			imageview3.setImageResource(R.drawable.circle_2);
			imageview4.setImageResource(R.drawable.circle_1);
			imageview5.setImageResource(R.drawable.circle_1);
			_TransitionManager(linear1, 300);
		}
		if (viewpager1.getCurrentItem() == 3) {
			imageview1.setImageResource(R.drawable.circle_1);
			imageview2.setImageResource(R.drawable.circle_1);
			imageview3.setImageResource(R.drawable.circle_1);
			imageview4.setImageResource(R.drawable.circle_2);
			imageview5.setImageResource(R.drawable.circle_1);
			
			
			_TransitionManager(linear1, 300);
			linear.setVisibility(View.VISIBLE);
		}
		if (viewpager1.getCurrentItem() == 4) {
			imageview1.setImageResource(R.drawable.circle_1);
			imageview2.setImageResource(R.drawable.circle_1);
			imageview3.setImageResource(R.drawable.circle_1);
			imageview4.setImageResource(R.drawable.circle_1);
			imageview5.setImageResource(R.drawable.circle_2);
			_TransitionManager(linear1, 300);
		}
	}
	
	public class FaFragmentAdapter extends FragmentStatePagerAdapter {
		// This class is deprecated, you should migrate to ViewPager2:
		// https://developer.android.com/reference/androidx/viewpager2/widget/ViewPager2
		Context context;
		int tabCount;
		
		public FaFragmentAdapter(Context context, FragmentManager manager) {
			super(manager);
			this.context = context;
		}
		
		public void setTabCount(int tabCount) {
			this.tabCount = tabCount;
		}
		
		@Override
		public int getCount() {
			return tabCount;
		}
		
		@Override
		public CharSequence getPageTitle(int _position) {
			
			return null;
		}
		
		@Override
		public Fragment getItem(int _position) {
			if (_position == 0) {
				return new Page1FragmentActivity();
			}
			if (_position == 1) {
				return new Page2FragmentActivity();
			}
			if (_position == 2) {
				return new Page3FragmentActivity();
			}
			if (_position == 3) {
				return new Page4FragmentActivity();
			}
			if (_position == 4) {
				return new Page5FragmentActivity();
			}
			return null;
		}
	}
	
	@Override
	public void onResume() {
		super.onResume();
		if (viewpager1.getCurrentItem() == 0) {
			imageview1.setImageResource(R.drawable.circle_2);
			imageview2.setImageResource(R.drawable.circle_1);
			imageview3.setImageResource(R.drawable.circle_1);
			imageview4.setImageResource(R.drawable.circle_1);
			imageview5.setImageResource(R.drawable.circle_1);
			
			
		}
		if (viewpager1.getCurrentItem() == 1) {
			imageview1.setImageResource(R.drawable.circle_1);
			imageview2.setImageResource(R.drawable.circle_2);
			imageview3.setImageResource(R.drawable.circle_1);
			imageview4.setImageResource(R.drawable.circle_1);
			imageview5.setImageResource(R.drawable.circle_1);
			
			
		}
		if (viewpager1.getCurrentItem() == 2) {
			imageview1.setImageResource(R.drawable.circle_1);
			imageview2.setImageResource(R.drawable.circle_1);
			imageview3.setImageResource(R.drawable.circle_2);
			imageview4.setImageResource(R.drawable.circle_1);
			imageview5.setImageResource(R.drawable.circle_1);
			
			
		}
		if (viewpager1.getCurrentItem() == 3) {
			imageview1.setImageResource(R.drawable.circle_1);
			imageview2.setImageResource(R.drawable.circle_1);
			imageview3.setImageResource(R.drawable.circle_1);
			imageview4.setImageResource(R.drawable.circle_2);
			imageview5.setImageResource(R.drawable.circle_1);
			
			
		}
		if (viewpager1.getCurrentItem() == 4) {
			imageview1.setImageResource(R.drawable.circle_1);
			imageview2.setImageResource(R.drawable.circle_1);
			imageview3.setImageResource(R.drawable.circle_1);
			imageview4.setImageResource(R.drawable.circle_1);
			imageview5.setImageResource(R.drawable.circle_2);
			
			
		}
	}
	
	@Override
	public void onPause() {
		super.onPause();
		if (viewpager1.getCurrentItem() == 0) {
			imageview1.setImageResource(R.drawable.circle_2);
			imageview2.setImageResource(R.drawable.circle_1);
			imageview3.setImageResource(R.drawable.circle_1);
			imageview4.setImageResource(R.drawable.circle_1);
			imageview5.setImageResource(R.drawable.circle_1);
			
			
			_TransitionManager(linear1, 300);
			linear.setVisibility(View.GONE);
		}
		if (viewpager1.getCurrentItem() == 1) {
			imageview1.setImageResource(R.drawable.circle_1);
			imageview2.setImageResource(R.drawable.circle_2);
			imageview3.setImageResource(R.drawable.circle_1);
			imageview4.setImageResource(R.drawable.circle_1);
			imageview5.setImageResource(R.drawable.circle_1);
			
			
			_TransitionManager(linear1, 300);
			linear.setVisibility(View.GONE);
		}
		if (viewpager1.getCurrentItem() == 2) {
			imageview1.setImageResource(R.drawable.circle_1);
			imageview2.setImageResource(R.drawable.circle_1);
			imageview3.setImageResource(R.drawable.circle_2);
			imageview4.setImageResource(R.drawable.circle_1);
			imageview5.setImageResource(R.drawable.circle_1);
			
			
			_TransitionManager(linear1, 300);
			linear.setVisibility(View.GONE);
		}
		if (viewpager1.getCurrentItem() == 3) {
			imageview1.setImageResource(R.drawable.circle_1);
			imageview2.setImageResource(R.drawable.circle_1);
			imageview3.setImageResource(R.drawable.circle_1);
			imageview4.setImageResource(R.drawable.circle_2);
			imageview5.setImageResource(R.drawable.circle_1);
			
			
			_TransitionManager(linear1, 300);
			linear.setVisibility(View.VISIBLE);
		}
		if (viewpager1.getCurrentItem() == 4) {
			imageview1.setImageResource(R.drawable.circle_1);
			imageview2.setImageResource(R.drawable.circle_1);
			imageview3.setImageResource(R.drawable.circle_1);
			imageview4.setImageResource(R.drawable.circle_1);
			imageview5.setImageResource(R.drawable.circle_2);
			
			
			_TransitionManager(linear1, 300);
			linear.setVisibility(View.GONE);
		}
	}
	public void _TransitionManager(final View _view, final double _duration) {
		LinearLayout viewgroup =(LinearLayout) _view;
		
		android.transition.AutoTransition autoTransition = new android.transition.AutoTransition(); autoTransition.setDuration((long)_duration); android.transition.TransitionManager.beginDelayedTransition(viewgroup, autoTransition);
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