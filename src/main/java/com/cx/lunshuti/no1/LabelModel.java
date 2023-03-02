package com.cx.lunshuti.no1;

import javafx.beans.property.SimpleStringProperty;
import javafx.beans.property.StringProperty;

/**
 * @author 陈翔
 */
public class LabelModel {
    private final StringProperty point = new SimpleStringProperty();;
    public LabelModel(String point) { this.point.set(point); }
    public StringProperty pointProperty() { return point; }
    public void setPoint(String point) { this.point.set(point); }
}