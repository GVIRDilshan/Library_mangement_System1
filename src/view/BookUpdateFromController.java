package view;

import Notification.Alerts;
import com.jfoenix.controls.JFXTextField;
import controller.BookController;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;
import modal.Book;

import java.io.IOException;

public class BookUpdateFromController {

    @FXML
    private AnchorPane root;

    @FXML
    private JFXTextField txtEnterId;

    @FXML
    private JFXTextField txtBookId;

    @FXML
    private JFXTextField txtBookName;

    @FXML
    private JFXTextField txtBookAuthor;

    @FXML
    private JFXTextField txtBookPrice;

    @FXML
    void Search(ActionEvent event) {
        String searchId = txtEnterId.getText();

        Book book = BookController.bookSearch(searchId);

        txtBookId.setText(book.getId());
        txtBookName.setText(book.getName());
        txtBookAuthor.setText(book.getAuthor());
        txtBookPrice.setText(String.valueOf(book.getQty()));

    }

    @FXML
    void back(ActionEvent event) {
        try {
            Parent view = FXMLLoader.load(this.getClass().getResource("BookMainFrom.fxml"));
            Stage primaryStage = (Stage) root.getScene().getWindow();
            Scene scene = new Scene(view);
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    @FXML
    void onUpdate(ActionEvent event) {
        String BookId = txtBookId.getText();
        String BookName = txtBookName.getText();
        String BookAuthoer = txtBookAuthor.getText();
        String BookQty = txtBookPrice.getText();

        Book book = new Book();
        book.setId(BookId);
        book.setName(BookName);
        book.setAuthor(BookAuthoer);
        book.setQty(Integer.parseInt(BookQty));


        boolean update = BookController.BookUpdate(book);

        Alerts alerts = new Alerts();
        alerts.notification("Update Sucses...!", "Book update");

    }

}
