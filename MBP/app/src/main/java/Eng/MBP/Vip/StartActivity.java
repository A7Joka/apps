package Eng.MBP.Vip;

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
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.blogspot.atifsoftwares.animatoolib.*;
import com.github.rubensousa.bottomsheetbuilder.*;
import com.google.android.exoplayer2.*;
import com.google.android.exoplayer2.common.*;
import com.google.android.exoplayer2.core.*;
import com.google.android.exoplayer2.database.*;
import com.google.android.exoplayer2.decoder.*;
import com.google.android.exoplayer2.ext.cast.*;
import com.google.android.exoplayer2.extractor.*;
import com.google.android.exoplayer2.source.dash.*;
import com.google.android.exoplayer2.source.hls.*;
import com.google.android.exoplayer2.source.rtsp.*;
import com.google.android.exoplayer2.source.smoothstreaming.*;
import com.google.android.exoplayer2.ui.*;
import com.google.android.exoplayer2.upstream.*;
import com.google.android.gms.ads.MobileAds;
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
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import meorg.jsoup.*;
import org.checkerframework.checker.nullness.compatqual.*;
import org.json.*;

public class StartActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private double n = 0;
	private String data_ = "";
	private HashMap<String, Object> map = new HashMap<>();
	private String userr = "";
	private String reff = "";
	private String txxt = "";
	private double pos = 0;
	private double pos1 = 0;
	private double pos2 = 0;
	private String new_url = "";
	private String NewSource = "";
	private String st = "";
	private String refrere = "";
	private String ked = "";
	private String uurrll = "";
	private String uuu = "";
	
	private ArrayList<HashMap<String, Object>> map2 = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private ImageView imageview2;
	private TextView textview1;
	private ImageView imageview1;
	private ListView listview1;
	private TextView textview3;
	private ScrollView linear;
	private LinearLayout linear01;
	private TextView textview2;
	private TextView textview4;
	private TextInputLayout textinputlayout1;
	private TextInputLayout textinputlayout2;
	private TextInputLayout textinputlayout3;
	private TextView textview6;
	private TextInputLayout textinputlayout4;
	private TextView textview5;
	private TextInputLayout textinputlayout5;
	private TextView textview7;
	private LinearLayout linear3;
	private Button button1;
	private EditText edittext1;
	private EditText edittext2;
	private EditText edittext3;
	private EditText edittext4;
	private EditText edittext5;
	private CheckBox checkbox1;
	private CheckBox checkbox2;
	private CheckBox checkbox3;
	
	private AlertDialog.Builder d;
	private SharedPreferences data;
	private TimerTask t;
	private AlertDialog.Builder d0;
	private Intent nnn = new Intent();
	private RequestNetwork r;
	private RequestNetwork.RequestListener _r_request_listener;
	private RequestNetwork r2;
	private RequestNetwork.RequestListener _r2_request_listener;
	private RequestNetwork r3;
	private RequestNetwork.RequestListener _r3_request_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.start);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		MobileAds.initialize(this);
		
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		linear2 = findViewById(R.id.linear2);
		imageview2 = findViewById(R.id.imageview2);
		textview1 = findViewById(R.id.textview1);
		imageview1 = findViewById(R.id.imageview1);
		listview1 = findViewById(R.id.listview1);
		textview3 = findViewById(R.id.textview3);
		linear = findViewById(R.id.linear);
		linear01 = findViewById(R.id.linear01);
		textview2 = findViewById(R.id.textview2);
		textview4 = findViewById(R.id.textview4);
		textinputlayout1 = findViewById(R.id.textinputlayout1);
		textinputlayout2 = findViewById(R.id.textinputlayout2);
		textinputlayout3 = findViewById(R.id.textinputlayout3);
		textview6 = findViewById(R.id.textview6);
		textinputlayout4 = findViewById(R.id.textinputlayout4);
		textview5 = findViewById(R.id.textview5);
		textinputlayout5 = findViewById(R.id.textinputlayout5);
		textview7 = findViewById(R.id.textview7);
		linear3 = findViewById(R.id.linear3);
		button1 = findViewById(R.id.button1);
		edittext1 = findViewById(R.id.edittext1);
		edittext2 = findViewById(R.id.edittext2);
		edittext3 = findViewById(R.id.edittext3);
		edittext4 = findViewById(R.id.edittext4);
		edittext5 = findViewById(R.id.edittext5);
		checkbox1 = findViewById(R.id.checkbox1);
		checkbox2 = findViewById(R.id.checkbox2);
		checkbox3 = findViewById(R.id.checkbox3);
		d = new AlertDialog.Builder(this);
		data = getSharedPreferences("data", Activity.MODE_PRIVATE);
		d0 = new AlertDialog.Builder(this);
		r = new RequestNetwork(this);
		r2 = new RequestNetwork(this);
		r3 = new RequestNetwork(this);
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				imageview1.setVisibility(View.VISIBLE);
				imageview2.setVisibility(View.GONE);
				linear.setVisibility(View.GONE);
				if (map2.size() == 0) {
					textview3.setVisibility(View.VISIBLE);
				}
				else {
					listview1.setVisibility(View.VISIBLE);
				}
				edittext1.setText("");
				edittext2.setText("");
				edittext3.setText("");
				edittext4.setText("");
				edittext5.setText("");
				SketchwareUtil.hideKeyboard(getApplicationContext());
			}
		});
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				n = 0.5d;
				listview1.setVisibility(View.GONE);
				textview3.setVisibility(View.GONE);
				imageview1.setVisibility(View.GONE);
				imageview2.setVisibility(View.VISIBLE);
				linear.setVisibility(View.VISIBLE);
				edittext1.setText("");
				edittext2.setText("");
				edittext3.setText("");
				edittext4.setText("");
				edittext5.setText("");
				checkbox1.setChecked(true);
				checkbox2.setChecked(false);
				checkbox3.setChecked(false);
			}
		});
		
		listview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				if (map2.get((int)_position).get("typeplayer").toString().equals("Exo")) {
					if (map2.get((int)_position).get("Url").toString().contains("youtube.com/embed/")) {
						_ProgresbarShow("Please wait a few moments");
						userr = map2.get((int)_position).get("user_agent").toString();
						reff = map2.get((int)_position).get("referer").toString();
						txxt = map2.get((int)_position).get("txt").toString();
						ked = map2.get((int)_position).get("drm").toString();
						r3.startRequestNetwork(RequestNetworkController.GET, map2.get((int)_position).get("Url").toString(), "", _r3_request_listener);
					}
					else {
						if (map2.get((int)_position).get("Url").toString().contains("https://vk.com/")) {
							_ProgresbarShow("Please wait a few moments");
							userr = map2.get((int)_position).get("user_agent").toString();
							reff = map2.get((int)_position).get("referer").toString();
							txxt = map2.get((int)_position).get("txt").toString();
							ked = map2.get((int)_position).get("drm").toString();
							r.startRequestNetwork(RequestNetworkController.GET, map2.get((int)_position).get("Url").toString(), "", _r_request_listener);
						}
						else {
							nnn.setClass(getApplicationContext(), PlayActivity.class);
							nnn.putExtra("txt", map2.get((int)_position).get("txt").toString());
							  try {
								  nnn.putExtra("url", AESCrypt.encrypt("85Fl31Hu49Uv15Vl31Ta", map2.get((int)_position).get("Url").toString()));
								  } catch (java.security.GeneralSecurityException e){
								      showMessage("password incorrect !" + "\n" + e.toString());
								  }
							nnn.putExtra("userAgent", map2.get((int)_position).get("user_agent").toString());
							nnn.putExtra("referer", map2.get((int)_position).get("referer").toString());
							nnn.putExtra("DRM", map2.get((int)_position).get("drm").toString());
							nnn.putExtra("name", "player");
							startActivity(nnn);
						}
					}
				}
				else {
					if (map2.get((int)_position).get("typeplayer").toString().equals("Web")) {
						nnn.setClass(getApplicationContext(), WebActivity.class);
						nnn.putExtra("txt", map2.get((int)_position).get("txt").toString());
						  try {
							  nnn.putExtra("url", AESCrypt.encrypt("85Fl31Hu49Uv15Vl31Ta", map2.get((int)_position).get("Url").toString()));
							  } catch (java.security.GeneralSecurityException e){
							      showMessage("password incorrect !" + "\n" + e.toString());
							  }
						nnn.putExtra("userAgent", map2.get((int)_position).get("user_agent").toString());
						nnn.putExtra("referer", map2.get((int)_position).get("referer").toString());
						nnn.putExtra("DRM", map2.get((int)_position).get("drm").toString());
						nnn.putExtra("name", "player");
						startActivity(nnn);
					}
					else {
						if (map2.get((int)_position).get("typeplayer").toString().equals("M3U")) {
							nnn.setClass(getApplicationContext(), M3uActivity.class);
							nnn.putExtra("txt", map2.get((int)_position).get("txt").toString());
							  try {
								  nnn.putExtra("url", AESCrypt.encrypt("85Fl31Hu49Uv15Vl31Ta", map2.get((int)_position).get("Url").toString()));
								  } catch (java.security.GeneralSecurityException e){
								      showMessage("password incorrect !" + "\n" + e.toString());
								  }
							nnn.putExtra("userAgent", map2.get((int)_position).get("user_agent").toString());
							nnn.putExtra("referer", map2.get((int)_position).get("referer").toString());
							nnn.putExtra("DRM", map2.get((int)_position).get("drm").toString());
							nnn.putExtra("name", "player");
							startActivity(nnn);
						}
					}
				}
			}
		});
		
		listview1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				data_ = map2.get((int)_position).get("txt").toString();
				d.setTitle("هل تريد حذف او تعديل قناة ".concat(map2.get((int)_position).get("txt").toString().concat(".")));
				d.setPositiveButton("حذف", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						map2.remove((int)(_position));
						data.edit().putString("data", new Gson().toJson(map2)).commit();
						((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
						if (map2.size() == 0) {
							listview1.setVisibility(View.GONE);
							textview3.setVisibility(View.VISIBLE);
							t = new TimerTask() {
								@Override
								public void run() {
									runOnUiThread(new Runnable() {
										@Override
										public void run() {
											textview3.setVisibility(View.GONE);
											imageview1.setVisibility(View.GONE);
											imageview2.setVisibility(View.VISIBLE);
											linear.setVisibility(View.VISIBLE);
										}
									});
								}
							};
							_timer.schedule(t, (int)(500));
						}
						else {
							listview1.setVisibility(View.VISIBLE);
						}
					}
				});
				d.setNegativeButton("تعديل", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						n = _position;
						edittext1.setText(map2.get((int)_position).get("txt").toString());
						edittext2.setText(map2.get((int)_position).get("Url").toString());
						if (map2.get((int)_position).get("user_agent").toString().equals("MBPlayer")) {
							edittext3.setText("");
						}
						else {
							edittext3.setText(map2.get((int)_position).get("user_agent").toString());
						}
						if (map2.get((int)_position).get("referer").toString().equals("MBPlayer")) {
							edittext4.setText("");
						}
						else {
							edittext4.setText(map2.get((int)_position).get("referer").toString());
						}
						if (map2.get((int)_position).get("drm").toString().equals("KeyID:Key")) {
							edittext5.setText("");
						}
						else {
							edittext5.setText(map2.get((int)_position).get("drm").toString());
						}
						if (map2.get((int)_position).get("typeplayer").toString().equals("Exo")) {
							checkbox1.setChecked(true);
							checkbox2.setChecked(false);
							checkbox3.setChecked(false);
						}
						else {
							if (map2.get((int)_position).get("typeplayer").toString().equals("Web")) {
								checkbox1.setChecked(false);
								checkbox2.setChecked(true);
								checkbox3.setChecked(false);
							}
							else {
								if (map2.get((int)_position).get("typeplayer").toString().equals("M3U")) {
									checkbox1.setChecked(false);
									checkbox2.setChecked(false);
									checkbox3.setChecked(true);
								}
							}
						}
						listview1.setVisibility(View.GONE);
						textview3.setVisibility(View.GONE);
						imageview1.setVisibility(View.GONE);
						imageview2.setVisibility(View.VISIBLE);
						linear.setVisibility(View.VISIBLE);
					}
				});
				d.setNeutralButton("الغاء", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						
					}
				});
				d.create().show();
				return true;
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (edittext1.getText().toString().equals("")) {
					edittext1.setError("Please Entre Title");
				}
				else {
					if (edittext2.getText().toString().equals("")) {
						edittext2.setError("Please Entre a Valid URL");
					}
					else {
						if (n == 0.5d) {
							map = new HashMap<>();
							map.put("txt", edittext1.getText().toString());
							map.put("Url", edittext2.getText().toString());
							if (edittext3.getText().toString().equals("")) {
								map.put("user_agent", "MBPlayer");
							}
							else {
								map.put("user_agent", edittext3.getText().toString());
							}
							if (edittext4.getText().toString().equals("")) {
								map.put("referer", "MBPlayer");
							}
							else {
								map.put("referer", edittext4.getText().toString());
							}
							if (edittext5.getText().toString().equals("")) {
								map.put("drm", "KeyID:Key");
							}
							else {
								map.put("drm", edittext5.getText().toString());
							}
							if (checkbox1.isChecked()) {
								map.put("typeplayer", "Exo");
							}
							else {
								if (checkbox2.isChecked()) {
									map.put("typeplayer", "Web");
								}
								else {
									if (checkbox3.isChecked()) {
										map.put("typeplayer", "M3U");
									}
								}
							}
							map2.add(map);
							data.edit().putString("data", new Gson().toJson(map2)).commit();
							linear.setVisibility(View.GONE);
							textview3.setVisibility(View.GONE);
							imageview2.setVisibility(View.GONE);
							imageview1.setVisibility(View.VISIBLE);
							listview1.setVisibility(View.VISIBLE);
							listview1.setAdapter(new Listview1Adapter(map2));
							((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
							edittext1.setText("");
							edittext2.setText("");
							edittext3.setText("");
							edittext4.setText("");
							edittext5.setText("");
						}
						else {
							map = new HashMap<>();
							map.put("txt", edittext1.getText().toString());
							map.put("Url", edittext2.getText().toString());
							if (edittext3.getText().toString().equals("")) {
								map.put("user_agent", "MBPlayer");
							}
							else {
								map.put("user_agent", edittext3.getText().toString());
							}
							if (edittext4.getText().toString().equals("")) {
								map.put("referer", "MBPlayer");
							}
							else {
								map.put("referer", edittext4.getText().toString());
							}
							if (edittext5.getText().toString().equals("")) {
								map.put("drm", "MBPlayer");
							}
							else {
								map.put("drm", edittext5.getText().toString());
							}
							if (checkbox1.isChecked()) {
								map.put("typeplayer", "Exo");
							}
							else {
								if (checkbox2.isChecked()) {
									map.put("typeplayer", "Web");
								}
								else {
									if (checkbox3.isChecked()) {
										map.put("typeplayer", "M3U");
									}
								}
							}
							map2.add(map);
							map2.remove((int)(n));
							data.edit().putString("data", new Gson().toJson(map2)).commit();
							linear.setVisibility(View.GONE);
							textview3.setVisibility(View.GONE);
							imageview2.setVisibility(View.GONE);
							imageview1.setVisibility(View.VISIBLE);
							listview1.setVisibility(View.VISIBLE);
							listview1.setAdapter(new Listview1Adapter(map2));
							((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
							edittext1.setText("");
							edittext2.setText("");
							edittext3.setText("");
							edittext4.setText("");
							edittext5.setText("");
							n = 0.5d;
						}
					}
				}
				SketchwareUtil.hideKeyboard(getApplicationContext());
			}
		});
		
		checkbox1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				checkbox1.setChecked(true);
				checkbox2.setChecked(false);
				checkbox3.setChecked(false);
			}
		});
		
		checkbox2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				checkbox1.setChecked(false);
				checkbox2.setChecked(true);
				checkbox3.setChecked(false);
			}
		});
		
		checkbox3.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				checkbox1.setChecked(false);
				checkbox2.setChecked(false);
				checkbox3.setChecked(true);
			}
		});
		
		_r_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				try{
						_link_1(_response, 0, "hls_live_ondemand\":\"", "\"");
				}catch(Exception e){
						 
				}
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
		_r2_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				try{
						st = _response.replace("\\u0026", "&");
						_link2(st, 0, "\"hlsManifestUrl\":\"", "\"");
				}catch(Exception e){
						 
				}
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
		_r3_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				try{
						_link2(_response, 0, "rel=\"canonical\" href=\"", "\"");
				}catch(Exception e){
						 
				}
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
	}
	
	private void initializeLogic() {
		if (getIntent().getStringExtra("txt") == null) {
			
		}
		else {
			nnn.setClass(getApplicationContext(), PlayActivity.class);
			nnn.putExtra("txt", getIntent().getStringExtra("txt"));
			nnn.putExtra("url", getIntent().getStringExtra("url"));
			nnn.putExtra("userAgent", getIntent().getStringExtra("user_agent"));
			nnn.putExtra("referer", getIntent().getStringExtra("referer"));
			nnn.putExtra("DRM", getIntent().getStringExtra("drm"));
			nnn.putExtra("name", "user");
			startActivity(nnn);
		}
		n = 0.5d;
		button1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF008B8B));
		if (!data.getString("data", "").equals("")) {
			map2 = new Gson().fromJson(data.getString("data", ""), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
			listview1.setAdapter(new Listview1Adapter(map2));
			((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
		}
		textview3.setVisibility(View.GONE);
		imageview2.setVisibility(View.GONE);
		linear.setVisibility(View.GONE);
		listview1.setVisibility(View.GONE);
		imageview1.setVisibility(View.VISIBLE);
		if (map2.size() == 0) {
			textview3.setVisibility(View.VISIBLE);
			t = new TimerTask() {
				@Override
				public void run() {
					runOnUiThread(new Runnable() {
						@Override
						public void run() {
							checkbox1.setChecked(true);
							checkbox2.setChecked(false);
							checkbox3.setChecked(false);
							textview3.setVisibility(View.GONE);
							imageview1.setVisibility(View.GONE);
							imageview2.setVisibility(View.VISIBLE);
							linear.setVisibility(View.VISIBLE);
						}
					});
				}
			};
			_timer.schedule(t, (int)(500));
		}
		else {
			listview1.setVisibility(View.VISIBLE);
		}
	}
	
	public void _link_1(final String _Source, final double _type, final String _StartingKey, final String _EndingKey) {
		pos2 = _Source.indexOf(_StartingKey);
		pos1 = pos2 + _StartingKey.length();
		pos = pos1;
		for(int _repeat10 = 0; _repeat10 < (int)(_Source.length()); _repeat10++) {
				if (_Source.substring((int)(pos1), (int)(pos + 1)).contains(_EndingKey)) {
						if (_type == 0) {
								new_url = _Source.substring((int)(pos1), (int)(pos));
						}
						NewSource = _Source.replace(_Source.substring((int)(pos2), (int)(pos)), "");
						if (NewSource.contains(_StartingKey)) {
								_link_1(NewSource, _type, _StartingKey, _EndingKey);
						}
						else {
								
						}
						break;
				}
				pos++;
		}
		uurrll = new_url.replace("\\/", "/");
		  try {
			  uuu = AESCrypt.encrypt("85Fl31Hu49Uv15Vl31Ta", uurrll);
			  } catch (java.security.GeneralSecurityException e){
			      showMessage("password incorrect !" + "\n" + e.toString());
			  }
		_ProgresbarDimiss();
		
		nnn.setClass(getApplicationContext(), PlayActivity.class);
		nnn.putExtra("txt", txxt);
		nnn.putExtra("url", uuu);
		nnn.putExtra("referer", reff);
		nnn.putExtra("userAgent", userr);
		nnn.putExtra("DRM", ked);
		nnn.putExtra("name", "player");
		startActivity(nnn);
	}
	
	
	public void _link2(final String _Source, final double _type, final String _StartingKey, final String _EndingKey) {
		pos2 = _Source.indexOf(_StartingKey);
		pos1 = pos2 + _StartingKey.length();
		pos = pos1;
		for(int _repeat10 = 0; _repeat10 < (int)(_Source.length()); _repeat10++) {
				if (_Source.substring((int)(pos1), (int)(pos + 1)).contains(_EndingKey)) {
						if (_type == 0) {
								new_url = _Source.substring((int)(pos1), (int)(pos));
						}
						NewSource = _Source.replace(_Source.substring((int)(pos2), (int)(pos)), "");
						if (NewSource.contains(_StartingKey)) {
								_link2(NewSource, _type, _StartingKey, _EndingKey);
						}
						else {
								
						}
						break;
				}
				pos++;
		}
		if (new_url.contains("youtube.com")) {
				r2.startRequestNetwork(RequestNetworkController.GET, new_url, "", _r2_request_listener);
		}
		else {
			((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", new_url));
			  try {
				  uuu = AESCrypt.encrypt("85Fl31Hu49Uv15Vl31Ta", new_url);
				  } catch (java.security.GeneralSecurityException e){
				      showMessage("password incorrect !" + "\n" + e.toString());
				  }
			_ProgresbarDimiss();	nnn.setClass(getApplicationContext(), PlayActivity.class);
				nnn.putExtra("txt", txxt);
				nnn.putExtra("url", uuu);
				nnn.putExtra("referer", refrere);
				nnn.putExtra("userAgent", userr);
				nnn.putExtra("DRM", ked);
				nnn.putExtra("name", "player");
				startActivity(nnn);
		}
	}
	
	
	public void _ProgresbarShow(final String _title) {
		prog = new ProgressDialog(StartActivity.this);
		prog.setMax(100);
		prog.setMessage(_title);
		prog.setIndeterminate(true);
		prog.setCancelable(false);
		prog.show();
	}
	
	
	public void _ProgresbarDimiss() {
		if(prog != null)
		{
			prog.dismiss();
		}
	}
	
	
	public void _extra() {
	}
	public static final class AESCrypt {
		    private static final String TAG = "AESCrypt";
		    private static final String AES_MODE = "AES/CBC/PKCS7Padding";
		    private static final String CHARSET = "UTF-8";
		    private static final String HASH_ALGORITHM = "SHA-256";
		    private static final byte[] ivBytes = {0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00, 0x00};
		    public static boolean DEBUG_LOG_ENABLED = false;
		    private static javax.crypto.spec.SecretKeySpec generateKey(final String password) throws java.security.NoSuchAlgorithmException, java.io.UnsupportedEncodingException {
			        final java.security.MessageDigest digest = java.security.MessageDigest.getInstance(HASH_ALGORITHM);
			        byte[] bytes = password.getBytes("UTF-8");
			        digest.update(bytes, 0, bytes.length);
			        byte[] key = digest.digest();
			        log("SHA-256 key ", key);
			        javax.crypto.spec.SecretKeySpec secretKeySpec = new javax.crypto.spec.SecretKeySpec(key, "AES");
			        return secretKeySpec;
			    }
		    public static String encrypt(final String password, String message)
		            throws java.security.GeneralSecurityException {
			        try {
				            final javax.crypto.spec.SecretKeySpec key = generateKey(password);
				            log("message", message);
				            byte[] cipherText = encrypt(key, ivBytes, message.getBytes(CHARSET));
				            String encoded = android.util.Base64.encodeToString(cipherText, android.util.Base64.NO_WRAP);
				            log("Base64.NO_WRAP", encoded);
				            return encoded;
				        } catch (java.io.UnsupportedEncodingException e) {
				            if (DEBUG_LOG_ENABLED)
				                android.util.Log.e(TAG, "UnsupportedEncodingException ", e);
				            throw new java.security.GeneralSecurityException(e);
				        }
			    }
		    public static byte[] encrypt(final javax.crypto.spec.SecretKeySpec key, final byte[] iv, final byte[] message)
		            throws java.security.GeneralSecurityException {
			        final javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(AES_MODE);
			        javax.crypto.spec.IvParameterSpec ivSpec = new javax.crypto.spec.IvParameterSpec(iv);
			        cipher.init(javax.crypto.Cipher.ENCRYPT_MODE, key, ivSpec);
			        byte[] cipherText = cipher.doFinal(message);
			        log("cipherText", cipherText);
			        return cipherText;
			    }
		    public static String decrypt(final String password, String base64EncodedCipherText)
		            throws java.security.GeneralSecurityException {
			        try {
				            final javax.crypto.spec.SecretKeySpec key = generateKey(password);
				            log("base64EncodedCipherText", base64EncodedCipherText);
				            byte[] decodedCipherText = android.util.Base64.decode(base64EncodedCipherText, android.util.Base64.NO_WRAP);
				            log("decodedCipherText", decodedCipherText);
				            byte[] decryptedBytes = decrypt(key, ivBytes, decodedCipherText);
				            log("decryptedBytes", decryptedBytes);
				            String message = new String(decryptedBytes, CHARSET);
				            log("message", message);
				            return message;
				        } catch (java.io.UnsupportedEncodingException e) {
				            if (DEBUG_LOG_ENABLED)
				                android.util.Log.e(TAG, "UnsupportedEncodingException ", e);
				            throw new java.security.GeneralSecurityException(e);
				        }
			    }
		    public static byte[] decrypt(final javax.crypto.spec.SecretKeySpec key, final byte[] iv, final byte[] decodedCipherText)
		            throws java.security.GeneralSecurityException {
			            final javax.crypto.Cipher cipher = javax.crypto.Cipher.getInstance(AES_MODE);
			            javax.crypto.spec.IvParameterSpec ivSpec = new javax.crypto.spec.IvParameterSpec(iv);
			            cipher.init(javax.crypto.Cipher.DECRYPT_MODE, key, ivSpec);
			            byte[] decryptedBytes = cipher.doFinal(decodedCipherText);
			            log("decryptedBytes", decryptedBytes);
			            return decryptedBytes;
			    }
		    private static void log(String what, byte[] bytes) {
			        if (DEBUG_LOG_ENABLED)
			            android.util.Log.d(TAG, what + "[" + bytes.length + "] [" + bytesToHex(bytes) + "]");
			    }
		    private static void log(String what, String value) {
			        if (DEBUG_LOG_ENABLED)
			            android.util.Log.d(TAG, what + "[" + value.length() + "] [" + value + "]");
			    }
		    private static String bytesToHex(byte[] bytes) {
			        final char[] hexArray = {'0', '1', '2', '3', '4', '5', '6', '7', '8',
				                '9', 'A', 'B', 'C', 'D', 'E', 'F'};
			        char[] hexChars = new char[bytes.length * 2];
			        int v;
			        for (int j = 0; j < bytes.length; j++) {
				            v = bytes[j] & 0xFF;
				            hexChars[j * 2] = hexArray[v >>> 4];
				            hexChars[j * 2 + 1] = hexArray[v & 0x0F];
				        }
			        return new String(hexChars);
			    }
		    private AESCrypt() {
			    }
	}
	private String cryptedOutput;
	private String decryptedOutput; 
	
	public void encryptText(String text, String key){
		  
		try {    	
			 cryptedOutput =  AESCrypt.encrypt(key, text);
		}catch (java.security.GeneralSecurityException e){
				showMessage("password not correct !" + "\n" + e.toString());
		}
	}
	
	public void decryptCode(String code, String key){
		  
		  try {
			  decryptedOutput =	AESCrypt.decrypt(key, code);
			  } catch (java.security.GeneralSecurityException e){
			      showMessage("password incorrect !" + "\n" + e.toString());
			  }
	}
	{
	}
	private SpannableString spannable;
	private ProgressDialog prog;
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
				_view = _inflater.inflate(R.layout.cus_start, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final TextView textview2 = _view.findViewById(R.id.textview2);
			final TextView textview3 = _view.findViewById(R.id.textview3);
			final TextView textview4 = _view.findViewById(R.id.textview4);
			final TextView textview5 = _view.findViewById(R.id.textview5);
			final TextView textview6 = _view.findViewById(R.id.textview6);
			
			linear1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFFFFFFF));
			textview3.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF008B8B));
			textview1.setText(map2.get((int)_position).get("txt").toString());
			textview1.setEllipsize(TextUtils.TruncateAt.MARQUEE);
			textview1.setMarqueeRepeatLimit(-1);
			textview1.setSingleLine(true);
			textview1.setSelected(true);
			textview2.setText(map2.get((int)_position).get("Url").toString());
			textview2.setEllipsize(TextUtils.TruncateAt.MARQUEE);
			textview2.setMarqueeRepeatLimit(-1);
			textview2.setSingleLine(true);
			textview2.setSelected(true);
			textview3.setText(map2.get((int)_position).get("typeplayer").toString());
			textview4.setText(map2.get((int)_position).get("user_agent").toString());
			textview5.setText(map2.get((int)_position).get("referer").toString());
			textview6.setText(map2.get((int)_position).get("drm").toString());
			
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