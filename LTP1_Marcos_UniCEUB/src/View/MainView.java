package View;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

public class MainView {

//-----------------------------------------------------------------------------------------------------------------------------------------------------//
	
	public String getSelected() {
		
		JDialog.setDefaultLookAndFeelDecorated(true);
		Object[] selectionValues = {"Search Music By Name", "Search Music By Letter", 
									"Search Music By Artist", "Insert Artist Music", 
									"Delete Music", "Insert Artist", "Delete Artist"};
		String initialSelection = "Search Music By Name";
		Object selection = JOptionPane.showInputDialog(null, "Choose and option to proceed", "Spotify", 
						   JOptionPane.QUESTION_MESSAGE, null, selectionValues, initialSelection);
		return selection.toString();
	}
}

