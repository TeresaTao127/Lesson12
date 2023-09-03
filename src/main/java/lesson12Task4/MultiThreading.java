package lesson12Task4;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

public class MultiThreading {
    public static void main(String[] args) {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);

        Thread thread = new Thread(() -> {
            IntStream
                    .range(1, 5)
                    .forEach(num -> System.out.println(Thread.currentThread().getId() + "," + AverageAndSumCalculator.calculateAverage(numbers)));

        });

        Thread thread1 = new Thread(() -> {
            IntStream
                    .range(1, 5)
                    .forEach(num -> System.out.println(Thread.currentThread().getId() + "," + AverageAndSumCalculator.calculateSum(numbers)));

        });

        thread.start();
        thread1.start();
    }
}
