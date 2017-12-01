package Model;

public class Music {

	//________________________________________________________________ATRIBUTOS
	
	private String nome;
	private String album;
	private String artista;

	//________________________________________________________________METODO CONSTRUTOR
	
	public Music(String nome, String genero, String artista) {
		this.nome = nome;
		this.album = genero;
		this.artista = artista;
	}

	//________________________________________________________________METODOS GET & SET
	
	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getAlbum() {
		return album;
	}

	public void setAlbum(String album) {
		this.album = album;
	}

	public String getArtista() {
		return artista;
	}

	public void setArtista(String artista) {
		this.artista = artista;
	}
}
