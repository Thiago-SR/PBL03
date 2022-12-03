package app.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import app.Main;
import app.model.Arbitro;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TelaMenuArbitroController {

	@FXML
    private TableView<Arbitro> TableViewArbitro;
	 
	 
	@FXML
    private TableColumn<Arbitro, String> NomeCol;
    
    @FXML
    private TableColumn<Arbitro, Integer> CodigoCol;
	 
    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;
    
    
   

    
    ObservableList<Arbitro> ArbitroData;

    @FXML
    void lblEditar(MouseEvent event) throws IOException {
    	Arbitro arbitro = TableViewArbitro.getSelectionModel().getSelectedItem();
    	if(arbitro != null) {
	    	String nome = arbitro.getNome();
	    	boolean clickconfirmar= showTelaCadastro(arbitro);
	    	if(clickconfirmar) {
	    		Main.list_arbitro.editar(nome, arbitro.getNome());
	    		TableViewArbitro.refresh();
	    	}
    	}
    }

    @FXML
    void lblInserir(MouseEvent event) throws IOException {
    	Arbitro arbitro = new Arbitro(null,0);
    	boolean clickconfirmar= showTelaCadastro(arbitro);
    	if(clickconfirmar) {
    		//Main.list_arbitro.inserir(arbitro);
    		this.ArbitroData.add(arbitro);
    		this.TableViewArbitro.refresh();
    	}
    }

    @FXML
    void lblRemover(MouseEvent event) {
    	Arbitro arbitro = TableViewArbitro.getSelectionModel().getSelectedItem();
    	if(arbitro != null) {
    		Main.list_arbitro.remover(arbitro.getNome());
    		TableViewArbitro.refresh();
    	}
    }

    @FXML
    void initialize() {
    	this.ArbitroData = FXCollections.observableList(Main.list_arbitro.listar());
    	this.CodigoCol.setCellValueFactory(new PropertyValueFactory<Arbitro,Integer>("Codigo"));
    	this.NomeCol.setCellValueFactory(new PropertyValueFactory<Arbitro,String>("Nome"));
    	this.TableViewArbitro.setItems(ArbitroData);
    }
    
    public boolean showTelaCadastro(Arbitro arbitro) throws IOException {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(dialogCadastroArbitroController.class.getResource("/app/view/dialogCadastroArbitro.fxml"));
    	AnchorPane page = (AnchorPane) loader.load();
    	//Criando estagio de dialogo
    	Stage dialogStage = new Stage();
    	dialogStage.setTitle("Cadastro de arbitro");
    	Scene scene = new Scene(page);
    	dialogStage.setScene(scene);
    	
    	//Pegando o controller da tela de cadastro e setando o jogador
    	dialogCadastroArbitroController controller = loader.getController();
    	controller.setStage(dialogStage);
    	controller.setArbitro(arbitro);
    	
    	//Mostra o dialog e espera o usuario fechar
    	dialogStage.showAndWait();
    	
    	return controller.isClickConfirmar();
    }

}
