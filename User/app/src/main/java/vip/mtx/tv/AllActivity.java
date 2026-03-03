package vip.mtx.tv;

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
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnAdapterChangeListener;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.google.android.exoplayer2.ui.*;
import com.google.android.material.appbar.AppBarLayout;
import com.google.firebase.FirebaseApp;
import com.monstertechno.adblocker.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import meorg.jsoup.*;
import org.json.*;

public class AllActivity extends AppCompatActivity {
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	
	private LinearLayout back;
	private LinearLayout Top_line;
	private LinearLayout View;
	private LinearLayout line;
	private LinearLayout linear5;
	private ImageView imageview2;
	private ImageView logo;
	private ViewPager viewpager1;
	private LinearLayout line1;
	private LinearLayout line2;
	private LinearLayout line3;
	private LinearLayout line4;
	private LinearLayout line5;
	private ImageView img1;
	private TextView text1;
	private ImageView img2;
	private TextView text2;
	private ImageView img3;
	private TextView text3;
	private ImageView img4;
	private TextView text4;
	private ImageView img5;
	private TextView text5;
	
	private FaFragmentAdapter fa;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.all);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		_app_bar = findViewById(R.id._app_bar);
		_coordinator = findViewById(R.id._coordinator);
		_toolbar = findViewById(R.id._toolbar);
		setSupportActionBar(_toolbar);
		getSupportActionBar().setDisplayHomeAsUpEnabled(true);
		getSupportActionBar().setHomeButtonEnabled(true);
		_toolbar.setNavigationOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _v) {
				onBackPressed();
			}
		});
		back = findViewById(R.id.back);
		Top_line = findViewById(R.id.Top_line);
		View = findViewById(R.id.View);
		line = findViewById(R.id.line);
		linear5 = findViewById(R.id.linear5);
		imageview2 = findViewById(R.id.imageview2);
		logo = findViewById(R.id.logo);
		viewpager1 = findViewById(R.id.viewpager1);
		line1 = findViewById(R.id.line1);
		line2 = findViewById(R.id.line2);
		line3 = findViewById(R.id.line3);
		line4 = findViewById(R.id.line4);
		line5 = findViewById(R.id.line5);
		img1 = findViewById(R.id.img1);
		text1 = findViewById(R.id.text1);
		img2 = findViewById(R.id.img2);
		text2 = findViewById(R.id.text2);
		img3 = findViewById(R.id.img3);
		text3 = findViewById(R.id.text3);
		img4 = findViewById(R.id.img4);
		text4 = findViewById(R.id.text4);
		img5 = findViewById(R.id.img5);
		text5 = findViewById(R.id.text5);
		fa = new FaFragmentAdapter(getApplicationContext(), getSupportFragmentManager());
		
		viewpager1.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
			@Override
			public void onPageScrolled(int _position, float _positionOffset, int _positionOffsetPixels) {
				
			}
			
			@Override
			public void onPageSelected(int _position) {
				
			}
			
			@Override
			public void onPageScrollStateChanged(int _scrollState) {
				
			}
		});
		
		line1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				viewpager1.setCurrentItem((int)0);
			}
		});
		
		line2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				viewpager1.setCurrentItem((int)1);
			}
		});
		
		line3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				viewpager1.setCurrentItem((int)2);
			}
		});
		
		line4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				viewpager1.setCurrentItem((int)3);
			}
		});
		
		line5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				viewpager1.setCurrentItem((int)4);
			}
		});
	}
	
	private void initializeLogic() {
		fa.setTabCount(5);
		viewpager1.setAdapter(fa);
		if (viewpager1.getCurrentItem() == 0) {
			img1.setImageResource(R.drawable.img__5);
			img2.setImageResource(R.drawable.img__4);
			img3.setImageResource(R.drawable.img__1);
			img4.setImageResource(R.drawable.img__10);
			img5.setImageResource(R.drawable.img__8);
			_TransitionManager(line, 300);
		}
		if (viewpager1.getCurrentItem() == 1) {
			img1.setImageResource(R.drawable.img__6);
			img2.setImageResource(R.drawable.img__3);
			img3.setImageResource(R.drawable.img__1);
			img4.setImageResource(R.drawable.img__10);
			img5.setImageResource(R.drawable.img__8);
			_TransitionManager(line, 300);
		}
		if (viewpager1.getCurrentItem() == 2) {
			img1.setImageResource(R.drawable.img__6);
			img2.setImageResource(R.drawable.img__4);
			img3.setImageResource(R.drawable.img__2);
			img4.setImageResource(R.drawable.img__10);
			img5.setImageResource(R.drawable.img__8);
			_TransitionManager(line, 300);
		}
		if (viewpager1.getCurrentItem() == 3) {
			img1.setImageResource(R.drawable.img__6);
			img2.setImageResource(R.drawable.img__4);
			img3.setImageResource(R.drawable.img__1);
			img4.setImageResource(R.drawable.img__9);
			img5.setImageResource(R.drawable.img__8);
			_TransitionManager(line, 300);
		}
		if (viewpager1.getCurrentItem() == 4) {
			img1.setImageResource(R.drawable.img__6);
			img2.setImageResource(R.drawable.img__4);
			img3.setImageResource(R.drawable.img__1);
			img4.setImageResource(R.drawable.img__10);
			img5.setImageResource(R.drawable.img__7);
			_TransitionManager(line, 300);
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
				return new CategoryActivity();
			}
			if (_position == 1) {
				return new AflamActivity();
			}
			if (_position == 2) {
				return new LiveActivity();
			}
			if (_position == 3) {
				return new NewsActivity();
			}
			if (_position == 4) {
				return new ChampionshipActivity();
			}
			return null;
		}
	}
	
	@Override
	public void onPause() {
		super.onPause();
		if (viewpager1.getCurrentItem() == 0) {
			img1.setImageResource(R.drawable.img__5);
			img2.setImageResource(R.drawable.img__4);
			img3.setImageResource(R.drawable.img__1);
			img4.setImageResource(R.drawable.img__10);
			img5.setImageResource(R.drawable.img__8);
		}
		if (viewpager1.getCurrentItem() == 1) {
			img1.setImageResource(R.drawable.img__6);
			img2.setImageResource(R.drawable.img__3);
			img3.setImageResource(R.drawable.img__1);
			img4.setImageResource(R.drawable.img__10);
			img5.setImageResource(R.drawable.img__8);
		}
		if (viewpager1.getCurrentItem() == 2) {
			img1.setImageResource(R.drawable.img__6);
			img2.setImageResource(R.drawable.img__4);
			img3.setImageResource(R.drawable.img__2);
			img4.setImageResource(R.drawable.img__10);
			img5.setImageResource(R.drawable.img__8);
		}
		if (viewpager1.getCurrentItem() == 3) {
			img1.setImageResource(R.drawable.img__6);
			img2.setImageResource(R.drawable.img__4);
			img3.setImageResource(R.drawable.img__1);
			img4.setImageResource(R.drawable.img__9);
			img5.setImageResource(R.drawable.img__8);
		}
		if (viewpager1.getCurrentItem() == 4) {
			img1.setImageResource(R.drawable.img__6);
			img2.setImageResource(R.drawable.img__4);
			img3.setImageResource(R.drawable.img__1);
			img4.setImageResource(R.drawable.img__10);
			img5.setImageResource(R.drawable.img__7);
		}
	}
	
	@Override
	public void onResume() {
		super.onResume();
		if (viewpager1.getCurrentItem() == 0) {
			img1.setImageResource(R.drawable.img__5);
			img2.setImageResource(R.drawable.img__4);
			img3.setImageResource(R.drawable.img__1);
			img4.setImageResource(R.drawable.img__10);
			img5.setImageResource(R.drawable.img__8);
		}
		if (viewpager1.getCurrentItem() == 1) {
			img1.setImageResource(R.drawable.img__6);
			img2.setImageResource(R.drawable.img__3);
			img3.setImageResource(R.drawable.img__1);
			img4.setImageResource(R.drawable.img__10);
			img5.setImageResource(R.drawable.img__8);
		}
		if (viewpager1.getCurrentItem() == 2) {
			img1.setImageResource(R.drawable.img__6);
			img2.setImageResource(R.drawable.img__4);
			img3.setImageResource(R.drawable.img__2);
			img4.setImageResource(R.drawable.img__10);
			img5.setImageResource(R.drawable.img__8);
		}
		if (viewpager1.getCurrentItem() == 3) {
			img1.setImageResource(R.drawable.img__6);
			img2.setImageResource(R.drawable.img__4);
			img3.setImageResource(R.drawable.img__1);
			img4.setImageResource(R.drawable.img__9);
			img5.setImageResource(R.drawable.img__8);
		}
		if (viewpager1.getCurrentItem() == 4) {
			img1.setImageResource(R.drawable.img__6);
			img2.setImageResource(R.drawable.img__4);
			img3.setImageResource(R.drawable.img__1);
			img4.setImageResource(R.drawable.img__10);
			img5.setImageResource(R.drawable.img__7);
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