package com.useInterface2;

/**
 * Created by Грам on 21.03.2017.
 */
public class Echo implements Command {
    private String text;

    public Echo(String text) {
        this.text = text;
    }

    public String getText() {
        return text;
    }

    public void execute() {
        System.out.println(getText());
    }
}
