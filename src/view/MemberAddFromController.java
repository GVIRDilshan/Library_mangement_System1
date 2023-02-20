package view;

import Notification.Alerts;
import controller.MemberController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import modal.Member;

import java.io.IOException;

public class MemberAddFromController {
    @FXML
    private AnchorPane root;
    @FXML
    private TextField txtMemberId;

    @FXML
    private TextField txtMemberName;

    @FXML
    private TextField txtMemberAddress;

    @FXML
    private TextField txtMemberContact;

    @FXML
    private TextField txtMemberAge;

    @FXML
    private TextField txtMemberEmail;

    @FXML
    void Save(ActionEvent event) {
       String memberId      =  txtMemberId.getText();
       String memberName    =  txtMemberName.getText();
       String memberAddress =  txtMemberAddress.getText();
       String memberContact =  txtMemberContact.getText();
       int    memberAge     = Integer.parseInt(txtMemberAge.getText());
        String memberEmail  =  txtMemberEmail.getText();

        Member member = new Member();

        member.setId(memberId);
        member.setName(memberName);
        member.setAddress(memberAddress);
        member.setContact(memberContact);
        member.setAge(memberAge);
        member.setEmail(memberEmail);

        boolean mb1 = MemberController.memberAddFrom(member);

        Alerts alerts = new Alerts();
        alerts.notification("Member Adding Sucses...!", "Members Add");

    }

    @FXML
    void back(ActionEvent event) {
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
}
