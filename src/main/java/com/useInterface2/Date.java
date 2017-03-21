package com.useInterface2;

/**
 * Created by Грам on 21.03.2017.
 */
public class Date implements Command {
    private Date date;

    public Date() {
        this.date = date;
    }

    public Date getDate() {
        return date;
    }

    public void execute() {
        System.out.println(System.currentTimeMillis());
    }
}
