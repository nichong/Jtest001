package com.wh.test.labda.test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Labda001 {
    public static void main(String[] args) {
        // System.out.println(getInt());
        t1();
    }

    public static void t2(){

    }

    public static Integer getInt() {
        Integer a = 5;
        Integer b = 6;
        Integer c = usrFi(a, b, (e, d) -> e + d);
        System.out.println(c);
        return c;
    }

    public static Integer usrFi(int a, int b, LabdaI labdaI) {
        Integer c = labdaI.dis(a, b);
        return c;
    }

    public static void t1() {
        List<Integer> nums = Arrays.asList(1, 2, 3, 4);
        // nums.stream().map(a->{if(a == 3){a = a+10}}).collect(Collectors.toList()).forEach(System.out::print);
        nums.stream().forEach(a -> {
                    if (a == 3) {
                        a = a + 10;
                        a = a * 2;
                    }
                    System.out.println(a);
                }
        );
        System.out.println("---------------");
       //flatMap就是将最底层元素抽出来放到一起  ,这里多个list合并了
        Stream<List<Integer>> inputStream = Stream.of(
                Arrays.asList(1),
                Arrays.asList(2, 3),
                Arrays.asList(4, 5, 6)

        );
        inputStream.
                flatMap((childList) -> childList.stream()).forEach(x -> System.out.println(x));
        System.out.println("+++++++++++++++");

        //peek可以拿到每个中间步骤  peek 对每个元素执行操作并返回一个新的 Stream
        Stream.of("one", "two", "three", "four")
                .filter(e -> e.length() > 3)
                .peek(e -> System.out.println("Filtered value: " + e))
                .map(String::toUpperCase)
                .peek(e -> System.out.println("Mapped value: " + e))
                .collect(Collectors.toList()).forEach(s-> System.out.println(s));

        System.out.println(")))))))))))))");

        //缩小范围   max min reduce（可以将流中元素反复结合起来，得到一个值）
        // 求和，sumValue = 10, 无起始值
        Integer sumValue = Stream.of(1, 2, 3, 4).map(t1->t1=t1+5).reduce(Integer::sum).get();
        System.out.println(sumValue);

        //skip limit
        System.out.println("<<<<<<<<<<<<<<<<<");
        List<Person> persons = new ArrayList();
        for (int i = 1; i <= 10000; i++) {
            Person person = new Person(i, "name" + i);
            persons.add(person);
        }

        List<String> personList2 = persons.stream().
                map(Person::getName).limit(10).skip(3).collect(Collectors.toList());
        System.out.println(personList2);
    }
    static  class Person {
        public int no;
        private String name;
        public Person (int no, String name) {
            this.no = no;
            this.name = name;
        }
        public String getName() {
            System.out.println(name);
            return name;
        }
    }
}


