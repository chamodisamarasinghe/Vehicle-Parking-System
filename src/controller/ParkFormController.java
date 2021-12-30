package controller;

import com.jfoenix.controls.JFXButton;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import model.Delivery;
import model.AddDriver;
import model.Park;
import model.Vehicle;

import java.io.IOException;
import java.security.spec.RSAOtherPrimeInfo;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

//import static controller.AddVehicleController.vehicleList;


public class ParkFormController {
    public AnchorPane parkFormContext;
    public ComboBox cmbVehicleNumbers;
    public ComboBox cmbDriverNames;
    public TextField txtVehicleType;
    public TextField txtTime;
    public TextField txtSlotNum;
    public JFXButton button1;
    public JFXButton button2;

    static ArrayList<Delivery> deliveryList = new ArrayList();
    static ArrayList<Park> parkList = new ArrayList();
    static ArrayList<Vehicle> vehicleList = new ArrayList();
    static ArrayList<AddDriver> addDriverList = new ArrayList();
    static int[] slot = new int[14];


    public void initialize() {


        loadAddDriver();

        ObservableList<String> tmObservableList = FXCollections.observableArrayList();
        for (Vehicle temp : vehicleList) {
            tmObservableList.add(temp.getNumber());
        }
        cmbVehicleNumbers.setItems(tmObservableList);

        cmbVehicleNumbers.getSelectionModel().selectedItemProperty().addListener((observable, oldValue, newValue) -> {
            String type = "none";
            for (Vehicle temp1 : vehicleList
            ) {
                if (newValue.equals(temp1.getNumber())) {
                    type = temp1.getType();
                }
            }
            txtVehicleType.setText(type);

        });


        SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy   HH:mm  a");
        Date date = new Date();
        txtTime.setText(formatter.format(date));

        InParkingController.deliveryArrayList = deliveryList;
        InParkingController.parkArrayList = parkList;
    }

    private void loadAddDriver(){

    ObservableList<String> tmObservableList = FXCollections.observableArrayList();
        for(AddDriver temp :addDriverList) {
        tmObservableList.add(temp.getDriverName());
    }
        cmbDriverNames.setItems(tmObservableList);
}




    public void openLogIn(ActionEvent actionEvent) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("../view/LogIn.fxml"));
        Parent parent = loader.load();
        LogInController controller = loader.getController();
        Scene scene= new Scene(parent);
        Stage stage = new Stage();
        controller.closeStage(parkFormContext);
        stage.setScene(scene);
        stage.setTitle("Log In");
        stage.setResizable(false);
        stage.centerOnScreen();
        stage.show();
    }

    public void parkVehicleOnAction(ActionEvent actionEvent) throws IOException {
        button1.setDisable(false);
        button2.setDisable(true);

        if (cmbVehicleNumbers.getValue().equals(null) && cmbDriverNames.getValue().equals("null")) {
            new Alert(Alert.AlertType.WARNING, "Pick Up vehicle Number", ButtonType.CLOSE).show();
        } else {
            check(txtVehicleType.getText());
            deliveryList.removeIf(temp2 -> cmbVehicleNumbers.getSelectionModel().getSelectedItem().toString().equals(temp2.getNumber()));
            parkList.add(new Park(cmbVehicleNumbers.getValue().toString(), txtVehicleType.getText(), txtSlotNum.getText(), txtTime.getText()));
        }

        System.out.println(parkList);
    }






    private void check(String text) {
        if (text.equalsIgnoreCase("Bus")){
            if (slot[13]==14){
                new Alert(Alert.AlertType.WARNING,"Can't be park",ButtonType.CLOSE).show();
            }else {
                txtSlotNum.setText("14");
                slot[13]=14;
            }
        }else if (text.equalsIgnoreCase("Cargo Lorry")){
          if (slot[4]==0){
                txtSlotNum.setText("5");
                slot[4]=5;
            }else if (slot[5]==0){
                txtSlotNum.setText("6");
                slot[5]=6;
            }else if (slot[6]==0){
                txtSlotNum.setText("7");
                slot[6]=7;
            }else if (slot[7]==0){
                txtSlotNum.setText("8");
                slot[7]=8;
            }else if (slot[8]==0){
                txtSlotNum.setText("9");
                slot[8]=9;
            }else if (slot[9]==0){
                txtSlotNum.setText("10");
                slot[9]=10;
            }else if (slot[10]==0){
                txtSlotNum.setText("11");
                slot[10]=11;
            }
        }else if (text.equalsIgnoreCase("Van")){
            if (slot[0]==0){
                txtSlotNum.setText("1");
                slot[0]=1;
            }else if (slot[1]==0){
                txtSlotNum.setText("2");
                slot[1]=2;
            }else if (slot[2]==0){
                txtSlotNum.setText("3");
                slot[2]=3;
            }else if (slot[3]==0){
                txtSlotNum.setText("4");
                slot[3]=4;
            }else if (slot[11]==0){
                txtSlotNum.setText("12");
                slot[11]=12;
            }else if (slot[12]==0){
                txtSlotNum.setText("13");
                slot[12]=13;
            }
        }
    }

    public void onDeliveryShiftOnAction(ActionEvent actionEvent) throws IOException {
        //button2.setDisable(true);
       // button1.setDisable(false);

         button1.setDisable(true);
         button2.setDisable(false);

        if (cmbDriverNames.getValue().equals(null) && cmbVehicleNumbers.getValue().equals("null")) {
            new Alert(Alert.AlertType.WARNING, "Pick Up Driver Name", ButtonType.CLOSE).show();
        } else {
            parkList.removeIf(temp2 -> cmbVehicleNumbers.getSelectionModel().getSelectedItem().toString().equals(temp2.getNumber()));
            deliveryList.add(new Delivery(cmbVehicleNumbers.getValue().toString(), txtVehicleType.getText(), cmbDriverNames.getValue().toString(), txtTime.getText()));
        }
        System.out.println(deliveryList);
    }



   public void selectVehicleOnAction(ActionEvent actionEvent) {
       if (checkParkList()==1){
           getType();
           button1.setDisable(true);
           button2.setDisable(false);
       }else {
           getType();
           button2.setDisable(true);
           button1.setDisable(false);
       }
       System.out.println(txtVehicleType.getText());
   }
   /* private int checkDeliverList() {
        int i=0;
        for (Delivery t1 : deliveryList) {
            if (cmbVehicleNumbers.getValue().equals(t1.getNumber())) {
                i=1;
            }
        }
        return i;
    }*/

    private int checkParkList() {
        int i = 0;
        for (Park temp : parkList) {
            if (cmbVehicleNumbers.getValue().equals(temp.getNumber())) {
                i = 1;
            }
        }
        return i;
    }

    private void getType() {
        for ( Vehicle t: vehicleList) {
            if (cmbVehicleNumbers.getValue().equals(t.getNumber())) {
               txtVehicleType.setText(t.getNumber());
            }
        }
    }
}



