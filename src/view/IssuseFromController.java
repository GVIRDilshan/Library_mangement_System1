package view;

import com.jfoenix.controls.JFXComboBox;
import com.jfoenix.controls.JFXTextField;
import controller.BookController;
import controller.IssuseController;
import controller.MemberController;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import modal.Book;
import modal.Issuse;
import modal.Member;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class IssuseFromController implements Initializable {
    @FXML
    private AnchorPane root;

    @FXML
    private JFXComboBox<?> cmbMemberId;

    @FXML
    private JFXComboBox<?> cmbBookId;

    @FXML
    private JFXTextField txtIssuseId;

    @FXML
    private JFXTextField txtQty;

    @FXML
    private Label lblMemberName;

    @FXML
    private Label lblBookName;

    @FXML
    private Label lblMemberContact;

    @FXML
    private Label lblBookQty;

    @Override
    public void initialize(URL location, ResourceBundle resources) {
        loadBookIds();
        loadMemberIds();
    }

    @FXML
    void onSelectBook(ActionEvent event) {
        Book book = BookController.bookSearch((String) cmbBookId.getValue());
        lblBookName.setText(book.getName());
        lblBookQty.setText(String.valueOf(book.getQty()));
    }

    @FXML
    void onSelectMember(ActionEvent event) {
        Member member = MemberController.searchFrom((String) cmbMemberId.getValue());
        lblMemberName.setText(member.getName());
        lblMemberContact.setText(member.getContact());
    }

    @FXML
    void onTake(ActionEvent event) {
        String IssuseId = txtIssuseId.getText();
        String Qty = txtQty.getText();
        String bId = String.valueOf(cmbBookId.getValue());

        Issuse issuse = new Issuse();
        issuse.setIssusId(IssuseId);
        issuse.setIssusDate(String.valueOf((LocalDate.now())));
        issuse.setMemberId((String) cmbMemberId.getValue());

        System.out.println(bId+" "+issuse.getIssusDate());

         boolean issuses = IssuseController.issuseSet(issuse,Qty,bId);
    }

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
    public void loadBookIds(){
        ArrayList<String> BookIds = BookController.loadAllBookIds();

        ObservableList ids = FXCollections.observableArrayList();

        for (String id : BookIds){
            ids.add(id);
        }
        cmbBookId.setItems(ids);
    }
    public  void loadMemberIds(){
        ArrayList<String> MemberIds = MemberController.loadAllMemberIds();

        ObservableList ids = FXCollections.observableArrayList();

        for (String id : MemberIds){
            ids.add(id);
        }
        cmbMemberId.setItems(ids);
    }
    @FXML
    void onVivew(ActionEvent event) {
        try {
            Parent view = FXMLLoader.load(this.getClass().getResource("BookTableFrom.fxml"));
            Stage primaryStage = (Stage) root.getScene().getWindow();
            Scene scene = new Scene(view);
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
