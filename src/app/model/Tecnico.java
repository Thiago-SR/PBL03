package app.model;

public class Tecnico {
	private String nome;
	private int codTecnico;
	private String selecao;

	public String getSelecao() {
		return selecao;
	}

	public void setSelecao(String selecao) {
		this.selecao = selecao;
	}

	public Tecnico(String nome_tec, int codTecnico) {
		this.nome = nome_tec;
		this.codTecnico = codTecnico;

	}

	public int getCod() {
		return codTecnico;
	}

	public void setCod(int codTecnico) {
		this.codTecnico = codTecnico;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String novo_nome) {
		nome = novo_nome;
	}

}
