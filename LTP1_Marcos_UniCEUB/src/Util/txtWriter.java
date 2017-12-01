package Util;

import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

public class txtWriter {

	public void write(String fileName, String fileText) {
		try {
			
			//____________________________________________________________CRIA O FILEWRITER PARA ESCREVER NO ARQUIVO.TXT
			
			FileWriter fw = new FileWriter(fileName, true);
			
			//____________________________________________________________CRIA UM PRINTWRITER PARA ESCREVER NO ARQUIVO.TXT
			
			PrintWriter pw = new PrintWriter(fw);
			
			//____________________________________________________________ESCREVE A LINHA NO ARQUIVO E PULA PARA A PRÓXIMA LINHA
			
			pw.println(fileText);
			
			//____________________________________________________________FECHA O PRINTWRITER
			
			pw.close();

			//____________________________________________________________ERRO DE ACESSO AO "IO"
			
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
}
