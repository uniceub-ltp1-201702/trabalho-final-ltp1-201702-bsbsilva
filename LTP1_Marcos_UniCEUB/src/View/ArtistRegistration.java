package View;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class ArtistRegistration {
	
	private String nome;
	private String RG;
	private String nascionalidade;
	
	//___________________________________________________MÉTODOS GET
	
	public String getNome() {
		return nome;
	}
	public String getNascionalidade() {
		return nascionalidade;
	}
	public String getRG() {
		return RG;
	}
	
//-----------------------------------------------------------------------------------------------------------------------------------------------------//
	
	public void recuperarDadosArtista() {
		JDialog.setDefaultLookAndFeelDecorated(true);
		this.nome = JOptionPane.showInputDialog(null, "NOME DO ARTISTA");
		this.nascionalidade = JOptionPane.showInputDialog(null, "NASCIONALIDADE DO ARTISTA");
		this.RG = JOptionPane.showInputDialog(null, "RG DO ARTISTA");
	}
	
//-----------------------------------------------------------------------------------------------------------------------------------------------------//
	
	public void recuperarDadosArtistaMusica(String nome) {
		JDialog.setDefaultLookAndFeelDecorated(true);
		this.nome = nome;
		this.nascionalidade = JOptionPane.showInputDialog(null, "NASCIONALIDADE DO ARTISTA");
		this.RG = JOptionPane.showInputDialog(null, "RG DO ARTISTA");
	}
}
