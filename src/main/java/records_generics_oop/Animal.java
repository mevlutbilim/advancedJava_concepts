package records_generics_oop;

import java.util.Arrays;
import java.util.List;

interface AnimalFactory<T extends Animal>{
    T create(String gender, byte age, String color, String name);
}

public abstract class Animal {
    String gender;
    byte age;
    String color;
    String name;
    public Animal(String gender,byte age,String color,String name) {
        this.gender=gender;
        this.age=age;
        this.name=color;
        this.color=color;

    }

    public  abstract void Speak(String language);

    public abstract void Eat(String food);


    public abstract void Sleep(int hour);

    public abstract void Drink(String drinks);


    public void getInfo() {
        System.out.println("Nick Name: "+name);
        System.out.println("Age : "+age);
        System.out.println("Gender :"+gender);
        System.out.println("Color  : "+color);
    }
}

class Cat extends Animal {

    public Cat(String gender, byte age, String color, String name) {
        super(gender, age, color, name);
        // TODO Auto-generated constructor stub
    }

    @Override
    public void Speak(String language) {
        System.out.println(name+" is peaking "+language);

    }

    @Override
    public void Eat(String food) {
        System.out.println(name+" is eating "+ food);

    }

    @Override
    public void Sleep(int hour) {
        System.out.println(name+" is sleeping "+hour+" hours");

    }

    @Override
    public void Drink(String drinks) {
        System.out.println(name+" is drinking "+drinks);

    }

}

class Dog extends Animal {
    public Dog(String gender, byte age, String color, String name) {
        super(gender, age, color, name);

    }

    @Override
    public void Speak(String language) {
        System.out.println(name+"is speaking "+language);

    }

    @Override
    public void Eat(String food) {
        System.out.println(name+" is eating "+food);

    }

    @Override
    public void Sleep(int hour) {
        System.out.println(name+" is sleeping "+hour+" hours");

    }

    @Override
    public void Drink(String drinks) {
        System.out.println(name+" is drinking "+drinks);

    }

}

class Tom extends Cat {

    public Tom(String gender, byte age, String color, String name) {
        super(gender, age, color, name);
    }
    public void canCatch(){
        System.out.println("Tom can catch Jerry");
    }
}

class AnimalApp{
    public static void main(String[] args) {
        AnimalFactory<Animal> cat= Cat::new,
                              dog= Dog::new,
                              tom= Tom::new;
        List<Animal> animalList= Arrays.asList(
                cat.create("male", (byte) 2,"white","Simon"),
                dog.create("female",(byte)4,"black","Freedy"),
                tom.create("baby",(byte)0,"Red","Tommy")
        );
    }

}