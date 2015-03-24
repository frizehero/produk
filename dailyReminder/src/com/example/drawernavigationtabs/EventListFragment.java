package com.example.drawernavigationtabs;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.webkit.WebView;

public class EventListFragment extends Fragment {

	public final static String TAG = EventListFragment.class.getSimpleName();

	public EventListFragment() {
		// TODO Auto-generated constructor stub
	}

	public static EventListFragment newInstance() {
		return new EventListFragment();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setRetainInstance(true);
	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {
		return inflater.inflate(R.layout.fragment_event_list, container, false);
	}

	@Override
	public void onViewCreated(View view, Bundle savedInstanceState) {
		super.onViewCreated(view, savedInstanceState);
		/*WebView webView = (WebView) view.findViewById(R.id.webView);
		webView.loadUrl("http://www.google.com");*/
	}
}
