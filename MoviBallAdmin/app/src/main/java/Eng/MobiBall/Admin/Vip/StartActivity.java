package Eng.MobiBall.Admin.Vip;

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
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import androidx.annotation.*;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.DialogFragment;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import com.google.firebase.FirebaseApp;
import java.io.*;
import java.text.*;
import java.util.*;
import java.util.regex.*;
import org.json.*;

public class StartActivity extends AppCompatActivity {
	
	private ScrollView vscroll1;
	private LinearLayout bg;
	private LinearLayout linear_top1;
	private LinearLayout linear_top2;
	private LinearLayout linear_top3;
	private LinearLayout linear_bot3;
	private LinearLayout linear_bot2;
	private LinearLayout linear_bot1;
	private LinearLayout top11;
	private LinearLayout top12;
	private LinearLayout top13;
	private ImageView img_top11;
	private TextView txt_top11;
	private ImageView img_top12;
	private TextView txt_top12;
	private ImageView img_top13;
	private TextView txt_top13;
	private ImageView img_top2;
	private TextView txt_top2;
	private ImageView img_top3;
	private TextView txt_top3;
	private ImageView img_bot3;
	private TextView txt_bot3;
	private LinearLayout bot21;
	private LinearLayout bot22;
	private ImageView img_bot21;
	private TextView txt_bot21;
	private ImageView img_bot22;
	private TextView txt_bot22;
	private LinearLayout bot11;
	private LinearLayout bot12;
	private ImageView img_bot11;
	private TextView txt_bot11;
	private ImageView img_bot12;
	private TextView txt_bot12;
	
	@Override
	protected void onCreate(Bundle _savedInstanceState) {
		super.onCreate(_savedInstanceState);
		setContentView(R.layout.start);
		initialize(_savedInstanceState);
		FirebaseApp.initializeApp(this);
		initializeLogic();
	}
	
	private void initialize(Bundle _savedInstanceState) {
		vscroll1 = findViewById(R.id.vscroll1);
		bg = findViewById(R.id.bg);
		linear_top1 = findViewById(R.id.linear_top1);
		linear_top2 = findViewById(R.id.linear_top2);
		linear_top3 = findViewById(R.id.linear_top3);
		linear_bot3 = findViewById(R.id.linear_bot3);
		linear_bot2 = findViewById(R.id.linear_bot2);
		linear_bot1 = findViewById(R.id.linear_bot1);
		top11 = findViewById(R.id.top11);
		top12 = findViewById(R.id.top12);
		top13 = findViewById(R.id.top13);
		img_top11 = findViewById(R.id.img_top11);
		txt_top11 = findViewById(R.id.txt_top11);
		img_top12 = findViewById(R.id.img_top12);
		txt_top12 = findViewById(R.id.txt_top12);
		img_top13 = findViewById(R.id.img_top13);
		txt_top13 = findViewById(R.id.txt_top13);
		img_top2 = findViewById(R.id.img_top2);
		txt_top2 = findViewById(R.id.txt_top2);
		img_top3 = findViewById(R.id.img_top3);
		txt_top3 = findViewById(R.id.txt_top3);
		img_bot3 = findViewById(R.id.img_bot3);
		txt_bot3 = findViewById(R.id.txt_bot3);
		bot21 = findViewById(R.id.bot21);
		bot22 = findViewById(R.id.bot22);
		img_bot21 = findViewById(R.id.img_bot21);
		txt_bot21 = findViewById(R.id.txt_bot21);
		img_bot22 = findViewById(R.id.img_bot22);
		txt_bot22 = findViewById(R.id.txt_bot22);
		bot11 = findViewById(R.id.bot11);
		bot12 = findViewById(R.id.bot12);
		img_bot11 = findViewById(R.id.img_bot11);
		txt_bot11 = findViewById(R.id.txt_bot11);
		img_bot12 = findViewById(R.id.img_bot12);
		txt_bot12 = findViewById(R.id.txt_bot12);
	}
	
	private void initializeLogic() {
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