package app.model;

import java.util.*;

import app.model.*;

public interface Inter_DAO_tecnico {
	
	public void inserir(Tecnico tecnico);
	
	public void editar(String nome, String novo_nome);
	
	public void remover(String nome);
	
	public List<Tecnico> listar();


}
