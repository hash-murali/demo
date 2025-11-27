package org.example.streams;

import java.math.BigInteger;
import java.util.concurrent.atomic.AtomicLong;
import java.util.stream.Stream;

public class SumOfCubes {

    public static void main(String[] arg){
        int n=3;
        AtomicLong sum = new AtomicLong();

        long start = System.nanoTime();

        // highest answer for  90000000 : 16402499635500002025000000000000
        BigInteger l = Stream.iterate(new BigInteger("1"), x->x.compareTo(new BigInteger("4"))<0, x->x.add(new BigInteger("1")))
                        .parallel()
                .map(x->x.pow(3))
                .reduce(BigInteger.valueOf(0L), BigInteger::add);
        System.out.println("time took :" + (System.nanoTime() - start));
        System.out.println(l);
    }
}
