package vip.mtx.admin;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.Intent;
import android.content.res.*;
import android.graphics.*;
import android.graphics.Typeface;
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
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
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
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class LiveActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	private FirebaseDatabase _firebase = FirebaseDatabase.getInstance();
	
	private Toolbar _toolbar;
	private AppBarLayout _app_bar;
	private CoordinatorLayout _coordinator;
	private String fontName = "";
	private String typeace = "";
	private String url = "";
	private String url0 = "";
	private String url1 = "";
	private String url2 = "";
	private double pos2 = 0;
	private double pos1 = 0;
	private double pos = 0;
	private String html1 = "";
	private String html = "";
	private String NewSource = "";
	private String html0 = "";
	private String cup = "";
	private String tv = "";
	private String mic = "";
	private String match = "";
	private String time = "";
	private double number = 0;
	private double length = 0;
	private String watch = "";
	private String watch_live = "";
	private String watch_finsh = "";
	private String txt = "";
	private String user = "";
	private String refer = "";
	private String key = "";
	
	private ArrayList<HashMap<String, Object>> mpl = new ArrayList<>();
	private ArrayList<String> listImg2 = new ArrayList<>();
	private ArrayList<String> listName2 = new ArrayList<>();
	private ArrayList<String> listTV = new ArrayList<>();
	private ArrayList<String> listMIC = new ArrayList<>();
	private ArrayList<String> listCUP = new ArrayList<>();
	private ArrayList<String> listImg1 = new ArrayList<>();
	private ArrayList<String> listName1 = new ArrayList<>();
	private ArrayList<String> listDate = new ArrayList<>();
	private ArrayList<String> listhala = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> listUrl = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> livet = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear2;
	private LinearLayout linear60;
	private ListView listview1;
	private LinearLayout linear3;
	private LinearLayout linear61;
	private TextView textview5;
	private EditText edittext_date;
	private ImageView imageview_click;
	private TextView textview1;
	
	private Intent live = new Intent();
	private TimerTask t;
	private Intent i = new Intent();
	private RequestNetwork req;
	private RequestNetwork.RequestListener _req_request_listener;
	private TimerTask entimer;
	private DatabaseReference mt = _firebase.getReference("mt");
	private ChildEventListener _mt_child_listener;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.live);
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
		linear1 = findViewById(R.id.linear1);
		linear2 = findViewById(R.id.linear2);
		linear60 = findViewById(R.id.linear60);
		listview1 = findViewById(R.id.listview1);
		linear3 = findViewById(R.id.linear3);
		linear61 = findViewById(R.id.linear61);
		textview5 = findViewById(R.id.textview5);
		edittext_date = findViewById(R.id.edittext_date);
		imageview_click = findViewById(R.id.imageview_click);
		textview1 = findViewById(R.id.textview1);
		req = new RequestNetwork(this);
		
		edittext_date.addTextChangedListener(new TextWatcher() {
			@Override
			public void onTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				final String _charSeq = _param1.toString();
				linear3.setVisibility(View.GONE);
				linear60.setVisibility(View.GONE);
				listUrl.clear();
				listImg1.clear();
				listName1.clear();
				listImg2.clear();
				listName2.clear();
				listTV.clear();
				listMIC.clear();
				listCUP.clear();
				listDate.clear();
				listhala.clear();
				req.startRequestNetwork(RequestNetworkController.GET, "https://www.yalla-group.com/live/".concat(_charSeq), "", _req_request_listener);
			}
			
			@Override
			public void beforeTextChanged(CharSequence _param1, int _param2, int _param3, int _param4) {
				
			}
			
			@Override
			public void afterTextChanged(Editable _param1) {
				
			}
		});
		
		imageview_click.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				androidx.appcompat.app.AppCompatDialogFragment newFragment = new DatePickerFragment();
				
				newFragment.show(getSupportFragmentManager(), "Date Picker");
			}
		});
		
		_req_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				_GetSource(_response, 3, "// var data = {date : \"", "\"");
				if (_response.contains("<span class=\"right-side teams-logo\">")) {
					match = _response.substring((int)(_response.indexOf("<div class=\"current-plays\">")), (int)(_response.indexOf("</li></ul>")));
					_GetSource(match, 2, "<span class=\"left-side teams-logo\">", "<span class=\"clickToWatch\">");
					_GetSource(match, 1, "<span class=\"right-side teams-logo\">", "<span class=\"left-side teams-logo\">");
					_GetSource(match, 0, "<a href=\"https://www.yalla-group.com/live/match?live_id=", "&");
				}
				else {
					listUrl.clear();
					listImg1.clear();
					listName1.clear();
					listImg2.clear();
					listName2.clear();
					listTV.clear();
					listMIC.clear();
					listCUP.clear();
					listDate.clear();
					listhala.clear();
					((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
					linear3.setVisibility(View.VISIBLE);
					linear60.setVisibility(View.VISIBLE);
				}
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				SketchwareUtil.showMessage(getApplicationContext(), "حدث خطأ");
			}
		};
		
		_mt_child_listener = new ChildEventListener() {
			@Override
			public void onChildAdded(DataSnapshot _param1, String _param2) {
				GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
				final String _childKey = _param1.getKey();
				final HashMap<String, Object> _childValue = _param1.getValue(_ind);
				mt.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						livet = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								livet.add(_map);
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
				mt.addListenerForSingleValueEvent(new ValueEventListener() {
					@Override
					public void onDataChange(DataSnapshot _dataSnapshot) {
						livet = new ArrayList<>();
						try {
							GenericTypeIndicator<HashMap<String, Object>> _ind = new GenericTypeIndicator<HashMap<String, Object>>() {};
							for (DataSnapshot _data : _dataSnapshot.getChildren()) {
								HashMap<String, Object> _map = _data.getValue(_ind);
								livet.add(_map);
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
		mt.addChildEventListener(_mt_child_listener);
	}
	
	private void initializeLogic() {
		_telegramLoaderDialog(true);
		getWindow().getDecorView().setSystemUiVisibility( View.SYSTEM_UI_FLAG_HIDE_NAVIGATION| View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
		_changeActivityFont("neosansarabic");
		req.startRequestNetwork(RequestNetworkController.GET, "https://www.yalla-group.com/live/", "", _req_request_listener);
		linear3.setVisibility(View.GONE);
		linear60.setVisibility(View.GONE);
		listview1.setSelector(android.R.color.transparent);
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
	
	
	public void _rippleRoundStroke(final View _view, final String _focus, final String _pressed, final double _round, final double _stroke, final String _strokeclr) {
		android.graphics.drawable.GradientDrawable GG = new android.graphics.drawable.GradientDrawable();
		GG.setColor(Color.parseColor(_focus));
		GG.setCornerRadius((float)_round);
		GG.setStroke((int) _stroke,
		Color.parseColor("#" + _strokeclr.replace("#", "")));
		android.graphics.drawable.RippleDrawable RE = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor(_pressed)}), GG, null);
		_view.setBackground(RE);
	}
	
	
	public void _GetSource(final String _Source, final double _type, final String _StartingKey, final String _EndingKey) {
		pos2 = _Source.indexOf(_StartingKey);
		pos1 = pos2 + _StartingKey.length();
		pos = pos1;
		for(int _repeat21 = 0; _repeat21 < (int)(_Source.length()); _repeat21++) {
			if (_Source.substring((int)(pos1), (int)(pos + 1)).contains(_EndingKey)) {
				if (_type == 3) {
					textview5.setText(_Source.substring((int)(pos1), (int)(pos)).replace("/12/", " ديسمبر ").replace("/11/", " نوفمبر ").replace("/10/", " اكتوبر ").replace("/09/", " سبتمبر ").replace("/08/", " اغسطس ").replace("/07/", " يوليو ").replace("/06/", " يونيو ").replace("/05/", " مايو ").replace("/04/", "ابريل").replace("/03/", " مارس ").replace("/02/", " فبراير ").replace("/01/", " يناير "));
				}
				else {
					if (_type == 2) {
						html1 = _Source.substring((int)(pos1), (int)(pos));
						Document docc = Jsoup.parse(html1);
						listImg2.add(docc.getElementsByTag("img").attr("src"));
						listName2.add(docc.getElementsByTag("span").first().text());
						listTV.add(docc.getElementsByTag("span").get(2).text());
						listMIC.add(docc.getElementsByTag("span").get(3).text());
						listCUP.add(docc.getElementsByTag("span").get(4).text());
					}
					else {
						if (_type == 1) {
							if (_Source.substring((int)(pos1), (int)(pos)).contains("<ul>")) {
								html = _Source.substring((int)(pos1), (int)(pos));
								Document doc = Jsoup.parse(html);
								listImg1.add(doc.getElementsByTag("img").attr("src"));
								listName1.add(doc.getElementsByTag("span").first().text());
								listDate.add(doc.getElementsByTag("span").get(2).text());
								listhala.add(doc.getElementsByTag("ul").first().text());
							}
							else {
								html = _Source.substring((int)(pos1), (int)(pos));
								Document doc = Jsoup.parse(html);
								listImg1.add(doc.getElementsByTag("img").attr("src"));
								listName1.add(doc.getElementsByTag("span").first().text());
								listDate.add(doc.getElementsByTag("span").get(2).text());
								listhala.add(":");
							}
						}
						else {
							{
								HashMap<String, Object> _item = new HashMap<>();
								_item.put("url", _Source.substring((int)(pos1), (int)(pos)));
								listUrl.add(_item);
							}
							
						}
					}
				}
				NewSource = _Source.replace(_Source.substring((int)(pos2), (int)(pos)), "");
				if (NewSource.contains(_StartingKey)) {
					_GetSource(NewSource, _type, _StartingKey, _EndingKey);
				}
				else {
					if (_type == 0) {
						linear60.setVisibility(View.VISIBLE);
						listview1.setAdapter(new Listview1Adapter(listUrl));
						((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
						_telegramLoaderDialog(false);
					}
				}
				break;
			}
			pos++;
		}
	}
	
	
	public void _Extra() {
	}
	public static class DatePickerFragment extends androidx.appcompat.app.AppCompatDialogFragment implements DatePickerDialog.OnDateSetListener {
		@Override
		public Dialog onCreateDialog(Bundle savedInstanceState) {
			final Calendar c = Calendar.getInstance();
			int year = c.get(Calendar.YEAR);
			int month = c.get(Calendar.MONTH);
			int day = c.get(Calendar.DAY_OF_MONTH);
			return new DatePickerDialog(getActivity(), AlertDialog.THEME_DEVICE_DEFAULT_DARK , this, year, month, day);
		}
		public void onDateSet(DatePicker view, int year, int month, int day) {
			int mon = month +1;
			String date = "?d=" + day + "&m=" + mon + "&y=" + year;
			EditText edittext_date = (EditText) getActivity().findViewById(R.id.edittext_date);
			edittext_date.setText(date);
		}
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
				_view = _inflater.inflate(R.layout.livee, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final LinearLayout linear6 = _view.findViewById(R.id.linear6);
			final LinearLayout linear7 = _view.findViewById(R.id.linear7);
			final LinearLayout linear18 = _view.findViewById(R.id.linear18);
			final TextView textview8 = _view.findViewById(R.id.textview8);
			final LinearLayout linear21 = _view.findViewById(R.id.linear21);
			final LinearLayout linear19 = _view.findViewById(R.id.linear19);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			final TextView textview2 = _view.findViewById(R.id.textview2);
			final LinearLayout linear22 = _view.findViewById(R.id.linear22);
			final TextView textview7 = _view.findViewById(R.id.textview7);
			final LinearLayout linear23 = _view.findViewById(R.id.linear23);
			final TextView textview3 = _view.findViewById(R.id.textview3);
			final ImageView imageview2 = _view.findViewById(R.id.imageview2);
			
			textview1.setEllipsize(TextUtils.TruncateAt.MARQUEE);
			textview1.setMarqueeRepeatLimit(-1);
			textview1.setSingleLine(true);
			textview1.setSelected(true);
			textview2.setEllipsize(TextUtils.TruncateAt.MARQUEE);
			textview2.setMarqueeRepeatLimit(-1);
			textview2.setSingleLine(true);
			textview2.setSelected(true);
			textview3.setEllipsize(TextUtils.TruncateAt.MARQUEE);
			textview3.setMarqueeRepeatLimit(-1);
			textview3.setSingleLine(true);
			textview3.setSelected(true);
			textview7.setEllipsize(TextUtils.TruncateAt.MARQUEE);
			textview7.setMarqueeRepeatLimit(-1);
			textview7.setSingleLine(true);
			textview7.setSelected(true);
			textview8.setEllipsize(TextUtils.TruncateAt.MARQUEE);
			textview8.setMarqueeRepeatLimit(-1);
			textview8.setSingleLine(true);
			textview8.setSelected(true);
			linear1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)20, 0xFF78022C));
			textview2.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)10, 0xFFEEEEEE));
			textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
			textview2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
			textview3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
			textview7.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 1);
			Glide.with(getApplicationContext()).load(Uri.parse(listImg1.get((int)(_position)))).into(imageview1);
			textview1.setText(listName1.get((int)(_position)));
			Glide.with(getApplicationContext()).load(Uri.parse(listImg2.get((int)(_position)))).into(imageview2);
			textview3.setText(listName2.get((int)(_position)));
			textview2.setText(listDate.get((int)(_position)).replace("ص", ""));
			textview8.setText(listCUP.get((int)(_position)));
			if (listhala.get((int)(_position)).contains(":")) {
				linear23.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)90, 0xFFE0E0E0));
				textview7.setText("لم تبدا");
				textview7.setTextColor(0xFFE0E0E0);
			}
			else {
				if (listhala.get((int)(_position)).contains("قريباً")) {
					linear23.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)90, 0xFFFF9800));
					textview7.setText("بعد قليل");
					textview7.setTextColor(0xFFFF9800);
				}
				else {
					if (listhala.get((int)(_position)).contains("الآن")) {
						linear23.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)90, 0xFFF44336));
						textview7.setText("مباشر");
						textview7.setTextColor(0xFFF44336);
					}
					else {
						linear23.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)90, 0xFF9E9E9E));
						textview7.setText("انتهت");
						textview7.setTextColor(0xFF9E9E9E);
					}
				}
			}
			linear1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					i.setClass(getApplicationContext(), LiveeeActivity.class);
					if (livet.size() > 0) {
						number = livet.size() - 1;
						length = livet.size();
						for(int _repeat397 = 0; _repeat397 < (int)(length); _repeat397++) {
							if (livet.get((int)number).get("key").toString().toLowerCase().contains(listUrl.get((int)_position).get("url").toString().toLowerCase())) {
								i.putExtra("key", livet.get((int)number).get("key").toString());
							}
							else {
								i.putExtra("key", listUrl.get((int)_position).get("url").toString());
							}
							number--;
						}
						Collections.reverse(livet);
					}
					else {
						i.putExtra("key", listUrl.get((int)_position).get("url").toString());
					}
					SketchwareUtil.showMessage(getApplicationContext(), listName1.get((int)(_position)).concat(" ضد ".concat(listName2.get((int)(_position)))));
					startActivity(i);
				}
			});
			
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