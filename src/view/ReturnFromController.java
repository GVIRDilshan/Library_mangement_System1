package view;

import Notification.Alerts;
import controller.BookController;
import controller.IssuseController;
import controller.MemberController;
import controller.ReturnController;
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
import modal.Returnss;

import java.io.IOException;
import java.time.LocalDate;

public class ReturnFromController {

    @FXML
    private AnchorPane root;

    @FXML
    private TextField txtIssuseID;

    @FXML
    private TextField txtReturnId;

    @FXML
    private TextField txtReturnQty;

    @FXML
    private TextField txtBookId;

    @FXML
    private Label lblIssuseId;

    @FXML
    private Label lblMemberId;

    @FXML
    private Label lblIsuseDate;

    @FXML
    private Label lblBookID;

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
        String IssuseId = txtIssuseID.getText();
        String ReturnId = txtReturnId.getText();
        String ReturnQty = txtReturnQty.getText();
        String BookId = txtBookId.getText();
        String IssuseDate = lblIsuseDate.getText();


        Returnss returnss = new Returnss();
        returnss.setIssuseId(IssuseId);
        returnss.setReturnDate(String.valueOf(LocalDate.now()));
        returnss.setReturnId(ReturnId);
        returnss.setRreturnQty(ReturnQty);
        returnss.setBookId(BookId);
        returnss.setIssuseDate(IssuseDate);

        System.out.println(returnss.getIssuseId()+" "+returnss.getReturnId()+" "+returnss.getRreturnQty()+" "+returnss.getReturnDate());

        boolean returnsed = ReturnController.ReturnSet(returnss);
        System.out.println(returnsed);
    }

    @FXML
    void search(ActionEvent event) {
        String searchId = txtIssuseID.getText();

        Issuse issuse = IssuseController.IssuseSearch(searchId);

        Book book =  new Book();

        lblIssuseId.setText(issuse.getIssusId());
        lblIsuseDate.setText(issuse.getIssusDate());
        lblMemberId.setText(issuse.getMemberId());
        lblBookID.setText(issuse.getBookId());

       // lblQty.setText(String.valueOf(book.getQty()));

//        Member member = MemberController.searchFrom(txtMemberID.getText());
//        Issuse issuse = IssuseController.IssuseSearch(txtMemberID.getText());
//        lblName.setText(issuse.getIssusId());
//        lblIsuseDate.setText(issuse.getIssusDate());
//        lblBookId.setText(issuse.getMemberId());
    }
}
