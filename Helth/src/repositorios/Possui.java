package repositorios;

public class Possui {
	private int id;
	private int cod_uds;
	
	public Possui () {
		
	}
	
	public Possui (int id, int cod_uds) {
		this.id = id;
		this.cod_uds = cod_uds;
	}
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getCod_uds() {
		return cod_uds;
	}
	public void setCod_uds(int cod_uds) {
		this.cod_uds = cod_uds;
	}
	
}
