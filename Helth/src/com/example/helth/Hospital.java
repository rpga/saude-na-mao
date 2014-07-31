package com.example.helth;

import java.util.ArrayList;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;
import android.widget.AdapterView.OnItemClickListener;

public class Hospital extends Activity {
	private String[] lstHospitais;
	private ListView lView;
	private EditText eText2;
	private ArrayList<String> pesquisa = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hospital);

		lView = (ListView) findViewById(R.id.lView);
		eText2 = (EditText) findViewById(R.id.eText2);

		lstHospitais = new String[] { "Hospital Agamenon Magalhães",
				"Hospital Barão de Lucena", "Hospital Correia Picanço",
				"Hospital da Restauração", "Hospital das Clínicas",
				"Hospital de Câncer de Pernambuco",
				"Hospital Evangélico de Pernambuco - TEOTEC",
				"Hospital Geral de Areias", "Hospital Getúlio Vargas",
				"Hospital Infantil Maria Lucinda",
				"Hospital Metropolitanco Oeste - Pelópidas Silveira",
				"Hospital Otávio de Freitas",
				"Hospital Psiquiátrico Ulysses Pernambucano",
				"Hospital Universitário Oswaldo Cruz",
				"UPA Caxangá - Escritor Paulo Cavalcanti",
				"UPA Ibura - Pediatra Zilda Ams",
				"UPA Imbiribeira - Maria Esther Souto Carvalho",
				"UPA Nova Descoberta - Solano Trindade",
				"UPA Torrões - Dulce Sampaio" };

		lView.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, lstHospitais));

		lView.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> adapter, View view,
					int posicao, long id) {
				Intent intent;
				switch (posicao) {
				case 0:
					intent = new Intent(getBaseContext(), Sobre.class);
					startActivity(intent);
					break;
				case 1:
					intent = new Intent(getBaseContext(), Sobre.class);
					startActivity(intent);
					break;
				case 2:
					intent = new Intent(getBaseContext(), Sobre.class);
					startActivity(intent);
					break;
				}

				Toast.makeText(Hospital.this, "Posição Selecionada:" + posicao,
						Toast.LENGTH_LONG).show();
			}
		});

		Pesquisar();

		eText2.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable arg0) {

			}

			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {

			}

			public void onTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				Pesquisar();

				lView.setAdapter(new ArrayAdapter<String>(Hospital.this,
						android.R.layout.simple_list_item_1, pesquisa));

			}
		});
	}

	public void Pesquisar() {
		int textlength = eText2.getText().length();
		pesquisa.clear();

		for (int i = 0; i < lstHospitais.length; i++) {
			if (textlength <= lstHospitais[i].length()) {
				if (eText2
						.getText()
						.toString()
						.equalsIgnoreCase(
								(String) lstHospitais[i].subSequence(0,
										textlength))) {
					pesquisa.add(lstHospitais[i]);
				}
			}
		}
	}
}

/*
 * @Override public boolean onCreateOptionsMenu(Menu menu) { // Inflate the
 * menu; this adds items to the action bar if it is present.
 * getMenuInflater().inflate(R.menu.hospital, menu); return true; }
 * 
 * /*@Override public boolean onOptionsItemSelected(MenuItem item) { // Handle
 * action bar item clicks here. The action bar will // automatically handle
 * clicks on the Home/Up button, so long // as you specify a parent activity in
 * AndroidManifest.xml. int id = item.getItemId(); if (id ==
 * R.id.action_settings) { return true; } return
 * super.onOptionsItemSelected(item); }
 */