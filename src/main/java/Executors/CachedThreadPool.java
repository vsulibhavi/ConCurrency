package Executors;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.stream.Collectors;
import java.util.stream.IntStream;

public class CachedThreadPool {


    public static void main(String[] args){

      long start =   System.nanoTime();
      ExecutorService es =  Executors.newCachedThreadPool();

        List<Future<NumberPrime>> test = IntStream.rangeClosed(100, 900000).mapToObj(

                num -> {
                    return es.submit(new PrimeRunnable(num));
                }).collect(Collectors.toList());

        test.stream().forEach(booleanFuture -> {
            try {
                System.out.println(booleanFuture.get().getNumber()  +" " + booleanFuture.get().isPrime);
            } catch (InterruptedException e) {
                e.printStackTrace();
            } catch (ExecutionException e) {
                e.printStackTrace();
            }
        });

        System.out.println("Total time :"+ (System.nanoTime() - start)/1000000.0);
        es.shutdown();
    }
}
