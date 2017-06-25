package com.threads.thread_labs;

/**
 * Created by agra on 6/25/2017.
 */
public class Accordion {
    public static void main(String[] args) throws InterruptedException {
        for (int k = 0; k < 3; k++) {
        /*    // A + B
            Runnable printerA = new PrintRunnable("A   .", 100);
            Thread threadA = new Thread(printerA);
            threadA.start();
            Runnable printerB = new PrintRunnable(".   B", 99);
            Thread threadB = new Thread(printerB);
            threadB.start();
            threadA.join();
            threadB.join();
            // C
            System.out.println("-----");
            Runnable printerC = new PrintRunnable("  C", 100);
            Thread threadC = new Thread(printerC);
            threadC.start();
            threadC.join();
           // printerC.run();
            System.out.println("-----");*/

        //NEW IMPLEMENTATION

            Runnable coordinator = new Coordinator();
          Thread threadCoordinator = new Thread(coordinator);
            System.out.println("--- Start from threadCoordinator----");
          threadCoordinator.start();

          Runnable coordinator2 = new Coordinator();
            Thread threadCoordinator2 = new Thread(coordinator2);
            System.out.println("--- Start from threadCoordinator2----");
            threadCoordinator2.sleep(2000);
            threadCoordinator2.start();

          threadCoordinator.join();
            System.out.println("<<Coordinator! finished>>");
            threadCoordinator2.join();
            System.out.println("<<Coordinator2 finished>>");

        }
    }
}
