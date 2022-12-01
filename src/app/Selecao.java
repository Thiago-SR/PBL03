package app;

import java.util.ArrayList;
import java.util.List;

public class Selecao {
	private String nome;
	private int tecnico;
	private List<Integer> jogadores = new ArrayList<Integer>();

	public Selecao(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public int getTecnico() {
		return tecnico;
	}

	public void setNome(String novo_nome) {
		nome = novo_nome;
	}

	public void setTecnico(int novo_tecnico) {
		tecnico = novo_tecnico;
	}

	public List<Integer> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<Integer> jogadores) {
		this.jogadores = jogadores;
	}

	public String toString() {
		return this.nome;
	}
}