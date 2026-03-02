package vip.mtx.admin;

import android.animation.*;
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
import com.bumptech.glide.Glide;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.floatingactionbutton.FloatingActionButton;
import com.google.firebase.FirebaseApp;
import com.google.firebase.database.ChildEventListener;
import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.GenericTypeIndicator;
import com.google.firebase.database.ValueEventListener;
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

public class AddChannelActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private FloatingActionButton _fab;
	private HashMap<String, Object> map = new HashMap<>();
	private String id = "";
	private String icon_path = "";
	private boolean picked = false;
	private String key = "";
	private String fontName = "";
	private String typeace = "";
	private String user = "";
	private boolean N1 = false;
	private boolean N2 = false;
	private boolean N3 = false;
	private String N01 = "";
	private String N02 = "";
	private String N03 = "";
	private String N04 = "";
	private boolean N4 = false;
	private String N05 = "";
	private String N06 = "";
	private String N07 = "";
	private String N08 = "";
	private boolean N5 = false;
	private boolean N6 = false;
	private boolean N7 = false;
	private boolean N8 = false;
	private String nam = "";
	
	private ArrayList<HashMap<String, Object>> listmap = new ArrayList<>();
	private ArrayList<String> list = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> chn = new ArrayList<>();
	
	private LinearLayout linear10;
	private ImageView imageview2;
	private TextView textview1;
	private LinearLayout linear8;
	private GridView gridview1;
	private LinearLayout linear1;
	private ImageView imageview1;
	private TextView textview2;
	
	private DatabaseReference channels = _firebase.getReference("channels");
	private ChildEventListener _channels_child_listener;
	private AlertDialog.Builder d;
	private AlertDialog.Builder d2;
	private Intent i = new Intent();
	private SharedPreferences s;
	private TimerTask t;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.add_channel);
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
		_fab = findViewById(R.id._fab);
		
		linear10 = findViewById(R.id.linear10);
		imageview2 = findViewById(R.id.imageview2);
		textview1 = findViewById(R.id.textview1);
		linear8 = findViewById(R.id.linear8);
		gridview1 = findViewById(R.id.gridview1);
		linear1 = findViewById(R.id.linear1);
		imageview1 = findViewById(R.id.imageview1);
		textview2 = findViewById(R.id.textview2);
		d = new AlertDialog.Builder(this);
		d2 = new AlertDialog.Builder(this);
		s = getSharedPreferences("s", Activity.MODE_PRIVATE);
		
		gridview1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				d.setMessage("هل تريد تعديل أم حذف هذه القناة ؟");
				d.setPositiveButton("حذف", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						d2.setMessage("هل أنت متأكد من حذف هذه القناة؟");
						d2.setPositiveButton("نعم", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								channels.child(listmap.get((int)_position).get("key").toString()).removeValue();
							}
						});
						d2.setNegativeButton("لا", new DialogInterface.OnClickListener() {
							@Override
							public void onClick(DialogInterface _dialog, int _which) {
								
							}
						});
						d2.create().show();
					}
				});
				d.setNegativeButton("تعديل", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						i.putExtra("name", listmap.get((int)_position).get("name").toString());
						i.putExtra("logo", listmap.get((int)_position).get("logo").toString());
						i.putExtra("id", listmap.get((int)_position).get("id").toString());
						i.putExtra("key", listmap.get((int)_position).get("key").toString());
						i.putExtra("max", listmap.get((int)_position).get("max").toString());
						i.putExtra("url", listmap.get((int)_position).get("url").toString());
						i.putExtra("user", listmap.get((int)_position).get("user").toString());
						i.putExtra("referer", listmap.get((int)_position).get("referer").toString());
						i.putExtra("url2", listmap.get((int)_position).get("url2").toString());
						i.putExtra("user2", listmap.get((int)_position).get("user2").toString());
						i.putExtra("referer2", listmap.get((int)_position).get("referer2").toString());
						i.putExtra("url3", listmap.get((int)_position).get("url3").toString());
						i.putExtra("user3", listmap.get((int)_position).get("user3").toString());
						i.putExtra("referer3", listmap.get((int)_position).get("referer3").toString());
						i.putExtra("url4", listmap.get((int)_position).get("url4").toString());
						i.putExtra("user4", listmap.get((int)_position).get("user4").toString());
						i.putExtra("referer4", listmap.get((int)_position).get("referer4").toString());
						i.putExtra("url5", listmap.get((int)_position).get("url5").toString());
						i.putExtra("user5", listmap.get((int)_position).get("user5").toString());
						i.putExtra("referer5", listmap.get((int)_position).get("referer5").toString());
						i.putExtra("nam", nam);
						i.setClass(getApplicationContext(), EditChannelActivity.class);
						startActivity(i);
						overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
					}
				});
				d.setNeutralButton("إلغاء", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				d.create().show();
				return true;
			}
		});
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.putExtra("id", id);
				i.putExtra("nam", nam);
				i.setClass(getApplicationContext(), EditChannelActivity.class);
				startActivity(i);
				overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
			}
		});
		
		_fab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.putExtra("id", id);
				i.putExtra("nam", nam);
				i.setClass(getApplicationContext(), EditChannelActivity.class);
				startActivity(i);
				overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
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
						gridview1.setAdapter(new Gridview1Adapter(listmap));
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
	}
	
	private void initializeLogic() {
		nam = getIntent().getStringExtra("name");
		id = getIntent().getStringExtra("id");
		picked = false;
		linear1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF424242));
		textview2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
		textview2.setText("باقة ".concat(nam));
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
				_view = _inflater.inflate(R.layout.channel_custom, null);
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
			textview1.setTextColor(0xFF000000);
			linear1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)10, 0xFFFFFFFF));
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