package app.model;

import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

import app.Selecao;
import app.model.*;
import app.model.Inter_DAO_selecao;
import app.Exceptions.NumJogException;
import app.Exceptions.NumSelecException;
/**
 *
 * @author Thiago Souza, Israel Oliveira
 *
 */


public class DAO_selecao implements Inter_DAO_selecao {
	private List<Selecao> Selecoes = new ArrayList<Selecao>();

	/**
	 *Insere uma nova selecao na lista Selecoes.
	 *@param  selecao  Selecao que sera inserida.
	 * @throws NumSelecException 
	 *
	 *
	 */
	@Override
	public void inserir(Selecao selecao) throws NumSelecException {
		if(Selecoes.size()<32) {
			Selecoes.add(selecao);
		}
		else {
			throw new NumSelecException(Selecoes.size());
		}
	}

	/**
	 * Edita o nome de uma determinada selecao.
	 *@param nome Nome da selecao que sera editada.
	 *@param novo_nome Novo nome que sera atribuido a selecao.
	 * 
	 */
	@Override
	public void editar(String nome, String novo_nome) {
		Iterator<Selecao> itr = Selecoes.iterator();
		while (itr.hasNext()) {
			Selecao selecao = itr.next();
			if (nome.equals(selecao.getNome()) == true ) {
				selecao.setNome(novo_nome);
				break;
			}
		}
		// TODO Auto-generated method stub

	}
	
	
	/**
	 * Remove uma determinada selecao da lista Selecoes.
	 * @param nome Nome da selecao que sera removida.
	 * 
	 *
	 */
	@Override
	public void remover(String nome) {
		Iterator<Selecao> itr = Selecoes.iterator();
		while (itr.hasNext()) {
			Selecao selecao = itr.next();
			if (nome.equals(selecao.getNome()) == true ) {
				Selecoes.remove(selecao);
				break;
			}
		}
		// TODO Auto-generated method stub

	}
	
	/**
	 * Lista as selecoes.
	 * @return Selecoes- Retorna um List de selecoes.
	 */
	@Override
	public List<Selecao> listar() {
		// TODO Auto-generated method stub
		return Selecoes;
	}
	/**
	 * Insere o codigo de um jogador na lista de codigo de jogadores em uma determinada selecao.
	 * @param nome_selecao  Nome da selecao que o jogador sera inserido.
	 * @param id_jog Codigo de identificacao do jogador.
	 * @throws NumJogException 
	 *
	 */
	@Override
	public void inserir_jogador(String nome_selecao, int id_jog) throws NumJogException {
		List<Integer> lista_jogadores = new ArrayList<Integer>();
		Iterator<Selecao> itr = Selecoes.iterator();
		while (itr.hasNext()) {
			Selecao selecao = itr.next();
			if (nome_selecao.equals(selecao.getNome()) == true) {
				lista_jogadores = selecao.getJogadores();
				if(lista_jogadores.size() < 11) {
					lista_jogadores.add(id_jog);
					selecao.setJogadores(lista_jogadores);
					break;
				}
				else {
					throw new NumJogException(selecao);
				}
			}
		}
	}
	
	/**
	 * Remove o codigo de um jogador da lista de codigos em uma determinada selecao.
	 * @param nome_selecao  Nome da selecao a qual o jogador pertence.
	 * @param id_jog Codigo do jogador que sera removido.
	 * 
	 */
	@Override
	public void remover_jogador(String nome_selecao, int id_jog) {
		List<Integer> lista_jogadores = new ArrayList<Integer>();
		Iterator<Selecao> itr = Selecoes.iterator();
		while (itr.hasNext()) {
			Selecao selecao = itr.next();
			if (nome_selecao.equals(selecao.getNome()) == true) {
				lista_jogadores = selecao.getJogadores();
				int index = lista_jogadores.indexOf(id_jog);
				lista_jogadores.remove(index);
				selecao.setJogadores(lista_jogadores);
				break;
				
			}
		}
	}
	
	/**
	 * Insere o codigo de um tecnico na variavel tecnico de uma determinada selecao.
	 * @param nome_selecao  Nome da selecao a qual o tecnico sera adicionado.
	 * @param cod_tecnico  Codigo do tecnico que sera adicionado.
	 * 
	 */
	@Override
	public void inserir_tecnico(String nome_selecao, int cod_tecnico) {
		Iterator<Selecao> itr = Selecoes.iterator();
		while (itr.hasNext()) {
			Selecao selecao = itr.next();
			if (nome_selecao.equals(selecao.getNome()) == true) {
				selecao.setTecnico(cod_tecnico);
				break;
			}
		}
	}
	/**
	 * Remove o codigo do tecnico da selecao que ele pertence.
	 * @param cod  Codigo do tecnico que sera removido. 
	 * 
	 */
	@Override
	public void remove_tecnico(int cod) {
		Iterator<Selecao> itr = Selecoes.iterator();
		while (itr.hasNext()) {
			Selecao selecao = itr.next();
			if (selecao.getTecnico() == cod) {
				selecao.setTecnico(0);
				break;
			}
		}
	}
	/**
	 * Procura uma selecao na lista de selecoes.
	 * @param nome Nome da selecao que deseja encontrar.
	 *
	 *@return Selecao - Retorna o objeto selecao caso tenha encontrado ou null caso nao tenha sido encontrada.
	 */
	@Override
	public Selecao procurar_selecao(String nome) {
		Iterator<Selecao> itr = Selecoes.iterator();
		while (itr.hasNext()) {
			Selecao selecao = itr.next();
			
			if (nome.equals(selecao.getNome())== true) {
				return selecao;
			}
		}
		// TODO Auto-generated method stub
		return null;
	}
	/**
	 * Identifica qual selecao o jogador pertence.
	 * @param cod  Codigo do jogador que deseja descobrir a qual selecao pertence.
	 * 
	 *@return Nome da selecao - Retorna o nome da selecao caso o jogador faca parte de uma selecao ou null caso o jogador nao faca parte de uma selecao.
	 */
	public String selecao_do_jogador(int cod) {
		Iterator<Selecao> itr = Selecoes.iterator();
		while (itr.hasNext()) {
			Selecao selecao = itr.next();
			Iterator<Integer> itr1 = selecao.getJogadores().iterator();
			while(itr1.hasNext()) {
				int cod_jog = itr1.next();
				if(cod == cod_jog) {
					return selecao.getNome();
				}
			}
			
		
		}
		return null;
	}
	/**
	 * Identifica a selecao que o tecnico pertence.
	 * @param cod Codigo do tecnico que deseja descobrir a selecao que ele pertence.
	 *
	 *@return Nome da selecao- Retorna o nome da selecao que  o tecnico faz parte.
	 */
	public String selecao_do_tecnico(int cod){
		Iterator<Selecao> itr = Selecoes.iterator();
		while(itr.hasNext()) {
			Selecao selecao = itr.next();
			if(cod == selecao.getTecnico()) {
				return selecao.getNome();
			}
		}
		return null;
	}

}

