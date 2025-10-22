package org.example;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class FibSeries {

    private Integer a =0;
    private final Object lock = new Object();
    private Integer b = 1;
    private Integer temp =0;
    private ExecutorService executorService = Executors.newFixedThreadPool(5);

    public void printSeries() {
        List<Future<Void>> futureList = new ArrayList<>();
        for (int i = 0; i < 30; i++) {

            Future<Void> future = executorService.submit(()->{
                synchronized(lock){
                    System.out.println(a);
                    temp = b;
                    b=a+b;
                    a=temp;
                }
                return null;

            });
            futureList.add(future);
        }

        for(Future<Void> future:futureList){
            try{
                future.get();
            }catch (Exception ex){
                ex.printStackTrace();
            }
        }

        executorService.shutdown();
    }


}
