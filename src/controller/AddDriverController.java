package controller;

import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.AddDriver;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import static controller.ParkFormController.addDriverList;

public class AddDriverController {
    public AnchorPane addDriverContext;
    public TextField txtDriverName;
    public TextField txtNIC;
    public TextField txtLicenseNo;
    public TextField txtAddress;
    public TextField txtContactNo;

    static ArrayList<AddDriver> addDriverArrayList = addDriverList;


    Stage stage;
    public void addDriverOnAction(ActionEvent actionEvent) throws IOException {



        AddDriver driver = new AddDriver(txtDriverName.getText(),txtNIC.getText(),txtLicenseNo.getText(),txtAddress.getText(),Integer.valueOf(txtContactNo.getText()));
        if (addDriverList.add(driver)) {
            new Alert(Alert.AlertType.CONFIRMATION, "Saved..", ButtonType.CLOSE).show();
        }else {
            new Alert(Alert.AlertType.WARNING,"Try Again..",ButtonType.CLOSE).show();
        }


    }

    public void moveToNIC(ActionEvent actionEvent) {
        txtNIC.requestFocus();
    }

    public void moveToLicenseNo(ActionEvent actionEvent) {
        txtLicenseNo.requestFocus();
    }

    public void moveToAddress(ActionEvent actionEvent) {
        txtAddress.requestFocus();
    }

    public void moveToContactNo(ActionEvent actionEvent) {
        txtContactNo.requestFocus();
    }
}
