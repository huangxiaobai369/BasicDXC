package dxc;

/**
 * wait()与notify()基础用法
 *
 * wait()，notify()必须包含对应的synchronzied语句中
 */
public class BasicWN {
    public static Object object = new Object();
    public static  class T1 extends Thread{
        @Override
        public  void run() {
            synchronized(object){
                try {
                    System.out.println("T1->begin");
                    object.wait();
                    System.out.println("T1->end");
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }


    public static class T2 extends Thread{
        @Override
        public void run() {
            synchronized(object){
                System.out.println("T2->begin");
                object.notify();
                System.out.println("T2->end");
            }

        }
    }

    public static void main(String[] args) {
        T1 t1 = new T1();
        T2 t2 = new T2();
        t1.start();
        t2.start();
    }
}
