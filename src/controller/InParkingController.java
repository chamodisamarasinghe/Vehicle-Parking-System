package controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Delivery;
import model.Park;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;

import static controller.ParkFormController.deliveryList;
import static controller.ParkFormController.parkList;

public class InParkingController {
    public AnchorPane inParkingContext;
    public TableView tblInParking;
    public TableColumn colVehicleNum;
    public TableColumn colVehicleType;
    public TableColumn colParkingSlot;
    public TableColumn colParkedTime;
    public TableView tblOnDelivery;
    public ComboBox cmbInParkingOnDelivery;
    public TableColumn colNumber;
    public TableColumn colType;
    public TableColumn colDriverName;
    public TableColumn colLeftTime;

    public static ArrayList<Delivery> deliveryArrayList = deliveryList;
    public static ArrayList<Park> parkArrayList = parkList;

    private String type = "In Parking";

    public void initialize(){
        loadDelivery();
        colNumber.setCellValueFactory(new PropertyValueFactory<>("number"));
        colType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colDriverName.setCellValueFactory(new PropertyValueFactory<>("name"));
        colLeftTime.setCellValueFactory(new PropertyValueFactory<>("leftTime"));

        loadPark();
        colVehicleNum.setCellValueFactory(new PropertyValueFactory<>("number"));
        colVehicleType.setCellValueFactory(new PropertyValueFactory<>("type"));
        colParkingSlot.setCellValueFactory(new PropertyValueFactory<>("slot"));
        colParkedTime.setCellValueFactory(new PropertyValueFactory<>("parkedTime"));


        checkResultInComboBox();
        cmbInParkingOnDelivery.getItems().addAll("In Parking","On Delivery");
        cmbInParkingOnDelivery.getSelectionModel().selectedItemProperty().addListener((observable,oldValue,newValue )->{
            type = String.valueOf(newValue);
            checkResultInComboBox();
        });
    }

    private void loadPark() {
        ObservableList<Park> tmObservableList = FXCollections.observableArrayList();
        for (Park temp :parkArrayList) {
            tmObservableList.add(new Park(temp.getNumber(),temp.getType(),temp.getSlot(),temp.getParkedTime()));
        }
        tblInParking.setItems(tmObservableList);
    }

    private void loadDelivery() {
        ObservableList<Delivery> tmObservableList = FXCollections.observableArrayList();
        for (Delivery temp :deliveryArrayList) {
            tmObservableList.add(new Delivery(temp.getNumber(),temp.getType(),temp.getName(),temp.getLeftTime()));
        }
        tblOnDelivery.setItems(tmObservableList);
    }


    private void checkResultInComboBox() {
        if(type.equals("On Delivery")) {
            tblInParking.setVisible(false);
            tblOnDelivery.setVisible(true);
        }if(type.equals("In Parking")){
            tblInParking.setVisible(true);
            tblOnDelivery.setVisible(false);
        }
    }


    public void openAddVehicle(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AddVehicle.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    public void openAddDriver(ActionEvent actionEvent) throws IOException {
        URL resource = getClass().getResource("../view/AddDriver.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }

    Stage stage;
    public void closeParking(ActionEvent actionEvent) throws IOException {
        stage = (Stage) inParkingContext.getScene().getWindow();
        stage.close();
        URL resource = getClass().getResource("../view/ParkForm.fxml");
        Parent load = FXMLLoader.load(resource);
        Scene scene = new Scene(load);
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
    }


}
