package View;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class AskMusicWord {

//-----------------------------------------------------------------------------------------------------------------------------------------------------//
	
	public String getViewSolicitaLetra() {
		JDialog.setDefaultLookAndFeelDecorated(true);
		String letra = JOptionPane.showInputDialog("LETRA PARA PESQUISA");
		return letra;
	}
}
