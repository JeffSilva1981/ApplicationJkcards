package com.jkcards.ecommerce.exceptions;

public class FieldMessage {

    private String fieldName;
    private String fieldMessage;

    public FieldMessage(){

    }

    public FieldMessage(String fieldName, String message) {
        this.fieldName = fieldName;
        this.fieldMessage = message;
    }

    public String getFieldName() {
        return fieldName;
    }

    public void setFieldName(String fieldName) {
        this.fieldName = fieldName;
    }

    public String getFieldMessage() {
        return fieldMessage;
    }

    public void setFieldMessage(String message) {
        this.fieldMessage = message;
    }
}
