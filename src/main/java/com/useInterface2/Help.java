package com.useInterface2;

/**
 * Created by Грам on 21.03.2017.
 */
public class Help implements Command {
    private String hello;

    public Help() {
        this.hello = "Help execute";
    }

    public String getHello() {
        return hello;
    }

    public void execute() {
        System.out.println(getHello());
    }
}
