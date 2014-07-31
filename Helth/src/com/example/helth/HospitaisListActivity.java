package com.example.helth;

import java.util.Arrays;
import java.util.List;

import android.app.Activity;
import android.app.ListActivity;
import android.content.DialogInterface.OnClickListener;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

public class HospitaisListActivity extends ListActivity 
										implements OnItemClickListener  {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hospitais_list);
		setListAdapter(new ArrayAdapter<String>(this,
				 android.R.layout.simple_list_item_1, listarGastos()));
				 ListView listView = getListView();
				 listView.setOnItemClickListener(this);
	}
	
	@Override
	 public void onItemClick(AdapterView<?> parent, View view,
	 int position, long id) {
		TextView textView = (TextView) view;
		Toast.makeText(this,"Gasto selecionado: " + textView.getText(),
	 	Toast.LENGTH_SHORT).show();
	 }
	
	private List<String> listarGastos() {
		 return Arrays.asList("Sanduíche R$ 19,90",
		 "Táxi Aeroporto - Hotel R$ 34,00",
		 "Revista R$ 12,00");
		 }
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hospitais_list, menu);
		return true;
	}

	@Override
	public boolean onOptionsItemSelected(MenuItem item) {
		// Handle action bar item clicks here. The action bar will
		// automatically handle clicks on the Home/Up button, so long
		// as you specify a parent activity in AndroidManifest.xml.
		int id = item.getItemId();
		if (id == R.id.action_settings) {
			return true;
		}
		return super.onOptionsItemSelected(item);
	}
}
