package com.test.multiThreading.waitAndNotify;

public class Postman extends Thread {
    private MailBox mailBox;

    public Postman() {
    }

    public Postman(MailBox mailBox) {
        this.mailBox = mailBox;
    }

    @Override
    public void run() {
        System.out.println("run method start");
        synchronized (mailBox) {
            System.out.println("Postman Starting counting");
            int numberOfMails = 0;
            for (int i = 0; i < 1000; i++) {
                numberOfMails++;
                System.out.println("Postman counting number of mails for a particular mailbox.");
                mailBox.setNumberOfMails(numberOfMails);
                System.out.println("postman notifying");
                mailBox.notify();
                System.out.println("postman notified");
                System.out.println("postman going to waiting state");
                try {
                    mailBox.wait();
                } catch (InterruptedException e) {
                    throw new RuntimeException(e);
                }
                System.out.println("postman comming out of waiting state");
            }
        }
        //System.out.println(String.format("Postman found %s mails for this mailbox", numberOfMails));
        System.out.println("Postman dropped mails to the mailbox");
    }
}
