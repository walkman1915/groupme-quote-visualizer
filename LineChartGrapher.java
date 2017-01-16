import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.chart.LineChart;
import javafx.scene.chart.NumberAxis;
import javafx.scene.chart.CategoryAxis;
import javafx.scene.chart.XYChart;
import javafx.stage.Stage;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.Map;
import java.util.HashMap;

public class LineChartGrapher extends Application {
    @Override public void start(Stage stage) {
        Scanner scanner;
        Map<Date, Integer> dateMap = new HashMap<>();

        try {
            File file = new File("jason.txt");
            scanner = new Scanner(file);

            //System.out.println(scanner.nextLine());
            //System.out.println(scanner.hasNext());

            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();

                String[] words = line.split(" ");
                Date date = new Date(Integer.parseInt(words[1]), words[2], Integer.parseInt(words[3].substring(0, words[3].length() - 1)));

                //System.out.println(date);

                if (dateMap.putIfAbsent(date, 1) != null) {
                    dateMap.put(date, dateMap.get(date) + 1);
                }
            }
            // for (Date d : dateMap.keySet()) {
            //     //System.out.printf("%s %5d%n", s, map.get(s));
            //     System.out.println(d);
            // }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }




        stage.setTitle("When Jason Drank");

        //defining the axes
        final NumberAxis xAxis = new NumberAxis();
        //final CategoryAxis xAxis = new CategoryAxis();
        final NumberAxis yAxis = new NumberAxis();
        xAxis.setLabel("Number of Month");
        yAxis.setLabel("Number of Quotes");

        //creating the chart
        final LineChart<Number,Number> lineChart = 
                new LineChart<Number,Number>(xAxis,yAxis);
                
        lineChart.setTitle("Jason's Drinking, 2016");
        //defining a series
        XYChart.Series series = new XYChart.Series();
        series.setName("Quotes");

        //populating the series with data
        for (Date d : dateMap.keySet()) {
            series.getData().add(new XYChart.Data(d.month + (d.day / 30.0), dateMap.get(d)));
        }



        // series.getData().add(new XYChart.Data(1, 23));
        // series.getData().add(new XYChart.Data(2, 14));
        // series.getData().add(new XYChart.Data(3, 15));
        // series.getData().add(new XYChart.Data(4, 24));
        // series.getData().add(new XYChart.Data(5, 34));
        // series.getData().add(new XYChart.Data(6, 36));
        // series.getData().add(new XYChart.Data(7, 22));
        // series.getData().add(new XYChart.Data(8, 45));
        // series.getData().add(new XYChart.Data(9, 43));
        // series.getData().add(new XYChart.Data(10, 17));
        // series.getData().add(new XYChart.Data(11, 29));
        // series.getData().add(new XYChart.Data(12, 25));
        
        Scene scene  = new Scene(lineChart,1800,600);
        lineChart.getData().add(series);
       
        stage.setScene(scene);
        stage.show();
    }
 
    public static void main(String[] args) {
        launch(args);
    }
}