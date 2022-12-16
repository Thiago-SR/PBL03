package app.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;

public class TelaMenuPesquisarController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private ComboBox<?> cbJogador;

    @FXML
    private ComboBox<?> cbOpcao;

    @FXML
    private Label lblCodigo;

    @FXML
    private Label lblNome;

    @FXML
    private Label lblSelecao;

    @FXML
    private Label lblnomeJogadores;

    @FXML
    private Label lblnomeSelecao;

    @FXML
    private Label lblnomecodigo;

    @FXML
    private Label lblnomedata;

    @FXML
    private TextField textFieldCodigo;

    @FXML
    private TextField textFieldData;

    @FXML
    private TextField textFieldNome;

    @FXML
    void btnBuscar(ActionEvent event) {

    }
    
    private boolean opcJogador = false;
    private boolean opcSelecao = false;
    private boolean opcArbitro = false;
    private boolean opcPartida = false;
    private boolean opcTecnico = false;

    @FXML
    void initialize() {
        if (opcJogador == true) {
        	this.lblnomecodigo.setVisible(false);
        	this.textFieldCodigo.setVisible(false);
        	this.lblnomedata.setVisible(false);
        	this.textFieldData.setVisible(false);
        	this.lblnomeJogadores.setVisible(false);
        	this.cbJogador.setVisible(false);
        	
        }
        if(opcSelecao == true) {
        	this.lblnomecodigo.setVisible(false);
        	this.textFieldCodigo.setVisible(false);
        	this.lblnomedata.setVisible(false);
        	this.textFieldData.setVisible(false);
        	this.lblnomeSelecao.setVisible(false);
        	this.lblSelecao.setVisible(false);
        }
        if(opcArbitro == true) {
        	this.lblnomecodigo.setVisible(false);
        	this.textFieldCodigo.setVisible(false);
        	this.lblnomedata.setVisible(false);
        	this.textFieldData.setVisible(false);
        	this.lblnomeSelecao.setVisible(false);
        	this.lblSelecao.setVisible(false);
        	this.cbJogador.setVisible(false);
        	this.lblnomeJogadores.setVisible(false);
        }
        if(opcPartida == true) {
        	this.lblnomeSelecao.setVisible(false);
        	this.lblSelecao.setVisible(false);
        	this.cbJogador.setVisible(false);
        	this.lblnomeJogadores.setVisible(false);
        	this.lblnomeSelecao.setVisible(false);
        	this.textFieldNome.setVisible(false);
        }
        if(opcTecnico == true) {
        	this.lblnomecodigo.setVisible(false);
        	this.textFieldCodigo.setVisible(false);
        	this.lblnomedata.setVisible(false);
        	this.textFieldData.setVisible(false);
        	this.cbJogador.setVisible(false);
        	this.lblnomeJogadores.setVisible(false);
        }

    }

}
