package app.controller;

import java.io.IOException;
import java.net.URL;
import java.util.List;
import java.util.ResourceBundle;

import app.Main;
import app.Exceptions.NotTecnicoException;
import app.Exceptions.NumJogException;
import app.Exceptions.NumSelecException;
import app.Exceptions.SemArbitroException;
import app.model.Fase_grupo;
import app.model.Grupo;
import app.model.Partida;
import javafx.beans.Observable;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

public class TelaFaseGrupoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Partida> TableViewPartidasGrupo;

    @FXML
    private VBox VboxGrupoA;

    @FXML
    private VBox VboxGrupoB;

    @FXML
    private VBox VboxGrupoD;

    @FXML
    private VBox VboxGrupoE;

    @FXML
    private VBox VboxGrupoF;

    @FXML
    private VBox VboxGrupoG;

    @FXML
    private VBox VboxGrupoH;

    @FXML
    private Button btnEncerrarFaseGrupo;

    @FXML
    private Button btnIniciarFaseGrupo;

    @FXML
    private TableColumn<Partida, String> columPlacar;

    @FXML
    private TableColumn<Partida, String> columSelecao01;

    @FXML
    private TableColumn<Partida, String> columSelecao02;

    @FXML
    private Label lblGrupoASelecao01;

    @FXML
    private Label lblGrupoASelecao02;

    @FXML
    private Label lblGrupoASelecao03;

    @FXML
    private Label lblGrupoASelecao04;

    @FXML
    private Label lblGrupoAptSelecao01;

    @FXML
    private Label lblGrupoAptSelecao02;

    @FXML
    private Label lblGrupoAptSelecao03;

    @FXML
    private Label lblGrupoAptSelecao04;

    @FXML
    private Label lblGrupoBSelecao01;

    @FXML
    private Label lblGrupoBSelecao02;

    @FXML
    private Label lblGrupoBSelecao03;

    @FXML
    private Label lblGrupoBSelecao04;

    @FXML
    private Label lblGrupoBptSelecao01;

    @FXML
    private Label lblGrupoBptSelecao02;

    @FXML
    private Label lblGrupoBptSelecao03;

    @FXML
    private Label lblGrupoBptSelecao04;

    @FXML
    private Label lblGrupoCSelecao01;

    @FXML
    private Label lblGrupoCSelecao02;

    @FXML
    private Label lblGrupoCSelecao03;

    @FXML
    private Label lblGrupoCSelecao04;

    @FXML
    private Label lblGrupoCptSelecao01;

    @FXML
    private Label lblGrupoCptSelecao02;

    @FXML
    private Label lblGrupoCptSelecao03;

    @FXML
    private Label lblGrupoCptSelecao04;

    @FXML
    private Label lblGrupoDSelecao01;

    @FXML
    private Label lblGrupoDSelecao02;

    @FXML
    private Label lblGrupoDSelecao03;

    @FXML
    private Label lblGrupoDSelecao04;

    @FXML
    private Label lblGrupoDptSelecao01;

    @FXML
    private Label lblGrupoDptSelecao02;

    @FXML
    private Label lblGrupoDptSelecao03;

    @FXML
    private Label lblGrupoDptSelecao04;

    @FXML
    private Label lblGrupoESelecao01;

    @FXML
    private Label lblGrupoESelecao02;

    @FXML
    private Label lblGrupoESelecao03;

    @FXML
    private Label lblGrupoESelecao04;

    @FXML
    private Label lblGrupoEptSelecao01;

    @FXML
    private Label lblGrupoEptSelecao02;

    @FXML
    private Label lblGrupoEptSelecao03;

    @FXML
    private Label lblGrupoEptSelecao04;

    @FXML
    private Label lblGrupoFSelecao01;

    @FXML
    private Label lblGrupoFSelecao02;

    @FXML
    private Label lblGrupoFSelecao03;

    @FXML
    private Label lblGrupoFSelecao04;

    @FXML
    private Label lblGrupoFptSelecao01;

    @FXML
    private Label lblGrupoFptSelecao02;

    @FXML
    private Label lblGrupoFptSelecao03;

    @FXML
    private Label lblGrupoFptSelecao04;

    @FXML
    private Label lblGrupoGSelecao01;

    @FXML
    private Label lblGrupoGSelecao02;

    @FXML
    private Label lblGrupoGSelecao03;

    @FXML
    private Label lblGrupoGSelecao04;

    @FXML
    private Label lblGrupoGptSelecao01;

    @FXML
    private Label lblGrupoGptSelecao02;

    @FXML
    private Label lblGrupoGptSelecao03;

    @FXML
    private Label lblGrupoGptSelecao04;

    @FXML
    private Label lblGrupoHSelecao01;

    @FXML
    private Label lblGrupoHSelecao02;

    @FXML
    private Label lblGrupoHSelecao03;

    @FXML
    private Label lblGrupoHSelecao04;

    @FXML
    private Label lblGrupoHptSelecao01;

    @FXML
    private Label lblGrupoHptSelecao02;

    @FXML
    private Label lblGrupoHptSelecao03;

    @FXML
    private Label lblGrupoHptSelecao04;
    
    
    private boolean RunFaseGrupo =false;
    
    Grupo grupo01;
    Grupo grupo02;
    Grupo grupo03;
    Grupo grupo04;
    Grupo grupo05;
    Grupo grupo06;
    Grupo grupo07;
    Grupo grupo08;

    @FXML
    void ClickEncerrarFasegrupo(ActionEvent event) {

    }

    @FXML
    void ClickGrupoA(MouseEvent event) {
    	if(this.grupo01 != null) {
    		ObservableList<Partida> lista_partidas = FXCollections.observableArrayList(this.grupo01.getPartidas().values());
	    	this.columSelecao01.setCellValueFactory(new PropertyValueFactory<Partida,String>("Selecao01"));
	    	this.columSelecao02.setCellValueFactory(new PropertyValueFactory<Partida,String>("Selecao02"));
	    	this.columPlacar.setCellValueFactory(new PropertyValueFactory<Partida, String>("Placar"));
	    	TableViewPartidasGrupo.setItems((ObservableList<Partida>) lista_partidas);
    	}
    }

    @FXML
    void ClickGrupoB(MouseEvent event) {
    	if(this.grupo02 != null) {
    		ObservableList<Partida> lista_partidas = FXCollections.observableArrayList(this.grupo02.getPartidas().values());
	    	this.columSelecao01.setCellValueFactory(new PropertyValueFactory<Partida,String>("Selecao01"));
	    	this.columSelecao02.setCellValueFactory(new PropertyValueFactory<Partida,String>("Selecao02"));
	    	this.columPlacar.setCellValueFactory(new PropertyValueFactory<Partida, String>("Placar"));
	    	TableViewPartidasGrupo.setItems((ObservableList<Partida>) lista_partidas);
    	}
    }

    @FXML
    void ClickGrupoC(MouseEvent event) {
    	if(this.grupo03 != null) {
    		ObservableList<Partida> lista_partidas = FXCollections.observableArrayList(this.grupo03.getPartidas().values());
	    	this.columSelecao01.setCellValueFactory(new PropertyValueFactory<Partida,String>("Selecao01"));
	    	this.columSelecao02.setCellValueFactory(new PropertyValueFactory<Partida,String>("Selecao02"));
	    	this.columPlacar.setCellValueFactory(new PropertyValueFactory<Partida, String>("Placar"));
	    	TableViewPartidasGrupo.setItems((ObservableList<Partida>) lista_partidas);
    	}
    }

    @FXML
    void ClickGrupoD(MouseEvent event) {
    	if(this.grupo04 != null) {
    		ObservableList<Partida> lista_partidas = FXCollections.observableArrayList(this.grupo04.getPartidas().values());
			this.columSelecao01.setCellValueFactory(new PropertyValueFactory<Partida,String>("Selecao01"));
	    	this.columSelecao02.setCellValueFactory(new PropertyValueFactory<Partida,String>("Selecao02"));
	    	this.columPlacar.setCellValueFactory(new PropertyValueFactory<Partida, String>("Placar"));
	    	TableViewPartidasGrupo.setItems((ObservableList<Partida>) lista_partidas);
		}
    }

    @FXML
    void ClickGrupoE(MouseEvent event) {
    	if(this.grupo05 != null) {
    		ObservableList<Partida> lista_partidas = FXCollections.observableArrayList(this.grupo05.getPartidas().values());
	    	this.columSelecao01.setCellValueFactory(new PropertyValueFactory<Partida,String>("Selecao01"));
	    	this.columSelecao02.setCellValueFactory(new PropertyValueFactory<Partida,String>("Selecao02"));
	    	this.columPlacar.setCellValueFactory(new PropertyValueFactory<Partida, String>("Placar"));
	    	TableViewPartidasGrupo.setItems((ObservableList<Partida>) lista_partidas);
    	}
    }

    @FXML
    void ClickGrupoF(MouseEvent event) {
    	if(this.grupo06 != null) {
    		ObservableList<Partida> lista_partidas = FXCollections.observableArrayList(this.grupo06.getPartidas().values());
			this.columSelecao01.setCellValueFactory(new PropertyValueFactory<Partida,String>("Selecao01"));
	    	this.columSelecao02.setCellValueFactory(new PropertyValueFactory<Partida,String>("Selecao02"));
	    	this.columPlacar.setCellValueFactory(new PropertyValueFactory<Partida, String>("Placar"));
	    	TableViewPartidasGrupo.setItems((ObservableList<Partida>) lista_partidas);
		}
    }

    @FXML
    void ClickGrupoG(MouseEvent event) {
        if(this.grupo07 != null){
            ObservableList<Partida> lista_partidas = FXCollections.observableArrayList(this.grupo07.getPartidas().values());
	    	this.columSelecao01.setCellValueFactory(new PropertyValueFactory<Partida,String>("Selecao01"));
	    	this.columSelecao02.setCellValueFactory(new PropertyValueFactory<Partida,String>("Selecao02"));
	    	this.columPlacar.setCellValueFactory(new PropertyValueFactory<Partida, String>("Placar"));
	    	TableViewPartidasGrupo.setItems((ObservableList<Partida>) lista_partidas);
        }
    	
    }

    @FXML
    void ClickGrupoH(MouseEvent event) {
        if(this.grupo08 != null){
            ObservableList<Partida> lista_partidas = FXCollections.observableArrayList(this.grupo08.getPartidas().values());
	    	this.columSelecao01.setCellValueFactory(new PropertyValueFactory<Partida,String>("Selecao01"));
	    	this.columSelecao02.setCellValueFactory(new PropertyValueFactory<Partida,String>("Selecao02"));
	    	this.columPlacar.setCellValueFactory(new PropertyValueFactory<Partida, String>("Placar"));
	    	TableViewPartidasGrupo.setItems((ObservableList<Partida>) lista_partidas);
        }
    	
    }

    @FXML
    void ClickIniciarFaseGrupo(ActionEvent event) {
    	try {
			Fase_grupo faseGrupo = new Fase_grupo(Main.list_sele.listar());
			Main.faseGrupo = faseGrupo;
			this.btnIniciarFaseGrupo.setVisible(false);
			this.btnEncerrarFaseGrupo.setVisible(true);
			
			CarregarGrupos();
			Main.RunFaseGrupo = true;
			
		} catch (NumSelecException e) {
			
			e.printStackTrace();
		} catch (NumJogException e) {
			
			e.printStackTrace();
		} catch (NotTecnicoException e) {
			System.out.println(e.get_selecao());
			e.printStackTrace();
		} catch (SemArbitroException e) {
			
			e.printStackTrace();
		}
    }

    @FXML
    void btnFinalizarPartida(ActionEvent event) throws IOException {
    	Partida partida = TableViewPartidasGrupo.getSelectionModel().getSelectedItem();
    	if(partida != null) {
    		System.out.println(partida.getSelecao01());
    		boolean clickSalvar = ShowPegarDadosPartida(partida);
    		if(clickSalvar) {
    			this.TableViewPartidasGrupo.refresh();
    		}
    	}
    }

    @FXML
    void btnVerPartida(ActionEvent event) {

    }

    @FXML
    void initialize() {
        if(Main.RunFaseGrupo) {
        	CarregarGrupos();
        	this.btnEncerrarFaseGrupo.setVisible(true);     	
        }
        else
        	this.btnIniciarFaseGrupo.setVisible(true);
    }
    
    public boolean ShowPegarDadosPartida(Partida partida) throws IOException {
    	FXMLLoader loader = new FXMLLoader();
    	loader.setLocation(dialogPegarDadosPartidaController.class.getResource("/app/view/dialogPegarDadosPartida.fxml"));
    	GridPane page =  loader.load();
    	//Criando estagio de dialogo
    	Stage dialogStage = new Stage();
    	dialogStage.setTitle("Adicionar dados de partida");
    	Scene scene = new Scene(page);
    	dialogStage.setScene(scene);
    	
    	//Pegando o controller da tela de cadastro e setando o jogador
    	dialogPegarDadosPartidaController controller = loader.getController();
    	controller.setPartida(partida);
    	controller.setStage(dialogStage);
    	System.out.println("Setou partida");
    	//Mostra o dialog e espera o usuario fechar
    	dialogStage.showAndWait();
    	
    	return controller.isClickSalvar();
    }
    
    public void CarregarGrupos() {
    	this.grupo01 = Main.faseGrupo.get_grupos().get(0);
		this.grupo02 = Main.faseGrupo.get_grupos().get(1);
		this.grupo03 = Main.faseGrupo.get_grupos().get(2);
		this.grupo04 = Main.faseGrupo.get_grupos().get(3);
		this.grupo05 = Main.faseGrupo.get_grupos().get(4);
		this.grupo06 = Main.faseGrupo.get_grupos().get(5);
		this.grupo07 = Main.faseGrupo.get_grupos().get(6);
		this.grupo08 = Main.faseGrupo.get_grupos().get(7);
		
		this.lblGrupoASelecao01.setText(grupo01.getSelecoes().get(0).getNome());
		this.lblGrupoASelecao02.setText(grupo01.getSelecoes().get(1).getNome());
		this.lblGrupoASelecao03.setText(grupo01.getSelecoes().get(2).getNome());
		this.lblGrupoASelecao04.setText(grupo01.getSelecoes().get(3).getNome());
		
		this.lblGrupoBSelecao01.setText(grupo02.getSelecoes().get(0).getNome());
		this.lblGrupoBSelecao02.setText(grupo02.getSelecoes().get(1).getNome());
		this.lblGrupoBSelecao03.setText(grupo02.getSelecoes().get(2).getNome());
		this.lblGrupoBSelecao04.setText(grupo02.getSelecoes().get(3).getNome());
		
		this.lblGrupoCSelecao01.setText(grupo03.getSelecoes().get(0).getNome());
		this.lblGrupoCSelecao02.setText(grupo03.getSelecoes().get(1).getNome());
		this.lblGrupoCSelecao03.setText(grupo03.getSelecoes().get(2).getNome());
		this.lblGrupoCSelecao04.setText(grupo03.getSelecoes().get(3).getNome());
		
		this.lblGrupoDSelecao01.setText(grupo04.getSelecoes().get(0).getNome());
		this.lblGrupoDSelecao02.setText(grupo04.getSelecoes().get(1).getNome());
		this.lblGrupoDSelecao03.setText(grupo04.getSelecoes().get(2).getNome());
		this.lblGrupoDSelecao04.setText(grupo04.getSelecoes().get(3).getNome());
		
		this.lblGrupoESelecao01.setText(grupo05.getSelecoes().get(0).getNome());
		this.lblGrupoESelecao02.setText(grupo05.getSelecoes().get(1).getNome());
		this.lblGrupoESelecao03.setText(grupo05.getSelecoes().get(2).getNome());
		this.lblGrupoESelecao04.setText(grupo05.getSelecoes().get(3).getNome());
		
		this.lblGrupoFSelecao01.setText(grupo06.getSelecoes().get(0).getNome());
		this.lblGrupoFSelecao02.setText(grupo06.getSelecoes().get(1).getNome());
		this.lblGrupoFSelecao03.setText(grupo06.getSelecoes().get(2).getNome());
		this.lblGrupoFSelecao04.setText(grupo06.getSelecoes().get(3).getNome());
		
		this.lblGrupoGSelecao01.setText(grupo07.getSelecoes().get(0).getNome());
		this.lblGrupoGSelecao02.setText(grupo07.getSelecoes().get(1).getNome());
		this.lblGrupoGSelecao03.setText(grupo07.getSelecoes().get(2).getNome());
		this.lblGrupoGSelecao04.setText(grupo07.getSelecoes().get(3).getNome());
		
		this.lblGrupoHSelecao01.setText(grupo08.getSelecoes().get(0).getNome());
		this.lblGrupoHSelecao02.setText(grupo08.getSelecoes().get(1).getNome());
		this.lblGrupoHSelecao03.setText(grupo08.getSelecoes().get(2).getNome());
		this.lblGrupoHSelecao04.setText(grupo08.getSelecoes().get(3).getNome());
    }

}
