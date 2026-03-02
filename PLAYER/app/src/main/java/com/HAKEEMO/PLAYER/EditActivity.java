package com.HAKEEMO.PLAYER;

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
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.blogspot.atifsoftwares.animatoolib.*;
import com.google.android.exoplayer2.*;
import com.google.android.exoplayer2.ui.*;
import com.google.android.gms.ads.MobileAds;
import com.google.android.material.appbar.AppBarLayout;
import com.google.android.material.textfield.*;
import com.google.firebase.FirebaseApp;
import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import dev.gerges.ParserM3U.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.regex.*;
import org.json.*;

public class EditActivity extends AppCompatActivity {
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private String key = "";
	private HashMap<String, Object> mapp = new HashMap<>();
	private String type = "";
	private double GetPosition = 0;
	
	private ArrayList<HashMap<String, Object>> map = new ArrayList<>();
	
	private LinearLayout content;
	private LinearLayout linear8;
	private LinearLayout linear19;
	private TextInputLayout title_lay;
	private LinearLayout linear24;
	private TextInputLayout textinputlayout1;
	private LinearLayout linear25;
	private TextInputLayout description_lay;
	private LinearLayout linear30;
	private TextInputLayout textinputlayout2;
	private LinearLayout linear27;
	private LinearLayout linear16;
	private LinearLayout linear20;
	private EditText edittext1;
	private EditText edittext2;
	private EditText edittext3;
	private EditText edittext4;
	private CheckBox checkbox2;
	private CheckBox checkbox1;
	private CheckBox checkbox3;
	private Button button1;
	private Button button2;
	
	private SharedPreferences s;
	private Intent i = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.edit);
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
		content = findViewById(R.id.content);
		linear8 = findViewById(R.id.linear8);
		linear19 = findViewById(R.id.linear19);
		title_lay = findViewById(R.id.title_lay);
		linear24 = findViewById(R.id.linear24);
		textinputlayout1 = findViewById(R.id.textinputlayout1);
		linear25 = findViewById(R.id.linear25);
		description_lay = findViewById(R.id.description_lay);
		linear30 = findViewById(R.id.linear30);
		textinputlayout2 = findViewById(R.id.textinputlayout2);
		linear27 = findViewById(R.id.linear27);
		linear16 = findViewById(R.id.linear16);
		linear20 = findViewById(R.id.linear20);
		edittext1 = findViewById(R.id.edittext1);
		edittext2 = findViewById(R.id.edittext2);
		edittext3 = findViewById(R.id.edittext3);
		edittext4 = findViewById(R.id.edittext4);
		checkbox2 = findViewById(R.id.checkbox2);
		checkbox1 = findViewById(R.id.checkbox1);
		checkbox3 = findViewById(R.id.checkbox3);
		button1 = findViewById(R.id.button1);
		button2 = findViewById(R.id.button2);
		s = getSharedPreferences("s", Activity.MODE_PRIVATE);
		
		checkbox2.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					checkbox1.setChecked(false);
					checkbox2.setChecked(true);
					checkbox3.setChecked(false);
					type = "Exo Player";
				}
				else {
					
				}
			}
		});
		
		checkbox1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					checkbox1.setChecked(true);
					checkbox2.setChecked(false);
					checkbox3.setChecked(false);
					type = "Web Player";
				}
				else {
					
				}
			}
		});
		
		checkbox3.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
			@Override
			public void onCheckedChanged(CompoundButton _param1, boolean _param2) {
				final boolean _isChecked = _param2;
				if (_isChecked) {
					checkbox1.setChecked(false);
					checkbox2.setChecked(false);
					checkbox3.setChecked(true);
					type = "M3u8 Link";
				}
				else {
					
				}
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				startActivity(new Intent(EditActivity.this, HomeActivity.class)); Animatoo.animateSlideLeft(EditActivity.this);
			}
		});
		
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (edittext2.getText().toString().trim().equals("")) {
					SketchwareUtil.showMessage(getApplicationContext(), "Enter Url video");
				}
				else {
					if (edittext1.getText().toString().trim().equals("")) {
						SketchwareUtil.showMessage(getApplicationContext(), "Enter Name video");
					}
					else {
						if (getIntent().getStringExtra("isEdit").equals("false")) {
							if (!s.getString("y", "").equals("")) {
								map = new Gson().fromJson(s.getString("y", ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
							}
							mapp = new HashMap<>();
							mapp.put("name", edittext1.getText().toString());
							mapp.put("user", edittext3.getText().toString());
							mapp.put("url", edittext2.getText().toString());
							mapp.put("referer", edittext4.getText().toString());
							mapp.put("type", type);
							map.add(mapp);
							s.edit().putString("y", new Gson().toJson(map)).commit();
							i.setClass(getApplicationContext(), HomeActivity.class);
							startActivity(i);
							finish();
						}
						else {
							map.get((int)GetPosition).put("name", edittext1.getText().toString());
							map.get((int)GetPosition).put("url", edittext2.getText().toString());
							map.get((int)GetPosition).put("user", edittext3.getText().toString());
							map.get((int)GetPosition).put("referer", edittext4.getText().toString());
							map.get((int)GetPosition).put("type", type);
							s.edit().putString("y", new Gson().toJson(map)).commit();
							i.setClass(getApplicationContext(), HomeActivity.class);
							startActivity(i);
							finish();
						}
					}
				}
			}
		});
	}
	
	private void initializeLogic() {
		if (getIntent().getStringExtra("isEdit").equals("true")) {
			edittext1.setText(getIntent().getStringExtra("name"));
			edittext2.setText(getIntent().getStringExtra("url"));
			edittext3.setText(getIntent().getStringExtra("user"));
			edittext4.setText(getIntent().getStringExtra("referer"));
			key = getIntent().getStringExtra("name");
			button2.setText("تعديل");
			GetPosition = Double.parseDouble(getIntent().getStringExtra("GetPosition"));
			if (!s.getString("y", "").equals("")) {
				map = new Gson().fromJson(s.getString("y", ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
				mapp = map.get((int)GetPosition);
			}
		}
		checkbox2.setChecked(true);
	}
	
	@Override
	public void onBackPressed() {
		startActivity(new Intent(EditActivity.this, HomeActivity.class)); Animatoo.animateSlideLeft(EditActivity.this);
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