package ihmcontroller;

import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.chart.Axis;
import javafx.scene.chart.BarChart;
import javafx.scene.chart.XYChart;
import javafx.scene.control.Label;

import java.util.List;

import static DAO.GraphDAO.getRangeValue;

public class GraphPageController {
    private SceneManager sceneManager;

    public void setManager(SceneManager sceneManager) {
        this.sceneManager = sceneManager;
    }

    @FXML
    private BarChart<String, Number> barChart;

    @FXML
    private Label titleOfPage;

    public void initialize() {
        System.out.println(titleOfPage.getStyleClass());
        System.out.println("Style classes on label: " + titleOfPage.getStyleClass());
    }

    public void graphUpdate() {
        barChart.getData().clear();
        Axis xAxis = barChart.getXAxis();
        xAxis.setLabel("Groupes de moyennes");
        Axis yAxis = barChart.getYAxis();
        yAxis.setLabel("Nombre d'étudiants");

        XYChart.Series<String, Number> gradeSeries = new XYChart.Series<>();
        gradeSeries.setName("Notes");

        int valueMin = 0;
        int valueMax = 4;
        for (int bar = 0; bar < 5; bar++) {
            String title = valueMin + " - " + valueMax;
            int value = getRangeValue(valueMin, valueMax);
            gradeSeries.getData().add(new XYChart.Data<>(title, value));

            valueMin += 4;
            valueMax += 4;
        }

        barChart.getData().add(gradeSeries);
    }

    public void switchToAgeGaphButton(ActionEvent actionEvent) {

    }
}
