package com.threads.buchakaChallenge;

/**
 * Created by agra on 7/11/2017.
 */
public class MainBank {
    public static void main(String[] args) {
    /*   final TransferChallenge account = new TransferChallenge("12345-678", 1000);

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("User1 started...");
                try {
                    account.transfer(300,50);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("User1 finished");
            }
        }).start();

        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("User2 started...");
                try {
                    account.transfer(203,100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("User2 finished");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("User3 started...");
                try {
                    account.withdraw(203);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("User3 finished");
            }
        }).start();
        new Thread(new Runnable() {
            @Override
            public void run() {
                System.out.println("User4 started...");
                try {
                    account.withdraw(203);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                System.out.println("User4 finished");
            }
        }).start();*/

/*
// Transfer Challenge
        TransferChallenge account1 = new TransferChallenge("12345-678", 500.00);
        TransferChallenge account2 = new TransferChallenge("98765-432", 1000.00);

        new Thread(new Transfer(account1, account2, 10.00), "Transfer1").start();
        new Thread(new Transfer(account2, account1, 55.88), "Transfer2").start();
*/

        Tutor tutor = new Tutor();
        Student student = new Student(tutor);
        tutor.setStudent(student);

        Thread tutorThread = new Thread(new Runnable() {
            @Override
            public void run() {
                tutor.studyTime();
            }
        });

        Thread studentThread = new Thread(new Runnable() {
            @Override
            public void run() {
                student.handInAssignment();
            }
        });

        tutorThread.start();
        studentThread.start();

    }

}
