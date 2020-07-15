package functional_programming;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

public class StringOperations {
    /*
      write a java program that can count how many
      time the word "book" is appered in a String Ex:
      input: I like books, I have books, I need book
      output: 3
   */

    public static PowerOfLambda<Integer,String> countWord= str->{
        return (int) Arrays.stream(str.split(" "))
                .filter(word->word.toLowerCase().contains("book"))
                .count();
    };
    //write a java program to find all permutations of string
    public static Stream<String> permutation(String s)
    {
        if(s.isEmpty()){
            return Stream.of("");
        }
        return IntStream.range(0,s.length())
                .boxed()
                .flatMap(i->permutation(s.substring(0,i)+s.substring(i+1)).
                        map(t->s.charAt(i)+t));
    };
    /*
        Write a java program to reverse the String without reverse method
        input =ABCD
        output =DCBA
    */
    public static PowerOfLambda<String,String> reverseString= str->{
                return Arrays.stream(str.split(""))
                        .reduce("",(x,y)->y+x);
            };
    /*
    write a java program that can  find unique of characters in string
     */
    public static PowerOfLambda<String,String> uniqueChars= str->{
        Map<String,Integer> map=new HashMap<>();
        for (String s:str.replaceAll(" ","").split("")){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        return map.entrySet().stream()
                .filter(value->value.getValue()==1)
                .map(key->key.getKey())
                .collect(Collectors.joining());
    };
    // write a java program that can find frequency  of characters in string
    public static PowerOfLambda<String,String> frequencyChars= str->{
        Map<String,Integer> map=new HashMap<>();
        for (String s:str.replaceAll(" ","").split("")){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        return map.entrySet().stream()
                .map(s->s.getKey()+s.getValue())
                .collect(Collectors.joining());
    };
    //write a java program that can remove duplicates from string
    public static PowerOfLambda<String,String> removeDup= str->{
        Map<String,Integer> map=new HashMap<>();
        for (String s:str.replaceAll(" ","").split("")){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        return map.entrySet().stream()
                .map(s->s.getKey())
                .collect(Collectors.joining());
    };
    /*  write a java program that can sum of number in the string
       input="I have 12 apples . john has 34 apples. how many apple we have? "
       output=46
    */
    public static PowerOfLambda<Integer,String> sumOfNumbersInString= s->{

        String[] numbers=s.replaceAll("^[0-9]"," ").split(" ");

        return Arrays.stream(numbers)
                .filter(n->!n.isEmpty())
                .mapToInt(Integer::parseInt)
                .sum();
    };

    //write a java program that can check is string palindrome

    public static PowerOfLambda<Boolean,String> isPalindrome= s->{
        String result=s.toLowerCase().codePoints()
                .filter(Character::isLetterOrDigit)
                .mapToObj(String::valueOf)
                .collect(Collectors.joining());

        return result.equals(new StringBuilder(result).reverse().toString()) ;
    };
    /*
Implement atoi which converts a string to an integer.

The function first discards as many whitespace characters as necessary until the first non-whitespace character is found. Then, starting from this character, takes an optional initial plus or minus sign followed by as many numerical digits as possible, and interprets them as a numerical value.

The string can contain additional characters after those that form the integral number, which are ignored and have no effect on the behavior of this function.

If the first sequence of non-whitespace characters in str is not a valid integral number, or if no such sequence exists because either str is empty or it contains only whitespace characters, no conversion is performed.

If no valid conversion could be performed, a zero value is returned.
Input: "42"
Output: 42
Example 2:

Input: "   -42"
Output: -42
Explanation: The first non-whitespace character is '-', which is the minus sign.
             Then take as many numerical digits as possible, which gets 42.
Example 3:

Input: "4193 with words"
Output: 4193
Explanation: Conversion stops at digit '3' as the next character is not a numerical digit.
Example 4:

Input: "words and 987"
Output: 0
Explanation: The first non-whitespace character is 'w', which is not a numerical
             digit or a +/- sign. Therefore no valid conversion could be performed.
Example 5:

Input: "-91283472332"
Output: -2147483648
Explanation: The number "-91283472332" is out of the range of a 32-bit signed integer.
             Thefore INT_MIN (−231) is returned.
 */
    public static PowerOfLambda<Integer,String> toInteger= str-> {
        char c = str.charAt(0);
        if (Character.isLetter(c)
                || (Character.isSpaceChar(c)
                && str.contains("^[a-z]"))) {
            return 0;
        }

        String s = str.replaceAll("[a-z]", "");

        return Stream.of(s)
                .mapToInt(Integer::parseInt)
                .findAny()
                .orElse(Integer.MAX_VALUE);
    };
    /*
       Please Implement in C# the function that increments a string based on the rules below:
1. It should take the string of unknown length and increment the numeric ending of that string by 1.
2. If numeric ending is overflown it must be reset.
3. Don't use regular expressions.

1. 000002 -> 000003
2. 999999 -> 000000
3. GL-321 -> GL-322
4. GL-999 -> GL-000
5. DRI000EDERS0RE -> DRI000EDERS0RE
6. DRI000EDERS0RE99999 -> DRI000EDERS0RE00000
        */

    public static PowerOfLambda<String,String> nineToZero= s->{

        char [] a=s.toCharArray();
        int len=s.length();
        for (int i=0;i<a.length;i++){

            if (a[i]=='9'){
                a[i]='0';
            }else if (Character.isDigit(a[i])&&i==len-1){
                a[i]++;
            }


        }
        return new String(a);

    };

}
