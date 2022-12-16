package app.controller;

import java.io.IOException;
import java.net.URL;
import java.util.*;
import java.util.ResourceBundle;

import app.model.Categorias;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;

public class TelaPesquisarController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    @FXML
    private BorderPane layoutPrincipal;

    @FXML
    private ComboBox<Categorias> cbCategorias;

    @FXML
    private TextField tfBuscar;
    
    @FXML
    private Label lblErro;
    
    List<Categorias> categorias = new ArrayList<Categorias>();

    @FXML
    void btnBuscar(ActionEvent event) throws IOException {
    	System.out.println("Chegou aq");
		if(this.cbCategorias != null) {
			if(this.cbCategorias.getValue().getNome().equals("Jogador") ==true ){
                FXMLLoader loader = new FXMLLoader();
			    loader.setLocation(TelaMenujogadorController.class.getResource("/app/view/TelaMenuJogador.fxml"));
		    	GridPane a = loader.load();
		    	TelaMenujogadorController controller = loader.getController();
		    	//controller.SetarVisibilidadebtn();
		    	
		    	this.layoutPrincipal.setCenter(a);
            }
			
			if (this.cbCategorias.getValue().getNome().equals("Selecao") == true) {
				System.out.println("afaino");
				if(this.tfBuscar.equals("") !=true ) {
					System.out.println("afaino");
					this.layoutPrincipal.getChildren().get(2).setVisible(true);
				}
				}
			
			if(this.cbCategorias.getValue().getNome().equals("Tecnico") ==true ){
                FXMLLoader loader = new FXMLLoader();
			    loader.setLocation(TelaMenuTecnicoController.class.getResource("/app/view/TelaMenuTecnico.fxml"));
		    	GridPane c = loader.load();
		    	TelaMenujogadorController controller = loader.getController();
		    	controller.SetarVisiilidadebtn();
		    	this.layoutPrincipal.setCenter(c);
				
			}
			
			if(this.cbCategorias.getValue().getNome().equals("Arbitro") ==true ){
                FXMLLoader loader = new FXMLLoader();
			    loader.setLocation(TelaMenuArbitroController.class.getResource("/app/view/TelaMenuArbitro.fxml"));
		    	GridPane d = loader.load();
		    	TelaMenujogadorController controller = loader.getController();
		    	controller.SetarVisiilidadebtn();
		    	this.layoutPrincipal.setCenter(d);
				
			}
			
			if(this.cbCategorias.getValue().getNome().equals("Partida") ==true ){
			    
			}
		}
		
			
		
    }
    
    

    @FXML
    void initialize() {
    	this.layoutPrincipal.getChildren().get(2).setVisible(false);
        Categorias categoria01 = new Categorias("Jogador");
        Categorias categoria02 = new Categorias("Selecao");
        Categorias categoria03 = new Categorias("Tecnico");
        Categorias categoria04 = new Categorias("Arbitro");
        Categorias categoria05 = new Categorias("Partida");
        
        this.categorias.add(categoria01);
        this.categorias.add(categoria02);
        this.categorias.add(categoria03);
        this.categorias.add(categoria04);
        this.categorias.add(categoria05);
        
        ObservableList<Categorias> obs_list = FXCollections.observableArrayList(this.categorias);
        cbCategorias.setItems(obs_list);
        
    }

}
