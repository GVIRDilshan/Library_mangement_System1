package view;

import controller.BookController;
import controller.MemberController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import modal.Book;
import modal.Member;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MailFromController implements Initializable {
    @FXML
    private AnchorPane root;

    @FXML
    private ComboBox<?> cmdMail;


    @FXML
    void Back(ActionEvent event) {
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
    void Sent(ActionEvent event) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Not Complete");
        alert.showAndWait();

    }
    @FXML
    void onSelectMail(ActionEvent event) {
        Member member = MemberController.searchFrom((String)cmdMail.getValue());

    }
    public void loadBookIds(){
        ArrayList<String> BookIds = MemberController.loadAllMemberEmails();

        ObservableList mails = FXCollections.observableArrayList();

        for (String id : BookIds){
            mails.add(id);
        }
        cmdMail.setItems(mails);
    }

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadBookIds();
    }
}
