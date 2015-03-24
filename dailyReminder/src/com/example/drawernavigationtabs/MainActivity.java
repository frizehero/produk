package com.example.drawernavigationtabs;

import java.util.ArrayList;

import com.example.drawernavigationtabs.adapter.NavDrawerListAdapter;
import com.example.drawernavigationtabs.model.NavDrawerItem;

import android.os.Bundle;
import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.content.res.TypedArray;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.app.FragmentActivity;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;

@SuppressLint("NewApi")
public class MainActivity extends FragmentActivity {

	private static final String TAG = MainActivity.class.getSimpleName();

	private DrawerLayout mDrawerLayout;
	private ListView mDrawerList;
	private ActionBarDrawerToggle mDrawerToggle;

	private CharSequence mDrawerTitle;
	private CharSequence mTitle;
	private String[] mDrawerItmes;
	private TypedArray navMenuIcons;

	private ArrayList<NavDrawerItem> navDrawerItems;
	private NavDrawerListAdapter adapter;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		mTitle = mDrawerTitle = getTitle();

		mDrawerItmes = getResources().getStringArray(R.array.drawer_titles);
		// getting Navigation drawer icons from res
		navMenuIcons = getResources()
				.obtainTypedArray(R.array.nav_drawer_icons);

		mDrawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
		mDrawerList = (ListView) findViewById(R.id.left_drawer);

		// set a custom shadow that overlays the main content when the drawer
		// opens
		mDrawerLayout.setDrawerShadow(R.drawable.drawer_shadow,
				GravityCompat.START);

		navDrawerItems = new ArrayList<NavDrawerItem>();

		// list item in slider at 1 Home daily list details
		navDrawerItems.add(new NavDrawerItem(mDrawerItmes[0], navMenuIcons
				.getResourceId(0, -1)));
		// list item in slider at 2 event list details
		navDrawerItems.add(new NavDrawerItem(mDrawerItmes[1], navMenuIcons
				.getResourceId(1, -1)));
		// list item in slider at 3 option details
		navDrawerItems.add(new NavDrawerItem(mDrawerItmes[2], navMenuIcons
				.getResourceId(2, -1)));
		// Recycle array
		navMenuIcons.recycle();

		// Add items to the ListView
		mDrawerList.setAdapter(new ArrayAdapter<String>(this,
				R.layout.drawer_list_item, mDrawerItmes));
		// Set the OnItemClickListener so something happens when a
		// user clicks on an item.
		mDrawerList.setOnItemClickListener(new DrawerItemClickListener());

		adapter = new NavDrawerListAdapter(getApplicationContext(),
				navDrawerItems);
		mDrawerList.setAdapter(adapter);
		// Enable ActionBar app icon to behave as action to toggle the
		// NavigationDrawer
		getActionBar().setDisplayHomeAsUpEnabled(true);
		getActionBar().setHomeButtonEnabled(true);

		mDrawerToggle = new ActionBarDrawerToggle(this, mDrawerLayout,
				R.drawable.ic_drawer, R.string.drawer_open,
				R.string.drawer_close) {
			public void onDrawerClosed(View view) {
				getActionBar().setTitle(mTitle);
				invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu
			}

			public void onDrawerOpened(View drawerView) {
				getActionBar().setTitle(mDrawerTitle);
				invalidateOptionsMenu(); // creates call to onPrepareOptionsMenu
			}
		};

		mDrawerLayout.setDrawerListener(mDrawerToggle);

		// Set the default content area to item 0
		// when the app opens for the first time
		if (savedInstanceState == null) {
			navigateTo(0);
		}

	}

	/**
	 * Slider menu item click listener
	 * */

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// title/icon
		if (mDrawerToggle.onOptionsItemSelected(item)) {
			return true;
		}
		// Handle action bar actions click
		switch (item.getItemId()) {
		case R.id.action_settings:
			return true;
		default:
			return super.onOptionsItemSelected(item);
		}
	}

	/*
	 * If you do not have any menus, you still need this function in order to
	 * open or close the NavigationDrawer when the user clicking the ActionBar
	 * app icon.
	 */

	/*
	 * When using the ActionBarDrawerToggle, you must call it during
	 * onPostCreate() and onConfigurationChanged()
	 */

	@Override
	protected void onPostCreate(Bundle savedInstanceState) {
		super.onPostCreate(savedInstanceState);
		mDrawerToggle.syncState();
	}

	@Override
	public void onConfigurationChanged(Configuration newConfig) {
		super.onConfigurationChanged(newConfig);
		mDrawerToggle.onConfigurationChanged(newConfig);
	}

	private class DrawerItemClickListener implements OnItemClickListener {
		@Override
		public void onItemClick(AdapterView<?> parent, View view, int position,
				long id) {
			navigateTo(position);
		}
	}

	private void navigateTo(int position) {

		switch (position) {
		case 0:
			getSupportFragmentManager()
					.beginTransaction()
					.replace(R.id.content_frame, TabbedActivity.newInstance(),
							TabbedActivity.TAG).commit();
			mDrawerList.setItemChecked(position, true);
			mDrawerList.setSelection(position);
			setTitle(mDrawerItmes[position]);
			mDrawerLayout.closeDrawer(mDrawerList);
			break;
		case 1:
			getSupportFragmentManager()
					.beginTransaction()
					.replace(R.id.content_frame,
							EventListFragment.newInstance(),
							EventListFragment.TAG).commit();
			mDrawerList.setItemChecked(position, true);
			mDrawerList.setSelection(position);
			setTitle(mDrawerItmes[position]);
			mDrawerLayout.closeDrawer(mDrawerList);
			break;
		case 2:
			getSupportFragmentManager()
					.beginTransaction()
					.replace(R.id.content_frame, OptionFragment.newInstance(),
							EventListFragment.TAG).commit();
			mDrawerList.setItemChecked(position, true);
			mDrawerList.setSelection(position);
			setTitle(mDrawerItmes[position]);
			mDrawerLayout.closeDrawer(mDrawerList);
		}

		mDrawerLayout.closeDrawer(mDrawerList);
	}

	@Override
	public void setTitle(CharSequence title) {
		mTitle = title;
		getActionBar().setTitle(mTitle);
	}

}
