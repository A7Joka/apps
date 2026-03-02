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
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.viewpager.widget.PagerAdapter;
import androidx.viewpager.widget.ViewPager;
import androidx.viewpager.widget.ViewPager.OnAdapterChangeListener;
import androidx.viewpager.widget.ViewPager.OnPageChangeListener;
import com.google.android.material.appbar.AppBarLayout;
import com.google.firebase.FirebaseApp;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;

public class HomeActivity extends AppCompatActivity {
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private DrawerLayout _drawer;
	
	private LinearLayout bg;
	private LinearLayout linear1;
	private ScrollView vsc;
	private LinearLayout BN;
	private ImageView TimgL;
	private ImageView TimgC;
	private LinearLayout linear_view;
	private ViewPager VP;
	private LinearLayout back1;
	private LinearLayout back2;
	private LinearLayout back3;
	private LinearLayout back4;
	private LinearLayout back5;
	private LinearLayout b1;
	private LinearLayout above1;
	private ImageView img1;
	private TextView t1;
	private LinearLayout b2;
	private LinearLayout above2;
	private ImageView img2;
	private TextView t2;
	private LinearLayout b3;
	private LinearLayout above3;
	private ImageView img3;
	private TextView t3;
	private LinearLayout b4;
	private LinearLayout above4;
	private ImageView img4;
	private TextView t4;
	private LinearLayout b5;
	private LinearLayout above5;
	private ImageView img5;
	private TextView t5;
	private LinearLayout _drawer_lin_draw;
	private LinearLayout _drawer_back;
	private LinearLayout _drawer_button1;
	private LinearLayout _drawer_button2;
	private LinearLayout _drawer_button3;
	private LinearLayout _drawer_button4;
	private LinearLayout _drawer_button5;
	private LinearLayout _drawer_button6;
	private LinearLayout _drawer_img1;
	private TextView _drawer_t1;
	private LinearLayout _drawer_img2;
	private TextView _drawer_t2;
	private LinearLayout _drawer_img3;
	private TextView _drawer_t3;
	private LinearLayout _drawer_img4;
	private TextView _drawer_t4;
	private LinearLayout _drawer_img5;
	private TextView _drawer_t5;
	private LinearLayout _drawer_img6;
	private TextView _drawer_t6;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.home);
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
		_drawer = findViewById(R.id._drawer);
		ActionBarDrawerToggle _toggle = new ActionBarDrawerToggle(HomeActivity.this, _drawer, _toolbar, R.string.app_name, R.string.app_name);
		_drawer.addDrawerListener(_toggle);
		_toggle.syncState();
		
		LinearLayout _nav_view = findViewById(R.id._nav_view);
		
		bg = findViewById(R.id.bg);
		linear1 = findViewById(R.id.linear1);
		vsc = findViewById(R.id.vsc);
		BN = findViewById(R.id.BN);
		TimgL = findViewById(R.id.TimgL);
		TimgC = findViewById(R.id.TimgC);
		linear_view = findViewById(R.id.linear_view);
		VP = findViewById(R.id.VP);
		back1 = findViewById(R.id.back1);
		back2 = findViewById(R.id.back2);
		back3 = findViewById(R.id.back3);
		back4 = findViewById(R.id.back4);
		back5 = findViewById(R.id.back5);
		b1 = findViewById(R.id.b1);
		above1 = findViewById(R.id.above1);
		img1 = findViewById(R.id.img1);
		t1 = findViewById(R.id.t1);
		b2 = findViewById(R.id.b2);
		above2 = findViewById(R.id.above2);
		img2 = findViewById(R.id.img2);
		t2 = findViewById(R.id.t2);
		b3 = findViewById(R.id.b3);
		above3 = findViewById(R.id.above3);
		img3 = findViewById(R.id.img3);
		t3 = findViewById(R.id.t3);
		b4 = findViewById(R.id.b4);
		above4 = findViewById(R.id.above4);
		img4 = findViewById(R.id.img4);
		t4 = findViewById(R.id.t4);
		b5 = findViewById(R.id.b5);
		above5 = findViewById(R.id.above5);
		img5 = findViewById(R.id.img5);
		t5 = findViewById(R.id.t5);
		_drawer_lin_draw = _nav_view.findViewById(R.id.lin_draw);
		_drawer_back = _nav_view.findViewById(R.id.back);
		_drawer_button1 = _nav_view.findViewById(R.id.button1);
		_drawer_button2 = _nav_view.findViewById(R.id.button2);
		_drawer_button3 = _nav_view.findViewById(R.id.button3);
		_drawer_button4 = _nav_view.findViewById(R.id.button4);
		_drawer_button5 = _nav_view.findViewById(R.id.button5);
		_drawer_button6 = _nav_view.findViewById(R.id.button6);
		_drawer_img1 = _nav_view.findViewById(R.id.img1);
		_drawer_t1 = _nav_view.findViewById(R.id.t1);
		_drawer_img2 = _nav_view.findViewById(R.id.img2);
		_drawer_t2 = _nav_view.findViewById(R.id.t2);
		_drawer_img3 = _nav_view.findViewById(R.id.img3);
		_drawer_t3 = _nav_view.findViewById(R.id.t3);
		_drawer_img4 = _nav_view.findViewById(R.id.img4);
		_drawer_t4 = _nav_view.findViewById(R.id.t4);
		_drawer_img5 = _nav_view.findViewById(R.id.img5);
		_drawer_t5 = _nav_view.findViewById(R.id.t5);
		_drawer_img6 = _nav_view.findViewById(R.id.img6);
		_drawer_t6 = _nav_view.findViewById(R.id.t6);
		
		TimgL.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (_drawer.isDrawerOpen(GravityCompat.START)) {
					_drawer.closeDrawer(GravityCompat.START);
				}
				else {
					_drawer.openDrawer(GravityCompat.START);
				}
			}
		});
		
		above1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ObjectAnimator anim = ObjectAnimator.ofFloat(t2, "ScaleY", 0, 1);
				anim.setInterpolator(new BounceInterpolator()); 
				anim.setDuration(1000);
				anim.start();
				_rippleRoundStroke(above1, "#3affffff", "#40FFFFFF", 20, 0, "#000000");
				above2.setBackgroundColor(Color.TRANSPARENT);
				above3.setBackgroundColor(Color.TRANSPARENT);
				above4.setBackgroundColor(Color.TRANSPARENT);
				above5.setBackgroundColor(Color.TRANSPARENT);
				t1.setTextColor(0xFFFFFFFF);
				t2.setTextColor(0xFFE0E0E0);
				t3.setTextColor(0xFFE0E0E0);
				t4.setTextColor(0xFFE0E0E0);
				t5.setTextColor(0xFFE0E0E0);
				_Icon_Colour(img1, "#ffffff");
				_Icon_Colour(img2, "#e0e0e0");
				_Icon_Colour(img3, "#e0e0e0");
				_Icon_Colour(img4, "#e0e0e0");
				_Icon_Colour(img5, "#e0e0e0");
				t1.setVisibility(View.VISIBLE);
				t2.setVisibility(View.GONE);
				t3.setVisibility(View.GONE);
				t4.setVisibility(View.GONE);
				t5.setVisibility(View.GONE);
			}
		});
		
		above2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ObjectAnimator anim = ObjectAnimator.ofFloat(t2, "ScaleY", 0, 1);
				anim.setInterpolator(new BounceInterpolator()); 
				anim.setDuration(1000);
				anim.start();
				above1.setBackgroundColor(Color.TRANSPARENT);
				_rippleRoundStroke(above2, "#3affffff", "#40FFFFFF", 20, 0, "#000000");
				above3.setBackgroundColor(Color.TRANSPARENT);
				above4.setBackgroundColor(Color.TRANSPARENT);
				above5.setBackgroundColor(Color.TRANSPARENT);
				t1.setTextColor(0xFFE0E0E0);
				t2.setTextColor(0xFFFFFFFF);
				t3.setTextColor(0xFFE0E0E0);
				t4.setTextColor(0xFFE0E0E0);
				t5.setTextColor(0xFFE0E0E0);
				_Icon_Colour(img1, "#e0e0e0");
				_Icon_Colour(img2, "#ffffff");
				_Icon_Colour(img3, "#e0e0e0");
				_Icon_Colour(img4, "#e0e0e0");
				_Icon_Colour(img5, "#e0e0e0");
				t1.setVisibility(View.GONE);
				t2.setVisibility(View.VISIBLE);
				t3.setVisibility(View.GONE);
				t4.setVisibility(View.GONE);
				t5.setVisibility(View.GONE);
			}
		});
		
		above3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ObjectAnimator anim = ObjectAnimator.ofFloat(t2, "ScaleY", 0, 1);
				anim.setInterpolator(new BounceInterpolator()); 
				anim.setDuration(1000);
				anim.start();
				above1.setBackgroundColor(Color.TRANSPARENT);
				above2.setBackgroundColor(Color.TRANSPARENT);
				_rippleRoundStroke(above3, "#3affffff", "#40FFFFFF", 20, 0, "#000000");
				above4.setBackgroundColor(Color.TRANSPARENT);
				above5.setBackgroundColor(Color.TRANSPARENT);
				t1.setTextColor(0xFFE0E0E0);
				t2.setTextColor(0xFFE0E0E0);
				t3.setTextColor(0xFFFFFFFF);
				t4.setTextColor(0xFFE0E0E0);
				t5.setTextColor(0xFFE0E0E0);
				_Icon_Colour(img1, "#e0e0e0");
				_Icon_Colour(img2, "#e0e0e0");
				_Icon_Colour(img3, "#ffffff");
				_Icon_Colour(img4, "#e0e0e0");
				_Icon_Colour(img5, "#e0e0e0");
				t1.setVisibility(View.GONE);
				t2.setVisibility(View.GONE);
				t3.setVisibility(View.VISIBLE);
				t4.setVisibility(View.GONE);
				t5.setVisibility(View.GONE);
			}
		});
		
		above4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ObjectAnimator anim = ObjectAnimator.ofFloat(t2, "ScaleY", 0, 1);
				anim.setInterpolator(new BounceInterpolator()); 
				anim.setDuration(1000);
				anim.start();
				above1.setBackgroundColor(Color.TRANSPARENT);
				above2.setBackgroundColor(Color.TRANSPARENT);
				above3.setBackgroundColor(Color.TRANSPARENT);
				_rippleRoundStroke(above4, "#3affffff", "#40FFFFFF", 20, 0, "#000000");
				above5.setBackgroundColor(Color.TRANSPARENT);
				t1.setTextColor(0xFFE0E0E0);
				t2.setTextColor(0xFFE0E0E0);
				t3.setTextColor(0xFFE0E0E0);
				t4.setTextColor(0xFFFFFFFF);
				t5.setTextColor(0xFFE0E0E0);
				_Icon_Colour(img1, "#e0e0e0");
				_Icon_Colour(img2, "#e0e0e0");
				_Icon_Colour(img3, "#e0e0e0");
				_Icon_Colour(img4, "#ffffff");
				_Icon_Colour(img5, "#e0e0e0");
				t1.setVisibility(View.GONE);
				t2.setVisibility(View.GONE);
				t3.setVisibility(View.GONE);
				t4.setVisibility(View.VISIBLE);
				t5.setVisibility(View.GONE);
			}
		});
		
		above5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				ObjectAnimator anim = ObjectAnimator.ofFloat(t2, "ScaleY", 0, 1);
				anim.setInterpolator(new BounceInterpolator()); 
				anim.setDuration(1000);
				anim.start();
				above1.setBackgroundColor(Color.TRANSPARENT);
				above2.setBackgroundColor(Color.TRANSPARENT);
				above3.setBackgroundColor(Color.TRANSPARENT);
				above4.setBackgroundColor(Color.TRANSPARENT);
				_rippleRoundStroke(above5, "#3affffff", "#40FFFFFF", 20, 0, "#000000");
				t1.setTextColor(0xFFE0E0E0);
				t2.setTextColor(0xFFE0E0E0);
				t3.setTextColor(0xFFE0E0E0);
				t4.setTextColor(0xFFE0E0E0);
				t5.setTextColor(0xFFFFFFFF);
				_Icon_Colour(img1, "#e0e0e0");
				_Icon_Colour(img2, "#e0e0e0");
				_Icon_Colour(img3, "#e0e0e0");
				_Icon_Colour(img4, "#e0e0e0");
				_Icon_Colour(img5, "#ffffff");
				t1.setVisibility(View.GONE);
				t2.setVisibility(View.GONE);
				t3.setVisibility(View.GONE);
				t4.setVisibility(View.GONE);
				t5.setVisibility(View.VISIBLE);
			}
		});
	}
	
	private void initializeLogic() {
		final LinearLayout _nav_view = (LinearLayout) findViewById(R.id._nav_view); _nav_view.setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(Color.TRANSPARENT));
		getSupportActionBar().hide();
		_drawer_lin_draw.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)50, 0xFF242424));
		_drawer_button1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)30, 0xFF131418));
		above1.performClick();
		bg.setElevation((float)30);
		_DARK_ICONS();
	}
	
	@Override
	public void onBackPressed() {
		if (_drawer.isDrawerOpen(GravityCompat.START)) {
			_drawer.closeDrawer(GravityCompat.START);
		} else {
			super.onBackPressed();
		}
	}
	public void _Icon_Colour(final ImageView _iconview, final String _colour) {
		_iconview.getDrawable().setColorFilter(Color.parseColor(_colour), PorterDuff.Mode.SRC_IN);
	}
	
	
	public void _rippleRoundStroke(final View _view, final String _focus, final String _pressed, final double _round, final double _stroke, final String _strokeclr) {
		android.graphics.drawable.GradientDrawable GG = new android.graphics.drawable.GradientDrawable();
		GG.setColor(Color.parseColor(_focus));
		GG.setCornerRadius((float)_round);
		GG.setStroke((int) _stroke,
		Color.parseColor("#" + _strokeclr.replace("#", "")));
		android.graphics.drawable.RippleDrawable RE = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor(_pressed)}), GG, null);
		_view.setBackground(RE);
	}
	
	
	public void _DARK_ICONS() {
		getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
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