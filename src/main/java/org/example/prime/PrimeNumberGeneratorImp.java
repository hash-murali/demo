package org.example.prime;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.math.BigInteger;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Set;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class PrimeNumberGeneratorImp extends PrimeNumbersGenerator {
    @Override
    public void generatorPrimeNumbers(int limit) {
        final Object lock = new Object();
        boolean hasDivider = false;
        long initialStart = System.nanoTime();
        Path path = Paths.get("/Users/mks/My Space/projects/infosys/demo/bank-sim-simulation-suite/untitled/prime_numbers.txt");
        List<Integer> fileList = new ArrayList<>();
        fileList.add(2);

        try(Stream<String> lines = Files.lines(path)){
            fileList.addAll(lines.map(Integer::parseInt)
                    .collect(Collectors.toList()));
        }catch (IOException ex){
            System.out.println(Arrays.toString(ex.getStackTrace()));
        }

        int initialValue = fileList.get(fileList.size()-1);
        Set<Integer> list = new CopyOnWriteArraySet<>(fileList);
        int size = list.size();
        long start = System.nanoTime();
        for(int i=(initialValue==2?1:initialValue)+2;i<=10000;i+=2){
            int finalI = i;
            System.out.println("Current i value :"+finalI);
            int n = (int) Math.sqrt(finalI);
            hasDivider = list.stream()
                    .parallel()
                    .anyMatch(
                            x->
                                    finalI %x==0
                                            &&
                                            x <= n
                    );
            if(!hasDivider){
                synchronized (lock){
                    list.add(i);
                }
            }

        }

        long end = System.nanoTime();
        if(size!=list.size()) {
            try (BufferedWriter writer = new BufferedWriter(new FileWriter("prime_numbers.txt"))) {
                for (int i : list) {
                    writer.write(i + "\n");
                }
            } catch (IOException ex) {
                System.out.println(Arrays.toString(ex.getStackTrace()));
            }
        }
//        list.forEach(System.out::println);
        System.out.println("initial value :"+initialValue + " initial size : "+size+" current size : "+list.size());

        System.out.println("Time took to cal : "+(end-start));
        System.out.println("time to complete task: "+(System.nanoTime()-initialStart));
    }

    @Override
    public void displayLargerOne() {

    }

    @Override
    public BigInteger getLargestPrimeDiscovery() {
        return null;
    }
}
