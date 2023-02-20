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

public class memberUpdateFromController {
    @FXML
    private AnchorPane root;

    @FXML
    private JFXTextField txtMemberId;

    @FXML
    private JFXTextField txtId;

    @FXML
    private JFXTextField txtName;

    @FXML
    private JFXTextField txtAddress;

    @FXML
    private JFXTextField txtContact;

    @FXML
    private JFXTextField txtAge;

    @FXML
    private JFXTextField txtEmail;

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

        txtId.setText(m1.getId());
        txtName.setText(m1.getName());
        txtAddress.setText(m1.getAddress());
        txtContact.setText(m1.getContact());
        txtAge.setText(Integer.toString(m1.getAge()));
        txtEmail.setText(m1.getEmail());
    }
    @FXML
    void onUpdate(ActionEvent event) {

        String id = txtId.getText();
        String name = txtName.getText();
        String address = txtAddress.getText();
        String contact = txtContact.getText();
        int age = Integer.parseInt(txtAge.getText());
        String Email = txtEmail.getText();

        Member member = new Member();

        member.setId(id);
        member.setName(name);
        member.setAddress(address);
        member.setContact(contact);
        member.setAge(Integer.parseInt(String.valueOf(age)));
        member.setEmail(Email);

       boolean update = MemberController.updateMember(member);

        Alerts alerts = new Alerts();
        alerts.notification("Member Update......!", "Member Update");
    }
}
