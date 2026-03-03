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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
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

public class Freq11Activity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private String NewSource = "";
	private double pos2 = 0;
	private double pos1 = 0;
	private double pos = 0;
	private String html = "";
	private String match = "";
	private double group = 0;
	
	private ArrayList<String> key6 = new ArrayList<>();
	private ArrayList<String> key5 = new ArrayList<>();
	private ArrayList<String> key4 = new ArrayList<>();
	private ArrayList<String> key3 = new ArrayList<>();
	private ArrayList<String> key2 = new ArrayList<>();
	private ArrayList<String> key1 = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> list_data = new ArrayList<>();
	private ArrayList<String> name = new ArrayList<>();
	private ArrayList<String> key7 = new ArrayList<>();
	
	private LinearLayout linear;
	private LinearLayout linear5;
	private LinearLayout linear7;
	private LinearLayout linear6;
	private ImageView imageview1;
	private TextView textview8;
	private LinearLayout linear1;
	private ListView listview1;
	private LinearLayout linear8;
	private LinearLayout linear3;
	private LinearLayout linear2;
	private TextView textview7;
	private TextView textview9;
	private TextView textview6;
	private TextView textview5;
	private TextView textview4;
	private TextView textview3;
	private TextView textview2;
	private TextView textview1;
	private ImageView imageview2;
	private TextView textview10;
	
	private RequestNetwork req;
	private RequestNetwork.RequestListener _req_request_listener;
	private Intent i = new Intent();
	private SharedPreferences settings;
	private TimerTask entimer;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.freq11);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear = findViewById(R.id.linear);
		linear5 = findViewById(R.id.linear5);
		linear7 = findViewById(R.id.linear7);
		linear6 = findViewById(R.id.linear6);
		imageview1 = findViewById(R.id.imageview1);
		textview8 = findViewById(R.id.textview8);
		linear1 = findViewById(R.id.linear1);
		listview1 = findViewById(R.id.listview1);
		linear8 = findViewById(R.id.linear8);
		linear3 = findViewById(R.id.linear3);
		linear2 = findViewById(R.id.linear2);
		textview7 = findViewById(R.id.textview7);
		textview9 = findViewById(R.id.textview9);
		textview6 = findViewById(R.id.textview6);
		textview5 = findViewById(R.id.textview5);
		textview4 = findViewById(R.id.textview4);
		textview3 = findViewById(R.id.textview3);
		textview2 = findViewById(R.id.textview2);
		textview1 = findViewById(R.id.textview1);
		imageview2 = findViewById(R.id.imageview2);
		textview10 = findViewById(R.id.textview10);
		req = new RequestNetwork(this);
		settings = getSharedPreferences("settings", Activity.MODE_PRIVATE);
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setClass(getApplicationContext(), ChampionshipActivity.class);
				startActivity(i);
				overridePendingTransition(android.R.anim.fade_in, android.R.anim.fade_out);
			}
		});
		
		_req_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				if (!_response.contains("مجموعة")) {
					linear8.setVisibility(View.VISIBLE);
				}
				else {
					match = _response.substring((int)(_response.indexOf("<div id=\"groups_cover\">")), (int)(_response.indexOf("</table></div></div>")));
					_GetSource(match, 7, "<td class=\"rank\">", "</td>");
					_GetSource(match, 6, "<td class=\"goal-plus-minus\">", "</td>");
					_GetSource(match, 5, "<td class=\"pts\">", "</td>");
					_GetSource(match, 4, "<td class=\"lost\">", "</td>");
					_GetSource(match, 3, "<td class=\"draw\">", "</td>");
					_GetSource(match, 2, "<td class=\"won\">", "</td>");
					_GetSource(match, 1, "<td class=\"pld\">", "</td>");
					_GetSource(match, 0, "<td class=\"team team_logo\">", "</td>");
				}
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				SketchwareUtil.showMessage(getApplicationContext(), "راجع اتصالك بالشبكة");
			}
		};
	}
	
	private void initializeLogic() {
		_Setting();
		textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 1);
		textview2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 1);
		textview3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 1);
		textview4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 1);
		textview5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 1);
		textview6.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 1);
		textview7.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 1);
		textview8.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 1);
		textview9.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 1);
		textview10.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 1);
		linear1.setVisibility(View.GONE);
		req.startRequestNetwork(RequestNetworkController.GET, getIntent().getStringExtra("reqq"), "", _req_request_listener);
		textview8.setText("ترتيب ".concat(getIntent().getStringExtra("namee")));
		linear8.setVisibility(View.GONE);
		listview1.setSelector(android.R.color.transparent);
	}
	
	
	@Override
	public void onBackPressed() {
		i.setClass(getApplicationContext(), ChampionshipActivity.class);
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
				if (_type == 7) {
					key7.add(_Source.substring((int)(pos1), (int)(pos)).replace("span", "").replace(" ", "").replace("class=\"goal-minus\"", "").replace("class=\"goal-plus\"", "").replace("/", "").replace("<", "").replace(">", "").replace("td", ""));
				}
				else {
					if (_type == 6) {
						key6.add(_Source.substring((int)(pos1), (int)(pos)).replace("span", "").replace(" ", "").replace("class=\"goal-minus\"", "").replace("class=\"goal-plus\"", "").replace("/", "").replace("<", "").replace(">", "").replace("td", ""));
					}
					else {
						if (_type == 5) {
							key5.add(_Source.substring((int)(pos1), (int)(pos)).replace("/", "").replace("<", "").replace(">", "").replace("td", ""));
						}
						else {
							if (_type == 4) {
								key4.add(_Source.substring((int)(pos1), (int)(pos)).replace("/", "").replace("<", "").replace(">", "").replace("td", ""));
							}
							else {
								if (_type == 3) {
									key3.add(_Source.substring((int)(pos1), (int)(pos)).replace("/", "").replace("<", "").replace(">", "").replace("td", ""));
								}
								else {
									if (_type == 2) {
										key2.add(_Source.substring((int)(pos1), (int)(pos)).replace("/", "").replace("<", "").replace(">", "").replace("td", ""));
									}
									else {
										if (_type == 1) {
											key1.add(_Source.substring((int)(pos1), (int)(pos)).replace("/", "").replace("<", "").replace(">", "").replace("td", ""));
										}
										else {
											html = _Source.substring((int)(pos1), (int)(pos));
											Document doc = Jsoup.parse(html);
											{
												HashMap<String, Object> _item = new HashMap<>();
												_item.put("img", doc.getElementsByTag("img").attr("src"));
												list_data.add(_item);
											}
											
											name.add(doc.getElementsByTag("img").attr("alt").replace("شعار ", ""));
										}
									}
								}
							}
						}
					}
				}
				NewSource = NewSource.substring((int)(0), (int)(pos)).replace(NewSource.substring((int)(pos2), (int)(pos)), "").concat(NewSource.substring((int)(pos), (int)(NewSource.length())));
				if (NewSource.contains(_StartingKey)) {
					_GetSource(NewSource, _type, _StartingKey, _EndingKey);
				}
				else {
					if (_type == 0) {
						listview1.setAdapter(new Listview1Adapter(list_data));
						linear1.setVisibility(View.VISIBLE);
						((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
						group = 1;
					}
				}
				break;
			}
			pos++;
		}
	}
	
	
	public void _style_2(final View _view, final double _r, final double _shadow, final double _str, final String _str_color, final String _color) {
		android.graphics.drawable.GradientDrawable gd = new android.graphics.drawable.GradientDrawable();
		gd.setColor(Color.parseColor(_color));
		gd.setCornerRadius((int)_r);
		gd.setStroke((int)_str,Color.parseColor(_str_color));
		_view.setBackground(gd);
		_view.setElevation((int)_shadow);
	}
	
	
	public void _Setting() {
		if (settings.getString("theme", "").equals("Light")) {
			linear7.setBackgroundColor(0xFFE0E0E0);
		}
		else {
			linear7.setBackgroundColor(0xFF303030);
			textview10.setTextColor(0xFFFFFFFF);
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
			textview2.setText("Team");
			textview3.setText("P");
			textview4.setText("W");
			textview5.setText("D");
			textview6.setText("L");
			textview7.setText("Point");
			textview7.setTextSize((int)12);
			textview10.setText("Sorry, Groups Are Not Defined Yet");
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
				_view = _inflater.inflate(R.layout.freq, null);
			}
			
			final LinearLayout linear7 = _view.findViewById(R.id.linear7);
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final LinearLayout linear5 = _view.findViewById(R.id.linear5);
			final TextView text = _view.findViewById(R.id.text);
			final LinearLayout linear6 = _view.findViewById(R.id.linear6);
			final LinearLayout linear3 = _view.findViewById(R.id.linear3);
			final LinearLayout linear2 = _view.findViewById(R.id.linear2);
			final LinearLayout linear4 = _view.findViewById(R.id.linear4);
			final TextView textview7 = _view.findViewById(R.id.textview7);
			final TextView textview8 = _view.findViewById(R.id.textview8);
			final TextView textview6 = _view.findViewById(R.id.textview6);
			final TextView textview5 = _view.findViewById(R.id.textview5);
			final TextView textview4 = _view.findViewById(R.id.textview4);
			final TextView textview3 = _view.findViewById(R.id.textview3);
			final TextView textview2 = _view.findViewById(R.id.textview2);
			final ImageView imageview1 = _view.findViewById(R.id.imageview1);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			
			textview2.setEllipsize(TextUtils.TruncateAt.MARQUEE);
			textview2.setMarqueeRepeatLimit(-1);
			textview2.setSingleLine(true);
			textview2.setSelected(true);
			textview1.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 1);
			textview2.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 0);
			textview3.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 1);
			textview4.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 1);
			textview5.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 1);
			textview6.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 1);
			textview7.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 1);
			textview8.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 1);
			linear7.setVisibility(View.GONE);
			textview1.setText(key7.get((int)(_position)));
			Glide.with(getApplicationContext()).load(Uri.parse(list_data.get((int)_position).get("img").toString())).into(imageview1);
			textview2.setText(name.get((int)(_position)));
			textview3.setText(key1.get((int)(_position)));
			textview4.setText(key2.get((int)(_position)));
			textview5.setText(key3.get((int)(_position)));
			textview6.setText(key4.get((int)(_position)));
			textview7.setText(key5.get((int)(_position)));
			textview8.setText(key6.get((int)(_position)));
			if (settings.getString("theme", "").equals("Light")) {
				if ((_position % 2) == 0) {
					linear1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)0, 0xFFEEEEEE));
				}
				else {
					linear1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)0, 0xFFE0E0E0));
				}
			}
			else {
				text.setTextColor(0xFFFFFFFF);
				textview1.setTextColor(0xFFFFFFFF);
				textview2.setTextColor(0xFFFFFFFF);
				textview3.setTextColor(0xFFFFFFFF);
				textview4.setTextColor(0xFFFFFFFF);
				textview5.setTextColor(0xFFFFFFFF);
				textview6.setTextColor(0xFFFFFFFF);
				textview8.setTextColor(0xFFFFFFFF);
				textview7.setTextColor(0xFFFFFFFF);
				linear5.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)0, 0xFF000000));
				if ((_position % 2) == 0) {
					linear1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)0, 0xFF424242));
				}
				else {
					linear1.setBackground(new GradientDrawable() { public GradientDrawable getIns(int a, int b) { this.setCornerRadius(a); this.setColor(b); return this; } }.getIns((int)0, 0xFF212121));
				}
			}
			if (settings.getString("language", "").equals("AR")) {
				if ((_position % 4) == 0) {
					linear7.setVisibility(View.VISIBLE);
					text.setText("المجموعة ".concat(String.valueOf((long)(group)).replace("1", "A").replace("2", "B").replace("3", "D").replace("4", "E").replace("5", "F").replace("6", "G").replace("7", "H").replace("8", "K").replace("9", "L").replace("0", "")).replace(".", ""));
					text.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 1);
					group++;
				}
			}
			else {
				if ((_position % 4) == 0) {
					linear7.setVisibility(View.VISIBLE);
					text.setText("Group ".concat(String.valueOf((long)(group)).replace("1", "A").replace("2", "B").replace("3", "D").replace("4", "E").replace("5", "F").replace("6", "G").replace("7", "H").replace("8", "K").replace("9", "L").replace("0", "")).replace(".", ""));
					text.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 1);
					group++;
				}
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