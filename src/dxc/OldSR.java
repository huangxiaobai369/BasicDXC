package dxc;

/**
 * 挂起（suspend）,继续执行（resume）
 */
public class OldSR {
    public static class SuspendDemo extends Thread{
        @Override
        public void run() {
            System.out.println(getName()+"->begin");
            Thread.currentThread().suspend();
            System.out.println(getName()+"->end");
        }
    }

    public static void main(String[] args) {
        try {
            SuspendDemo s1 = new SuspendDemo();
            SuspendDemo s2 = new SuspendDemo();
            s1.start();
            Thread.sleep(100);
            s2.start();
            s1.resume();
            Thread.sleep(100);
            s2.resume();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
