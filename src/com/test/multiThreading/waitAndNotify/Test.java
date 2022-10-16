package com.test.multiThreading.waitAndNotify;

public class Test {
    public static void main(String[] args) throws InterruptedException {
        System.out.println("main thread start");
        MailBox mailBox1 = new MailBox();
        MailBox mailBox2 = new MailBox();
        Postman postman = new Postman(mailBox1);
        postman.start();
        synchronized (mailBox1) {
            while (true) {
                mailBox1.notify();
                int numberOfMails = mailBox1.getNumberOfMails();
                if (mailBox1.getNumberOfMails() > 999)
                    break;
                System.out.println("main thread checking the mailbox");
                System.out.println("owner of mailbox found " + numberOfMails + " mails in the mailbox");
                System.out.println("main thread going to waiting state");
                mailBox1.wait();
                System.out.println("main thread comming out of waiting state");
            }
        }
        //System.out.println("main thread completed");
    }
}
