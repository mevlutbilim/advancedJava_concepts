package functional_programming;

import java.util.*;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;


public class ArrayOperations {
    StringOperations str=new StringOperations();
    public static void main(String[] args) {
        String s1="abbbbcccd";
        String s2="abcd";
        System.out.println(isBuildOut.lambda(s1,s2));
    }
    /*
Given an unsorted integer array, find the smallest missing positive integer.
Example
Input: [3,4,-1,1]
Output: 2
Example 3:
 */
    public static PowerOfLambda<Integer, int[]> missingPositive = arr -> {
        return IntStream.range(1, arr.length)
                .filter(i -> Arrays.stream(arr)
                        .noneMatch(x -> x == i))
                .findFirst().orElse(0);
    };
    //write a java program to find maximum element.
    public static PowerOfLambda<Integer, int[]> maxNumber = array -> {
        return Arrays.stream(array)
                .max().orElse(0);
    };
    //write a java program to find minimum element.
    public static PowerOfLambda<Integer, int[]> minNumber = array -> {
        return Arrays.stream(array)
                .min().orElse(0);
    };

    //write a java program that can return the second maximum value from an int array
    public static PowerOfLambda<Integer, int[]> secondMax = arr -> {
        return Arrays.stream(arr)
                .boxed().sorted((x, y) -> y.compareTo(x))
                .collect(Collectors.toList())
                .get(1);
    };
    //write a java program that can return the second minimum value from an int array
    public static PowerOfLambda<Integer, int[]> secondMin = arr -> {
        return Arrays.stream(arr)
                .boxed().sorted()
                .collect(Collectors.toList())
                .get(1);
    };
    //write a java program that can find the unique values from an int array
    //return type is int array
    public static PowerOfLambda<int[], int[]> uniqueIntArray = arr -> {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        return map.entrySet().stream()
                .filter(uniq -> uniq.getValue() == 1)
                .mapToInt(uniq -> uniq.getKey())
                .toArray();
    };
    //write a java program that can find the unique values from a string array
    //return type is string array
    public static PowerOfLambda<String[], String[]> uniqueStringArray = arr -> {
        Map<String, Integer> map = new HashMap<>();
        for (String s : arr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        return (String[]) map.entrySet().stream()
                .filter(uniq -> uniq.getValue() == 1)
                .map(uniq -> uniq.getKey())
                .toArray();
    };
    //write a java program that can find the unique values from an int array
    //return type is List<Integer>
    public static PowerOfLambda<List<Integer>, int[]> uniqueIntList = arr -> {
        Map<Integer, Integer> map = new HashMap<>();
        for (int i : arr) {
            map.put(i, map.getOrDefault(i, 0) + 1);
        }
        return map.entrySet().stream()
                .filter(uniq -> uniq.getValue() == 1)
                .map(uniq -> uniq.getKey())
                .collect(Collectors.toList());
    };
    //write a java program that can find the unique values from a string array
    //return type is List<String>
    public static PowerOfLambda<List<String>, String[]> uniqueStringList = arr -> {
        Map<String, Integer> map = new HashMap<>();
        for (String s : arr) {
            map.put(s, map.getOrDefault(s, 0) + 1);
        }
        return map.entrySet().stream()
                .filter(uniq -> uniq.getValue() == 1)
                .map(uniq -> uniq.getKey())
                .collect(Collectors.toList());
    };
    /*
    write a program that can check if two Strings are build out of same    Ex:
     if str1 = "aabbbc";  str2 ="cab";        output: true        if str1 ="abcd";  str2 ="abc";        output: false
    */
    public static Functional<Boolean,String> isBuildOut=(str1, str2)->{
        return Arrays.stream(str1.split("")).distinct()
                .allMatch(s1->Arrays.stream(str2.split(""))
                        .distinct().anyMatch(s2->s1.equalsIgnoreCase(s2)));
    };
     /*
    a.write a return method that accepts an int array and sorts it in descending order.
 	b.write a return method that accepts a double array and sorts it in descending order.
 	c.write a return method that accepts a char array and sorts it in descending order.
    d.write a return method that accepts a String array and sorts it in descending order
    Hint: method overloading is prefered here
 */
    // a.write a return method that accepts an int array and sorts it in descending order.
    public static List<Integer> descendingOrder(int[]intArr) {
        return Arrays.stream(intArr)
                .boxed()
                .sorted((x,y)->y.compareTo(x))
                .collect(Collectors.toList());

    }
    //b.write a return method that accepts a double array and sorts it in descending order.
    public static List<Double> descendingOrder(double []intDouble) {
        return Arrays.stream(intDouble)
                .boxed()
                .sorted((x,y)->y.compareTo(x))
                .collect(Collectors.toList());

    }
    //c.write a return method that accepts a char array and sorts it in descending order.
    public static List<Character> descendingOrder(char []chArr) {

        List<Character> chrlist=new ArrayList<Character>();
        for(Character chr:chArr) {
            chrlist.add(chr);
        }
        return chrlist.stream()
                .sorted((x,y)->y.compareTo(x))
                .collect(Collectors.toList());

    }
    //d.write a return method that accepts a String array and sorts it in descending order
    public static List<String> descendingOrder(String []strArr) {
        return Arrays.stream(strArr)
                .sorted((x,y)->y.compareTo(x))
                .collect(Collectors.toList());

    }
    /*
 You are given an integer array nums and you have to return a new counts array.
 The counts array has the property where counts[i] is the number of smaller elements to the right of nums[i].

Example:

Input: [5,2,6,1]
Output: [2,1,1,0]
 */
    public static PowerOfLambda<Stream<Integer>,int[]> smallerElements= a->{
        return IntStream.range(0,a.length)
                .mapToObj(i->{
                    return (int)IntStream.range(i+1,a.length)
                            .filter(j->a[i]>a[j])
                            .count();
                });
    };
    //find to biggest palindrome in string array - using StringOperations class' method(isPalindrome)
    public static PowerOfLambda<String,String[]> biggestPalindrome=strings -> {
        return Stream.of(strings)
                .filter(string->StringOperations.isPalindrome.lambda(string))
                .max(String::compareTo).get();
    };


}