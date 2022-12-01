package app.model;

import java.util.List;

import app.model.*;

public interface Inter_DAO_arbitro {
	
	public void inserir(Arbitro arbitro);
	
	public void editar(String nome, String novo_nome);
	
	public void remover(String nome);
	
	public List<Arbitro> listar();
	
	
}