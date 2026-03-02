package com.HAKEEMO.PLAYER;

import android.animation.*;
import android.animation.ObjectAnimator;
import android.app.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.*;
import android.content.DialogInterface;
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
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.webkit.*;
import android.widget.*;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
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
import com.blogspot.atifsoftwares.animatoolib.*;
import com.bumptech.glide.Glide;
import com.google.android.exoplayer2.*;
import com.google.android.exoplayer2.ui.*;
import com.google.android.gms.ads.MobileAds;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.FirebaseApp;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dev.gerges.ParserM3U.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import org.json.*;
import android.content.pm.PackageManager;

public class HomeActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private FloatingActionButton _fab;
	private DrawerLayout _drawer;
	private HashMap<String, Object> mapp = new HashMap<>();
	private double pos = 0;
	private String edit = "";
	private String type = "";
	private String user_agiant = "";
	private String tt = "";
	private HashMap<String, Object> UpdatifyMap = new HashMap<>();
	private String uri = "";
	private boolean isVpnConnected = false;
	private String v1 = "";
	private String v2 = "";
	private String v3 = "";
	private String vip = "";
	
	private ArrayList<HashMap<String, Object>> map = new ArrayList<>();
	
	private LinearLayout linear2;
	private ListView listview1;
	private LinearLayout linear4;
	private LinearLayout linear28;
	private LinearLayout linear26;
	private TextView textview1;
	private LinearLayout linear29;
	private ImageView imageview2;
	private ImageView imageview6;
	private TextView textview2;
	private LinearLayout _drawer_linear1;
	private LinearLayout _drawer_linear2;
	private LinearLayout _drawer_linear_inf;
	private LinearLayout _drawer_linear5;
	private LinearLayout _drawer_linear6;
	private LinearLayout _drawer_linear7;
	private ImageView _drawer_imageview1;
	private ScrollView _drawer_vscroll1;
	private LinearLayout _drawer_linear8;
	private LinearLayout _drawer_linear_c2;
	private LinearLayout _drawer_linear9;
	private LinearLayout _drawer_linear10;
	private LinearLayout _drawer_linear11;
	private LinearLayout _drawer_linear14;
	private LinearLayout _drawer_linear16;
	private ImageView _drawer_imageview4;
	private TextView _drawer_textview5;
	private ImageView _drawer_imageview10;
	private TextView _drawer_textview11;
	private ImageView _drawer_imageview11;
	private TextView _drawer_textview12;
	private ImageView _drawer_imageview12;
	private TextView _drawer_textview13;
	private ImageView _drawer_imageview15;
	private TextView _drawer_textview16;
	private ImageView _drawer_imageview17;
	private TextView _drawer_textview18;
	private ImageView _drawer_imageview2;
	private TextView _drawer_textview3;
	
	private Intent i = new Intent();
	private Intent in = new Intent();
	private TimerTask t;
	private ObjectAnimator object = new ObjectAnimator();
	private SharedPreferences s;
	private AlertDialog.Builder d;
	private AlertDialog.Builder d2;
	private Intent ii = new Intent();
	private SharedPreferences UCSP;
	private RequestNetwork req;
	private RequestNetwork.RequestListener _req_request_listener;
	private AlertDialog.Builder about;
	private SharedPreferences Sp;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.home);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		MobileAds.initialize(this);
		
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
		_fab = findViewById(R.id._fab);
		
		_drawer = findViewById(R.id._drawer);
		ActionBarDrawerToggle _toggle = new ActionBarDrawerToggle(HomeActivity.this, _drawer, _toolbar, R.string.app_name, R.string.app_name);
		_drawer.addDrawerListener(_toggle);
		_toggle.syncState();
		
		LinearLayout _nav_view = findViewById(R.id._nav_view);
		
		linear2 = findViewById(R.id.linear2);
		listview1 = findViewById(R.id.listview1);
		linear4 = findViewById(R.id.linear4);
		linear28 = findViewById(R.id.linear28);
		linear26 = findViewById(R.id.linear26);
		textview1 = findViewById(R.id.textview1);
		linear29 = findViewById(R.id.linear29);
		imageview2 = findViewById(R.id.imageview2);
		imageview6 = findViewById(R.id.imageview6);
		textview2 = findViewById(R.id.textview2);
		_drawer_linear1 = _nav_view.findViewById(R.id.linear1);
		_drawer_linear2 = _nav_view.findViewById(R.id.linear2);
		_drawer_linear_inf = _nav_view.findViewById(R.id.linear_inf);
		_drawer_linear5 = _nav_view.findViewById(R.id.linear5);
		_drawer_linear6 = _nav_view.findViewById(R.id.linear6);
		_drawer_linear7 = _nav_view.findViewById(R.id.linear7);
		_drawer_imageview1 = _nav_view.findViewById(R.id.imageview1);
		_drawer_vscroll1 = _nav_view.findViewById(R.id.vscroll1);
		_drawer_linear8 = _nav_view.findViewById(R.id.linear8);
		_drawer_linear_c2 = _nav_view.findViewById(R.id.linear_c2);
		_drawer_linear9 = _nav_view.findViewById(R.id.linear9);
		_drawer_linear10 = _nav_view.findViewById(R.id.linear10);
		_drawer_linear11 = _nav_view.findViewById(R.id.linear11);
		_drawer_linear14 = _nav_view.findViewById(R.id.linear14);
		_drawer_linear16 = _nav_view.findViewById(R.id.linear16);
		_drawer_imageview4 = _nav_view.findViewById(R.id.imageview4);
		_drawer_textview5 = _nav_view.findViewById(R.id.textview5);
		_drawer_imageview10 = _nav_view.findViewById(R.id.imageview10);
		_drawer_textview11 = _nav_view.findViewById(R.id.textview11);
		_drawer_imageview11 = _nav_view.findViewById(R.id.imageview11);
		_drawer_textview12 = _nav_view.findViewById(R.id.textview12);
		_drawer_imageview12 = _nav_view.findViewById(R.id.imageview12);
		_drawer_textview13 = _nav_view.findViewById(R.id.textview13);
		_drawer_imageview15 = _nav_view.findViewById(R.id.imageview15);
		_drawer_textview16 = _nav_view.findViewById(R.id.textview16);
		_drawer_imageview17 = _nav_view.findViewById(R.id.imageview17);
		_drawer_textview18 = _nav_view.findViewById(R.id.textview18);
		_drawer_imageview2 = _nav_view.findViewById(R.id.imageview2);
		_drawer_textview3 = _nav_view.findViewById(R.id.textview3);
		s = getSharedPreferences("s", Activity.MODE_PRIVATE);
		d = new AlertDialog.Builder(this);
		d2 = new AlertDialog.Builder(this);
		UCSP = getSharedPreferences("UCSP", Activity.MODE_PRIVATE);
		req = new RequestNetwork(this);
		about = new AlertDialog.Builder(this);
		Sp = getSharedPreferences("Sp", Activity.MODE_PRIVATE);
		
		listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				if (map.get((int)_position).get("type").toString().equals("Web Player")) {
					i.setClass(getApplicationContext(), PlayerActivity.class);
					i.putExtra("web", map.get((int)_position).get("url").toString());
					startActivity(i);
				}
				if (map.get((int)_position).get("type").toString().equals("M3u8 Link")) {
					i.setClass(getApplicationContext(), ChannelActivity.class);
					i.putExtra("link", map.get((int)_position).get("url").toString());
					i.putExtra("User_agent", map.get((int)_position).get("user").toString());
					startActivity(i);
				}
				if (map.get((int)_position).get("type").toString().equals("Exo Player")) {
					if (!map.get((int)_position).get("url").toString().equals("") && (map.get((int)_position).get("user").toString().equals("") && map.get((int)_position).get("referer").toString().equals(""))) {
						in.putExtra("URL", map.get((int)_position).get("url").toString());
						in.putExtra("User_agent", map.get((int)_position).get("url").toString());
						in.setClass(getApplicationContext(), MainActivity.class);
						startActivity(in);
					}
					else {
						if (!map.get((int)_position).get("url").toString().equals("") && (!map.get((int)_position).get("referer").toString().equals("") && map.get((int)_position).get("user").toString().equals(""))) {
							in.putExtra("URL", map.get((int)_position).get("url").toString());
							in.putExtra("User_agent", map.get((int)_position).get("url").toString());
							in.putExtra("Referer", map.get((int)_position).get("referer").toString());
							in.setClass(getApplicationContext(), MainActivity.class);
							startActivity(in);
						}
						else {
							if (!map.get((int)_position).get("url").toString().equals("") && (!map.get((int)_position).get("user").toString().equals("") && map.get((int)_position).get("referer").toString().equals(""))) {
								in.putExtra("URL", map.get((int)_position).get("url").toString());
								in.putExtra("User_agent", map.get((int)_position).get("user").toString());
								in.setClass(getApplicationContext(), MainActivity.class);
								startActivity(in);
							}
							else {
								if (!map.get((int)_position).get("url").toString().equals("") && (!map.get((int)_position).get("user").toString().equals("") && !map.get((int)_position).get("referer").toString().equals(""))) {
									in.putExtra("URL", map.get((int)_position).get("url").toString());
									in.putExtra("User_agent", map.get((int)_position).get("user").toString());
									in.putExtra("Referer", map.get((int)_position).get("referer").toString());
									in.setClass(getApplicationContext(), MainActivity.class);
									startActivity(in);
								}
								else {
									
								}
							}
						}
					}
				}
			}
		});
		
		listview1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				d.setMessage("Do you want to:");
				d.setPositiveButton("delete", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						map.remove((int)(_position));
						s.edit().putString("y", new Gson().toJson(map)).commit();
						((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
					}
				});
				d.setNegativeButton("edit", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						pos = _position;
						i.putExtra("name", map.get((int)_position).get("name").toString());
						i.putExtra("url", map.get((int)_position).get("url").toString());
						i.putExtra("user", map.get((int)_position).get("user").toString());
						i.putExtra("referer", map.get((int)_position).get("referer").toString());
						tt = map.get((int)_position).get("type").toString();
						i.putExtra("GetPosition", String.valueOf((long)(_position)));
						i.putExtra("isEdit", "true");
						i.setClass(getApplicationContext(), EditActivity.class);
						startActivity(i);
					}
				});
				d.create().show();
				return true;
			}
		});
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_drawer.openDrawer(GravityCompat.START);
			}
		});
		
		imageview6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				in.setClass(getApplicationContext(), PrivacpolicyActivity.class);
				startActivity(in);
			}
		});
		
		_fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.putExtra("isEdit", "false");
				i.setClass(getApplicationContext(), EditActivity.class);
				startActivity(i);
			}
		});
		
		_req_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				SketchwareUtil.showMessage(getApplicationContext(), "No Internet Connection");
			}
		};
		
		_drawer_linear5.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				shareApplication();
			}
		});
		
		_drawer_linear_c2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				in.setAction(Intent.ACTION_VIEW);
				in.setData(Uri.parse("https://youtube.com/@user-hm5tp5vr6c"));
				startActivity(in);
			}
		});
		
		_drawer_linear9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				in.setAction(Intent.ACTION_VIEW);
				in.setData(Uri.parse("https://t.me/ALHakimTV"));
				startActivity(in);
			}
		});
		
		_drawer_linear10.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				in.setAction(Intent.ACTION_VIEW);
				in.setData(Uri.parse("https://www.facebook.com/profile.php?id=100090663923747&mibextid=ZbWKwL"));
				startActivity(in);
			}
		});
		
		_drawer_linear11.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				in.setAction(Intent.ACTION_VIEW);
				in.setData(Uri.parse("https://play.google.com/store/apps/details?id=com.HAKEEMO.PLAYER"));
				startActivity(in);
			}
		});
		
		_drawer_linear14.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				in.setClass(getApplicationContext(), PrivacpolicyActivity.class);
				startActivity(in);
			}
		});
		
		_drawer_linear16.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				SketchwareUtil.showMessage(getApplicationContext(), "VERSION app 1.4");
			}
		});
	}
	
	private void initializeLogic() {
		StrictMode.VmPolicy.Builder builder = 
		  new StrictMode.VmPolicy.Builder(); 
		  StrictMode.setVmPolicy(builder.build());
		  if(Build.VERSION.SDK_INT>=24){ 
			      try{
				    java.lang.reflect.Method m = 
				          StrictMode.class.getMethod(
				    "disableDeathOnFileUriExposure"); 
				          m.invoke(null); 
				    }
			   catch(Exception e){ 
				    showMessage(e.toString()); 
				    } 
			  }
		getSupportActionBar().hide();
		final LinearLayout _nav_view = (LinearLayout) findViewById(R.id._nav_view); 
		
		_nav_view.setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(Color.TRANSPARENT));  
		if (Sp.getString("onetime", "").equals("true")) {
			
		}
		else {
			in.setClass(getApplicationContext(), AccepttermsActivity.class);
			startActivity(in);
		}
		if (s.getString("y", "").equals("")) {
			linear4.setVisibility(View.VISIBLE);
			listview1.setVisibility(View.GONE);
		}
		else {
			listview1.setVisibility(View.VISIBLE);
			linear4.setVisibility(View.GONE);
			map = new Gson().fromJson(s.getString("y", ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
		}
		listview1.setAdapter(new Listview1Adapter(map));
		((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
	}
	
	@Override
	public void onBackPressed() {
		d2.setTitle("Exit");
		d2.setMessage("Do You Exit This App?");
		d2.setPositiveButton("YES", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				finishAffinity();
			}
		});
		d2.setNegativeButton("NO", new DialogInterface.OnClickListener() {
			@Override
			public void onClick(DialogInterface _dialog, int _which) {
				SketchwareUtil.showMessage(getApplicationContext(), "Thanks ❤");
			}
		});
		d2.create().show();
	}
	
	public void _style_2(final View _view, final double _r, final double _shadow, final double _str, final String _str_color, final String _color) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		gd.setColor(Color.parseColor(_color));
		gd.setCornerRadius((int)_r);
		gd.setStroke((int)_str,Color.parseColor(_str_color));
		_view.setBackground(gd);
		_view.setElevation((int)_shadow);
	}
	
	
	public void _UpdatifyComponent(final String _response) {
		try {
			//GET EVERYTHING READY
			
			String UpdatifyColorBack = "0";
			
			double UpdatifyRound = 60;
			
			String UpdatifyColor = "0";
			
			String UpdatifyCurrVer = "0";
			
			String UpdatifyTxtColor = "0";
			
			String UpdatifyBtnTxtColor = "0";
			
			String updatifyFontName = "null";
			//GET CURRENT VERSION
			
			android.content.pm.PackageInfo packageInfo = this.getPackageManager().getPackageInfo(getPackageName(), 0);
			
			UpdatifyCurrVer = packageInfo.versionName;
			UpdatifyMap = new Gson().fromJson(_response, new TypeToken<HashMap<String, Object>>(){}.getType());
			//FILL DIALOG DATA
			
			String updatifyContent1 = (UpdatifyMap.get("dialogTitle").toString());
			
			String updatifyContent2 = (UpdatifyMap.get("dialogSubtitle").toString());
			
			String updatifyContent3 = (UpdatifyMap.get("dialogBtnExtraTxt").toString());
			
			String updatifyContent4 = (UpdatifyMap.get("dialogBtnMainTxt").toString());
			if (UpdatifyMap.get("dialogOption").toString().equals("warning")) {
				UpdatifyColor = "#BD081C";
				
				UpdatifyColorBack = "#FFFFFF";
				
				UpdatifyRound = 60;
				
				UpdatifyTxtColor = "#212121";
				
				UpdatifyBtnTxtColor = "#FFFFFF";
			}
			else {
				if (UpdatifyMap.get("dialogOption").toString().equals("update")) {
					UpdatifyColor = "#0084FF";
					
					UpdatifyColorBack = "#FFFFFF";
					
					UpdatifyRound = 60;
					
					UpdatifyTxtColor = "#212121";
					
					UpdatifyBtnTxtColor = "#FFFFFF";
				}
				else {
					if (UpdatifyMap.get("dialogOption").toString().equals("message")) {
						UpdatifyColor = "#00B489";
						
						UpdatifyColorBack = "#FFFFFF";
						
						UpdatifyRound = 60;
						
						UpdatifyTxtColor = "#212121";
						
						UpdatifyBtnTxtColor = "#FFFFFF";
					}
					else {
						UpdatifyColor = (UpdatifyMap.get("customDialogAccent").toString());
						
						UpdatifyColorBack = (UpdatifyMap.get("customDialogBack").toString());
						
						UpdatifyRound = Double.parseDouble(UpdatifyMap.get("customDialogRound").toString());
						
						UpdatifyTxtColor = (UpdatifyMap.get("customDialogMainTxtColor").toString());
						
						UpdatifyBtnTxtColor = (UpdatifyMap.get("customDialogBtnTxtColor").toString());
					}
				}
			}
			if (!UpdatifyMap.containsKey("alertOption")) {
				UpdatifyMap.put("alertOption", "dialog");
			}
			if (UpdatifyMap.containsKey("dialogFont")) {
				updatifyFontName = (UpdatifyMap.get("dialogFont").toString());
				if (updatifyFontName.contains(".ttf")) {
							updatifyFontName = updatifyFontName.replace(".ttf", "");
				}
			}
			else {
				UpdatifyMap.put("dialogFont", "null");
			}
			//CREATE MAIN LAYOUT
			
			final LinearLayout main_layout = new LinearLayout(this);
			main_layout.setLayoutParams(new LinearLayout.LayoutParams(android.widget.LinearLayout.LayoutParams.MATCH_PARENT,android.widget.LinearLayout.LayoutParams.WRAP_CONTENT, 0.0f));
			main_layout.setPadding(0,0,0,0);
			main_layout.setOrientation(LinearLayout.VERTICAL);
			main_layout.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
			//CHECK DIALOG OR SHEET
			
			if (UpdatifyMap.get("alertOption").toString().equals("sheet")) {
						
				updatifySheet = new com.google.android.material.bottomsheet.BottomSheetDialog(this);
				updatifySheet.setContentView(main_layout);	updatifySheet.getWindow().findViewById(R.id.design_bottom_sheet).setBackgroundResource(android.R.color.transparent);
						
			} else if (UpdatifyMap.get("alertOption").toString().equals("dialog")) {
				updatifyDialog = new AlertDialog.Builder(this).create();	
				updatifyDialog.setView(main_layout);	updatifyDialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
						
			}
			
			//CUSTOMIZE MAIN LAYOUT
			
			android.graphics.drawable.GradientDrawable wg1 = new android.graphics.drawable.GradientDrawable();
			wg1.setColor(Color.parseColor(UpdatifyColor));
			wg1.setCornerRadius(100);
			
			final LinearLayout linear_1 = new LinearLayout(this);
			linear_1.setLayoutParams(new LinearLayout.LayoutParams(175,175, 0.0f));
			linear_1.setPadding(0,0,0,0);
			linear_1.setOrientation(LinearLayout.VERTICAL);
			linear_1.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
			linear_1.setBackground(wg1);
			
			main_layout.addView(linear_1);
			
			android.graphics.drawable.GradientDrawable wg0 = new android.graphics.drawable.GradientDrawable();
			wg0.setColor(Color.parseColor(UpdatifyColorBack));
			wg0.setCornerRadius((float)UpdatifyRound);
			
			LinearLayout.LayoutParams lp1= new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, android.widget.LinearLayout.LayoutParams.WRAP_CONTENT); 
			lp1.setMargins(40,0,40,0);
			final LinearLayout linear_55 = new LinearLayout(this);
			linear_55.setLayoutParams(new LinearLayout.LayoutParams(android.widget.LinearLayout.LayoutParams.MATCH_PARENT,android.widget.LinearLayout.LayoutParams.WRAP_CONTENT, 0.0f));
			linear_55.setPadding(45,140,45,45);
			linear_55.setLayoutParams(lp1);
			linear_55.setOrientation(LinearLayout.VERTICAL);
			linear_55.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
			linear_55.setBackground(wg0);
			main_layout.addView(linear_55);
			linear_55.setTranslationY((float)(-57.5d));
			//TITLE TEXTVIEW
			
			final TextView textview_3 = new TextView(this);
			textview_3.setLayoutParams(new LinearLayout.LayoutParams(android.widget.LinearLayout.LayoutParams.WRAP_CONTENT,android.widget.LinearLayout.LayoutParams.WRAP_CONTENT, 0.0f));
			textview_3.setPadding(0,0,0,0);
			textview_3.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
			textview_3.setText(updatifyContent1);
			textview_3.setTextSize(16);
			
			if (UpdatifyMap.get("dialogFont").toString().equals("null")) {   
				    textview_3.setTypeface(null, 1);
				    } else {
				    try {
					    	Typeface updatifyTypeFace = Typeface.createFromAsset(getAssets(), "fonts/" + updatifyFontName + ".ttf");
							textview_3.setTypeface(updatifyTypeFace, 1);
				}catch(Exception e){	
							textview_3.setTypeface(null, 1);
				}
				    }
			
			textview_3.setTextColor(Color.parseColor(UpdatifyTxtColor));
			textview_3.setSingleLine(true);
			linear_55.addView(textview_3);
			
			final LinearLayout linear_71 = new LinearLayout(this);
			linear_71.setLayoutParams(new LinearLayout.LayoutParams(android.widget.LinearLayout.LayoutParams.MATCH_PARENT,15, 0.0f));
			linear_71.setPadding(10,10,10,10);
			linear_71.setOrientation(LinearLayout.HORIZONTAL);
			linear_71.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
			linear_55.addView(linear_71);
			
			//SUBTITLE TEXTVIEW
			
			final TextView textview_4 = new TextView(this);
			textview_4.setLayoutParams(new LinearLayout.LayoutParams(android.widget.LinearLayout.LayoutParams.MATCH_PARENT,android.widget.LinearLayout.LayoutParams.WRAP_CONTENT, 0.0f));
			textview_4.setPadding(0,20,0,20);
			textview_4.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
			textview_4.setText(updatifyContent2);
			textview_4.setTextSize(14);
			if (UpdatifyMap.get("dialogFont").toString().equals("null")) {   
				    textview_4.setTypeface(null, 0);
				    } else {
				    try {
					    	Typeface updatifyTypeFace = Typeface.createFromAsset(getAssets(), "fonts/" + updatifyFontName + ".ttf");
							textview_4.setTypeface(updatifyTypeFace, 0);
				}catch(Exception e){	
							textview_4.setTypeface(null, 0);
				}
				    }
			textview_4.setTextColor(Color.parseColor(UpdatifyTxtColor));
			linear_55.addView(textview_4);
			//DIALOG IMAGE
			
			final ImageView img1 = new ImageView(this);
			img1.setLayoutParams(new LinearLayout.LayoutParams(90,90, 0.0f));
			img1.setPadding(0,0,0,0);
			if (UpdatifyMap.get("dialogOption").toString().equals("custom")) {
				Glide.with(getApplicationContext()).load(Uri.parse((UpdatifyMap.get("customDialogIcon").toString()))).into(img1);
			}
			else {
				if (UpdatifyMap.get("dialogOption").toString().equals("message")) {
					Glide.with(getApplicationContext()).load(Uri.parse("https://nerbly.com/updatify/media/dialog/dia_msg.png")).into(img1);
				}
				else {
					if (UpdatifyMap.get("dialogOption").toString().equals("warning")) {
						Glide.with(getApplicationContext()).load(Uri.parse("https://nerbly.com/updatify/media/dialog/dia_warning.png")).into(img1);
					}
					else {
						Glide.with(getApplicationContext()).load(Uri.parse("https://www5.0zz0.com/2023/03/25/20/671376830.png")).into(img1);
					}
				}
				img1.setImageTintList(new android.content.res.ColorStateList(new int[][] {{-android.R.attr.state_pressed},{android.R.attr.state_pressed}},new int[]{Color.parseColor("#FFFFFF"), Color.parseColor("#FFFFFF")}));
			}
			linear_1.addView(img1);
			linear_1.setElevation((float)5);
			linear_1.setTranslationY((float)(30));
			if (UpdatifyMap.get("dialogBtnExtra").toString().equals("true")) {
				//EXTRA BUTTON BACKGROUND
				
				final LinearLayout linear_5 = new LinearLayout(this);
				linear_5.setLayoutParams(new LinearLayout.LayoutParams(android.widget.LinearLayout.LayoutParams.MATCH_PARENT,50, 0.0f));
				linear_5.setPadding(8,8,8,8);
				linear_5.setOrientation(LinearLayout.HORIZONTAL);
				linear_55.addView(linear_5);
				//EXTRA BUTTON TEXTVIEW
				
				final TextView textview_5 = new TextView(this);
				textview_5.setLayoutParams(new LinearLayout.LayoutParams(android.widget.LinearLayout.LayoutParams.MATCH_PARENT,100, 01.0f));
				textview_5.setPadding(16,8,16,8);
				textview_5.setText(updatifyContent3);
				textview_5.setTextSize(14);
				textview_5.setTextColor(Color.parseColor(UpdatifyTxtColor));
				textview_5.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
				
				if (UpdatifyMap.get("dialogFont").toString().equals("null")) {   
					    textview_5.setTypeface(null, 0);
					    } else {
					    try {
						    	Typeface updatifyTypeFace = Typeface.createFromAsset(getAssets(), "fonts/" + updatifyFontName + ".ttf");
								textview_5.setTypeface(updatifyTypeFace, 0);
					}catch(Exception e){	
								textview_5.setTypeface(null, 0);
					}
					    }
				
				linear_55.addView(textview_5);
				
				android.graphics.drawable.GradientDrawable GG = new android.graphics.drawable.GradientDrawable();
				GG.setColor(Color.parseColor(UpdatifyColorBack));
				GG.setCornerRadius((float)UpdatifyRound);
				GG.setStroke((int) 0,
				Color.parseColor(UpdatifyColor));
				android.graphics.drawable.RippleDrawable RE = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#EEEEEE")}), GG, null);
				textview_5.setBackground(RE);
				textview_5.setOnClickListener(new OnClickListener() { 
					public void onClick(View v) {
						if (UpdatifyMap.get("dialogBtnExtraClick").toString().equals("exit")) {
							finishAffinity();
						}
						else {
							if (UpdatifyMap.get("dialogBtnExtraClick").toString().equals("browser")) {
								if (UpdatifyMap.get("isCancelable").toString().equals("true")) {
									try {
										Intent UpdatifyIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(UpdatifyMap.get("openLinkExtra").toString()));
										startActivity(UpdatifyIntent);
									} catch(Exception e) {
										SketchwareUtil.showMessage(getApplicationContext(), (e.toString()));
									}
								}
								else {
									if (UpdatifyMap.get("isCancelable").toString().equals("false")) {
										try {
											Intent UpdatifyIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(UpdatifyMap.get("openLinkExtra").toString()));
											startActivity(UpdatifyIntent);
											finishAffinity();
										} catch(Exception e) {
											SketchwareUtil.showMessage(getApplicationContext(), (e.toString()));
										}
									}
									else {
										SketchwareUtil.showMessage(getApplicationContext(), "Updatify error [CANCEL]");
									}
								}
							}
							else {
								if (UpdatifyMap.get("dialogBtnExtraClick").toString().equals("dismiss")) {
									if (UpdatifyMap.get("alertOption").toString().equals("sheet")) {
										
										updatifySheet.dismiss();		
												
									} else if (UpdatifyMap.get("alertOption").toString().equals("dialog")) {
										    
										updatifyDialog.dismiss();
												
									}
									
								}
								else {
									SketchwareUtil.showMessage(getApplicationContext(), "Updatify error [DISMISS]");
								}
							}
						}
					} 
				});
			}
			if (UpdatifyMap.get("dialogBtnMain").toString().equals("true")) {
				//MAIN BUTTON BACKGROUND
				
				final LinearLayout linear_512 = new LinearLayout(this);
				linear_512.setLayoutParams(new LinearLayout.LayoutParams(android.widget.LinearLayout.LayoutParams.MATCH_PARENT,30, 0.0f));
				linear_512.setPadding(8,8,8,8);
				linear_512.setOrientation(LinearLayout.HORIZONTAL);
				linear_55.addView(linear_512);
				//MAIN BUTTON BACKGROUND
				
				final TextView textview_6 = new TextView(this);
				textview_6.setLayoutParams(new LinearLayout.LayoutParams(android.widget.LinearLayout.LayoutParams.MATCH_PARENT,100, 0.0f));
				textview_6.setPadding(16,8,16,8);
				textview_6.setText(updatifyContent4);
				textview_6.setTextSize(14);
				textview_6.setTextColor(Color.parseColor(UpdatifyBtnTxtColor));
				textview_6.setGravity(Gravity.CENTER_HORIZONTAL | Gravity.CENTER_VERTICAL);
				if (UpdatifyMap.get("dialogFont").toString().equals("null")) {   
					    textview_6.setTypeface(null, 0);
					    } else {
					    try {
						    	Typeface updatifyTypeFace = Typeface.createFromAsset(getAssets(), "fonts/" + updatifyFontName + ".ttf");
								textview_6.setTypeface(updatifyTypeFace, 0);
					}catch(Exception e){	
								textview_6.setTypeface(null, 0);
					}
					    }
				linear_55.addView(textview_6);
				
				android.graphics.drawable.GradientDrawable GG1 = new android.graphics.drawable.GradientDrawable();
				GG1.setColor(Color.parseColor(UpdatifyColor));
				GG1.setCornerRadius((float)UpdatifyRound);
				GG1.setStroke((int) 0,
				Color.parseColor(UpdatifyColor));
				android.graphics.drawable.RippleDrawable RE1 = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor("#EEEEEE")}), GG1, null);
				textview_6.setBackground(RE1);
				textview_6.setOnClickListener(new OnClickListener() { 
					public void onClick(View v) {
						if (UpdatifyMap.get("dialogBtnMainClick").toString().equals("exit")) {
							finishAffinity();
						}
						else {
							if (UpdatifyMap.get("dialogBtnMainClick").toString().equals("browser")) {
								if (UpdatifyMap.get("isCancelable").toString().equals("true")) {
									try {
										Intent UpdatifyIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(UpdatifyMap.get("openLinkMain").toString()));
										startActivity(UpdatifyIntent);
										finishAffinity();
									} catch(Exception e) {
										SketchwareUtil.showMessage(getApplicationContext(), (e.toString()));
									}
								}
								else {
									if (UpdatifyMap.get("isCancelable").toString().equals("false")) {
										try {
											Intent UpdatifyIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(UpdatifyMap.get("openLinkMain").toString()));
											startActivity(UpdatifyIntent);
										} catch(Exception e) {
											SketchwareUtil.showMessage(getApplicationContext(), (e.toString()));
										}
									}
									else {
										SketchwareUtil.showMessage(getApplicationContext(), "Updatify error [CANCEL]");
									}
								}
							}
							else {
								if (UpdatifyMap.get("dialogBtnMainClick").toString().equals("dismiss")) {
									if (UpdatifyMap.get("alertOption").toString().equals("sheet")) {
										
										updatifySheet.dismiss();		
												
									} else if (UpdatifyMap.get("alertOption").toString().equals("dialog")) {
										
										updatifyDialog.dismiss();
												
									}
								}
								else {
									SketchwareUtil.showMessage(getApplicationContext(), "Updatify error [DISMISS]");
								}
							}
						}
					} 
				});
			}
			if (UpdatifyMap.get("isCancelable").toString().equals("false")) {
				if (UpdatifyMap.get("alertOption").toString().equals("sheet")) {
					
					updatifySheet.setCancelable(false);		
							
				} else if (UpdatifyMap.get("alertOption").toString().equals("dialog")) {
					
					updatifyDialog.setCancelable(false);
							
				}
			}
			else {
				if (UpdatifyMap.get("isCancelable").toString().equals("true")) {
					if (UpdatifyMap.get("alertOption").toString().equals("sheet")) {
						
						updatifySheet.setCancelable(true);		
								
					} else if (UpdatifyMap.get("alertOption").toString().equals("dialog")) {
						
						updatifyDialog.setCancelable(true);
								
					}
				}
				else {
					SketchwareUtil.showMessage(getApplicationContext(), "Updatify error [CANCEL]");
				}
			}
			if (UpdatifyMap.get("newVersion").toString().equals(UpdatifyCurrVer)) {
				
			}
			else {
				if (UpdatifyMap.get("isOneTime").toString().equals("true")) {
					if ((UCSP.getString("isOneTime", "").equals(UpdatifyMap.get("isOneTimeKey").toString()))) {
						
					}
					else {
						UCSP.edit().putString("isOneTime", UpdatifyMap.get("isOneTimeKey").toString()).commit();
						
						if (UpdatifyMap.get("alertOption").toString().equals("sheet")) {
							
							updatifySheet.show();		
									
						} else if (UpdatifyMap.get("alertOption").toString().equals("dialog")) {
							
							updatifyDialog.show();
							
						}
						
					}
				}
				else {
					if (UpdatifyMap.get("alertOption").toString().equals("sheet")) {
						
						updatifySheet.show();		
								
					} else if (UpdatifyMap.get("alertOption").toString().equals("dialog")) {
						
						updatifyDialog.show();
						
					}
				}
			}
		} catch(Exception e) {
			SketchwareUtil.showMessage(getApplicationContext(), (e.toString()));
		}
	}
	AlertDialog updatifyDialog;
	com.google.android.material.bottomsheet.BottomSheetDialog updatifySheet;
	{
		
	}
	
	
	public void _share() {
	}
	private void shareApplication() { 
		    android.content.pm.ApplicationInfo app = 
		    getApplicationContext().getApplicationInfo(); 
		    String filePath = app.sourceDir;
		    Intent intent = new Intent(Intent.ACTION_SEND); 
		    intent.setType("*/*"); 
		    java.io.File originalApk = new java.io.File(filePath); 
		    try {  
			     java.io.File tempFile = new java.io.File(getExternalCacheDir() + "/ExtractedApk"); 
			      if (!tempFile.isDirectory()) 
			      if (!tempFile.mkdirs()) 
			      return; 
			      tempFile = new java.io.File(tempFile.getPath() + "/" + 
			      "HAKEM PLAYER.apk");
			      if (!tempFile.exists()) 
			       {
				       try{
					        if (!tempFile.createNewFile()) { 
						         return; }
					        }
				       catch (java.io.IOException e){} 
				       } 
			      java.io.InputStream in = new java.io.FileInputStream (originalApk);
			      java.io.OutputStream out = new java.io.FileOutputStream(tempFile);
			      byte[] buf = new byte[1024];
			      int len; 
			      while ((len = in.read(buf)) > 0) { 
				        out.write(buf, 0, len); 
				      } 
			      in.close(); 
			      out.close(); 
			      intent.putExtra(Intent.EXTRA_STREAM, Uri.fromFile(tempFile));
			      startActivity(Intent.createChooser(intent, "Share app via"));
			    } 
		    catch (java.io.IOException e) 
		    { showMessage(e.toString()); 
			    } 
		
		  }
	{
	}
	
	public class Listview1Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Listview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
			_data = _arr;
		}
		
		@Override
		public int getCount() {
			return _data.size();
		}
		
		@Override
		public HashMap<String, Object> getItem(int _index) {
			return _data.get(_index);
		}
		
		@Override
		public long getItemId(int _index) {
			return _index;
		}
		
		@Override
		public View getView(final int _position, View _v, ViewGroup _container) {
			LayoutInflater _inflater = getLayoutInflater();
			View _view = _v;
			if (_view == null) {
				_view = _inflater.inflate(R.layout.list, null);
			}
			
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			final TextView textview2 = _view.findViewById(R.id.textview2);
			
			textview1.setText(map.get((int)_position).get("name").toString());
			textview2.setText(map.get((int)_position).get("url").toString());
			_style_2(linear2, 20, 3, 8, "#000000", "#ffffff");
			
			return _view;
		}
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