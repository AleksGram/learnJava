package com.threads.buchakaChallenge;

/**
 * Created by agra on 7/15/2017.
 */
public class Tutor {

        private Student student;

        public synchronized void setStudent(Student student) {
            this.student = student;
        }

        public synchronized void studyTime() {
            System.out.println("Tutor has arrived");
            try {
                // wait for student to arrive and hand in assignment
                Thread.sleep(300);
            }
            catch (InterruptedException e) {

            }
            student.startStudy();
            System.out.println("Tutor is studying with student");
        }

        public synchronized void getProgressReport() {
            // get progress report
            System.out.println("Tutor gave progress report");
        }
    }

    class Student {

        private Tutor tutor;

        Student(Tutor tutor) {
            this.tutor = tutor;
        }

        public synchronized void startStudy() {
            // study
            System.out.println("Student is studying");
        }

        public  void handInAssignment() {
            tutor.getProgressReport();
            System.out.println("Student handed in assignment");
        }
    }

