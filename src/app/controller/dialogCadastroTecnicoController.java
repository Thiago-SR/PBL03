package app.controller;

import java.net.URL;
import java.util.ResourceBundle;

import app.model.Tecnico;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class dialogCadastroTecnicoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField TextFildNome;

    @FXML
    private TextField TextFildSelecao;
    
    Tecnico tecnico;
    boolean clickConfirmar = false;
    Stage stage;

    public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
		TextFildNome.setText(tecnico.getNome());
		TextFildSelecao.setText(tecnico.getSelecao());
	}

	public boolean isClickConfirmar() {
		return clickConfirmar;
	}

	public void setClickConfirmar(boolean clickConfirmar) {
		this.clickConfirmar = clickConfirmar;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	@FXML
    void btncancelar(ActionEvent event) {
		this.stage.close();
    }

    @FXML
    void btnconfirmar(ActionEvent event) {
    	this.tecnico.setNome(TextFildNome.getText());
    	this.tecnico.setSelecao(TextFildSelecao.getText());;
    	this.clickConfirmar = true;
    	this.stage.close();
    }

    @FXML
    void initialize() {
       
    }

}
