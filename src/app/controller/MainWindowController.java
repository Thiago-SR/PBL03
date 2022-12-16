package app.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.ImageView;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class MainWindowController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private Button btnArbitro;

    @FXML
    private Button btnEliminatorias;

    @FXML
    private Button btnGrupos;

    @FXML
    private Button btnJogador;

    @FXML
    private Button btnPartidas;

    @FXML
    private Button btnPesquisar;

    @FXML
    private Button btnPreencher;

    @FXML
    private Button btnSelecao;

    @FXML
    private Button btnTecnico;

    @FXML
    private ImageView imagem;

    @FXML
    private BorderPane layoutprincipal;

    @FXML
    void menu_arbitro(ActionEvent event) throws IOException {
    	GridPane d = FXMLLoader.load(getClass().getResource("/app/view/TelaMenuArbitro.fxml"));
    	
    	layoutprincipal.setCenter(d);
    }

    @FXML
    void menu_grupos(ActionEvent event) throws IOException {
    	GridPane g =  FXMLLoader.load(getClass().getResource("/app/view/TelaFaseGrupo.fxml"));
    	
    	layoutprincipal.setCenter(g);
    }

    @FXML
    void menu_jogador(ActionEvent event) throws IOException {
    	GridPane a = FXMLLoader.load(getClass().getResource("/app/view/TelaMenuJogador.fxml"));
    	
    	layoutprincipal.setCenter(a);
    }

    @FXML
    void menu_partidas(ActionEvent event) {

    }

    @FXML
    void menu_selecao(ActionEvent event) throws IOException {
    	GridPane b = FXMLLoader.load(getClass().getResource("/app/view/TelaMenuSelecao.fxml"));
    	
    	layoutprincipal.setCenter(b);
    }

    @FXML
    void menu_tecnico(ActionEvent event) throws IOException {
    	GridPane c = FXMLLoader.load(getClass().getResource("/app/view/TelaMenuTecnico.fxml"));
    	layoutprincipal.setCenter(c);
    }
    
    @FXML
    void menu_eliminatorias(ActionEvent event) throws IOException {
    	GridPane e = FXMLLoader.load(getClass().getResource("/app/view/TelaMenuEliminatorias.fxml"));
    	layoutprincipal.setCenter(e);
    }
    
    @FXML
    void search(ActionEvent event) throws IOException {
        GridPane f = FXMLLoader.load(getClass().getResource("/app/view/TelaMenuPesquisar.fxml"));
    	layoutprincipal.setCenter(f);
    }

    @FXML
    void initialize() {
       
    }

}
