package vip.mtx.admin;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.Intent;
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
import android.webkit.*;
import android.widget.*;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.textfield.*;
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
import java.util.regex.*;
import meorg.jsoup.*;
import org.json.*;

public class EditChannelActivity extends AppCompatActivity {
	
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private String key = "";
	private String id = "";
	private String path = "";
	private boolean picked = false;
	private HashMap<String, Object> map = new HashMap<>();
	private String fontName = "";
	private String typeace = "";
	private String max = "";
	private String nam = "";
	
	private ArrayList<String> list = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> listmap = new ArrayList<>();
	
	private LinearLayout linear2;
	private ScrollView vscroll1;
	private LinearLayout linear3;
	private LinearLayout linear1;
	private ImageView imageview1;
	private TextView textview1;
	private TextInputLayout textinputlayout1;
	private TextInputLayout textinputlayout2;
	private LinearLayout linear5;
	private LinearLayout linear_1;
	private LinearLayout linear_2;
	private LinearLayout linear_3;
	private LinearLayout linear_4;
	private LinearLayout linear_5;
	private Button button1;
	private EditText edittext1;
	private EditText edittext2;
	private RadioButton radiobutton1;
	private RadioButton radiobutton2;
	private RadioButton radiobutton3;
	private RadioButton radiobutton4;
	private RadioButton radiobutton5;
	private RadioButton radiobutton0;
	private TextInputLayout textinputlayout3;
	private TextInputLayout textinputlayout4;
	private TextView textview2;
	private TextInputLayout textinputlayout5;
	private TextView textview3;
	private EditText edittext_1_1;
	private EditText edittext_1_2;
	private EditText edittext_1_3;
	private TextInputLayout textinputlayout6;
	private TextInputLayout textinputlayout7;
	private TextView textview4;
	private TextInputLayout textinputlayout8;
	private TextView textview5;
	private EditText edittext_2_1;
	private EditText edittext_2_2;
	private EditText edittext_2_3;
	private TextInputLayout textinputlayout9;
	private TextInputLayout textinputlayout10;
	private TextView textview6;
	private TextInputLayout textinputlayout11;
	private TextView textview7;
	private EditText edittext_3_1;
	private EditText edittext_3_2;
	private EditText edittext_3_3;
	private TextInputLayout textinputlayout12;
	private TextInputLayout textinputlayout13;
	private TextView textview8;
	private TextInputLayout textinputlayout14;
	private TextView textview9;
	private EditText edittext_4_1;
	private EditText edittext_4_2;
	private EditText edittext_4_3;
	private TextInputLayout textinputlayout15;
	private TextInputLayout textinputlayout16;
	private TextView textview10;
	private TextInputLayout textinputlayout17;
	private TextView textview11;
	private EditText edittext_5_1;
	private EditText edittext_5_2;
	private EditText edittext_5_3;
	
	private DatabaseReference channels = _firebase.getReference("channels");
	private ChildEventListener _channels_child_listener;
	private Intent i = new Intent();
	private Intent in = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.edit_channel);
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
		linear2 = findViewById(R.id.linear2);
		vscroll1 = findViewById(R.id.vscroll1);
		linear3 = findViewById(R.id.linear3);
		linear1 = findViewById(R.id.linear1);
		imageview1 = findViewById(R.id.imageview1);
		textview1 = findViewById(R.id.textview1);
		textinputlayout1 = findViewById(R.id.textinputlayout1);
		textinputlayout2 = findViewById(R.id.textinputlayout2);
		linear5 = findViewById(R.id.linear5);
		linear_1 = findViewById(R.id.linear_1);
		linear_2 = findViewById(R.id.linear_2);
		linear_3 = findViewById(R.id.linear_3);
		linear_4 = findViewById(R.id.linear_4);
		linear_5 = findViewById(R.id.linear_5);
		button1 = findViewById(R.id.button1);
		edittext1 = findViewById(R.id.edittext1);
		edittext2 = findViewById(R.id.edittext2);
		radiobutton1 = findViewById(R.id.radiobutton1);
		radiobutton2 = findViewById(R.id.radiobutton2);
		radiobutton3 = findViewById(R.id.radiobutton3);
		radiobutton4 = findViewById(R.id.radiobutton4);
		radiobutton5 = findViewById(R.id.radiobutton5);
		radiobutton0 = findViewById(R.id.radiobutton0);
		textinputlayout3 = findViewById(R.id.textinputlayout3);
		textinputlayout4 = findViewById(R.id.textinputlayout4);
		textview2 = findViewById(R.id.textview2);
		textinputlayout5 = findViewById(R.id.textinputlayout5);
		textview3 = findViewById(R.id.textview3);
		edittext_1_1 = findViewById(R.id.edittext_1_1);
		edittext_1_2 = findViewById(R.id.edittext_1_2);
		edittext_1_3 = findViewById(R.id.edittext_1_3);
		textinputlayout6 = findViewById(R.id.textinputlayout6);
		textinputlayout7 = findViewById(R.id.textinputlayout7);
		textview4 = findViewById(R.id.textview4);
		textinputlayout8 = findViewById(R.id.textinputlayout8);
		textview5 = findViewById(R.id.textview5);
		edittext_2_1 = findViewById(R.id.edittext_2_1);
		edittext_2_2 = findViewById(R.id.edittext_2_2);
		edittext_2_3 = findViewById(R.id.edittext_2_3);
		textinputlayout9 = findViewById(R.id.textinputlayout9);
		textinputlayout10 = findViewById(R.id.textinputlayout10);
		textview6 = findViewById(R.id.textview6);
		textinputlayout11 = findViewById(R.id.textinputlayout11);
		textview7 = findViewById(R.id.textview7);
		edittext_3_1 = findViewById(R.id.edittext_3_1);
		edittext_3_2 = findViewById(R.id.edittext_3_2);
		edittext_3_3 = findViewById(R.id.edittext_3_3);
		textinputlayout12 = findViewById(R.id.textinputlayout12);
		textinputlayout13 = findViewById(R.id.textinputlayout13);
		textview8 = findViewById(R.id.textview8);
		textinputlayout14 = findViewById(R.id.textinputlayout14);
		textview9 = findViewById(R.id.textview9);
		edittext_4_1 = findViewById(R.id.edittext_4_1);
		edittext_4_2 = findViewById(R.id.edittext_4_2);
		edittext_4_3 = findViewById(R.id.edittext_4_3);
		textinputlayout15 = findViewById(R.id.textinputlayout15);
		textinputlayout16 = findViewById(R.id.textinputlayout16);
		textview10 = findViewById(R.id.textview10);
		textinputlayout17 = findViewById(R.id.textinputlayout17);
		textview11 = findViewById(R.id.textview11);
		edittext_5_1 = findViewById(R.id.edittext_5_1);
		edittext_5_2 = findViewById(R.id.edittext_5_2);
		edittext_5_3 = findViewById(R.id.edittext_5_3);
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				map.put("name", edittext1.getText().toString());
				map.put("logo", edittext2.getText().toString());
				map.put("max", max);
				map.put("id", id);
				//1
				map.put("url", edittext_1_1.getText().toString());
				if (edittext_1_2.getText().toString().equals("")) {
					map.put("user", "YF Player");
				}
				else {
					map.put("user", edittext_1_2.getText().toString());
				}
				map.put("referer", edittext_1_3.getText().toString());
				//2
				map.put("url2", edittext_2_1.getText().toString());
				if (edittext_2_2.getText().toString().equals("")) {
					map.put("user2", "YF Player");
				}
				else {
					map.put("user2", edittext_2_2.getText().toString());
				}
				map.put("referer2", edittext_2_3.getText().toString());
				//3
				map.put("url3", edittext_3_1.getText().toString());
				if (edittext_3_2.getText().toString().equals("")) {
					map.put("user3", "YF Player");
				}
				else {
					map.put("user3", edittext_3_2.getText().toString());
				}
				map.put("referer3", edittext_3_3.getText().toString());
				//4
				map.put("url4", edittext_4_1.getText().toString());
				if (edittext_4_2.getText().toString().equals("")) {
					map.put("user4", "YF Player");
				}
				else {
					map.put("user4", edittext_4_2.getText().toString());
				}
				map.put("referer4", edittext_4_3.getText().toString());
				//5
				map.put("url5", edittext_5_1.getText().toString());
				if (edittext_5_2.getText().toString().equals("")) {
					map.put("user5", "YF Player");
				}
				else {
					map.put("user5", edittext_5_2.getText().toString());
				}
				map.put("referer5", edittext_5_3.getText().toString());
				//save
				if (textview1.getText().toString().equals("إنشاء قناة")) {
					if (listmap.size() > 0) {
						map.put("key", String.valueOf((long)(Double.parseDouble(listmap.get((int)listmap.size() - 1).get("key").toString()) + 1)));
						key = String.valueOf((long)(Double.parseDouble(listmap.get((int)listmap.size() - 1).get("key").toString()) + 1));
					}
					else {
						map.put("key", "0");
						key = "0";
					}
					channels.child(key).updateChildren(map);
				}
				else {
					map.put("key", key);
					channels.child(key).updateChildren(map);
				}
			}
		});
		
		radiobutton1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					radiobutton0.setChecked(false);
					radiobutton2.setChecked(false);
					radiobutton3.setChecked(false);
					radiobutton4.setChecked(false);
					radiobutton5.setChecked(false);
					linear_1.setVisibility(View.VISIBLE);
					linear_2.setVisibility(View.GONE);
					linear_3.setVisibility(View.GONE);
					linear_4.setVisibility(View.GONE);
					linear_5.setVisibility(View.GONE);
					max = "1";
				}
			}
		});
		
		radiobutton2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					radiobutton0.setChecked(false);
					radiobutton1.setChecked(false);
					radiobutton3.setChecked(false);
					radiobutton4.setChecked(false);
					radiobutton5.setChecked(false);
					linear_1.setVisibility(View.VISIBLE);
					linear_2.setVisibility(View.VISIBLE);
					linear_3.setVisibility(View.GONE);
					linear_4.setVisibility(View.GONE);
					linear_5.setVisibility(View.GONE);
					max = "2";
				}
			}
		});
		
		radiobutton3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					radiobutton0.setChecked(false);
					radiobutton1.setChecked(false);
					radiobutton2.setChecked(false);
					radiobutton4.setChecked(false);
					radiobutton5.setChecked(false);
					linear_1.setVisibility(View.VISIBLE);
					linear_2.setVisibility(View.VISIBLE);
					linear_3.setVisibility(View.VISIBLE);
					linear_4.setVisibility(View.GONE);
					linear_5.setVisibility(View.GONE);
					max = "3";
				}
			}
		});
		
		radiobutton4.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					radiobutton0.setChecked(false);
					radiobutton1.setChecked(false);
					radiobutton2.setChecked(false);
					radiobutton3.setChecked(false);
					radiobutton5.setChecked(false);
					linear_1.setVisibility(View.VISIBLE);
					linear_2.setVisibility(View.VISIBLE);
					linear_3.setVisibility(View.VISIBLE);
					linear_4.setVisibility(View.VISIBLE);
					linear_5.setVisibility(View.GONE);
					max = "4";
				}
			}
		});
		
		radiobutton5.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					radiobutton0.setChecked(false);
					radiobutton1.setChecked(false);
					radiobutton2.setChecked(false);
					radiobutton3.setChecked(false);
					radiobutton4.setChecked(false);
					linear_1.setVisibility(View.VISIBLE);
					linear_2.setVisibility(View.VISIBLE);
					linear_3.setVisibility(View.VISIBLE);
					linear_4.setVisibility(View.VISIBLE);
					linear_5.setVisibility(View.VISIBLE);
					max = "5";
				}
			}
		});
		
		radiobutton0.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					radiobutton1.setChecked(false);
					radiobutton2.setChecked(false);
					radiobutton3.setChecked(false);
					radiobutton4.setChecked(false);
					radiobutton5.setChecked(false);
					linear_1.setVisibility(View.VISIBLE);
					linear_2.setVisibility(View.GONE);
					linear_3.setVisibility(View.GONE);
					linear_4.setVisibility(View.GONE);
					linear_5.setVisibility(View.GONE);
					max = "0";
				}
			}
		});
		
		_channels_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				channels.addListenerForSingleValueEvent(new ValueEventListener() {
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
				channels.addListenerForSingleValueEvent(new ValueEventListener() {
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
						
					}
					@Override
					public void onCancelled(DatabaseError _databaseError) {
					}
				});
				SketchwareUtil.showMessage(getApplicationContext(), "تم التعديل");
			}
			
			@Override
			public void onChildMoved(DataSnapshot _param1, String _param2) {
				
			}
			
			@Override
			public void onChildRemoved(DataSnapshot _param1) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				channels.addListenerForSingleValueEvent(new ValueEventListener() {
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
		channels.addChildEventListener(_channels_child_listener);
	}
	
	private void initializeLogic() {
		edittext1.setText(getIntent().getStringExtra("name"));
		id = getIntent().getStringExtra("id");
		nam = getIntent().getStringExtra("nam");
		if (edittext1.getText().toString().equals("")) {
			textview1.setText("إنشاء قناة");
			button1.setText("نشر القناة");
			max = "1";
		}
		else {
			edittext2.setText(getIntent().getStringExtra("logo"));
			edittext_1_1.setText(getIntent().getStringExtra("url"));
			edittext_1_2.setText(getIntent().getStringExtra("user"));
			edittext_1_3.setText(getIntent().getStringExtra("referer"));
			edittext_2_1.setText(getIntent().getStringExtra("url2"));
			edittext_2_2.setText(getIntent().getStringExtra("user2"));
			edittext_2_3.setText(getIntent().getStringExtra("referer2"));
			edittext_3_1.setText(getIntent().getStringExtra("url3"));
			edittext_3_2.setText(getIntent().getStringExtra("user3"));
			edittext_3_3.setText(getIntent().getStringExtra("referer3"));
			edittext_4_1.setText(getIntent().getStringExtra("url4"));
			edittext_4_2.setText(getIntent().getStringExtra("user4"));
			edittext_4_3.setText(getIntent().getStringExtra("referer4"));
			edittext_5_1.setText(getIntent().getStringExtra("url5"));
			edittext_5_2.setText(getIntent().getStringExtra("user5"));
			edittext_5_3.setText(getIntent().getStringExtra("referer5"));
			max = getIntent().getStringExtra("max");
			key = getIntent().getStringExtra("key");
		}
		if (max.equals("0")) {
			radiobutton0.setChecked(true);
			linear_1.setVisibility(View.VISIBLE);
			linear_2.setVisibility(View.GONE);
			linear_3.setVisibility(View.GONE);
			linear_4.setVisibility(View.GONE);
			linear_5.setVisibility(View.GONE);
		}
		if (max.equals("1")) {
			radiobutton1.setChecked(true);
			linear_1.setVisibility(View.VISIBLE);
			linear_2.setVisibility(View.GONE);
			linear_3.setVisibility(View.GONE);
			linear_4.setVisibility(View.GONE);
			linear_5.setVisibility(View.GONE);
		}
		if (max.equals("2")) {
			radiobutton2.setChecked(true);
			linear_1.setVisibility(View.VISIBLE);
			linear_2.setVisibility(View.VISIBLE);
			linear_3.setVisibility(View.GONE);
			linear_4.setVisibility(View.GONE);
			linear_5.setVisibility(View.GONE);
		}
		if (max.equals("3")) {
			radiobutton3.setChecked(true);
			linear_1.setVisibility(View.VISIBLE);
			linear_2.setVisibility(View.VISIBLE);
			linear_3.setVisibility(View.VISIBLE);
			linear_4.setVisibility(View.GONE);
			linear_5.setVisibility(View.GONE);
		}
		if (max.equals("4")) {
			radiobutton4.setChecked(true);
			linear_1.setVisibility(View.VISIBLE);
			linear_2.setVisibility(View.VISIBLE);
			linear_3.setVisibility(View.VISIBLE);
			linear_4.setVisibility(View.VISIBLE);
			linear_5.setVisibility(View.GONE);
		}
		if (max.equals("5")) {
			radiobutton5.setChecked(true);
			linear_1.setVisibility(View.VISIBLE);
			linear_2.setVisibility(View.VISIBLE);
			linear_3.setVisibility(View.VISIBLE);
			linear_4.setVisibility(View.VISIBLE);
			linear_5.setVisibility(View.VISIBLE);
		}
		button1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF424242));
		_changeActivityFont("neosansarabic");
	}
	
	@Override
	public void onBackPressed() {
		i.setClass(getApplicationContext(), AddChannelActivity.class);
		i.putExtra("id", id);
		i.putExtra("name", nam);
		startActivity(i);
		finish();
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