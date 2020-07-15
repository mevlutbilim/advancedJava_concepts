package functional_programming;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class ListOperations {

    /*
 * There is a shop with old style cash registers. Rather than scanning items and pulling the price  from a database
 * the price of each item is typed in manually. This method sometimes leads to errors
 * given a list of items and their correct prices ,
 * compare the prices to those entered when each item was sold.
 * Determine the number of errors in selling prices.
 *      products=[Arrays.asList("eggs","milk","cheese"]
		productPrice=[2.89f,3.29f,5.79f];
	    productSold=["eggs","eggs","cheese","milk"];
		soldPrice=[2.89f,2.99f,5.97f,3.29f];
		The second sale of eggs has a wrong price, as does the sale of cheese.
		There are two errors in pricing
 */
    public static int priceCheck(List<String> products,List<Float> productPrice,List<String> productSold,List<Float> soldPrice) {


        return (int) IntStream.range(0,products.size())
                .filter(i->{
                    return IntStream.range(0, productSold.size())
                            .filter(j->products.get(i).toString().equals(productSold.get(j).toString()))
                            .anyMatch(j->productPrice.get(i).floatValue()!=soldPrice.get(j).floatValue());

                }).count();


    }
    /*
write a method that can remove all even numbers from a List Interface
write a method that can remove all odd numbers from a List Interface

*/
    //
    public static PowerOfLambda<List<Integer>,List<Integer>> removeEven= list->{
            return list.stream()
                    .filter(x->x%2==1)
                    .collect(Collectors.toList());
        };
        public static PowerOfLambda<List<Integer>,List<Integer>> removeOdd= list->{
            return list.stream()
                    .filter(x->x%2==0)
                    .collect(Collectors.toList());
        };
        //Combination with generics
        public static <T> Stream<List<T>> combination(List<T> l, int size) {
            if (size == 0) {
                return Stream.of(Collections.emptyList());
            } else {
                return IntStream.range(0, l.size()).boxed().
                        flatMap(i -> combination(l.subList(i+1, l.size()), size - 1)
                                .map(t -> pipe(l.get(i), t)));
            }
        }

    private static <T> List<T> pipe(T head,List<T> tail) {
        List<T> newList = new ArrayList<>(tail);
        newList.add(0, head);

        return newList;
    }
// check is two array equal
    public static Functional<Boolean,int[]> arrays=(arr1, arr2)->{
        return arr1.length==arr2.length &&
                Arrays.stream(arr1)
                        .allMatch(x->Arrays.stream(arr2)
                                .anyMatch(y->x==y));
    };

//prime number series 2,3,5,7,11,13,17,19......
    public static PowerOfLambda<List<Integer>,Integer> primeSeries= number->{
        return IntStream.rangeClosed(2,number).boxed()
                .filter(i-> NumberOperations.isPrime.lambda(number))
                .collect(Collectors.toList());

    };
    /*
Given an array of n integers, are there elements a, b, c in numbers such that
a + b + c = 0  Find all unique triplets in the array which gives the sum of zero.
Note:
The solution set must not contain duplicate triplets.
                    nums[0]+nums[1]+nums[5]
Example:          i  0  1  2
Given array nums = [-1, 0, 1, 2, -1, -4],

A solution set is:
[
  [-1, 0, 1],

  [-1, -1, 2]
]
 */
    public static List<List<Integer>>  threeSum(int [] nums,int target){
        Arrays.sort(nums);

        List<List<Integer>> result = new ArrayList<>();

        for (int i = 0; i < nums.length; i++) {
            int j = i + 1;
            int k = nums.length - 1;

            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            while (j < k) {
                if (k < nums.length - 1 && nums[k] == nums[k + 1]) {
                    k--;
                    continue;
                }

                if (nums[i] + nums[j] + nums[k] > target) {
                    j++;
                } else if (nums[i] + nums[j] + nums[k] < target) {
                    k--;
                } else {
                    ArrayList<Integer> l = new ArrayList<>();
                    l.add(nums[i]);
                    l.add(nums[j]);
                    l.add(nums[k]);
                    result.add(l);
                    j++;
                    k--;
                }
            }
        }

        return result;

    }

}


