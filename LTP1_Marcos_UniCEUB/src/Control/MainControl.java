package Control;

import java.io.IOException;

import Model.SimulatedDatabase;
import View.MainView;
import Control.ArtistControl;
import Control.MusicControl;

public class MainControl {

	private SimulatedDatabase bds;
	private MainView vp;

	//____________________________________________________________________METODO CONSTRUTOR
	
	public MainControl() throws IOException {
		
		//________________________________________________________________INSTANCIA O OBJETO DO SimulatedDatabase
		
		this.bds = new SimulatedDatabase();

		//________________________________________________________________INSTANCIA A VIEW
		
		this.vp = new MainView();
		
		triggerOption(this.vp.getSelected());
	}
	
//-----------------------------------------------------------------------------------------------------------------------------------------------------//
	
	public void triggerOption(String selection) throws IOException {
		
		//________________________________________________________________CRIA CONTROLES
		
		MusicControl cm = new MusicControl(bds);
		ArtistControl ca = new ArtistControl(bds);
		
		//________________________________________________________________COMPARA VALOR PEGO NA JANELA DE SELECIONADOS
		
		if(selection.equals("Search Music By Artist"))
			cm.exibeMusicaArtista();
		if(selection.equals("Search Music By Name"))
			cm.exibeMusicaNome();
		if(selection.equals("Search Music By Letter"))
			cm.buscaPorLetra();
		if(selection.equals("Insert Artist Music"))
			cm.cadastraMusica();
		if(selection.equals("Delete Music"))
			cm.excluirMusica();
		if(selection.equals("Insert Artist"))
			ca.cadastraArtista();
		if(selection.equals("Delete Artist"))
			ca.deletaArtista();
	}
}
