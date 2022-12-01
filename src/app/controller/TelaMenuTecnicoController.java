package app.controller;

import java.net.URL;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.TableColumn;
import javafx.scene.layout.VBox;

public class TelaMenuTecnicoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private VBox TableViewTecnico;

    @FXML
    private TableColumn<Tecnico, Integer> codigoTecnico;

    @FXML
    private TableColumn<Tecnico, String> nomeTecnico;

    @FXML
    private TableColumn<Tecnico, String> selecaoTecnico;

    @FXML
    void btnEditar(ActionEvent event) {

    }

    @FXML
    void btnInserir(ActionEvent event) {

    }

    @FXML
    void btnRemover(ActionEvent event) {

    }

    @FXML
    void initialize() {
        
    }

}
