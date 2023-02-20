package view;

import controller.IssuseController;
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
import modal.Issuse;

import java.io.IOException;
import java.net.URL;
import java.sql.Date;
import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class IssuseTableFromController implements Initializable {

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<Issuse> tblIssuse;

    @FXML
    private TableColumn<?, ?> colIssuseId;

    @FXML
    private TableColumn<PatientEntity, Date> colIssuseDate;

    @FXML
    private TableColumn<?, ?> colMemberId;

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

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        tblIssuse.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("iid"));
        tblIssuse.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("issusdate"));
        tblIssuse.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("memberId"));

        ArrayList<Issuse> issus = IssuseController.loadAllIssuse();

        tblIssuse.setItems(FXCollections.observableArrayList(issus));

    }
}
