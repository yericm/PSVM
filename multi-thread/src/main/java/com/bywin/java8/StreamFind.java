package com.bywin.java8;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

/**
 * created by yeric on 2019/8/14
 */
public class StreamFind {
    public static void main(String[] args) {
        List<String> names= Arrays.asList("one", "two", "three", "four");
        Optional<String> optionalAny = names.stream().findAny();
        Optional<String> optionalFirst = names.stream().findFirst();

        // anyMatch操作用于判断Stream中的是否有满足指定条件的元素。如果最少有一个满足条件返回true，否则返回false。
        boolean anyMatch = names.stream().anyMatch(s -> s.length()>4);
        // allMatch操作用于判断Stream中的元素是否全部满足指定条件。如果全部满足条件返回true，否则返回false。
        boolean allMatch = names.stream().allMatch(s -> s.length()<10);
        //
        boolean noneMatch = names.stream().noneMatch(s -> s.length()==6);

        Optional accResult = Stream.of(1, 2, 3, 4)
                .reduce((acc, item) -> {
                    System.out.println("acc : "  + acc);
                    acc += item;
                    System.out.println("item: " + item);
                    System.out.println("acc+ : "  + acc);
                    System.out.println("--------");
                    return acc;
                });
        System.out.println("accResult: " + accResult.get());
        System.out.println("--------");
        int accResult1 = Stream.of(1, 2, 3, 4)
                .reduce(5, (acc, item) -> {
                    System.out.println("acc : "  + acc);
                    acc += item;
                    System.out.println("item: " + item);
                    System.out.println("acc+ : "  + acc);
                    System.out.println("--------");
                    return acc;
                });
        System.out.println("accResult: " + accResult1);
        System.out.println("--------");
    }
}
