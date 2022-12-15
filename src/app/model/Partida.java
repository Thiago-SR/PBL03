package app.model;


import java.util.*;

public class Partida {
	private int cod;
	private boolean dados_completo;// SE FOR FALSE OS DADOS DA PARTIDA NAO FORAM ADICIONADOS PELO USUARIO AINDA
	//SE FOR TRUE O USUARIO JA ADICIONOU OS DADOS DA PARTIDA
	private Selecao selecao01;
	private Selecao selecao02;
	private int cod_arbitro;
	private int gols_time01;
	private int gols_time02;
	private String local;
	private String data;
	private String hora;
	private Map<Integer, Jog_partida> dados_jog = new HashMap<Integer, Jog_partida>();
	/**
	 * Recebe as informacoes da partida e cria o jog_partida de cada jogador, os jog_partida serao armazenadas no propio objeto.
	 * @param selecao01 Selecao 01
	 * @param selecao02 Selecao 02
	 * @param cod Codigo da partida
	 * @param cod_arbitro Codigo do arbitro
	 * @param local Local da partida
	 * @param data Data da partida
	 * @param hora Hora da partida
	 */
	public Partida(Selecao selecao01, Selecao selecao02, int cod, int cod_arbitro,String local, String data, String hora) {
		this.selecao01 = selecao01;
		this.selecao02 = selecao02;
		this.cod = cod;
		this.cod_arbitro = cod_arbitro;
		this.local = local;
		this.data = data;
		this.hora = hora;
		this.dados_completo = false;
		
		Iterator<Jogador> itr = selecao01.getJogadores().iterator();
		while(itr.hasNext()) {
			Jogador jog = itr.next();
			Jog_partida dados = new Jog_partida(jog,this.cod,0,0,0);
			this.dados_jog.put(jog.getCod(), dados);
		}
		
		Iterator<Jogador> itr1 = selecao02.getJogadores().iterator();
		while(itr1.hasNext()){
			Jogador jog = itr1.next();
			Jog_partida dados = new Jog_partida(jog,this.cod,0,0,0);
			this.dados_jog.put(jog.getCod(), dados);
			
		}
	}
	
	
	
	public int getCod() {
		return cod;
	}

	public void setCod(int cod) {
		this.cod = cod;
	}

	public Selecao getSelecao01() {
		return selecao01;
	}

	public void setSelecao01(Selecao selecao01) {
		this.selecao01 = selecao01;
	}

	public Selecao getSelecao02() {
		return selecao02;
	}

	public void setSelecao02(Selecao selecao02) {
		this.selecao02 = selecao02;
	}

	public int getCod_arbitro() {
		return cod_arbitro;
	}

	public void setCod_arbitro(int cod_arbitro) {
		this.cod_arbitro = cod_arbitro;
	}

	public int getGols_time01() {
		return gols_time01;
	}

	public void setGols_time01(int gols_time01) {
		this.gols_time01 = gols_time01;
	}

	public int getGols_time02() {
		return gols_time02;
	}

	public void setGols_time02(int gols_time02) {
		this.gols_time02 = gols_time02;
	}

	public String getLocal() {
		return local;
	}

	public void setLocal(String local) {
		this.local = local;
	}

	public String getData() {
		return data;
	}

	public void setData(String data) {
		this.data = data;
	}

	public String getHora() {
		return hora;
	}

	public void setHora(String hora) {
		this.hora = hora;
	}
	public boolean get_dados_completo() {
		return dados_completo;
	}
	public void set_dados_completos(boolean atualizado) {
		this.dados_completo = atualizado;
	}
	
	/**
	 * Atualiza os dados da partida.
	 * @param cod_arb Codigo do arbitro
	 * @param local Local da partida
	 * @param data Data da partida
	 * @param hora Hora da partida
	 * @param gols_time01 Gols da selecao 01
	 * @param gols_time02 Gols da selecao 02
	 */
	public void inserir_dados(int cod_arb,String local, String data, String hora, int gols_time01, int gols_time02) {
		this.cod_arbitro = cod_arb;
		this.data = data;
		this.gols_time01 = gols_time01;
		this.gols_time02 = gols_time02;
		this.local = local;
		this.hora = hora;
	}
	
	
	public Map<Integer, Jog_partida> get_dados_jog(){
		return dados_jog;
	}
	
	public String getPlacar() {
		String placar = Integer.toString(gols_time01)+ " x "+Integer.toString(gols_time02);
		return placar;
	}
}
