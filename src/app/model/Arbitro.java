package app.model;

public class Arbitro {
	private String nome;
	private int codigo;

	public Arbitro(String nome, int codigo) {
		this.nome = nome;
		this.codigo = codigo;
	}
	
	public String getName() {
		return nome;
	}

	public void setName(String name) {
		this.nome = name;
	}

	public int getCodigo() {
		return codigo;
	}

	public void setCodigo(int codigo) {
		this.codigo = codigo;
	}

	public String toString() {
		return this.nome;
	}

}