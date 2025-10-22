package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;
import java.util.concurrent.TimeUnit;
import java.util.logging.Level;

import java.util.logging.Logger;

public class FibSeries {

    private final Logger log = Logger.getLogger(FibSeries.class.getName());
    private final Object lock;
    private Integer a, b, temp;
    private final ExecutorService executorService;

    public FibSeries(){
        this.lock = new Object();
        this.a=0;
        this.b=1;
        this.temp=0;
        this.executorService = Executors.newFixedThreadPool(5);
    }


    public void printSeries() {
        log.log(Level.parse("INFO"),"Printing Fib series starts: ");
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
                log.log(Level.parse("SEVERE"), Arrays.toString(ex.getStackTrace()));
            }
        }
        try {
            executorService.awaitTermination(250, TimeUnit.MILLISECONDS);
            log.log(Level.parse("INFO"), "Log complete");
        } catch (InterruptedException e) {
            throw new RuntimeException(e);
        }finally {
            executorService.shutdown();
        }
    }


}
