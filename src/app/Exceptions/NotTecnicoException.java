package app.Exceptions;

import app.model.Selecao;

public class NotTecnicoException extends Exception{
	Selecao selecao;
	public  NotTecnicoException(Selecao selecao) {
		super("Selecao sem tecnico!");
		this.selecao = selecao;
	}
	
	public Selecao get_selecao() {
		return  selecao;
	}
}
