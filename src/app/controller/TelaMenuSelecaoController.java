package app.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.List;
import java.util.ResourceBundle;

import app.Main;
import app.Exceptions.NumSelecException;
import app.model.Jogador;
import app.model.Selecao;
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
    void btnEditar(ActionEvent event) throws IOException, NumSelecException {
    	Selecao sele = TableViewSelecao.getSelectionModel().getSelectedItem();
    	if(sele != null) {
	    	String nome = sele.getNome();
	    	boolean clickconfirmar = showTelaCadastro(sele);
	    	if(clickconfirmar) {
	    		Main.list_sele.editar(nome, sele.getNome());
	    		TableViewSelecao.refresh();
	 
	    	}
    	}
    }

    @FXML
    void btnInserir(ActionEvent event) throws IOException, NumSelecException {
    	Selecao selecao = new Selecao(null);
    	boolean clickconfirmar = showTelaCadastro(selecao);
    	if(clickconfirmar) {
    		SelecaoData.add(selecao);
    		TableViewSelecao.refresh();
    		
    	}
    }

    @FXML
    void btnRemover(ActionEvent event) {
    	Selecao sele = TableViewSelecao.getSelectionModel().getSelectedItem();
    	if(sele != null) {
    		List<Jogador> lista_jog = sele.getJogadores();
    		for(Jogador i: lista_jog) {
                Main.list_jog.remover(i.getCod());
            }
    		Main.list_sele.remover(sele.getNome());
    		//SelecaoData.remove(SelecaoData.indexOf(sele));
    		TableViewSelecao.refresh();
    	}
    }

    @FXML
    void btnVerEquipe(ActionEvent event) {

    }

    @FXML
    void initialize() throws NumSelecException {
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

