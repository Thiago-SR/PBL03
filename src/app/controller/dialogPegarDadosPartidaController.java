package app.controller;

import java.net.URL;
import java.text.Format;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;

import app.Main;
import app.model.Arbitro;
import app.model.Cartoes;
import app.model.Jogador;
import app.model.Partida;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.DatePicker;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class dialogPegarDadosPartidaController {

	@FXML
	private ResourceBundle resources;

	@FXML
	private URL location;
	
   @FXML
    private DatePicker Data;
   
   @FXML
   private TextField Hora;

   @FXML
   private TextField TextFildLocal;

   @FXML
   private ComboBox<Arbitro> cbArbitro;
     
   @FXML
   private Label lblErroPg02;
   
   @FXML
   private Label lblErroPlacar;

	@FXML
	private TextField CadJogadorSelecao01;

	@FXML
	private TextField CadJogadorSelecao02;

	@FXML
	private TextField GolsJogadorSelecao01;

	@FXML
	private TextField GolsJogadorSelecao02;

	@FXML
	private TextField GolsSelecao01;

	@FXML
	private TextField GolsSelecao02;

	@FXML
	private ComboBox<Jogador> cbCardJogSelecao01;

	@FXML
	private ComboBox<Jogador> cbCardJogSelecao02;
	
	@FXML
    private ComboBox<Cartoes> cbCardColorSelecao01;

    @FXML
    private ComboBox<Cartoes> cbCardColorSelecao02;

	@FXML
	private ComboBox<Jogador> cbGolJogadorSelecao01;

	@FXML
	private ComboBox<Jogador> cbGolJogadorSelecao02;

	@FXML
	private Label lblMensagemCartoes;

	@FXML
	private Label lblMensagemGols;

	@FXML
	private Label lblSelecao01;

	@FXML
	private Label lblSelecao02;

	Partida partida;
	boolean ClickSalvar = false;
	Stage stage;

	ObservableList<Jogador> jogadoresselec01;
	ObservableList<Jogador> jogadoresselec02;
	ObservableList<Arbitro> arbitro;
	Map<Jogador, Integer> jogadores_gols_selecao01 = new HashMap<Jogador,Integer>();
	Map<Jogador, Integer> jogadores_gols_selecao02 = new HashMap<Jogador,Integer>();
	Map<Jogador, Integer> jogadores_cartoesVermelho_selecao01 = new HashMap<Jogador, Integer>();
	Map<Jogador, Integer> jogadores_cartoesAmarelo_selecao01 = new HashMap<Jogador, Integer>();
	Map<Jogador, Integer> jogadores_cartoesAmarelo_selecao02 = new HashMap<Jogador, Integer>();
	Map<Jogador, Integer> jogadores_cartoesVermelho_selecao02 = new HashMap<Jogador, Integer>();
	int somatorio_gol_selecao01 = 0;
	int somatorio_gol_selecao02 = 0;
	


	public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
		this.lblSelecao01.setText(partida.getSelecao01().getNome());
		this.lblSelecao02.setText(partida.getSelecao02().getNome());
		jogadoresselec01 = FXCollections.observableArrayList(this.partida.getSelecao01().getJogadores());
		jogadoresselec02 = FXCollections.observableArrayList(this.partida.getSelecao02().getJogadores());
		this.cbGolJogadorSelecao01.setItems(jogadoresselec01);
		this.cbGolJogadorSelecao02.setItems(jogadoresselec02);
		this.cbCardJogSelecao01.setItems(jogadoresselec01);
		this.cbCardJogSelecao02.setItems(jogadoresselec02);
		arbitro = FXCollections.observableArrayList(Main.list_arbitro.listar());
		this.cbArbitro.setItems(arbitro);
	}

	public boolean isClickSalvar() {
		return ClickSalvar;
	}

	public void setClickSalvar(boolean clickSalvar) {
		ClickSalvar = clickSalvar;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	@FXML
	void SalvarCardJogadorSelecao01(ActionEvent event) {
		Jogador jog = this.cbCardJogSelecao01.getValue();
		if(jog != null) {
			try{
				if(this.cbCardColorSelecao01.getValue() != null) {
					if(this.cbCardColorSelecao01.getValue().getTipo().equals("Amarelo")==true){
						this.jogadores_cartoesAmarelo_selecao01.put(jog,Integer.parseInt(this.CadJogadorSelecao01.getText()));
					}
					else{
						this.jogadores_cartoesVermelho_selecao01.put(jog,Integer.parseInt(this.CadJogadorSelecao01.getText()));
					}
				}
				else {
					this.lblMensagemCartoes.setText("*Selecione a cor do cartao!");
				}
			}
			catch(NumberFormatException b){
				this.lblMensagemCartoes.setText("*A entrada deve ser numerica!");
			}
		}
		else {
			this.lblMensagemCartoes.setText("*Selecione um jogador!");
		}
		
		
	}

	@FXML
	void SalvarCardJogadorSelecao02(ActionEvent event) {
		Jogador jog = this.cbCardJogSelecao02.getValue();
		if(jog != null) {
			try{
				if(this.cbCardColorSelecao02.getValue() != null) {
					if(this.cbCardColorSelecao02.getValue().getTipo().equals("Amarelo")==true){
						this.jogadores_cartoesAmarelo_selecao02.put(jog,Integer.parseInt(this.CadJogadorSelecao02.getText()));
					}
					else{
						this.jogadores_cartoesVermelho_selecao02.put(jog,Integer.parseInt(this.CadJogadorSelecao02.getText()));
					}
				}else {
					this.lblMensagemCartoes.setText("*Selecione a cor do cartao!");
				}
			}
			catch(NumberFormatException b){
				this.lblMensagemCartoes.setText("*A entrada deve ser numerica!");
			}
		}
		else {
			this.lblMensagemCartoes.setText("*Selecione um jogador!");
		}
		
	}

	@FXML
	int SalvarGolsJogadorSelecao01(ActionEvent event) {
		Jogador jog = this.cbGolJogadorSelecao01.getValue();
		if(jog !=null) {
			try {
				Integer.parseInt(this.GolsSelecao01.getText());
			}catch(NumberFormatException b) {
				
			}
			
			try {
				int gols = Integer.parseInt(this.GolsJogadorSelecao01.getText());
				
				
				if(somatorio_gol_selecao01+ gols != Integer.parseInt(this.GolsSelecao01.getText())) {
					throw new Exception();
				}
				somatorio_gol_selecao01 += gols;
				this.jogadores_gols_selecao01.put(jog, gols);
			}catch(NumberFormatException e) {
				this.lblMensagemGols.setText("A entrada deve ser numerica");
			}
			catch(Exception a) {
				
			}
		}
		else {
			this.lblMensagemGols.setText("*Selecione um jogador!");
		}
		
		return somatorio_gol_selecao01;
		
	}

	@FXML
	int SalvarGolsJogadorSelecao02(ActionEvent event) {
		Jogador jog = this.cbGolJogadorSelecao02.getValue();
		if(jog != null) {
			try {
				int gols = Integer.parseInt(this.GolsJogadorSelecao02.getText());
				
				
				if(somatorio_gol_selecao01+ gols != Integer.parseInt(this.GolsSelecao02.getText())) {
					throw new Exception();
				}
				somatorio_gol_selecao02 += gols;
				this.jogadores_gols_selecao02.put(jog, gols);
			}catch(NumberFormatException e) {
				this.lblMensagemGols.setText("A entrada deve ser numerica");
			}
			catch(Exception a) {
				
			}
		}else {
			this.lblMensagemGols.setText("*Selecione um jogador!");
		}
		
		return somatorio_gol_selecao02;
		
	}

	@FXML
	void SalvarPartida(ActionEvent event) {
		String day;
		String hora;
		
		int gols_time01 = SalvarGolsJogadorSelecao01(event);
		int gols_time02 = SalvarGolsJogadorSelecao02(event);
		
		String local = this.TextFildLocal.getText();
		try {// valida se a entrada esta no formato esperado
			String hora = this.Hora.getText();
			SimpleDateFormat formato = new SimpleDateFormat("HH:mm");
			Date hour = formato.parse(hora);
		} catch (java.text.ParseException e) {
			System.out.println("Horario invalido!");
			this.lblErroPg02.setText("Horario invalido");
		}
		try {// valida se a entrada esta no formato esperado
			LocalDate data = this.Data.getValue();
			String day = data.toString();
			SimpleDateFormat formato = new SimpleDateFormat("yyyy-mm-dd");
			Date date = formato.parse(day);
		} catch (java.text.ParseException a) {
			System.out.println("Data invalida!");
			this.lblErroPg02.setText("Data invalida");
		}
		Arbitro arbitro = this.cbArbitro.getValue();
		int cod_arbitro = arbitro.getCodigo();
		
		
		
		partida.inserir_dados(cod_arbitro, local, day, hora, gols_time01, gols_time02);
	}

	@FXML
	void btnCancelar(ActionEvent event) {

	}

	@FXML
	void initialize() {
		List<Cartoes> cartoes = new ArrayList<Cartoes>();
		Cartoes card1 = new Cartoes("Amarelo");
		Cartoes card2 = new Cartoes("Vermelho");
		cartoes.add(card1);
		cartoes.add(card2);
		ObservableList<Cartoes> obListCard = FXCollections.observableArrayList(cartoes);
		this.cbCardColorSelecao01.setItems(obListCard);
		this.cbCardColorSelecao02.setItems(obListCard);
		
		
		
		
	}

}
