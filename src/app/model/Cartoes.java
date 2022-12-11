package app.model;

public class Cartoes {
	String tipo;

	public Cartoes(String tipo){
		this.tipo= tipo;
	}
	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	@Override
	public String toString() {
		return this.tipo;
	}
}
