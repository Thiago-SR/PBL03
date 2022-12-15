package app.controller;

import java.net.URL;
import java.util.*;

import app.Main;
import app.model.Jog_partida;
import app.model.Partida;
import app.model.Jogador;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.stage.Stage;

public class TelaExibirPartidaController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TableView<Jog_partida> TableViewJogadores;

    @FXML
    private TableColumn<Jog_partida, Integer> columGols;

    @FXML
    private TableColumn<Jog_partida, String> columNome;
    
    @FXML
    private TableColumn<Jog_partida, String>  columSelecao;

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
    
    Partida partida;
    Stage stage;

    public Partida getPartida() {
		return partida;
	}

	public void setPartida(Partida partida) {
		this.partida = partida;
		this.lblSelecao01.setText(this.partida.getSelecao01().getNome());
		this.lblSelecao02.setText(this.partida.getSelecao02().getNome());
		this.lblPlacar.setText(this.partida.getPlacar());
		this.lblData.setText(this.partida.getData());
		this.lblLocal.setText(this.partida.getLocal());
		this.lblHora.setText(this.partida.getHora());
		this.lblArbitro.setText(Main.list_arbitro.buscar_arbitro(this.partida.getCod_arbitro()).getNome());
		List<Jog_partida> dados_jogadores = new ArrayList<Jog_partida>();
		Map<Integer, Jog_partida> lista = this.partida.get_dados_jog();

		for (Map.Entry<Integer, Jog_partida> pair : lista.entrySet()) {
			if(pair.getValue().getQuant_gols()>0) {
				dados_jogadores.add(pair.getValue());
			}
		}
		ObservableList<Jog_partida> obs_dados = FXCollections.observableArrayList(dados_jogadores);
		this.columGols.setCellValueFactory(new PropertyValueFactory<Jog_partida,Integer>("Quant_gols"));
		this.columNome.setCellValueFactory(new PropertyValueFactory<Jog_partida, String>("Nome"));
		this.columSelecao.setCellValueFactory(new PropertyValueFactory<Jog_partida,String>("Selecao"));
		
		this.TableViewJogadores.setItems(obs_dados);
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	@FXML
    void btnSair(ActionEvent event) {
		this.stage.close();
    }

    @FXML
    void initialize() {
       
    }

}
