package com.useInterface2;

/**
 * Created by Грам on 21.03.2017.
 */
public class Application {


    public static void main(String[] args) {

       /* call(new String[]{"date", "now"});
        call(new String[]{"echo", "you called echo"});
        call(new String[]{"help"});
        call(new String[]{"echo"});
        call(new String[]{"exit"});
        call(new String[]{});
        call(args);
        call(new String[]{"echo", "echo", "echo"});*/
        args=new  String[]{"help"};
        args=new  String[]{""};
        args=new  String[]{"date"};
        args=new  String[]{"echo", "hello"};


   // }

  //  public static void call(String[] args) {
        if (args.length == 0 || args == null||args.length>2) {
            System.out.println("Error");
            return;

        }
        if ((args[0] == "echo") && (args.length <2)) {
            System.out.println("Error");
            return;
        } else if ((args[0] == "echo") && (args.length >= 2)) {
            Command command = new Echo(args[1]);
            command.execute();
            return;
        }
        if (args[0] == "date") {
            Command command = new Date();
            command.execute();
            return;
        } else if (args[0] == "help") {
            Command command = new Help();
            command.execute();
            return;
        } else if (args[0] == "exit") {
            Command command = new Exit();
            command.execute();
            return;
        } else
            System.out.println("Error");
    }



}