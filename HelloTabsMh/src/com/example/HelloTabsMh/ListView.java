package com.example.HelloTabsMh;
import android.app.ListActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AdapterView;

public class ListView extends ListActivity {
    
    
     @Override
    public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

  	String[] countries = getResources().getStringArray(R.array.countries_array);
	setListAdapter(new ArrayAdapter<String>(this, R.layout.list_item, countries));
  	getListView().setTextFilterEnabled(true);
  	
  }
  }


