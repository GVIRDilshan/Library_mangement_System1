package view;

import MailSystem.JavaMail;
import controller.MemberController;
import javafx.animation.Animation;
import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Alert;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;
import javafx.util.Duration;
import modal.Member;

import java.io.IOException;
import java.net.URL;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.ResourceBundle;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class DashBordFromController implements Initializable {

    @FXML
    private Label timeLable;

    @FXML
    private Label dateLable;

    @FXML
    private AnchorPane root;

    @FXML
    private BarChart<?, ?> barChart;

    @FXML
    void MemberDeatils(ActionEvent event) {

        try {
            Parent view = FXMLLoader.load(this.getClass().getResource("MemberTableFrom.fxml"));
            Stage primaryStage = (Stage) root.getScene().getWindow();
            Scene scene = new Scene(view);
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void BookDeatils(ActionEvent event) {

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

    @FXML
    void book(ActionEvent event) {

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
    void member(ActionEvent event) {

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
    void BookIssueBtn(ActionEvent event) {
        try {
            Parent view = FXMLLoader.load(this.getClass().getResource("IssuseFrom.fxml"));
            Stage primaryStage = (Stage) root.getScene().getWindow();
            Scene scene = new Scene(view);
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void LogoutBnt(ActionEvent event) {
        try {
            Parent view = FXMLLoader.load(this.getClass().getResource("LoginFrom.fxml"));
            Stage primaryStage = (Stage) root.getScene().getWindow();
            Scene scene = new Scene(view);
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void bookReturnBtn(ActionEvent event) {
        try {
            Parent view = FXMLLoader.load(this.getClass().getResource("ReturnFrom.fxml"));
            Stage primaryStage = (Stage) root.getScene().getWindow();
            Scene scene = new Scene(view);
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void sendEmail(ActionEvent event) {
        try {
            Parent view = FXMLLoader.load(this.getClass().getResource("MailFrom.fxml"));
            Stage primaryStage = (Stage) root.getScene().getWindow();
            Scene scene = new Scene(view);
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void returnDetails(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Not Complete");
        alert.showAndWait();

    }

    @FXML
    void IssuseDetails(ActionEvent event) {
        try {
            Parent view = FXMLLoader.load(this.getClass().getResource("IssuseTableFrom.fxml"));
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

        XYChart.Series series1 = new XYChart.Series();
        series1.setName("first Week");
        series1.getData().add(new XYChart.Data("Day 1",35));
        series1.getData().add(new XYChart.Data("Day 2",49));
        series1.getData().add(new XYChart.Data("Day 3",25));
        series1.getData().add(new XYChart.Data("Day 4",41));
        series1.getData().add(new XYChart.Data("Day 5",77));
//        series1.getData().add(new XYChart.Data("Day 6",75));
//        series1.getData().add(new XYChart.Data("Day 7",7));


        XYChart.Series series2 = new XYChart.Series();
        series2.setName("Second week");
        series2.getData().add(new XYChart.Data("Day 1",45));
        series2.getData().add(new XYChart.Data("Day 2",19));
        series2.getData().add(new XYChart.Data("Day 3",16));
        series2.getData().add(new XYChart.Data("Day 4",45));
        series2.getData().add(new XYChart.Data("Day 5",80));
//        series2.getData().add(new XYChart.Data("Day 6",50));
//        series2.getData().add(new XYChart.Data("Day 7",90));

        XYChart.Series series3 = new XYChart.Series();
        series3.setName("3rd week");
        series3.getData().add(new XYChart.Data("Day 1",55));
        series3.getData().add(new XYChart.Data("Day 2",45));
        series3.getData().add(new XYChart.Data("Day 3",35));
        series3.getData().add(new XYChart.Data("Day 4",28));
        series3.getData().add(new XYChart.Data("Day 5",90));

        XYChart.Series series4 = new XYChart.Series();
        series3.setName("4th week");
        series4.getData().add(new XYChart.Data("Day 1",25));
        series4.getData().add(new XYChart.Data("Day 2",34));
        series4.getData().add(new XYChart.Data("Day 3",26));
        series4.getData().add(new XYChart.Data("Day 4",76));
        series4.getData().add(new XYChart.Data("Day 5",90));

        barChart.getData().addAll(series1,series2,series3,series4);

    }
    @FXML
    void openView(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Not Complete");
        alert.showAndWait();
    }
    public void initialize(){
        timeLable.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("     hh:mm:ss a")));

        dateLable.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("     yyyy-MM-dd")));

        Timeline timeline = new Timeline(new KeyFrame(Duration.seconds(1), event -> timeLable.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("     hh:mm:ss a")))));
        timeline.setCycleCount(Animation.INDEFINITE);
        timeline.play();
        Timeline timeline2 = new Timeline(new KeyFrame(Duration.seconds(1), event -> dateLable.setText(LocalDateTime.now().format(DateTimeFormatter.ofPattern("     yyyy-MM-dd")))));
        timeline2.setCycleCount(Animation.INDEFINITE);
        timeline2.play();

    }
    @FXML
    void openChart(ActionEvent event) {
        try {
            Parent view = FXMLLoader.load(this.getClass().getResource("FullChartFrom.fxml"));
            Stage primaryStage = (Stage) root.getScene().getWindow();
            Scene scene = new Scene(view);
            primaryStage.setScene(scene);
            primaryStage.centerOnScreen();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    @FXML
    void Setting(ActionEvent event) {
        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setContentText("Not Complete");
        alert.showAndWait();
    }

}
