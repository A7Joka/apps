package Eng.MBP.Vip;

import android.animation.*;
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
import android.view.View.*;
import android.view.animation.*;
import android.webkit.*;
import android.widget.*;
import android.widget.ImageView;
import android.widget.LinearLayout;
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
import com.google.firebase.FirebaseApp;
import dev.gerges.ParserM3U.*;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.Timer;
import java.util.TimerTask;
import java.util.regex.*;
import meorg.jsoup.*;
import org.checkerframework.checker.nullness.compatqual.*;
import org.json.*;

public class SplashActivity extends AppCompatActivity {
	
	private Timer _timer = new Timer();
	
	private LinearLayout bg;
	private LinearLayout top;
	private LinearLayout center;
	private LinearLayout bottom;
	private ImageView icon;
	private TextView textview1;
	
	private TimerTask time;
	private Intent intent = new Intent();
	private RequestNetwork req;
	private RequestNetwork.RequestListener _req_request_listener;
	private Intent nnn = new Intent();
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.splash);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		MobileAds.initialize(this);
		
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		bg = findViewById(R.id.bg);
		top = findViewById(R.id.top);
		center = findViewById(R.id.center);
		bottom = findViewById(R.id.bottom);
		icon = findViewById(R.id.icon);
		textview1 = findViewById(R.id.textview1);
		req = new RequestNetwork(this);
		
		_req_request_listener = new RequestNetwork.RequestListener() {
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
	}
	
	private void initializeLogic() {
		getWindow().getDecorView().setSystemUiVisibility(View.SYSTEM_UI_FLAG_LIGHT_STATUS_BAR);
		Animation fadeIn = new AlphaAnimation(0, 1);
		fadeIn.setInterpolator(new DecelerateInterpolator());
		fadeIn.setDuration(1500);
		icon.setAnimation(fadeIn);
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
		req.startRequestNetwork(RequestNetworkController.GET, "t.me/eng3body", "", _req_request_listener);
		time = new TimerTask() {
			@Override
			public void run() {
				runOnUiThread(new Runnable() {
					@Override
					public void run() {
						if (SketchwareUtil.isConnected(getApplicationContext())) {
							intent.setClass(getApplicationContext(), StartActivity.class);
							startActivity(intent);
							finish();
						}
						else {
							time.cancel();
							SketchwareUtil.showMessage(getApplicationContext(), "يبدو ان هناك خطا في اتصالك بالانترنت جاري اعادة المحاولة");
							time = new TimerTask() {
								@Override
								public void run() {
									runOnUiThread(new Runnable() {
										@Override
										public void run() {
											if (SketchwareUtil.isConnected(getApplicationContext())) {
												time.cancel();
												intent.setClass(getApplicationContext(), StartActivity.class);
												startActivity(intent);
												finish();
											}
											else {
												time.cancel();
												SketchwareUtil.showMessage(getApplicationContext(), "يبدو ان هناك عطل \nتحقق من اتصالك بالانترنت من فضلك");
												finishAffinity();
											}
										}
									});
								}
							};
							_timer.schedule(time, (int)(5000));
						}
					}
				});
			}
		};
		_timer.schedule(time, (int)(3000));
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