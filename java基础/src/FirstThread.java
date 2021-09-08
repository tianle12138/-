import java.util.concurrent.*;

public class FirstThread {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        Thread A = new Thread(()->{
            try {

                Thread.sleep(1234);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("A");
        });
        Thread B = new Thread(()->{

            try {
                A.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println("B");
        });
        // A.start();
        // B.start();
        ExecutorService executor = Executors.newCachedThreadPool();
        Task task = new Task();
        Future<Integer> result = executor.submit(task);
        System.out.println(result.get());

    }
}
class Task implements Callable<Integer>{

    @Override
    public Integer call() throws Exception {
        Thread.sleep(1000);
        return 100;
    }
}
