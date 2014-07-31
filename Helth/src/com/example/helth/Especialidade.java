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

public class Especialidade extends Activity {
	private String[] lstEspecialidades;
	private ListView lView;
	private EditText eText3;
	private ArrayList<String> pesquisa = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_especialidade);
		lView = (ListView) findViewById(R.id.lView);
		eText3 = (EditText) findViewById(R.id.eText3);

		lstEspecialidades = new String[] { "Acupuntura", "Alergologia",
				"Angiologia", "Broncoscopia", "Cardiologia", "Clínica Médica",
				"Cirurgia Bucomaxilofacial", "Cirurgia Plástica",
				"Cirurgia Geral", "Cirurgia Traumato-Ortopédica",
				"Cirurgia Toráxica", "Cirurgia Vascular", "Colposcopia",
				"Dermatologia", "Endocrinologia", "Espirometria",
				"Esquitossomose", "Fibromialgia", "Fisioterapia",
				"Fisioterapia Urológica", "Fonoaudiologia",
				"Gastroenterologia", "Geriatria", "Ginecologia",
				"Hansenologia", "Hebiatria", "Hematologia", "Hepatologia",
				"Homeopatia", "Infectologia", "Mastologia", "Nefrologia",
				"Neurocirurgia", "Neurologia", "Nutrição", "Obstetrícia",
				"Odontologia", "Oftalmologia", "Oncoginecologia", "Oncologia",
				"Ortopedia", "Otorrinolaringologia", "Pediatria", "Pélvis",
				"Pneumologia", "Proctologia", "Psicologia", "Psiquiatria",
				"Quimioterapia", "Radiologia", "Renal Crônico", "Reumatologia",
				"Saúde Mental", "Terapia Ocupacional", "Tisiologia",
				"Traumato-Ortopedia", "Urologia", "Vascular" };

		lView.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, lstEspecialidades));

		lView.setOnItemClickListener(new OnItemClickListener() {
			//Criar Activity pra cada especialidade e na outra list view colocar os hospitais q tem essa especialidade
			
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

				Toast.makeText(Especialidade.this,
						"Posição Selecionada:" + posicao, Toast.LENGTH_LONG)
						.show();
			}
		});

		Pesquisar();

		eText3.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable arg0) {

			}

			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {

			}

			public void onTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				Pesquisar();

				lView.setAdapter(new ArrayAdapter<String>(Especialidade.this,
						android.R.layout.simple_list_item_1, pesquisa));

			}
		});
	}

	public void Pesquisar() {
		int textlength = eText3.getText().length();
		pesquisa.clear();

		for (int i = 0; i < lstEspecialidades.length; i++) {
			if (textlength <= lstEspecialidades[i].length()) {
				if (eText3
						.getText()
						.toString()
						.equalsIgnoreCase(
								(String) lstEspecialidades[i].subSequence(0,
										textlength))) {
					pesquisa.add(lstEspecialidades[i]);
				}
			}
		}
	}

	/*
	 * @Override public boolean onCreateOptionsMenu(Menu menu) { // Inflate the
	 * menu; this adds items to the action bar if it is present. return true; }
	 * 
	 * //@Override public boolean onOptionsItemSelected(MenuItem item) { //
	 * Handle action bar item clicks here. The action bar will // automatically
	 * handle clicks on the Home/Up button, so long // as you specify a parent
	 * activity in AndroidManifest.xml. int id = item.getItemId(); if (id ==
	 * R.id.action_settings) { return true; } return
	 * super.onOptionsItemSelected(item); }
	 */

}
