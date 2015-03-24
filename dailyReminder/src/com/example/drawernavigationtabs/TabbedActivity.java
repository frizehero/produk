package com.example.drawernavigationtabs;

import java.util.Calendar;
import java.util.Locale;

import android.app.AlertDialog;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.TimePicker;
import android.widget.Toast;

public class TabbedActivity extends Fragment {

	/**
	 * The {@link android.support.v4.view.PagerAdapter} that will provide
	 * fragments for each of the sections. We use a
	 * {@link android.support.v4.app.FragmentPagerAdapter} derivative, which
	 * will keep every loaded fragment in memory. If this becomes too memory
	 * intensive, it may be best to switch to a
	 * {@link android.support.v4.app.FragmentStatePagerAdapter}.
	 */
	Button btnCalendar, btnTimePicker;
	SectionsPagerAdapter mSectionsPagerAdapter;
	TextView txtDate, txtTime;
	AddedDaily mAddedDaily;
	private int mYear, mMonth, mDay, mHour, mMinute;
	public static final String TAG = TabbedActivity.class.getSimpleName();

	/**
	 * The {@link ViewPager} that will host the section contents.
	 */
	ViewPager mViewPager;

	public static TabbedActivity newInstance() {
		return new TabbedActivity();
	}

	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);

	}

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View v = inflater.inflate(R.layout.fragment_tabbed, container, false);
		ImageButton buttonFab = (ImageButton) v
				.findViewById(R.id.fab_image_button);
		buttonFab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				System.out.println("tttttttttttttttttttttttttttttttttttt");
				Toast.makeText(getActivity(), "laki-laki", Toast.LENGTH_SHORT)
						.show();
				dialog();
			}
		});
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getChildFragmentManager());

		mViewPager = (ViewPager) v.findViewById(R.id.pager);
		mViewPager.setAdapter(mSectionsPagerAdapter);

		return v;
	}

	/**
	 * A {@link FragmentPagerAdapter} that returns a fragment corresponding to
	 * one of the sections/tabs/pages.
	 */

	public class SectionsPagerAdapter extends FragmentPagerAdapter {

		public SectionsPagerAdapter(FragmentManager fm) {
			super(fm);
		}

		@Override
		public Fragment getItem(int position) {
			switch (position) {
			case 0:
				return new TabbedSenin();
			case 1:
				// Movies fragment activity
				return new TabbedSelasa();
			}

			return null;
		}

		@Override
		public int getCount() {
			// Show 3 total pages.
			return 2;
		}

		@Override
		public CharSequence getPageTitle(int position) {
			Locale l = Locale.getDefault();
			switch (position) {
			case 0:
				return getString(R.string.title_section1).toUpperCase(l);
			case 1:
				return getString(R.string.title_section2).toUpperCase(l);

			}
			return null;
		}
	}

	public void dialog() {
		LayoutInflater factory = LayoutInflater.from(getActivity());
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		final View view = factory.inflate(R.layout.dialog_main, null);
		final EditText baru = (EditText) view.findViewById(R.id.e_title);
		btnCalendar = (Button) view.findViewById(R.id.b_date);
		btnTimePicker = (Button) view.findViewById(R.id.b_time);
		txtDate = (TextView) view.findViewById(R.id.txtDate);
		txtTime = (TextView) view.findViewById(R.id.txtTime);
		btnCalendar.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				// Process to get Current Date
				final Calendar c = Calendar.getInstance();
				mYear = c.get(Calendar.YEAR);
				mMonth = c.get(Calendar.MONTH);
				mDay = c.get(Calendar.DAY_OF_MONTH);

				DatePickerDialog dpd = new DatePickerDialog(getActivity(),
						new DatePickerDialog.OnDateSetListener() {

							@Override
							public void onDateSet(DatePicker view, int year,
									int monthOfYear, int dayOfMonth) {
								// Display Selected date in textbox
								txtDate.setText(dayOfMonth + "-"
										+ (monthOfYear + 1) + "-" + year);

							}
						}, mYear, mMonth, mDay);
				dpd.show();
			}
		});

		btnTimePicker.setOnClickListener(new View.OnClickListener() {

			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				final Calendar c = Calendar.getInstance();
				mHour = c.get(Calendar.HOUR_OF_DAY);
				mMinute = c.get(Calendar.MINUTE);

				// Launch Time Picker Dialog
				TimePickerDialog tpd = new TimePickerDialog(getActivity(),
						new TimePickerDialog.OnTimeSetListener() {

							@Override
							public void onTimeSet(TimePicker view,
									int hourOfDay, int minute) {
								// Display Selected time in textbox
								txtTime.setText(hourOfDay + ":" + minute);
							}
						}, mHour, mMinute, false);
				tpd.show();
			}
		});
		builder.setView(view);
		builder.setTitle("Create Your Reminder")
				.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						Toast.makeText(getActivity(),
								"sukess" + baru.getText().toString(),
								Toast.LENGTH_LONG).show();
					}
				})
				.setNegativeButton("cancel",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								Toast.makeText(getActivity(), "cancel",
										Toast.LENGTH_LONG).show();
							}
						}).show();
		// Create the AlertDialog object and return it
	}
}
