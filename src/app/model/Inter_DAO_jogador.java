package app.model;

import java.util.Map;

public interface Inter_DAO_jogador {
	
	public void inserir(Jogador jogador);
	
	public void editar(Jogador jogador);
	
	public void remover(int id);
	
	public Map<Integer, Jogador> listar();
	
	public Jogador buscar_jogador(int id);
}
  
