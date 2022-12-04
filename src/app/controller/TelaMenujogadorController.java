package app.controller;

import java.io.IOException;
import java.net.URL;
import java.util.Collection;
import java.util.List;
import java.util.Map;
import java.util.ResourceBundle;
import java.util.Set;

import app.Main;
import app.model.Jogador;
import app.model.Selecao;
import javafx.beans.Observable;
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

public class TelaMenujogadorController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Jogador> TableViewJogadores;
    
    private ObservableList<Jogador> JogadorData;
    
    @FXML
    private Label labelJogadorPosicao;

    @FXML
    private Label labelJogadorSelecao;

    @FXML
    private Label labeljogadorGols;
    
    @FXML
    private TableColumn<Jogador, Integer> codcol;
    
    @FXML
    private TableColumn<Jogador, String> nomecol;

    @FXML
    void initialize() {
    	this.JogadorData = FXCollections.observableArrayList(  Main.list_jog.listar().values());      
        this.nomecol.setCellValueFactory(new PropertyValueFactory<Jogador,String>("Nome"));
        this.codcol.setCellValueFactory(new PropertyValueFactory<Jogador,Integer>("cod"));
        
        this.TableViewJogadores.setItems(JogadorData);
 
        this.TableViewJogadores.getSelectionModel().selectedItemProperty().addListener((observable,oldValue,newValue) -> selecionarItemTableViewJogador(newValue));
        
    }
    
    
    public void selecionarItemTableViewJogador(Jogador jogador) {
    	if(jogador != null) {
	    	this.labelJogadorSelecao.setText(jogador.getSelecao().getNome());
	    	this.labelJogadorPosicao.setText(jogador.getPosicao());
	    	this.labeljogadorGols.setText(String.valueOf(jogador.getNumGols()));
    	}
    
    }
    
    @FXML
    void btnEditar(ActionEvent event) throws IOException {
    	Jogador jog  = TableViewJogadores.getSelectionModel().getSelectedItem();
    	Selecao selecao_antiga = jog.getSelecao();
    	if(jog != null) {
    		boolean clickconfirmar = showTelaCadastro(jog);
        	if(clickconfirmar) {
        		Main.list_jog.editar(jog);
        		JogadorData.remove(JogadorData.indexOf(jog));
        		JogadorData.add(jog);
        		if(selecao_antiga.equals(jog.getSelecao()) == false) {
        			Main.list_sele.remover_jogador(selecao_antiga.getNome(), jog);
        		}
        	}
    	}
    }

    @FXML
    void btnInserir(ActionEvent event) throws IOException {
    	Jogador jog = new Jogador(null,0,null,null);
    	boolean clickconfirmar = showTelaCadastro(jog);
    	if(clickconfirmar) {
    		Main.list_jog.inserir(jog);
    		JogadorData.add(jog);
    		
    	}
    }

    @FXML
    void btnRemover(ActionEvent event) {
    	Jogador jog  = TableViewJogadores.getSelectionModel().getSelectedItem();
    	if(jog != null) {
    		Main.list_sele.remover_jogador(jog.getSelecao().getNome(), jog);
    		Main.list_jog.remover(jog.getCod());
    		JogadorData.remove(JogadorData.indexOf(jog));
    	}
    }
    
    public boolean showTelaCadastro(Jogador jog) throws IOException{
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(dialogCadastroJogador.class.getResource("/app/view/dialogCadastroJogador.fxml"));
    	AnchorPane page = (AnchorPane) loader.load();
    	//Criando estagio de dialogo
    	Stage dialogStage = new Stage();
    	dialogStage.setTitle("Cadastro de Jogadores");
    	Scene scene = new Scene(page);
    	dialogStage.setScene(scene);
    	
    	//Pegando o controller da tela de cadastro e setando o jogador
    	dialogCadastroJogador controller = loader.getController();
    	controller.setStage(dialogStage);
    	controller.setJogador(jog);
    	
    	//Mostra o dialog e espera o usuario fechar
    	dialogStage.showAndWait();
    	
    	return controller.isClickconfirmar();
    	
    }

}
