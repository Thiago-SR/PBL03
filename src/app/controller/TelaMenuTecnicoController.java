package app.controller;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

import app.Main;
import app.model.Selecao;
import app.model.Tecnico;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class TelaMenuTecnicoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Tecnico> TableViewTecnico;

    @FXML
    private TableColumn<Tecnico, Integer> codigoTecnico;

    @FXML
    private TableColumn<Tecnico, String> nomeTecnico;

    @FXML
    private TableColumn<Tecnico, String> selecaoTecnico;
    
    ObservableList TecnicoData;

    @FXML
    void btnEditar(ActionEvent event) throws IOException {
    	Tecnico tecnico = TableViewTecnico.getSelectionModel().getSelectedItem();
    	if(tecnico != null) {
	    	String selecao_antiga = tecnico.getSelecao();
	    	String nome = tecnico.getNome();
	    	boolean clickconfirmar = showTelaCadastro(tecnico);
	    	if(clickconfirmar) {
	    		Main.list_tecnico.editar(nome, tecnico.getNome());
	    		TecnicoData.remove(TecnicoData.indexOf(tecnico));
	    		TecnicoData.add(tecnico);
	    		if(selecao_antiga.equals(tecnico.getSelecao()) == false)
	                Main.list_sele.remove_tecnico(tecnico);
	    		TableViewTecnico.refresh();
	    	}
    	}
	    }
    
   

    @FXML
    void btnInserir(ActionEvent event) throws IOException {
    	Tecnico tecnico = new Tecnico(null, 0, null);
    	boolean clickconfirmar = showTelaCadastro(tecnico);
    	if(clickconfirmar) {
    		TecnicoData.add(tecnico);
    		TableViewTecnico.refresh();
    	}
    }

    @FXML
    void btnRemover(ActionEvent event) {
    	Tecnico tecnico = TableViewTecnico.getSelectionModel().getSelectedItem();
    	
    	if(tecnico != null) {
    		int index = TecnicoData.indexOf(tecnico);
    		TecnicoData.remove(index);
    		TableViewTecnico.refresh();
    	}
    }

    @FXML
    void initialize() {
        this.TecnicoData = FXCollections.observableList(Main.list_tecnico.listar());
        this.nomeTecnico.setCellValueFactory(new PropertyValueFactory<Tecnico, String>("Nome"));
        this.codigoTecnico.setCellValueFactory(new PropertyValueFactory<Tecnico,Integer>("Cod"));
        this.selecaoTecnico.setCellValueFactory(new PropertyValueFactory<Tecnico, String>("Selecao"));
        this.TableViewTecnico.setItems(TecnicoData);
    }
    
    public boolean showTelaCadastro(Tecnico tecnico) throws IOException {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(dialogCadastroSelecaoController.class.getResource("/app/view/dialogCadastroTecnico.fxml"));
    	GridPane page =  loader.load();
    	//Criando estagio de dialogo
    	Stage dialogStage = new Stage();
    	dialogStage.setTitle("Cadastro de tecnico");
    	Scene scene = new Scene(page);
    	dialogStage.setScene(scene);
    	
    	//Pegando o controller da tela de cadastro e setando o jogador
    	dialogCadastroTecnicoController controller = loader.getController();
    	controller.setStage(dialogStage);
    	controller.setTecnico(tecnico);
    	
    	//Mostra o dialog e espera o usuario fechar
    	dialogStage.showAndWait();
    	
    	return controller.isClickConfirmar();
    }

}
