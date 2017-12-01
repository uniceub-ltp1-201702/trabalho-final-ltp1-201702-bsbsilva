package View;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class AskMusicDetail {

//-----------------------------------------------------------------------------------------------------------------------------------------------------//
	
	public String getViewSolicitaMusica() {
		JDialog.setDefaultLookAndFeelDecorated(true);
		String nome = JOptionPane.showInputDialog("NOME DA MÚSICA");
		return nome;
	}
}
