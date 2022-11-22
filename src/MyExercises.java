import lt.itakademija.exam.Exercises;
import lt.itakademija.exam.IntegerGenerator;
import lt.itakademija.exam.NumberFilter;

import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class MyExercises implements Exercises {

    List<Integer> numbers = new ArrayList<>();

    @Override
    public Integer findSmallest(List<Integer> list) {
        return list.stream()
                .min(Comparator.comparing(Integer::valueOf))
                .get();
    }

    @Override
    public Integer findLargest(List<Integer> list) {
        return list.stream()
                .max(Comparator.comparing(Integer::valueOf))
                .get();
    }

    @Override
    public boolean isEqual(Object o, Object o1) {
        return o.equals(o1);
    }

    @Override
    public boolean isSameObject(Object o, Object o1) {
        return o == o1;
    }

    @Override
    public List<Integer> consume(Iterator<Integer> iterator) {
        List<Integer> listOfNumbers = new ArrayList<>();
        listOfNumbers.add(iterator.next());

        return listOfNumbers;
    }

    @Override
    public int computeSumOfNumbers(int number) {
        int sum = 0;
        for (int i = 1; i <= number; i++){
            sum = sum + i;
        }
        return sum;
    }

    @Override
    public int computeSumOfNumbers(int number, NumberFilter numberFilter) {
        int sum = 0;
        for (int i = 1; i <= number; i++){
            if (numberFilter.accept(i)){
                sum = sum + i;
            }
        }
        return sum;
    }

    @Override
    public List<Integer> computeNumbersUpTo(int number) {
        List<Integer> numbersUpTo = new ArrayList<>();
        for (int i = 1; i < number; i++){
            numbersUpTo.add(i);
        }
        return numbersUpTo;
    }

    @Override
    public Map<Integer, Integer> countOccurrences(List<Integer> list) {
       Map<Integer, Integer> counts= new TreeMap<>();
        for (Integer number : list) {
            if (!counts.containsKey(number)){
                counts.put(number, 1);
            } else {
                int count = counts.get(number);
                count++;
                counts.put(number, count);
            }
        }

        return counts;
    }

    @Override
    public IntegerGenerator createIntegerGenerator(int from, int to) {
        return null;
    }

    @Override
    public IntegerGenerator createFilteredIntegerGenerator(IntegerGenerator integerGenerator, NumberFilter numberFilter) {
        return null;
    }
}
