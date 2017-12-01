package Control;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import Model.Artist;
import Model.SimulatedDatabase;
import View.ArtistRegistration;
import View.AskArtistDetail;

public class ArtistControl {
	
	//____________________________________________________________________ATRIBUTOS
	
	private SimulatedDatabase bds;
	
	//____________________________________________________________________MÉTODO CONSTRUTOR
	
	public ArtistControl(SimulatedDatabase bds) {
		this.bds = bds;
	}
	
//-----------------------------------------------------------------------------------------------------------------------------------------------------//

	public void cadastraArtista() {

		//________________________________________________________________INSTANCIA A CLASSE VIEW
		
		ArtistRegistration vca = new ArtistRegistration();

		//________________________________________________________________CHAMA O METODO QUE ARMAZENOU OS DADOS DO USUARIO
		
		vca.recuperarDadosArtista();

		//__________________________________________________________INSTANCIAR UM OBJETO DA CLASSE ARTISTA NO "ARTISTA.TXT"
		
		Artist incluir = new Artist(vca.getNome(), vca.getNascionalidade(), vca.getRG());

		if (bds.verificaArtistaExisteTXT(incluir)) {//____________________SE O MÉTODO RETORNAR UM VALOR "TRUE" ENTAO:
			JOptionPane.showMessageDialog(null, "Artista existente no banco de dados");
		} else {//_____________________________________SENÃO... OU SEJA, QUANDO O MÉTODO "testaArtistaExiste()" RETORNAR UM VALOR "FALSE"!
			bds.gravarArtista(incluir);//_________________________________GRAVAR NO "ARTISTA.TXT"
			JOptionPane.showMessageDialog(null, "Artista cadastrado com sucesso");
		}
	}
	
//----------------------------------------------------------------------------------------------------------//
	
	public void cadastraArtistaMusica(String nomeArt) {

		//________________________________________________________________INSTANCIA A CLASSE VIEW
		
		ArtistRegistration vca = new ArtistRegistration();

		//________________________________________________________________CHAMA O METODO QUE ARMAZENOU OS DADOS DO USUARIO
		
		vca.recuperarDadosArtistaMusica(nomeArt);//_______________________ESSE MÉTODO CRIA [2] "JOptionPane" EM VEZ DE [3] POIS O "nomeArt" JÁ INSERE O NOME DO ARTISTA

		//________________________________________________________________INSTANCIAR UM OBJETO DA CLASSE ARTISTA NO "ARTISTA.TXT"
		
		Artist incluir = new Artist(vca.getNome(), vca.getNascionalidade(), vca.getRG());

		if (bds.verificaArtistaExisteTXT(incluir)) {
			JOptionPane.showMessageDialog(null, "Artista existente no banco de dados");
		} else {
			bds.gravarArtista(incluir);
			JOptionPane.showMessageDialog(null, "Artista cadastrado com sucesso");
		}
	}
	
//-----------------------------------------------------------------------------------------------------------------------------------------------------//
	
	public void deletaArtista() throws IOException {

		//________________________________________________________________CRIA A VARIÁVEL E INICIALIZA COM O NOME DO ARQUIVO
		
		String FileName = "artists.txt";

		//________________________________________________________________RECUPERA VALORES DO ARRAYLIST CRIADO LA NO BD, ESSE QUE PEGOU OS VALORES DO "ARTISTA.TXT"
		
		ArrayList<Artist> artista = bds.getArtistas();

		//________________________________________________________________INSTANCIA A VIEW
		
		AskArtistDetail sn = new AskArtistDetail();
		
		//________________________________________________________________RECUPERA ARRAY([0], [1]) = ARRAY(NOME, RG) INSERIDA PELO USUÁRIO
		
		String[] artistAsk = sn.getViewSolicitaArtista();
		
		//________________________________________________________________PEGA VALOR DA POSIÇÃO "[0]" NA ARRAY EQUIVALENTE AO NOME
		
		String nome = artistAsk[0];
		
		//________________________________________________________________PEGA VALOR DA POSIÇÃO "[1]" NA ARRAY EQUIVALENTE AO RG
		
		String RG = artistAsk[1];

		//________________________________________________________________PERCORRE ARRAYLIST
		
		for (int i = 0; i < artista.size(); i++) {
			
			//____________________________________________________________COMPARA NOME E RG PASSADOS PELO USUÁRIO COM OS EXISTENTES NO "ARTISTA.TXT"
			
			if (artista.get(i).getNome().equalsIgnoreCase(nome) && artista.get(i).getRGToString().equalsIgnoreCase(RG)) {
				artista.remove(i);//______________________________________SE ENCONTRADO, REMOVE OS DADOS PRESENTES NA LINHA "X" DO "ARTISTA.TXT"
			}
		}

		String listaArtista = "";
		
		//________________________________________________________________GRAVA ARQUIVO ATUALIZADO
		
		for (int i = 0; i < artista.size(); i++) {

			if (i == (artista.size() - 1)) {
				
				//________________________________________________________TRANSFORMA O ARRAY EM STRING
				
				listaArtista += artista.get(i).getNome() + ";" + artista.get(i).getNascionalidade() + ";"
						+ artista.get(i).getRGToString();

			} else {
				
				//________________________________________________________TRANSFORMA O ARRAY EM STRING
				
				listaArtista += artista.get(i).getNome() + ";" + artista.get(i).getNascionalidade() + ";"
						+ artista.get(i).getRGToString() + "\n";
			}
		}

		FileWriter fw = new FileWriter(FileName, false);
		PrintWriter pw = new PrintWriter(fw);
		pw.println(listaArtista);
		pw.close();

		JDialog.setDefaultLookAndFeelDecorated(true);
		JOptionPane.showMessageDialog(null, "Artista foi excluido da lista com Exito!");
	}
}
