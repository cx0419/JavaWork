package com.cx.javafx;

import javafx.application.Application;
import javafx.stage.Stage;

/**
 * @author 陈翔
 */
public class Main  extends Application{

    @Override
    public void start(Stage primaryStage) throws Exception{
        IndexView.start(primaryStage);
    }

    public static void main(String[] args){
        launch(args);
    }


}


