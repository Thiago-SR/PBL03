package app.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;

public class TelaExibirPartidaController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<?> TableViewJogadores;

    @FXML
    private TableColumn<?, ?> columGols;

    @FXML
    private TableColumn<?, ?> columNome;

    @FXML
    private Label lblArbitro;

    @FXML
    private Label lblData;

    @FXML
    private Label lblHora;

    @FXML
    private Label lblLocal;

    @FXML
    private Label lblPlacar;

    @FXML
    private Label lblSelecao01;

    @FXML
    private Label lblSelecao02;

    @FXML
    void btnSair(ActionEvent event) {

    }

    @FXML
    void initialize() {
        assert TableViewJogadores != null : "fx:id=\"TableViewJogadores\" was not injected: check your FXML file 'TelaExibirPartida.fxml'.";
        assert columGols != null : "fx:id=\"columGols\" was not injected: check your FXML file 'TelaExibirPartida.fxml'.";
        assert columNome != null : "fx:id=\"columNome\" was not injected: check your FXML file 'TelaExibirPartida.fxml'.";
        assert lblArbitro != null : "fx:id=\"lblArbitro\" was not injected: check your FXML file 'TelaExibirPartida.fxml'.";
        assert lblData != null : "fx:id=\"lblData\" was not injected: check your FXML file 'TelaExibirPartida.fxml'.";
        assert lblHora != null : "fx:id=\"lblHora\" was not injected: check your FXML file 'TelaExibirPartida.fxml'.";
        assert lblLocal != null : "fx:id=\"lblLocal\" was not injected: check your FXML file 'TelaExibirPartida.fxml'.";
        assert lblPlacar != null : "fx:id=\"lblPlacar\" was not injected: check your FXML file 'TelaExibirPartida.fxml'.";
        assert lblSelecao01 != null : "fx:id=\"lblSelecao01\" was not injected: check your FXML file 'TelaExibirPartida.fxml'.";
        assert lblSelecao02 != null : "fx:id=\"lblSelecao02\" was not injected: check your FXML file 'TelaExibirPartida.fxml'.";

    }

}
