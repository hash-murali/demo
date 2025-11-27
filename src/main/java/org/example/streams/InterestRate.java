package org.example.streams;

import java.util.*;
import java.util.concurrent.*;
import java.util.stream.Collectors;
import java.util.stream.DoubleStream;

public class InterestRate {

    private static double rate;

    public static void main(String[] arg){
        Map<Double, Double> ls = new ConcurrentHashMap<>();

        List<AbstractMap.SimpleEntry> list = DoubleStream.iterate(0.04, rate->rate<=0.09, rate->rate+0.01)
                .parallel()
                .mapToObj(x->new AbstractMap.SimpleEntry(x,InterestRate.function(x)))
                        .collect(Collectors.toList());
        list.forEach((x)-> System.out.println("rate : "+x.getKey()+" month : "+x.getValue()));
    }

    public static double function(double rate){
        double month = Math.pow(1 + rate, (double) 1 /12) -1;
        double timePlusOne = 12 * (18 + 1); // change this inner number to number of years
        double total = 1000000; // this is target amount
        return (total * month)/(Math.pow(1+month, timePlusOne)-1);
    }



}
