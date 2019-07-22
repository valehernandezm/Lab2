/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Modelo.Aportante;
import Modelo.Persona;
import Modelo.Promotor;
import Vista.Registro;
import Vista.Vista;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.control.Alert;
import javafx.stage.Stage;
import Vista.Ingreso;
import javafx.scene.control.Button;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
/**
 *
 * @author Usuario
 */
public class Controlador2 {
    private Registro registro;
    private Promotor promotor;
    private Aportante aportante;
    ArrayList <Persona> Personas = new ArrayList<>();
    String nombre;
    String id;
    String usuario;
    String contraseña;
    String confirmacion;
    String rol;
    String aporte;
    

    public Controlador2() throws FileNotFoundException {
        this.registro = new Registro();
        this.registro.getB1().setOnAction(new Evento());
        this.registro.getB2().setOnAction(new Evento1());
        
    }
    public Registro getVista(){
    return registro;
}
    private class Evento1  implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            Controlador1 controlador= new Controlador1();
          Singleton singleton = Singleton.getSingleton();
          Stage stage = singleton.getStage();
          Vista vista= controlador.getVista();
          stage.setScene(vista.getScene());
          stage.show();
           
        }
        
    }
    private class Evento  implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
          
          
          /*Controlador1 controlador= new Controlador1();
          Singleton singleton = Singleton.getSingleton();
          Stage stage = singleton.getStage();
          Vista vista= controlador.getVista();
          stage.setScene(vista.getScene());
          stage.show();
           */ 
          
          nombre= registro.getH1().getText();
           id=registro.getH2().getText();
           usuario= registro.getH3().getText();
           contraseña= registro.getContraseña().getText();
           confirmacion= registro.getContraseña1().getText();
           rol= registro.getH6().getText();
           aporte= registro.getH7().getText();
            System.out.println(" "+contraseña);
            System.out.println(" "+confirmacion);
        
           if(contraseña == null ? confirmacion != null : !contraseña.equals(confirmacion)){
               Alert mensaje= new Alert(Alert.AlertType.ERROR);
               mensaje.setTitle("Error");
               mensaje.setHeaderText("Las contraseñas no coinciden");
               mensaje.showAndWait();
               
           }
           else{
                if(rol.equals("Aportante")){
              Personas.add(new Aportante(Integer.parseInt(aporte), nombre, Integer.parseInt(id), usuario, contraseña));
                  
            
                }
                else if(rol.equals("Promotor")){
                    Personas.add(new Promotor(nombre, Integer.parseInt(id), usuario, contraseña));
             
       
                }
            
       }
            System.out.println(" "+Personas.size());
            for(int i=0; i<Personas.size();i++){
                System.out.println(" "+Personas.get(i).Datos());
            }

        }}    
   /* public void leer(Button b){
        
       b.setOnAction(new EventHandler<ActionEvent> (){
       @Override
      
       
   });
            
    }*/

    public Registro getRegistro() {
        return registro;
    }

    public void setRegistro(Registro registro) {
        this.registro = registro;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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

    public String getConfirmacion() {
        return confirmacion;
    }

    public void setConfirmacion(String confirmacion) {
        this.confirmacion = confirmacion;
    }

    public String getRol() {
        return rol;
    }

    public void setRol(String rol) {
        this.rol = rol;
    }

    public String getAporte() {
        return aporte;
    }

    public void setAporte(String aporte) {
        this.aporte = aporte;
    }
    
}
