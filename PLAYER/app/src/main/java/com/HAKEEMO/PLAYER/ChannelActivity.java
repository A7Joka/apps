package com.HAKEEMO.PLAYER;

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
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.LinearLayout;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.coordinatorlayout.widget.CoordinatorLayout;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.blogspot.atifsoftwares.animatoolib.*;
import com.bumptech.glide.Glide;
import com.google.android.exoplayer2.*;
import com.google.android.exoplayer2.ui.*;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.material.appbar.AppBarLayout;
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
import org.json.*;
import dev.gerges.ParserM3U.Parser;

public class ChannelActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private String _ad_unit_id;
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private String UrlM3u = "";
	
	private ArrayList<HashMap<String, Object>> lm = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> ListIPTV = new ArrayList<>();
	
	private LinearLayout linear_all;
	private LinearLayout linear8;
	private LinearLayout linear3;
	private GridView gridview1;
	private TextView textview1;
	private TextView textview2;
	private TextView textview3;
	
	private SharedPreferences file_m3u;
	private SharedPreferences file_m3u_all;
	private AlertDialog.Builder copy_link;
	private Intent intent = new Intent();
	private TimerTask t;
	private Intent refresh = new Intent();
	private TimerTask timer;
	private InterstitialAd ad;
	private InterstitialAdLoadCallback _ad_interstitial_ad_load_callback;
	private FullScreenContentCallback _ad_full_screen_content_callback;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.channel);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		MobileAds.initialize(this);
		_ad_unit_id = "ca-app-pub-3675302410879827/8081302828";
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
		linear_all = findViewById(R.id.linear_all);
		linear8 = findViewById(R.id.linear8);
		linear3 = findViewById(R.id.linear3);
		gridview1 = findViewById(R.id.gridview1);
		textview1 = findViewById(R.id.textview1);
		textview2 = findViewById(R.id.textview2);
		textview3 = findViewById(R.id.textview3);
		file_m3u = getSharedPreferences("file_m3u", Activity.MODE_PRIVATE);
		file_m3u_all = getSharedPreferences("file_m3u_all", Activity.MODE_PRIVATE);
		copy_link = new AlertDialog.Builder(this);
		
		gridview1.setOnItemClickListener(new AdapterView.OnItemClickListener() {
			@Override
			public void onItemClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				if (true) {
					intent.putExtra("URL", lm.get((int)_position).get("channelUri").toString());
					intent.putExtra("User_agent", textview2.getText().toString());
					intent.setClass(getApplicationContext(), MainActivity.class);
					startActivity(intent);
				}
				else {
					intent.putExtra("URL", lm.get((int)_position).get("channelUri").toString());
					intent.putExtra("User_agent", textview2.getText().toString());
					intent.putExtra("exit", getIntent().getStringExtra("exit"));
					intent.setClass(getApplicationContext(), MainActivity.class);
					startActivity(intent);
				}
			}
		});
		
		gridview1.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
			@Override
			public boolean onItemLongClick(AdapterView<?> _param1, View _param2, int _param3, long _param4) {
				final int _position = _param3;
				copy_link.setTitle("نسخ الرابط");
				copy_link.setPositiveButton("نسخ رابط القناة", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", lm.get((int)_position).get("channelUri").toString()));
						SketchwareUtil.showMessage(getApplicationContext(), "تم نسخ الرابط ".concat(" ( ".concat(lm.get((int)_position).get("channelUri").toString().concat(" )"))));
					}
				});
				copy_link.setNegativeButton("نسخ رابط الصوره", new DialogInterface.OnClickListener() {
					@Override
					public void onClick(DialogInterface _dialog, int _which) {
						((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", lm.get((int)_position).get("tvgLogo").toString()));
						SketchwareUtil.showMessage(getApplicationContext(), "تم نسخ الرابط ".concat(" ( ".concat(lm.get((int)_position).get("tvgLogo").toString().concat(" )"))));
					}
				});
				copy_link.create().show();
				return true;
			}
		});
		
		_ad_interstitial_ad_load_callback = new InterstitialAdLoadCallback() {
			@Override
			public void onAdLoaded(InterstitialAd _param1) {
				
			}
			
			@Override
			public void onAdFailedToLoad(LoadAdError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		
		_ad_full_screen_content_callback = new FullScreenContentCallback() {
			@Override
			public void onAdDismissedFullScreenContent() {
				
			}
			
			@Override
			public void onAdFailedToShowFullScreenContent(AdError _adError) {
				final int _errorCode = _adError.getCode();
				final String _errorMessage = _adError.getMessage();
				
			}
			
			@Override
			public void onAdShowedFullScreenContent() {
				
			}
		};
	}
	
	private void initializeLogic() {
		textview2.setText(getIntent().getStringExtra("User_agent"));
		UrlM3u = getIntent().getStringExtra("link");
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
								_ProgresbarDimiss();
							}
						}catch(Exception e){
							SketchwareUtil.showMessage(getApplicationContext(), e.toString());
						}
					}
						});
				}
		};
		_timer.schedule(t, (int)(200));
		getSupportActionBar().hide();
		gridview1.setVerticalScrollBarEnabled(false);
	}
	
	@Override
	public void onBackPressed() {
		intent.setClass(getApplicationContext(), HomeActivity.class);
		startActivity(intent);
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
		prog = new ProgressDialog(ChannelActivity.this);
		prog.setMax(100);
		prog.setMessage(_title);
		prog.setIndeterminate(true);
		prog.setCancelable(false);
		prog.show();
	}
	
	
	public void _MarqueTextView(final TextView _view, final String _text) {
		_view.setText(_text);
		_view.setSingleLine(true);
		_view.setEllipsize(TextUtils.TruncateAt.MARQUEE);
		_view.setSelected(true);
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
				_view = _inflater.inflate(R.layout.channels, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			
			textview1.setText(_data.get((int)_position).get("channelName").toString());
			if (_data.get((int)_position).containsKey("tvgLogo")) {
				if (_data.get((int)_position).get("tvgLogo").toString().equals("")) {
					imageview1.setImageResource(R.drawable.ic_no_image);
				}
				else {
					Glide.with(getApplicationContext()).load(Uri.parse(_data.get((int)_position).get("tvgLogo").toString())).into(imageview1);
				}
			}
			else {
				imageview1.setImageResource(R.drawable.ic_no_image);
			}
			_MarqueTextView(textview1, _data.get((int)_position).get("channelName").toString());
			
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