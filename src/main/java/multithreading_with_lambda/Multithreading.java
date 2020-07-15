package multithreading_with_lambda;

import functional_programming.PowerOfLambda;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

public class Multithreading {
     PowerOfLambda<String,String> frequencyOfCharacters= str->{
        Map<String,Integer> map=new HashMap<>();
        for (String s:str.split("")){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        return map.entrySet().stream().map(c->c.getKey()+c.getValue())
                .collect(Collectors.joining());
    };
    PowerOfLambda<String,String> uniqueCharacters= str->{
        Map<String,Integer> map=new HashMap<>();
        for (String s:str.split("")){
            map.put(s,map.getOrDefault(s,0)+1);
        }
        return map.entrySet().stream().filter(c->c.getValue()==1)
                .map(c->c.getKey()).collect(Collectors.joining());
    };
    PowerOfLambda<String,String> removeDuplicates= str->{
        return str.codePoints().distinct().mapToObj(o->""+o)
                .collect(Collectors.joining());
    };

}

class AppThread{
    public static void main(String[] args) {
        String str="AABCCDEEF";
        Multithreading thread=new Multithreading();
        Thread t1=new Thread(()->{
            System.out.println("Remove Duplicates: "+thread.removeDuplicates.lambda(str));
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        Thread t2=new Thread(()->{
            System.out.println("Frequency Of Characters: "+thread.frequencyOfCharacters.lambda(str));
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        });
        Thread t3=new Thread(()->{
            System.out.println("Unique Characters: "+thread.uniqueCharacters.lambda(str));
            try {
                Thread.sleep(15000);
            } catch (InterruptedException e) {

                e.printStackTrace();
            }
        });


        t1.start();
        try {Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t2.start();
        try {Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t3.start();;

    }
}

