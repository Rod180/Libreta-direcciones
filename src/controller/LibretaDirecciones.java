/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controller;

import java.io.IOException;
import java.net.URL;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.application.Application;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.collections.ObservableList;
import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import model.Persona;
import view.VistaPersonaController;
/**
 *
 * @author dam
 */
public class LibretaDirecciones extends Application {
   private ObservableList datosPersona = FXCollections.observableArrayList(); 
    private Stage escenarioPrincipal;
    private BorderPane layoutPrincipal;
    private AnchorPane vistaPersona;
    
    public LibretaDirecciones(){
        datosPersona.add(new Persona("Jairo", "García Rincón"));
        datosPersona.add(new Persona("Juan", "Pérez Martínez"));
        datosPersona.add(new Persona("Andrea", "Chenier López"));
        datosPersona.add(new Persona("Emilio", "González Pla"));
        datosPersona.add(new Persona("Mónica", "de Santos Sánchez"));
    }
     //Método para devolver los datos como lista observable de personas
    public ObservableList getDatosPersona() {
        return datosPersona;
    }

    @Override
    public void start(Stage escenarioPrincipal) {
        this.escenarioPrincipal = escenarioPrincipal;
        //pongo el titulo
        this.escenarioPrincipal.setTitle("Libreta de direcciones");
        //inicializa el layout principal 
        initLayoutPrincipal();
        //muestra la vista persona
        muestraPersona();
    }

    public void initLayoutPrincipal() {
        //cargar el layout principal mediante la vista principal 
        FXMLLoader loader = new FXMLLoader();
        URL location = LibretaDirecciones.class.getResource("../view/VistaPrincipal.fxml");
        loader.setLocation(location);
        try {
            layoutPrincipal = loader.load();
        } catch (IOException ex) {
          
        }
        
        Scene escena = new Scene(layoutPrincipal);
        escenarioPrincipal.setScene(escena);
        escenarioPrincipal.show();
    }

    public void muestraPersona() {
         FXMLLoader loader = new FXMLLoader();
         URL location = LibretaDirecciones.class.getResource("../view/VistaPersona.fxml");
         loader.setLocation(location);
         try {
            vistaPersona = loader.load();
        } catch (IOException ex) {
          
        }
        //añado a centro la vista persona
        layoutPrincipal.setCenter(vistaPersona);
        VistaPersonaController controller = loader.getController();
        controller.setLibretaDirecciones(this);
    }

    public Stage getPrimaryStage(){
        return escenarioPrincipal;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        launch(args);
    }

}
