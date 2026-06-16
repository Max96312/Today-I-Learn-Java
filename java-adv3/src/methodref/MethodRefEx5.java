package methodref;

import lambda.lambda5.mystrem.MyStreamV3;

import java.util.List;

public class MethodRefEx5 {

    public static void main(String[] args) {
        List<Person> personList = List.of(
                new Person("Kim"),
                new Person("Park"),
                new Person("Lee")
        );

        List<String> result1 = MyStreamV3.of(personList)
                .map(person -> person.introduction())
                .map(str -> str.toUpperCase())
                .toList();

        System.out.println("result1 = " + result1);

        List<String> result2 = MyStreamV3.of(personList)
                .map(Person::introduction)
                .map(String::toUpperCase)
                .toList();

        System.out.println("result1 = " + result1);
        System.out.println("result2 = " + result2);
    }
}
