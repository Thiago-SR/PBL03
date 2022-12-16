package app.controller;

import java.net.URL;
import app.model.Preencher;
import app.Main;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.stage.Stage;

public class AutoPreencherController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnNao;

    @FXML
    private Button btnSim;
    
    private Stage stage;
    
    public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

    @FXML
    void btnNao(ActionEvent event) {
    	this.stage.close();
    }

    @FXML
    void btnSim(ActionEvent event) {
    	Preencher p = new Preencher();
    	p.MockSelecoes(Main.list_sele);
		p.MockTecnicos(Main.list_sele);
		p.MockJogadores(Main.list_sele);
		this.stage.close();
    }
    @FXML
    void initialize() {
        assert btnNao != null : "fx:id=\"btnNao\" was not injected: check your FXML file 'TelaAutoPreencher.fxml'.";
        assert btnSim != null : "fx:id=\"btnSim\" was not injected: check your FXML file 'TelaAutoPreencher.fxml'.";

    }

}
