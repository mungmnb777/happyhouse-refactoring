package com.ssafy.happyhouse.view.entity;

public class JsonEntity<T> {

    private T value;

    public JsonEntity(T value) {
        this.value = value;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
