package Eng.MoviBall.Vip;

import android.animation.*;
import android.app.*;
import android.app.Activity;
import android.content.*;
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
import android.widget.ImageView;
import android.widget.LinearLayout;
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

public class Frag5FragmentActivity extends Fragment {
	
	private LinearLayout background;
	private LinearLayout topBG;
	private LinearLayout bottomBG;
	private LinearLayout top;
	private ImageView logo;
	private LinearLayout bottom;
	private TextView title;
	private LinearLayout buttonBG;
	private LinearLayout linear1;
	private TextView textview1;
	private TextView buttonText;
	
	private Intent i = new Intent();
	private SharedPreferences settings;
	
	@NonNull
	@Override
	public View onCreateView(@NonNull LayoutInflater _inflater, @Nullable ViewGroup _container, @Nullable Bundle _savedInstanceState) {
		View _view = _inflater.inflate(R.layout.frag5_fragment, _container, false);
		initialize(_savedInstanceState, _view);
		FirebaseApp.initializeApp(getContext());
		initializeLogic();
		return _view;
	}
	
	private void initialize(Bundle _savedInstanceState, View _view) {
		background = _view.findViewById(R.id.background);
		topBG = _view.findViewById(R.id.topBG);
		bottomBG = _view.findViewById(R.id.bottomBG);
		top = _view.findViewById(R.id.top);
		logo = _view.findViewById(R.id.logo);
		bottom = _view.findViewById(R.id.bottom);
		title = _view.findViewById(R.id.title);
		buttonBG = _view.findViewById(R.id.buttonBG);
		linear1 = _view.findViewById(R.id.linear1);
		textview1 = _view.findViewById(R.id.textview1);
		buttonText = _view.findViewById(R.id.buttonText);
		settings = getContext().getSharedPreferences("settings", Activity.MODE_PRIVATE);
		
		buttonBG.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View _view) {
				if (settings.getString("language", "").equals("")) {
					settings.edit().putString("language", "AR").commit();
				}
				if (settings.getString("view", "").equals("")) {
					settings.edit().putString("view", "Mobile").commit();
				}
				if (settings.getString("theme", "").equals("")) {
					settings.edit().putString("theme", "Light").commit();
				}
				settings.edit().putString("activity", "true").commit();
				i.setClass(getContext().getApplicationContext(), CodeActivity.class);
				startActivity(i);
			}
		});
	}
	
	private void initializeLogic() {
	}
	
	@Override
	public void onStart() {
		super.onStart();
		_CR(top, "#008b8b", 0, 0, 100, 0);
		_CR(bottom, "#FFFFFF", 100, 0, 0, 0);
		_CR_SYTStudio(buttonBG, "#008b8b", "#FFFFFF", 25, 25, 25, 25, 0, "#008b8b", 0);
	}
	public void _CR_SYTStudio(final View _view, final String _bgcolor, final String _colorPressed, final double _tl, final double _tr, final double _br, final double _bl, final double _strokeSize, final String _strokeColor, final double _shadow) {
		{
			_view.setClickable(true);
			android.graphics.drawable.GradientDrawable SYT_gd = new android.graphics.drawable.GradientDrawable();
			SYT_gd.setColor(Color.parseColor(_bgcolor));
			SYT_gd.setCornerRadii(new float[]{(int)_tl,(int)_tl,(int)_tr,(int)_tr,(int)_bl,(int)_bl,(int)_br,(int)_br});
			SYT_gd.setStroke((int) _strokeSize,
			Color.parseColor(_strokeColor));
			
			android.graphics.drawable.RippleDrawable SYT_rd = new android.graphics.drawable.RippleDrawable(new android.content.res.ColorStateList(new int[][]{new int[]{}}, new int[]{ Color.parseColor(_colorPressed)}), SYT_gd, null);
			_view.setElevation((int)_shadow);
			_view.setBackground(SYT_rd);
		}
	}
	
	
	public void _CR(final View _view, final String _color, final double _tl, final double _tr, final double _br, final double _bl) {
		android.graphics.drawable.GradientDrawable SYT_gd = new android.graphics.drawable.GradientDrawable();
		SYT_gd.setColor(Color.parseColor(_color));
		SYT_gd.setCornerRadii(new float[]{(int)_tl,(int)_tl,(int)_tr,(int)_tr,(int)_br,(int)_br,(int)_bl,(int)_bl});
		_view.setBackground(SYT_gd);
	}
	
}