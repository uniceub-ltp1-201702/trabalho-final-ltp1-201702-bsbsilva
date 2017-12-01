package View;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class ShowMusicDetail {

	public ShowMusicDetail(String musicas) {
		JDialog.setDefaultLookAndFeelDecorated(true);
		JOptionPane.showMessageDialog(null, musicas);
		new MainView();
	}

}
