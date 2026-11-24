import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;
public class ConcurrencyPractice {
 public static void main(String[]args)throws InterruptedException,ExecutionException{
  AtomicInteger count=new AtomicInteger();
  ExecutorService pool=Executors.newFixedThreadPool(4);
  try{
   Future<?>[] tasks=new Future<?>[4];
   for(int t=0;t<4;t++)tasks[t]=pool.submit(()->{for(int i=0;i<10000;i++)count.incrementAndGet();});
   for(Future<?> f:tasks)f.get();
   System.out.println("Expected 40000; actual "+count.get());
  }finally{pool.shutdown();if(!pool.awaitTermination(5,TimeUnit.SECONDS))pool.shutdownNow();}
 }
}
