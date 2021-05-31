package J3Lesson4;

public class FirstVariant {

    public static void main(String[] args) throws InterruptedException {
        FirstVariant test = new FirstVariant();
        for (int i = 0; i < 5; i++) {
            Thread aThread = new Thread(() -> {
                test.aPrint();
            });
            Thread bThread = new Thread(() -> {
                test.bPrint();
            });
            Thread cThread = new Thread(() -> {
                test.cPrint();
            });
            aThread.start();
            aThread.join();
            bThread.start();
            bThread.join();
            cThread.start();
            cThread.join();
            //Возможно это костыль с join() методами.
    }
    }

    public  synchronized void aPrint() {
        System.out.print("A");
    }
    public  synchronized void bPrint() {
        System.out.print("B");
    }
    public  synchronized void cPrint() {
        System.out.print("C");
    }
}