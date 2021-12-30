package controller;

import javafx.event.ActionEvent;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import model.Vehicle;

import java.util.ArrayList;

import static controller.ParkFormController.vehicleList;

public class AddVehicleController {
    public AnchorPane addVehicleContext;
    public ComboBox cmbVehicleType;
    public TextField txtVehicleNumber;
    public TextField txtMaximumWeight;
    public TextField txtPassengers;


    static ArrayList<Vehicle> vehicleArrayList = vehicleList;

    public void initialize(){
        cmbVehicleType.getItems().addAll(
            "Bus","Van","Cargo Lorry");

    }

    public void addVehicleOnAction(ActionEvent actionEvent) {
        Vehicle vehicle = new Vehicle(txtVehicleNumber.getText(),Integer.valueOf(txtMaximumWeight.getText()),Integer.valueOf(txtPassengers.getText()),cmbVehicleType.getValue().toString());
        if (vehicleList.add(vehicle)) {
            new Alert(Alert.AlertType.CONFIRMATION, "Saved..", ButtonType.CLOSE).show();
        }else {
            new Alert(Alert.AlertType.WARNING,"Try Again..",ButtonType.CLOSE).show();
        }

    }

    public void moveToMaximumWeight(ActionEvent actionEvent) {
        txtMaximumWeight.requestFocus();
    }

    public void moveToNoOfPassengers(ActionEvent actionEvent) {
        txtPassengers.requestFocus();
    }
}
