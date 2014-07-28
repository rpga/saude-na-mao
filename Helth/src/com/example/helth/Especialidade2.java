package com.example.helth;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;

public class Especialidade2 extends Activity {
	private static final String[] CLUBES = new String[]{"Corinthians", "Ceará","Atlético-PR"};  
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_especialidade2);
		
        ArrayAdapter<String> adp = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, CLUBES);
        //AutoCompleteTextView clubes = (AutoCompleteTextView) findViewById(R.id.clubes);
       // clubes.setAdapter(adp);    
	}
}
