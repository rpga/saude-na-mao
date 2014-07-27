package banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;
import android.util.Log;

public class BDCore extends SQLiteOpenHelper {	
	private static final String nome_BD = "Saúde na Mão";
	private static final int versao_BD = 1;	
	private static final String TAG = "QuickNotesMainActivity";
	
	
	public BDCore (Context ctx){
		super(ctx, nome_BD, null, versao_BD);
		Log.d(TAG,"mensagem de debug");
	}
		
	
	@Override
	public void onCreate(SQLiteDatabase bd){
		
		//Criando as tabelas
		bd.execSQL("create table tipo(_id integer primary key autoincrement, nome text not null);");
		bd.execSQL("create table especialidade(_id integer primary key autoincrement, nome text not null);");
		bd.execSQL("create table uds(_id integer primary key autoincrement, " +
				"cod_tipo integer, nome text not null, rua text not null, " +
				"cidade text not null, numero integer, bairro text not null, foreign key(cod_especialidade) references especialidade(_id)," +
				"foreign key(cod_tipo) references tipo(_id);");
		bd.execSQL("create table telefone(_id integer primary key autoincrement, telefone integer primary key autoincrement, foreign key(_id) references uds(_id);");
		bd.execSQL("create table possui(_id integer primary key autoincrement, cod_uds integer primary key autoincrement, foreign key(_id)references especialidade(_id)," +
				"foreign key(cod_uds)references uds(_id);");
				
	}
	@Override
	public void onUpgrade(SQLiteDatabase bd, int oldVersion, int newVersion){
		bd.execSQL("drop table if exists tipo;");
		bd.execSQL("drop table if exists especialidade;");
		bd.execSQL("drop table if exists uds;");
		bd.execSQL("drop table if exists telefone;");
		bd.execSQL("drop table if exists possui;");
		
		onCreate(bd);
	}
}
