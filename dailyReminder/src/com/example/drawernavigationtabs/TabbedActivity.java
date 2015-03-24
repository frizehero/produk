package com.example.drawernavigationtabs;

import java.util.Locale;

import android.animation.AnimatorSet.Builder;
import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentPagerAdapter;
import android.support.v4.view.ViewPager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
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
	SectionsPagerAdapter mSectionsPagerAdapter;
	// FireMissilesDialogFragment dFireMissilesDialogFragment;

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
		mSectionsPagerAdapter = new SectionsPagerAdapter(
				getChildFragmentManager());

		ImageButton buttonFab = (ImageButton) v
				.findViewById(R.id.fab_image_button);
		buttonFab.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View view) {
				System.out.println("tttttttttttttttttttttttttttttttttttt");
//				Toast.makeText(getActivity(), "laki-laki", Toast.LENGTH_SHORT)
//						.show();
				dialog();
			}
		});
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
	
	public void dialog2() {


	}

	public void dialog() {
		AlertDialog.Builder alertDialogBuilderSuccess = new AlertDialog.Builder(
                getActivity());
        alertDialogBuilderSuccess.setTitle("TopUp Success");
        // set dialog message
        alertDialogBuilderSuccess
                .setMessage(
                        "You voucher is printed, please go to the cashier.")
                .setCancelable(false)
                .setPositiveButton("Confirm",
                        new DialogInterface.OnClickListener() {
                            public void onClick(
                                    DialogInterface dialog, int id) {

//                                finish();
                            }
                        });

        // create alert dialog
        final AlertDialog alertDialogSuccess = alertDialogBuilderSuccess.create();
		
		AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(getActivity());
         alertDialogBuilder.setTitle("TopUp Request");
         // set dialog message
         alertDialogBuilder
                 .setMessage("TES")
                 .setCancelable(false)
                 .setPositiveButton("Confirm",
                         new DialogInterface.OnClickListener() {
                             public void onClick(
                                     DialogInterface dialog, int id) {

                                 //calling the second alert when it user press the confirm button
                                 alertDialogSuccess.show();
                             }
                         })
                 .setNegativeButton("Cancel",
                         new DialogInterface.OnClickListener() {
                             public void onClick(
                                     DialogInterface dialog, int id) {
                                 dialog.cancel();
                             }
                         });

         // create alert dialog
         AlertDialog alertDialog = alertDialogBuilder.create();

         // show it
         alertDialog.show();
         
		   
	}
	
	


	
}
