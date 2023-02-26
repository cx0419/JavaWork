package com.cx.javafx;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.scene.control.Button;

import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.scene.text.Text;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

/**
 * @author 陈翔
 */
public class IndexController {

    @FXML
    private Text text;


    @FXML
    private MenuItem openFile;

    @FXML
    private Rectangle rectangle;


    @FXML
    private Button jiaCu;

    @FXML
    private Button xieXian;



    public void initialize(){

        rectangle.setOnMouseClicked( new EventHandler<MouseEvent>() {
            public void handle(MouseEvent me) {
                text.setText(me.getX() + "," + me.getY());
            }
        });
        openFile.setOnAction(new EventHandler<ActionEvent>(){

            public void handle(ActionEvent event) {
                FileChooser fileChooser = new FileChooser();
                fileChooser.setTitle("打开");
                fileChooser.showOpenDialog(new Stage());
            }
        });
        jiaCu.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event) {
                text.setStyle("-fx-font-weight:bold");

            }
        });
        xieXian.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent event) {
                text.setStyle("-fx-font-style:italic");
            }
        });
    }


}
