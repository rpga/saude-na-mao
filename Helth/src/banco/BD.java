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
		String [] colunas = new String []{"_id","cod_especialidade", "cod_tipo","nome","rua", "cidade","numero", "bairro" };
		Cursor cursor = bd.query("uds", colunas, null,null, null, null, "nome ASC");
		
		if(cursor.getCount() > 0){
			cursor.moveToFirst();
			
			do{
				Uds u = new Uds();
				u.setId(cursor.getInt(0));
				u.setCod_especialidade(cursor.getInt(1));
				u.setCod_tipo(cursor.getInt(2));
				u.setNome(cursor.getString(3));
				u.setRua(cursor.getString(4));
				u.setCidade(cursor.getString(5));
				u.setNumero(cursor.getInt(6));
				u.setBairro(cursor.getString(7));
				
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
				te.setTelefone(cursor.getInt(1));
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
}
