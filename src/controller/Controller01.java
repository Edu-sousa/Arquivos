package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStreamReader;

public class Controller01 {

	public void lerArquivo(String caminho, String arquivo) throws Exception {

		File file = new File(caminho, arquivo);

		if (file.exists() && file.isFile()) {
			FileInputStream fluxo = new FileInputStream(file);// abre arquivo
			InputStreamReader leitor = new InputStreamReader(fluxo); // ler arquivo
			BufferedReader buffer = new BufferedReader(leitor); // coloca conteudo no buffer

			String linha = buffer.readLine();

			while (linha != null) {

				String[] info = linha.split(",");
//				System.out.println("FOOD NAME  SCIENTIFIC NAME  SUB GROUP");
				if (info[2].equals("Fruits")) {
//					System.out.println(info[0] + "				" + info[1] + "				" + info[3]);
					System.out.println(info[0] + "\t\t\t\t\t\t" + info[1] + "\t\t\t\t\t\t" + info[3]);
				}
				linha = buffer.readLine(); //ler prixima linha
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		} else {
			throw new Exception("Arquivo Invalido");
		}

	}
}
