package view;

import Notification.Alerts;
import com.jfoenix.controls.JFXPasswordField;
import com.jfoenix.controls.JFXTextField;
import com.sun.scenario.effect.impl.sw.sse.SSEBlend_SRC_OUTPeer;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.image.ImageView;
import javafx.stage.Stage;

import java.io.IOException;

public class LoginFromController {

    @FXML
    private ImageView root;

    @FXML
    private JFXTextField txtUserName;

    @FXML
    private JFXPasswordField txtPassword;

    @FXML
    void Login(ActionEvent event) {
        String userName = txtUserName.getText();
        String password = txtPassword.getText();

        if (userName.equals("Admin") && password.equals("Admin")){
            try {
                Parent view = FXMLLoader.load(this.getClass().getResource("DashBordFrom.fxml"));
                Stage primaryStage = (Stage) root.getScene().getWindow();
                Scene scene = new Scene(view);
                primaryStage.setScene(scene);
                primaryStage.centerOnScreen();
            } catch (IOException e) {
                e.printStackTrace();
            }

            Alerts alerts = new Alerts();
            alerts.notification("Sucses login........", "Login");

        }else{
            Alert a = new Alert(Alert.AlertType.ERROR);
            a.setContentText("Login Fail");
            a.showAndWait();
        }
    }

    @FXML
    void showPasswod(ActionEvent event) {
        String pass = txtPassword.getText();
        Alert b = new Alert(Alert.AlertType.WARNING);
        b.setContentText("Not Complte wait");
        b.show();
    }
}
