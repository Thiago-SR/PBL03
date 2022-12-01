package app.controller;

import java.net.URL;
import java.util.ResourceBundle;

import app.Jogador;
import app.Main;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
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
    private TextField TextFildPosicao;

    @FXML
    private TextField TextFildSelecao;
    
    private Stage stage;
    private boolean clickconfirmar = false;
    Jogador jogador;

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
		this.TextFildPosicao.setText(jogador.getPosicao());
	}

	@FXML
    void btncancelar(ActionEvent event) {

    }

    @FXML
    void btnconfirmar(ActionEvent event) {
    	String nome = this.TextFildNome.getText();
    	String posicao = this.TextFildPosicao.getText();
    	String selecao = this.TextFildSelecao.getText();
    	this.jogador.setCod(10);
    	this.jogador.setNome(nome);
    	this.jogador.setPosicao(posicao);
    	this.clickconfirmar =true;
    	this.stage.close();

    }

    @FXML
    void initialize() {
        
    }

}
