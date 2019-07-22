/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.Ingreso;
import Vista.Vista;
import java.io.FileNotFoundException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

/**
 *
 * @author Usuario
 */
public class Controlador1 {
    private Ingreso ingreso;
    String usuario;
    String contraseña;
    public Controlador1(){
        this.ingreso= new Ingreso();
        this.ingreso.getH1().setOnAction(new EventoSiguiente()); 
        this.ingreso.getB1().setOnAction(new Evento2());
    }
    public Ingreso getVista(){
        return ingreso;
    }
    
    private class EventoSiguiente implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
           
           Singleton singleton = Singleton.getSingleton();
           Stage stage = singleton.getStage();
            try {
                Controlador2 controlador= new Controlador2();
                Vista vista= controlador.getVista();
                stage.setScene(vista.getScene());
                stage.show();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Controlador1.class.getName()).log(Level.SEVERE, null, ex);
            }
           
        }
        
    }
    private class Evento2 implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            usuario= ingreso.getUsuario().getText();
            contraseña= ingreso.getContraseña().getText();
            
            Singleton singleton = Singleton.getSingleton();
            Stage stage = singleton.getStage();
           
            try {
                Controlador3 controlador1= new Controlador3();
                Vista vista1= controlador1.getVista();
                stage.setScene(vista1.getScene());
                stage.show();
            } catch (FileNotFoundException ex) {
                Logger.getLogger(Controlador1.class.getName()).log(Level.SEVERE, null, ex);
            }
            
   
           
        }
    
}

    public Ingreso getIngreso() {
        return ingreso;
    }

    public void setIngreso(Ingreso ingreso) {
        this.ingreso = ingreso;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public String getContraseña() {
        return contraseña;
    }

    public void setContraseña(String contraseña) {
        this.contraseña = contraseña;
    }
    
    
}
