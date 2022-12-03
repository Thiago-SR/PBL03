package app.controller;

import java.net.URL;
import java.util.*;

import java.util.ResourceBundle;

import app.Main;
import app.model.Jogador;
import app.model.Posicao;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class dialogCadastroJogador {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField TextFildNome;

    @FXML
    private ComboBox<Posicao> cbPosicoes;

    @FXML
    private TextField TextFildSelecao;
    
    private Stage stage;
    private boolean clickconfirmar = false;
    Jogador jogador;
    List<Posicao> Posicoes = new ArrayList<Posicao>();
    ObservableList<Posicao> obsPosicoes;
    
    public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public boolean isClickconfirmar() {
		return clickconfirmar;
	}

	public void setClickconfirmar(boolean clickconfirmar) {
		this.clickconfirmar = clickconfirmar;
	}

	public Jogador getJogador() {
		return jogador;
	}

	public void setJogador(Jogador jogador) {
		this.jogador = jogador;
		this.TextFildNome.setText(jogador.getNome());
		//this.TextFildPosicao.setText(jogador.getPosicao());
	}

	@FXML
    void btncancelar(ActionEvent event) {

    }

    @FXML
    void btnconfirmar(ActionEvent event) {
    	String nome = this.TextFildNome.getText();
    	//String posicao = this.TextFildPosicao.getText();
    	String selecao = this.TextFildSelecao.getText();
    	this.jogador.setCod(10);
    	this.jogador.setNome(nome);
    	//this.jogador.setPosicao(posicao);
    	this.clickconfirmar =true;
    	this.stage.close();

    }

    @FXML
    void initialize() {
        carregarPosicoes();
    }
    
    public void carregarPosicoes() {
    	Posicao posi1 = new Posicao("Goleiro");
    	Posicao posi2 = new Posicao("Atacante");
    	Posicao posi3 = new Posicao("Lateral");
    	Posicao posi4 = new Posicao("Meio Campo");
    	Posicao posi5 = new Posicao("Zagueiro");
    	
    	this.Posicoes.add(posi1);
    	this.Posicoes.add(posi2);
    	this.Posicoes.add(posi3);
    	this.Posicoes.add(posi4);
    	this.Posicoes.add(posi5);
    	
    	obsPosicoes = FXCollections.observableList(Posicoes);
    	cbPosicoes.setItems(obsPosicoes);
    	
    }

}
