package app.model;

import java.util.*;

import app.Main;
import app.Exceptions.NotTecnicoException;
import app.Exceptions.NumJogException;
import app.Exceptions.NumSelecException;
import app.Exceptions.SemArbitroException;

public class Fase_grupo {
	private List<Grupo> grupos = new ArrayList<Grupo>();
	/**
	 * Cria 8 grupos compostos por 4 selecoes cada.
	 * @param selecoes Lista de selecoes
	 * @throws NumSelecException Numero de selecoes menor que 32.
	 * @throws NumJogException Alguma selecao tem menos que 11 jogadores.
	 * @throws NotTecnicoException Alguma selecao nao possui tecnico.
	 * @throws SemArbitroException 
	 */
	public Fase_grupo(List<Selecao> selecoes) throws NumSelecException, NumJogException, NotTecnicoException, SemArbitroException {
		verifica_selecao(selecoes);
		if(Main.list_arbitro.listar().size()==0) {
			throw  new SemArbitroException();
		}
		Iterator<Selecao> itr = selecoes.iterator();
		while(itr.hasNext()) {
			Selecao selec = itr.next();
			verifica_jogadores(selec);
			verifica_tecnico(selec);
		}
		
		Grupo grupo01 = new Grupo(selecoes.get(0),selecoes.get(1),selecoes.get(2),selecoes.get(3),1);
		Grupo grupo02 = new Grupo(selecoes.get(4),selecoes.get(5),selecoes.get(6),selecoes.get(7),2);
		Grupo grupo03 = new Grupo(selecoes.get(8),selecoes.get(9),selecoes.get(10),selecoes.get(11),3);
		Grupo grupo04 = new Grupo(selecoes.get(12),selecoes.get(13),selecoes.get(14),selecoes.get(15),4);
		Grupo grupo05 = new Grupo(selecoes.get(16),selecoes.get(17),selecoes.get(18),selecoes.get(19),5);
		Grupo grupo06 = new Grupo(selecoes.get(20),selecoes.get(21),selecoes.get(22),selecoes.get(23),6);
		Grupo grupo07 = new Grupo(selecoes.get(24),selecoes.get(25),selecoes.get(26),selecoes.get(27),7);
		Grupo grupo08 = new Grupo(selecoes.get(28),selecoes.get(29),selecoes.get(30),selecoes.get(31),8);
		
		this.grupos.add(grupo01);
		this.grupos.add(grupo02);
		this.grupos.add(grupo03);
		this.grupos.add(grupo04);
		this.grupos.add(grupo05);
		this.grupos.add(grupo06);
		this.grupos.add(grupo07);
		this.grupos.add(grupo08);
		
		}
		
		
	
/**
 * Verifica se ha 32 selecoes para poder iniciar a fase de grupos.
 * @param selecoes Lista de selecoes.
 * @throws NumSelecException Possui menos de 32 selecoes.
 */
	static public void verifica_selecao(List<Selecao> selecoes) throws NumSelecException {
		if(selecoes.size() < 32)
			throw new NumSelecException(selecoes.size());
	}
	/**
	 * Verifica se cada selecao tem 11 jogadores.
	 * @param selecao Selecao.
	 * @throws NumJogException A selecao possui menos de 11 jogadores.
	 */
	static public void verifica_jogadores(Selecao selecao) throws NumJogException {
		if(selecao.getJogadores().size() <11) {
			throw new NumJogException(selecao);
		}
	}
	/**
	 * Verifica se cada selecao tem um tecnico.
	 * @param selecao Selecao.
	 * @throws NotTecnicoException A selecao nao possui tecnico.
	 */
	static public void verifica_tecnico(Selecao selecao) throws NotTecnicoException {
		if(selecao.getTecnico().getCod() == 0) {
			throw new NotTecnicoException(selecao);
		}
	}
	
	public List<Grupo> get_grupos() {
		return this.grupos;
	}
	
	public List<Partida> FinalizarFaseGrupo(){
		List<Partida> partidas_oitavas = new ArrayList<Partida>();
		List<Selecao> Classificadas = new ArrayList<Selecao>();
		List<Selecao> vetor;
		Iterator<Grupo> itr = this.grupos.iterator();
		while(itr.hasNext()) {
			Grupo grupo = itr.next();
			vetor  =grupo.getSelecoes();
			 boolean troca = true;
             Selecao aux;
             while (troca) {
                 troca = false;
                 for (int i = 0; i < vetor.size() - 1; i++) {
                     if (vetor.get(i).getPontos() > vetor.get(i+1).getPontos()) {
                         aux = vetor.get(i);
                         vetor.add(i, vetor.get(i+1));
                         vetor.add(i+1, aux);
                         troca = true;
                     }
                 }
             }
           Classificadas.add(vetor.get(3));
           Classificadas.add(vetor.get(2));
		}
		
		Partida partida01 = new Partida(Classificadas.get(1),Classificadas.get(4),500,0,null,null,null);
		Partida partida02 = new Partida(Classificadas.get(2),Classificadas.get(3),501,0,null,null,null);
		Partida partida03 = new Partida(Classificadas.get(5),Classificadas.get(8),502,0,null,null,null);
		Partida partida04 = new Partida(Classificadas.get(6),Classificadas.get(7),503,0,null,null,null);;
		Partida partida05 = new Partida(Classificadas.get(9),Classificadas.get(12),504,0,null,null,null);;
		Partida partida06 = new Partida(Classificadas.get(10),Classificadas.get(11),505,0,null,null,null);;
		Partida partida07 = new Partida(Classificadas.get(13),Classificadas.get(16),506,0,null,null,null);;
		Partida partida08 = new Partida(Classificadas.get(14),Classificadas.get(15),507,0,null,null,null);;
		
		partidas_oitavas.add(partida01);
		partidas_oitavas.add(partida02);
		partidas_oitavas.add(partida03);
		partidas_oitavas.add(partida04);
		partidas_oitavas.add(partida05);
		partidas_oitavas.add(partida06);
		partidas_oitavas.add(partida07);
		partidas_oitavas.add(partida08);
		
		return partidas_oitavas;
		
	}
}

