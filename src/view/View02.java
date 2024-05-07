package view;

import javax.swing.JOptionPane;

import controller.Controller02;

public class View02 {

	public static void main(String[] args) throws Exception {

		Controller02 cont = new Controller02();

		int e = 9;
		while (e != 0) {
			e = Integer.parseInt(
					JOptionPane.showInputDialog("\tMenu \n 1- Procurar Informações \n 2 - Criar Arquivo \n 0 - Sair"));
			switch (e) {
			case 1:
				int ano = Integer.parseInt(JOptionPane.showInputDialog("Insira Ano"));
				String mes = JOptionPane.showInputDialog("Insira Mês (em inglês)");
				float mediaPlayers = Float.parseFloat(JOptionPane.showInputDialog("Media de Jogadores"));
				
				cont.lerInfoJogos(ano, mes, mediaPlayers);
//				cont.lerInfoJogos(2021, "February", 7410);
				break;

			case 2:
				String caminho = "C:\\Users\\user\\OneDrive - Fatec Centro Paula Souza\\Desktop\\Temp";
				int ano2 = Integer.parseInt(JOptionPane.showInputDialog("Insira Ano"));
				String mes2 = JOptionPane.showInputDialog("Insira Mês (em inglês)");
				String nomeArquivo = JOptionPane.showInputDialog("Insira um nome para o arquivo");
				
				cont.geraArquivo(ano2, mes2, caminho, nomeArquivo);
//				cont.geraArquivo(2021, "February", caminho, "nomeArquivo");
				break;

			case 0:
				e = 0;
				break;

			}
		}



	}
}
