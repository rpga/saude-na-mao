package com.example.helth;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import banco.BDCore;

import android.app.Activity;
import android.app.ListActivity;
import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
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

public class LocalidadeListActivity extends ListActivity 
implements OnItemClickListener {
	BDCore auxBD;
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_localidade_list);
		
		setListAdapter(new ArrayAdapter<Map<String, Object>>(this,android.R.layout.simple_list_item_1, listarBairros()));	
		ListView listView = getListView();
		listView.setOnItemClickListener(this);	
	}
	
	private List<Map<String, Object>> listarBairros() {
		SQLiteDatabase bd = auxBD.getReadableDatabase();
		Cursor cursor =bd.rawQuery("SELECT _id, nome, rua, bairro, cidade, numero  FROM uds",null);
		
		cursor.moveToFirst();
		
		ArrayList<Map<String, Object>> hospitais = new ArrayList<Map<String,Object>>();
		
		for (int i=0; i<cursor.getCount(); i++) {
			Map<String, Object> item = new HashMap<String, Object>();
			String id = cursor.getString(0);
			String nome =cursor.getString(1);
			String rua = cursor.getString(2);
			String bairro = cursor.getString(3);			
			String cidade= cursor.getString(4);
			int numero = cursor.getInt(5);
			
			item.put("_id",id);
			item.put("nome",nome);
			item.put("rua",rua);
			item.put("bairro",bairro);
			item.put("cidade",cidade);
			item.put("numero",numero);
			
			hospitais.add(item);
			cursor.moveToNext();			
		}
		cursor.close();
		
		return hospitais;
		
	}
	
	@Override
	public void onItemClick(AdapterView<?> parent, View view, int position,
	long id) {
	TextView textView = (TextView) view;
	String mensagem = "Viagem selecionada: " + textView.getText();
	Toast.makeText(getApplicationContext(), mensagem,
	Toast.LENGTH_SHORT).show();
	startActivity(new Intent(this, HospitaisListActivity.class));
	}
	
	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.localidade_list, menu);
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
