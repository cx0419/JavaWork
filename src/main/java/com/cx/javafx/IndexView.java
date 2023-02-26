package com.cx.javafx;

import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import javafx.stage.StageStyle;

import java.io.IOException;

/**
 * @author 陈翔
 */
public class IndexView {

    static Stage stage;
    public static Parent root;
    public static Scene scene;

    public static void start(final Stage primaryStage) throws IOException{
        stage = primaryStage;
        root = FXMLLoader.load(IndexView.class.getResource("./index.fxml"));
        primaryStage.setTitle("演示窗口");
        scene = new Scene(root,600,400);
        primaryStage.setScene(scene);
        primaryStage.show();
    }

}


