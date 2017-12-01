package Model;

import java.util.ArrayList;

import Util.txtReader;
import Util.txtWriter;

public class SimulatedDatabase {

	//____________________________________________________________________ATRIBUTOS
	
	private ArrayList<Music> musicas;
	private ArrayList<Artist> artistas;
	private String fileMusicas = "musics.txt";
	private String FileArtista = "artists.txt";

	//____________________________________________________________________METODO CONSTRUTOR
	
	public SimulatedDatabase() {

		//________________________________________________________________INSTANCIA ARRAYLISTS
		
		this.artistas = new ArrayList<Artist>();
		this.musicas = new ArrayList<Music>();

		//________________________________________________________________INSTANCIA LEITO DE TXT
		
		txtReader tr1 = new txtReader();
		txtReader tr2 = new txtReader();

		//________________________________________________________________LEITOR DE LINHAS DO ARQUIVO "ARTISTS.TXT"
		
		ArrayList<String> primeiraleitura = tr1.read(FileArtista);

		//________________________________________________________________LEITOR DE LINHAS DO ARQUIVO "MSUCIS.TXT"
		
		ArrayList<String> segundaleitura = tr2.read(fileMusicas);

		//________________________________________________________________PERCORRE O ARRAYLIST CRIANDO ARRAYLIST DE ARTISTAS
		
		for (int i = 0; i < primeiraleitura.size(); i++) {
			
			//____________________________________________________________SEPARA A LINHA DE UM ARRAY DE STRINGS
			
			String[] linhaArtista = primeiraleitura.get(i).split(";");

			//____________________________________________________________CRIA ARTISTA COM OS DADOS PRESENTES NA LINHA
			
			Artist a = new Artist(linhaArtista[0], linhaArtista[1], linhaArtista[2]);

			//____________________________________________________________COLOCA ARTISTA NO ARRAYLIST
			
			this.artistas.add(a);
		}

		//________________________________________________________________PERCORRE O ARRAYLIST CRIANDO LISTA DE MUSICAS
		
		for (int i = 0; i < segundaleitura.size(); i++) {

			//____________________________________________________________SEPARA A LINHA DE UM ARRAY DE STRINGS
			
			String[] linhaMusica = segundaleitura.get(i).split(";");

			//____________________________________________________________CRIA MSUICA COM OS DADOS PRESENTES NA LINHA
			
			Music m = new Music(linhaMusica[0], linhaMusica[1],linhaMusica[2]);

			//____________________________________________________________COLOCA MUSICA NO ARRAYLIST
			
			this.musicas.add(m);
		}
	}

//-----------------------------------------------------------------------------------------------------------------------------------------------------//
	
	public void gravarArtista(Artist a) {
		this.artistas.add(a);

		//________________________________________________________________TRANSFORMA ARTISTA EM STRING
		
		String artista = a.getNome() + ";" + a.getNascionalidade() + ";" + a.getRGToString();

		//________________________________________________________________INSTANCIAR O txtWriter
		
		txtWriter dw = new txtWriter();

		//________________________________________________________________GRAVA ARTISTA NO ARQUIVO "ARTISTS.TXT"
		
		dw.write(FileArtista, artista);
	}

//-----------------------------------------------------------------------------------------------------------------------------------------------------//
	
	public void gravarMusica(Music m) {
		this.musicas.add(m);

		//________________________________________________________________TRANSFORMA ARTISTA EM STRING
		
		String musica = m.getNome() + ";" + m.getAlbum() + ";" + m.getArtista();

		//________________________________________________________________INSTANCIAR O txtWriter
		
		txtWriter dw = new txtWriter();

		//________________________________________________________________GRAVA MUSICA NO ARQUIVO "MUSICS.TXT"
		
		dw.write(fileMusicas, musica);
	}
	
//-----------------------------------------------------------------------------------------------------------------------------------------------------//

	public boolean verificaArtistaExisteTXT(Artist artista) {
		boolean resultado = false;
		for (int i = 0; i < artistas.size(); i++) {
			if (artistas.get(i).getNome().equalsIgnoreCase(artista.getNome()) && artistas.get(i).getNascionalidade().equalsIgnoreCase(artista.getNascionalidade()) ) {
				return resultado = true;
			}
		}
		return resultado;
	}

//-----------------------------------------------------------------------------------------------------------------------------------------------------//

	public boolean verificaMusicaExisteTXT(Music musica) {
		boolean resultado = false;

		for (int i = 0; i < musicas.size(); i++) {
			if ((musicas.get(i).getNome().equalsIgnoreCase(musica.getNome()))
					&& (musicas.get(i).getAlbum().equalsIgnoreCase(musica.getAlbum()))
					&& (musicas.get(i).getArtista().equalsIgnoreCase(musica.getArtista()))) {
				resultado = true;
			}

		}
		return resultado;

	}

	//____________________________________________________________________METODOS GET "ARRAYLISTS"
	
	public ArrayList<Music> getMusicas() {
		return musicas;
	}

	public ArrayList<Artist> getArtistas() {
		return artistas;
	}

}
