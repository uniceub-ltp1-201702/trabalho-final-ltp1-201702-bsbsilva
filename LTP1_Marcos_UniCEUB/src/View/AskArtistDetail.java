package View;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class AskArtistDetail {
	
//-----------------------------------------------------------------------------------------------------------------------------------------------------//
	
	public String getViewSolicitaNomeArtista() {
		JDialog.setDefaultLookAndFeelDecorated(true);
		String nome = JOptionPane.showInputDialog("NOME DO ARTISTA");
		return nome;
	}

//-----------------------------------------------------------------------------------------------------------------------------------------------------//
	
	public String[] getViewSolicitaArtista() {
		JDialog.setDefaultLookAndFeelDecorated(true);
		String[] nome = { JOptionPane.showInputDialog("NOME DO ARTISTA"), JOptionPane.showInputDialog("RG DO ARTISTA")};
//		nome = ";" + JOptionPane.showInputDialog("RG do artista: ");
		return nome;
	}
}
