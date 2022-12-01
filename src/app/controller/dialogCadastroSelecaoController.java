package app.controller;

import java.net.URL;
import java.util.ResourceBundle;

import app.Main;
import app.model.Selecao;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class dialogCadastroSelecaoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField TextFildNome;
    
    private Stage stage;
    private boolean clickconfirmar = false;
    Selecao selecao;

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

	public Selecao getSelecao() {
		return selecao;
	}

	public void setSelecao(Selecao selecao) {
		this.selecao = selecao;
	}

	@FXML
    void btnCancelar(ActionEvent event) {

    }

    @FXML
    void btnConfirmar(ActionEvent event) {
    	String nome = TextFildNome.getText();
    	this.selecao.setNome(nome);
    	this.clickconfirmar = true;
    	this.stage.close();
    }

    @FXML
    void initialize() {
            }

}
