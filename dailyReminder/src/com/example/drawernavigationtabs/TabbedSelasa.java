package com.example.drawernavigationtabs;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.BaseExpandableListAdapter;
import android.widget.ExpandableListView;
import android.widget.ListView;
import android.widget.TextView;

public class TabbedSelasa extends Fragment {

	 @Override
	    public View onCreateView(LayoutInflater inflater, ViewGroup container,
	            Bundle savedInstanceState) {
	 
	        View rootView = inflater.inflate(R.layout.fragment_tabbed_selasa, container, false);
	        
	        //now you must initialize your list view
	           ListView listview =(ListView)rootView.findViewById(R.id.listselasa);

	           //EDITED Code 
	           String[] items = new String[] {"Item 1", "Item 2", "Item 3"};
	           ArrayAdapter<String> adapter =
	           new ArrayAdapter<String>(getActivity(), android.R.layout.simple_list_item_1, items); 

	            listview.setAdapter(adapter);  
	         
	        return rootView;
	    }
}