package app;


import java.net.URL;

import app.model.DAO_jogador;
import app.model.DAO_selecao;
import app.model.DAO_tecnico;
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
	static int contador_jogador = 1000;
	static int contador_tecnico = 100;
	static int contador_arbitro = 10;
	@Override
	public void start(Stage primaryStage) throws Exception {
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
