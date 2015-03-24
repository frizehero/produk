package com.example.drawernavigationtabs;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Toast;

public class TabbedSenin extends Fragment {

	@Override
	public View onCreateView(LayoutInflater inflater, ViewGroup container,
			Bundle savedInstanceState) {

		View rootView = inflater.inflate(R.layout.fragment_tabbed_senin,
				container, false);

		// now you must initialize your list view
		ListView listview = (ListView) rootView.findViewById(R.id.listsenin);

		// EDITED Code
		String[] items = new String[] { "Item 1", "Item 2", "Item 3", "Item 1",
				"Item 2", "Item 3", "Item 1", "Item 2", "Item 3", "Item 1",
				"Item 2", "Item 3" };
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(getActivity(),
				android.R.layout.simple_list_item_1, items);

		listview.setAdapter(adapter);

		return rootView;
	}

	public AlertDialog showDialog() {
		AlertDialog.Builder builder = new AlertDialog.Builder(getActivity());
		LayoutInflater inflater = getActivity().getLayoutInflater();
		builder.setView(inflater.inflate(R.layout.dialog_main, null));
		builder.setMessage("Alert Dialog")
				.setPositiveButton("Ya", new DialogInterface.OnClickListener() {
					public void onClick(DialogInterface dialog, int id) {
						Toast.makeText(getActivity(), "sukess",
								Toast.LENGTH_LONG).show();
					}
				})
				.setNegativeButton("cancel",
						new DialogInterface.OnClickListener() {
							public void onClick(DialogInterface dialog, int id) {
								Toast.makeText(getActivity(), "sukess",
										Toast.LENGTH_LONG).show();
							}
						});
		// Create the AlertDialog object and return it
		return builder.create();
	}
}