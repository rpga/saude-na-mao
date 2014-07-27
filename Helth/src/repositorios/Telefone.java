package repositorios;

public class Telefone {
	private int id;
	private String telefone;
	
	public Telefone (int id, String numero) {
		this.id = id;
		this.telefone = numero;
	}
	
	public Telefone () {
		
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTelefone() {
		return telefone;
	}
	public void setTelefone(String telefone) {
		this.telefone = telefone;
	}
}
