package view;

import Notification.Alerts;
import com.jfoenix.controls.JFXTextField;
import controller.MemberController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import modal.Member;

import java.io.IOException;

public class MemberDeletFromController {

    @FXML
    private AnchorPane root;

    @FXML
    private JFXTextField txtMemberId;

    @FXML
    private Label lblId;

    @FXML
    private Label lblName;

    @FXML
    private Label lblAddress;

    @FXML
    private Label lblContact;

    @FXML
    private Label lblAge;

    @FXML
    private Label lblEmail;

    @FXML
    void Back(ActionEvent event) {
        try {
            Parent view = FXMLLoader.load(this.getClass().getResource("MemberMainFrom.fxml"));
            Stage primaryStage = (Stage) root.getScene().getWindow();
            Scene scene = new Scene(view);
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void Search(ActionEvent event) {
        String searchId = txtMemberId.getText();

        Member m1 = MemberController.searchFrom(searchId);

        lblId.setText(m1.getId());
        lblName.setText(m1.getName());
        lblAddress.setText(m1.getAddress());
        lblContact.setText(m1.getContact());
        lblAge.setText(Integer.toString(m1.getAge()));
        lblEmail.setText(m1.getEmail());
    }
    @FXML
    void onDelete(ActionEvent event) {
        String memberId = txtMemberId.getText();

        boolean delete = MemberController.deleteFrom(memberId);

        Alerts alerts = new Alerts();
        alerts.notification("Member Delete Sucses....!", "Memebr Delete");

    }
}
