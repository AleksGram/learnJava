package com.useInterface2;

/**
 * Created by Грам on 21.03.2017.
 */
public class Exit implements Command {
    private String text;

    public Exit() {
        this.text = "Goodbye!";
    }

    public String getText() {
        return text;
    }

    public void execute() {
        System.out.println(getText());
    }
}
