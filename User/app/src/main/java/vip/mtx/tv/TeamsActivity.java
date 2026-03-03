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
import android.text.Editable;
import android.text.TextWatcher;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
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
import com.bumptech.glide.Glide;

public class TeamsActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private String fontName = "";
	private String typeace = "";
	private HashMap<String, Object> m = new HashMap<>();
	private String getDateFromDb = "";
	private double time = 0;
	private String getKeyFromUser = "";
	private String key = "";
	private String status = "";
	private String deviceID = "";
	
	private ArrayList<HashMap<String, Object>> map = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private TextView textview1;
	private TextView txt;
	private ImageView imageview1;
	private LinearLayout linear3;
	private LinearLayout linear5;
	private Button button3;
	private LinearLayout linear4;
	private EditText edittext1;
	private ImageView imageview2;
	private Button button2;
	private Button button1;
	
	private DatabaseReference pass = _firebase.getReference("pass");
	private ChildEventListener _pass_child_listener;
	private Intent i = new Intent();
	private TimerTask t;
	private SharedPreferences settings;
	private TimerTask entimer;
	private SharedPreferences shared;
	private Calendar startDateCalender = Calendar.getInstance();
	private Calendar nowCalendar = Calendar.getInstance();
	private Intent x = new Intent();
	private Calendar cal = Calendar.getInstance();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.teams);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		linear2 = findViewById(R.id.linear2);
		textview1 = findViewById(R.id.textview1);
		txt = findViewById(R.id.txt);
		imageview1 = findViewById(R.id.imageview1);
		linear3 = findViewById(R.id.linear3);
		linear5 = findViewById(R.id.linear5);
		button3 = findViewById(R.id.button3);
		linear4 = findViewById(R.id.linear4);
		edittext1 = findViewById(R.id.edittext1);
		imageview2 = findViewById(R.id.imageview2);
		button2 = findViewById(R.id.button2);
		button1 = findViewById(R.id.button1);
		settings = getSharedPreferences("settings", Activity.MODE_PRIVATE);
		shared = getSharedPreferences("shared", Activity.MODE_PRIVATE);
		
		button3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setAction(Intent.ACTION_VIEW);
				i.setData(Uri.parse("https://t.me/mtxtv/579"));
				startActivity(i);
			}
		});
		
		linear4.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		edittext1.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				textview1.setText(_charSeq);
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				
			}
		});
		
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				_asdasda(8, txt);
				m = new HashMap<>();
				m.put("Key", "MTX-".concat(txt.getText().toString()));
				m.put("ActivateDate", new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a",Locale.US).format(nowCalendar.getTime()));
				m.put("DeviceID", "Empty");
				m.put("KeyStatus", "Active");
				m.put("timeNum", "14");
				m.put("Status", "key has not been used yet");
				m.put("Time", "14".concat(" ".concat("Days")));
				pass.child("MTX-".concat(txt.getText().toString())).updateChildren(m);
				m.clear();
				i.setClass(getApplicationContext(), GetkayActivity.class);
				i.putExtra("key", "MTX-".concat(txt.getText().toString()));
				startActivity(i);
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (edittext1.getText().toString().equals("")) {
					((EditText)edittext1).setError("يجب اضافة كود اولا");
				}
				else {
					getKeyFromUser = textview1.getText().toString();
					getKeyFromUser = textview1.getText().toString();
					        com.google.firebase.database.Query query = pass;
					                        query.orderByChild("Key").equalTo(getKeyFromUser).addListenerForSingleValueEvent(new ValueEventListener() {
						                              @Override
						                              public void onDataChange(DataSnapshot snapshot) {
							                                    if (snapshot.exists()){
																		
																		
																		
								
								                                      //String key = snapshot.child(getKeyFromUser).child("Key").getValue(String.class);
								                          String deviceID = snapshot.child(getKeyFromUser).child("DeviceID").getValue(String.class);
								                          String status = snapshot.child(getKeyFromUser).child("Status").getValue(String.class);
								                          String getDeviceID = Build.ID;
														  
														 
														  
															   
															   
														
								                           if (status.equals("keyUsed")){
									                            if (deviceID.equals(getDeviceID)){
										                              Intent intent  = new Intent(TeamsActivity.this,CategoryActivity.class);
										                              intent.putExtra("key",getKeyFromUser);
										                              startActivity(intent);
										                              Toast.makeText(getApplicationContext(),"تم التفعيل",Toast.LENGTH_LONG).show();
										key = textview1.getText().toString();
										shared.edit().putString("key", key).commit();
										                            }else{
										                              Toast.makeText(getApplicationContext(),"عفوا هذا المفتاح مستخدم مسبقا",Toast.LENGTH_LONG).show();
										                            }
									                          }else{
									                            long getDate = System.currentTimeMillis();
													Date date1 = new Date();
													date1.setTime(getDate);
													cal.setTime(date1);
													m = new HashMap<>();
													m.put("DeviceID", Build.ID);
													m.put("Status", "keyUsed");
													m.put("ActivateDate", new SimpleDateFormat("dd-MM-yyyy hh:mm:ss a",Locale.US).format(cal.getTime()));
													pass.child(getKeyFromUser).updateChildren(m);
													i.setClass(getApplicationContext(), CategoryActivity.class);
													i.putExtra("key", textview1.getText().toString());
													startActivity(i);
													m.clear();
									key = textview1.getText().toString();
									shared.edit().putString("key", key).commit();
									                          }
												
														  
								
								                          }else{
								                          Toast.makeText(getApplicationContext(),"هذا الكود غير صحيح تاكد من الادخال",Toast.LENGTH_LONG).show();
								                        }
													
													
												}
						                                
						          
						                              @Override
						                              public void onCancelled(DatabaseError error) {
							
							                                }
						                          });
				}
			}
		});
		
		_pass_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (key.equals("NO")) {
					linear2.setVisibility(View.VISIBLE);
					_telegramLoaderDialog(false);
				}
				else {
					String getDeviceID = Build.ID;
					if (_childKey.equals(key)) {
						status = _childValue.get("Status").toString();
						deviceID = _childValue.get("DeviceID").toString();
						if (status.equals("keyUsed")) {
							if (deviceID.equals(getDeviceID)) {
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
										x.setClass(getApplicationContext(), CategoryActivity.class);
										startActivity(x);
										shared.edit().putString("key", key).commit();
										_telegramLoaderDialog(false);
									}
									else {
										pass.child(_childKey).removeValue();
										shared.edit().remove("key").commit();
										_telegramLoaderDialog(false);
									}
								}
								else {
									pass.child(_childKey).removeValue();
									shared.edit().remove("key").commit();
									SketchwareUtil.showMessage(getApplicationContext(), "انتهت صلاحية الكود");
									linear2.setVisibility(View.VISIBLE);
									_telegramLoaderDialog(false);
								}
							}
							else {
								shared.edit().remove("key").commit();
								SketchwareUtil.showMessage(getApplicationContext(), "عفوا هذا المفتاح مستخدم مسبقا");
								linear2.setVisibility(View.VISIBLE);
								_telegramLoaderDialog(false);
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
							x.setClass(getApplicationContext(), CategoryActivity.class);
							startActivity(x);
							shared.edit().putString("key", key).commit();
							_telegramLoaderDialog(false);
						}
					}
					else {
						entimer = new TimerTask() {
							@Override
							public void run() {
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										linear2.setVisibility(View.VISIBLE);
										_telegramLoaderDialog(false);
									}
								});
							}
						};
						_timer.schedule(entimer, (int)(1000));
					}
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (key.equals("NO")) {
					linear2.setVisibility(View.VISIBLE);
					_telegramLoaderDialog(false);
				}
				else {
					String getDeviceID = Build.ID;
					if (_childKey.equals(key)) {
						status = _childValue.get("Status").toString();
						deviceID = _childValue.get("DeviceID").toString();
						if (status.equals("keyUsed")) {
							if (deviceID.equals(getDeviceID)) {
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
										x.setClass(getApplicationContext(), CategoryActivity.class);
										startActivity(x);
										shared.edit().putString("key", key).commit();
										_telegramLoaderDialog(false);
									}
									else {
										pass.child(_childKey).removeValue();
										shared.edit().remove("key").commit();
										_telegramLoaderDialog(false);
									}
								}
								else {
									pass.child(_childKey).removeValue();
									shared.edit().remove("key").commit();
									SketchwareUtil.showMessage(getApplicationContext(), "انتهت صلاحية الكود");
									linear2.setVisibility(View.VISIBLE);
									_telegramLoaderDialog(false);
								}
							}
							else {
								shared.edit().remove("key").commit();
								SketchwareUtil.showMessage(getApplicationContext(), "عفوا هذا المفتاح مستخدم مسبقا");
								linear2.setVisibility(View.VISIBLE);
								_telegramLoaderDialog(false);
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
							x.setClass(getApplicationContext(), CategoryActivity.class);
							startActivity(x);
							shared.edit().putString("key", key).commit();
							_telegramLoaderDialog(false);
						}
					}
					else {
						t = new TimerTask() {
							@Override
							public void run() {
								runOnUiThread(new Runnable() {
									@Override
									public void run() {
										linear2.setVisibility(View.VISIBLE);
										_telegramLoaderDialog(false);
									}
								});
							}
						};
						_timer.schedule(t, (int)(1000));
					}
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
		_telegramLoaderDialog(true);
		if (shared.getString("key", "").equals("")) {
			key = "NO";
		}
		else {
			key = shared.getString("key", "");
		}
		linear1.setBackgroundColor(0xFF78022C);
		linear2.setVisibility(View.GONE);
		_style_2(edittext1, 5, 2, 2, "#ffffff", "#78022C");
		_style_2(linear4, 90, 5, 5, "#ffffff", "#ffffff");
		_style_2(button1, 10, 5, 5, "#ffffff", "#ffffff");
		_style_2(button2, 10, 5, 5, "#bdbdbd", "#bdbdbd");
		_style_2(button3, 10, 5, 5, "#212121", "#212121");
		_changeActivityFont("neosansarabic");
	}
	
	@Override
	public void onBackPressed() {
		final AlertDialog dialog = new 
		
		//غير الأسماء
		 AlertDialog.Builder(TeamsActivity.this).create();
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
		w.setColor(Color.parseColor("#23286A"));
		w.setCornerRadius((int)20f);
		btn1.setBackground(w);
		
		
		android.graphics.drawable.GradientDrawable wd = new android.graphics.drawable.GradientDrawable();
		wd.setColor(Color.parseColor("#23286A"));
		wd.setCornerRadius((int)20f);
		btn2.setBackground(wd);
		
		dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);dialog.show();
	}
	
	
	@Override
	public void onStart() {
		super.onStart();
		pass.addChildEventListener(_pass_child_listener);
	}
	
	@Override
	public void onStop() {
		super.onStop();
		pass.removeEventListener(_pass_child_listener);
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
	
	
	public void _style_2(final View _view, final double _r, final double _shadow, final double _str, final String _str_color, final String _color) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		gd.setColor(Color.parseColor(_color));
		gd.setCornerRadius((int)_r);
		gd.setStroke((int)_str,Color.parseColor(_str_color));
		_view.setBackground(gd);
		_view.setElevation((int)_shadow);
	}
	
	
	public void _bt1() {
		finishAffinity();
	}
	
	
	public void _bt2() {
		
	}
	
	
	public void _bt5() {
		
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
	
	
	public void _Setting() {
		if (settings.getString("language", "").equals("AR")) {
			edittext1.setHint("ادخل كود التفعيل");
			button1.setText("تفعيل");
			button2.setText("الحصول علي كود التفعيل");
			button3.setText("طريقة الحصول علي كود تفعيل");
		}
		else {
			edittext1.setHint("Enter The Activation Code");
			button1.setText("Activate");
			button2.setText("Get The Activation Code");
			button3.setText("How to get the activation code");
		}
		if (settings.getString("theme", "").equals("Light")) {
			
		}
		else {
			
		}
	}
	
	
	public void _asdasda(final double _length, final TextView _text) {
		StringBuilder a1 = new StringBuilder();
		
		Random random = new Random();
		
		while (a1.length() < ((int)_length))
		
		{
			
			a1.append("1234567890".charAt((int)(random.nextFloat() * (float)"1234567890".length())));
			
		} 
		
		_text.setText(a1); 
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