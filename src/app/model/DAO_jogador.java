package app.model;

import app.*;
import application.model.Jogador;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
/**
 * 
 * @author Thiago Souza, Israel Oliveira
 *
 */
public class DAO_jogador implements Inter_DAO_jogador {
	private Map<Integer, Jogador> jogadores = new HashMap<>();
	
	private List<Jogador> Jogadores = new ArrayList<Jogador>();

	public DAO_jogador() {
	}

	/**
	 * Insere um jogador ao Map de jogadores.
	 * @param jogador Jogador que sera inserido.
	 *  
	 */
	@Override
	public void inserir(Jogador jogador) {
		int cod = jogador.getCod();
		jogadores.put(cod, jogador);
	}

	/**
	 * Substitui um jogador por outro jogador com o mesmo codigo mas com algum dos atributos alterado.
	 * @param jogador Jogador editado.
	 *  
	 */
	@Override
	public void editar(Jogador jogador) {
		jogadores.remove(jogador.getCod());
		jogadores.put(jogador.getCod(), jogador);
		// TODO Auto-generated method stub


	}

	/**
	 * Remove um jogador do Map de jogadores.
	 * @param id Codigo do jogador.
	 *  
	 */
	@Override
	public void remover(int id) {
		// TODO Auto-generated method stub
		jogadores.remove(id);
	}
	
	/**
	 * Lista os jogadores.
	 * @return Jogadores- Retorna um Map de jogadores.
	 */
	@Override
	public Map<Integer, Jogador> listar() {
		// TODO Auto-generated method stub
		return jogadores;
	}
	/**
	 * Substitui o atributo jogadores por um novo Map de jogadores.
	 * @param jogadores Map de jogadores.
	 * 
	 */
	public void setJogadores(Map<Integer, Jogador> jogadores) {
		this.jogadores = jogadores;
	}
	
	/**
	 * Busca um jogador pelo seu codigo.
	 *@param id Codigo do jogador. 
	 *
	 *@return Jogador- Retorna um objeto jogador caso o jogador seja encontrado ou null caso nao encontre.
	 */
	@Override
	public Jogador buscar_jogador(int id) {
		return this.jogadores.get(id);
		// TODO Auto-generated method stub

	}
	@Override
	public Jogador procurar_jogador(String nome) {
		for (Map.Entry<Integer, Jogador> pair : jogadores.entrySet()) {
			if(pair.getValue().getNome().equals(nome)==true) {
				Jogador jogador = pair.getValue();
				return jogador;
		}
			}
			return null;
		}
	
}