package JavaFX;
/**
 * Created by AMP on 25.10.2015.
 */

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.scene.web.WebEngine;
import javafx.scene.web.WebView;
import javafx.stage.Stage;

public class t extends Application {
    @Override
    public void start(Stage primaryStage) {
//        Button button = new Button("Hello World");
//        button.setOnAction(e -> System.out.println("Hello World"));
        StackPane myPane = new StackPane();
//        myPane.getChildren().add(button);

        WebView webView = new WebView();
        WebEngine engine  = webView.getEngine();
        engine.load("https://www.f.ua");
        myPane.getChildren().add(webView);
        engine.executeScript("history.back()");

        Scene myScene = new Scene(myPane);
        primaryStage.setScene(myScene);
        primaryStage.setWidth(1024);
        primaryStage.setHeight(800);

        primaryStage.show();
    }

    public static void main(String[] args) {
        launch(args);
    }
}