package com.cx.lunshuti.no1;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

/**
 * @author 陈翔
 */
public class Main extends Application{
    @Override
    public void start(Stage primaryStage) throws Exception{
        Parent root = FXMLLoader.load(Main.class.getResource("indexView.fxml"));
        Scene scene = new Scene(root,600,400);
        primaryStage.setTitle("演示窗口");primaryStage.setScene(scene);primaryStage.show();
    }
    public static void main(String[] args){ launch(args); }
}


