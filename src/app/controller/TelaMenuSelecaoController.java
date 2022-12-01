package app.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

import app.Main;
import app.Selecao;
import app.Exceptions.NumSelecException;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

public class TelaMenuSelecaoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Selecao> TableViewSelecao;
    
    @FXML
    private TableColumn<Selecao, String> nomecol ;

    @FXML
    private Label lblGrupoSelecao;

    @FXML
    private Label lblPontosSelecao;

    @FXML
    private Label lblPosicaoGrupoSelecao;
    
    private ObservableList<Selecao> SelecaoData;
    
    
    


    @FXML
    void btnEditar(ActionEvent event) throws IOException {
    	Selecao sele = TableViewSelecao.getSelectionModel().getSelectedItem();
    	boolean clickconfirmar = showTelaCadastro(sele);
    	if(clickconfirmar) {
    		Main.list_sele.listar().add(Main.list_sele.listar().indexOf(sele), sele);
    		SelecaoData.add(SelecaoData, sele);
 
    	}
    }

    @FXML
    void btnInserir(ActionEvent event) throws IOException, NumSelecException {
    	Selecao selecao = new Selecao(null);
    	boolean clickconfirmar = showTelaCadastro(selecao);
    	if(clickconfirmar) {
    		Main.list_sele.inserir(selecao);
    		SelecaoData.add(selecao);
    	}
    }

    @FXML
    void btnRemover(ActionEvent event) {
    	Selecao sele = TableViewSelecao.getSelectionModel().getSelectedItem();
    	if(sele != null) {
    		Main.list_sele.remover(sele.getNome());
    		SelecaoData.remove(SelecaoData.indexOf(sele));
    	}
    }

    @FXML
    void btnVerEquipe(ActionEvent event) {

    }

    @FXML
    void initialize() throws NumSelecException {
    	Selecao sele = new Selecao("brasil");
    	Main.list_sele.inserir(sele);
    	Selecao sele2 = new Selecao("Argentina");
    	Main.list_sele.inserir(sele2);
    	this.SelecaoData =  FXCollections.observableList(Main.list_sele.listar());
    	this.nomecol.setCellValueFactory(new PropertyValueFactory<Selecao,String>("Nome"));
    	this.TableViewSelecao.setItems(SelecaoData);
    	 this.TableViewSelecao.getSelectionModel().selectedItemProperty().addListener((observable,oldValue,newValue)-> SelecionarItemTableViewSelecao(newValue));
    	
        
    }
    
    public boolean showTelaCadastro(Selecao selecao) throws IOException {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(dialogCadastroSelecaoController.class.getResource("/app/view/dialogCadastroSelecao.fxml"));
    	AnchorPane page = (AnchorPane) loader.load();
    	//Criando estagio de dialogo
    	Stage dialogStage = new Stage();
    	dialogStage.setTitle("Cadastro de selecao");
    	Scene scene = new Scene(page);
    	dialogStage.setScene(scene);
    	
    	//Pegando o controller da tela de cadastro e setando o jogador
    	dialogCadastroSelecaoController controller = loader.getController();
    	controller.setStage(dialogStage);
    	controller.setSelecao(selecao);
    	
    	//Mostra o dialog e espera o usuario fechar
    	dialogStage.showAndWait();
    	
    	return controller.isClickconfirmar();
    }
 
    
    public void SelecionarItemTableViewSelecao(Selecao selecao) {
    	if(selecao != null) {
    		this.lblGrupoSelecao.setText("Fase de grupos nao inicada");
    		this.lblPontosSelecao.setText("");
    		this.lblPosicaoGrupoSelecao.setText("");
    		
    	}
    }
    	
    	}

