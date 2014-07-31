package banco;

import java.util.ArrayList;
import java.util.List;

import repositorios.Especialidade;
import repositorios.Possui;
import repositorios.Telefone;
import repositorios.Tipo;
import repositorios.Uds;
import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

public class BD {
	private SQLiteDatabase bd;
	
	public BD(Context context){
		BDCore auxBd = new BDCore(context);
		bd = auxBd.getWritableDatabase();
	}
	


	//inserindo atributos no banco
	public void povoarTipo () {
		//criando os tipos
		Tipo t1 = new Tipo(1, "Hospital");
		Tipo t2 = new Tipo(2, "UPA");
		Tipo t3 = new Tipo(3, "Clínica");
		
		//Executando o comando de inserir 
		inserir(t1);
		inserir(t2);
	}
	
	public void povoarEspecialidade () {
		Especialidade e1 = new Especialidade(1,"Angiologia");
		Especialidade e2 = new Especialidade(2,"Alergologia");
		Especialidade e3 = new Especialidade(3,"Broncoscopia");
		Especialidade e4 = new Especialidade(4,"Cardiologia");
		Especialidade e5 = new Especialidade(5,"Clínica Médica");
		Especialidade e6 = new Especialidade(6,"Cirurgia");
		Especialidade e7 = new Especialidade(7,"Colposcopia");
		Especialidade e8 = new Especialidade(8,"Endocrinologia");
		Especialidade e9 = new Especialidade(9,"Neurologia");
		Especialidade e10 = new Especialidade(10,"Obstetrícia");
		
		inserir(e1);
		inserir(e2);
		inserir(e3);
		inserir(e4);
		inserir(e5);
		inserir(e6);
		inserir(e7);
		inserir(e8);
		inserir(e9);
		inserir(e10);		
	}
	
	public void povoarUds () {
		Uds u1 = new Uds(1,1, "Hospital Agamenon Magalhãe","Estrada Do Arraial", "Recife",2723,"Casa Amarela");
		Uds u2 = new Uds(2,1,"Hospital Da Restauração","AV. Agamenon Magalhaes", "Recife",0,"Derby");
				
		inserir(u1);
		inserir(u2);
	}
	
	public void povoarPossui() {
		Possui p1 = new Possui(1,3);
		Possui p2 = new Possui(1,4);
		Possui p3 = new Possui(1,5);
		Possui p4 = new Possui(1,6);
		Possui p5 = new Possui(1,7);
		Possui p6 = new Possui(2,3);
		Possui p7 = new Possui(2,5);
		Possui p8 = new Possui(2,10);
		Possui p9 = new Possui(2,6);
		Possui p10 = new Possui(2,8);
		
		inserir(p1);
		inserir(p2);
		inserir(p3);
		inserir(p4);
		inserir(p5);
		inserir(p6);
		inserir(p7);
		inserir(p8);
		inserir(p9);
		inserir(p10);		
	}
	
	public void povoarTelefone () {
		Telefone t1 = new Telefone(1,"31841600");
		Telefone t2 = new Telefone(1,"08002812025");
		Telefone t3 = new Telefone(2,"(81) 3181-5400");
		
		inserir(t1);
		inserir(t2);
		inserir(t3);
	}
	
	public void inserir(Tipo tipo){
		ContentValues valor = new ContentValues();
		valor.put("id", tipo.getId());
		valor.put("nome", tipo.getNome());
		
		bd.insert("tipo", null, valor);
	}
	public void inserir(Especialidade especialidade){
		ContentValues valor = new ContentValues();
		valor.put("id", especialidade.getId());
		valor.put("nome", especialidade.getNome());
		
		bd.insert("especialidade", null, valor);
	}
	public void inserir(Uds uds){ 
		ContentValues valor = new ContentValues();
		valor.put("id", uds.getId());
		valor.put("nome", uds.getNome());
		valor.put("rua", uds.getRua());
		valor.put("cidade", uds.getCidade());
		valor.put("numero", uds.getNumero());
		valor.put("bairro", uds.getBairro());
		
		bd.insert("uds", null,valor);
	}
	public void inserir(Telefone telefone){
		ContentValues valor = new ContentValues();
		valor.put("id", telefone.getId());
		valor.put("telefone", telefone.getTelefone());
		
		bd.insert("telefone", null, valor);
	}
	public void inserir(Possui possui){
		ContentValues valor = new ContentValues();
		valor.put("id", possui.getId());
		valor.put("codigo_uds", possui.getCod_uds());
		
		bd.insert("possui", null, valor);
	}
	//atualizando atributos no banco
	public void atualizar(Tipo tipo){
		ContentValues valor = new ContentValues();
		valor.put("id", tipo.getId());
		valor.put("nome", tipo.getNome());
		
		bd.update("tipo", valor,"_id = ?", new String[]{"" +tipo.getId()});
	}
	
	public void atualizar(Especialidade especialidade){
		ContentValues valor = new ContentValues();
		valor.put("id", especialidade.getId());
		valor.put("nome", especialidade.getNome());
		
		bd.update("especialidade", valor,"_id = ?", new String[]{"" +especialidade.getId()});
	}
	public void atualizar(Uds uds){
		ContentValues valor = new ContentValues();
		valor.put("id", uds.getId());
		valor.put("nome", uds.getNome());
		valor.put("rua", uds.getRua());
		valor.put("cidade", uds.getCidade());
		valor.put("numero", uds.getNumero());
		valor.put("bairro", uds.getBairro());
		
		bd.update("uds", valor,"_id = ?", new String[]{"" +uds.getId()});
	}
	
	public void atualizar(Telefone telefone){
		ContentValues valor = new ContentValues();
		valor.put("id", telefone.getId());
		valor.put("nome", telefone.getTelefone());
		
		bd.update("telefone", valor,"_id = ?", new String[]{"" +telefone.getId()});
	}
	public void atualizar(Possui possui){
		ContentValues valor = new ContentValues();
		valor.put("id", possui.getId());
		valor.put("nome", possui.getCod_uds());
		
		bd.update("tipo", valor,"_id = ?", new String[]{"" +possui.getId()});
	}
	//deletando variaveis no banco
	public void deletar (Tipo tipo){
		bd.delete("tipo", "_id = "+tipo.getId(), null);
	}
	
	public void deletar (Especialidade especialidade){
		bd.delete("especialidade", "_id = "+especialidade.getId(), null);
	}
	public void deletar (Uds uds){
		bd.delete("uds", "_id = "+uds.getId(), null);
	}
	
	public void deletar (Telefone telefone){
		bd.delete("telefone", "_id = "+telefone.getId(), null);
	}
	public void deletar (Possui possui){
		bd.delete("possui", "_id = "+possui.getId(), null);
	}
	
	
	public List<Tipo> buscar(){
		List<Tipo> list = new ArrayList<Tipo>();
		String [] colunas = new String []{"_id", "nome"};
		Cursor cursor = bd.query("tipo", colunas, null, null, null, null, "nome ASC");
		
		if(cursor.getCount() > 0){
			cursor.moveToFirst();
			
			do{
				Tipo t = new Tipo();
				t.setId(cursor.getInt(0));
				t.setNome(cursor.getString(1));
				list.add(t);
				
			}while(cursor.moveToNext());
		}
		return(list);
	}
	
	public List<Especialidade> buscarEsp(){
		List<Especialidade> list = new ArrayList<Especialidade>();
		String [] colunas = new String []{"_id", "nome"};
		Cursor cursor = bd.query("especialidade", colunas, null, null, null, null, "nome ASC");
		
		if(cursor.getCount() > 0){
			cursor.moveToFirst();
			
			do{
				Especialidade e = new Especialidade();
				e.setId(cursor.getInt(0));
				e.setNome(cursor.getString(1));
				list.add(e);
				
			}while(cursor.moveToNext());
		}
		return(list);
	}
	public List<Uds> buscarUds(){
		List<Uds> list = new ArrayList<Uds>();
		String [] colunas = new String []{"_id","cod_tipo","nome","rua", "cidade","numero", "bairro" };
		Cursor cursor = bd.query("uds", colunas, null,null, null, null, "nome ASC");
		
		if(cursor.getCount() > 0){
			cursor.moveToFirst();
			
			do{
				Uds u = new Uds();
				u.setId(cursor.getInt(0));				
				u.setCod_tipo(cursor.getInt(1));
				u.setNome(cursor.getString(2));
				u.setRua(cursor.getString(3));
				u.setCidade(cursor.getString(4));
				u.setNumero(cursor.getInt(5));
				u.setBairro(cursor.getString(6));
				
				list.add(u);
				
			}while(cursor.moveToNext());
		}
		return(list);
	}
	
	public List<Telefone> buscarTel(){
		List<Telefone> list = new ArrayList<Telefone>();
		String [] colunas = new String []{"_id", "telefone"};
		Cursor cursor = bd.query("telefone", colunas, null, null, null, null, "nome ASC");
		
		if(cursor.getCount() > 0){
			cursor.moveToFirst();
			
			do{
				Telefone te = new Telefone();
				te.setId(cursor.getInt(0));
				te.setTelefone(cursor.getString(1));
				list.add(te);
				
			}while(cursor.moveToNext());
		}
		return(list);
	}
	public List<Possui> buscarPossui(){
		List<Possui> list = new ArrayList<Possui>();
		String [] colunas = new String []{"_id", "cod_uds"};
		Cursor cursor = bd.query("possui", colunas, null, null, null, null, "nome ASC");
		
		if(cursor.getCount() > 0){
			cursor.moveToFirst();
			
			do{
				Possui p = new Possui();
				p.setId(cursor.getInt(0));
				p.setCod_uds(cursor.getInt(1));
				list.add(p);
				
			}while(cursor.moveToNext());
		}
		return(list);
	}



	public static Cursor rawQuery(String string, Object object) {
		// TODO Auto-generated method stub
		return null;
	}
}
