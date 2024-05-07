package view;

import controller.Controller01;

public class View01 {

	public static void main(String[] args) throws Exception {

		Controller01 cont = new Controller01();
		
		String caminho = "C:\\Users\\user\\OneDrive - Fatec Centro Paula Souza\\Desktop\\Temp";
		String arq = "generic_food.csv";
		
		cont.lerArquivo(caminho, arq);
		
		
	}
}
