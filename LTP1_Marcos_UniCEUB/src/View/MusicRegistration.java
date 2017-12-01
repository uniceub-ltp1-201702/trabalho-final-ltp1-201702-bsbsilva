package View;

import java.io.IOException;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import Control.ArtistControl;
import Model.SimulatedDatabase;

public class MusicRegistration {
	
	//____________________________________________________________ATRIBUTOS

	private String musica;
	private String album;
	private String artista;
	private SimulatedDatabase sDB;
	
	//____________________________________________________________MÉTODO CONSTRUTOR

	public MusicRegistration(SimulatedDatabase sdb) throws IOException {
		sDB = sdb;
	}

	//____________________________________________________________METODOS GET & SET
	
	public String getMusica() {
		return musica;
	}

	public String getAlbum() {
		return album;
	}

	public String getArtista() {
		return artista;
	}

//-----------------------------------------------------------------------------------------------------------------------------------------------------//
	
	public void obterDadosMusica() throws IOException {
		JDialog.setDefaultLookAndFeelDecorated(true);
		this.musica = (JOptionPane.showInputDialog(null, "NOME DA MÚSICA"));
		this.album = (JOptionPane.showInputDialog(null, "NOME DO ALBÚM"));
		this.artista = (JOptionPane.showInputDialog(null, "NOME DO ARTISTA DESTA MÚSICA"));

			ArtistControl ca = new ArtistControl(sDB);
			JOptionPane.showMessageDialog(null, "CADASTRANDO ARTISTA");
			ca.cadastraArtistaMusica(getArtista());
		}

	}
