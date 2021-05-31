package J3Lesson4;

public class SecondVariant {
    private final Object monitor = new Object();
    private volatile char theLetter = 'A';

    public static void main(String[] args) {
        SecondVariant secondVariant = new SecondVariant();
        Thread thread1 = new Thread(() ->{
            secondVariant.aPrint();
        });
        Thread thread2 = new Thread(() ->{secondVariant.bPrint();
        });
        Thread thread3 = new Thread(() ->{secondVariant.cPrint();
        });
        thread1.start();
        thread2.start();
        thread3.start();
    }

    public void aPrint() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (theLetter != 'A'){
                        monitor.wait();
                    }
                    System.out.print('A');
                    theLetter = 'B';
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void bPrint() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (theLetter != 'B'){
                        monitor.wait();
                    }
                    System.out.print('B');
                    theLetter = 'C';
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
    public void cPrint() {
        synchronized (monitor) {
            try {
                for (int i = 0; i < 5; i++) {
                    while (theLetter != 'C'){
                        monitor.wait();
                    }
                    System.out.print('C');
                    theLetter = 'A';
                    monitor.notifyAll();
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
