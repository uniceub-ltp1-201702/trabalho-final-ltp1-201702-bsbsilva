package Util;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class txtReader {

	public ArrayList<String> read(String fileName) {
		// Cria o ArrayList de retorno
		ArrayList<String> fileLines = new ArrayList<String>();

		try {
			
			//____________________________________________________________CRIA O FILEREADER COM O NOME DO ARQUIVO.TXT
			
			FileReader fr = new FileReader(fileName);
			
			//____________________________________________________________CRIA O BUFFER DE LEITURA
			
			BufferedReader br = new BufferedReader(fr);
			
			//____________________________________________________________LÊ A PRIMEIRA LINHA
			
			String line = br.readLine();
			
			//____________________________________________________________ENQUANTO AINDA EXISTIREM LINHAS ENTAO:
			
			while (line != null) {
				
				//________________________________________________________Adiciona a linha lida no ArrayList
				
				fileLines.add(line);
				
				//________________________________________________________LÊ A PRÓXIMA LINHA
				
				line = br.readLine();
			}
			
			//____________________________________________________________FECHA O BUFFER DE LEITURA
			
			br.close();

			//____________________________________________________________ERRO QUANDO O ARQUIVO NÃO É ENCONTRADO
			
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			
			//____________________________________________________________ERRO DE EXCEÇÃO DO "IO"
			
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//________________________________________________________________RETORNA O ARRAYLIST COM TODAS AS LINHAS
		
		return fileLines;
	}
}
