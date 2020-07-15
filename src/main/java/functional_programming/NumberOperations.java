package functional_programming;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class NumberOperations {

    //Write a Java program to find factorial of given number
    public static PowerOfLambda<Object,Integer> factorial= n->{
        if (n==0){
            return 1;
        }else if(n<0){
            return "No factorial of negative numbers";
        }
        return IntStream.rangeClosed(1,n)
                .reduce(1,(x,y)->x*y);
    };
    /*
    In fibonacci series, next number is the sum of previous two numbers
    for example 0, 1, 1, 2, 3, 5, 8, 13, 21, 34, 55 etc.
    The first two numbers of fibonacci series are 0 and 1
     */
    public static PowerOfLambda<List<Integer>,Integer> fiboNumbers= number->{
        return Stream.iterate(new int[]{0,1}, fibo->new int[]{fibo[1],fibo[0]+fibo[1]})
                .limit(number)
                .map(fibo->fibo[0])
                .collect(Collectors.toList());
    };
    /*   1.create an int array called numbers that has length of 100
         2.  assign 1~100 to the array' indexes
         3. find to even numbers
    */

    public static PowerOfLambda<int[],Integer> evenNumbersArray= num->{
        int[] numbers=new int[num];
        Stream.iterate(0,i->++i)
                .limit(99)
                .forEach(i->numbers[i]=i+1);
        return Arrays.stream(numbers)
                .filter(x->x%2==0)
                .toArray();

    };
    //write a java method to reverse the number
    //input =123 output=321
    public static PowerOfLambda<Integer,Integer> reverseNumber= n->{
        return Stream.of(String.valueOf(n).split(""))
                .reduce((x,y)->y+x)
                .map(Integer::parseInt)
                .orElse(0);

    };

// find to Armstrong numbers list
    public PowerOfLambda<List<Integer>,Integer> armStrongList= number->{

        return IntStream.rangeClosed(1,number)
                .boxed()
                .filter(i->isArmstrong.lambda(i))
                .collect(Collectors.toList());
    };
    /*
    Given a number x, determine whether the given number is Armstrong number or not.
    A positive integer of n digits is called an Armstrong number of order n (order is number of digits) if.
Input : 153
Output : Yes
153 is an Armstrong number.
1*1*1 + 5*5*5 + 3*3*3 = 153
     */
    private static PowerOfLambda<Boolean,Integer> isArmstrong= number-> {
        String num=String.valueOf(number);
        return number==Stream.of(num.split(""))
                .mapToInt(Integer::valueOf)
                .map(n-> (int) Math.pow(n,num.length()))
                .sum();

    };
    //is number prime?
    public static PowerOfLambda<Boolean,Integer> isPrime= number-> {
        return number>1&&IntStream.range(2, number)
                .noneMatch(n->number%n==0);
    };


}
