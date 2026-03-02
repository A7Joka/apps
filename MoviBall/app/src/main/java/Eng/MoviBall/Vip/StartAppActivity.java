package Eng.MoviBall.Vip;

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
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.FirebaseApp;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;
import com.google.android.material.floatingactionbutton.ExtendedFloatingActionButton;

public class StartAppActivity extends AppCompatActivity {
	
	private ExtendedFloatingActionButton _fab;
	
	private LinearLayout bg;
	private LinearLayout linear_vp;
	private LinearLayout linear;
	private ViewPager viewpager1;
	private LinearLayout linear_page;
	private ImageView imageview1;
	private ImageView imageview2;
	private ImageView imageview3;
	private ImageView imageview4;
	private ImageView imageview5;
	
	private FAFragmentAdapter FA;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.start_app);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		_fab = findViewById(R.id._fab);
		
		bg = findViewById(R.id.bg);
		linear_vp = findViewById(R.id.linear_vp);
		linear = findViewById(R.id.linear);
		viewpager1 = findViewById(R.id.viewpager1);
		linear_page = findViewById(R.id.linear_page);
		imageview1 = findViewById(R.id.imageview1);
		imageview2 = findViewById(R.id.imageview2);
		imageview3 = findViewById(R.id.imageview3);
		imageview4 = findViewById(R.id.imageview4);
		imageview5 = findViewById(R.id.imageview5);
		FA = new FAFragmentAdapter(getApplicationContext(), getSupportFragmentManager());
		
		viewpager1.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(int _position, float _positionOffset, int _positionOffsetPixels) {
				if (viewpager1.getCurrentItem() == 0) {
					_fab.hide();
					linear.setVisibility(View.VISIBLE);
					imageview1.setImageResource(R.drawable.circle_2);
					imageview2.setImageResource(R.drawable.circle_1);
					imageview3.setImageResource(R.drawable.circle_1);
					imageview4.setImageResource(R.drawable.circle_1);
					imageview5.setImageResource(R.drawable.circle_1);
					_TransitionManager(bg, 300);
				}
				if (viewpager1.getCurrentItem() == 1) {
					_fab.hide();
					linear.setVisibility(View.VISIBLE);
					imageview1.setImageResource(R.drawable.circle_1);
					imageview2.setImageResource(R.drawable.circle_2);
					imageview3.setImageResource(R.drawable.circle_1);
					imageview4.setImageResource(R.drawable.circle_1);
					imageview5.setImageResource(R.drawable.circle_1);
					_TransitionManager(bg, 300);
				}
				if (viewpager1.getCurrentItem() == 2) {
					_fab.hide();
					linear.setVisibility(View.VISIBLE);
					imageview1.setImageResource(R.drawable.circle_1);
					imageview2.setImageResource(R.drawable.circle_1);
					imageview3.setImageResource(R.drawable.circle_2);
					imageview4.setImageResource(R.drawable.circle_1);
					imageview5.setImageResource(R.drawable.circle_1);
					_TransitionManager(bg, 300);
				}
				if (viewpager1.getCurrentItem() == 3) {
					_fab.show();
					linear.setVisibility(View.VISIBLE);
					imageview1.setImageResource(R.drawable.circle_1);
					imageview2.setImageResource(R.drawable.circle_1);
					imageview3.setImageResource(R.drawable.circle_1);
					imageview4.setImageResource(R.drawable.circle_2);
					imageview5.setImageResource(R.drawable.circle_1);
					_TransitionManager(bg, 300);
				}
				if (viewpager1.getCurrentItem() == 4) {
					_fab.hide();
					linear.setVisibility(View.GONE);
					imageview1.setImageResource(R.drawable.circle_1);
					imageview2.setImageResource(R.drawable.circle_1);
					imageview3.setImageResource(R.drawable.circle_1);
					imageview4.setImageResource(R.drawable.circle_1);
					imageview5.setImageResource(R.drawable.circle_2);
					_TransitionManager(bg, 300);
				}
			}
			
			@Override
			public void onPageSelected(int _position) {
				
			}
			
			@Override
			public void onPageScrollStateChanged(int _scrollState) {
				
			}
		});
		
		_fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				final com.google.android.material.bottomsheet.BottomSheetDialog bottomSheetDialog = new com.google.android.material.bottomsheet.BottomSheetDialog(StartAppActivity.this);
				
				View bottomSheetView; bottomSheetView = getLayoutInflater().inflate(R.layout.start_app_setting,null );
				bottomSheetDialog.setContentView(bottomSheetView);
				
				bottomSheetDialog.getWindow().findViewById(R.id.design_bottom_sheet).setBackgroundResource(android.R.color.transparent);
				LinearLayout bg = (LinearLayout) bottomSheetView.findViewById(R.id.bg);
				
				 LinearLayout up = (LinearLayout) bottomSheetView.findViewById(R.id.up);
				
				LinearLayout linear_1 = (LinearLayout) bottomSheetView.findViewById(R.id.linear_1);
				
				LinearLayout linear_2 = (LinearLayout) bottomSheetView.findViewById(R.id.linear_2);
				
				LinearLayout linear_3 = (LinearLayout) bottomSheetView.findViewById(R.id.linear_3);
				_SX_CornerRadius_4(bg, "#FFFFFF", "#FFFFFF", 0, 35, 35, 0, 0);
				_Round(up, 20);
				_Round(linear_1, 20);
				_Round(linear_2, 20);
				_Round(linear_3, 20);
				bottomSheetDialog.dismiss();
				bottomSheetDialog.setCancelable(true);
				bottomSheetDialog.show();
			}
		});
	}
	
	private void initializeLogic() {
		FA.setTabCount(5);
		viewpager1.setAdapter(FA);
		if (viewpager1.getCurrentItem() == 0) {
			_fab.hide();
			imageview1.setImageResource(R.drawable.circle_2);
			imageview2.setImageResource(R.drawable.circle_1);
			imageview3.setImageResource(R.drawable.circle_1);
			imageview4.setImageResource(R.drawable.circle_1);
			imageview5.setImageResource(R.drawable.circle_1);
			_TransitionManager(bg, 300);
		}
		if (viewpager1.getCurrentItem() == 1) {
			_fab.hide();
			imageview1.setImageResource(R.drawable.circle_1);
			imageview2.setImageResource(R.drawable.circle_2);
			imageview3.setImageResource(R.drawable.circle_1);
			imageview4.setImageResource(R.drawable.circle_1);
			imageview5.setImageResource(R.drawable.circle_1);
			_TransitionManager(bg, 300);
		}
		if (viewpager1.getCurrentItem() == 2) {
			_fab.hide();
			imageview1.setImageResource(R.drawable.circle_1);
			imageview2.setImageResource(R.drawable.circle_1);
			imageview3.setImageResource(R.drawable.circle_2);
			imageview4.setImageResource(R.drawable.circle_1);
			imageview5.setImageResource(R.drawable.circle_1);
			_TransitionManager(bg, 300);
		}
		if (viewpager1.getCurrentItem() == 3) {
			_fab.show();
			imageview1.setImageResource(R.drawable.circle_1);
			imageview2.setImageResource(R.drawable.circle_1);
			imageview3.setImageResource(R.drawable.circle_1);
			imageview4.setImageResource(R.drawable.circle_2);
			imageview5.setImageResource(R.drawable.circle_1);
			_TransitionManager(bg, 300);
		}
		if (viewpager1.getCurrentItem() == 4) {
			_fab.hide();
			imageview1.setImageResource(R.drawable.circle_1);
			imageview2.setImageResource(R.drawable.circle_1);
		}
	}
	
	public class FAFragmentAdapter extends FragmentStatePagerAdapter {
		// This class is deprecated, you should migrate to ViewPager2:
		// https://developer.android.com/reference/androidx/viewpager2/widget/ViewPager2
		Context context;
		int tabCount;
		
		public FAFragmentAdapter(Context context, FragmentManager manager) {
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
				return new Frag1FragmentActivity();
			}
			if (_position == 1) {
				return new Frag2FragmentActivity();
			}
			if (_position == 2) {
				return new Frag3FragmentActivity();
			}
			if (_position == 3) {
				return new Frag4FragmentActivity();
			}
			if (_position == 4) {
				return new Frag5FragmentActivity();
			}
			return null;
		}
	}
	
	public void _TransitionManager(final View _view, final double _duration) {
		LinearLayout viewgroup =(LinearLayout) _view;
		
		android.transition.AutoTransition autoTransition = new android.transition.AutoTransition(); autoTransition.setDuration((long)_duration); android.transition.TransitionManager.beginDelayedTransition(viewgroup, autoTransition);
	}
	
	
	public void _SX_CornerRadius_4(final View _view, final String _color1, final String _color2, final double _str, final double _n1, final double _n2, final double _n3, final double _n4) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		
		gd.setColor(Color.parseColor(_color1));
		
		gd.setStroke((int)_str, Color.parseColor(_color2));
		
		gd.setCornerRadii(new float[]{(int)_n1,(int)_n1,(int)_n2,(int)_n2,(int)_n3,(int)_n3,(int)_n4,(int)_n4});
		
		_view.setBackground(gd);
		
		_view.setElevation(8);
	}
	
	
	public void _Round(final View _viewRound, final double _viewRoundSetRadius) {
		// hevo team
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		
		// hevo team
		android.graphics.drawable.ColorDrawable cd = new android.graphics.drawable.ColorDrawable();
		
		cd = (android.graphics.drawable.ColorDrawable)_viewRound.getBackground();
		
		int colorId = cd.getColor();
		gd.setColor(colorId);
		gd.setCornerRadius((int)_viewRoundSetRadius);
		_viewRound.setBackground(gd);
		
		// hevo team
	}
	
	
	public void _RoundandShadow(final double _Radius, final double _Elevation, final String _color, final View _v) {
		float r = (float) _Radius;
		float e = (float) _Elevation;
		_v.setElevation(e);
		android.graphics.drawable.GradientDrawable s=new android.graphics.drawable.GradientDrawable();
		s.setColor(Color.parseColor(_color));
		s.setCornerRadius(r);
		_v.setBackground(s);
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