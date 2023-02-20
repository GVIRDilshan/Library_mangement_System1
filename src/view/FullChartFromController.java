package view;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.chart.AreaChart;
import javafx.scene.chart.XYChart;
import javafx.scene.layout.AnchorPane;
import javafx.stage.Stage;

import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;

public class FullChartFromController implements Initializable {

    @FXML
    private AnchorPane root;

    @FXML
    private AreaChart<?, ?> lineChart;

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
        XYChart.Series series1 = new XYChart.Series();
        series1.setName("1st week");
        series1.getData().add(new XYChart.Data("Day 1",25));
        series1.getData().add(new XYChart.Data("Day 2",36));
        series1.getData().add(new XYChart.Data("Day 3",25));
        series1.getData().add(new XYChart.Data("Day 4",41));
        series1.getData().add(new XYChart.Data("Day 5",51));
        series1.getData().add(new XYChart.Data("Day 6",84));
        series1.getData().add(new XYChart.Data("Day 7",90));

        XYChart.Series series2 = new XYChart.Series();
        series2.setName("2nd week");
        series2.getData().add(new XYChart.Data("Day 1",28));
        series2.getData().add(new XYChart.Data("Day 2",31));
        series2.getData().add(new XYChart.Data("Day 3",16));
        series2.getData().add(new XYChart.Data("Day 4",45));
        series2.getData().add(new XYChart.Data("Day 5",48));
        series2.getData().add(new XYChart.Data("Day 6",78));
        series2.getData().add(new XYChart.Data("Day 7",87));

        XYChart.Series series3 = new XYChart.Series();
        series3.setName("3rd week");
        series3.getData().add(new XYChart.Data("Day 1",15));
        series3.getData().add(new XYChart.Data("Day 2",35));
        series3.getData().add(new XYChart.Data("Day 3",35));
        series3.getData().add(new XYChart.Data("Day 4",28));
        series3.getData().add(new XYChart.Data("Day 5",50));
        series3.getData().add(new XYChart.Data("Day 6",77));
        series3.getData().add(new XYChart.Data("Day 7",87));

        XYChart.Series series4 = new XYChart.Series();
        series3.setName("4th week");
        series4.getData().add(new XYChart.Data("Day 1",10));
        series4.getData().add(new XYChart.Data("Day 2",29));
        series4.getData().add(new XYChart.Data("Day 3",39));
        series4.getData().add(new XYChart.Data("Day 4",39));
        series4.getData().add(new XYChart.Data("Day 5",47));
        series4.getData().add(new XYChart.Data("Day 6",75));
        series4.getData().add(new XYChart.Data("Day 7",87));

        lineChart.getData().addAll(series1,series2,series3,series4);
    }
}
