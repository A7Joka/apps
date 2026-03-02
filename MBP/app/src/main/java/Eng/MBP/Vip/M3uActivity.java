package Eng.MBP.Vip;

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
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.blogspot.atifsoftwares.animatoolib.*;
import com.bumptech.glide.Glide;
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
import dev.gerges.ParserM3U.Parser;

public class M3uActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private String UrlM3u = "";
	private String txt = "";
	private String user = "";
	private String referer = "";
	private String drm = "";
	private double number = 0;
	private double length = 0;
	private String save = "";
	
	private ArrayList<HashMap<String, Object>> lm = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> ListIPTV = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private ImageView imageview1;
	private TextView textview1;
	private ImageView imageview2;
	private TextView textview2;
	private LinearLayout linear3;
	private GridView gridview1;
	private TextInputLayout textinputlayout1;
	private EditText edittext1;
	
	private Intent nnn = new Intent();
	private AlertDialog.Builder copy_link;
	private TimerTask t;
	private TimerTask timer;
	private Intent refresh = new Intent();
	private SharedPreferences file_m3u;
	private SharedPreferences file_m3u_all;
	private Intent intent = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.m3u);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		MobileAds.initialize(this);
		
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		linear2 = findViewById(R.id.linear2);
		imageview1 = findViewById(R.id.imageview1);
		textview1 = findViewById(R.id.textview1);
		imageview2 = findViewById(R.id.imageview2);
		textview2 = findViewById(R.id.textview2);
		linear3 = findViewById(R.id.linear3);
		gridview1 = findViewById(R.id.gridview1);
		textinputlayout1 = findViewById(R.id.textinputlayout1);
		edittext1 = findViewById(R.id.edittext1);
		copy_link = new AlertDialog.Builder(this);
		file_m3u = getSharedPreferences("file_m3u", Activity.MODE_PRIVATE);
		file_m3u_all = getSharedPreferences("file_m3u_all", Activity.MODE_PRIVATE);
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				nnn.setClass(getApplicationContext(), StartActivity.class);
				startActivity(nnn);
				finish();
			}
		});
		
		imageview2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (linear3.getVisibility() == View.GONE) {
					imageview2.setImageResource(R.drawable.ic_close_white);
					linear3.setVisibility(View.VISIBLE);
					edittext1.setText("");
				}
				else {
					imageview2.setImageResource(R.drawable.ic_search_white);
					linear3.setVisibility(View.GONE);
					edittext1.setText("");
				}
			}
		});
		
		gridview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				nnn.setClass(getApplicationContext(), PlayActivity.class);
				nnn.putExtra("txt", lm.get((int)_position).get("channelName").toString());
				nnn.putExtra("url", lm.get((int)_position).get("channelUri").toString());
				nnn.putExtra("userAgent", user);
				nnn.putExtra("referer", referer);
				nnn.putExtra("DRM", drm);
				startActivity(nnn);
			}
		});
		
		edittext1.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				_Search(_charSeq);
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
	}
	
	private void initializeLogic() {
		linear3.setVisibility(View.GONE);
		user = getIntent().getStringExtra("userAgent");
		referer = getIntent().getStringExtra("referer");
		drm = getIntent().getStringExtra("DRM");
		textview1.setText("MBP - ".concat(getIntent().getStringExtra("txt").concat(" Channels Playlist")));
		textview1.setEllipsize(TextUtils.TruncateAt.MARQUEE);
		textview1.setMarqueeRepeatLimit(-1);
		textview1.setSingleLine(true);
		textview1.setSelected(true);
		_ProgresbarShow("please wait...");
		StrictMode.ThreadPolicy policy = new StrictMode.ThreadPolicy.Builder().permitAll().build();
		StrictMode.setThreadPolicy(policy);
		UrlM3u = getIntent().getStringExtra("url");
		t = new TimerTask() {
				@Override
				public void run() {
						runOnUiThread(new Runnable() {
								@Override
								public void run() {
						try{
							Parser ParserIPTV = new Parser();
							List<Entry> ListIPTV= ParserIPTV.parse(RequestIPTV(UrlM3u));
							lm = new Gson().fromJson(new Gson().toJson(ListIPTV), new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
							if (lm.size() > 0) {
								gridview1.setAdapter(new Gridview1Adapter(lm));
								textview2.setText("Channels : ".concat(String.valueOf((long)(lm.size()))));
								textview2.setTextColor(0xFF000000);
								save = new Gson().toJson(lm);
								_ProgresbarDimiss();
							}
						}catch(Exception e){
							SketchwareUtil.showMessage(getApplicationContext(), "There is a problem with the server. Try another server\n".concat(e.toString()));
							nnn.setClass(getApplicationContext(), StartActivity.class);
							startActivity(nnn);
							finish();
						}
					}
						});
				}
		};
		_timer.schedule(t, (int)(200));
		gridview1.setVerticalScrollBarEnabled(false);
	}
	
	public void _lib() {
	}public static InputStream RequestIPTV(String _url) throws Exception {
				java.net.URL UrlRequest = new java.net.URL(_url);
				java.net.URLConnection URLConnectionRequest = UrlRequest.openConnection();
				return URLConnectionRequest.getInputStream();
				
		}
		
		{
	}
	
	
	public void _ProgresbarDimiss() {
		if(prog != null)
		{
			prog.dismiss();
		}
	}
	
	
	public void _extra() {
	}
	private SpannableString spannable;
	private ProgressDialog prog;
	{
	}
	
	
	public void _ProgresbarShow(final String _title) {
		prog = new ProgressDialog(M3uActivity.this);
		prog.setMax(100);
		prog.setMessage(_title);
		prog.setIndeterminate(true);
		prog.setCancelable(false);
		prog.show();
	}
	
	
	public void _Search(final String _hg) {
		lm = new Gson().fromJson(save, new TypeToken<ArrayList<HashMap<String, Object>>>(){}.getType());
		if (_hg.length() > 0) {
			length = lm.size();
			number = lm.size() - 1;
			for(int _repeat19 = 0; _repeat19 < (int)(length); _repeat19++) {
				if (lm.get((int)number).get("channelName").toString().toLowerCase().contains(_hg.toLowerCase())) {
					
				}
				else {
					lm.remove((int)(number));
				}
				number--;
			}
		}
		textview2.setText("Channels : ".concat(String.valueOf((long)(lm.size()))));
		textview2.setTextColor(0xFF000000);
		gridview1.setAdapter(new Gridview1Adapter(lm));
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
				_view = _inflater.inflate(R.layout.cus_m3u, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			
			linear1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFFFFFFFF));
			textview1.setText(_data.get((int)_position).get("channelName").toString());
			textview1.setEllipsize(TextUtils.TruncateAt.MARQUEE);
			textview1.setMarqueeRepeatLimit(-1);
			textview1.setSingleLine(true);
			textview1.setSelected(true);
			if (_data.get((int)_position).containsKey("tvgLogo")) {
				if (_data.get((int)_position).get("tvgLogo").toString().equals("")) {
					imageview1.setImageResource(R.drawable.logo);
				}
				else {
					Glide.with(getApplicationContext()).load(Uri.parse(_data.get((int)_position).get("tvgLogo").toString())).into(imageview1);
				}
			}
			else {
				imageview1.setImageResource(R.drawable.logo);
			}
			
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