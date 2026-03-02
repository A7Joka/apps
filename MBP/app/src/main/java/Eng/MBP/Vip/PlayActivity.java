package Eng.MBP.Vip;

import android.animation.*;
import android.app.*;
import android.content.*;
import android.content.res.*;
import android.graphics.*;
import android.graphics.drawable.*;
import android.media.*;
import android.net.*;
import android.os.*;
import android.text.*;
import android.text.style.*;
import android.util.*;
import android.view.*;
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
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
import com.google.firebase.FirebaseApp;
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
import com.google.android.gms.ads.MobileAds;
import com.google.android.gms.ads.initialization.InitializationStatus;
import com.google.android.gms.ads.initialization.OnInitializationCompleteListener;
import com.google.android.gms.ads.AdError;
import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdLoader;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.AdValue;
import com.google.android.gms.ads.AdView;
import com.google.android.gms.ads.FullScreenContentCallback;
import com.google.android.gms.ads.LoadAdError;
import com.google.android.gms.ads.OnPaidEventListener;
import com.google.android.gms.ads.OnUserEarnedRewardListener;
import com.google.android.gms.ads.interstitial.InterstitialAd;
import com.google.android.gms.ads.interstitial.InterstitialAdLoadCallback;
import com.google.android.gms.ads.nativead.MediaView;
import com.google.android.gms.ads.nativead.NativeAd;
import com.google.android.gms.ads.nativead.NativeAdOptions;
import com.google.android.gms.ads.nativead.NativeAdView;
import com.google.android.gms.ads.rewarded.OnAdMetadataChangedListener;
import com.google.android.gms.ads.rewarded.RewardItem;
import com.google.android.gms.ads.rewarded.RewardedAd;
import com.google.android.gms.ads.rewarded.RewardedAdLoadCallback;
import com.google.android.gms.ads.RequestConfiguration;
import com.google.android.gms.ads.AdSize;
import com.google.android.gms.ads.AdView;
import android.widget.LinearLayout.LayoutParams;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.ui.StyledPlayerView;
import com.google.common.collect.ImmutableList;
import com.google.android.exoplayer2.util.MimeTypes;
import static java.lang.annotation.ElementType.TYPE_USE;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.IntDef;
import androidx.annotation.Nullable;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import android.content.pm.ActivityInfo;
import  com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import  com.google.android.exoplayer2.upstream.DefaultHttpDataSource;
import com.google.android.exoplayer2.SimpleExoPlayer;
import android.net.Uri;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.DataSourceInputStream;
import com.google.android.exoplayer2.upstream.DataSpec;
import com.google.android.exoplayer2.upstream.TransferListener;
import com.google.android.exoplayer2.util.Assertions;
import java.io.IOException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.Key;
import java.security.NoSuchAlgorithmException;
import java.security.spec.AlgorithmParameterSpec;
import java.util.List;
import java.util.Map;
import javax.crypto.Cipher;
import javax.crypto.CipherInputStream;
import javax.crypto.NoSuchPaddingException;
import javax.crypto.spec.IvParameterSpec;
import javax.crypto.spec.SecretKeySpec;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import android.net.Uri;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource;
import com.google.android.exoplayer2.upstream.DefaultHttpDataSourceFactory;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
 
import java.net.NetworkInterface;
import java.net.SocketException;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import javax.crypto.spec.IvParameterSpec;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import android.os.Bundle;
import androidx.appcompat.app.AppCompatActivity;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.drm.FrameworkMediaDrm;
import com.google.android.exoplayer2.drm.HttpMediaDrmCallback;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.ui.StyledPlayerView;
import com.google.common.collect.ImmutableList;
import com.google.android.exoplayer2.util.MimeTypes;
import static java.lang.annotation.ElementType.TYPE_USE;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.FrameLayout;
import androidx.annotation.IntDef;
import androidx.annotation.Nullable;
import java.lang.annotation.Documented;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;
import android.content.pm.ActivityInfo;
import  com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import  com.google.android.exoplayer2.upstream.DefaultHttpDataSource;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.C.ContentType;
import com.google.android.exoplayer2.ExoPlaybackException;

import com.google.android.exoplayer2.RenderersFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;

import com.google.android.exoplayer2.drm.FrameworkMediaDrm;

import com.google.android.exoplayer2.drm.UnsupportedDrmException;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.DecoderInitializationException;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException;
import com.google.android.exoplayer2.offline.DownloadHelper;
import com.google.android.exoplayer2.offline.DownloadRequest;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.ConcatenatingMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.ads.AdsLoader;
import com.google.android.exoplayer2.source.ads.AdsMediaSource;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo;
import com.google.android.exoplayer2.trackselection.RandomTrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;

import com.google.android.exoplayer2.ui.PlayerControlView;
import com.google.android.exoplayer2.ui.PlayerView;

import com.google.android.exoplayer2.upstream.DataSource;
import com.google.android.exoplayer2.upstream.HttpDataSource;
import com.google.android.exoplayer2.util.ErrorMessageProvider;
import com.google.android.exoplayer2.util.EventLogger;
import com.google.android.exoplayer2.util.Util;


import java.lang.reflect.Constructor;
import java.net.CookieHandler;
import java.net.CookieManager;
import java.net.CookiePolicy;
import java.util.UUID;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.C.ContentType;
import com.google.android.exoplayer2.ExoPlaybackException;

import com.google.android.exoplayer2.RenderersFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;

import com.google.android.exoplayer2.drm.FrameworkMediaDrm;

import com.google.android.exoplayer2.drm.UnsupportedDrmException;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.DecoderInitializationException;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException;
import com.google.android.exoplayer2.offline.DownloadHelper;
import com.google.android.exoplayer2.offline.DownloadRequest;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.ConcatenatingMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.ads.AdsLoader;
import com.google.android.exoplayer2.source.ads.AdsMediaSource;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo;
import com.google.android.exoplayer2.trackselection.RandomTrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;

import com.google.android.exoplayer2.ui.PlayerControlView;
import com.google.android.exoplayer2.ui.PlayerView;

import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.C.ContentType;
import com.google.android.exoplayer2.ExoPlaybackException;

import com.google.android.exoplayer2.RenderersFactory;
import com.google.android.exoplayer2.SimpleExoPlayer;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;

import com.google.android.exoplayer2.drm.FrameworkMediaDrm;

import com.google.android.exoplayer2.drm.UnsupportedDrmException;
import com.google.android.exoplayer2.mediacodec.MediaCodecRenderer.DecoderInitializationException;
import com.google.android.exoplayer2.mediacodec.MediaCodecUtil.DecoderQueryException;
import com.google.android.exoplayer2.offline.DownloadHelper;
import com.google.android.exoplayer2.offline.DownloadRequest;
import com.google.android.exoplayer2.source.BehindLiveWindowException;
import com.google.android.exoplayer2.source.ConcatenatingMediaSource;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.ProgressiveMediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.ads.AdsLoader;
import com.google.android.exoplayer2.source.ads.AdsMediaSource;
import com.google.android.exoplayer2.source.dash.DashMediaSource;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.source.smoothstreaming.SsMediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector.MappedTrackInfo;
import com.google.android.exoplayer2.trackselection.RandomTrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;

import com.google.android.exoplayer2.ui.PlayerControlView;
import com.google.android.exoplayer2.ui.PlayerView;

import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.RenderersFactory;
import java.net.NetworkInterface;
import java.net.SocketException;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;
import androidx.annotation.Nullable;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager; import com.google.android.exoplayer2.drm.DrmSessionManager;
 import com.google.android.exoplayer2.drm.FrameworkMediaDrm; 
import com.google.android.exoplayer2.drm.LocalMediaDrmCallback; 
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory; 
import android.net.Uri; 
import android.os.Bundle; 
import com.google.android.exoplayer2.C; import com.google.android.exoplayer2.ExoPlayer; 
import com.google.android.exoplayer2.MediaItem;
 import com.google.android.exoplayer2.SimpleExoPlayer; 
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager; import com.google.android.exoplayer2.drm.DrmSessionManager;
 import com.google.android.exoplayer2.drm.FrameworkMediaDrm; 
import com.google.android.exoplayer2.drm.LocalMediaDrmCallback;
 import com.google.android.exoplayer2.source.DefaultMediaSourceFactory; import com.google.android.exoplayer2.source.MediaSource; 
import com.google.android.exoplayer2.source.dash.DashMediaSource;
 import com.google.android.exoplayer2.upstream.DataSource; 
import com.google.android.exoplayer2.upstream.DefaultHttpDataSource; 
import java.util.HashMap; 
import java.util.Map;
import android.util.Base64;
import com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.drm.DefaultDrmSessionManager;
import com.google.android.exoplayer2.drm.DrmSessionManager;
import com.google.android.exoplayer2.drm.FrameworkMediaDrm;
import com.google.android.exoplayer2.drm.LocalMediaDrmCallback;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;

import com.google.android.exoplayer2.util.MimeTypes;


import java.util.HashMap;
import android.media.MediaPlayer;
import  com.google.android.exoplayer2.ExoPlayer;
import com.google.android.exoplayer2.MediaItem;
import com.google.android.exoplayer2.ui.StyledPlayerView;
import com.google.common.collect.ImmutableList;
import com.google.android.exoplayer2.util.MimeTypes;
import com.google.android.exoplayer2.C;
import com.google.android.exoplayer2.DefaultRenderersFactory;
import com.google.android.exoplayer2.Player;
import com.google.android.exoplayer2.RenderersFactory;
import com.google.android.exoplayer2.SeekParameters;
import com.google.android.exoplayer2.trackselection.TrackSelector;
import com.google.android.exoplayer2.audio.AudioAttributes;
import com.google.android.exoplayer2.source.MediaSource;
import com.google.android.exoplayer2.source.TrackGroupArray;
import com.google.android.exoplayer2.source.hls.HlsMediaSource;
import com.google.android.exoplayer2.trackselection.AdaptiveTrackSelection;
import com.google.android.exoplayer2.trackselection.DefaultTrackSelector;
import com.google.android.exoplayer2.trackselection.MappingTrackSelector;
import com.google.android.exoplayer2.trackselection.TrackSelection;
import com.google.android.exoplayer2.trackselection.TrackSelectionArray;
import com.google.android.exoplayer2.util.Util;
import com.google.android.exoplayer2.source.DefaultMediaSourceFactory;
import com.google.android.exoplayer2.upstream.DefaultDataSourceFactory;

public class PlayActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	StyledPlayerView spv;
	StyledPlayerView playerView;
	ExoPlayer player;
	private String type = "";
	private String userAgent = "";
	private String referer = "";
	private String videoURL = "";
	private String name = "";
	private String image = "";
	private String name_channel = "";
	private boolean loading = false;
	private boolean orien = false;
	private double num = 0;
	private boolean isFullScreen = false;
	private boolean exo_icon_fullscreen_enter = false;
	private String url = "";
	private String uri = "";
	private HashMap<String, Object> server1 = new HashMap<>();
	private HashMap<String, Object> map_channel_server = new HashMap<>();
	private String server2 = "";
	private String refererHeader = "";
	private String userAgentHeader = "";
	private String link = "";
	private String contentUri = "";
	private String url_playing = "";
	private String link3 = "";
	private String origin = "";
	private String status_vpn = "";
	private String nowsousr_2 = "";
	private double post_22 = 0;
	private double post_11 = 0;
	private double post_00 = 0;
	private String class_1 = "";
	private String response = "";
	private String key = "";
	private String iv = "";
	private String p = "";
	private String l = "";
	private String IV_ALL = "";
	private boolean pip_view = false;
	private String security = "";
	private double pos_perclick = 0;
	private String server_playing = "";
	private String use = "";
	private String ref = "";
	private String oru = "";
	private String useragent = "";
	private String s = "";
	private String uid_choose = "";
	private String server_channel = "";
	private String url_playing_second = "";
	private String server_playing_second = "";
	private String massage_server = "";
	private String videoStart = "";
	private String choose_playing = "";
	private String name_playing = "";
	private String tv_server_all = "";
	private String video_path = "";
	private double pos2 = 0;
	private double pos1 = 0;
	private double pos = 0;
	private String new_url = "";
	private String NewSource = "";
	private  InterstitialAd ia;
	private double view = 0;
	private String html = "";
	private double weblink = 0;
	private String web_link = "";
	private String ClearKey_Key = "";
	private String ClearKey_Key_ID = "";
	private String drmKey = "";
	private String drmKeyId = "";
	private boolean isShowingTrackSelectionDialog = false;
	private double zoom = 0;
	private String txt = "";
	private String DRM = "";
	private String uuu = "";
	
	private ArrayList<HashMap<String, Object>> list_map_channel_tv = new ArrayList<>();
	private ArrayList<String> url_2 = new ArrayList<>();
	private ArrayList<String> Expires = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> name_2 = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> link_map = new ArrayList<>();
	private ArrayList<HashMap<String, Object>> list_map_server_tv = new ArrayList<>();
	
	private StyledPlayerView linear1;
	
	private TimerTask t_1;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.play);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		MobileAds.initialize(this);
		
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		linear1 = findViewById(R.id.linear1);
	}
	
	private void initializeLogic() {
		getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);
		  try {
			  uuu = AESCrypt.decrypt("85Fl31Hu49Uv15Vl31Ta", getIntent().getStringExtra("url"));
			  } catch (java.security.GeneralSecurityException e){
			      showMessage("password incorrect !" + "\n" + e.toString());
			  }
		txt = getIntent().getStringExtra("txt");
		url = uuu;
		url_playing = uuu;
		link = uuu;
		contentUri = uuu;
		videoURL = link;
		if (getIntent().getStringExtra("userAgent").equals("")) {
			userAgent = "MBPlayer";
		}
		else {
			userAgent = getIntent().getStringExtra("userAgent");
		}
		if (getIntent().getStringExtra("referer").equals("")) {
			referer = "MBPlayer";
		}
		else {
			referer = getIntent().getStringExtra("referer");
		}
		if (getIntent().getStringExtra("DRM").equals("")) {
			DRM = "moviball:moviball";
			ClearKey_Key_ID = "drm".concat(DRM.concat(".")).substring((int)("drm".concat(DRM.concat(".")).indexOf("drm")), (int)("drm".concat(DRM.concat(".")).indexOf(":"))).replace("drm", "");
			ClearKey_Key = "drm".concat(DRM.concat(".")).substring((int)("drm".concat(DRM.concat(".")).indexOf(":")), (int)("drm".concat(DRM.concat(".")).indexOf("."))).replace(":", "");
		}
		else {
			if (getIntent().getStringExtra("DRM").contains("KeyID")) {
				DRM = "moviball:moviball";
				ClearKey_Key_ID = "drm".concat(DRM.concat(".")).substring((int)("drm".concat(DRM.concat(".")).indexOf("drm")), (int)("drm".concat(DRM.concat(".")).indexOf(":"))).replace("drm", "");
				ClearKey_Key = "drm".concat(DRM.concat(".")).substring((int)("drm".concat(DRM.concat(".")).indexOf(":")), (int)("drm".concat(DRM.concat(".")).indexOf("."))).replace(":", "");
			}
			else {
				DRM = getIntent().getStringExtra("DRM");
				if (DRM.contains("http")) {
					ClearKey_Key = DRM;
				}
				else {
					if (DRM.contains("},{")) {
						ClearKey_Key = DRM;
					}
					else {
						if (DRM.contains(":")) {
							link3 = "https://drm.cloud.insysvt.com/acquire-license/widevine";
							ClearKey_Key_ID = "drm".concat(DRM.concat(".")).substring((int)("drm".concat(DRM.concat(".")).indexOf("drm")), (int)("drm".concat(DRM.concat(".")).indexOf(":"))).replace("drm", "");
							ClearKey_Key = "drm".concat(DRM.concat(".")).substring((int)("drm".concat(DRM.concat(".")).indexOf(":")), (int)("drm".concat(DRM.concat(".")).indexOf("."))).replace(":", "");
						}
					}
				}
			}
		}
		_play_videos();
		num = 1;
		isFullScreen = false;
		isShowingTrackSelectionDialog = false;
	}
	
	
	@Override
	public void onDestroy() {
		super.onDestroy();
		if (player != null) {
				spv.setPlayer(null);
				player.release();
				player = null;
		}
	}
	
	@Override
	public void onBackPressed() {
		if ((Build.VERSION.SDK_INT > 21) || (Build.VERSION.SDK_INT == 21)) {
			finishAndRemoveTask();
		}
		else {
			finish();
		}
	}
	
	@Override
	public void onResume() {
		super.onResume();
		super.onResume();
		        getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_FULLSCREEN
		                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
		                | View.SYSTEM_UI_FLAG_HIDE_NAVIGATION);
	}
	public void _Events() {
		
		final TextView file_name_tv = (TextView)spv.findViewById(R.id.file_name_tv);
		file_name_tv.setText(txt);
		spv.setResizeMode(AspectRatioFrameLayout.RESIZE_MODE_FILL);
		
		final ImageView btn_back = (ImageView)spv.findViewById(R.id.btn_back);
		btn_back.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View _view){
				if ((Build.VERSION.SDK_INT > 21) || (Build.VERSION.SDK_INT == 21)) {
					finishAndRemoveTask();
				}
				else {
					finish();
				}
			}
		});
		Window window = this.getWindow();
		
		// التحقق من إصدار الأندرويد
		if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.R) {
			    // بالنسبة للأندرويد 11 (Android 11) وما بعده
			    window.setDecorFitsSystemWindows(false);
			    window.getInsetsController().hide(WindowInsets.Type.systemBars());
			    window.getInsetsController().setSystemBarsBehavior(
			        WindowInsetsController.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE
			    );
		} else {
			    // للأندرويد 10 (Android 10) وما قبله
			    window.getDecorView().setSystemUiVisibility(
			        View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
			        | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
			        | View.SYSTEM_UI_FLAG_FULLSCREEN
			    );
		}
		
		
		
		
		
		        // لضبط وضع الشاشة الكاملة والتوافق مع مختلف الأجهزة
		        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
		
		        // ضبط طريقة العرض لملء الشاشة
		        spv.setResizeMode(AspectRatioFrameLayout.RESIZE_MODE_FILL);
		
		        // إخفاء شريط التنقل والحالة للحصول على تجربة ملء الشاشة
		        hideSystemUI();
		
		        // معالجة مشاكل الحواف السوداء في بعض الأجهزة مثل Realme
		        adjustLayoutForFullScreen();
		
		
		    }
	
	    private void hideSystemUI() {
		        // إخفاء شريط التنقل وشريط الحالة
		        View decorView = getWindow().getDecorView();
		        decorView.setSystemUiVisibility(
		                View.SYSTEM_UI_FLAG_HIDE_NAVIGATION
		                | View.SYSTEM_UI_FLAG_IMMERSIVE_STICKY
		                | View.SYSTEM_UI_FLAG_FULLSCREEN);
		    }
	
	    private void adjustLayoutForFullScreen() {
		        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.P) {
			            // معالجة مشاكل حواف الشاشات المنحنية والشاشات الكاملة
			            WindowManager.LayoutParams params = getWindow().getAttributes();
			            params.layoutInDisplayCutoutMode = WindowManager.LayoutParams.LAYOUT_IN_DISPLAY_CUTOUT_MODE_SHORT_EDGES;
			            getWindow().setAttributes(params);}
		
		
		
		
		
		
		
		final ImageView btn_quality = (ImageView)spv.findViewById(R.id.btn_quality);
		btn_quality.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View _view){
				type = "2";
				// إعداد TrackSelectionDialogBuilder
				TrackSelectionDialogBuilder trackSelectionDialogBuilder = new TrackSelectionDialogBuilder(PlayActivity.this, "Video Quality", player, Integer.parseInt(type));
				trackSelectionDialogBuilder.setAllowMultipleOverrides(true);
				trackSelectionDialogBuilder.setAllowAdaptiveSelections(false);
				trackSelectionDialogBuilder.setShowDisableOption(true);
				
				// بناء الـ Dialog باستخدام TrackSelectionDialogBuilder
				Dialog dialog = trackSelectionDialogBuilder.build();
				
				// الوصول إلى محتوى الـ Dialog وتخصيصه
				dialog.setOnShowListener(new DialogInterface.OnShowListener() {
					    @Override
					    public void onShow(DialogInterface dialogInterface) {
						        // هنا نصل إلى نافذة الـ Dialog لتخصيص الخلفية
						        Window window = dialog.getWindow();
						        if (window != null) {GradientDrawable background = new GradientDrawable(); background.setColor(Color.parseColor("#e0e0e0")); background.setCornerRadius(20f);  window.setBackgroundDrawable(background);
							
							
							        }
						    }
				});
				dialog.show();
			}
		});
		
		final ImageView btn_audio = (ImageView)spv.findViewById(R.id.btn_audio);
		btn_audio.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View _view){
				type = "1";
				// إعداد TrackSelectionDialogBuilder
				TrackSelectionDialogBuilder trackSelectionDialogBuilder = new TrackSelectionDialogBuilder(PlayActivity.this, "Audio Track", player, Integer.parseInt(type));
				trackSelectionDialogBuilder.setAllowMultipleOverrides(true);
				trackSelectionDialogBuilder.setAllowAdaptiveSelections(false);
				trackSelectionDialogBuilder.setShowDisableOption(true);
				
				// بناء الـ Dialog باستخدام TrackSelectionDialogBuilder
				Dialog dialog = trackSelectionDialogBuilder.build();
				
				// الوصول إلى محتوى الـ Dialog وتخصيصه
				dialog.setOnShowListener(new DialogInterface.OnShowListener() {
					    @Override
					    public void onShow(DialogInterface dialogInterface) {
						        // هنا نصل إلى نافذة الـ Dialog لتخصيص الخلفية
						        Window window = dialog.getWindow();
						        if (window != null) {GradientDrawable background = new GradientDrawable(); background.setColor(Color.parseColor("#e0e0e0")); background.setCornerRadius(20f);  window.setBackgroundDrawable(background);
							
							
							        }
						    }
				});
				dialog.show();
			}
		});
		
		final ImageView btn_pip = (ImageView)spv.findViewById(R.id.btn_pip);
		btn_pip.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View _view){
				
				             if (android.os.Build.VERSION.SDK_INT >= 26) {
					             
					                try {
						                    Rational rational = new Rational(spv.getWidth(), spv.getHeight());
						            
						                    PictureInPictureParams mParams =
						                            new PictureInPictureParams.Builder()
						                                    .setAspectRatio(rational)
						                                    .build();
						
						                    enterPictureInPictureMode(mParams);
						                } catch (IllegalStateException e) {
						                    e.printStackTrace();
						                }
					            } else {
					                Toast.makeText(PlayActivity.this, "Background player not supported on your device", Toast.LENGTH_SHORT).show();
					finish();
					            }
			}
		});
		
		final ImageView btn_cast = (ImageView)spv.findViewById(R.id.btn_cast);
		btn_cast.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View _view){
				Intent intent = new Intent(android.provider.Settings.ACTION_CAST_SETTINGS);
				startActivityForResult(intent, 0);
			}
		});
		
		final ImageView btn_rotate = (ImageView)spv.findViewById(R.id.btn_rotate);
		btn_rotate.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View _view){
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
		
		final ImageView btn_screen = (ImageView)spv.findViewById(R.id.btn_screen);
		btn_screen.setOnClickListener(new View.OnClickListener(){
			@Override
			public void onClick(View _view){
				zoom++;
				if (zoom == 1) {
					spv.setResizeMode(AspectRatioFrameLayout.RESIZE_MODE_FIXED_WIDTH);
					SketchwareUtil.showMessage(getApplicationContext(), "Click 1. Fixed Width");
				}
				if (zoom == 2) {
					spv.setResizeMode(AspectRatioFrameLayout.RESIZE_MODE_FIXED_HEIGHT);
					SketchwareUtil.showMessage(getApplicationContext(), "Click 2. Fixed Height");
				}
				if (zoom == 3) {
					spv.setResizeMode(AspectRatioFrameLayout.RESIZE_MODE_ZOOM);
					SketchwareUtil.showMessage(getApplicationContext(), "Click 3. Zoom");
				}
				if (zoom == 4) {
					spv.setResizeMode(AspectRatioFrameLayout.RESIZE_MODE_FIT);
					SketchwareUtil.showMessage(getApplicationContext(), "Click 4. FIT");
				}
				if (zoom == 5) {
					spv.setResizeMode(AspectRatioFrameLayout.RESIZE_MODE_FILL);
					SketchwareUtil.showMessage(getApplicationContext(), "Click 5. FILL. Auto");
					zoom = 0;
				}
			}
		});
		
		final ImageView forward_10 = (ImageView)spv.findViewById(R.id.forward_10);
		forward_10.setEnabled(false);
		
		final ImageView backward_10 = (ImageView)spv.findViewById(R.id.backward_10);
		backward_10.setEnabled(false);
	}
	
	
	public void _MarqueTextView(final TextView _view, final String _text) {
		_view.setText(_text);
		_view.setSingleLine(true);
		_view.setEllipsize(TextUtils.TruncateAt.MARQUEE);
		_view.setSelected(true);
	}
	
	
	public void _MPD_1() {
		String drmBody;
		
		if (ClearKey_Key.contains("},{")) {
			    drmBody = ClearKey_Key;
		} else {
			    byte[] drmKeyBytes = hexStringToByteArray(ClearKey_Key);
			    String encodedDrmKey = Base64.encodeToString(drmKeyBytes, Base64.URL_SAFE | Base64.NO_PADDING | Base64.NO_WRAP);
			    
			    byte[] drmKeyIdBytes = hexStringToByteArray(ClearKey_Key_ID);
			    String encodedDrmKeyId = Base64.encodeToString(drmKeyIdBytes, Base64.URL_SAFE | Base64.NO_PADDING | Base64.NO_WRAP);
			    
			    drmBody = "{\"keys\":[{\"kty\":\"oct\",\"k\":\"" + encodedDrmKey + "\",\"kid\":\"" + encodedDrmKeyId + "\"}],\"type\":\"temporary\"}";
		}
		
		MediaItem dashMediaItem = new MediaItem.Builder()
		    .setUri(link)
		    .setMimeType(MimeTypes.APPLICATION_MPD)
		    .build();
		
		DefaultTrackSelector trackSelector = new DefaultTrackSelector(this);
		DefaultLoadControl loadControl = new DefaultLoadControl();
		
		LocalMediaDrmCallback drmCallback = new LocalMediaDrmCallback(drmBody.getBytes());
		DefaultDrmSessionManager drmSessionManager = new DefaultDrmSessionManager.Builder()
		    .setPlayClearSamplesWithoutKeys(true)
		    .setMultiSession(false)
		    .setKeyRequestParameters(new HashMap<>())
		    .setUuidAndExoMediaDrmProvider(C.CLEARKEY_UUID, FrameworkMediaDrm.DEFAULT_PROVIDER)
		    .build(drmCallback);
		
		DrmSessionManager customDrmSessionManager = drmSessionManager;
		DefaultMediaSourceFactory mediaSourceFactory = new DefaultMediaSourceFactory(this)
		    .setDrmSessionManagerProvider(drmSessionManagerProvider -> customDrmSessionManager);
		
		player = new ExoPlayer.Builder(this)
		    .setTrackSelector(trackSelector)
		    .setSeekForwardIncrementMs(10000L)
		    .setSeekBackIncrementMs(10000L)
		    .build();
		
		player.setMediaSource(mediaSourceFactory.createMediaSource(dashMediaItem), true);
	}
	
	
	public void _init() {
	}
	private android.app.Dialog dialogX_vpn;
	private Context context = PlayActivity.this;
	
	    private static final Boolean DEFAULT_PLAYER = false;
	    private static final Boolean DEFAULT_BUFFERVALUE = true;
	    private static final Boolean DEFAULT_MEDIASOURCE = false;
	    private static final String DOWNLOAD_CONTENT_DIRECTORY = "downloads";
	    public static final String DRM_SCHEME_EXTRA = "drm_scheme";
	    public static final String DRM_LICENSE_URL_EXTRA = "drm_license_url";
	    public static final String DRM_KEY_REQUEST_PROPERTIES_EXTRA = "drm_key_request_properties";
	    public static final String DRM_MULTI_SESSION_EXTRA = "drm_multi_session";
	    public static final String PREFER_EXTENSION_DECODERS_EXTRA = "prefer_extension_decoders";
	    private static final String DRM_SCHEME_UUID_EXTRA = "drm_scheme_uuid";
	
	    public static final String ABR_ALGORITHM_EXTRA = "abr_algorithm";
	    public static final String ABR_ALGORITHM_DEFAULT = "default";
	    public static final String ABR_ALGORITHM_RANDOM = "random";
	
	   
	    private boolean starting = false;
	    private boolean stopBuffering = false;
	    
	    
	    
	    private String urlStreaming = "";
	    
	   
	    //private static PlayerManager instance;
	
	  
	
	
	private byte[] hexStringToByteArray(String s) {
		        int len = s.length();
		        byte[] data = new byte[len / 2];
		        for (int i = 0; i < len; i += 2) {
			            data[i / 2] = (byte) ((Character.digit(s.charAt(i), 16) << 4) + Character.digit(s.charAt(i + 1), 16));
			        }
		        return data;
	}
	{
	}
	
	
	public void _play_videos() {
		try {
				HttpDataSource.Factory httpDataSourceFactory = new DefaultHttpDataSource.Factory()
				        .setAllowCrossProtocolRedirects(true)
				        .setUserAgent(userAgent)
				        .setDefaultRequestProperties(Collections.singletonMap("Referer", referer));
				
				Map<String, String> headers = new HashMap<>();
				headers.put("User-Agent", userAgent); // قيمة لرأس User-Agent
				headers.put("Referer", referer); // قيمة لرأس Referer
				headers.put("Icy-MetaData", "1");
				
				httpDataSourceFactory.setDefaultRequestProperties(headers); 
				
				DefaultDataSource.Factory dataSourceFactory; // إعلان dataSourceFactory هنا
				//Default
			RenderersFactory renderersFactory = buildRenderersFactory(true);/*new DefaultRenderersFactory(this)
	            .setEnableDecoderFallback(true); */
				if (link.equals("https://prod")) {
						dataSourceFactory = new DefaultDataSource.Factory(this, new DefaultHttpDataSource.Factory()
				  .setAllowCrossProtocolRedirects(true)
					        .setUserAgent(userAgent)
					        .setDefaultRequestProperties(Collections.singletonMap("Referer", referer)));
				}
				else {
						dataSourceFactory = new DefaultDataSource.Factory(this, new DefaultHttpDataSource.Factory()
				  .setAllowCrossProtocolRedirects(true)
					        .setUserAgent(userAgent)
					        .setDefaultRequestProperties(Collections.singletonMap("Referer", referer)));
				}
				player = new ExoPlayer.Builder(this, renderersFactory)
				        .setMediaSourceFactory(new DefaultMediaSourceFactory(dataSourceFactory))
				        .build();
				
				spv = linear1;
				if (link.contains(".mpd")) {
				dataSourceFactory = new DefaultDataSource.Factory(this, new DefaultHttpDataSource.Factory()
				  .setAllowCrossProtocolRedirects(true)
					        .setUserAgent(userAgent)
					        .setDefaultRequestProperties(Collections.singletonMap("Referer", referer)));
						if (!ClearKey_Key.equals("")) {
								_MPD_1();
						}
						else {
								player = new ExoPlayer.Builder(this)
								                .setTrackSelector(new DefaultTrackSelector(this))
								                .build();
								   
								MediaItem mediaItem = new MediaItem.Builder()
								                .setUri(link)
								                .setDrmUuid(C.WIDEVINE_UUID)
								                .setDrmLicenseUri(link3)
								                .build();
								   
								player.addMediaItem(mediaItem);
						}
				}
				else {
						if (!type.equals("hls")) {
								MediaItem mediaItem = MediaItem.fromUri(link);
								
								player.addMediaItem(mediaItem);
						}
						else {
								MediaItem mediaItem = new MediaItem.Builder()
								        .setUri(link)
								        .setMimeType(MimeTypes.APPLICATION_M3U8)
								        .build();
								player.setMediaItem(mediaItem);
						}
				}
			    player.setAudioAttributes(AudioAttributes.DEFAULT,true);
				spv.setPlayer(player);
				player.prepare();
				player.play();	getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
				_Events();		
		} catch (Exception e) {
				// Handle exception
			
			spv.setPlayer(player);
				player.prepare();
				player.play();
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
	private RenderersFactory buildRenderersFactory(boolean preferExtensionRenderer) {
		       @DefaultRenderersFactory.ExtensionRendererMode
		       int extensionRendererMode =
		               true
		                       ? (preferExtensionRenderer
		                       ? DefaultRenderersFactory.EXTENSION_RENDERER_MODE_PREFER
		                       : DefaultRenderersFactory.EXTENSION_RENDERER_MODE_ON)
		                       : DefaultRenderersFactory.EXTENSION_RENDERER_MODE_OFF;
		       return new DefaultRenderersFactory(/* context= */ this)
		               .setExtensionRendererMode(extensionRendererMode);
		   } void nothing (){
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