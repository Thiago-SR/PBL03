package app.model;

import java.util.*;

import app.Exceptions.NumJogException;
import app.Exceptions.NumSelecException;

public interface Inter_DAO_selecao {
	
	public void inserir(Selecao selecao)throws NumSelecException;
		
	public void editar(String nome, String novo_nome);
		
	public void remover(String nome);
		
	public List<Selecao> listar();
	
	public void inserir_jogador(String nome_selecao, int id_jog)throws NumJogException ;
	
	public void remover_jogador(String nome_selecao, int id_jog);
	
	public void inserir_tecnico(String nome_selecao, int cod_tecnico);
	
	public void remove_tecnico(int cod);
	
	public Selecao procurar_selecao(String nome);


}
