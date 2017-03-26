package com.string;

/**
 * Created by Грам on 26.03.2017.
 */
public class Application {
    public static void main(String[] args) {
        StringBuilder string = new StringBuilder("HHhherthhellllll");
        int reppets = 1;

        String newString = new String();
        for (int i = 0; i < string.length() - 1; i++) {
            for (int j = (i + 1); j < string.length(); j++) {
                char ch1 = string.charAt(i);
                char ch2 = string.charAt(j);

                if (ch1 == ch2) {

                    newString = String.valueOf(ch1);
                    reppets += 1;
                } else
                    break;


            }
            if (reppets > 1) {
                newString += reppets;
                string.replace(i, (i + reppets), newString);
                // string=new StringBuilder(newString);
                reppets = 1;


            } else
               reppets = 1;
        }
        System.out.println(string);
    }
}