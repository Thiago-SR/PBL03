package app.model;

import java.time.*;
import java.util.*;

public class Grupo {
	private int cod;
	private List<Selecao> selecoes = new ArrayList<Selecao>();
	private Map<Integer,Partida> partidas = new HashMap<Integer,Partida>();
	/**
	 * Cria partidas de todas as selecoes contra todas, ou seja, 6 partidas.
	 * @param sele01 Selecao 01 Selecao 01
	 * @param sele02 Selecao 02 Selecao 02
	 * @param sele03 Selecao 03 Selecao 03
	 * @param sele04 Selecao 04 Selecao 04
	 * @param cod Codigo do grupo
	 */
	public Grupo(Selecao sele01, Selecao sele02,Selecao sele03,Selecao sele04, int cod) {
		this.selecoes.add(sele01);
		this.selecoes.add(sele02);
		this.selecoes.add(sele03);
		this.selecoes.add(sele04);
		this.cod = cod;
		
		//CRIAR PARTIDAS
		Partida part01 = new Partida(selecoes.get(0),selecoes.get(1),cod*10+1,0,null,null,null);
		Partida part02 = new Partida(selecoes.get(0),selecoes.get(2),cod*10+2,0,null,null,null);
		Partida part03 = new Partida(selecoes.get(0),selecoes.get(3),cod*10+3,0,null,null,null);
		Partida part04 = new Partida(selecoes.get(1),selecoes.get(2),cod*10+4,0,null,null,null);
		Partida part05 = new Partida(selecoes.get(1),selecoes.get(3),cod*10+5,0,null,null,null);
		Partida part06 = new Partida(selecoes.get(2),selecoes.get(3),cod*10+6,0,null,null,null);
		
		this.partidas.put(part01.getCod(), part01);
		this.partidas.put(part02.getCod(), part02);
		this.partidas.put(part03.getCod(), part03);
		this.partidas.put(part04.getCod(), part04);
		this.partidas.put(part05.getCod(), part05);
		this.partidas.put(part06.getCod(), part06);
	}


	
	public int getCod() {
		return cod;
	}

	
	public void setCod(int cod) {
		this.cod = cod;
	}


	public List<Selecao> getSelecoes() {
		return selecoes;
	}


	public void setSelecoes(List<Selecao> selecoes) {
		this.selecoes = selecoes;
	}


	public Map<Integer,Partida> getPartidas() {
		return this.partidas;
	}


	public void setPartidas(Map<Integer,Partida> partidas) {
		this.partidas = partidas;
	}


}
