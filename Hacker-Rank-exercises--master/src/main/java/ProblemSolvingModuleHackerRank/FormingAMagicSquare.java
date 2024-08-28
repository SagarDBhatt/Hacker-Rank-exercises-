package ProblemSolvingModuleHackerRank;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.stream.IntStream;

public class FormingAMagicSquare {
    public static void main(String[] args) {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        List<List<Integer>> list = new ArrayList<>();

        IntStream.range(0,3).forEach(i -> {
            try {
                list.add(Arrays.stream(br.readLine().split(" ")).map(Integer::parseInt).toList());
            }catch (IOException e){
                e.printStackTrace();
            }
        });

        System.out.println(FormingASquareResult.formingMagicSquare(list));
    }
}

class FormingASquareResult{
    public static int formingMagicSquare(List<List<Integer>> s) {
        List<List<List<Integer>>> magicSquares = List.of(
                List.of(List.of(8, 1, 6), List.of(3, 5, 7), List.of(4, 9, 2)),
                List.of(List.of(6, 1, 8), List.of(7, 5, 3), List.of(2, 9, 4)),
                List.of(List.of(4, 9, 2), List.of(3, 5, 7), List.of(8, 1, 6)),
                List.of(List.of(2, 9, 4), List.of(7, 5, 3), List.of(6, 1, 8)),
                List.of(List.of(8, 3, 4), List.of(1, 5, 9), List.of(6, 7, 2)),
                List.of(List.of(4, 3, 8), List.of(9, 5, 1), List.of(2, 7, 6)),
                List.of(List.of(6, 7, 2), List.of(1, 5, 9), List.of(8, 3, 4)),
                List.of(List.of(2, 7, 6), List.of(9, 5, 1), List.of(4, 3, 8))
        );

        AtomicInteger minimumCost = new AtomicInteger(Integer.MAX_VALUE);

        magicSquares.forEach(magicSquare -> {
            AtomicInteger cost = new AtomicInteger();

            IntStream.range(0, magicSquare.size()).forEach(row -> {
                IntStream.range(0, magicSquare.get(row).size()).forEach(col -> {
                    cost.addAndGet(Math.abs(s.get(row).get(col) - magicSquare.get(row).get(col)));
                });
            });

            minimumCost.set(Integer.min(cost.get(), minimumCost.get()));
        });

        return minimumCost.get();
    }
}