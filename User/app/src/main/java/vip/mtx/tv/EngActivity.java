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
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.exoplayer2.ui.*;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
import com.google.firebase.iid.FirebaseInstanceId;
import com.google.firebase.iid.InstanceIdResult;
import com.google.firebase.messaging.FirebaseMessaging;
import com.monstertechno.adblocker.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import meorg.jsoup.*;
import org.json.*;

public class EngActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private HashMap<String, Object> m = new HashMap<>();
	private String packagee = "";
	private String sing = "";
	
	private LinearLayout linear3;
	private LinearLayout linear1;
	private LinearLayout linear2;
	private ImageView imageview1;
	
	private Intent i = new Intent();
	private TimerTask ti;
	private ObjectAnimator a = new ObjectAnimator();
	private ObjectAnimator b = new ObjectAnimator();
	private ObjectAnimator c = new ObjectAnimator();
	private ObjectAnimator d = new ObjectAnimator();
	private RequestNetwork connect;
	private RequestNetwork.RequestListener _connect_request_listener;
	
	private OnCompleteListener FCM_onCompleteListener;
	private TimerTask t;
	private ObjectAnimator object = new ObjectAnimator();
	private DatabaseReference stop = _firebase.getReference("stop");
	private ChildEventListener _stop_child_listener;
	private DatabaseReference update = _firebase.getReference("update");
	private ChildEventListener _update_child_listener;
	private AlertDialog.Builder dialog;
	private SharedPreferences settings;
	private TimerTask tm;
	private TimerTask tt;
	private SharedPreferences shared;
	private TimerTask xtt;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.eng);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear3 = findViewById(R.id.linear3);
		linear1 = findViewById(R.id.linear1);
		linear2 = findViewById(R.id.linear2);
		imageview1 = findViewById(R.id.imageview1);
		connect = new RequestNetwork(this);
		dialog = new AlertDialog.Builder(this);
		settings = getSharedPreferences("settings", Activity.MODE_PRIVATE);
		shared = getSharedPreferences("shared", Activity.MODE_PRIVATE);
		
		_connect_request_listener = new RequestNetwork.RequestListener() {
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
				final AlertDialog dialog = new 
				
				//غير الأسماء
				 AlertDialog.Builder(EngActivity.this).create();
				LayoutInflater inflater = getLayoutInflater();
				
				View convertView = (View) inflater.inflate(R.layout.exit4, null);
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
				
				android.graphics.drawable.GradientDrawable d = new android.graphics.drawable.GradientDrawable();
				d.setColor(Color.parseColor("#78022C"));
				d.setCornerRadius((int)20f);
				btn1.setBackground(d);
				
				dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
				dialog.show();dialog.setCancelable(false);
				t.cancel();
				ti.cancel();
			}
		};
		
		FCM_onCompleteListener = new OnCompleteListener<InstanceIdResult>() {
			@Override
			public void onComplete(Task<InstanceIdResult> task) {
				final boolean _success = task.isSuccessful();
				final String _token = task.getResult().getToken();
				final String _errorMessage = task.getException() != null ? task.getException().getMessage() : "";
				
			}
		};
		
		_stop_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childValue.get("stoped").toString().equals("off")) {
					final AlertDialog dialog = new 
					
					//غير الأسماء
					 AlertDialog.Builder(EngActivity.this).create();
					LayoutInflater inflater = getLayoutInflater();
					
					View convertView = (View) inflater.inflate(R.layout.seana, null);
					dialog.setView(convertView);
					
					//تعريف العناصر
					
					TextView txt1 = (TextView)convertView.findViewById(R.id.textview1);
					
					Button btn2 = (Button)convertView.findViewById(R.id.Button2);
					
					ImageView imageview1= (ImageView)convertView.findViewById(R.id.imageview1);
					
					final LinearLayout linear1  = (LinearLayout)convertView.findViewById(R.id.pop);
					
					final LinearLayout linear2  = (LinearLayout)convertView.findViewById(R.id.box);
					
					final LinearLayout linear3  = (LinearLayout)convertView.findViewById(R.id.tybe);
					
					txt1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
					
					btn2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
					
					//الضغط على الأيقونات
					
					btn2.setOnClickListener(new View.OnClickListener() {
						public void onClick(View v) {
							dialog.dismiss();
							_bt4(); 
						}});
					
					//الحواف دائرية
					android.graphics.drawable.GradientDrawable d = new android.graphics.drawable.GradientDrawable();
					d.setColor(Color.parseColor("#e0e0e0"));
					d.setCornerRadius((int)20f);
					linear1.setBackground(d);
					
					android.graphics.drawable.GradientDrawable yd = new android.graphics.drawable.GradientDrawable();
					yd.setColor(Color.parseColor("#e0e0e0"));
					yd.setCornerRadius((int)20f);
					linear2.setBackground(yd);
					
					android.graphics.drawable.GradientDrawable wd = new android.graphics.drawable.GradientDrawable();
					wd.setColor(Color.parseColor("#78022C"));
					wd.setCornerRadius((int)20f);
					btn2.setBackground(wd);
					
					dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
					dialog.show();dialog.setCancelable(false);
					t.cancel();
					ti.cancel();
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
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
		stop.addChildEventListener(_stop_child_listener);
		
		_update_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childValue.get("updatee").toString().equals("on")) {
					if (!((Double.parseDouble(_childValue.get("Version").toString()) < 10) || (Double.parseDouble(_childValue.get("Version").toString()) == 10))) {
						m.put("url", _childValue.get("URL").toString());
						final AlertDialog dialog = new 
						
						//غير الأسماء
						 AlertDialog.Builder(EngActivity.this).create();
						LayoutInflater inflater = getLayoutInflater();
						
						View convertView = (View) inflater.inflate(R.layout.update, null);
						dialog.setView(convertView);
						
						//تعريف العناصر
						
						TextView txt1 = (TextView)convertView.findViewById(R.id.textview1);
						
						Button btn1 = (Button)convertView.findViewById(R.id.Button1);
						
						Button btn2 = (Button)convertView.findViewById(R.id.Button2);
						
						ImageView imageview1= (ImageView)convertView.findViewById(R.id.imageview1);
						
						final LinearLayout linear1  = (LinearLayout)convertView.findViewById(R.id.pop);
						
						final LinearLayout linear2  = (LinearLayout)convertView.findViewById(R.id.box);
						
						final LinearLayout linear3  = (LinearLayout)convertView.findViewById(R.id.tybe);
						
						txt1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
						
						btn1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
						
						btn2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
						
						//الضغط على الأيقونات
						
						btn1.setOnClickListener(new View.OnClickListener() {
							public void onClick(View v) {
								dialog.dismiss();
								_bt3();
							}});
						
						btn2.setOnClickListener(new View.OnClickListener() {
							public void onClick(View v) {
								dialog.dismiss();
								_bt4(); 
							}});
						
						//الحواف دائرية
						android.graphics.drawable.GradientDrawable d = new android.graphics.drawable.GradientDrawable();
						d.setColor(Color.parseColor("#e0e0e0"));
						d.setCornerRadius((int)20f);
						linear1.setBackground(d);
						
						android.graphics.drawable.GradientDrawable yd = new android.graphics.drawable.GradientDrawable();
						yd.setColor(Color.parseColor("#e0e0e0"));
						yd.setCornerRadius((int)20f);
						linear2.setBackground(yd);
						
						android.graphics.drawable.GradientDrawable w = new android.graphics.drawable.GradientDrawable();
						w.setColor(Color.parseColor("#78022C"));
						w.setCornerRadius((int)20f);
						btn1.setBackground(w);
						
						
						android.graphics.drawable.GradientDrawable wd = new android.graphics.drawable.GradientDrawable();
						wd.setColor(Color.parseColor("#78022C"));
						wd.setCornerRadius((int)20f);
						btn2.setBackground(wd);
						
						dialog.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
						dialog.show();dialog.setCancelable(false);
						t.cancel();
						ti.cancel();
					}
				}
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				
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
		update.addChildEventListener(_update_child_listener);
	}
	
	private void initializeLogic() {
		_Check();
		_Setting();
		FirebaseMessaging.getInstance().subscribeToTopic("notif")
		        .addOnCompleteListener(new OnCompleteListener() {
			            @Override
			            public void onComplete(@NonNull Task task) {
				                String msg = "ستتلقى اشعارات 😅";
				                if (!task.isSuccessful()) {
					                    msg = "تم ايقاف الاشعارات 😭";
					                }
				            }
			        });
		
		startService(new Intent(getApplicationContext(),BackServices.class));
		connect.startRequestNetwork(RequestNetworkController.GET, "https://www.google.com", "hh", _connect_request_listener);
		linear2.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b, int c, int d) { this.setCornerRadius(a); this.setStroke(b, c); this.setColor(d); return this; } }.getIns((int)555, (int)0, Color.TRANSPARENT, 0xFFEEEEEE));
		a.setTarget(linear2);
		a.setPropertyName("alpha");
		a.setFloatValues((float)(0), (float)(1));
		a.setDuration((int)(400));
		a.start();
		t = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						a.setTarget(linear2);
						a.setPropertyName("scaleX");
						a.setFloatValues((float)(1), (float)(20));
						a.setDuration((int)(800));
						a.start();
						c.setTarget(imageview1);
						c.setPropertyName("scaleX");
						c.setFloatValues((float)(1), (float)(0));
						c.setDuration((int)(300));
						c.start();
						if (true) {
							d.setTarget(imageview1);
							d.setPropertyName("scaleY");
							d.setFloatValues((float)(1), (float)(0));
							d.setDuration((int)(300));
							d.start();
						}
						b.setTarget(linear2);
						b.setPropertyName("scaleY");
						b.setFloatValues((float)(1), (float)(20));
						b.setDuration((int)(800));
						b.start();
					}
				});
			}
		};
		_timer.schedule(t, (int)(2000));
		linear3.setVisibility(View.VISIBLE);
		if (settings.getString("activity", "").equals("")) {
			ti = new TimerTask() {
				@Override
				public void run() {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							i.setClass(getApplicationContext(), AllActivity.class);
							startActivity(i);
							overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
							finish();
						}
					});
				}
			};
			_timer.schedule(ti, (int)(2800));
		}
		else {
			ti = new TimerTask() {
				@Override
				public void run() {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							i.setClass(getApplicationContext(), TeamsActivity.class);
							startActivity(i);
							overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
							finish();
						}
					});
				}
			};
			_timer.schedule(ti, (int)(2800));
		}
	}
	
	@Override
	public void onStart() {
		super.onStart();
		_Check();
		_Setting();
		stop.addChildEventListener(_stop_child_listener);
		update.addChildEventListener(_update_child_listener);
	}
	
	@Override
	public void onStop() {
		super.onStop();
		_Setting();
		stop.removeEventListener(_stop_child_listener);
		update.removeEventListener(_update_child_listener);
	}
	public void _notification(final String _Title, final String _Content) {
		final Context context = getApplicationContext();
		
		
		NotificationManager notificationManager = (NotificationManager) context.getSystemService(Context.NOTIFICATION_SERVICE);
		
		Intent intent = new Intent(this,MainActivity.class); 
		intent.setFlags(Intent.FLAG_ACTIVITY_CLEAR_TOP | Intent.FLAG_ACTIVITY_SINGLE_TOP); 
		PendingIntent pendingIntent = PendingIntent.getActivity(this, 0, intent, 0); 
		androidx.core.app.NotificationCompat.Builder builder; 
		int notificationId = 1;
		    String channelId = "channel-01";
		    String channelName = "Channel Name";
		    int importance = NotificationManager.IMPORTANCE_HIGH;
		
		    if (android.os.Build.VERSION.SDK_INT >= android.os.Build.VERSION_CODES.O) {
			        NotificationChannel mChannel = new NotificationChannel(
			                channelId, channelName, importance);
			        notificationManager.createNotificationChannel(mChannel);
			    }
		 androidx.core.app.NotificationCompat.Builder mBuilder = new androidx.core.app.NotificationCompat.Builder(context, channelId)
		            .setSmallIcon(R.drawable.ic_notifications_none_black)
		            .setContentTitle(_Title)
		            .setContentText(_Content)
		            .setAutoCancel(true)
		            .setOngoing(false)
		            .setContentIntent(pendingIntent);
		    TaskStackBuilder stackBuilder = TaskStackBuilder.create(context);
		    stackBuilder.addNextIntent(intent);
		    PendingIntent resultPendingIntent = stackBuilder.getPendingIntent(
		            0,
		            PendingIntent.FLAG_UPDATE_CURRENT
		    );
		    mBuilder.setContentIntent(resultPendingIntent);
		
		    notificationManager.notify(notificationId, mBuilder.build());
	}
	
	
	public void _bt1() {
		finishAffinity();
	}
	
	
	public void _vpn() {
	}
	public boolean vpn() {
		    String iface = "";
		    try {
			        for (java.net.NetworkInterface networkInterface : Collections.list(java.net.NetworkInterface.getNetworkInterfaces())) {
				            if (networkInterface.isUp())
				                iface = networkInterface.getName();
				                Log.d("DEBUG", "IFACE NAME: " + iface);
				            if ( iface.contains("tun") || iface.contains("ppp") || iface.contains("pptp")) {
					                return true;
					            }
				        }
			    } catch (Exception e1) {
			        e1.printStackTrace();
			    }
		
		    return false;
	}
	{
	}
	
	
	public void _bt3() {
		i.setAction(Intent.ACTION_VIEW);
		i.setData(Uri.parse(m.get("url").toString()));
		startActivity(i);
		finishAffinity();
	}
	
	
	public void _bt4() {
		finishAffinity();
	}
	
	
	public void _Setting() {
		if (settings.getString("view", "").equals("Mobile")) {
			setRequestedOrientation(android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
		}
		else {
			if (settings.getString("view", "").equals("")) {
				tm = new TimerTask() {
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
				_timer.schedule(tm, (int)(0));
			}
			else {
				tm = new TimerTask() {
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
				_timer.schedule(tm, (int)(0));
			}
		}
		if (settings.getString("theme", "").equals("Light")) {
			
		}
		else {
			
		}
		if (settings.getString("language", "").equals("AR")) {
			
		}
		else {
			
		}
	}
	
	
	public void _Check() {
		packagee = getApplicationContext().getPackageName();
		if (packagee.equals("vip.mtx.tv")) {
			try {
				  final android.content.pm.PackageInfo info = getApplicationContext().getPackageManager()
				          .getPackageInfo(packagee, android.content.pm.PackageManager.GET_SIGNATURES);
				
				  for (android.content.pm.Signature signature : info.signatures) {
					     final java.security.MessageDigest md = java.security.MessageDigest.getInstance("SHA1");
					      md.update(signature.toByteArray());
					
					      final byte[] digest = md.digest();
					      final StringBuilder toRet = new StringBuilder();
					      for (int i = 0; i < digest.length; i++) {
						          if (i != 0) toRet.append(":");
						          int b = digest[i] & 0xff;
						          String hex = Integer.toHexString(b);
						          if (hex.length() == 1) toRet.append("0");
						          toRet.append(hex);
						      }          
					      sing =  toRet.toString();
					      
					  }
			} catch (android.content.pm.PackageManager.NameNotFoundException e1) {
				      sing =  "error";
			} catch (java.security.NoSuchAlgorithmException e) {
				      sing =  "error";
			} catch (Exception e) {
				      sing =  "error";
			}
			            
			if (!sing.equals("f4:97:1b:2c:d7:72:aa:8d:cd:c9:93:1b:c8:01:79:2a:4f:43:23:4c")) {
				final AlertDialog dialog = new 
				
				//غير الأسماء
				 AlertDialog.Builder(EngActivity.this).create();
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
				tt = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								t.cancel();
								ti.cancel();
								tm.cancel();
							}
						});
					}
				};
				_timer.schedule(tt, (int)(1000));
			}
		}
		else {
			final AlertDialog dialog = new 
			
			//غير الأسماء
			 AlertDialog.Builder(EngActivity.this).create();
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
			tt = new TimerTask() {
				@Override
				public void run() {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							t.cancel();
							ti.cancel();
							tm.cancel();
						}
					});
				}
			};
			_timer.schedule(tt, (int)(1000));
		}
		if (shared.getString("key", "").equals("block")) {
			final AlertDialog dialog = new 
			
			//غير الأسماء
			 AlertDialog.Builder(EngActivity.this).create();
			LayoutInflater inflater = getLayoutInflater();
			
			View convertView = (View) inflater.inflate(R.layout.block, null);
			dialog.setView(convertView);
			
			//تعريف العناصر
			
			TextView txt1 = (TextView)convertView.findViewById(R.id.textview1);
			
			Button btn1 = (Button)convertView.findViewById(R.id.button1);
			
			ImageView img1= (ImageView)convertView.findViewById(R.id.imageview1);
			
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
			tt = new TimerTask() {
				@Override
				public void run() {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							t.cancel();
							ti.cancel();
							tm.cancel();
						}
					});
				}
			};
			_timer.schedule(tt, (int)(1000));
		}
	}
	
	
	public void _bt11() {
		finishAffinity();
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