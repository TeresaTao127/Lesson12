package lesson12Task4;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

public class AverageAndSumCalculator {
    public static void main(String[] args) throws InterruptedException, ExecutionException {
        List<Integer> numbers = new ArrayList<>();
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
        numbers.add(4);

        ExecutorService executorService = Executors.newFixedThreadPool(2);

        Future<Double> averageFuture = executorService.submit(() -> calculateAverage(numbers));
        Future<Integer> sumFuture = executorService.submit(() -> calculateSum(numbers));

        double average = averageFuture.get();
        int sum = sumFuture.get();


        System.out.println("Average: " + average);
        System.out.println("Sum " + sum);

        executorService.shutdown();
    }


    public static int calculateSum(List<Integer> numbers) {
        int sum = 0;
        for (int number : numbers) {
            sum += number;
        }
        return sum;
    }

    public static double calculateAverage(List<Integer> numbers) {
        if (numbers.isEmpty()) {
            return 0;
        }
        int sum = calculateSum(numbers);
        return (double) sum / numbers.size();
    }

}