package app.Exceptions;

import app.Selecao;

public class NumJogException extends Exception {
	Selecao selecao;
	
	public NumJogException(Selecao selecao) {
		super("O numero de jogadores nao permitido!");
		this.selecao = selecao;
	}
	
	public Selecao get_selecao() {
		return this.selecao;
	}
}
