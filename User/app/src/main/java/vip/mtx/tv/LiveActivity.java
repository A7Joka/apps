package vip.mtx.tv;

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
import android.graphics.Typeface;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.net.Uri;
import android.os.*;
import android.text.*;
import android.text.Editable;
import android.text.TextWatcher;
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
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
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
import com.bumptech.glide.Glide;
import com.google.android.exoplayer2.ui.*;
import com.google.android.material.appbar.AppBarLayout;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.monstertechno.adblocker.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import meorg.jsoup.*;
import org.json.*;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class LiveActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private DrawerLayout _drawer;
	private String fontName = "";
	private String typeace = "";
	private String url = "";
	private String url0 = "";
	private String url1 = "";
	private String url2 = "";
	private double pos2 = 0;
	private double pos1 = 0;
	private double pos = 0;
	private String html1 = "";
	private String html = "";
	private String NewSource = "";
	private String html0 = "";
	private String cup = "";
	private String tv = "";
	private String mic = "";
	private String match = "";
	private String time = "";
	private double number = 0;
	private double length = 0;
	private String watch = "";
	private String watch_live = "";
	private String watch_finsh = "";
	private String txt = "";
	private String user = "";
	private String refer = "";
	
	private ArrayList<HashMap<String, Object>> mpl = new ArrayList<>();
	private ArrayList<String> listImg2 = new ArrayList<>();
	private ArrayList<String> listName2 = new ArrayList<>();
	private ArrayList<String> listTV = new ArrayList<>();
	private ArrayList<String> listMIC = new ArrayList<>();
	private ArrayList<String> listCUP = new ArrayList<>();
	private ArrayList<String> listImg1 = new ArrayList<>();
	private ArrayList<String> listName1 = new ArrayList<>();
	private ArrayList<String> listDate = new ArrayList<>();
	private ArrayList<String> listhala = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> listUrl = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> livet = new ArrayList<>();
	
	private LinearLayout linear18;
	private LinearLayout taplayout;
	private LinearLayout linear14;
	private LinearLayout linear1;
	private ImageView imageview2;
	private ImageView imageview5;
	private ImageView imageview6;
	private TextView textview2;
	private TextView textview3;
	private TextView textview4;
	private LinearLayout linear15;
	private LinearLayout linear16;
	private LinearLayout linear17;
	private LinearLayout linear2;
	private LinearLayout linear60;
	private ListView listview1;
	private LinearLayout linear3;
	private LinearLayout linear61;
	private TextView textview5;
	private EditText edittext_date;
	private ImageView imageview_click;
	private ImageView imageview1;
	private TextView textview1;
	private LinearLayout _drawer_linear1;
	private LinearLayout _drawer_linear4;
	private LinearLayout _drawer_linear3;
	private LinearLayout _drawer_linear2;
	private LinearLayout _drawer_linear_exit;
	private ImageView _drawer_imageview1;
	private LinearLayout _drawer_linear5;
	private ImageView _drawer_close;
	private TextView _drawer_textview8;
	private LinearLayout _drawer_linear_home;
	private LinearLayout _drawer_linear_aboutapp;
	private LinearLayout _drawer_linear_about;
	private LinearLayout _drawer_linear_support;
	private LinearLayout _drawer_linear_rate;
	private LinearLayout _drawer_linear13;
	private LinearLayout _drawer_linear14;
	private ImageView _drawer_home_img;
	private TextView _drawer_textview1;
	private ImageView _drawer_aboutapp_img;
	private TextView _drawer_textview2;
	private ImageView _drawer_about_img;
	private TextView _drawer_textview3;
	private ImageView _drawer_support_img;
	private TextView _drawer_textview4;
	private ImageView _drawer_rate_img;
	private TextView _drawer_textview5;
	private ImageView _drawer_imageview4;
	private TextView _drawer_textview6;
	private ImageView _drawer_imageview5;
	private TextView _drawer_textview9;
	private ImageView _drawer_exit_img;
	private TextView _drawer_textview7;
	
	private Intent live = new Intent();
	private ObjectAnimator animation_ = new ObjectAnimator();
	private AlertDialog.Builder dialog;
	private TimerTask t;
	private Intent i = new Intent();
	private DatabaseReference link = _firebase.getReference("link");
	private ChildEventListener _link_child_listener;
	private RequestNetwork req;
	private RequestNetwork.RequestListener _req_request_listener;
	private SharedPreferences settings;
	private TimerTask entimer;
	private DatabaseReference mt = _firebase.getReference("mt");
	private ChildEventListener _mt_child_listener;
	private SharedPreferences shared;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.live);
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
		ActionBarDrawerToggle _toggle = new ActionBarDrawerToggle(LiveActivity.this, _drawer, _toolbar, R.string.app_name, R.string.app_name);
		_drawer.addDrawerListener(_toggle);
		_toggle.syncState();
		
		LinearLayout _nav_view = findViewById(R.id._nav_view);
		
		linear18 = findViewById(R.id.linear18);
		taplayout = findViewById(R.id.taplayout);
		linear14 = findViewById(R.id.linear14);
		linear1 = findViewById(R.id.linear1);
		imageview2 = findViewById(R.id.imageview2);
		imageview5 = findViewById(R.id.imageview5);
		imageview6 = findViewById(R.id.imageview6);
		textview2 = findViewById(R.id.textview2);
		textview3 = findViewById(R.id.textview3);
		textview4 = findViewById(R.id.textview4);
		linear15 = findViewById(R.id.linear15);
		linear16 = findViewById(R.id.linear16);
		linear17 = findViewById(R.id.linear17);
		linear2 = findViewById(R.id.linear2);
		linear60 = findViewById(R.id.linear60);
		listview1 = findViewById(R.id.listview1);
		linear3 = findViewById(R.id.linear3);
		linear61 = findViewById(R.id.linear61);
		textview5 = findViewById(R.id.textview5);
		edittext_date = findViewById(R.id.edittext_date);
		imageview_click = findViewById(R.id.imageview_click);
		imageview1 = findViewById(R.id.imageview1);
		textview1 = findViewById(R.id.textview1);
		_drawer_linear1 = _nav_view.findViewById(R.id.linear1);
		_drawer_linear4 = _nav_view.findViewById(R.id.linear4);
		_drawer_linear3 = _nav_view.findViewById(R.id.linear3);
		_drawer_linear2 = _nav_view.findViewById(R.id.linear2);
		_drawer_linear_exit = _nav_view.findViewById(R.id.linear_exit);
		_drawer_imageview1 = _nav_view.findViewById(R.id.imageview1);
		_drawer_linear5 = _nav_view.findViewById(R.id.linear5);
		_drawer_close = _nav_view.findViewById(R.id.close);
		_drawer_textview8 = _nav_view.findViewById(R.id.textview8);
		_drawer_linear_home = _nav_view.findViewById(R.id.linear_home);
		_drawer_linear_aboutapp = _nav_view.findViewById(R.id.linear_aboutapp);
		_drawer_linear_about = _nav_view.findViewById(R.id.linear_about);
		_drawer_linear_support = _nav_view.findViewById(R.id.linear_support);
		_drawer_linear_rate = _nav_view.findViewById(R.id.linear_rate);
		_drawer_linear13 = _nav_view.findViewById(R.id.linear13);
		_drawer_linear14 = _nav_view.findViewById(R.id.linear14);
		_drawer_home_img = _nav_view.findViewById(R.id.home_img);
		_drawer_textview1 = _nav_view.findViewById(R.id.textview1);
		_drawer_aboutapp_img = _nav_view.findViewById(R.id.aboutapp_img);
		_drawer_textview2 = _nav_view.findViewById(R.id.textview2);
		_drawer_about_img = _nav_view.findViewById(R.id.about_img);
		_drawer_textview3 = _nav_view.findViewById(R.id.textview3);
		_drawer_support_img = _nav_view.findViewById(R.id.support_img);
		_drawer_textview4 = _nav_view.findViewById(R.id.textview4);
		_drawer_rate_img = _nav_view.findViewById(R.id.rate_img);
		_drawer_textview5 = _nav_view.findViewById(R.id.textview5);
		_drawer_imageview4 = _nav_view.findViewById(R.id.imageview4);
		_drawer_textview6 = _nav_view.findViewById(R.id.textview6);
		_drawer_imageview5 = _nav_view.findViewById(R.id.imageview5);
		_drawer_textview9 = _nav_view.findViewById(R.id.textview9);
		_drawer_exit_img = _nav_view.findViewById(R.id.exit_img);
		_drawer_textview7 = _nav_view.findViewById(R.id.textview7);
		dialog = new AlertDialog.Builder(this);
		req = new RequestNetwork(this);
		settings = getSharedPreferences("settings", Activity.MODE_PRIVATE);
		shared = getSharedPreferences("shared", Activity.MODE_PRIVATE);
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_drawer.openDrawer(GravityCompat.START);
			}
		});
		
		imageview6.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_drawer.closeDrawer(GravityCompat.START);
				final AlertDialog dialog = new 
				
				//غير الأسماء
				 AlertDialog.Builder(LiveActivity.this).create();
				LayoutInflater inflater = getLayoutInflater();
				
				View convertView = (View) inflater.inflate(R.layout.exit5, null);
				dialog.setView(convertView);
				
				//تعريف العناصر
				
				TextView txt1 = (TextView)convertView.findViewById(R.id.textview1);
				
				Button btn1 = (Button)convertView.findViewById(R.id.button1);
				
				Button btn2 = (Button)convertView.findViewById(R.id.button2);
				
				ImageView imageview1= (ImageView)convertView.findViewById(R.id.imageview1);
				
				final LinearLayout linear  = (LinearLayout)convertView.findViewById(R.id.linear1);
				
				final LinearLayout linear2  = (LinearLayout)convertView.findViewById(R.id.linear2);
				
				final LinearLayout linear3  = (LinearLayout)convertView.findViewById(R.id.linear3);
				
				txt1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
				
				btn1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
				
				btn2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
				
				//الضغط على الأيقونات
				
				btn1.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						dialog.dismiss();
						_bt1();
					}});
				
				btn2.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						dialog.dismiss();
						_bt5(); 
					}});
				
				//الحواف دائرية
				android.graphics.drawable.GradientDrawable d = new android.graphics.drawable.GradientDrawable();
				d.setColor(Color.parseColor("#e0e0e0"));
				d.setCornerRadius((int)20f);
				linear.setBackground(d);
				
				android.graphics.drawable.GradientDrawable w = new android.graphics.drawable.GradientDrawable();
				w.setColor(Color.parseColor("#78022C"));
				w.setCornerRadius((int)20f);
				btn1.setBackground(w);
				
				
				android.graphics.drawable.GradientDrawable wd = new android.graphics.drawable.GradientDrawable();
				wd.setColor(Color.parseColor("#78022C"));
				wd.setCornerRadius((int)20f);
				btn2.setBackground(wd);
				
				dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);dialog.show();
			}
		});
		
		textview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				live.setClass(getApplicationContext(), CategoryActivity.class);
				startActivity(live);
				overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
			}
		});
		
		textview3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				live.setClass(getApplicationContext(), AflamActivity.class);
				startActivity(live);
				overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
			}
		});
		
		edittext_date.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				linear3.setVisibility(View.GONE);
				linear60.setVisibility(View.GONE);
				listUrl.clear();
				listImg1.clear();
				listName1.clear();
				listImg2.clear();
				listName2.clear();
				listTV.clear();
				listMIC.clear();
				listCUP.clear();
				listDate.clear();
				listhala.clear();
				req.startRequestNetwork(RequestNetworkController.GET, "https://www.yalla-group.com/live/".concat(_charSeq), "", _req_request_listener);
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		imageview_click.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				androidx.appcompat.app.AppCompatDialogFragment newFragment = new DatePickerFragment();
				
				newFragment.show(getSupportFragmentManager(), "Date Picker");
			}
		});
		
		_link_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				url = _childValue.get("player").toString();
				url0 = _childValue.get("whats").toString();
				url1 = _childValue.get("tele").toString();
				url2 = _childValue.get("free").toString();
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				url = _childValue.get("player").toString();
				url0 = _childValue.get("whats").toString();
				url1 = _childValue.get("tele").toString();
				url2 = _childValue.get("free").toString();
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		link.addChildEventListener(_link_child_listener);
		
		_req_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				_GetSource(_response, 3, "// var data = {date : \"", "\"");
				if (_response.contains("<span class=\"right-side teams-logo\">")) {
					match = _response.substring((int)(_response.indexOf("<div class=\"current-plays\">")), (int)(_response.indexOf("</li></ul>")));
					_GetSource(match, 2, "<span class=\"left-side teams-logo\">", "<span class=\"clickToWatch\">");
					_GetSource(match, 1, "<span class=\"right-side teams-logo\">", "<span class=\"left-side teams-logo\">");
					_GetSource(match, 0, "<a href=\"https://www.yalla-group.com/live/match?live_id=", "&");
				}
				else {
					listUrl.clear();
					listImg1.clear();
					listName1.clear();
					listImg2.clear();
					listName2.clear();
					listTV.clear();
					listMIC.clear();
					listCUP.clear();
					listDate.clear();
					listhala.clear();
					((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
					linear3.setVisibility(View.VISIBLE);
					linear60.setVisibility(View.VISIBLE);
				}
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				SketchwareUtil.showMessage(getApplicationContext(), "حدث خطأ");
			}
		};
		
		_mt_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				mt.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						livet = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								livet.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				mt.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						livet = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								livet.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		mt.addChildEventListener(_mt_child_listener);
		
		_drawer_linear_exit.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_drawer.closeDrawer(GravityCompat.START);
				final AlertDialog dialog = new 
				
				//غير الأسماء
				 AlertDialog.Builder(LiveActivity.this).create();
				LayoutInflater inflater = getLayoutInflater();
				
				View convertView = (View) inflater.inflate(R.layout.exit5, null);
				dialog.setView(convertView);
				
				//تعريف العناصر
				
				TextView txt1 = (TextView)convertView.findViewById(R.id.textview1);
				
				Button btn1 = (Button)convertView.findViewById(R.id.button1);
				
				Button btn2 = (Button)convertView.findViewById(R.id.button2);
				
				ImageView imageview1= (ImageView)convertView.findViewById(R.id.imageview1);
				
				final LinearLayout linear  = (LinearLayout)convertView.findViewById(R.id.linear1);
				
				final LinearLayout linear2  = (LinearLayout)convertView.findViewById(R.id.linear2);
				
				final LinearLayout linear3  = (LinearLayout)convertView.findViewById(R.id.linear3);
				
				txt1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
				
				btn1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
				
				btn2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
				
				//الضغط على الأيقونات
				
				btn1.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						dialog.dismiss();
						_bt1();
					}});
				
				btn2.setOnClickListener(new View.OnClickListener() {
					public void onClick(View v) {
						dialog.dismiss();
						_bt5(); 
					}});
				
				//الحواف دائرية
				android.graphics.drawable.GradientDrawable d = new android.graphics.drawable.GradientDrawable();
				d.setColor(Color.parseColor("#e0e0e0"));
				d.setCornerRadius((int)20f);
				linear.setBackground(d);
				
				android.graphics.drawable.GradientDrawable w = new android.graphics.drawable.GradientDrawable();
				w.setColor(Color.parseColor("#78022C"));
				w.setCornerRadius((int)20f);
				btn1.setBackground(w);
				
				
				android.graphics.drawable.GradientDrawable wd = new android.graphics.drawable.GradientDrawable();
				wd.setColor(Color.parseColor("#78022C"));
				wd.setCornerRadius((int)20f);
				btn2.setBackground(wd);
				
				dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);dialog.show();
			}
		});
		
		_drawer_close.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_drawer.closeDrawer(GravityCompat.START);
			}
		});
		
		_drawer_linear_home.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_drawer.closeDrawer(GravityCompat.START);
			}
		});
		
		_drawer_linear_aboutapp.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_drawer.closeDrawer(GravityCompat.START);
				
				
				
				
				
				
				.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFE0E0E0));
				textview10.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
				
				
				
				
				
				
				
				
				
			}
		});
		
		_drawer_linear_about.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_drawer.closeDrawer(GravityCompat.START);
				final AlertDialog dialog = new 
				
				//غير الأسماء
				 AlertDialog.Builder(LiveActivity.this).create();
				LayoutInflater inflater = getLayoutInflater();
				
				View convertView = (View) inflater.inflate(R.layout.div, null);
				dialog.setView(convertView);
				
				//تعريف العناصر
				
				TextView txt1 = (TextView)convertView.findViewById(R.id.textview1);
				
				TextView txt2 = (TextView)convertView.findViewById(R.id.textview2);
				
				TextView txt3 = (TextView)convertView.findViewById(R.id.textview3);
				
				TextView txt4 = (TextView)convertView.findViewById(R.id.textview4);
				
				TextView txt5 = (TextView)convertView.findViewById(R.id.textview5);
				
				TextView txt6 = (TextView)convertView.findViewById(R.id.textview6);
				
				TextView txt7 = (TextView)convertView.findViewById(R.id.textview7);
				
				ImageView imageview1= (ImageView)convertView.findViewById(R.id.imageview1);
				
				ImageView imageview2= (ImageView)convertView.findViewById(R.id.imageview2);
				
				ImageView imageview3= (ImageView)convertView.findViewById(R.id.imageview3);
				
				final LinearLayout linear1  = (LinearLayout)convertView.findViewById(R.id.linear1);
				
				final LinearLayout linear2  = (LinearLayout)convertView.findViewById(R.id.linear2);
				
				final LinearLayout linear3  = (LinearLayout)convertView.findViewById(R.id.linear3);
				
				final LinearLayout linear4  = (LinearLayout)convertView.findViewById(R.id.linear4);
				
				final LinearLayout linear5 = (LinearLayout)convertView.findViewById(R.id.linear5);
				
				txt1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
				
				txt2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
				
				txt3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
				
				txt4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
				
				txt5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
				
				txt6.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
				
				txt7.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
				
				//الحواف دائرية
				android.graphics.drawable.GradientDrawable d = new android.graphics.drawable.GradientDrawable();
				d.setColor(Color.parseColor("#78022C"));
				d.setCornerRadius((int)20f);
				linear1.setBackground(d);
				
				android.graphics.drawable.GradientDrawable dr = new android.graphics.drawable.GradientDrawable();
				dr.setColor(Color.parseColor("#e0e0e0"));
				dr.setCornerRadius((int)20f);
				linear2.setBackground(dr);
				
				android.graphics.drawable.GradientDrawable rd = new android.graphics.drawable.GradientDrawable();
				rd.setColor(Color.parseColor("#e0e0e0"));
				rd.setCornerRadius((int)20f);
				linear3.setBackground(rd);
				
				android.graphics.drawable.GradientDrawable w = new android.graphics.drawable.GradientDrawable();
				w.setColor(Color.parseColor("#78022C"));
				w.setCornerRadius((int)20f);
				txt1.setBackground(w);
				
				android.graphics.drawable.GradientDrawable rw = new android.graphics.drawable.GradientDrawable();
				rw.setColor(Color.parseColor("#78022C"));
				rw.setCornerRadius((int)20f);
				txt4.setBackground(rw);
				
				
				android.graphics.drawable.GradientDrawable rww = new android.graphics.drawable.GradientDrawable();
				rww.setColor(Color.parseColor("#78022C"));
				rww.setCornerRadius((int)20f);
				txt6.setBackground(rww);
				
				dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
				dialog.show();
			}
		});
		
		_drawer_linear_support.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_drawer.closeDrawer(GravityCompat.START);
				final com.google.android.material.bottomsheet.BottomSheetDialog bottomSheetDialog = new com.google.android.material.bottomsheet.BottomSheetDialog(LiveActivity.this);
				
				View bottomSheetView; bottomSheetView = getLayoutInflater().inflate(R.layout.policy,null );
				bottomSheetDialog.setContentView(bottomSheetView);
				
				bottomSheetDialog.getWindow().findViewById(R.id.design_bottom_sheet).setBackgroundResource(android.R.color.transparent);
				TextView t1 = (TextView) bottomSheetView.findViewById(R.id.t1);
				
				TextView t2 = (TextView) bottomSheetView.findViewById(R.id.t2);
				
				LinearLayout bg = (LinearLayout) bottomSheetView.findViewById(R.id.bg);
				
				LinearLayout b1 = (LinearLayout) bottomSheetView.findViewById(R.id.b1);
				
				ScrollView vscroll1 = (ScrollView)
				bottomSheetView.findViewById(R.id.vscroll1);
				
				vscroll1.setHorizontalScrollBarEnabled(false);
				vscroll1.setVerticalScrollBarEnabled(false);
				vscroll1.setOverScrollMode(ScrollView.OVER_SCROLL_NEVER);
				
				t1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
				t2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
				b1.setBackgroundColor(0xFF242424);
				b1.setBackgroundColor(0xFFE0E0E0);
				_rippleRoundStroke(bg, "#e0e0e0", "#e0e0e0", 15, 0, "#e0e0e0");
				bottomSheetDialog.setCancelable(true);
				bottomSheetDialog.show();
			}
		});
		
		_drawer_linear_rate.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_drawer.closeDrawer(GravityCompat.START);
				i.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP);
				i.setClass(getApplicationContext(), RateeActivity.class);
				startActivity(i);
				overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
			}
		});
		
		_drawer_linear13.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), ChampionshipActivity.class);
				startActivity(i);
				overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
			}
		});
		
		_drawer_linear14.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), NewsActivity.class);
				startActivity(i);
				overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
			}
		});
	}
	
	private void initializeLogic() {
		_telegramLoaderDialog(true);
		_Setting();
		linear17.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)10, 0xFFFFFFFF));
		_Drawer_Ui();
		_OnCreate();
		final LinearLayout _nav_view = (LinearLayout) findViewById(R.id._nav_view); _nav_view.setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(Color.TRANSPARENT));
		_changeActivityFont("neosansarabic");
		_ICC(imageview6, "#CBD0DA", "#000000");
		_RippleEffects("#e0e0e0", imageview6);
		_ICC(imageview2, "#CBD0DA", "#000000");
		_RippleEffects("#e0e0e0", imageview2);
		req.startRequestNetwork(RequestNetworkController.GET, "https://www.yalla-group.com/live/", "", _req_request_listener);
		linear3.setVisibility(View.GONE);
		linear60.setVisibility(View.GONE);
		listview1.setSelector(android.R.color.transparent);
		entimer = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						if (livet.size() > 0) {
							_telegramLoaderDialog(false);
						}
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(entimer, (int)(10), (int)(10));
	}
	
	@Override
	public void onBackPressed() {
		if (_drawer.isDrawerOpen(GravityCompat.START)) {
			_drawer.closeDrawer(GravityCompat.START);
		}
		else {
			i.setClass(getApplicationContext(), CategoryActivity.class);
			startActivity(i);
			overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
		}
	}
	
	public void _Effect_Views(final View _v, final ObjectAnimator _o) {
		_o.setTarget(_v);
		_o.setPropertyName("translationX");
		_o.setFloatValues((float)(50), (float)(0));
		_o.setDuration((int)(300));
		_o.start();
	}
	
	
	public void _changeActivityFont(final String _fontname) {
		fontName = "fonts/".concat(_fontname.concat(".ttf"));
		overrideFonts(this,getWindow().getDecorView()); 
	} 
	private void overrideFonts(final android.content.Context context, final View v) {
		
		try {
			Typeface 
			typeace = Typeface.createFromAsset(getAssets(), fontName);;
			if ((v instanceof ViewGroup)) {
				ViewGroup vg = (ViewGroup) v;
				for (int i = 0;
				i < vg.getChildCount();
				i++) {
					View child = vg.getChildAt(i);
					overrideFonts(context, child);
				}
			}
			else {
				if ((v instanceof TextView)) {
					((TextView) v).setTypeface(typeace);
				}
				else {
					if ((v instanceof EditText )) {
						((EditText) v).setTypeface(typeace);
					}
					else {
						if ((v instanceof Button)) {
							((Button) v).setTypeface(typeace);
						}
					}
				}
			}
		}
		catch(Exception e)
		
		{
			SketchwareUtil.showMessage(getApplicationContext(), "Error Loading Font");
		};
	}
	
	
	public void _NavStatusBarColor(final String _color1, final String _color2) {
		if (Build.VERSION.SDK_INT > Build.VERSION_CODES.LOLLIPOP) {
			Window w = this.getWindow();	w.clearFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);	w.addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
			w.setStatusBarColor(Color.parseColor("#" + _color1.replace("#", "")));	w.setNavigationBarColor(Color.parseColor("#" + _color2.replace("#", "")));
		}
	}
	
	
	public void _exit(final View _view, final String _focus, final String _pressed, final double _round, final double _stroke, final String _strokeclr) {
		android.graphics.drawable.GradientDrawable GG = new android.graphics.drawable.GradientDrawable();
		GG.setColor(Color.parseColor(_focus));
		
		
		
		GG.setCornerRadii(new float[] { 0, 0, 100, 100, 100, 100, 0, 0 }); //LeftTop, //RightTop, //RightBottom, //LeftBottom,
		
		
		
		GG.setStroke((int) _stroke,
		Color.parseColor("#" + _strokeclr.replace("#", "")));
		android.graphics.drawable.RippleDrawable RE = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor(_pressed)}), GG, null);
		_view.setBackground(RE);
	}
	
	
	public void _RippleEffects(final String _color, final View _view) {
		android.content.res.ColorStateList clr = new android.content.res.ColorStateList(new int[][]{new int[]{}},new int[]{Color.parseColor(_color)});
		android.graphics.drawable.RippleDrawable ripdr = new android.graphics.drawable.RippleDrawable(clr, null, null);
		_view.setBackground(ripdr);
	}
	
	
	public void _ICC(final ImageView _img, final String _c1, final String _c2) {
		_img.setImageTintList(new android.content.res.ColorStateList(new int[][] {{-android.R.attr.state_pressed},{android.R.attr.state_pressed}},new int[]{Color.parseColor(_c1), Color.parseColor(_c2)}));
	}
	
	
	public void _RadiusGradient4(final View _view, final String _color1, final String _color2, final double _lt, final double _rt, final double _rb, final double _lb, final double _border, final String _color3) {
		int[] colors = { Color.parseColor(_color1), Color.parseColor(_color2) }; android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable(android.graphics.drawable.GradientDrawable.Orientation.TOP_BOTTOM, colors);
		gd.setCornerRadii(new float[]{(int)_lt,(int)_lt,(int)_rt,(int)_rt,(int)_rb,(int)_rb,(int)_lb,(int)_lb});
		gd.setStroke((int) _border, Color.parseColor(_color3));
		_view.setBackground(gd);
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
	
	
	public void _Drawer_Ui() {
		final LinearLayout _nav_view = (LinearLayout) findViewById(R.id._nav_view); _nav_view.setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(Color.TRANSPARENT));
		_RadiusGradient4(_drawer_linear1, "#ffffff", "#ffffff", 0, 100, 100, 0, 0, "#ffffff");
		//close
		_ICC(_drawer_close, "#000000", "#757575");
		_RippleEffects("#e0e0e0", _drawer_close);
		//Home
		_ICC(_drawer_home_img, "#CBD0DA", "#78022C");
		_RippleEffects("#e0e0e0", _drawer_home_img);
		_rippleRoundStroke(_drawer_linear_home, "#78022C", "#f5f5f5", 15, 0, "#ffffff");
		//About app
		_ICC(_drawer_aboutapp_img, "#CBD0DA", "#000000");
		_RippleEffects("#e0e0e0", _drawer_aboutapp_img);
		_rippleRoundStroke(_drawer_linear_aboutapp, "#f5f5f5", "#e0e0e0", 15, 0, "#ffffff");
		//About us
		_ICC(_drawer_about_img, "#CBD0DA", "#000000");
		_RippleEffects("#e0e0e0", _drawer_about_img);
		_rippleRoundStroke(_drawer_linear_about, "#f5f5f5", "#e0e0e0", 15, 0, "#ffffff");
		//Dontate
		_ICC(_drawer_support_img, "#CBD0DA", "#000000");
		_RippleEffects("#e0e0e0", _drawer_support_img);
		_rippleRoundStroke(_drawer_linear_support, "#f5f5f5", "#e0e0e0", 15, 0, "#ffffff");
		//Rate
		_ICC(_drawer_rate_img, "#CBD0DA", "#000000");
		_RippleEffects("#e0e0e0", _drawer_rate_img);
		_rippleRoundStroke(_drawer_linear_rate, "#f5f5f5", "#e0e0e0", 15, 0, "#ffffff");
		//Championship
		_ICC(_drawer_imageview4, "#CBD0DA", "#23286A");
		_RippleEffects("#e0e0e0", _drawer_imageview4);
		_rippleRoundStroke(_drawer_linear13, "#f5f5f5", "#e0e0e0", 15, 0, "#ffffff");
		//News
		_ICC(_drawer_imageview5, "#CBD0DA", "#000000");
		_RippleEffects("#e0e0e0", _drawer_imageview5);
		_rippleRoundStroke(_drawer_linear14, "#f5f5f5", "#e0e0e0", 15, 0, "#ffffff");
		//Exit
		_ICC(_drawer_exit_img, "#CBD0DA", "#78022C");
		_RippleEffects("#e0e0e0", _drawer_exit_img);
		_exit(_drawer_linear_exit, "#78022C", "#f5f5f5", 0, 0, "#ffffff");
	}
	
	
	public void _OnCreate() {
		_changeActivityFont("neosansarabic");
		_NavStatusBarColor("#000000", "#FFFFFF");
		_toolbar.setVisibility(View.GONE);
		imageview2.getDrawable(). setColorFilter(Color.parseColor("#fafafa"), PorterDuff.Mode.SRC_IN);
		_RippleEffects("#e0e0e0", imageview2);
	}
	
	
	public void _bt1() {
		finishAffinity();
	}
	
	
	public void _bt2() {
		i.setAction(Intent.ACTION_VIEW);
		i.setData(Uri.parse(url));
		startActivity(i);
		finishAffinity();
	}
	
	
	public void _txt2() {
		
	}
	
	
	public void _txt3() {
		
	}
	
	
	public void _bt5() {
		
	}
	
	
	public void _btn1() {
		
	}
	
	
	public void _btn2() {
		i.setAction(Intent.ACTION_VIEW);
		i.setData(Uri.parse("https://dl.dropbox.com/scl/fi/z7v03jqiy4hgrec3wrn9n/MTX-Player.apk?dl=0&rlkey=njdc645wnjbl8wvgupce7uae2"));
		startActivity(i);
	}
	
	
	public void _GetSource(final String _Source, final double _type, final String _StartingKey, final String _EndingKey) {
		pos2 = _Source.indexOf(_StartingKey);
		pos1 = pos2 + _StartingKey.length();
		pos = pos1;
		for(int _repeat21 = 0; _repeat21 < (int)(_Source.length()); _repeat21++) {
			if (_Source.substring((int)(pos1), (int)(pos + 1)).contains(_EndingKey)) {
				if (_type == 3) {
					textview5.setText(_Source.substring((int)(pos1), (int)(pos)).replace("/12/", " ديسمبر ").replace("/11/", " نوفمبر ").replace("/10/", " اكتوبر ").replace("/09/", " سبتمبر ").replace("/08/", " اغسطس ").replace("/07/", " يوليو ").replace("/06/", " يونيو ").replace("/05/", " مايو ").replace("/04/", "ابريل").replace("/03/", " مارس ").replace("/02/", " فبراير ").replace("/01/", " يناير "));
				}
				else {
					if (_type == 2) {
						html1 = _Source.substring((int)(pos1), (int)(pos));
						Document docc = Jsoup.parse(html1);
						listImg2.add(docc.getElementsByTag("img").attr("src"));
						listName2.add(docc.getElementsByTag("span").first().text());
						listTV.add(docc.getElementsByTag("span").get(2).text());
						listMIC.add(docc.getElementsByTag("span").get(3).text());
						listCUP.add(docc.getElementsByTag("span").get(4).text());
					}
					else {
						if (_type == 1) {
							if (_Source.substring((int)(pos1), (int)(pos)).contains("<ul>")) {
								html = _Source.substring((int)(pos1), (int)(pos));
								Document doc = Jsoup.parse(html);
								listImg1.add(doc.getElementsByTag("img").attr("src"));
								listName1.add(doc.getElementsByTag("span").first().text());
								listDate.add(doc.getElementsByTag("span").get(2).text());
								listhala.add(doc.getElementsByTag("ul").first().text());
							}
							else {
								html = _Source.substring((int)(pos1), (int)(pos));
								Document doc = Jsoup.parse(html);
								listImg1.add(doc.getElementsByTag("img").attr("src"));
								listName1.add(doc.getElementsByTag("span").first().text());
								listDate.add(doc.getElementsByTag("span").get(2).text());
								listhala.add(":");
							}
						}
						else {
							{
								HashMap<String, Object> _item = new HashMap<>();
								_item.put("url", _Source.substring((int)(pos1), (int)(pos)));
								listUrl.add(_item);
							}
							
						}
					}
				}
				NewSource = _Source.replace(_Source.substring((int)(pos2), (int)(pos)), "");
				if (NewSource.contains(_StartingKey)) {
					_GetSource(NewSource, _type, _StartingKey, _EndingKey);
				}
				else {
					if (_type == 0) {
						linear60.setVisibility(View.VISIBLE);
						listview1.setAdapter(new Listview1Adapter(listUrl));
						((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
						entimer = new TimerTask() {
							@Override
							public void run() {
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										if (livet.size() > 0) {
											_telegramLoaderDialog(false);
										}
									}
								});
							}
						};
						_timer.scheduleAtFixedRate(entimer, (int)(10), (int)(10));
					}
				}
				break;
			}
			pos++;
		}
	}
	
	
	public void _Extra() {
	}
	public static class DatePickerFragment extends androidx.appcompat.app.AppCompatDialogFragment implements DatePickerDialog.OnDateSetListener {
		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			final Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH);
			int day = c.get(Calendar.DAY_OF_MONTH);
			return new DatePickerDialog(getActivity(), AlertDialog.THEME_DEVICE_DEFAULT_DARK , this, year, month, day);
		}
		public void onDateSet(DatePicker view, int year, int month, int day) {
			int mon = month +1;
			String date = "?d=" + day + "&m=" + mon + "&y=" + year;
			EditText edittext_date = (EditText) getActivity().findViewById(R.id.edittext_date);
			edittext_date.setText(date);
		}
	}
	
	
	public void _Setting() {
		if (settings.getString("view", "").equals("Mobile")) {
			entimer = new TimerTask() {
				@Override
				public void run() {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							setRequestedOrientation(android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
						}
					});
				}
			};
			_timer.schedule(entimer, (int)(0));
		}
		else {
			entimer = new TimerTask() {
				@Override
				public void run() {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							setRequestedOrientation(android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
						}
					});
				}
			};
			_timer.schedule(entimer, (int)(0));
		}
		if (settings.getString("theme", "").equals("Light")) {
			textview1.setTextColor(0xFF000000);
			linear2.setBackgroundColor(0xFFE0E0E0);
		}
		else {
			textview1.setTextColor(0xFFFFFFFF);
			linear2.setBackgroundColor(0xFF303030);
		}
		if (settings.getString("language", "").equals("AR")) {
			textview2.setText("قنوات");
			textview3.setText("ترفيه");
			textview4.setText("مباريات");
		}
		else {
			textview1.setText("No Matches For This Day");
			textview2.setText("Channels");
			textview3.setText("Library");
			textview4.setText("Match");
			_drawer_textview1.setText("Home");
			_drawer_textview2.setText("Support");
			_drawer_textview3.setText("Developers");
			_drawer_textview4.setText("Privacy Policy");
			_drawer_textview5.setText("Rate");
			_drawer_textview6.setText("Championship");
			_drawer_textview9.setText("News");
			_drawer_textview7.setText("Exit");
		}
	}
	
	
	public void _telegramLoaderDialog(final boolean _visibility) {
		if (_visibility) {
			if (loading == null) {
				loading = new ProgressDialog(this);
				loading.setCancelable(false);
				loading.setCanceledOnTouchOutside(false);
				loading.requestWindowFeature(Window.FEATURE_NO_TITLE);
				loading.getWindow().setBackgroundDrawable(new android.graphics.drawable.ColorDrawable(Color.TRANSPARENT));
				
			}
			loading.show();
			loading.setContentView(R.layout.loading);
			
			LinearLayout linear2 = (LinearLayout) loading.findViewById(R.id.linear2);
			LinearLayout back = (LinearLayout) loading.findViewById(R.id.background);
			ImageView prog = (ImageView) loading.findViewById(R.id.prog);
			
			Glide.with(getApplicationContext()).load(Uri.parse("file:///android_asset/loading.gif")).into(prog);
			
			android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable(); 
			gd.setColor(Color.parseColor("#FFFFFF"));
			gd.setCornerRadius(45);
			gd.setStroke(0, Color.WHITE);
			linear2.setBackground(gd);
			
		}
		else {
			if (loading != null){
					loading.dismiss();
			}
			
		}
	}
	private ProgressDialog loading;
	{
	}
	
	
	public void _gggg() {
		final AlertDialog dialog = new 
		
		//غير الأسماء
		 AlertDialog.Builder(LiveActivity.this).create();
		LayoutInflater inflater = getLayoutInflater();
		
		View convertView = (View) inflater.inflate(R.layout.coss, null);
		dialog.setView(convertView);
		
		//تعريف العناصر
		
		TextView txt1 = (TextView)convertView.findViewById(R.id.textview1);
		
		TextView txt2 = (TextView)convertView.findViewById(R.id.textview2);
		
		TextView txt3 = (TextView)convertView.findViewById(R.id.textview3);
		
		TextView txt4 = (TextView)convertView.findViewById(R.id.textview4);
		
		TextView txt5 = (TextView)convertView.findViewById(R.id.textview5);
		
		Button bt = (Button)convertView.findViewById(R.id.button1);
		
		TextView txt0 = (TextView)convertView.findViewById(R.id.textview0);
		
		TextView txt00 = (TextView)convertView.findViewById(R.id.textview00);
		
		TextView txt000 = (TextView)convertView.findViewById(R.id.textview000);
		
		TextView txt0000 = (TextView)convertView.findViewById(R.id.textview0000);
		
		TextView txt00000 = (TextView)convertView.findViewById(R.id.textview00000);
		
		ImageView imageview1= (ImageView)convertView.findViewById(R.id.imageview1);
		
		ImageView imageview2= (ImageView)convertView.findViewById(R.id.imageview2);
		
		ImageView imageview3= (ImageView)convertView.findViewById(R.id.imageview3);
		
		ImageView imageview4= (ImageView)convertView.findViewById(R.id.imageview4);
		
		ImageView imageview5= (ImageView)convertView.findViewById(R.id.imageview5);
		
		final LinearLayout linear  = (LinearLayout)convertView.findViewById(R.id.linear1);
		
		final LinearLayout linear2  = (LinearLayout)convertView.findViewById(R.id.linear2);
		
		final LinearLayout linear3  = (LinearLayout)convertView.findViewById(R.id.linear3);
		
		final LinearLayout linear4  = (LinearLayout)convertView.findViewById(R.id.linear4);
		
		final LinearLayout linear5  = (LinearLayout)convertView.findViewById(R.id.linear5);
		
		final LinearLayout linear6  = (LinearLayout)convertView.findViewById(R.id.linear6);
		
		android.graphics.drawable.GradientDrawable wd = new android.graphics.drawable.GradientDrawable();
		wd.setColor(Color.parseColor("#e0e0e0"));
		wd.setCornerRadius((int)20f);
		linear.setBackground(wd);
		linear.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFE0E0E0));
		linear1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)5, 0xFFBDBDBD));
		linear2.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)5, 0xFFBDBDBD));
		linear3.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)5, 0xFFBDBDBD));
		linear5.setVisibility(View.GONE);
		linear4.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)5, 0xFFBDBDBD));
		linear5.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)5, 0xFFBDBDBD));
		bt.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)5, 0xFF78022C));
		txt1.setText(cup);
		txt2.setText(tv);
		txt3.setText(mic);
		txt5.setText(time);
		if (watch.contains("no")) {
			bt.setVisibility(View.GONE);
		}
		else {
			if (time.contains("انتهت")) {
				if (watch_finsh.equals("no")) {
					bt.setVisibility(View.GONE);
				}
				else {
					bt.setVisibility(View.VISIBLE);
					bt.setText("مشاهدة الملخص");
					bt.setOnClickListener(new View.OnClickListener() {
						@Override
						public void onClick(View _view) {
							i.setClass(getApplicationContext(), PlayerwebActivity.class);
							i.putExtra("url", watch_finsh.replace("https://", "********").replace("http://", "*******").replace(".php", "*****").replace(".", "*"));
							startActivity(i);
						}
					});
				}
			}
			else {
				if (watch_live.equals("no")) {
					bt.setVisibility(View.GONE);
				}
				else {
					bt.setVisibility(View.VISIBLE);
					bt.setText("مشاهدة المباراة");
					bt.setOnClickListener(new View.OnClickListener() {
						@Override
						public void onClick(View _view) {
							i.setClass(getApplicationContext(), MainActivity.class);
							i.putExtra("txt", txt);
							i.putExtra("url", watch_live.replace("https://", "********").replace("http://", "*******").replace(".m3u8", "*****").replace(".", "*"));
							i.putExtra("user_agent", user.replace("https://", "********").replace("http://", "*******").replace(".m3u8", "*****").replace(".", "*"));
							i.putExtra("referer", refer.replace("https://", "********").replace("http://", "*******").replace(".m3u8", "*****").replace(".", "*"));
							i.putExtra("type", "channel");
							startActivity(i);
						}
					});
				}
			}
		}
		dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
		dialog.show();
		t = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						_telegramLoaderDialog(false);
					}
				});
			}
		};
		_timer.schedule(t, (int)(1300));
	}
	
	
	public void _zip() {
	}
	
	
	/*MADE BY ARAB WARE CHANNEL*/
	/*WHAT IS MADE ? ===>ADD FOLDER TO ZIP*/
	
	public void ArabWareAddFolderToZip (String _from,String _to) {
		if (FileUtil.isExistFile(_to.replace(Uri.parse(_to).getLastPathSegment(), "").concat("files/"))) {
				new UnZip().unZipIt(_to, _to.replace(Uri.parse(_to).getLastPathSegment(), "").concat("files/"));
				new java.io.File(_from).renameTo(new java.io.File(_to.replace(Uri.parse(_to).getLastPathSegment(), "").concat("files/").concat(Uri.parse(_from).getLastPathSegment())));
				try {
						Zip.zipFolder(_to.replace(Uri.parse(_to).getLastPathSegment(), "").concat("files/"),_to.replace(Uri.parse(_to).getLastPathSegment(), "") + Uri.parse(_to).getLastPathSegment());
				} catch(Exception e) {}
				FileUtil.deleteFile(_to.replace(Uri.parse(_to).getLastPathSegment(), "").concat("files/"));
		}
		else {
				FileUtil.makeDir(_to.replace(Uri.parse(_to).getLastPathSegment(), "").concat("files/"));
				new UnZip().unZipIt(_to, _to.replace(Uri.parse(_to).getLastPathSegment(), "").concat("files/"));
				new java.io.File(_from).renameTo(new java.io.File(_to.replace(Uri.parse(_to).getLastPathSegment(), "").concat("files/").concat(Uri.parse(_from).getLastPathSegment())));
				try {
						Zip.zipFolder(_to.replace(Uri.parse(_to).getLastPathSegment(), "").concat("files/"),_to.replace(Uri.parse(_to).getLastPathSegment(), "") + Uri.parse(_to).getLastPathSegment());
				} catch(Exception e) {}
				FileUtil.deleteFile(_to.replace(Uri.parse(_to).getLastPathSegment(), "").concat("files/"));
		}
	}
	
	
	
	public void addFilesToZip(java.io.File source, java.io.File files)
	{
		    try
		    {
			
			   
			        byte[] buffer = new byte[1024];
			        java.util.zip.ZipInputStream zin = new java.util.zip.ZipInputStream(new java.io.FileInputStream(files));
			        java.util.zip.ZipOutputStream out = new java.util.zip.ZipOutputStream(new java.io.FileOutputStream(source));
			            java.io.InputStream in = new java.io.FileInputStream(files);
			            out.putNextEntry(new java.util.zip.ZipEntry(files.getName()));
			            for(int read = in.read(buffer); read > -1; read = in.read(buffer))
			            {
				                out.write(buffer, 0, read);
				            }
			            out.closeEntry();
			            in.close();
			
			        for(java.util.zip.ZipEntry ze = zin.getNextEntry(); ze != null; ze = zin.getNextEntry())
			        {
				            out.putNextEntry(ze);
				            for(int read = zin.read(buffer); read > -1; read = zin.read(buffer))
				            {
					                out.write(buffer, 0, read);
					            }
				            out.closeEntry();
				        }
			
			        out.close();
			      
			    }
		    catch(Exception e)
		    {
			       showMessage(e.getMessage());
			    }
	}
	public static class Zip {
		
		public static void zipFolder(String str, String str2) throws Exception {
			            java.util.zip.ZipOutputStream zipOutputStream = new java.util.zip.ZipOutputStream(new java.io.FileOutputStream(str2));
			            addFolderToZip("", str, zipOutputStream);
			            zipOutputStream.flush();
			            zipOutputStream.close();
			        }
		
		
		public static void addFolderToZip(String str, String str2, java.util.zip.ZipOutputStream zipOutputStream) throws Exception {
			            java.io.File file = new java.io.File(str2);
			            for (String str3 : file.list()) {
				                if (str.equals("")) {
					                    addFileToZip(file.getName(), new StringBuilder(String.valueOf(str2)).append("/").append(str3).toString(), zipOutputStream);
					                } else {
					                    addFileToZip(new StringBuilder(String.valueOf(str)).append("/").append(file.getName()).toString(), new StringBuilder(String.valueOf(str2)).append("/").append(str3).toString(), zipOutputStream);
					                }
				            }
			        }
		
		
		
		  public static void addFileToZip(String path, String srcFile, java.util.zip.ZipOutputStream zip)
		      throws Exception {
			    java.io.File folder = new java.io.File(srcFile);
			    if (folder.isDirectory()) {
				      
				    } else {
				      byte[] buf = new byte[1024];
				      int len;
				      java.io.FileInputStream in = new java.io.FileInputStream(srcFile);
				      zip.putNextEntry(new java.util.zip.ZipEntry(path + "/" + folder.getName()));
				      while ((len = in.read(buf)) > 0) {
					        zip.write(buf, 0, len);
					      }
				    }
		}
		  }
	
	public static class UnZip {
		List<String> fileList;
		
		public void unZipIt(String zipFile, String outputFolder){
			byte[] buffer = new byte[1024];
			try{
				java.util.zip.ZipInputStream zis = new java.util.zip.ZipInputStream(new java.io.FileInputStream(zipFile));
				java.util.zip.ZipEntry ze = zis.getNextEntry();
				while(ze!=null){
					String fileName = ze.getName();
					java.io.File newFile = new java.io.File(outputFolder + java.io.File.separator + fileName);
					new java.io.File(newFile.getParent()).mkdirs();
					java.io.FileOutputStream fos = new java.io.FileOutputStream(newFile);
					int len;
					while ((len = zis.read(buffer)) > 0) {
						fos.write(buffer, 0, len);
					}
					fos.close();
					ze = zis.getNextEntry(); 
				}
				zis.closeEntry();
				zis.close();
			}catch(java.io.IOException ex){
				ex.printStackTrace();
			}
		}
	}
	
	
	public void _bt11() {
		finishAffinity();
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
				_view = _inflater.inflate(R.layout.livee, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final LinearLayout linear6 = _view.findViewById(R.id.linear6);
			final LinearLayout linear7 = _view.findViewById(R.id.linear7);
			final LinearLayout linear18 = _view.findViewById(R.id.linear18);
			final TextView textview8 = _view.findViewById(R.id.textview8);
			final LinearLayout linear21 = _view.findViewById(R.id.linear21);
			final LinearLayout linear19 = _view.findViewById(R.id.linear19);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			final TextView textview2 = _view.findViewById(R.id.textview2);
			final LinearLayout linear22 = _view.findViewById(R.id.linear22);
			final TextView textview7 = _view.findViewById(R.id.textview7);
			final LinearLayout linear23 = _view.findViewById(R.id.linear23);
			final TextView textview3 = _view.findViewById(R.id.textview3);
			final ImageView imageview2 = _view.findViewById(R.id.imageview2);
			
			textview1.setEllipsize(TextUtils.TruncateAt.MARQUEE);
			textview1.setMarqueeRepeatLimit(-1);
			textview1.setSingleLine(true);
			textview1.setSelected(true);
			textview2.setEllipsize(TextUtils.TruncateAt.MARQUEE);
			textview2.setMarqueeRepeatLimit(-1);
			textview2.setSingleLine(true);
			textview2.setSelected(true);
			textview3.setEllipsize(TextUtils.TruncateAt.MARQUEE);
			textview3.setMarqueeRepeatLimit(-1);
			textview3.setSingleLine(true);
			textview3.setSelected(true);
			textview7.setEllipsize(TextUtils.TruncateAt.MARQUEE);
			textview7.setMarqueeRepeatLimit(-1);
			textview7.setSingleLine(true);
			textview7.setSelected(true);
			textview8.setEllipsize(TextUtils.TruncateAt.MARQUEE);
			textview8.setMarqueeRepeatLimit(-1);
			textview8.setSingleLine(true);
			textview8.setSelected(true);
			textview2.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)10, 0xFFEEEEEE));
			Glide.with(getApplicationContext()).load(Uri.parse(listImg1.get((int)(_position)))).into(imageview1);
			textview1.setText(listName1.get((int)(_position)));
			Glide.with(getApplicationContext()).load(Uri.parse(listImg2.get((int)(_position)))).into(imageview2);
			textview3.setText(listName2.get((int)(_position)));
			textview2.setText(listDate.get((int)(_position)).replace("ص", ""));
			textview8.setText(listCUP.get((int)(_position)));
			if (listhala.get((int)(_position)).contains(":")) {
				linear23.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)90, 0xFFE0E0E0));
				textview7.setText("لم تبدا");
				textview7.setTextColor(0xFFE0E0E0);
			}
			else {
				if (listhala.get((int)(_position)).contains("قريباً")) {
					linear23.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)90, 0xFFFF9800));
					textview7.setText("بعد قليل");
					textview7.setTextColor(0xFFFF9800);
				}
				else {
					if (listhala.get((int)(_position)).contains("الآن")) {
						linear23.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)90, 0xFFF44336));
						textview7.setText("مباشر");
						textview7.setTextColor(0xFFF44336);
					}
					else {
						linear23.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)90, 0xFF9E9E9E));
						textview7.setText("انتهت");
						textview7.setTextColor(0xFF9E9E9E);
					}
				}
			}
			linear1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					_telegramLoaderDialog(true);
					if (!textview7.getText().toString().equals("لم تبدا")) {
						tv = listTV.get((int)(_position));
						mic = listMIC.get((int)(_position));
						cup = listCUP.get((int)(_position));
						time = listDate.get((int)(_position)).replace("ص", "").concat("  & ".concat(textview7.getText().toString()));
						if (listUrl.get((int)_position).get("url").toString().length() > 0) {
							number = livet.size() - 1;
							length = livet.size();
							for(int _repeat227 = 0; _repeat227 < (int)(length); _repeat227++) {
								if (livet.get((int)number).get("key").toString().equals(listUrl.get((int)_position).get("url").toString())) {
									if (livet.get((int)number).get("live").toString().equals("")) {
										watch_live = "no";
										if (livet.get((int)number).get("finsh").toString().equals("")) {
											watch_finsh = "no";
											watch = "yes";
											_gggg();
										}
										else {
											watch_finsh = livet.get((int)number).get("finsh").toString();
											watch = "yes";
											_gggg();
										}
									}
									else {
										watch_live = livet.get((int)number).get("live").toString();
										txt = listName1.get((int)(_position)).concat(" ضد ".concat(listName2.get((int)(_position))));
										user = livet.get((int)number).get("user").toString();
										refer = livet.get((int)number).get("referer").toString();
										watch = "yes";
										_gggg();
									}
								}
								else {
									if (number == 0) {
										watch = "no";
										_gggg();
									}
								}
								number--;
							}
						}
						Collections.reverse(livet);
					}
					else {
						watch = "no";
						tv = listTV.get((int)(_position));
						mic = listMIC.get((int)(_position));
						cup = listCUP.get((int)(_position));
						time = listDate.get((int)(_position)).replace("ص", "").concat(" & ".concat(textview7.getText().toString()));
						_gggg();
					}
				}
			});
			
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