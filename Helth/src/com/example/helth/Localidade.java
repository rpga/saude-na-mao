package com.example.helth;

import java.util.ArrayList;
import java.util.List;

import repositorios.Uds;

import banco.BD;

import android.annotation.TargetApi;
import android.app.Activity;
import android.app.SearchManager;
import android.content.Context;
import android.content.Intent;
import android.database.MatrixCursor;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.view.MenuItemCompat;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.AdapterView.OnItemClickListener;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;
import android.widget.SearchView.OnQueryTextListener;

public class Localidade extends Activity {
	//private ListViewAdapter adapter;
	//BD bd = new BD();
	//private List<Uds> nome = bd.buscarUds();
	private Menu menu;
	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_localidade);
		 
		/*ArrayList<ListViewObjetos> itens = new ArrayList<ListViewObjetos>();
	        for (int i = 0; i < 100; i++) {
	            itens.add(new ListViewObjetos(i, "descricao+" + i, "R$" + i + ",00"));
	        }
		String [] localidades = new String [] {
				"Dois Unidos", "Boa Viagem", "Alto da Favela"
			};
		
		adapter = new ListViewAdapter(this, localidades);
		ListView lv = (ListView) findViewById(R.id.lv);
		lv.setAdapter(adapter);
		*/
		/*EditText editText = (EditText) findViewById(R.id.editText1);
		editText.addTextChangedListener(new TextWatcher(){
		
		@Override
		public void onTextChanged(CharSequence s, int start, int before, int count){
			adapter.getFilter().filter(s.toString());
		}
		@Override
        public void beforeTextChanged(CharSequence s, int start, int count,
                int after) {
        }

        @Override
        public void afterTextChanged(Editable s) {
        }
		
		});
		}
		
		/*ListView listView = (ListView) findViewById(R.id.lv);
		
	
		
		
		ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, localidades);
		
		ListView lv= (ListView) findViewById(R.id.lv);
		lv.setAdapter(adapter);
		lv.setOnItemClickListener(chamaLocalidades());
	*/
}
	/*public OnItemClickListener chamaLocalidades(){
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
	}*/
	
	
	}