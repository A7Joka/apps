package vip.mtx.tv;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.app.AlertDialog;
import android.content.*;
import android.content.ClipData;
import android.content.ClipboardManager;
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
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.Glide;
import com.google.android.exoplayer2.ui.*;
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
import java.text.SimpleDateFormat;
import java.util.*;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import meorg.jsoup.*;
import org.json.*;

public class CategoryActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private String fontName = "";
	private String typeace = "";
	private HashMap<String, Object> stopp = new HashMap<>();
	private double position = 0;
	private boolean isAppInstalled = false;
	private double position_number = 0;
	private HashMap<String, Object> rat = new HashMap<>();
	private String id = "";
	private String rattt = "";
	private String url = "";
	private String url0 = "";
	private String url1 = "";
	private String url2 = "";
	private String key = "";
	private HashMap<String, Object> m = new HashMap<>();
	private String status = "";
	private double time = 0;
	private String deviceID = "";
	private String getDateFromDb = "";
	private double n = 0;
	private String eer = "";
	
	private ArrayList<HashMap<String, Object>> listmap = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> mpl = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> map = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> ratm = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> lpas = new ArrayList<>();
	private ArrayList<String> ls = new ArrayList<>();
	
	private LinearLayout layouts;
	private LinearLayout layout1;
	private LinearLayout linear13;
	private LinearLayout linear1;
	private ProgressBar progressbar2;
	private TextView txt;
	private GridView gridview1;
	
	private DatabaseReference category = _firebase.getReference("category");
	private ChildEventListener _category_child_listener;
	private Intent i = new Intent();
	private AlertDialog.Builder dialog;
	private AlertDialog.Builder about;
	private Intent intent = new Intent();
	private Intent YouTube = new Intent();
	private TimerTask t;
	private DatabaseReference link = _firebase.getReference("link");
	private ChildEventListener _link_child_listener;
	private SharedPreferences settings;
	private TimerTask entimer;
	private SharedPreferences shared;
	private Calendar nowCalendar = Calendar.getInstance();
	private Calendar startDateCalender = Calendar.getInstance();
	private Calendar cal = Calendar.getInstance();
	private DatabaseReference pass = _firebase.getReference("pass");
	private ChildEventListener _pass_child_listener;
	private TimerTask ttt;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.category);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		layouts = findViewById(R.id.layouts);
		layout1 = findViewById(R.id.layout1);
		linear13 = findViewById(R.id.linear13);
		linear1 = findViewById(R.id.linear1);
		progressbar2 = findViewById(R.id.progressbar2);
		txt = findViewById(R.id.txt);
		gridview1 = findViewById(R.id.gridview1);
		dialog = new AlertDialog.Builder(this);
		about = new AlertDialog.Builder(this);
		settings = getSharedPreferences("settings", Activity.MODE_PRIVATE);
		shared = getSharedPreferences("shared", Activity.MODE_PRIVATE);
		
		gridview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				i.putExtra("name", listmap.get((int)_position).get("name").toString());
				i.putExtra("id", listmap.get((int)_position).get("id").toString());
				i.putExtra("img", listmap.get((int)_position).get("img").toString());
				i.setClass(getApplicationContext(), ChannelsActivity.class);
				startActivity(i);
			}
		});
		
		_category_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				progressbar2.setVisibility(View.GONE);
				category.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						listmap = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								listmap.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						gridview1.setAdapter(new Gridview1Adapter(listmap));
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
				category.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						listmap = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								listmap.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						gridview1.setAdapter(new Gridview1Adapter(listmap));
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
				category.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						listmap = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								listmap.add(_map);
							}
						}
						catch (Exception _e) {
							_e.printStackTrace();
						}
						gridview1.setAdapter(new Gridview1Adapter(listmap));
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		category.addChildEventListener(_category_child_listener);
		
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
		
		_pass_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				eer = "no";
				String getDeviceID = Build.ID;
				if (_childKey.equals(key)) {
					eer = key;
					status = _childValue.get("Status").toString();
					deviceID = _childValue.get("DeviceID").toString();
					if (status.equals("keyUsed")) {
						if (deviceID.equals(getDeviceID)) {
							ttt = new TimerTask() {
								@Override
								public void run() {
									runOnUiThread(new Runnable() {
										@Override
										public void run() {
											getDateFromDb = _childValue.get("ActivateDate").toString();
											time = Double.parseDouble(_childValue.get("timeNum").toString());
											try{
												SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a",Locale.US);
												Date startDate = sdf.parse(getDateFromDb);
												startDateCalender.setTimeInMillis((long) (startDate.getTime()));
											}
											catch(Exception e){
												e.printStackTrace();
												SketchwareUtil.showMessage(getApplicationContext(), "Error At try and catch");
											}
											startDateCalender.add(Calendar.DAY_OF_MONTH, (int)(time));
											///// Now Calendar
											long n = System.currentTimeMillis();
											Date now = new Date();
											now.setTime(n);
											nowCalendar.setTimeInMillis((long)(now.getTime()));
											if (nowCalendar.getTimeInMillis() < startDateCalender.getTimeInMillis()) {
												if (nowCalendar.getTimeInMillis() < startDateCalender.getTimeInMillis()) {
													
													//startDateCalender.getTimeInMillis();
													
													        long diff = startDateCalender.getTimeInMillis() - nowCalendar.getTimeInMillis();
													
													        Locale useLaocale = Locale.US;
													
													        NumberFormat nf = NumberFormat.getInstance(useLaocale);
													
													
													        long days = diff / (24 * 60 * 60 * 1000);
													        diff -= days * (24 * 60 * 60 * 1000);
													
													        long hours = diff / (60 * 60 * 1000);
													        diff -= hours * (60 * 60 * 1000);
													
													        long minutes = diff / (60 * 1000);
													        diff -= minutes * (60 * 1000);
													
													        long seconds = diff / 1000;
													
													        String days1 = String.valueOf(nf.format(days));
													        String hours1 = String.valueOf(nf.format(hours));
													        String minutes1 = String.valueOf(nf.format(minutes));
													        String Seconds1 = String.valueOf(nf.format(seconds));
													
													
													
													txt.setText(days1+ " day" + " : " +
													            hours1 + " hour" + " : " +
													            minutes1 + " minute" + " : "
													            + Seconds1 + " second");
													((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", String.valueOf((long)(startDateCalender.getTimeInMillis()))));
												}
												else {
													ttt.cancel();
													pass.child(_childKey).removeValue();
												}
											}
											else {
												ttt.cancel();
												pass.child(_childKey).removeValue();
												i.setClass(getApplicationContext(), TeamsActivity.class);
												startActivity(i);
												SketchwareUtil.showMessage(getApplicationContext(), "انتهت صلاحية الكود");
												finish();
											}
										}
									});
								}
							};
							_timer.scheduleAtFixedRate(ttt, (int)(0), (int)(1000));
						}
						else {
							shared.edit().putString("key", "block").commit();
							entimer = new TimerTask() {
								@Override
								public void run() {
									runOnUiThread(new Runnable() {
										@Override
										public void run() {
											ttt.cancel();
											SketchwareUtil.showMessage(getApplicationContext(), "دخول غير مصرح به تم حظرك");
											finish();
										}
									});
								}
							};
							_timer.schedule(entimer, (int)(1000));
						}
					}
					else {
						nowCalendar = Calendar.getInstance();
						m = new HashMap<>();
						m.put("ActivateDate", new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a",Locale.US).format(nowCalendar.getTime()));
						m.put("Status", "keyUsed");
						m.put("DeviceID", getDeviceID);
						pass.child(key).updateChildren(m);
						m.clear();
						SketchwareUtil.showMessage(getApplicationContext(), "تم التفعيل");
						shared.edit().putString("key", key).commit();
					}
				}
				else {
					
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				eer = "no";
				String getDeviceID = Build.ID;
				if (_childKey.equals(key)) {
					eer = key;
					status = _childValue.get("Status").toString();
					deviceID = _childValue.get("DeviceID").toString();
					if (status.equals("keyUsed")) {
						if (deviceID.equals(getDeviceID)) {
							ttt = new TimerTask() {
								@Override
								public void run() {
									runOnUiThread(new Runnable() {
										@Override
										public void run() {
											getDateFromDb = _childValue.get("ActivateDate").toString();
											time = Double.parseDouble(_childValue.get("timeNum").toString());
											try{
												SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a",Locale.US);
												Date startDate = sdf.parse(getDateFromDb);
												startDateCalender.setTimeInMillis((long) (startDate.getTime()));
											}
											catch(Exception e){
												e.printStackTrace();
												SketchwareUtil.showMessage(getApplicationContext(), "Error At try and catch");
											}
											startDateCalender.add(Calendar.DAY_OF_MONTH, (int)(time));
											///// Now Calendar
											long n = System.currentTimeMillis();
											Date now = new Date();
											now.setTime(n);
											nowCalendar.setTimeInMillis((long)(now.getTime()));
											if (nowCalendar.getTimeInMillis() < startDateCalender.getTimeInMillis()) {
												if (nowCalendar.getTimeInMillis() < startDateCalender.getTimeInMillis()) {
													
													//startDateCalender.getTimeInMillis();
													
													        long diff = startDateCalender.getTimeInMillis() - nowCalendar.getTimeInMillis();
													
													        Locale useLaocale = Locale.US;
													
													        NumberFormat nf = NumberFormat.getInstance(useLaocale);
													
													
													        long days = diff / (24 * 60 * 60 * 1000);
													        diff -= days * (24 * 60 * 60 * 1000);
													
													        long hours = diff / (60 * 60 * 1000);
													        diff -= hours * (60 * 60 * 1000);
													
													        long minutes = diff / (60 * 1000);
													        diff -= minutes * (60 * 1000);
													
													        long seconds = diff / 1000;
													
													        String days1 = String.valueOf(nf.format(days));
													        String hours1 = String.valueOf(nf.format(hours));
													        String minutes1 = String.valueOf(nf.format(minutes));
													        String Seconds1 = String.valueOf(nf.format(seconds));
													
													
													
													txt.setText(days1+ " day" + " : " +
													            hours1 + " hour" + " : " +
													            minutes1 + " minute" + " : "
													            + Seconds1 + " second");
													((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", String.valueOf((long)(startDateCalender.getTimeInMillis()))));
												}
												else {
													ttt.cancel();
													pass.child(_childKey).removeValue();
												}
											}
											else {
												ttt.cancel();
												pass.child(_childKey).removeValue();
												i.setClass(getApplicationContext(), TeamsActivity.class);
												startActivity(i);
												SketchwareUtil.showMessage(getApplicationContext(), "انتهت صلاحية الكود");
												finish();
											}
										}
									});
								}
							};
							_timer.scheduleAtFixedRate(ttt, (int)(0), (int)(1000));
						}
						else {
							shared.edit().putString("key", "block").commit();
							entimer = new TimerTask() {
								@Override
								public void run() {
									runOnUiThread(new Runnable() {
										@Override
										public void run() {
											ttt.cancel();
											SketchwareUtil.showMessage(getApplicationContext(), "دخول غير مصرح به تم حظرك");
											finish();
										}
									});
								}
							};
							_timer.schedule(entimer, (int)(1000));
						}
					}
					else {
						nowCalendar = Calendar.getInstance();
						m = new HashMap<>();
						m.put("ActivateDate", new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a",Locale.US).format(nowCalendar.getTime()));
						m.put("Status", "keyUsed");
						m.put("DeviceID", getDeviceID);
						pass.child(key).updateChildren(m);
						m.clear();
						SketchwareUtil.showMessage(getApplicationContext(), "تم التفعيل");
						shared.edit().putString("key", key).commit();
					}
				}
				else {
					
				}
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				eer = "no";
				String getDeviceID = Build.ID;
				if (_childKey.equals(key)) {
					eer = key;
					status = _childValue.get("Status").toString();
					deviceID = _childValue.get("DeviceID").toString();
					if (status.equals("keyUsed")) {
						if (deviceID.equals(getDeviceID)) {
							ttt = new TimerTask() {
								@Override
								public void run() {
									runOnUiThread(new Runnable() {
										@Override
										public void run() {
											getDateFromDb = _childValue.get("ActivateDate").toString();
											time = Double.parseDouble(_childValue.get("timeNum").toString());
											try{
												SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a",Locale.US);
												Date startDate = sdf.parse(getDateFromDb);
												startDateCalender.setTimeInMillis((long) (startDate.getTime()));
											}
											catch(Exception e){
												e.printStackTrace();
												SketchwareUtil.showMessage(getApplicationContext(), "Error At try and catch");
											}
											startDateCalender.add(Calendar.DAY_OF_MONTH, (int)(time));
											///// Now Calendar
											long n = System.currentTimeMillis();
											Date now = new Date();
											now.setTime(n);
											nowCalendar.setTimeInMillis((long)(now.getTime()));
											if (nowCalendar.getTimeInMillis() < startDateCalender.getTimeInMillis()) {
												if (nowCalendar.getTimeInMillis() < startDateCalender.getTimeInMillis()) {
													
													//startDateCalender.getTimeInMillis();
													
													        long diff = startDateCalender.getTimeInMillis() - nowCalendar.getTimeInMillis();
													
													        Locale useLaocale = Locale.US;
													
													        NumberFormat nf = NumberFormat.getInstance(useLaocale);
													
													
													        long days = diff / (24 * 60 * 60 * 1000);
													        diff -= days * (24 * 60 * 60 * 1000);
													
													        long hours = diff / (60 * 60 * 1000);
													        diff -= hours * (60 * 60 * 1000);
													
													        long minutes = diff / (60 * 1000);
													        diff -= minutes * (60 * 1000);
													
													        long seconds = diff / 1000;
													
													        String days1 = String.valueOf(nf.format(days));
													        String hours1 = String.valueOf(nf.format(hours));
													        String minutes1 = String.valueOf(nf.format(minutes));
													        String Seconds1 = String.valueOf(nf.format(seconds));
													
													
													
													txt.setText(days1+ " day" + " : " +
													            hours1 + " hour" + " : " +
													            minutes1 + " minute" + " : "
													            + Seconds1 + " second");
													((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", String.valueOf((long)(startDateCalender.getTimeInMillis()))));
												}
												else {
													ttt.cancel();
													pass.child(_childKey).removeValue();
												}
											}
											else {
												ttt.cancel();
												pass.child(_childKey).removeValue();
												i.setClass(getApplicationContext(), TeamsActivity.class);
												startActivity(i);
												SketchwareUtil.showMessage(getApplicationContext(), "انتهت صلاحية الكود");
												finish();
											}
										}
									});
								}
							};
							_timer.scheduleAtFixedRate(ttt, (int)(0), (int)(1000));
						}
						else {
							shared.edit().putString("key", "block").commit();
							entimer = new TimerTask() {
								@Override
								public void run() {
									runOnUiThread(new Runnable() {
										@Override
										public void run() {
											ttt.cancel();
											SketchwareUtil.showMessage(getApplicationContext(), "دخول غير مصرح به تم حظرك");
											finish();
										}
									});
								}
							};
							_timer.schedule(entimer, (int)(1000));
						}
					}
					else {
						nowCalendar = Calendar.getInstance();
						m = new HashMap<>();
						m.put("ActivateDate", new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a",Locale.US).format(nowCalendar.getTime()));
						m.put("Status", "keyUsed");
						m.put("DeviceID", getDeviceID);
						pass.child(key).updateChildren(m);
						m.clear();
						SketchwareUtil.showMessage(getApplicationContext(), "تم التفعيل");
						shared.edit().putString("key", key).commit();
					}
				}
				else {
					
				}
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		pass.addChildEventListener(_pass_child_listener);
	}
	
	private void initializeLogic() {
		_Setting();
		.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)10, 0xFFFFFFFF));
		_ICC(iv1, "#CBD0DA", "#000000");
		_RippleEffects("#e0e0e0", iv1);
		_ICC(imageview2, "#CBD0DA", "#000000");
		_RippleEffects("#e0e0e0", imageview2);
		_Drawer_Ui();
		_OnCreate();
		_changeActivityFont("neosansarabic");
		gridview1.setSelector(android.R.color.transparent);
		t = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						
						//Http canary
						
						final AlertDialog dialog = new 
						
						//غير الأسماء
						 AlertDialog.Builder(CategoryActivity.this).create();
						LayoutInflater inflater = getLayoutInflater();
						
						View convertView = (View) inflater.inflate(R.layout.exit, null);
						dialog.setView(convertView);
						//تعريف العناصر
						
						TextView txt1 = (TextView)convertView.findViewById(R.id.textview1);
						
						Button btn1 = (Button)convertView.findViewById(R.id.button1);
						
						ImageView imageview1= (ImageView)convertView.findViewById(R.id.imageview1);
						
						final LinearLayout linear  = (LinearLayout)convertView.findViewById(R.id.linear1);
						
						txt1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
						
						btn1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
						
						//الضغط على الأيقونات
						
						btn1.setOnClickListener(new View.OnClickListener() {
							public void onClick(View v) {
								dialog.dismiss();
								_bt1();
							}});
						
						//الحواف دائرية
						android.graphics.drawable.GradientDrawable wd = new android.graphics.drawable.GradientDrawable();
						wd.setColor(Color.parseColor("#e0e0e0"));
						wd.setCornerRadius((int)20f);
						linear.setBackground(wd);
						
						android.graphics.drawable.GradientDrawable w = new android.graphics.drawable.GradientDrawable();
						w.setColor(Color.parseColor("#23286A"));
						w.setCornerRadius((int)20f);
						btn1.setBackground(w);
						
						boolean isAppInstalled = appInstalledOrNot("com.guoshi.httpcanary"); if(isAppInstalled) {dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
							dialog.show();dialog.setCancelable(false);} else {}
					}
					private boolean appInstalledOrNot(String uri) { android.content.pm.PackageManager pm = getPackageManager(); try { pm.getPackageInfo(uri, android.content.pm.PackageManager.GET_ACTIVITIES); return true; } catch (android.content.pm.PackageManager.NameNotFoundException e) { } return false;
					}
				});
			}
		};
		_timer.schedule(t, (int)(0));
		t = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						
						//NetCapture
						
						final AlertDialog dialog = new 
						
						//غير الأسماء
						 AlertDialog.Builder(CategoryActivity.this).create();
						LayoutInflater inflater = getLayoutInflater();
						
						View convertView = (View) inflater.inflate(R.layout.exit0, null);
						dialog.setView(convertView);
						
						//تعريف العناصر
						
						TextView txt1 = (TextView)convertView.findViewById(R.id.textview1);
						
						Button btn1 = (Button)convertView.findViewById(R.id.button1);
						
						ImageView imageview1= (ImageView)convertView.findViewById(R.id.imageview1);
						
						final LinearLayout linear  = (LinearLayout)convertView.findViewById(R.id.linear1);
						
						txt1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
						
						btn1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
						
						//الضغط على الأيقونات
						
						btn1.setOnClickListener(new View.OnClickListener() {
							public void onClick(View v) {
								dialog.dismiss();
								_bt1();
							}});
						
						//الحواف دائرية
						android.graphics.drawable.GradientDrawable wd = new android.graphics.drawable.GradientDrawable();
						wd.setColor(Color.parseColor("#e0e0e0"));
						wd.setCornerRadius((int)20f);
						linear.setBackground(wd);
						
						android.graphics.drawable.GradientDrawable w = new android.graphics.drawable.GradientDrawable();
						w.setColor(Color.parseColor("#23286A"));
						w.setCornerRadius((int)20f);
						btn1.setBackground(w);
						
						boolean isAppInstalled = appInstalledOrNot("com.minhui.networkcapture"); if(isAppInstalled) { dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
							dialog.show();dialog.setCancelable(false);} else {}
					}
					private boolean appInstalledOrNot(String uri) { android.content.pm.PackageManager pm = getPackageManager(); try { pm.getPackageInfo(uri, android.content.pm.PackageManager.GET_ACTIVITIES); return true; } catch (android.content.pm.PackageManager.NameNotFoundException e) { } return false;
					}
				});
			}
		};
		_timer.schedule(t, (int)(5));
		t = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						
						//Packet Capture 
						
						final AlertDialog dialog = new 
						
						//غير الأسماء
						 AlertDialog.Builder(CategoryActivity.this).create();
						LayoutInflater inflater = getLayoutInflater();
						
						View convertView = (View) inflater.inflate(R.layout.exit1, null);
						dialog.setView(convertView);
						//تعريف العناصر
						
						TextView txt1 = (TextView)convertView.findViewById(R.id.textview1);
						
						Button btn1 = (Button)convertView.findViewById(R.id.button1);
						
						ImageView imageview1= (ImageView)convertView.findViewById(R.id.imageview1);
						
						final LinearLayout linear  = (LinearLayout)convertView.findViewById(R.id.linear1);
						
						txt1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
						
						btn1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
						
						//الضغط على الأيقونات
						
						btn1.setOnClickListener(new View.OnClickListener() {
							public void onClick(View v) {
								dialog.dismiss();
								_bt1();
							}});
						
						//الحواف دائرية
						android.graphics.drawable.GradientDrawable wd = new android.graphics.drawable.GradientDrawable();
						wd.setColor(Color.parseColor("#e0e0e0"));
						wd.setCornerRadius((int)20f);
						linear.setBackground(wd);
						
						android.graphics.drawable.GradientDrawable w = new android.graphics.drawable.GradientDrawable();
						w.setColor(Color.parseColor("#23286A"));
						w.setCornerRadius((int)20f);
						btn1.setBackground(w);
						
						boolean isAppInstalled = appInstalledOrNot("app.greyshirts.sslcapture"); if(isAppInstalled) {dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
							dialog.show();dialog.setCancelable(false);} else {}
					}
					private boolean appInstalledOrNot(String uri) { android.content.pm.PackageManager pm = getPackageManager(); try { pm.getPackageInfo(uri, android.content.pm.PackageManager.GET_ACTIVITIES); return true; } catch (android.content.pm.PackageManager.NameNotFoundException e) { } return false;
					}
				});
			}
		};
		_timer.schedule(t, (int)(10));
		if (settings.getString("join", "").equals("no")) {
			
		}
		else {
			if (settings.getString("join", "").equals("")) {
				settings.edit().putString("join", "1").commit();
			}
			else {
				if (settings.getString("join", "").equals("5")) {
					settings.edit().putString("join", "no").commit();
					final AlertDialog dialog = new 
					
					//غير الأسماء
					 AlertDialog.Builder(CategoryActivity.this).create();
					LayoutInflater inflater = getLayoutInflater();
					
					View convertView = (View) inflater.inflate(R.layout.join, null);
					dialog.setView(convertView);
					
					//تعريف العناصر
					
					TextView txt1 = (TextView)convertView.findViewById(R.id.textview1);
					
					Button btn1 = (Button)convertView.findViewById(R.id.button1);
					
					ImageView imageview1= (ImageView)convertView.findViewById(R.id.imageview1);
					
					final LinearLayout linear  = (LinearLayout)convertView.findViewById(R.id.linear1);
					
					txt1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
					
					btn1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
					
					//الضغط على الأيقونات
					
					btn1.setOnClickListener(new View.OnClickListener() {
						public void onClick(View v) { 
							dialog.dismiss();
							_join();
						}});
					//الحواف دائرية
					android.graphics.drawable.GradientDrawable wd = new android.graphics.drawable.GradientDrawable();
					wd.setColor(Color.parseColor("#e0e0e0"));
					wd.setCornerRadius((int)20f);
					linear.setBackground(wd);
					
					android.graphics.drawable.GradientDrawable d = new android.graphics.drawable.GradientDrawable();
					d.setColor(Color.parseColor("#78022C"));
					d.setCornerRadius((int)20f);
					btn1.setBackground(d);
					
					dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
					dialog.show();dialog.setCancelable(false);
				}
				else {
					settings.edit().putString("join", String.valueOf((long)(Double.parseDouble(settings.getString("join", "")) + 1))).commit();
				}
			}
		}
		if (shared.getString("key", "").equals("") || !shared.getString("key", "").contains("MTX-")) {
			final AlertDialog dialog = new 
			
			//غير الأسماء
			 AlertDialog.Builder(CategoryActivity.this).create();
			LayoutInflater inflater = getLayoutInflater();
			
			View convertView = (View) inflater.inflate(R.layout.unsafe, null);
			dialog.setView(convertView);
			
			//تعريف العناصر
			
			TextView txt1 = (TextView)convertView.findViewById(R.id.textview1);
			
			Button btn1 = (Button)convertView.findViewById(R.id.button1);
			
			ImageView imageview1= (ImageView)convertView.findViewById(R.id.imageview1);
			
			final LinearLayout linear  = (LinearLayout)convertView.findViewById(R.id.linear1);
			
			txt1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
			
			btn1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
			
			//الضغط على الأيقونات
			
			btn1.setOnClickListener(new View.OnClickListener() {
				public void onClick(View v) { 
					dialog.dismiss();
					_bt11();
				}});
			//الحواف دائرية
			android.graphics.drawable.GradientDrawable wd = new android.graphics.drawable.GradientDrawable();
			wd.setColor(Color.parseColor("#e0e0e0"));
			wd.setCornerRadius((int)20f);
			linear.setBackground(wd);
			
			android.graphics.drawable.GradientDrawable d = new android.graphics.drawable.GradientDrawable();
			d.setColor(Color.parseColor("#78022C"));
			d.setCornerRadius((int)20f);
			btn1.setBackground(d);
			
			dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
			dialog.show();dialog.setCancelable(false);
			shared.edit().putString("key", "block").commit();
			entimer = new TimerTask() {
				@Override
				public void run() {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							t.cancel();
						}
					});
				}
			};
			_timer.schedule(entimer, (int)(1000));
		}
		else {
			key = shared.getString("key", "");
		}
		entimer = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						if (!txt.getText().toString().contains("hour") || (!txt.getText().toString().contains("day") || txt.getText().toString().equals(""))) {
							final AlertDialog dialog = new 
							
							//غير الأسماء
							 AlertDialog.Builder(CategoryActivity.this).create();
							LayoutInflater inflater = getLayoutInflater();
							
							View convertView = (View) inflater.inflate(R.layout.unsafe, null);
							dialog.setView(convertView);
							
							//تعريف العناصر
							
							TextView txt1 = (TextView)convertView.findViewById(R.id.textview1);
							
							Button btn1 = (Button)convertView.findViewById(R.id.button1);
							
							ImageView imageview1= (ImageView)convertView.findViewById(R.id.imageview1);
							
							final LinearLayout linear  = (LinearLayout)convertView.findViewById(R.id.linear1);
							
							txt1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
							
							btn1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
							
							//الضغط على الأيقونات
							
							btn1.setOnClickListener(new View.OnClickListener() {
								public void onClick(View v) { 
									dialog.dismiss();
									_bt11();
								}});
							//الحواف دائرية
							android.graphics.drawable.GradientDrawable wd = new android.graphics.drawable.GradientDrawable();
							wd.setColor(Color.parseColor("#e0e0e0"));
							wd.setCornerRadius((int)20f);
							linear.setBackground(wd);
							
							android.graphics.drawable.GradientDrawable d = new android.graphics.drawable.GradientDrawable();
							d.setColor(Color.parseColor("#78022C"));
							d.setCornerRadius((int)20f);
							btn1.setBackground(d);
							
							dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
							dialog.show();dialog.setCancelable(false);
							shared.edit().putString("key", "block").commit();
							entimer = new TimerTask() {
								@Override
								public void run() {
									runOnUiThread(new Runnable() {
										@Override
										public void run() {
											t.cancel();
										}
									});
								}
							};
							_timer.schedule(entimer, (int)(1000));
						}
						else {
							
						}
					}
				});
			}
		};
		_timer.schedule(entimer, (int)(5000));
	}
	
	@Override
	public void onBackPressed() {
		if (false) {
			
		}
		else {
			final AlertDialog dialog = new 
			
			//غير الأسماء
			 AlertDialog.Builder(CategoryActivity.this).create();
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
	}
	public void _style_2(final View _view, final double _r, final double _shadow, final double _str, final String _str_color, final String _color) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		gd.setColor(Color.parseColor(_color));
		gd.setCornerRadius((int)_r);
		gd.setStroke((int)_str,Color.parseColor(_str_color));
		_view.setBackground(gd);
		_view.setElevation((int)_shadow);
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
		_ICC(_drawer_imageview4, "#CBD0DA", "#000000");
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
	
	
	public void _bt5() {
		
	}
	
	
	public void _img2() {
		
	}
	
	
	public void _img3() {
		
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
			linear13.setBackgroundColor(0xFFE0E0E0);
		}
		else {
			linear13.setBackgroundColor(0xFF303030);
		}
		if (settings.getString("language", "").equals("AR")) {
			
			
			
		}
		else {
			
			
			
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
	
	
	public void _join() {
		i.setAction(Intent.ACTION_VIEW);
		i.setData(Uri.parse("https://t.me/MTXTV"));
		startActivity(i);
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
	
	
	public void _bt111() {
		
	}
	
	public class Gridview1Adapter extends BaseAdapter {
		
		ArrayList<HashMap<String, Object>> _data;
		
		public Gridview1Adapter(ArrayList<HashMap<String, Object>> _arr) {
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
				_view = _inflater.inflate(R.layout.category_custom, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			
			textview1.setEllipsize(TextUtils.TruncateAt.MARQUEE);
			textview1.setMarqueeRepeatLimit(-1);
			textview1.setSingleLine(true);
			textview1.setSelected(true);
			if (_data.get((int)_position).containsKey("name")) {
				textview1.setText(_data.get((int)_position).get("name").toString());
			}
			if (_data.get((int)_position).containsKey("img")) {
				Glide.with(getApplicationContext()).load(Uri.parse(_data.get((int)_position).get("img").toString())).into(imageview1);
			}
			if (settings.getString("theme", "").equals("Light")) {
				textview1.setTextColor(0xFF000000);
				linear1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)10, 0xFFFFFFFF));
			}
			else {
				textview1.setTextColor(0xFFFFFFFF);
				linear1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)10, 0xFF000000));
			}
			textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
			
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