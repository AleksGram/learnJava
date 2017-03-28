package com.string;

/**
 * Created by Грам on 26.03.2017.
 */
public class Application {
    public static void main(String[] args) {
        // StringBuilder string = new StringBuilder("hhhhhhhhhhhhhhhhhhhhyyhhhhhhhhhhhoohh");
        StringBuilder string = new StringBuilder(null);
        int reppets = 1;

        String newString = new String();
        String typeString = new String();
        for (int i = 0; i < string.length() - 1; i++) {
            for (int j = (i + 1); j < string.length(); j++) {
                char ch1 = string.charAt(i);
                char ch2 = string.charAt(j);

                if (ch1 == ch2) {

                    typeString = String.valueOf(ch1);


                    reppets += 1;
                } else
                    break;


            }
            if (reppets > 1) {
                int quantity = reppets - 9;
                if (quantity <= 0) {

                    newString = typeString + reppets;
                } else {
                    newString = typeString + 9;
                    while (quantity > 0) {
                        if (quantity <= 9) {
                            newString += typeString + quantity;
                        } else
                            newString += typeString + 9;
                        quantity -= 9;
                    }
                    // newString+=9;
                    // quantity-=9;
                }
                //  newString += reppets;
                string.replace(i, (i + reppets), newString);
                // string=new StringBuilder(newString);
                reppets = 1;


            }

        }
        System.out.println(string);
    }
}
