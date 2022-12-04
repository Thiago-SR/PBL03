package app.controller;

import java.net.URL;
import java.util.ResourceBundle;

import app.Main;
import app.Exceptions.CampoVazio;
import app.Exceptions.NumSelecException;
import app.Exceptions.SelecaoExisting;
import app.model.Selecao;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class dialogCadastroSelecaoController {

    @FXML
    private ResourceBundle resources;

    @FXML
    private URL location;

    @FXML
    private TextField TextFildNome;
    
    @FXML
    private Label lblErroSelecao;
    
    private Stage stage;
    private boolean clickconfirmar = false;
    Selecao selecao;

    public Stage getStage() {
		return stage;
	}

	public void setStage(Stage stage) {
		this.stage = stage;
	}

	public boolean isClickconfirmar() {
		return clickconfirmar;
	}

	public void setClickconfirmar(boolean clickconfirmar) {
		this.clickconfirmar = clickconfirmar;
	}

	public Selecao getSelecao() {
		return selecao;
	}

	public void setSelecao(Selecao selecao) {
		this.selecao = selecao;
		this.TextFildNome.setText(selecao.getNome());
	}

	@FXML
    void btnCancelar(ActionEvent event) {
		this.stage.close();
    }

    @FXML
    void btnConfirmar(ActionEvent event) {
    	try {
    		String nome = TextFildNome.getText();
    		if(nome.equals("")==true) {
    			throw new CampoVazio();
    		}
    		Selecao verifica_sele = Main.list_sele.procurar_selecao(nome);
    		if(verifica_sele != null) {
    			throw new SelecaoExisting();
    		}
    		else {
    			
    			if(this.selecao.getNome() == null) {
	    			this.selecao.setNome(nome);
					Main.list_sele.inserir(selecao);// CASO O NUMERO DE SELECOES TENHA ATINGIDO O LIMITE UMA EXCECAO E GERADA
					Main.list_sele.remover(selecao.getNome());
    			}
    			else {this.selecao.setNome(nome);}
				this.clickconfirmar = true;
				this.stage.close();
				 
    		}
    	}
    	catch(SelecaoExisting e) {
    		lblErroSelecao.setText("Selecao ja existe!");
    		lblErroSelecao.setVisible(true);
    	}
    	catch (NumSelecException e) {
    		lblErroSelecao.setText("Numero de selecoes cadastrada chegou ao limite!");
    		lblErroSelecao.setVisible(true);
		}
    	catch(CampoVazio b) {
    		lblErroSelecao.setText(b.getMessage());
    		lblErroSelecao.setVisible(true);
    	}
    	
    	//this.selecao.setNome(nome);
    	//this.clickconfirmar = true;
    	//this.stage.close();*/
    }

    @FXML
    void initialize() {
            }

}
