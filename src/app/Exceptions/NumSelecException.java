package app.Exceptions;

public class NumSelecException extends Exception {
	int num_selecoes;
	public NumSelecException(int  num_selecoes) {
		super("Numero de selecoes nao permitido!");
		this.num_selecoes = num_selecoes;
	}
	
	public int get_num() {
		return this.num_selecoes;
	}
	
}
