package controller;

import com.jfoenix.controls.JFXTextField;
import javafx.event.ActionEvent;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ButtonType;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;

public class LogInController {
    public JFXTextField txtUser;
    public JFXTextField txtPassWord;
    public AnchorPane logInContext;
    public AnchorPane parkFormContext;

    public void closeStage(AnchorPane parkFormContext){
        this.parkFormContext=parkFormContext;
    }

    public void openInParking(ActionEvent actionEvent) throws IOException {
        stage=(Stage)parkFormContext.getScene().getWindow();
        stage.close();
        if(txtUser.getText().equalsIgnoreCase("Admin") && txtPassWord.getText().equals("1234")) {
            Stage window =(Stage)logInContext.getScene().getWindow();
            window.setScene(new Scene(FXMLLoader.load(getClass().getResource("../view/InParking.fxml"))));
        }
        else{
            new Alert(Alert.AlertType.WARNING,"Incorrect User Name, Password. Try again..", ButtonType.CLOSE).show();
        }
    }



    Stage stage;
    public void closeOnAction(ActionEvent actionEvent) throws IOException {
        stage=(Stage) logInContext.getScene().getWindow();
        stage.close();

    }

    public void moveToPassword(ActionEvent actionEvent) {
        txtPassWord.requestFocus();
    }
}
