package vip.mtx.tv;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.content.*;
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
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import meorg.jsoup.*;
import org.json.*;

public class ChannelsActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private HashMap<String, Object> map = new HashMap<>();
	private String id = "";
	private double position = 0;
	private String fontName = "";
	private String typeace = "";
	private double pop = 0;
	private String url = "";
	private String url0 = "";
	private String url1 = "";
	private String url2 = "";
	
	private ArrayList<HashMap<String, Object>> listmap = new ArrayList<>();
	
	private LinearLayout linear2;
	private LinearLayout linear13;
	private LinearLayout linear5;
	private LinearLayout linear6;
	private ImageView imageview1;
	private TextView textview1;
	private LinearLayout linear1;
	private ImageView imageview2;
	private TextView textview2;
	private GridView gridview1;
	
	private DatabaseReference channels = _firebase.getReference("channels");
	private ChildEventListener _channels_child_listener;
	private Intent i = new Intent();
	private TimerTask t;
	private DatabaseReference link = _firebase.getReference("link");
	private ChildEventListener _link_child_listener;
	private SharedPreferences settings;
	private TimerTask entimer;
	private SharedPreferences shared;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.channels);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear2 = findViewById(R.id.linear2);
		linear13 = findViewById(R.id.linear13);
		linear5 = findViewById(R.id.linear5);
		linear6 = findViewById(R.id.linear6);
		imageview1 = findViewById(R.id.imageview1);
		textview1 = findViewById(R.id.textview1);
		linear1 = findViewById(R.id.linear1);
		imageview2 = findViewById(R.id.imageview2);
		textview2 = findViewById(R.id.textview2);
		gridview1 = findViewById(R.id.gridview1);
		settings = getSharedPreferences("settings", Activity.MODE_PRIVATE);
		shared = getSharedPreferences("shared", Activity.MODE_PRIVATE);
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), CategoryActivity.class);
				startActivity(i);
				overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
			}
		});
		
		gridview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				if (listmap.get((int)_position).get("max").toString().equals("0")) {
					i.setClass(getApplicationContext(), PlayerwebActivity.class);
					i.putExtra("url", listmap.get((int)_position).get("url").toString());
					startActivity(i);
				}
				if (listmap.get((int)_position).get("max").toString().equals("1")) {
					i.setClass(getApplicationContext(), MainActivity.class);
					i.putExtra("txt", listmap.get((int)_position).get("name").toString());
					i.putExtra("url", listmap.get((int)_position).get("url").toString());
					i.putExtra("user_agent", listmap.get((int)_position).get("user").toString());
					i.putExtra("referer", listmap.get((int)_position).get("referer").toString());
					i.putExtra("type", "channel");
					startActivity(i);
				}
				if (listmap.get((int)_position).get("max").toString().equals("2")) {
					
					
					
					
					
					
					
					
					
					
					.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFBDBDBD));
					.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF78022C));
					.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF78022C));
					.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF78022C));
					.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF78022C));
					.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF78022C));
					
					
					
					
					
					textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
					
					button1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
					
					button2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
					
					button3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
					
					button4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
					
					button5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
					
					
					
					
					
					
					
				}
				if (listmap.get((int)_position).get("max").toString().equals("3")) {
					
					
					
					
					
					
					
					
					
					
					.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFBDBDBD));
					.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF78022C));
					.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF78022C));
					.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF78022C));
					.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF78022C));
					.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF78022C));
					
					
					
					
					
					textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
					
					button1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
					
					button2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
					
					button3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
					
					button4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
					
					button5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
					
					
					
					
					
					
					
				}
				if (listmap.get((int)_position).get("max").toString().equals("4")) {
					
					
					
					
					
					
					
					
					
					
					.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFBDBDBD));
					.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF78022C));
					.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF78022C));
					.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF78022C));
					.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF78022C));
					.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF78022C));
					
					
					
					
					
					textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
					
					button1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
					
					button2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
					
					button3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
					
					button4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
					
					button5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
					
					
					
					
					
					
					
				}
				if (listmap.get((int)_position).get("max").toString().equals("5")) {
					
					
					
					
					
					
					
					
					
					
					.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFBDBDBD));
					.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF78022C));
					.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF78022C));
					.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF78022C));
					.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF78022C));
					.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF78022C));
					
					
					
					
					
					textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
					
					button1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
					
					button2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
					
					button3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
					
					button4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
					
					button5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
					
					
					
					
					
					
					
				}
			}
		});
		
		_channels_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childValue.containsKey("id")) {
					if (_childValue.get("id").toString().equals(id)) {
						listmap.add(_childValue);
						gridview1.setAdapter(new Gridview1Adapter(listmap));
					}
				}
				
			}
			
			@Override
			public void onChildChanged(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				if (_childValue.containsKey("id")) {
					if (_childValue.get("id").toString().equals(id)) {
						listmap.add(_childValue);
						gridview1.setAdapter(new Gridview1Adapter(listmap));
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
				if (_childValue.containsKey("id")) {
					if (_childValue.get("id").toString().equals(id)) {
						listmap.add(_childValue);
						
						
					}
				}
			}
			
			@Override
			public void onCancelled(DatabaseError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		channels.addChildEventListener(_channels_child_listener);
		
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
	}
	
	private void initializeLogic() {
		_Setting();
		textview2.setText(getIntent().getStringExtra("name"));
		id = getIntent().getStringExtra("id");
		textview2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 1);
		Glide.with(getApplicationContext()).load(Uri.parse(getIntent().getStringExtra("img"))).into(imageview2);
		gridview1.setSelector(android.R.color.transparent);
		if (shared.getString("key", "").equals("") || !shared.getString("key", "").contains("MTX-")) {
			final AlertDialog dialog = new 
			
			//غير الأسماء
			 AlertDialog.Builder(ChannelsActivity.this).create();
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
		}
		else {
			
		}
	}
	
	@Override
	public void onBackPressed() {
		i.setClass(getApplicationContext(), CategoryActivity.class);
		startActivity(i);
		overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
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
	
	
	public void _bt1() {
		finishAffinity();
	}
	
	
	public void _bt2() {
		i.setAction(Intent.ACTION_VIEW);
		i.setData(Uri.parse(url));
		startActivity(i);
		finishAffinity();
	}
	
	
	public void _btn1() {
		
	}
	
	
	public void _btn2() {
		i.setAction(Intent.ACTION_VIEW);
		i.setData(Uri.parse("https://dl.dropbox.com/scl/fi/z7v03jqiy4hgrec3wrn9n/MTX-Player.apk?dl=0&rlkey=njdc645wnjbl8wvgupce7uae2"));
		startActivity(i);
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
			linear1.setBackgroundColor(0xFFE0E0E0);
			textview2.setTextColor(0xFF000000);
		}
		else {
			linear1.setBackgroundColor(0xFF303030);
			textview2.setTextColor(0xFFFFFFFF);
		}
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
				_view = _inflater.inflate(R.layout.channels_custom, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			
			textview1.setEllipsize(TextUtils.TruncateAt.MARQUEE);
			textview1.setMarqueeRepeatLimit(-1);
			textview1.setSingleLine(true);
			textview1.setSelected(true);
			if (_data.get((int)_position).containsKey("id")) {
				if (_data.get((int)_position).containsKey("name")) {
					textview1.setText(_data.get((int)_position).get("name").toString());
				}
				if (_data.get((int)_position).containsKey("logo")) {
					if (_data.get((int)_position).get("logo").toString().contains("http")) {
						Glide.with(getApplicationContext()).load(Uri.parse(_data.get((int)_position).get("logo").toString())).into(imageview1);
					}
				}
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