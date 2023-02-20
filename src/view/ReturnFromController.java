package view;

import Notification.Alerts;
import controller.BookController;
import controller.IssuseController;
import controller.MemberController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import modal.Book;
import modal.Issuse;
import modal.Member;

import java.io.IOException;

public class ReturnFromController {

    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtMemberID;

    @FXML
    private Label lblName;

    @FXML
    private Label lblBookId;

    @FXML
    private Label lblIsuseDate;

    @FXML
    void back(ActionEvent event) {
        try {
            Parent view = FXMLLoader.load(this.getClass().getResource("DashBordFrom.fxml"));
            Stage primaryStage = (Stage) root.getScene().getWindow();
            Scene scene = new Scene(view);
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onReturn(ActionEvent event) {




        Alerts alerts =  new Alerts();
        alerts.notification("Return Sucses......!", "Return");

    }

    @FXML
    void search(ActionEvent event) {
        String searchId = txtMemberID.getText();

        Issuse issuse = IssuseController.IssuseSearch(searchId);

        lblName.setText(issuse.getIssusId());
        lblIsuseDate.setText(issuse.getIssusDate());
        lblBookId.setText(issuse.getMemberId());

//        Member member = MemberController.searchFrom(txtMemberID.getText());
//        Issuse issuse = IssuseController.IssuseSearch(txtMemberID.getText());
//        lblName.setText(issuse.getIssusId());
//        lblIsuseDate.setText(issuse.getIssusDate());
//        lblBookId.setText(issuse.getMemberId());
    }
}