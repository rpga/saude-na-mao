package hospitaisPorBairro;

import java.util.ArrayList;

import com.example.helth.R;
import com.example.helth.Sobre;
import com.example.helth.R.id;
import com.example.helth.R.layout;
import com.example.helth.R.menu;

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

public class HospitaisND extends Activity {
	private String[] lstHospitaisND;
	private ListView lView;
	private EditText eText14;
	private ArrayList<String> pesquisa = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_hospitais_nd);
		lView = (ListView) findViewById(R.id.lView);
		eText14 = (EditText) findViewById(R.id.eText14);

		lstHospitaisND = new String[] {"UPA Nova Descoberta - Solano Trindade"};

		lView.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, lstHospitaisND));

		lView.setOnItemClickListener(new OnItemClickListener() {

			public void onItemClick(AdapterView<?> adapter, View view,
					int posicao, long id) {
				Intent intent;
				switch (posicao) {
				case 0:
					intent = new Intent(getBaseContext(), Sobre.class);
					startActivity(intent);
					break;
				}

				Toast.makeText(HospitaisND.this, "Posi��o Selecionada:" + posicao,
						Toast.LENGTH_LONG).show();
			}
		});

		Pesquisar();

		eText14.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable arg0) {

			}

			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {

			}

			public void onTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				Pesquisar();

				lView.setAdapter(new ArrayAdapter<String>(HospitaisND.this,
						android.R.layout.simple_list_item_1, pesquisa));

			}
		});
	}

	public void Pesquisar() {
		int textlength = eText14.getText().length();
		pesquisa.clear();

		for (int i = 0; i < lstHospitaisND.length; i++) {
			if (textlength <= lstHospitaisND[i].length()) {
				if (eText14
						.getText()
						.toString()
						.equalsIgnoreCase(
								(String) lstHospitaisND[i].subSequence(0,
										textlength))) {
					pesquisa.add(lstHospitaisND[i]);
				}
			}
		}
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.hospitais_nd, menu);
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
