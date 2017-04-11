package com.fibonachi;

/**
 * Created by Грам on 11.04.2017.
 */
public class Fibonachi {


        public long calculateFbonachi(int position){
            if (position <= 0) {
                return -1;
            } else if (position == 1) {
                return 1;
            } else if (position == 2) {
                return 1;
            } else {
              return calculateFbonachi((position - 1) ) + calculateFbonachi((position - 2));


            }

        }

    }

