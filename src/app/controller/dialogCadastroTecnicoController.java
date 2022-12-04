package app.controller;

import java.net.URL;
import java.util.ResourceBundle;

import app.Main;
import app.model.Selecao;
import app.model.Tecnico;
import app.Exceptions.NumJogException;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class dialogCadastroTecnicoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField TextFildNome;

    @FXML
    private TextField TextFildSelecao;
    
    @FXML
    private Label lblErroSelecao;
    
    Tecnico tecnico;
    boolean clickConfirmar = false;
    Stage stage;

    public Tecnico getTecnico() {
		return tecnico;
	}

	public void setTecnico(Tecnico tecnico) {
		this.tecnico = tecnico;
		TextFildNome.setText(tecnico.getNome());
		TextFildSelecao.setText(tecnico.getSelecao());
	}

	public boolean isClickConfirmar() {
		return clickConfirmar;
	}

	public void setClickConfirmar(boolean clickConfirmar) {
		this.clickConfirmar = clickConfirmar;
	}

	public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	@FXML
    void btncancelar(ActionEvent event) {
		this.stage.close();
    }

    @FXML
    void btnconfirmar(ActionEvent event) {
        try {
    		Selecao verifica_sele = Main.list_sele.procurar_selecao(TextFildSelecao.getText());
    		
    		if(verifica_sele == null) {
    			throw new RuntimeException();
    		}
    		else {
                String nome = TextFildNome.getText();
    			String sele = TextFildSelecao.getText();
                this.tecnico.setNome(TextFildNome.getText());
    			if(this.tecnico.getSelecao()!= null) {
	    			if(this.tecnico.getSelecao().equals(verifica_sele)== false) {
	    				Main.list_sele.inserir_tecnico(verifica_sele.getNome(), this.tecnico);
	    			}
    			}
    			else {
    				Main.list_sele.inserir_tecnico(verifica_sele.getNome(), this.tecnico);
    			}
    			this.tecnico.setSelecao(TextFildSelecao.getText());
    			tecnico.setSelecao(sele);
    			this.tecnico.setCod(Main.contador_tecnico);
    			Main.contador_jogador++;
    			this.clickConfirmar = true;
    			this.stage.close();
    		}
    	}
    	catch(RuntimeException e) {
    		lblErroSelecao.setText("Selecao nao encontrada!");
    		lblErroSelecao.setVisible(true);
    		
    	}
    	//catch(NumJogException a) {
    		//lblErroSelecao.setText("Selecao atingiu o limite de jogadores!");
    		//lblErroSelecao.setVisible(true);
    		
    	//}
        
        
        
    	
    }

    @FXML
    void initialize() {
       if(tecnico!= null) {
    	   TextFildSelecao.setVisible(false);
       }
    }

}
