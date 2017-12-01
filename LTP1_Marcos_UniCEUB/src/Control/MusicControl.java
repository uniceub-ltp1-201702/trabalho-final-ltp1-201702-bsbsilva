package Control;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.swing.JDialog;
import javax.swing.JOptionPane;

import Model.SimulatedDatabase;
import Model.Music;
import View.MusicRegistration;
import View.ShowMusicDetail;
import View.AskArtistDetail;
import View.AskMusicWord;
import View.AskMusicDetail;

public class MusicControl {
	
	//____________________________________________________________________ATRIBUTOS
	
	private SimulatedDatabase bds;
	
	public MusicControl(SimulatedDatabase bds) {
		this.bds = bds;
	}
	
//-----------------------------------------------------------------------------------------------------------------------------------------------------//
	
	public void exibeMusicaArtista() {

		//________________________________________________________________RECUPERA A UMA LISTA COM TODAS AS MUSICAS PRESENTES NO "MUSICS.TXT"
		
		ArrayList<Music> musicas = this.bds.getMusicas();

		//________________________________________________________________INSTANCIA A CLASSE VIEW
		
		AskArtistDetail sa = new AskArtistDetail();

		//________________________________________________________________RECUPERA O NOME DO ARTISTA INSERIDO PELO USUÁRIO
		
		String nome = sa.getViewSolicitaNomeArtista();

		String a = "Artista: " + nome + "\n";
		for (int i = 0; i < musicas.size(); i++) {
			if (musicas.get(i).getArtista().equalsIgnoreCase(nome)) {
				a += "_____________________________\n" + 
			    musicas.get(i).getNome() + "\n" + 
				musicas.get(i).getAlbum() + "\n";
			}
		}
		new ShowMusicDetail(a);
	}
	
//-----------------------------------------------------------------------------------------------------------------------------------------------------//
	
	public void exibeMusicaNome() {

		//________________________________________________________________RECUPERA TODAS AS MÚSICAS
		
		ArrayList<Music> musicas = this.bds.getMusicas();

		//________________________________________________________________INSTANCIA A CLASSE VIEW View
		
		AskMusicDetail sn = new AskMusicDetail();

		//________________________________________________________________RECUPERA NOME DIGITADO PELO USUÁRIO
		
		String nome = sn.getViewSolicitaMusica();
		
		//________________________________________________________________CRIA A "STRING = CONCATENAÇÃO DE STRINGS PROCESSADAS PELO [for]" QUE SERÁ EXIBIDA PARA O USUÁRIO 

		String a = "\t" + "Música: " + nome + "\n";
		for (int i = 0; i < musicas.size(); i++) {//______________________PERCORRE TODA A ARRAYLIST DE "musicas" E CRIA UMA CONCATENAÇÃO DE STRINGS A SER EXIBIDA PARA O USUÁRIO 
			if (musicas.get(i).getNome().equalsIgnoreCase(nome)) {
				a += "_____________________________\n" + musicas.get(i).getArtista() + "\n" + musicas.get(i).getAlbum() + "\n";
			}
		}
		new ShowMusicDetail(a);//_________________________________________CHAMA A VIEW, ONDE CRIARA A JANELA "JOptionPane" QUE VAI RECEBER A STRING CRIADA PELO "for"
	}
	
//-----------------------------------------------------------------------------------------------------------------------------------------------------//
	
	public void buscaPorLetra() {

		//________________________________________________________________RECUPERA A ARRAYLIST DE MUSICAS CRIADAS APARTIR DO "MUSICS.TXT"
		
		ArrayList<Music> musicas = bds.getMusicas();

		//________________________________________________________________INSTANCIA A CLASSE VIEW
		
		AskMusicWord sn = new AskMusicWord();

		//________________________________________________________________RECUPERA PALAVRA PASSADA PELO USUÁRIO
		
		String nome = sn.getViewSolicitaLetra();

		//________________________________________________________________ARMAZENA APENAS A PRIMEIRA LETRA PASSADA PELO USUÁRIO
		
		String letra = nome.substring(0, 1);
		
		//________________________________________________________________CRIA A "STRING = CONCATENAÇÃO DE STRINGS PROCESSADAS PELO [for]" QUE SERÁ EXIBIDA PARA O USUÁRIO 

		String a = "\t" + "Musicas com a Letra '" + letra + "'\n";
		for (int i = 0; i < musicas.size(); i++) {

			if (musicas.get(i).getNome().toLowerCase().contains(letra) || musicas.get(i).getNome().toUpperCase().contains(letra)) {
				a += "_____________________________\n" + musicas.get(i).getNome() + "\n" 
			    + musicas.get(i).getAlbum() + "\n" + "\n" + musicas.get(i).getArtista() + "\n";
			}
		}
		new ShowMusicDetail(a);
	}
	
//-----------------------------------------------------------------------------------------------------------------------------------------------------//
	
	public void cadastraMusica() throws IOException {

		//________________________________________________________________INSTANCIA A VIEW
		
		MusicRegistration vcm = new MusicRegistration(bds);

		//________________________________________________________________CHAMA O METODO PARA OBTER OS DADOS
		
		vcm.obterDadosMusica();

		//________________________________________________________________INSTANCIA UM OBJETO DO TIPO "Music"

		Music incluir = new Music(vcm.getMusica(), vcm.getAlbum(), vcm.getArtista());

		if (bds.verificaMusicaExisteTXT(incluir)) {
			JOptionPane.showMessageDialog(null, "Musica já exite no banco de dados");
		} else {
			bds.gravarMusica(incluir);
			JOptionPane.showMessageDialog(null, "Música incluida com sucesso");
		}

	}
	
//-----------------------------------------------------------------------------------------------------------------------------------------------------//
	
	public void excluirMusica() throws IOException {

		//________________________________________________________________CRIA VARIÁVEL COM O NOME DO ARQUIVO A SER LIDO
		
		String FileName = "musics.txt";

		//________________________________________________________________RECUPERA VALORES DO ARRAYLIST
		
		ArrayList<Music> musicas = bds.getMusicas();

		//________________________________________________________________SOLICITA NOME DA MUSICA E ARTISTA
		
		AskMusicDetail snm = new AskMusicDetail();
		AskArtistDetail sna = new AskArtistDetail();

		//________________________________________________________________RECUPERA O NOME DA MUSICA E DO ARTISTA
		
		String mus = snm.getViewSolicitaMusica();
		String art = sna.getViewSolicitaNomeArtista();

		//________________________________________________________________PERCORRE O ARRAYLIST
		
		for (int i = 0; i < musicas.size(); i++) {
			
			//____________________________________________________________COMPARA VALORES PRESENTES NA "MUSICS.TXT" COM AS PASSADAS PELO USUÁRIO
			
			if (musicas.get(i).getNome().equalsIgnoreCase(mus) && musicas.get(i).getArtista().equalsIgnoreCase(art)) {//equalsIgnoreCase FAZ TODA DIFERENÇA DE equals
				
				//________________________________________________________________SE MUSICA E NOME ARTISTA FOREM IGUAIS AOS PASSADOS PELO USUÁRIO ENTAO:
				
				musicas.remove(i);
			}
		}

		//________________________________________________________________PERCORRE LISTA PARA REESCREVER O ARQUIVO "MUSICS.TXT"
		String listaMusicas = "";
		for (int i = 0; i < musicas.size(); i++) {

			if (i == (musicas.size() - 1)) {
				listaMusicas += musicas.get(i).getNome() + ";" + musicas.get(i).getAlbum() + ";" + musicas.get(i).getArtista();
			} else {
				listaMusicas += musicas.get(i).getNome() + ";" + musicas.get(i).getAlbum() + ";" + musicas.get(i).getArtista() + "\n";

			}
		}

		FileWriter fw = new FileWriter(FileName, false);
		PrintWriter pw = new PrintWriter(fw);
		pw.println(listaMusicas);
		pw.close();

		JDialog.setDefaultLookAndFeelDecorated(true);
		JOptionPane.showMessageDialog(null, "Música foi excluido da lista com Exito!");
	}
}
