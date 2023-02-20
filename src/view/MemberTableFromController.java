package view;

import controller.MemberController;
import javafx.collections.FXCollections;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import modal.Member;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class MemberTableFromController implements Initializable {

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<Member> tblMembers;

    @FXML
    private TableColumn<?, ?> colID;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colAddress;

    @FXML
    private TableColumn<?, ?> colContact;

    @FXML
    private TableColumn<?, ?> colAge;

    @FXML
    private TableColumn<?, ?> colEmail;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tblMembers.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblMembers.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblMembers.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("address"));
        tblMembers.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("contact"));
        tblMembers.getColumns().get(4).setCellValueFactory(new PropertyValueFactory<>("age"));
        tblMembers.getColumns().get(5).setCellValueFactory(new PropertyValueFactory<>("email"));

        ArrayList<Member> members = MemberController.loadAllMember();

        tblMembers.setItems(FXCollections.observableArrayList(members));

    }
}
