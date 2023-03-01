package com.cx.lunshuti.no1;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * @author 陈翔
 */
public class IndexController {
    @FXML
    private Label text;
    @FXML
    private MenuItem openFile;
    @FXML
    private Rectangle rectangle;
    @FXML
    private Button blue;
    @FXML
    private Button yellow;
    public void initialize(){
        rectangle.setOnMouseClicked( new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent me) {
                text.setText(me.getX() + "," + me.getY());
            }
        });
        openFile.setOnAction(new EventHandler<ActionEvent>(){

            @Override
            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("打开");
                fileChooser.showOpenDialog(new Stage());
            }
        });
        blue.setOnMouseClicked(new EventHandler<MouseEvent>() {
            @Override
            public void handle(MouseEvent event) {
                text.setStyle("-fx-text-fill:Blue;");
            }
        });
        yellow.setOnMouseClicked(new EventHandler<MouseEvent>(){
            @Override
            public void handle(MouseEvent event) {
                text.setStyle("-fx-text-fill:Yellow;");
            }
        });
    }
}
