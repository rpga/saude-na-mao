package banco;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class BDCore extends SQLiteOpenHelper {
	private static final String nome_BD = "Saúde na Mão";
	private static final int versao_BD = 1;
	
	public BDCore (Context ctx){
		super(ctx, nome_BD, null, versao_BD);
	}
	
	@Override
	public void onCreate(SQLiteDatabase bd){
		bd.execSQL("create table tipo(_id integer primary key autoincrement, nome text not null);");
		bd.execSQL("create table especialidade(_id integer primary key autoincrement, nome text not null);");
		bd.execSQL("create table uds(_id integer primary key autoincrement, " +
				"cod_especialidade integer foreign key, " +
				"cod_tipo integer, nome text not null, rua text not null, " +
				"cidade text not null, numero integer, bairro text not null, foreign key(cod_especialidade) references especialidade(_id)," +
				"foreign key(cod_tipo) references tipo(_id);");
		bd.execSQL("create table telefone(_id integer primary key autoincrement, telefone integer primary key autoincrement, foreign key(_id) references uds(_id);");
		bd.execSQL("create table possui(_id integer primary key autoincrement, cod_uds integer primary key autoincrement, foreign key(_id)references especialidade(_id)," +
				"foreign key(cod_uds)references uds(_id);");
		
	}
	@Override
	public void onUpgrade(SQLiteDatabase bd, int arg1, int arg2){
		bd.execSQL("drop table tipo;");
		bd.execSQL("drop table especialidade;");
		bd.execSQL("drop table uds;");
		bd.execSQL("drop table telefone;");
		bd.execSQL("drop table possui;");
		
		onCreate(bd);
	}
}
