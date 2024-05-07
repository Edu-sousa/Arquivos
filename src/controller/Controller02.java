package controller;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

import fateczl.listaSetGenerica.model.ListaSetGenerica;

public class Controller02 {

	ListaSetGenerica lista = new ListaSetGenerica();

	public void lerInfoJogos(int ano, String mes, float mediaPlayers) throws IOException {

		File file = new File("C:\\Users\\user\\OneDrive - Fatec Centro Paula Souza\\Desktop\\Temp", "SteamCharts.csv");

		if (file.exists() && file.isFile()) {
			FileInputStream fluxo = new FileInputStream(file);
			InputStreamReader leitor = new InputStreamReader(fluxo);
			BufferedReader buffer = new BufferedReader(leitor);

			String linha = buffer.readLine();
			while (linha != null) {

				String[] info = linha.split(",");
		
				if (info[1].equals(Integer.toString(ano)) && info[2].equals(mes)
						&& Float.parseFloat(info[3]) >= mediaPlayers) {
					System.out.println(info[0] + "\t\t\t\t\t\t\t" + info[3]);
				}
				linha = buffer.readLine();
			}
		}
	}

	public void geraArquivo(int ano, String mes, String caminho, String arquivo) throws Exception {

		File dir = new File(caminho);

		if (dir.exists() && dir.isDirectory()) {
			File arq = new File(caminho, arquivo + ".csv");
			boolean existe = false;
			if (arq.exists()) {
				existe = true;
			}
			StringBuffer buffer = new StringBuffer();
			lista = lerArquivo(caminho, arquivo, ano, mes);

			for (int i = 0; i < lista.size(); i++) {
				String linha = (String) lista.get(i);
				buffer.append(linha + "\n");
			}
			FileWriter fileWriter = new FileWriter(arq, existe);// abre o arquivo e define a operação, write ou append
			PrintWriter print = new PrintWriter(fileWriter); // escreve o conteudo no fileWriter
			print.write(buffer.toString());
			print.flush(); // finaliza a escrita
			print.close();
			fileWriter.close(); // fecha o arquivo
			
			System.out.println("Arquivo Criado");
		} else {
			throw new IOException("Diretorio Invalido");
		}
	}

	private ListaSetGenerica lerArquivo(String caminho, String arquivo, int ano, String mes) throws Exception {

		File file = new File("C:\\Users\\user\\OneDrive - Fatec Centro Paula Souza\\Desktop\\Temp", "SteamCharts.csv");		

		if (file.exists() && file.isFile()) {
			FileInputStream fluxo = new FileInputStream(file);// abre arquivo
			InputStreamReader leitor = new InputStreamReader(fluxo); // ler arquivo
			BufferedReader buffer = new BufferedReader(leitor); // coloca conteudo no buffer

			String linha = buffer.readLine();

			int cont = 0;
			while (linha != null) {

				String[] info = linha.split(",");

				if (info[1].equals(Integer.toString(ano)) && info[2].equals(mes)) {
					String conteudo = info[0] + "\t\t\t\t" + info[3];
					if (cont == 0) {
						lista.addFirst(conteudo);
						cont++;
					} else
						lista.add(conteudo, cont);
				}
				linha = buffer.readLine(); // ler primeira linha
			}
			buffer.close();
			leitor.close();
			fluxo.close();
		} else {
			throw new Exception("Arquivo Invalido");
		}
		return lista;
	}
}
