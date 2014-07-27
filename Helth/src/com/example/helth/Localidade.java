package com.example.helth;

import com.example.helth.MainActivity.SearchFiltro;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;

public class Localidade extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_localidade);
		ListView listView = (ListView) findViewById(R.id.lv);
		setTextFilterEnable(true);
	/*
		String [] localidades = new String [] {
			"Dois Unidos", "Boa Viagem", "Alto da Favela"
		};
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, localidades);
		
		ListView lv= (ListView) findViewById(R.id.lv);
		lv.setAdapter(adapter);
		lv.setOnItemClickListener(chamaLocalidades());*/
	}
	
	public OnItemClickListener chamaLocalidades(){
		return(new OnItemClickListener(){
			
			@Override
			public void onItemClick(AdapterView<?> ld, View v,int position, long id) {
				Intent intent;
				switch(position){
					case 0:
						intent = new Intent(getBaseContext(), Hospital.class);
						startActivity(intent);
						break;
					case 1:
						intent = new Intent(getBaseContext(), Hospital.class);
						startActivity(intent);
						break;
					case 2:
						intent = new Intent(getBaseContext(), Hospital.class);
						startActivity(intent);
						break;
				
				}
				
			}
			
		});
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		SearchView sv = new SearchView(this);
		sv.setOnQueryTextListener (new SearchFiltro());
		
		MenuItem m1 = menu.add(0, 0, 0, "Item 1");
		m1.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
		m1.setActionView(sv);
		
		
		return true;
	}

	private class SearchFiltro implements OnQueryTextListener {

		@Override
		
		public boolean onQueryTextSubmit(String query) {
			Log.i("Script", "onQueryTextSubmit -> "+query);
			return false;
		}

		@Override
		public boolean onQueryTextChange(String newText) {
			Log.i("Script", "onQueryTextChange -> "+newText);
			return false;
		}
		
	}


	/*@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}*/
}
