package app.model;

import java.util.ArrayList;
import java.util.List;

public class Selecao {
	private String nome;
	private Tecnico tecnico;
	private List<Jogador> jogadores = new ArrayList<Jogador>();

	public Selecao(String nome) {
		this.nome = nome;
	}

	public String getNome() {
		return nome;
	}

	public Tecnico getTecnico() {
		return tecnico;
	}

	public void setNome(String novo_nome) {
		nome = novo_nome;
	}

	public void setTecnico(Tecnico novo_tecnico) {
		tecnico = novo_tecnico;
	}

	public List<Jogador> getJogadores() {
		return jogadores;
	}

	public void setJogadores(List<Jogador> jogadores) {
		this.jogadores = jogadores;
	}

	public String toString() {
		return this.nome;
	}
}