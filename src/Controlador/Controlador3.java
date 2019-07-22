/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Controlador;

import Vista.Ventana1;
import java.io.FileNotFoundException;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;

/**
 *
 * @author Usuario
 */
public class Controlador3 {
    private Ventana1 ventana;
    String nombreP;
    String tiempo;
    String interes;

    public Controlador3() throws FileNotFoundException {
        this.ventana = new Ventana1();
        this.ventana.getB1().setOnAction(new Evento());
        
    }
    public Ventana1 getVista(){
        return ventana;
    }
    private class Evento implements EventHandler<ActionEvent>{

        @Override
        public void handle(ActionEvent event) {
            nombreP= ventana.getH1().getText();
            tiempo= ventana.getH3().getText();
            interes= ventana.getH2().getText();
            System.out.println(nombreP+" "+ interes+ " "+ tiempo);
        }
        
    }
  
    
}
