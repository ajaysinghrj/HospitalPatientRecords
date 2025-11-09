package service;

public class ThreadedBackupManager extends Thread {
    @Override
    public void run() {
        System.out.println("Backup in progress...");
        try { Thread.sleep(2000); } catch (InterruptedException e) { }
        System.out.println("Backup complete!");
    }
}