package com.example.helth;

import java.util.List;

import android.content.Context;
import android.database.Cursor;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.CursorAdapter;
import android.widget.TextView;

public class LocalidadeAdapter extends CursorAdapter {
	
	private List nome;
	private TextView text;
	
	public LocalidadeAdapter(Context context, Cursor cursor, List nome){
		super(context, cursor, false);
		this.nome = nome;
	}
	
	@Override
	public View newView(Context context, Cursor cursor, ViewGroup parent) {

		LayoutInflater inflater = (LayoutInflater) context.getSystemService(Context.LAYOUT_INFLATER_SERVICE);
		
		View view = inflater.inflate(R.layout.activity_localidade, parent, false);
		
		text = (TextView) view.findViewById(R.id.textView1);
		
		
		return view;
	}

	@Override
	public void bindView(View view, Context context, Cursor cursor) {
		text.setText(cursor.getString(cursor.getColumnIndex("text")));
		
		

	}

}