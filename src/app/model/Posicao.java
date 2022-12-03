package app.model;

public class Posicao {
	String nome;
	
	public Posicao(String nome) {
		this.nome = nome;
	}

	@Override
	public String toString() {
		return getNome();
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}
}
