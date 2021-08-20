import static java.lang.Thread.sleep;

public class VolatilTest {
    int index = 0;
    volatile boolean flag = true;

    public void write() throws InterruptedException {
        index = 1000;
        Thread.sleep(20);
        flag = true;
    }

    public void read() {
        if (flag) {
            System.out.println(index);
        }
    }

    public static void main(String[] args) throws InterruptedException {
        VolatilTest cls = new VolatilTest();
        while (true) {
            Thread t1 = new Thread(new Runnable() {
                @Override
                public void run() {
                    try {
                        cls.write();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            });
            Thread t2 = new Thread(new Runnable() {
                @Override
                public void run() {
                    cls.read();
                }
            });
            t1.start();
            t2.start();
            Thread.sleep(50);
            cls.index = 0;
        }

    }
}
