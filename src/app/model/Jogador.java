package app.model;

public class Jogador {
	private String nome;
	private int codJogador;
	private String posicao;
	private int cardAmarelo;
	private int cardVermelho;
	private int numGols;
	private Selecao Selecao;

	public Jogador(String nome_jog, int cod, String posicao_jog,Selecao selecao) {
		nome = nome_jog;
		codJogador = cod;
		posicao = posicao_jog;
		this.cardAmarelo = 0;
		this.cardVermelho = 0;
		this.numGols = 0;
		this.Selecao = selecao;

	} 

	public String toString() {
		return this.nome;
	}

	public String getNome() {
		return this.nome;
	}

	public int getCod() {
		return codJogador;
	}

	public String getPosicao() {
		return posicao;
	}

	public int getCardAmarelo() {
		return cardAmarelo;
	}

	public int getCardVermelho() {
		return cardVermelho;
	}

	public int getNumGols() {
		return numGols;
	}

	public void setNome(String novo_nome) {
		nome = novo_nome;
	}

	public void setCod(int novo_cod) {
		codJogador = novo_cod;

	}

	public void setPosicao(String nova_posicao) {
		posicao = nova_posicao;
	}

	public void setCardVermelho(int novo_card) {
		cardVermelho = novo_card;
	}

	public void setCardAmarelo(int novo_card) {
		cardAmarelo = novo_card;
	}

	public void setGols(int novo_gols) {
		numGols = novo_gols;
	}
	public Selecao getSelecao() {
		return Selecao;
	}

	public void setSelecao(Selecao selecao) {
		Selecao = selecao;
	}
}