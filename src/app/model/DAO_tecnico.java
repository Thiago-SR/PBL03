package app.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import app.model.*;

/**
 * @author Thiago Souza, Israel Oliveira
 * 
 */

public class DAO_tecnico implements Inter_DAO_tecnico {
	private List<Tecnico> Tecnicos = new ArrayList<Tecnico>();
/**
 * Insere o tecnico a lista de tecnicos
 * @param tecnico Tecnico que sera inserido.
 * 
 */
	@Override
	public void inserir(Tecnico tecnico) {
		Tecnicos.add(tecnico);
		
	}
	/**
	 * Altera o nome do tecnico.
	 * @param nome Nome do tecnico que sera editado.
	 * @param novo_nome Novo nome que sera atribuido ao tecnico.
	 * 
	 */
	@Override
	public void editar(String nome, String novo_nome) {
		Iterator<Tecnico> itr = Tecnicos.iterator();
		while (itr.hasNext()) {
			Tecnico tecnico = itr.next();
			if (nome.equals(tecnico.getNome())== true) {
				tecnico.setNome(novo_nome);
			}
		}
	}
	/**
	 * Remove o tecnico da lista de tecnicoos.
	 * @param nome Nome do tecnico que sera removido.
	 * 
	 */
	@Override
	public void remover(String nome) {
		Iterator<Tecnico> itr = Tecnicos.iterator();
		while (itr.hasNext()) {
			Tecnico tecnico = itr.next();
			if (nome.equals(tecnico.getNome())== true ) {
				int index = Tecnicos.indexOf(tecnico);
				Tecnicos.remove(index);
				break;
			}
		}

		// TODO Auto-generated method stub

	}
	/**
	 * Lista os tecnicos.
	 * @return Tecnicos - Retorna uma lista de tecnicos.
	 */
	@Override
	public List<Tecnico> listar() {
		// TODO Auto-generated method stub
		return Tecnicos;
	}
	/**
	 *  Busca o tecnico na lista de tecnicos.
	 * @param id Codigo do tecnico.
	 *
	 * @return Tecnico - Retorna o tecnico caso tenha econtrado ou null se nao for encontrado.
	 */
	public Tecnico buscar_tecnico(int id) {
		if(Tecnicos.size()>0) {
			Iterator<Tecnico> itr = this.Tecnicos.iterator();
			while(itr.hasNext()) {
				Tecnico tecnico = itr.next();
				if(tecnico.getCod() == id) {
					return tecnico;
				}
			}
		}
		return null;
	}

}