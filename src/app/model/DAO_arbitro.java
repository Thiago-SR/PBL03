package app.model;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import app.model.*;


/**
 * @author Thiago Souza, Israel Oliveira
 *
 */
public class DAO_arbitro implements Inter_DAO_arbitro {
	private List<Arbitro> Arbitros = new ArrayList<Arbitro>();

	/**
	 * Insere um novo arbitro na lista de arbitros.
	 * @param arbitro Arbitro que sera inserido.
	 * 
	 */
	@Override
	public void inserir(Arbitro arbitro) {
		Arbitros.add(arbitro);
		// TODO Auto-generated method stub

	}

	/**
	 * Remove um arbitro da lista de arbitros.
	 * @param nome Nome do arbitro.
	 *
	 */
	@Override
	public void remover(String nome) {
		Iterator<Arbitro> itr = Arbitros.iterator();
		while (itr.hasNext()) {
			Arbitro arbitro = itr.next();
			if (nome.equals(arbitro.getNome()) == true ) {
				Arbitros.remove(arbitro);
				break;
			}
		}

	}

	/**
	 *  Lista os arbitros.
	 * @return Arbitros - Retorna um List de arbitros.
	 */
	@Override
	public List<Arbitro> listar() {
		// TODO Auto-generated method stub
		return Arbitros;
	}

	/**
	 * Altera o nome do arbitro.
	 * @param nome Nome do arbitro que sera editado.
	 * @param novo_nome Novo nome do arbitro.
	 * 
	 */
	@Override
	public void editar(String nome, String novo_nome) {
		Iterator<Arbitro> itr = Arbitros.iterator();
		while (itr.hasNext()) {
			Arbitro arbitro = itr.next();
			if (nome.equals(arbitro.getNome()) == true) {
				arbitro.setNome(novo_nome);
			}
		}

		// TODO Auto-generated method stub

	}
	
	/**
	 * Busca um determinado arbitro usando seu codigo.
	 * @param id Codigo do arbitro.
	 * 
	 * @return Arbitro- Retorna o arbitro caso ele seja encontrado ou null caso nao seja.
	 */
	public Arbitro buscar_arbitro(int id) {
		Iterator<Arbitro> itr = this.Arbitros.iterator();
		while(itr.hasNext()) {
			Arbitro arbitro = itr.next();
			if(arbitro.getCodigo() == id) {
				return arbitro;
			}
		}
		return null;
	}

}