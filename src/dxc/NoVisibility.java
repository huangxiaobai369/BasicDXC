package dxc;

public class NoVisibility {
    public static boolean ready;
    public static int number;
    public static  class  T1  extends  Thread{
        @Override
        public void run() {
            while (!ready);
            System.out.println(number);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        T1 t1 = new T1();
        t1.start();
        Thread.sleep(1000);
        number = 100;
        ready = true;
        System.out.println("=================");
        Thread.sleep(10000);

    }
}
