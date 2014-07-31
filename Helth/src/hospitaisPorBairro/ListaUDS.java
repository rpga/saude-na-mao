package hospitaisPorBairro;

import java.util.ArrayList;

import com.example.helth.R;
import com.example.helth.Sobre;
import com.example.helth.R.id;
import com.example.helth.R.layout;

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
//Hospitais Boa Vista
public class ListaUDS extends Activity {
	private String[] lstHospitaisBV;
	private ListView lView;
	private EditText eText4;
	private ArrayList<String> pesquisa = new ArrayList<String>();

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_lista_uds);

		lView = (ListView) findViewById(R.id.lView);
		eText4 = (EditText) findViewById(R.id.eText4);

		lstHospitaisBV = new String[] { "Hospital Universitário Oswaldo Cruz" };

		lView.setAdapter(new ArrayAdapter<String>(this,
				android.R.layout.simple_list_item_1, lstHospitaisBV));

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
				Toast.makeText(ListaUDS.this, "Posição Selecionada:" + posicao,
						Toast.LENGTH_LONG).show();
			}
		});

		Pesquisar();

		eText4.addTextChangedListener(new TextWatcher() {
			public void afterTextChanged(Editable arg0) {

			}

			public void beforeTextChanged(CharSequence arg0, int arg1,
					int arg2, int arg3) {

			}

			public void onTextChanged(CharSequence arg0, int arg1, int arg2,
					int arg3) {
				Pesquisar();

				lView.setAdapter(new ArrayAdapter<String>(ListaUDS.this,
						android.R.layout.simple_list_item_1, pesquisa));

			}
		});
	}

	public void Pesquisar() {
		int textlength = eText4.getText().length();
		pesquisa.clear();

		for (int i = 0; i < lstHospitaisBV.length; i++) {
			if (textlength <= lstHospitaisBV[i].length()) {
				if (eText4
						.getText()
						.toString()
						.equalsIgnoreCase(
								(String) lstHospitaisBV[i].subSequence(0,
										textlength))) {
					pesquisa.add(lstHospitaisBV[i]);
				}
			}
		}
	}
}


