package Model;

public class Artist {
	
	//________________________________________________________________ATRIBUTOS
	
	private String nome;
	private String nascionalidade;
	private int RG;

	//________________________________________________________________METODO CONSTRUTOR
	
	public Artist(String nome, String RG) {
		this.nome = nome;
		this.RG = Integer.parseInt(RG);
	}
	
	public Artist(String nome, String nascionalidade, String RG) {
		this.nome = nome;
		this.nascionalidade = nascionalidade;
		this.RG = Integer.parseInt(RG);//_____________________________TRANSFORMA DE STRING PARA INTEIRO
	}

	//________________________________________________________________METODOS GET & SET
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getNascionalidade() {
		return nascionalidade;
	}

	public void setNascionalidade(String nascionalidade) {
		this.nascionalidade = nascionalidade;
	}

	public String getRGToString() {
		return Integer.toString(RG);//________________________________TRANSFORMA DE INTEIRO PARA STRING
	}

	public void setRGToInt(String RG) {
		this.RG = Integer.parseInt(RG);//_____________________________TRANSFORMA DE STRING PARA INTEIRO
	}
}
