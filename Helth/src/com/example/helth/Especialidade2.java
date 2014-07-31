package com.example.helth;

import android.app.Activity;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.SimpleCursorAdapter;
import android.widget.TextView;

public class Especialidade2 extends Activity {
	TextView textBairro;	
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_especialidade2);
		
        AutoCompleteTextView CompleteCliente = (AutoCompleteTextView)findViewById(R.id.autoCompleteEspecialidade);
        
		
       /* SQLiteDatabase db = openOrCreateDatabase("Saude",Context.MODE_PRIVATE,null);
        * Cursor cursorEspecialidade = db.rawQuery("SELECT DISTINCT bairro, rowid _id FROM uds ORDER BY bairro ASC",null);
        
        String[] fromEspecialidade = {"bairro","_id"};
        int[] to = {R.id.textBairro, R.id.textId};
        
        SimpleCursorAdapter ad1 = new SimpleCursorAdapter(getBaseContext(), R.layout.especilialidade_layout , cursorEspecialidade, fromEspecialidade, to,0);
        CompleteCliente.setAdapter(ad1);   */     
	}
}
