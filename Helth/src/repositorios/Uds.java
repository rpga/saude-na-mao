package repositorios;

public class Uds {
	
	private int id;
	private int cod_tipo;
	private String nome;
	private String rua;
	private String cidade;
	private int numero;
	private String bairro;
	
	public Uds (int id, int cod_tipo, String nome,String rua,String cidade, int numero, String bairro) {
		this.id = id;
		this.cod_tipo = cod_tipo;
		this.nome = nome;
		this.rua = rua;
		this.cidade = cidade;
		this.numero = numero;
		this.bairro = bairro;
	}
	
	public Uds () {
		
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}	
	public int getCod_tipo() {
		return cod_tipo;
	}
	public void setCod_tipo(int cod_tipo) {
		this.cod_tipo = cod_tipo;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	public String getRua() {
		return rua;
	}
	public void setRua(String rua) {
		this.rua = rua;
	}
	public String getCidade() {
		return cidade;
	}
	public void setCidade(String cidade) {
		this.cidade = cidade;
	}
	public int getNumero() {
		return numero;
	}
	public void setNumero(int numero) {
		this.numero = numero;
	}
	public String getBairro() {
		return bairro;
	}
	public void setBairro(String bairro) {
		this.bairro = bairro;
	}
	
	

}
