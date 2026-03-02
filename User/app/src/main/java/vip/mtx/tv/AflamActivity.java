package vip.mtx.tv;

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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.bumptech.glide.Glide;
import com.google.android.exoplayer2.ui.*;
import com.google.firebase.FirebaseApp;
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
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;

public class AflamActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private String fontName = "";
	private String typeace = "";
	private double N00 = 0;
	private double N01 = 0;
	private double N0 = 0;
	private double N1 = 0;
	private double n0 = 0;
	private double m0 = 0;
	private double n1 = 0;
	private double m1 = 0;
	private double change = 0;
	private String url = "";
	private String url0 = "";
	private String url1 = "";
	private String url2 = "";
	private double pos2 = 0;
	private double pos1 = 0;
	private double pos = 0;
	private String st = "";
	private String html = "";
	private String img = "";
	private String name = "";
	private String alt = "";
	private String NewSource = "";
	private String string = "";
	private double PageLimit = 0;
	private boolean statusLoad = false;
	private double ops1 = 0;
	private double ops2 = 0;
	private double BackPosition = 0;
	private String imgg = "";
	private String eng = "";
	private String nam = "";
	private double xx = 0;
	
	private ArrayList<HashMap<String, Object>> map = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> series = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> mapNames = new ArrayList<>();
	private ArrayList<String> imgbbbb = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> we = new ArrayList<>();
	private ArrayList<String> linkkk = new ArrayList<>();
	
	private LinearLayout linear18;
	private ScrollView vscroll1;
	private ScrollView vscroll2;
	private ScrollView vscroll3;
	private LinearLayout gred;
	private LinearLayout linear19;
	private LinearLayout linear27;
	private LinearLayout linear28;
	private LinearLayout linear29;
	private LinearLayout linear30;
	private ImageView imageview9;
	private TextView text1;
	private ImageView imageview10;
	private TextView text2;
	private ImageView imageview11;
	private TextView text3;
	private ImageView imageview12;
	private TextView text4;
	private LinearLayout linear31;
	private LinearLayout linear42;
	private LinearLayout linear43;
	private LinearLayout linear44;
	private LinearLayout linear45;
	private LinearLayout linear46;
	private LinearLayout linear47;
	private ImageView imageview20;
	private TextView text_1;
	private ImageView imageview21;
	private TextView text_2;
	private ImageView imageview22;
	private TextView text_3;
	private ImageView imageview23;
	private TextView text_4;
	private ImageView imageview24;
	private TextView text_5;
	private ImageView imageview25;
	private TextView text_6;
	private LinearLayout linear62;
	private LinearLayout linear51;
	private LinearLayout linear52;
	private LinearLayout linear53;
	private LinearLayout linear54;
	private LinearLayout linear55;
	private LinearLayout linear56;
	private ImageView imageview27;
	private TextView text_01;
	private ImageView imageview28;
	private TextView text_02;
	private ImageView imageview29;
	private TextView text_03;
	private ImageView imageview30;
	private TextView text_04;
	private ImageView imageview31;
	private TextView text_05;
	private ImageView imageview32;
	private TextView text_06;
	private GridView gridview1;
	private LinearLayout linear69;
	private LinearLayout linear9;
	private Button button1;
	private TextView textview1;
	private Button button2;
	private ImageView imageview2;
	private TextView textview9;
	
	private Intent i = new Intent();
	private AlertDialog.Builder dialog;
	private TimerTask t;
	private RequestNetwork req;
	private RequestNetwork.RequestListener _req_request_listener;
	private TimerTask ww;
	private SharedPreferences settings;
	private RequestNetwork req1;
	private RequestNetwork.RequestListener _req1_request_listener;
	private RequestNetwork req2;
	private RequestNetwork.RequestListener _req2_request_listener;
	private TimerTask entimer;
	private SharedPreferences shared;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.aflam);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear18 = findViewById(R.id.linear18);
		vscroll1 = findViewById(R.id.vscroll1);
		vscroll2 = findViewById(R.id.vscroll2);
		vscroll3 = findViewById(R.id.vscroll3);
		gred = findViewById(R.id.gred);
		linear19 = findViewById(R.id.linear19);
		linear27 = findViewById(R.id.linear27);
		linear28 = findViewById(R.id.linear28);
		linear29 = findViewById(R.id.linear29);
		linear30 = findViewById(R.id.linear30);
		imageview9 = findViewById(R.id.imageview9);
		text1 = findViewById(R.id.text1);
		imageview10 = findViewById(R.id.imageview10);
		text2 = findViewById(R.id.text2);
		imageview11 = findViewById(R.id.imageview11);
		text3 = findViewById(R.id.text3);
		imageview12 = findViewById(R.id.imageview12);
		text4 = findViewById(R.id.text4);
		linear31 = findViewById(R.id.linear31);
		linear42 = findViewById(R.id.linear42);
		linear43 = findViewById(R.id.linear43);
		linear44 = findViewById(R.id.linear44);
		linear45 = findViewById(R.id.linear45);
		linear46 = findViewById(R.id.linear46);
		linear47 = findViewById(R.id.linear47);
		imageview20 = findViewById(R.id.imageview20);
		text_1 = findViewById(R.id.text_1);
		imageview21 = findViewById(R.id.imageview21);
		text_2 = findViewById(R.id.text_2);
		imageview22 = findViewById(R.id.imageview22);
		text_3 = findViewById(R.id.text_3);
		imageview23 = findViewById(R.id.imageview23);
		text_4 = findViewById(R.id.text_4);
		imageview24 = findViewById(R.id.imageview24);
		text_5 = findViewById(R.id.text_5);
		imageview25 = findViewById(R.id.imageview25);
		text_6 = findViewById(R.id.text_6);
		linear62 = findViewById(R.id.linear62);
		linear51 = findViewById(R.id.linear51);
		linear52 = findViewById(R.id.linear52);
		linear53 = findViewById(R.id.linear53);
		linear54 = findViewById(R.id.linear54);
		linear55 = findViewById(R.id.linear55);
		linear56 = findViewById(R.id.linear56);
		imageview27 = findViewById(R.id.imageview27);
		text_01 = findViewById(R.id.text_01);
		imageview28 = findViewById(R.id.imageview28);
		text_02 = findViewById(R.id.text_02);
		imageview29 = findViewById(R.id.imageview29);
		text_03 = findViewById(R.id.text_03);
		imageview30 = findViewById(R.id.imageview30);
		text_04 = findViewById(R.id.text_04);
		imageview31 = findViewById(R.id.imageview31);
		text_05 = findViewById(R.id.text_05);
		imageview32 = findViewById(R.id.imageview32);
		text_06 = findViewById(R.id.text_06);
		gridview1 = findViewById(R.id.gridview1);
		linear69 = findViewById(R.id.linear69);
		linear9 = findViewById(R.id.linear9);
		button1 = findViewById(R.id.button1);
		textview1 = findViewById(R.id.textview1);
		button2 = findViewById(R.id.button2);
		imageview2 = findViewById(R.id.imageview2);
		textview9 = findViewById(R.id.textview9);
		dialog = new AlertDialog.Builder(this);
		req = new RequestNetwork(this);
		settings = getSharedPreferences("settings", Activity.MODE_PRIVATE);
		req1 = new RequestNetwork(this);
		req2 = new RequestNetwork(this);
		shared = getSharedPreferences("shared", Activity.MODE_PRIVATE);
		
		linear27.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				vscroll1.setVisibility(View.GONE);
				vscroll2.setVisibility(View.VISIBLE);
				vscroll3.setVisibility(View.GONE);
				gred.setVisibility(View.GONE);
				eng = "H";
			}
		});
		
		linear28.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				vscroll1.setVisibility(View.GONE);
				vscroll2.setVisibility(View.GONE);
				vscroll3.setVisibility(View.VISIBLE);
				gred.setVisibility(View.GONE);
				eng = "H";
			}
		});
		
		linear29.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				vscroll1.setVisibility(View.GONE);
				vscroll2.setVisibility(View.GONE);
				vscroll3.setVisibility(View.GONE);
				gred.setVisibility(View.VISIBLE);
				imgbbbb.clear();
				mapNames.clear();
				linkkk.clear();
				we.clear();
				string = "https://wecima.co/category/%d8%a8%d8%b1%d8%a7%d9%85%d8%ac-%d8%aa%d9%84%d9%8a%d9%81%d8%b2%d9%8a%d9%88%d9%86%d9%8a%d8%a9";
				_DialogShow(true);
				eng = "H";
			}
		});
		
		linear30.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				vscroll1.setVisibility(View.GONE);
				vscroll2.setVisibility(View.GONE);
				vscroll3.setVisibility(View.GONE);
				gred.setVisibility(View.VISIBLE);
				imgbbbb.clear();
				mapNames.clear();
				linkkk.clear();
				we.clear();
				string = "https://wecima.co/category/%d9%85%d8%b5%d8%a7%d8%b1%d8%b9%d8%a9-%d8%ad%d8%b1%d8%a9/";
				_DialogShow(true);
				eng = "H";
			}
		});
		
		linear42.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				vscroll1.setVisibility(View.GONE);
				vscroll2.setVisibility(View.GONE);
				vscroll3.setVisibility(View.GONE);
				gred.setVisibility(View.VISIBLE);
				imgbbbb.clear();
				mapNames.clear();
				linkkk.clear();
				we.clear();
				string = "https://wecima.co/category/%d8%a7%d9%81%d9%84%d8%a7%d9%85/%d8%a7%d9%81%d9%84%d8%a7%d9%85-%d8%b9%d8%b1%d8%a8%d9%8a-arabic-movies/";
				_DialogShow(true);
				eng = "M";
			}
		});
		
		linear43.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				vscroll1.setVisibility(View.GONE);
				vscroll2.setVisibility(View.GONE);
				vscroll3.setVisibility(View.GONE);
				gred.setVisibility(View.VISIBLE);
				imgbbbb.clear();
				mapNames.clear();
				linkkk.clear();
				we.clear();
				string = "https://wecima.co/category/%d8%a7%d9%81%d9%84%d8%a7%d9%85/10-movies-english-%d8%a7%d9%81%d9%84%d8%a7%d9%85-%d8%a7%d8%ac%d9%86%d8%a8%d9%8a/";
				_DialogShow(true);
				eng = "M";
			}
		});
		
		linear44.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				vscroll1.setVisibility(View.GONE);
				vscroll2.setVisibility(View.GONE);
				vscroll3.setVisibility(View.GONE);
				gred.setVisibility(View.VISIBLE);
				imgbbbb.clear();
				mapNames.clear();
				linkkk.clear();
				we.clear();
				string = "https://wecima.co/category/%d8%a7%d9%81%d9%84%d8%a7%d9%85/%d8%a7%d9%81%d9%84%d8%a7%d9%85-%d9%87%d9%86%d8%af%d9%8a-indian-movies/";
				_DialogShow(true);
				eng = "M";
			}
		});
		
		linear45.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				vscroll1.setVisibility(View.GONE);
				vscroll2.setVisibility(View.GONE);
				vscroll3.setVisibility(View.GONE);
				gred.setVisibility(View.VISIBLE);
				imgbbbb.clear();
				mapNames.clear();
				linkkk.clear();
				we.clear();
				string = "https://wecima.co/category/%d8%a7%d9%81%d9%84%d8%a7%d9%85/%d8%a7%d9%81%d9%84%d8%a7%d9%85-%d8%aa%d8%b1%d9%83%d9%89-turkish-films/";
				_DialogShow(true);
				eng = "M";
			}
		});
		
		linear46.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				vscroll1.setVisibility(View.GONE);
				vscroll2.setVisibility(View.GONE);
				vscroll3.setVisibility(View.GONE);
				gred.setVisibility(View.VISIBLE);
				imgbbbb.clear();
				mapNames.clear();
				linkkk.clear();
				we.clear();
				string = "https://wecima.co/category/%d8%a7%d9%81%d9%84%d8%a7%d9%85/%d8%a7%d9%81%d9%84%d8%a7%d9%85-%d9%88%d8%ab%d8%a7%d8%a6%d9%82%d9%8a%d8%a9-documentary-films/";
				_DialogShow(true);
				eng = "M";
			}
		});
		
		linear47.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				vscroll1.setVisibility(View.GONE);
				vscroll2.setVisibility(View.GONE);
				vscroll3.setVisibility(View.GONE);
				gred.setVisibility(View.VISIBLE);
				imgbbbb.clear();
				mapNames.clear();
				linkkk.clear();
				we.clear();
				string = "https://wecima.co/category/%d8%a7%d9%81%d9%84%d8%a7%d9%85-%d9%83%d8%b1%d8%aa%d9%88%d9%86/";
				_DialogShow(true);
				eng = "M";
			}
		});
		
		linear51.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				vscroll1.setVisibility(View.GONE);
				vscroll2.setVisibility(View.GONE);
				vscroll3.setVisibility(View.GONE);
				gred.setVisibility(View.VISIBLE);
				imgbbbb.clear();
				mapNames.clear();
				linkkk.clear();
				we.clear();
				string = "https://wecima.co/category/%d9%85%d8%b3%d9%84%d8%b3%d9%84%d8%a7%d8%aa/13-%d9%85%d8%b3%d9%84%d8%b3%d9%84%d8%a7%d8%aa-%d8%b9%d8%b1%d8%a8%d9%8a%d9%87-arabic-series";
				_DialogShow(true);
				eng = "S";
			}
		});
		
		linear52.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				vscroll1.setVisibility(View.GONE);
				vscroll2.setVisibility(View.GONE);
				vscroll3.setVisibility(View.GONE);
				gred.setVisibility(View.VISIBLE);
				imgbbbb.clear();
				mapNames.clear();
				linkkk.clear();
				we.clear();
				string = "https://wecima.co/category/%d9%85%d8%b3%d9%84%d8%b3%d9%84%d8%a7%d8%aa/5-series-english-%d9%85%d8%b3%d9%84%d8%b3%d9%84%d8%a7%d8%aa-%d8%a7%d8%ac%d9%86%d8%a8%d9%8a";
				_DialogShow(true);
				eng = "S";
			}
		});
		
		linear53.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				vscroll1.setVisibility(View.GONE);
				vscroll2.setVisibility(View.GONE);
				vscroll3.setVisibility(View.GONE);
				gred.setVisibility(View.VISIBLE);
				imgbbbb.clear();
				mapNames.clear();
				linkkk.clear();
				we.clear();
				string = "https://wecima.co/category/%d9%85%d8%b3%d9%84%d8%b3%d9%84%d8%a7%d8%aa/9-series-indian-%d9%85%d8%b3%d9%84%d8%b3%d9%84%d8%a7%d8%aa-%d9%87%d9%86%d8%af%d9%8a%d8%a9";
				_DialogShow(true);
				eng = "S";
			}
		});
		
		linear54.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				vscroll1.setVisibility(View.GONE);
				vscroll2.setVisibility(View.GONE);
				vscroll3.setVisibility(View.GONE);
				gred.setVisibility(View.VISIBLE);
				imgbbbb.clear();
				mapNames.clear();
				linkkk.clear();
				we.clear();
				string = "https://wecima.co/category/%d9%85%d8%b3%d9%84%d8%b3%d9%84%d8%a7%d8%aa/8-%d9%85%d8%b3%d9%84%d8%b3%d9%84%d8%a7%d8%aa-%d8%aa%d8%b1%d9%83%d9%8a%d8%a9-turkish-series";
				_DialogShow(true);
				eng = "S";
			}
		});
		
		linear55.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				vscroll1.setVisibility(View.GONE);
				vscroll2.setVisibility(View.GONE);
				vscroll3.setVisibility(View.GONE);
				gred.setVisibility(View.VISIBLE);
				imgbbbb.clear();
				mapNames.clear();
				linkkk.clear();
				we.clear();
				string = "https://wecima.co/category/%d9%85%d8%b3%d9%84%d8%b3%d9%84%d8%a7%d8%aa/%d9%85%d8%b3%d9%84%d8%b3%d9%84%d8%a7%d8%aa-%d9%88%d8%ab%d8%a7%d8%a6%d9%82%d9%8a%d8%a9-documentary-series";
				_DialogShow(true);
				eng = "S";
			}
		});
		
		linear56.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				vscroll1.setVisibility(View.GONE);
				vscroll2.setVisibility(View.GONE);
				vscroll3.setVisibility(View.GONE);
				gred.setVisibility(View.VISIBLE);
				imgbbbb.clear();
				mapNames.clear();
				linkkk.clear();
				we.clear();
				string = "https://wecima.co/category/%d9%85%d8%b3%d9%84%d8%b3%d9%84%d8%a7%d8%aa-%d9%83%d8%b1%d8%aa%d9%88%d9%86";
				_DialogShow(true);
				eng = "S";
			}
		});
		
		linear9.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (xx == 0) {
					_telegramLoaderDialog(true);
					linear9.setVisibility(View.GONE);
					gridview1.setVisibility(View.VISIBLE);
					linear69.setVisibility(View.VISIBLE);
					PageLimit++;
					_DialogShow(true);
					entimer = new TimerTask() {
						@Override
						public void run() {
							runOnUiThread(new Runnable() {
								@Override
								public void run() {
									imgbbbb.clear();
									mapNames.clear();
									linkkk.clear();
									we.clear();
									PageLimit--;
									_DialogShow(true);
								}
							});
						}
					};
					_timer.schedule(entimer, (int)(3000));
					xx++;
				}
				else {
					linear9.setVisibility(View.GONE);
					gridview1.setVisibility(View.VISIBLE);
					linear69.setVisibility(View.VISIBLE);
				}
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (PageLimit == 1) {
					SketchwareUtil.showMessage(getApplicationContext(), "انت ف اول صفحة");
				}
				else {
					PageLimit--;
					_DialogShow(true);
				}
			}
		});
		
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				PageLimit++;
				_DialogShow(true);
			}
		});
		
		_req_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				try{
						if (" آخر الإضافات".contains(_response)) {
								ops1 = _response.indexOf(" آخر الإضافات");
								ops2 = _response.indexOf("تابع وي سيم");
								_GetSource(_response.substring((int)(ops1), (int)(ops2)), 0, "<div class=\"Thumb--GridItem\"><a href=\"", "<span class=\"year\">");
								statusLoad = false;
						}
						else {
								ops1 = _response.indexOf("</wecimaslider>");
								ops2 = _response.indexOf("</html>");
								_GetSource(_response.substring((int)(ops1), (int)(ops2)), 0, "<div class=\"Thumb--GridItem\"><a href=\"", "<span class=\"year\">");
								statusLoad = false;
						}
				}catch(Exception e){
						gridview1.setVisibility(View.GONE);
						linear69.setVisibility(View.GONE);
						linear9.setVisibility(View.VISIBLE);
						if (xx == 1) {
								_telegramLoaderDialog(false);
						}
				}
				/*
try{
if (" آخر الإضافات".contains(_response)) {
ops1 = _response.indexOf(" آخر الإضافات");
ops2 = _response.indexOf("تابع وي سيم");
_GetSource(_response.substring((int)(ops1), (int)(ops2)), 0, "<div class=\"Thumb--GridItem\"><a href=\"", "<span class=\"year\">");
statusLoad = false;
}
else {
ops1 = _response.indexOf("</wecimaslider>");
ops2 = _response.indexOf("</html>");
_GetSource(_response.substring((int)(ops1), (int)(ops2)), 0, "<div class=\"Thumb--GridItem\"><a href=\"", "<span class=\"year\">");
statusLoad = false;
}
}catch(Exception e){
gridview1.setVisibility(View.GONE);
linear69.setVisibility(View.GONE);
linear9.setVisibility(View.VISIBLE);
if (xx == 1) {
_telegramLoaderDialog(false);
}
}
*/
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
		_req1_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				html = _response.substring((int)(_response.indexOf("<div class=\"Inner--WatchServersEmbed\">")), (int)(_response.indexOf("<div class=\"loader\">")));
				Document doc = Jsoup.parse(html);
				req2.startRequestNetwork(RequestNetworkController.GET, doc.getElementsByTag("iframe").attr("data-lazy-src"), "", _req2_request_listener);
				/*
html = _response.substring((int)(_response.indexOf("<div class=\"Inner--WatchServersEmbed\">")), (int)(_response.indexOf("<div class=\"loader\">")));
Document doc = Jsoup.parse(html);
req2.startRequestNetwork(RequestNetworkController.GET, doc.getElementsByTag("iframe").attr("data-lazy-src"), "", _req2_request_listener);
*/
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
		_req2_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				html = _response.substring((int)(_response.indexOf("<body>")), (int)(_response.indexOf("</video>")));
				Document doc = Jsoup.parse(html);
				_telegramLoaderDialog(false);
				((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", doc.getElementsByTag("source").attr("src")));
				SketchwareUtil.showMessage(getApplicationContext(), "تم نسخ رابط الفيلم");
				/*
html = _response.substring((int)(_response.indexOf("<body>")), (int)(_response.indexOf("</video>")));
Document doc = Jsoup.parse(html);
i.setClass(getApplicationContext(), MainActivity.class);
i.putExtra("txt", nam);
i.putExtra("url", doc.getElementsByTag("source").attr("src"));
((ClipboardManager) getSystemService(getApplicationContext().CLIPBOARD_SERVICE)).setPrimaryClip(ClipData.newPlainText("clipboard", doc.getElementsByTag("source").attr("src")));
i.putExtra("user_agent", "MTX_TV");
i.putExtra("referer", "MTX_TV");
i.putExtra("type", "Entertainment");
startActivity(i);
_telegramLoaderDialog(false);
*/
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
	}
	
	private void initializeLogic() {
		PageLimit = 1;
		vscroll1.setVisibility(View.VISIBLE);
		vscroll2.setVisibility(View.GONE);
		vscroll3.setVisibility(View.GONE);
		gred.setVisibility(View.GONE);
		linear9.setVisibility(View.GONE);
		gridview1.setSelector(android.R.color.transparent);
		xx = 0;
		eng = "ENG";
		/*
PageLimit = 1;
vscroll1.setVisibility(View.VISIBLE);
vscroll2.setVisibility(View.GONE);
vscroll3.setVisibility(View.GONE);
gred.setVisibility(View.GONE);
linear9.setVisibility(View.GONE);
gridview1.setSelector(android.R.color.transparent);
xx = 0;
eng = "ENG";
*/
	}
	
	@Override
	public void onBackPressed() {
		if (eng.equals("ENG")) {
				
				startActivity(i);
				overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
		}
		else {
				if (eng.equals("H")) {
						PageLimit = 1;
						gred.setVisibility(View.GONE);
						vscroll1.setVisibility(View.VISIBLE);
						vscroll2.setVisibility(View.GONE);
						vscroll3.setVisibility(View.GONE);
						imgbbbb.clear();
						mapNames.clear();
						linkkk.clear();
						we.clear();
						eng = "ENG";
				}
				else {
						if (eng.equals("M")) {
								gred.setVisibility(View.GONE);
								vscroll1.setVisibility(View.GONE);
								vscroll2.setVisibility(View.VISIBLE);
								vscroll3.setVisibility(View.GONE);
								imgbbbb.clear();
								mapNames.clear();
								linkkk.clear();
								we.clear();
								eng = "H";
						}
						else {
								if (eng.equals("S")) {
										gred.setVisibility(View.GONE);
										vscroll1.setVisibility(View.GONE);
										vscroll2.setVisibility(View.GONE);
										vscroll3.setVisibility(View.VISIBLE);
										imgbbbb.clear();
										mapNames.clear();
										linkkk.clear();
										we.clear();
										eng = "H";
								}
						}
				}
		}
		/*
if (eng.equals("ENG")) {

startActivity(i);
overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
}
else {
if (eng.equals("H")) {
PageLimit = 1;
gred.setVisibility(View.GONE);
vscroll1.setVisibility(View.VISIBLE);
vscroll2.setVisibility(View.GONE);
vscroll3.setVisibility(View.GONE);
imgbbbb.clear();
mapNames.clear();
linkkk.clear();
we.clear();
eng = "ENG";
}
else {
if (eng.equals("M")) {
gred.setVisibility(View.GONE);
vscroll1.setVisibility(View.GONE);
vscroll2.setVisibility(View.VISIBLE);
vscroll3.setVisibility(View.GONE);
imgbbbb.clear();
mapNames.clear();
linkkk.clear();
we.clear();
eng = "H";
}
else {
if (eng.equals("S")) {
gred.setVisibility(View.GONE);
vscroll1.setVisibility(View.GONE);
vscroll2.setVisibility(View.GONE);
vscroll3.setVisibility(View.VISIBLE);
imgbbbb.clear();
mapNames.clear();
linkkk.clear();
we.clear();
eng = "H";
}
}
}
}
*/
	}
	
	public void _GetSource(final String _Source, final double _type, final String _StartingKey, final String _EndingKey) {
		NewSource = _Source;
		pos2 = _Source.indexOf(_StartingKey);
		pos1 = pos2 + _StartingKey.length();
		pos = pos1;
		for(int _repeat10 = 0; _repeat10 < (int)(_Source.length()); _repeat10++) {
				if (_Source.substring((int)(pos1), (int)(pos + 1)).contains(_EndingKey)) {
						if (_type == 1) {
								
						}
						else {
								st = "<div class=\"Thumb--GridItem\"><a href=\"".concat(_Source.substring((int)(pos1), (int)(pos)).concat(">").replace(" مترجم", "").replace("مشاهدة فيلم ", "")).replace("BG--GridItem\" data-lazy-style=\"--image:url(", "").replace(");", "");
								html = st;
								Document doc = Jsoup.parse(html);
								name = doc.getElementsByTag("a").attr("title");
								img = doc.getElementsByTag("span").attr("class");
								alt = doc.getElementsByTag("a").attr("href");
								{
										HashMap<String, Object> _item = new HashMap<>();
										_item.put("name", img);
										mapNames.add(_item);
								}
								
								imgbbbb.add(name);
								linkkk.add(alt);
						}
						NewSource = NewSource.substring((int)(0), (int)(pos)).replace(NewSource.substring((int)(pos2), (int)(pos)), "").concat(NewSource.substring((int)(pos), (int)(NewSource.length())));
						if (NewSource.contains(_StartingKey)) {
								_GetSource(NewSource, _type, _StartingKey, _EndingKey);
						}
						else {
								if (_type == 0) {
										gridview1.setAdapter(new Gridview1Adapter(mapNames));
								}
						}
						break;
				}
				pos++;
		}
		/*
NewSource = _Source;
pos2 = _Source.indexOf(_StartingKey);
pos1 = pos2 + _StartingKey.length();
pos = pos1;
for(int _repeat10 = 0; _repeat10 < (int)(_Source.length()); _repeat10++) {
if (_Source.substring((int)(pos1), (int)(pos + 1)).contains(_EndingKey)) {
if (_type == 1) {

}
else {
st = "<div class=\"Thumb--GridItem\"><a href=\"".concat(_Source.substring((int)(pos1), (int)(pos)).concat(">").replace(" مترجم", "").replace("مشاهدة فيلم ", "")).replace("BG--GridItem\" data-lazy-style=\"--image:url(", "").replace(");", "");
html = st;
Document doc = Jsoup.parse(html);
name = doc.getElementsByTag("a").attr("title");
img = doc.getElementsByTag("span").attr("class");
alt = doc.getElementsByTag("a").attr("href");
{
HashMap<String, Object> _item = new HashMap<>();
_item.put("name", img);
mapNames.add(_item);
}

imgbbbb.add(name);
linkkk.add(alt);
}
NewSource = NewSource.substring((int)(0), (int)(pos)).replace(NewSource.substring((int)(pos2), (int)(pos)), "").concat(NewSource.substring((int)(pos), (int)(NewSource.length())));
if (NewSource.contains(_StartingKey)) {
_GetSource(NewSource, _type, _StartingKey, _EndingKey);
}
else {
if (_type == 0) {
gridview1.setAdapter(new Gridview1Adapter(mapNames));
}
}
break;
}
pos++;
}
*/
	}
	
	
	public void _DialogShow(final boolean _statu) {
		imgbbbb.clear();
		mapNames.clear();
		linkkk.clear();
		req.startRequestNetwork(RequestNetworkController.GET, string.concat("/page/").concat(String.valueOf((long)(PageLimit)).concat("/")), "", _req_request_listener);
		final AlertDialog dialog1 = new AlertDialog.Builder(AflamActivity.this).create();
		View inflate = getLayoutInflater().inflate(R.layout.load,null); 
		dialog1.getWindow().setBackgroundDrawableResource(android.R.color.transparent);
		dialog1.setView(inflate);
		
		ww = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						if (!statusLoad) {
							ww.cancel();
							dialog1.dismiss();
						}
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(ww, (int)(10), (int)(5));
		dialog1.setCancelable(false);
		dialog1.show();
		textview1.setText(String.valueOf((long)(PageLimit)));
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
				_view = _inflater.inflate(R.layout.aflamm, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final ImageView avatar = _view.findViewById(R.id.avatar);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			
			linear1.setElevation((float)10);
			android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
			gd.setColor(Color.parseColor("#ffffff"));
			gd.setStroke(5, Color.parseColor("#ffffff"));
			gd.setCornerRadius(10);
			linear1.setBackground(gd);
			textview1.setEllipsize(TextUtils.TruncateAt.MARQUEE);
			textview1.setMarqueeRepeatLimit(-1);
			textview1.setSingleLine(true);
			textview1.setSelected(true);
			Glide.with(getApplicationContext()).load(Uri.parse(mapNames.get((int)_position).get("name").toString())).into(avatar);
			textview1.setText(imgbbbb.get((int)(_position)));
			if (settings.getString("theme", "").equals("Light")) {
				textview1.setTextColor(0xFF000000);
				linear1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)10, 0xFFFFFFFF));
			}
			else {
				textview1.setTextColor(0xFFFFFFFF);
				linear1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)10, 0xFF000000));
			}
			linear1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					_telegramLoaderDialog(true);
					nam = imgbbbb.get((int)(_position));
					req1.startRequestNetwork(RequestNetworkController.GET, linkkk.get((int)(_position)), "", _req1_request_listener);
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