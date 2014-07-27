package com.example.helth;

import android.app.Activity;
import android.content.Intent;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.SearchView;
import android.widget.SearchView.OnQueryTextListener;
import android.widget.Spinner;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends Activity /*implements AdapterView.OnItemSelectedListener*/ {
	private static final String TAG = "QuickNotesMainActivity";
	
	
	
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
                    
        ImageButton imageButton1 = (ImageButton) findViewById(R.id.imageButton1);    
        imageButton1.setOnClickListener(new View.OnClickListener() {
		    
            @Override
            public void onClick(View v) {
            	Intent intent = new Intent();
                intent.setClass(MainActivity.this,
                      Especialidade.class);

                startActivity(intent);
        		Log.d(TAG,"mensagem de debug");

                //finish();
            }
        });
        
        ImageButton imageButton2 = (ImageButton) findViewById(R.id.imageButton2);
        imageButton2.setOnClickListener(new View.OnClickListener() {
        	
			
			@Override
			public void onClick(View v) {
			Intent intent = new Intent();
			intent.setClass(MainActivity.this, Localidade.class);
			
			startActivity(intent);
			}
		});
        
        ImageButton imageButton3 = (ImageButton) findViewById(R.id.imageButton3);
        imageButton3.setOnClickListener(new View.OnClickListener() {
        	
			
			@Override
			public void onClick(View v) {
			Intent intent = new Intent();
			intent.setClass(MainActivity.this, Hospital.class);
			
			startActivity(intent);
			}
		});
        
        ImageButton imageButton4 = (ImageButton) findViewById(R.id.imageButton4);
        imageButton4.setOnClickListener(new View.OnClickListener() {
        	
			
			@Override
			public void onClick(View v) {
			Intent intent = new Intent();
			intent.setClass(MainActivity.this, Sobre.class);
			
			startActivity(intent);
			}
		});
        /*spinner = (Spinner) findViewById(R.id.spinner1);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.Opcao_Busca, android.R.layout.simple_spinner_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);*/
    }

	@Override
    public boolean onCreateOptionsMenu(Menu menu) {
		super.onCreateOptionsMenu(menu);
		
			SearchView sv = new SearchView(this);
			sv.setOnQueryTextListener (new SearchFiltro());
			
			MenuItem m1 = menu.add(0, 0, 0, "Item 1");
			m1.setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
			m1.setActionView(sv);
			
		
		/* Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        */
		return true;
    }
	
	public class SearchFiltro implements OnQueryTextListener {

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

    //@Override 
    /*public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }


    
	/*@Override
	public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
		TextView myText= (TextView) view;
		Toast.makeText(this, "Buscar por: "+myText.getText(), Toast.LENGTH_SHORT).show();
		
	}


	@Override
	public void onNothingSelected(AdapterView<?> parent) {
		// TODO Auto-generated method stub
		
	}

	public void buscaPor(View view){
		EditText buscaPor = (EditText) findViewById(R.id.editText1);
		
	}*/
	
}
