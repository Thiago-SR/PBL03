package app;


import java.net.URL;

import app.model.DAO_jogador;
import app.model.DAO_selecao;
import app.model.DAO_tecnico;
import app.model.Fase_grupo;
import app.model.Preencher;
import app.model.DAO_arbitro;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	public static DAO_jogador list_jog = new DAO_jogador();
	public static DAO_selecao list_sele = new DAO_selecao();
	public static DAO_tecnico list_tecnico = new DAO_tecnico();
	public static DAO_arbitro list_arbitro = new DAO_arbitro();
	public static int contador_jogador = 1000;
	public static int contador_tecnico = 100;
	public static int contador_arbitro = 10;
	public static Fase_grupo faseGrupo;
	public static boolean RunFaseGrupo = false;
	public static boolean FimFaseGrupo = false;
	@Override
	public void start(Stage primaryStage) throws Exception {
		Preencher p = new Preencher();
		p.MockSelecoes(list_sele);
		p.MockTecnicos(list_sele);
		p.MockJogadores(list_sele);
		
		FXMLLoader loader = new FXMLLoader();
		URL xmlURL = getClass().getResource("view/MainWindow.fxml");
		loader.setLocation(xmlURL);
		
		Parent parent  = loader.load();
		Scene scene = new Scene(parent);
		primaryStage.setScene(scene);
		primaryStage.show();
		
	}

	public static void main(String[] args) {
		launch(args);
	}
}
