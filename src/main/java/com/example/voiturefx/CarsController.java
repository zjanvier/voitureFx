package com.example.voiturefx;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ArrayList;
import java.util.Optional;
import java.util.ResourceBundle;
import javafx.event.ActionEvent;
import javafx.scene.input.KeyEvent;

public class CarsController implements Initializable
{

    @FXML
    private Button btnAjouter;

    @FXML
    private Button btnEffacer;

    @FXML
    private Button btnEnlever;

    @FXML
    private Button btnModifier;

    @FXML
    private ComboBox<Car> cboCars;

    @FXML
    private TextField txtannee;

    @FXML
    private TextField txtcarId;

    @FXML
    private TextField txtmarque;

    @FXML
    private TextField txtmodele;


    CarManager carManager=new CarManager();


    @Override
    public void initialize(URL url, ResourceBundle resourceBundle)
    {

        ObservableList<Car>carList=carManager.loadCarsFromTextFile("cars.txt");
        cboCars.setItems(carList);
        cboCars.valueProperty().addListener((obs, oldVal, newVal) ->showCars(newVal));

    }

    /**
     * Affichage des données dans les différents champs
     * @param car
     */
    @FXML
     void showCars(Car car)
    {
        if(car!=null)
        {
            txtmarque.setText(car.getMake());
            txtmodele.setText(car.getModel());
            txtcarId.setText(Integer.toString(car.getCarId()));
            txtannee.setText(Integer.toString(car.getYear()));
            btnAjouter.setDisable(true);

        }
        else
        {
            txtmarque.setText("");
            txtmodele.setText("");
            txtcarId.setText("");
            txtannee.setText("");
        }
    }
public void Sauvegarder()
{
    carManager.saveCarsToTextFile("cars.txt");
}
    // Ajouter une auto
    @FXML
    void AddCar()
    {
        String make=txtmarque.getText();
        String modele=txtmodele.getText();
        int id= Integer.parseInt(txtcarId.getText()); // transformer un String en entier
        int year=Integer.parseInt(txtannee.getText());
        Car tmpcar=new Car(id,make,modele,year);
        carManager.addCar(tmpcar);
        //mettre à jour le fichier texte
        Sauvegarder();
        ClearAll();

    }
    @FXML
    void ModifCar()
    {
        int id=Integer.parseInt(txtcarId.getText());
        String make=txtmarque.getText();
        String modele=txtmodele.getText();
        int year=Integer.parseInt(txtannee.getText());
        carManager.updateCarById(id,make,modele,year);
        // mettre à jour le fichier texte
        Sauvegarder();


    }

    @FXML
    void DeleteCar()
    {
        int id=Integer.parseInt(txtcarId.getText());

            Alert alert = new Alert(Alert.AlertType.CONFIRMATION);
            alert.setTitle("Effacer");
            alert.setContentText("Confirmer la suppression!");
            Optional<ButtonType> result = alert.showAndWait();
            if(result.get()==ButtonType.OK)
            {
                carManager.deleteCarById(id);
                // mettre à jour le fichier texte
                Sauvegarder();
            }

    }
    @FXML
    void ClearAll()
    {
        txtmarque.setText("");
        txtmodele.setText("");
        txtcarId.setText("");
        txtannee.setText("");
        cboCars.getSelectionModel().clearSelection();
        btnAjouter.setDisable(false);

    }
    // methode pour vérifier si une entrée est numerique ou non

@FXML
    public boolean checkNum(KeyEvent e)
    {
        TextField txt= (TextField) e.getSource();
        if(!(txt.getText().equals("")))
        {
            try {
                Double b = Double.parseDouble(txt.getText());
            } catch (NumberFormatException ex) {
                Alert alert = new Alert(Alert.AlertType.ERROR);
                alert.setTitle("Entrée non valide");
                alert.setHeaderText(null);
                alert.setContentText("Veuillez donner une entrée numérique.");
                alert.showAndWait();
                txt.setText("");
                txt.requestFocus();

            }
        }
        return true;


    }
}
