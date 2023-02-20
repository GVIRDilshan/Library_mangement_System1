package view;

import controller.BookController;
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
import modal.Book;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;

public class BookTableFromController implements Initializable {

    @FXML
    private AnchorPane root;

    @FXML
    private TableView<Book> tblBooks;

    @FXML
    private TableColumn<?, ?> colId;

    @FXML
    private TableColumn<?, ?> colName;

    @FXML
    private TableColumn<?, ?> colAuthor;

    @FXML
    private TableColumn<?, ?> colQty;

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
        tblBooks.getColumns().get(0).setCellValueFactory(new PropertyValueFactory<>("id"));
        tblBooks.getColumns().get(1).setCellValueFactory(new PropertyValueFactory<>("name"));
        tblBooks.getColumns().get(2).setCellValueFactory(new PropertyValueFactory<>("author"));
        tblBooks.getColumns().get(3).setCellValueFactory(new PropertyValueFactory<>("Qty"));

        ArrayList<Book> books = BookController.loadAllMember();

        tblBooks.setItems(FXCollections.observableArrayList(books));

    }
}
