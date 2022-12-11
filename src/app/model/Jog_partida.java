package app.model;

public class Jog_partida {
	private int cod_jog;
	private int cod_part;
	private int quant_gols;
	private int card_amarelo;
	private int card_vermelho;
	/**
	 * 
	 * @param cod_jog Codigo do jogador
	 * @param cod_part Codigo da partida
	 * @param quant_gols Quantidades de gols que o jogador marcou na partida
	 * @param card_amarelo Quantidade de cartoes amarelos que o jogador recebeu na partida
	 * @param card_vermelho Quantidade cartoes vermelhos que o jogador recebeu na partida
	 */
	public Jog_partida(int cod_jog, int cod_part, int quant_gols, int card_amarelo,int card_vermelho) {
		this.cod_jog = cod_jog;
		this.cod_part = cod_part;
		this.quant_gols = quant_gols;
		this.card_amarelo = card_amarelo;
		this.card_vermelho = card_vermelho;
	}
	
	

	public int getCod_jog() {
		return cod_jog;
	}

	public void setCod_jog(int cod_jog) {
		this.cod_jog = cod_jog;
	}

	public int getCod_part() {
		return cod_part;
	}

	public void setCod_part(int cod_part) {
		this.cod_part = cod_part;
	}

	public int getQuant_gols() {
		return quant_gols;
	}

	public void setQuant_gols(int quant_gols) {
		this.quant_gols = quant_gols;
	}

	public int getCard_amarelo() {
		return card_amarelo;
	}

	public void setCard_amarelo(int card_amarelo) {
		this.card_amarelo = card_amarelo;
	}

	public int getCard_vermelho() {
		return card_vermelho;
	}

	public void setCard_vermelho(int card_vermelho) {
		this.card_vermelho = card_vermelho;
	}
	
	
}
