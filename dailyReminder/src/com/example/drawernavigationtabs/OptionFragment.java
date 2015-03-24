package com.example.drawernavigationtabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

public class OptionFragment extends Fragment {

	public final static String TAG = OptionFragment.class.getSimpleName();

	public OptionFragment() {
		// TODO Auto-generated constructor stub
	}

	public static OptionFragment newInstance() {
		return new OptionFragment();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.dialog_main, container, false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		/*WebView webView = (WebView) view.findViewById(R.id.webView);
		webView.loadUrl("http://www.google.com");*/
	}
}
