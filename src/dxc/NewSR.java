package dxc;

/**
 * 用wait()与notify()实现suspend与resume的功能
 */
public class NewSR {
    public static  Object o = new Object();
    public static class  T1 extends Thread{
        volatile boolean suspendme = false;
        public void suspendMe(){
            suspendme = true;
        }

        public void resumeMe(){
            suspendme = false;
            synchronized(this){
                notify();
            }
        }

        @Override
        public void run() {
            while(true){
                synchronized (this){
                    if (suspendme){
                        try {
                            wait();
                        } catch (InterruptedException e) {
                            e.printStackTrace();
                        }
                    }
                }
                synchronized (o){
                    System.out.println("in T1 ..");
                }
                Thread.yield();
            }
        }
    }

    public static class T2 extends Thread{
        @Override
        public void run() {
            while (true){
                synchronized(o){
                    System.out.println("in T2 ....");
                }
                Thread.yield();
            }

        }
    }

    public static void main(String[] args) throws InterruptedException {
        T1 t1 = new T1();
        T2 t2 = new T2();
        t1.start();
        t2.start();
        System.out.println("sleep before---------------");
        Thread.sleep(1000);
        System.out.println("sleep after---------------");
        t1.suspendMe();
        Thread.sleep(2000);
        t1.resumeMe();
    }
}
