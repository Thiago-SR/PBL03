package app.controller;

import java.io.IOException;
import java.net.URL;
import java.text.SimpleDateFormat;
import java.util.*;

import app.Main;
import app.Exceptions.NotTecnicoException;
import app.Exceptions.NumJogException;
import app.Exceptions.NumSelecException;
import app.Exceptions.SemArbitroException;
import app.model.Categorias;
import app.model.Selecao;
import app.model.Fase_grupo;
import app.model.Grupo;
import app.model.Partida;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import app.model.Jogador;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

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

	@FXML
	private Label nomeSelecao;

	@FXML
	private Label nomeTecnico;

	@FXML
	private TableView<Jogador> tableView;

	@FXML
	private TableColumn<Jogador, String> Jogador;

	@FXML
	private TableColumn<Jogador, Integer> codJogador;

	private ObservableList<Jogador> JogadorData;
	
	List<Grupo> grupos =  new ArrayList<Grupo>();

	List<Categorias> categorias = new ArrayList<Categorias>();
	
	static Fase_grupo fasegrp;

	@FXML
	void btnBuscar(ActionEvent event) throws IOException {
		if (this.cbCategorias != null) {
			if (this.cbCategorias.getValue().getNome().equals("Jogador") == true) {
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(TelaMenujogadorController.class.getResource("/app/view/TelaMenuJogador.fxml"));
				GridPane a = loader.load();
				TelaMenujogadorController controller = loader.getController();
				controller.SetarVisiilidadebtn();
				Jogador jog = Main.list_jog.procurar_jogador(tfBuscar.getText());
				controller.JogadorBusca(jog.getNome());
				this.layoutPrincipal.setCenter(a);
			}

			if (this.cbCategorias.getValue().getNome().equals("Selecao") == true) {
				if (this.tfBuscar.equals("") != true) {

					this.layoutPrincipal.getChildren().get(2).setVisible(true);

					Selecao selecao = Main.list_sele.procurar_selecao(tfBuscar.getText());
					String nome = selecao.getNome();
					String tecnico = selecao.getTecnico().getNome();
					this.nomeSelecao.setText(nome);
					this.nomeTecnico.setText(tecnico);

					this.JogadorData = FXCollections.observableArrayList(selecao.getJogadores());
					this.Jogador.setCellValueFactory(new PropertyValueFactory<Jogador, String>("Nome"));
					this.codJogador.setCellValueFactory(new PropertyValueFactory<Jogador, Integer>("cod"));

					this.tableView.setItems(JogadorData);

				}
			}

			if (this.cbCategorias.getValue().getNome().equals("Tecnico") == true) {
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(TelaMenuTecnicoController.class.getResource("/app/view/TelaMenuTecnico.fxml"));
				GridPane c = loader.load();
				TelaMenuTecnicoController controller = loader.getController();
				controller.SetarVisiilidadebtn();
				this.layoutPrincipal.setCenter(c);

			}

			if (this.cbCategorias.getValue().getNome().equals("Arbitro") == true) {
				FXMLLoader loader = new FXMLLoader();
				loader.setLocation(TelaMenuArbitroController.class.getResource("/app/view/TelaMenuArbitro.fxml"));
				GridPane d = loader.load();
				TelaMenuArbitroController controller = loader.getController();
				controller.SetarVisiilidadebtn();
				this.layoutPrincipal.setCenter(d);

			}

			if (this.cbCategorias.getValue().getNome().equals("Partida") == true) {
				String data = null;
				try {
					data = tfBuscar.getText();
					SimpleDateFormat formato = new SimpleDateFormat("dd/MM/yyyy");
					Date date = formato.parse(data);
				} catch (java.text.ParseException e) {
					lblErro.setVisible(true);
					lblErro.setText("Data invalida!!!");	
				}
				List<Grupo> grupos = Main.faseGrupo.get_grupos();
				Iterator<Grupo> itr = grupos.iterator();
				while(itr.hasNext()) {
					Grupo grupo = itr.next();
					Map<Integer, Partida> partidas = grupo.getPartidas();
					for (Map.Entry<Integer, Partida> pair : partidas.entrySet()) {
						if(pair.getValue().getData() != null) {
							if(pair.getValue().getData().equals(data)==true) {
								FXMLLoader loader = new FXMLLoader();
						    	loader.setLocation(TelaExibirPartidaController.class.getResource("/app/view/TelaExibirPartida.fxml"));
						    	GridPane page =  loader.load();
						    	
						    	
						    	//Criando estagio de dialogo
						    	Stage dialogStage = new Stage();
						    	dialogStage.setTitle("Dados da Partida");
						    	Scene scene = new Scene(page);
						    	dialogStage.setScene(scene);
						    	
						    	//Pegando o controller da tela de cadastro e setando o jogador
						    	TelaExibirPartidaController controller = loader.getController();
						    	controller.setPartida(pair.getValue());
						    	controller.setStage(dialogStage);
						    	
						    	//Mostra o dialog e espera o usuario fechar
						    	this.layoutPrincipal.setCenter(page);
						    	//dialogStage.showAndWait();
							}
						}	
					}
				}
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
