package com.cx.lunshuti.no1;

import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.Button;

import javafx.scene.control.Label;
import javafx.scene.control.MenuItem;
import javafx.scene.input.MouseEvent;
import javafx.scene.shape.Rectangle;
import javafx.stage.FileChooser;
import javafx.stage.Stage;

import java.net.URL;
import java.util.ResourceBundle;

/**
 * @author 陈翔
 */
public class IndexController implements Initializable {
    @FXML private Label text;
    private LabelModel labelModel = new LabelModel("厚德载物,天道酬勤");;
    @FXML private MenuItem openFile;
    @FXML private Rectangle rectangle;

    @FXML private Button blue;// 加粗jiaCu | 蓝色blue
    @FXML private Button yellow;// 斜体xieTi | 黄色yellow
    @Override
    public void initialize(URL location, ResourceBundle resources) {
        text.textProperty().bind(labelModel.pointProperty());
        rectangle.setOnMouseClicked(me -> labelModel.setPoint("横坐标:"+me.getX() + ",纵坐标" + me.getY()));
        openFile.setOnAction(event -> { FileChooser fileChooser = new FileChooser();fileChooser.setTitle("打开");fileChooser.showOpenDialog(new Stage()); });
        openFile.setOnAction(event -> {
            FileChooser fileChooser = new FileChooser();
            fileChooser.setTitle("打开");
            fileChooser.showOpenDialog(new Stage());
        });
        blue.setOnMouseClicked(event -> text.setStyle("-fx-text-fill:Blue;"));
        yellow.setOnMouseClicked(event -> text.setStyle("-fx-text-fill:Yellow;"));
//        jiaCu.setOnMouseClicked(event -> text.setStyle("-fx-font-weight: bold;"));
//        xieTi.setOnMouseClicked(event -> text.setStyle("-fx-font-style: 'italic';"));
    }
}
