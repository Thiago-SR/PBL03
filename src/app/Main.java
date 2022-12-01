package app;


import java.net.URL;

import app.model.DAO_jogador;
import app.model.DAO_selecao;
import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {
	public static DAO_jogador list_jog = new DAO_jogador();
	public static DAO_selecao list_sele = new DAO_selecao();

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
