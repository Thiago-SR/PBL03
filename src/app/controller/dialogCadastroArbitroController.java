package app.controller;

import java.net.URL;
import java.util.ResourceBundle;

import app.model.Arbitro;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;

public class dialogCadastroArbitroController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    public Arbitro getArbitro() {
		return arbitro;
	}

	public void setArbitro(Arbitro arbitro) {
		this.arbitro = arbitro;
		TextFildNome.setText(arbitro.getNome());
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public boolean isClickConfirmar() {
		return clickConfirmar;
	}

	public void setClickConfirmar(boolean clickConfirmar) {
		this.clickConfirmar = clickConfirmar;
	}

	Arbitro arbitro;
    Stage stage;
    boolean clickConfirmar =false;
    
    @FXML
    private TextField TextFildNome;
    @FXML
    private Label lblErro;

    @FXML
    void lblCancelar(MouseEvent event) {
    	this.stage.close();
    }

    @FXML
    void lblConfirmar(MouseEvent event) {
    	String nome = this.TextFildNome.getText();
    	this.arbitro.setNome(nome);
    	this.clickConfirmar = true;
    	this.stage.close();

    	}


    @FXML
    void initialize() {
    	TextFildNome.setPromptText("AFKJABNFJAHBA");
    }

}
