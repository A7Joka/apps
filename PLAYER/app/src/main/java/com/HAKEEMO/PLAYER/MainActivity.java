package com.HAKEEMO.PLAYER;

import com.HAKEEMO.PLAYER.StartActivity;
import android.animation.*;
import android.animation.ObjectAnimator;
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
import android.view.animation.AccelerateDecelerateInterpolator;
import android.view.animation.AccelerateInterpolator;
import android.view.animation.BounceInterpolator;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.webkit.*;
import android.widget.*;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ProgressBar;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.blogspot.atifsoftwares.animatoolib.*;
import com.google.android.exoplayer2.*;
import com.google.android.exoplayer2.ui.*;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.firebase.FirebaseApp;
import dev.gerges.ParserM3U.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
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
import androidx.appcompat.app.AppCompatActivity;

import android.content.pm.ActivityInfo;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.AdapterViewFlipper;
import android.widget.ImageView;
import android.widget.ProgressBar;

import com.google.android.exoplayer2.DefaultLoadControl;
import com.google.android.exoplayer2.ExoPlaybackException;
import com.google.android.exoplayer2.ExoPlayerFactory;
import com.google.android.exoplayer2.LoadControl;
import com.google.android.exoplayer2.PlaybackParameters;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.Timeline;
import com.google.android.exoplayer2.extractor.DefaultExtractorsFactory;
import com.google.android.exoplayer2.extractor.ExtractorsFactory;
import com.google.android.exoplayer2.source.ExtractorMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.ui.PlayerView;
import com.google.android.exoplayer2.upstream.BandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultBandwidthMeter;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
//
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
	private String _ad_unit_id;
	
	private boolean flag = false;
	private String video_path = "";
	private boolean loading = false;
	private double playbackState = 0;
	private String link = "";
	private double position = 0;
	private boolean orien = false;
	private  SimpleExoPlayer player;
	private  PlaybackParams param;
	private String userAgentHeader = "";
	private String refererHeader = "";
	private  MediaSource mediaSource;
	private  InterstitialAd ia;
	private String st = "";
	private double pos2 = 0;
	private double pos1 = 0;
	private double pos = 0;
	private String new_url = "";
	private String NewSource = "";
	private boolean isLoaded = false;
	
	private LinearLayout linear1;
	private PlayerView player_view;
	private ImageView imageview1;
	private ImageView settingss;
	private ImageView btFullScreen;
	private ProgressBar progressBar;
	private ImageView cast;
	private ImageView pip;
	
	private TimerTask check;
	private RequestNetwork rns;
	private RequestNetwork.RequestListener _rns_request_listener;
	private Intent i = new Intent();
	private ObjectAnimator object2 = new ObjectAnimator();
	private InterstitialAd InterstitialAd;
	private InterstitialAdLoadCallback _InterstitialAd_interstitial_ad_load_callback;
	private FullScreenContentCallback _InterstitialAd_full_screen_content_callback;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.main);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		MobileAds.initialize(this);
		_ad_unit_id = "ca-app-pub-3675302410879827/8081302828";
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
		player_view = findViewById(R.id.player_view);
		imageview1 = findViewById(R.id.imageview1);
		settingss = findViewById(R.id.settingss);
		btFullScreen = findViewById(R.id.btFullScreen);
		progressBar = findViewById(R.id.progressBar);
		cast = findViewById(R.id.cast);
		pip = findViewById(R.id.pip);
		rns = new RequestNetwork(this);
		
		imageview1.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (orien) {
					btFullScreen.setImageDrawable(getResources().getDrawable(R.drawable.exo_ic_fullscreen_enter));
					setRequestedOrientation(1);
					orien = false;
				}
				else {
					btFullScreen.setImageDrawable(getResources().getDrawable(R.drawable.exo_ic_fullscreen_exit));
					setRequestedOrientation(0);
					orien = true;
				}
			}
		});
		
		settingss.setOnClickListener(new View.OnClickListener() {
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
											//Ads...
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
		
		btFullScreen.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (orien) {
					setRequestedOrientation(0);
					orien = false;
				}
				else {
					setRequestedOrientation(1);
					orien = true;
				}
			}
		});
		
		cast.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				Intent intent = new Intent(android.provider.Settings.ACTION_CAST_SETTINGS);
				startActivityForResult(intent, 0);
			}
		});
		
		_rns_request_listener = new RequestNetwork.RequestListener() {
			@Override
			public void onResponse(String _param1, String _param2, HashMap<String, Object> _param3) {
				final String _tag = _param1;
				final String _response = _param2;
				final HashMap<String, Object> _responseHeaders = _param3;
				
			}
			
			@Override
			public void onErrorResponse(String _param1, String _param2) {
				final String _tag = _param1;
				final String _message = _param2;
				
			}
		};
		
		_InterstitialAd_interstitial_ad_load_callback = new InterstitialAdLoadCallback() {
			@Override
			public void onAdLoaded(InterstitialAd _param1) {
				
			}
			
			@Override
			public void onAdFailedToLoad(LoadAdError _param1) {
				final int _errorCode = _param1.getCode();
				final String _errorMessage = _param1.getMessage();
				
			}
		};
		
		_InterstitialAd_full_screen_content_callback = new FullScreenContentCallback() {
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
		if (!link.contains(".m3u8")) {
				
				player = ExoPlayerFactory.newSimpleInstance(this, new DefaultTrackSelector(new Factory(new DefaultBandwidthMeter())), new DefaultLoadControl());
				
				String HLS_URL = link;
			Uri uri = Uri.parse(HLS_URL);
				MediaSource mediaSource = new ExtractorMediaSource(uri, new DefaultHttpDataSourceFactory(userAgentHeader), new DefaultExtractorsFactory(), null, null);
				_HLS();
				
				
				        //set player
				
				        player_view.setPlayer(player);
				        //keep screen on
				        player_view.setKeepScreenOn(true);
				        //Media
				        player.prepare(mediaSource);
				        //play video rady
				        player.setPlayWhenReady(true);
				        player.addListener(new Player.EventListener() {
						            @Override
						            public void onTimelineChanged(Timeline timeline, Object manifest, int reason) {
								
								            }
						
						            @Override
						            public void onTracksChanged(TrackGroupArray trackGroups, TrackSelectionArray trackSelections) {
								
								            }
						
						            @Override
						            public void onLoadingChanged(boolean isLoading) {
								
								            }
						
						            @Override
						            public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
								                //check condition{}
								                if (playbackState == Player.STATE_BUFFERING){
										                    //show progressbar
										                    progressBar.setVisibility(View.VISIBLE);
										                }else if (playbackState == Player.STATE_READY){
										                    //hide progressbar
										                    progressBar.setVisibility(View.GONE);
										
										                }
								            }
						
						            @Override
						            public void onRepeatModeChanged(int repeatMode) {
								
								            }
						
						            @Override
						            public void onShuffleModeEnabledChanged(boolean shuffleModeEnabled) {
								
								            }
						
						            @Override
						            public void onPlayerError(ExoPlaybackException error) {
								
								            }
						
						            @Override
						            public void onPositionDiscontinuity(int reason) {
								
								            }
						
						            @Override
						            public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
								
								            }
						
						            @Override
						            public void onSeekProcessed() {
								
								            }
						        });
				
				//
		}
		else {
				
				DefaultHttpDataSourceFactory dataSourceFactory = new DefaultHttpDataSourceFactory(userAgentHeader);
				
				dataSourceFactory.getDefaultRequestProperties().set("Referer", refererHeader);
				
				player = ExoPlayerFactory.newSimpleInstance(this, new DefaultTrackSelector(new Factory(new DefaultBandwidthMeter())), new DefaultLoadControl());
				
				String HLS_URL = link;
				Uri uri = Uri.parse(HLS_URL); 
			MediaSource mediaSource =new HlsMediaSource.Factory(dataSourceFactory).createMediaSource(uri);
				
				_HLS();
				
					        //set player
				
				        player_view.setPlayer(player);
				        //keep screen on
				        player_view.setKeepScreenOn(true);
				        //Media
				        player.prepare(mediaSource);
				        //play video rady
				        player.setPlayWhenReady(true);
				        player.addListener(new Player.EventListener() {
						            @Override
						            public void onTimelineChanged(Timeline timeline, Object manifest, int reason) {
								
								            }
						
						            @Override
						            public void onTracksChanged(TrackGroupArray trackGroups, TrackSelectionArray trackSelections) {
								
								            }
						
						            @Override
						            public void onLoadingChanged(boolean isLoading) {
								
								            }
						
						            @Override
						            public void onPlayerStateChanged(boolean playWhenReady, int playbackState) {
								                //check condition{}
								                if (playbackState == Player.STATE_BUFFERING){
										                    //show progressbar
										                    progressBar.setVisibility(View.VISIBLE);
										                }else if (playbackState == Player.STATE_READY){
										                    //hide progressbar
										                    progressBar.setVisibility(View.GONE);
										
										                }
								            }
						
						            @Override
						            public void onRepeatModeChanged(int repeatMode) {
								
								            }
						
						            @Override
						            public void onShuffleModeEnabledChanged(boolean shuffleModeEnabled) {
								
								            }
						
						            @Override
						            public void onPlayerError(ExoPlaybackException error) {
								
								            }
						
						            @Override
						            public void onPositionDiscontinuity(int reason) {
								
								            }
						
						            @Override
						            public void onPlaybackParametersChanged(PlaybackParameters playbackParameters) {
								
								            }
						
						            @Override
						            public void onSeekProcessed() {
								
								            }
						        });
				
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
		
		final ImageView cast = (ImageView)player_view.findViewById(R.id.cast);
		player_view.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
						Intent intent = new Intent(android.provider.Settings.ACTION_CAST_SETTINGS);
						startActivityForResult(intent, 0);
						
				}
		});
		
		final ImageView settingss = (ImageView)player_view.findViewById(R.id.settingss);
		
		final ImageView pip = (ImageView)player_view.findViewById(R.id.pip);
		player_view.setOnClickListener(new View.OnClickListener() {
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
																				param.setSpeed(2.5f);
																				player.setPlaybackParams(param);
																				
																				SketchwareUtil.showMessage(getApplicationContext(), "x 2.5");
																		} catch(Exception e) {
																					 SketchwareUtil.showMessage(getApplicationContext(), "Error");
																		}
																}
																else {
																		if ((position + 1) == 5) {
																				
																				try {
																						PlaybackParams param = new PlaybackParams();
																						param.setSpeed(4.5f);
																						player.setPlaybackParams(param);
																						
																						SketchwareUtil.showMessage(getApplicationContext(), "x 4.5");
																				} catch(Exception e) {
																							 SketchwareUtil.showMessage(getApplicationContext(), "Error");
																				}
																		}
																		else {
																				//Ads...
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
		
		final ImageView btFullScreen = (ImageView)player_view.findViewById(R.id.bt_fullscreen);
		btFullScreen.setOnClickListener(new View.OnClickListener() {
				@Override
				public void onClick(View _view) {
						if (orien) {
								btFullScreen.setImageDrawable(getResources().getDrawable(R.drawable.exo_ic_fullscreen_enter));
								setRequestedOrientation(0);
								orien = false;
						}
						else {
								btFullScreen.setImageDrawable(getResources().getDrawable(R.drawable.exo_ic_fullscreen_exit));
								setRequestedOrientation(1);
								orien = true;
						}
				}
		});
		SystemClock.sleep(400);
		loading = true;
		refererHeader = getIntent().getStringExtra("Referer");
		userAgentHeader = getIntent().getStringExtra("User_agent");
		link = getIntent().getStringExtra("URL");
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
	
	@Override
	public void onPause() {
		super.onPause();
		if (player != null) {
				player.setPlayWhenReady(false);
				player.getPlaybackState();
		}
	}
	
	@Override
	public void onResume() {
		super.onResume();
		player.setPlayWhenReady(true);
	}
	
	@Override
	public void onBackPressed() {
		if (true) {
			i.setClass(getApplicationContext(), HomeActivity.class);
			startActivity(i);
		}
		else {
			finishAffinity();
		}
	}
	public void _Events() {
		
	}
	
	
	public void _SplashView() {
		//If this causes you problems, delete it
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
	
	
	public void _HLS() {
		
	}
	private MediaSource buildMediaSource(Uri uri) {
		    DataSource.Factory dataSourceFactory = new DefaultHttpDataSourceFactory(userAgentHeader);
		    return new HlsMediaSource.Factory(dataSourceFactory).createMediaSource(uri);
	}
	{
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