package com.example.helth;

import hospitaisPorBairro.HospitaisCAm;
import hospitaisPorBairro.HospitaisCDU;

import java.util.ArrayList;
import java.util.HashMap;
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
	
	private String[] lstLocais;
	private ListView lView;
	private EditText eText;
	private ArrayList<String> pesquisa = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_localidade);
		
		lView = (ListView) findViewById(R.id.lView);
		eText = (EditText) findViewById(R.id.eText);
		
		lstLocais = new String [] {"Boa Vista","Casa Amarela","Cidade Universitária",
				"Cordeiro","Curado","Derby","Estância","Graças","Ibura",
				"Imbiribeira","Iputinga","Nova Descoberta","Parnamirim","Santo Amaro" ,
				"Tamarineira", "Tejipió" ,"Torre","Torrões", "Várzea"};
		
		lView.setAdapter(new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, lstLocais));
		
		lView.setOnItemClickListener(new OnItemClickListener() {  
			  
            public void onItemClick(AdapterView<?> adapter, View view,  
                    int posicao, long id) {  
                Intent intent;
                switch(posicao){ 
                case 0: intent = new Intent(getBaseContext(), ListaUDS.class); 
                startActivity(intent); 
                break;
                case 1: intent = new Intent(getBaseContext(), HospitaisCAm.class);
                startActivity(intent); break; 
                case 2: intent = new Intent(getBaseContext(), HospitaisCDU.class); 
                startActivity(intent); 
                break;
                }

                Toast.makeText(Localidade.this,  
                        "Posição Selecionada:" + posicao, Toast.LENGTH_LONG)  
                        .show();  
            }  
        }); 
			
	
		Pesquisar();
		
		eText.addTextChangedListener(new TextWatcher(){
			public void afterTextChanged(Editable arg0){
				
			}
			public void beforeTextChanged(CharSequence arg0, int arg1, int arg2, int arg3){
				
			}
			public void onTextChanged(CharSequence arg0, int arg1, int arg2, int arg3){
				Pesquisar();
				
				lView.setAdapter(new ArrayAdapter<String>(Localidade.this, android.R.layout.simple_list_item_1, pesquisa));
				
			}
		});
	}
		
	public void Pesquisar() {
		int textlength = eText.getText().length();
		pesquisa.clear();

		for (int i = 0; i < lstLocais.length; i++) {
			if (textlength <= lstLocais[i].length()) {
				if (eText
						.getText()
						.toString()
						.equalsIgnoreCase(
								(String) lstLocais[i]
										.subSequence(0, textlength))) {
					pesquisa.add(lstLocais[i]);
				}
			}
		}
	}
	
	@Override
	
	public boolean onCreateOptionsMenu(Menu menu) {
		
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