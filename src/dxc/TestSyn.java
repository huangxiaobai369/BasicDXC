package dxc;

public class TestSyn {
    public static int i = 0;
    public static class T1 implements Runnable{
        @Override
        public synchronized void run() {
            for(int j=0;j<100000;j++){
                i++;
            }
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T1 t1 = new T1();
        Thread tt1 = new Thread(t1);
        Thread tt2 = new Thread(t1);
        tt1.start();
        tt2.start();
        tt1.join();
        tt2.join();
        System.out.println(i);
    }
}
