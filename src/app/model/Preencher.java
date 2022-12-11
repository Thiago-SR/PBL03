package app.model;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

import app.Main;
import app.model.Jogador;
import app.model.Selecao;
import app.model.Tecnico;



/**
 * Classe Responsável por preencher as selecoes, jogadores e tecnicos
 * @author Joao Victor e José Gabriel
 *
 */
public class Preencher {
	public static void MockSelecoes(DAO_selecao selecDao) {
			for (int i = 0;i<32;i++) {
				try {
					Selecao selec = new Selecao("Time"+(i+1));
					selecDao.inserir(selec);					
				} catch (Exception e) {
					System.out.println(e.getMessage());
				}
			}
	}
	
	public static void MockJogadores(DAO_selecao selecDao) {
		String[] nomes = {"Tyrell","Shola","Garin","Ajay","River","Rehan","Edan","Roland","Jaye","Lochlan","Antoni"};
		String[] sobreNomes = {"Dickerson","Leonard","Hewitt","Bassett","Suarez","Suarez","Jackson","Britt","Garner","Coles","Klein"};
		Random rand = new Random();
		
		try {
			List<Selecao> selecoes = Main.list_sele.listar();
			
			for(Selecao selec:selecoes) {
				for (int i = 0;i<11;i++) {
					int numAleatorio1 = rand.nextInt(11);
					int numAleatorio2 = rand.nextInt(11);
					int numPosicaoAleatorio = rand.nextInt(4);
					try {
						Jogador jog =  new Jogador(nomes[numAleatorio1]+ " " + sobreNomes[numAleatorio2],Main.contador_jogador, null, selec);
						Main.contador_jogador++;
						Main.list_sele.inserir_jogador(selec.getNome(),jog);
						Main.list_jog.inserir(jog);
						//Main.     (new Jogador(nomes[numAleatorio1]+ " " + sobreNomes[numAleatorio2],numPosicaoAleatorio, null, selec));		
						//selec.getJogadoresDao().create(new Jogador(nomes[numAleatorio1]+ " " + sobreNomes[numAleatorio2],numPosicaoAleatorio));			
					} catch (Exception e) {
						System.out.println(e.getMessage());
					}
				}
				
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
	}
	
	public static void MockTecnicos(DAO_selecao selecDao) {
		String[] nomes = {"Tyrell","Shola","Garin","Ajay","River","Rehan","Edan","Roland","Jaye","Lochlan","Antoni"};
		String[] sobreNomes = {"Dickerson","Leonard","Hewitt","Bassett","Suarez","Suarez","Jackson","Britt","Garner","Coles","Klein"};
		Random rand = new Random();
		try {
			List<Selecao> selecoes = Main.list_sele.listar();
			for(Selecao selec:selecoes) {
				int numAleatorio1 = rand.nextInt(11);
				int numAleatorio2 = rand.nextInt(11);
				Tecnico tec = new Tecnico(nomes[numAleatorio1]+ " " + sobreNomes[numAleatorio2],Main.contador_tecnico, selec.getNome());
				Main.list_sele.inserir_tecnico(selec.getNome(), tec);
				Main.list_tecnico.inserir(tec);
			
		}
		} catch (Exception e){}
			
	}
}