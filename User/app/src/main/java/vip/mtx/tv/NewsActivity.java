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
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.ProgressBar;
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

public class NewsActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private String NewSource = "";
	private double pos2 = 0;
	private double pos1 = 0;
	private double pos = 0;
	private String html = "";
	private double page = 0;
	private String match = "";
	
	private ArrayList<HashMap<String, Object>> list_data = new ArrayList<>();
	private ArrayList<String> name = new ArrayList<>();
	private ArrayList<String> key1 = new ArrayList<>();
	
	private LinearLayout linear1;
	private LinearLayout linear5;
	private LinearLayout linear7;
	private LinearLayout linear6;
	private ImageView imageview1;
	private TextView textview1;
	private ProgressBar progressbar1;
	private ListView listview1;
	private LinearLayout linear69;
	private Button button1;
	private TextView textview2;
	private Button button2;
	
	private RequestNetwork req;
	private RequestNetwork.RequestListener _req_request_listener;
	private SharedPreferences settings;
	private Intent i = new Intent();
	private TimerTask entimer;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.news);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		linear5 = findViewById(R.id.linear5);
		linear7 = findViewById(R.id.linear7);
		linear6 = findViewById(R.id.linear6);
		imageview1 = findViewById(R.id.imageview1);
		textview1 = findViewById(R.id.textview1);
		progressbar1 = findViewById(R.id.progressbar1);
		listview1 = findViewById(R.id.listview1);
		linear69 = findViewById(R.id.linear69);
		button1 = findViewById(R.id.button1);
		textview2 = findViewById(R.id.textview2);
		button2 = findViewById(R.id.button2);
		req = new RequestNetwork(this);
		settings = getSharedPreferences("settings", Activity.MODE_PRIVATE);
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), CategoryActivity.class);
				startActivity(i);
				overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
			}
		});
		
		button1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (page == 1) {
					if (settings.getString("language", "").equals("AR")) {
						SketchwareUtil.showMessage(getApplicationContext(), "انت ف اول صفحة");
					}
					else {
						SketchwareUtil.showMessage(getApplicationContext(), "You are now on the first page");
					}
				}
				else {
					page--;
					req.startRequestNetwork(RequestNetworkController.GET, "https://www.yalla-sport.com/yalla-sport/page/".concat(String.valueOf((long)(page)).concat("?s=%D8%A7&__cf_chl_tk=MsvT_.0sBEKf3PQE7beILiSRkP0SsFNedWCIFCbK9q0-1690278121-0-gaNycGzNC1A")), "", _req_request_listener);
					textview2.setText(String.valueOf((long)(page)));
					list_data.clear();
					name.clear();
					key1.clear();
				}
			}
		});
		
		button2.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				page++;
				req.startRequestNetwork(RequestNetworkController.GET, "https://www.yalla-sport.com/yalla-sport/page/".concat(String.valueOf((long)(page)).concat("?s=%D8%A7&__cf_chl_tk=MsvT_.0sBEKf3PQE7beILiSRkP0SsFNedWCIFCbK9q0-1690278121-0-gaNycGzNC1A")), "", _req_request_listener);
				textview2.setText(String.valueOf((long)(page)));
				list_data.clear();
				name.clear();
				key1.clear();
			}
		});
		
		_req_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				match = _response.substring((int)(_response.indexOf("<div class=\"post-listing \">")), (int)(_response.indexOf("<div class=\"pagination\">")));
				_GetSource(match, 0, "<div class=\"post-thumbnail\">", "</a>");
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
	}
	
	private void initializeLogic() {
		_Setting();
		req.startRequestNetwork(RequestNetworkController.GET, "https://www.yalla-sport.com/yalla-sport/page/1?s=%D8%A7&__cf_chl_tk=MsvT_.0sBEKf3PQE7beILiSRkP0SsFNedWCIFCbK9q0-1690278121-0-gaNycGzNC1A", "", _req_request_listener);
		page = 1;
		textview2.setText(String.valueOf((long)(page)));
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 1);
		button1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
		button2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
		listview1.setSelector(android.R.color.transparent);
	}
	
	
	@Override
	public void onBackPressed() {
		i.setClass(getApplicationContext(), CategoryActivity.class);
		startActivity(i);
		overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
	}
	public void _GetSource(final String _Source, final double _type, final String _StartingKey, final String _EndingKey) {
		NewSource = _Source;
		pos2 = _Source.indexOf(_StartingKey);
		pos1 = pos2 + _StartingKey.length();
		pos = pos1;
		for(int _repeat1239 = 0; _repeat1239 < (int)(_Source.length()); _repeat1239++) {
			if (_Source.substring((int)(pos1), (int)(pos + 1)).contains(_EndingKey)) {
				if (_type == 0) {
					html = _Source.substring((int)(pos1), (int)(pos));
					Document doc = Jsoup.parse(html);
					{
						HashMap<String, Object> _item = new HashMap<>();
						_item.put("url", doc.getElementsByTag("a").attr("href"));
						list_data.add(_item);
					}
					
					name.add(doc.getElementsByTag("a").attr("title").replace("رابط ثابت لـ ", ""));
					key1.add(doc.getElementsByTag("img").attr("src"));
				}
				NewSource = NewSource.substring((int)(0), (int)(pos)).replace(NewSource.substring((int)(pos2), (int)(pos)), "").concat(NewSource.substring((int)(pos), (int)(NewSource.length())));
				if (NewSource.contains(_StartingKey)) {
					_GetSource(NewSource, _type, _StartingKey, _EndingKey);
				}
				else {
					listview1.setAdapter(new Listview1Adapter(list_data));
					((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
					progressbar1.setVisibility(View.GONE);
				}
				break;
			}
			pos++;
		}
	}
	
	
	public void _AddCardView(final View _Linear, final double _Margin, final double _Radius, final double _Elevation, final double _MaxElevation, final boolean _CornerOverlap, final String _BgColor) {
		// This MoreBlock Created By SHAKIB 36x
		androidx.cardview.widget.CardView Ds = new androidx.cardview.widget.CardView(this);
		LinearLayout.LayoutParams Sa = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
		int Mg = (int)_Margin;
		Sa.setMargins(Mg,0,0,0);
		Ds.setLayoutParams(Sa);
		int Clr = Color.parseColor(_BgColor);
		Ds.setCardBackgroundColor(Clr);
		Ds.setRadius((float)_Radius);
		Ds.setCardElevation((float)_Elevation);
		Ds.setMaxCardElevation((float)_MaxElevation);
		Ds.setPreventCornerOverlap(_CornerOverlap);
		if(_Linear.getParent() instanceof LinearLayout){
			ViewGroup Bg = ((ViewGroup)_Linear.getParent());
			Bg.removeView(_Linear);
			Bg.addView(Ds);
			Ds.addView(_Linear);
		}else{
		}
		// Dont Remove Creator Credit
	}
	
	
	public void _Setting() {
		if (settings.getString("theme", "").equals("Light")) {
			linear7.setBackgroundColor(0xFFE0E0E0);
			button1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)10, 0xFF80CBC4));
			button2.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)10, 0xFF80DEEA));
		}
		else {
			linear7.setBackgroundColor(0xFF303030);
			textview2.setTextColor(0xFFFFFFFF);
			button1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)10, 0xFF000000));
			button2.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)10, 0xFF000000));
			button1.setTextColor(0xFFFFFFFF);
			button2.setTextColor(0xFFFFFFFF);
		}
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
		if (settings.getString("language", "").equals("AR")) {
			
		}
		else {
			textview1.setText("NEWS");
			button1.setText("Previous");
			button2.setText("Next");
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
				_view = _inflater.inflate(R.layout.newss, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			
			Glide.with(getApplicationContext()).load(Uri.parse(key1.get((int)(_position)))).into(imageview1);
			textview1.setText(name.get((int)(_position)));
			linear1.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
					i.setClass(getApplicationContext(), ViewnewsActivity.class);
					i.putExtra("name", name.get((int)(_position)));
					i.putExtra("url", list_data.get((int)_position).get("url").toString().replace("/?p=", "/news/"));
					i.putExtra("img", key1.get((int)(_position)));
					startActivity(i);
				}
			});
			_AddCardView(linear3, 0, 30, 5, 5, true, "#ffffff");
			textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
			if (settings.getString("theme", "").equals("Light")) {
				linear1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)10, 0xFFFFFFFF));
				textview1.setTextColor(0xFF000000);
			}
			else {
				linear1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)10, 0xFF000000));
				textview1.setTextColor(0xFFFFFFFF);
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