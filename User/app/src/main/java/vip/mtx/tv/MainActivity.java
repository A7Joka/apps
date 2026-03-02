package vip.mtx.tv;

import vip.mtx.tv.AflamActivity;
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
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.ArrayAdapter;
import android.widget.BaseAdapter;
import android.widget.ListView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
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
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection.Factory;
import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.Player.EventListener;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import java.io.File;
import android.net.Uri;

public class MainActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private  SimpleExoPlayer player;
	private  MediaSource mediaSource;
	private boolean loading = false;
	private String link = "";
	private double playbackState = 0;
	private double position = 0;
	private  PlaybackParams param;
	private boolean orien = false;
	private String refererHeader = "";
	private String userAgentHeader = "";
	private double zoom = 0;
	private String title = "";
	private boolean zomm = false;
	private String name = "";
	private double pos = 0;
	private double pos1 = 0;
	private String NewSource = "";
	private String url = "";
	
	private ArrayList<Double> zoom1 = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> quality = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> links = new ArrayList<>();
	
	private PlayerView player_view;
	private ListView listview1;
	
	private TimerTask check;
	private Intent i = new Intent();
	private RequestNetwork req;
	private RequestNetwork.RequestListener _req_request_listener;
	private TimerTask t;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		player_view = findViewById(R.id.player_view);
		listview1 = findViewById(R.id.listview1);
		req = new RequestNetwork(this);
		
		_req_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				Matcher a = Pattern.compile("\\W.*.m3u8").matcher(_response);
				while (a.find()) {
						{
						HashMap<String, Object> _item = new HashMap<>();
						_item.put("links", a.group());
						links.add(_item);
						}	
				}
				if (_response.contains(",NAME=\"")) {
					_Get_Quality(_response, 0, "RESOLUTION=", "\n");
					_Get_Quality(_response, 0, "QUALITY=", "\n");
				}
				else {
					if (_response.contains("#EXT-X-STREAM-INF:BANDWIDTH")) {
						if (_response.contains("#EXT-X-INDEPENDENT-SEGMENTS")) {
							_Get_Quality(_response, 0, "RESOLUTION=", ",");
							_Get_Quality(_response, 0, "QUALITY=", ",");
						}
						else {
							if (_response.contains("CLOSED-CAPTIONS=NONE")) {
								_Get_Quality(_response, 0, "RESOLUTION=", ",");
								_Get_Quality(_response, 0, "QUALITY=", ",");
							}
							else {
								_Get_Quality(_response, 0, "RESOLUTION=", "\n");
								_Get_Quality(_response, 0, "QUALITY=", "\n");
							}
						}
					}
					else {
						if (_response.contains("#EXT-X-STREAM-INF:PROGRAM-ID")) {
							_Get_Quality(_response, 0, "RESOLUTION=", "\n");
							_Get_Quality(_response, 0, "QUALITY=", "\n");
						}
						else {
							_Get_Quality(_response, 0, "RESOLUTION=", ",");
							_Get_Quality(_response, 0, "QUALITY=", ",");
						}
					}
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
		getWindow().getDecorView().setSystemUiVisibility( View.SYSTEM_UI_FLAG_HIDE_NAVIGATION| View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY);
		SystemClock.sleep(400);
		loading = true;
		refererHeader = getIntent().getStringExtra("referer");
		userAgentHeader = getIntent().getStringExtra("user_agent");
		link = getIntent().getStringExtra("url");
		title = getIntent().getStringExtra("txt");
		name = getIntent().getStringExtra("type");
		if (!link.contains(".m3u8")) {
					
					player = ExoPlayerFactory.newSimpleInstance(this, new DefaultTrackSelector(new Factory(new DefaultBandwidthMeter())), new DefaultLoadControl());
					
					String Url_Player = link;
					Uri videoUrl = Uri.parse(Url_Player);
					mediaSource = new ExtractorMediaSource(videoUrl, new DefaultHttpDataSourceFactory("exoplayer_video"), new DefaultExtractorsFactory(), null, null);
					_HLS();
					
					player_view.setPlayer(player);
					
					player_view.setKeepScreenOn(true);
					
					player.prepare(mediaSource);
					_Events();
					
					player.setPlayWhenReady(true);
		}
		else {
					
					DefaultHttpDataSourceFactory dataSourceFactory = new DefaultHttpDataSourceFactory(userAgentHeader);
					
					dataSourceFactory.getDefaultRequestProperties().set("Referer", refererHeader);
					
					player = ExoPlayerFactory.newSimpleInstance(this, new DefaultTrackSelector(new Factory(new DefaultBandwidthMeter())), new DefaultLoadControl());
					
					String HLS_URL = link;
					Uri uri = Uri.parse(HLS_URL); 
					MediaSource mediaSource = new HlsMediaSource.Factory(dataSourceFactory).createMediaSource(uri);
					
					_HLS();
					
					player_view.setPlayer(player);
					
					player_view.setKeepScreenOn(true);
					
					player.prepare(mediaSource);
					_Events();
					
					player.setPlayWhenReady(true);
		}
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN);
		
		        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
				            getWindow().getAttributes().layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
				        }
		        
		if (Build.VERSION.SDK_INT >= 19 && Build.VERSION.SDK_INT < 21) {
						    setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
						            | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, true);
		}
		if (Build.VERSION.SDK_INT >= 19) {
						    getWindow().getDecorView().setSystemUiVisibility(
						            View.SYSTEM_UI_FLAG_LAYOUT_STABLE
						                    | View.SYSTEM_UI_FLAG_LAYOUT_FULLSCREEN
						                    | View.SYSTEM_UI_FLAG_LAYOUT_HIDE_NAVIGATION
						    );
		}
		if (Build.VERSION.SDK_INT >= 21) {
						    setWindowFlag(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS
						            | WindowManager.LayoutParams.FLAG_TRANSLUCENT_NAVIGATION, false);
						    getWindow().setStatusBarColor(Color.TRANSPARENT);
						    getWindow().setNavigationBarColor(Color.TRANSPARENT);
		}
	}
	private void setWindowFlag(final int bits, boolean on) {
			    Window win = getWindow();
			    WindowManager.LayoutParams winParams = win.getAttributes();
			    if (on) {
							        winParams.flags |= bits;
							    } else {
							        winParams.flags &= ~bits;
							    }
			    win.setAttributes(winParams);
	}
	{
		t = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						req.startRequestNetwork(RequestNetworkController.GET, link, "", _req_request_listener);
						listview1.setVisibility(View.GONE);
					}
				});
			}
		};
		_timer.schedule(t, (int)(10));
	}
	
	
	@Override
	public void onPause() {
		super.onPause();
		if (player != null) {
				player.setPlayWhenReady(false);
				player.getPlaybackState();
		}
	}
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		if (player != null) {
				player_view.setPlayer(null);
				player.release();
				player = null;
		}
	}
	public void _HLS() {
		
	}
	private MediaSource buildMediaSource(Uri uri) {
		    DataSource.Factory dataSourceFactory = new DefaultDataSourceFactory(this, "exoplayer-codelab");
		    return new HlsMediaSource.Factory(dataSourceFactory).createMediaSource(uri);
	}
	{
	}
	
	
	public void _Extra() {
	}
	protected void onRestart() {
		        super.onRestart();
		        if (player != null) {
			            
			player.setPlayWhenReady(true);
			player.getPlaybackState();
			
			        }
		    }
	{
	}
	
	
	public void _Events() {
		
		final ProgressBar prg = (ProgressBar)player_view.findViewById(R.id.progress);
		
		final ImageView play1 = (ImageView)player_view.findViewById(R.id.exo_play);
		
		final ImageView pause1 = (ImageView)player_view.findViewById(R.id.exo_pause);
		
		final ImageView costt = (ImageView)player_view.findViewById(R.id.cost);
		
		final ImageView castt = (ImageView)player_view.findViewById(R.id.cast);
		
		final ImageView zoomm = (ImageView)player_view.findViewById(R.id.zoom);
		
		final ImageView stgs = (ImageView)player_view.findViewById(R.id.imageview1);
		
		final ImageView down = (ImageView)player_view.findViewById(R.id.imageview2);
		
		final ImageView hqhq = (ImageView)player_view.findViewById(R.id.imageview3);
		
		final TextView exo_duration = (TextView)player_view.findViewById(R.id.exo_duration);
		
		final TextView exo_position = (TextView)player_view.findViewById(R.id.exo_position);
		
		final TextView txt = (TextView)player_view.findViewById(R.id.textview1);
		
		final ImageView backk = (ImageView)player_view.findViewById(R.id.back);
		_Progress(prg, "#ff4081");
		txt.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 1);
		exo_duration.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 1);
		exo_position.setTypeface(Typeface.createFromAsset(getAssets(),"fonts/neosansarabic.ttf"), 1);
		player_view.setResizeMode(AspectRatioFrameLayout.RESIZE_MODE_FILL);
		setRequestedOrientation(0);
		
		player.addListener(new EventListener() {
			
			public void onTimelineChanged(Timeline timeline, Object manifest, int reason) {
				 
			}
			
			public void onTracksChanged(TrackGroupArray trackGroups, TrackSelectionArray trackSelections) {
				 loading = false;
				pause1.setVisibility(View.VISIBLE);
				prg.setVisibility(View.GONE);
			}
			
			public void onLoadingChanged(boolean isLoading) {
				 
			}
			
			public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
				if (playbackState == 2) {
					loading = true;
					prg.setVisibility(View.VISIBLE);
				}
				else {
					if (playbackState == 3) {
						loading = false;
						prg.setVisibility(View.GONE);
					}
				}
			}
			public void onRepeatModeChanged(int repeatMode) {
				 
			}
			public void onShuffleModeEnabledChanged(boolean shuffleModeEnabled) {
				 
			}
			public void onPlayerError(ExoPlaybackException error) {
				 
			}
			public void onPositionDiscontinuity(int reason) {
				 
			}
			public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
				 
			}
			public void onSeekProcessed() {
				 
			}
			
			 });
		txt.setText(title);
		check = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						if (loading) {
							pause1.setVisibility(View.GONE);
							play1.setVisibility(View.GONE);
							play1.setAlpha((float)(0));
							pause1.setAlpha((float)(0));
						}
						else {
							play1.setAlpha((float)(1));
							pause1.setAlpha((float)(1));
						}
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(check, (int)(0), (int)(1));
		backk.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				finish();
			}
		});
		zoomm.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				zoom++;
				if (zoom == 1) {
					player_view.setResizeMode(AspectRatioFrameLayout.RESIZE_MODE_ZOOM);
				}
				if (zoom == 2) {
					player_view.setResizeMode(AspectRatioFrameLayout.RESIZE_MODE_FIXED_WIDTH);
				}
				if (zoom == 3) {
					player_view.setResizeMode(AspectRatioFrameLayout.RESIZE_MODE_FIXED_HEIGHT);
				}
				if (zoom == 4) {
					player_view.setResizeMode(AspectRatioFrameLayout.RESIZE_MODE_FILL);
					zoom = 0;
				}
			}
		});
		costt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				Intent intent = new Intent(android.provider.Settings.ACTION_CAST_SETTINGS);
				startActivityForResult(intent, 0);
				
				//Hansdev
			}
		});
		castt.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (orien) {
					orien = false;
					setRequestedOrientation(android.content.pm.ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
				}
				else {
					orien = true;
					setRequestedOrientation(android.content.pm.ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
				}
			}
		});
		stgs.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
				builder.setTitle("Video Speed");
				
				builder.setItems(speed, new DialogInterface.OnClickListener() {
						                    @Override
						                    public void onClick(DialogInterface dialog, int position) {
								
								
						
						if ((position + 1) == 1) {
							
							try {
								PlaybackParams param = new PlaybackParams();
								param.setSpeed(0.25f);
								player.setPlaybackParams(param);
								
								SketchwareUtil.showMessage(getApplicationContext(), "x 0.25");
							} catch(Exception e) {
									 SketchwareUtil.showMessage(getApplicationContext(), "Error");
							}
						}
						else {
							if ((position + 1) == 2) {
								
								try {
									PlaybackParams param = new PlaybackParams();
									param.setSpeed(0.75f);
									player.setPlaybackParams(param);
									
									SketchwareUtil.showMessage(getApplicationContext(), "x 0.75");
								} catch(Exception e) {
										 SketchwareUtil.showMessage(getApplicationContext(), "Error");
								}
							}
							else {
								if ((position + 1) == 3) {
									
									try {
										PlaybackParams param = new PlaybackParams();
										param.setSpeed(1.0f);
										player.setPlaybackParams(param);
										
										SketchwareUtil.showMessage(getApplicationContext(), "Normal");
									} catch(Exception e) {
											 SketchwareUtil.showMessage(getApplicationContext(), "Error");
									}
								}
								else {
									if ((position + 1) == 4) {
										
										try {
											PlaybackParams param = new PlaybackParams();
											param.setSpeed(1.5f);
											player.setPlaybackParams(param);
											
											SketchwareUtil.showMessage(getApplicationContext(), "x 1.5");
										} catch(Exception e) {
												 SketchwareUtil.showMessage(getApplicationContext(), "Error");
										}
									}
									else {
										if ((position + 1) == 5) {
											
											try {
												PlaybackParams param = new PlaybackParams();
												param.setSpeed(2.0f);
												player.setPlaybackParams(param);
												
												SketchwareUtil.showMessage(getApplicationContext(), "x 2.0");
											} catch(Exception e) {
													 SketchwareUtil.showMessage(getApplicationContext(), "Error");
											}
										}
										else {
											
										}
									}
								}
							}
						}
						}
				});
				builder.show();
			}
		});
		if (name.equals("channel")) {
			down.setVisibility(View.GONE);
		}
		else {
			down.setVisibility(View.VISIBLE);
		}
		down.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				i.setAction(Intent.ACTION_VIEW);
				i.setData(Uri.parse(link));
				startActivity(i);
			}
		});
		t = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						if (links.size() > 0) {
							hqhq.setVisibility(View.VISIBLE);
						}
						else {
							hqhq.setVisibility(View.GONE);
						}
					}
				});
			}
		};
		_timer.scheduleAtFixedRate(t, (int)(100), (int)(100));
		hqhq.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				url = link;
				final AlertDialog dialog1 = new AlertDialog.Builder(MainActivity.this).create();View inflate = getLayoutInflater().inflate(R.layout.cus2,null); dialog1.setView(inflate); 
				final ListView listview1 = inflate.findViewById(R.id.listview1);
				TextView textview1 = inflate.findViewById(R.id.textview1);
				listview1.setAdapter(new Listview1Adapter(quality));
				((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
				t = new TimerTask() {
					@Override
					public void run() {
						runOnUiThread(new Runnable() {
							@Override
							public void run() {
								if (link.equals(url)) {
									
								}
								else {
									
									player_view.setResizeMode(AspectRatioFrameLayout.RESIZE_MODE_FILL);
								}
							}
						});
					}
				};
				_timer.scheduleAtFixedRate(t, (int)(10), (int)(10));
				dialog1.show();
			}
		});
	}
	
	
	public void _Progress(final ProgressBar _prgs, final String _color) {
		if
		(android.os.Build.VERSION.SDK_INT >= 21) {
			_prgs.getIndeterminateDrawable().setColorFilter(Color.parseColor(_color),
			PorterDuff.Mode.SRC_IN);
		}
	}
	
	
	public void _speed_types() {
	}
	String[] speed = {"x 0.25","x 0.75","Normal","x 1.5","x 2.0"};
	{
	}
	
	
	public void _Get_Quality(final String _Source, final double _type, final String _StartingKey, final String _EndingKey) {
		try{
			pos = _Source.indexOf(_StartingKey) + _StartingKey.length();
			pos1 = pos;
			for(int _repeat19 = 0; _repeat19 < (int)(_Source.length()); _repeat19++) {
				if (_Source.substring((int)(pos), (int)(pos1 + 1)).contains(_EndingKey)) {
					if (_type == 0) {
						{
							HashMap<String, Object> _item = new HashMap<>();
							_item.put("quality", _Source.substring((int)(pos), (int)(pos1)));
							quality.add(_item);
						}
						
					}
					NewSource = _Source.substring((int)(pos), (int)(_Source.length()));
					if (NewSource.contains(_StartingKey)) {
						_Get_Quality(NewSource, _type, _StartingKey, _EndingKey);
					}
					else {
						if (_type == 0) {
							listview1.setAdapter(new Listview1Adapter(quality));
							((BaseAdapter)listview1.getAdapter()).notifyDataSetChanged();
						}
					}
					break;
				}
				pos1++;
			}
		}catch(Exception e){
			 
		}
	}
	
	
	public void _bt11() {
		finishAffinity();
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
				_view = _inflater.inflate(R.layout.cos, null);
			}
			
			final LinearLayout linear1 = _view.findViewById(R.id.linear1);
			final TextView textview1 = _view.findViewById(R.id.textview1);
			
			try{
				if (quality.get((int)_position).get("quality").toString().contains("#EXT-X-VERSION")) {
					textview1.setText("Auto");
				}
				else {
					if (!quality.get((int)_position).get("quality").toString().contains("x")) {
						textview1.setText("Auto");
					}
					else {
						textview1.setText(quality.get((int)_position).get("quality").toString());
					}
				}
			}catch(Exception e){
				 
			}
			if (textview1.getText().toString().contains("Auto")) {
				linear1.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						link = getIntent().getStringExtra("url");
					}
				});
			}
			else {
				linear1.setOnClickListener(new View.OnClickListener() {
					@Override
					public void onClick(View _view) {
						link = getIntent().getStringExtra("url").replaceAll("(\\w+)(.m3u8)", "").concat(links.get((int)_position).get("links").toString()).replaceAll("\\\n", "");
					}
				});
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