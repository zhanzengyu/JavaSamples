import zzy.Collections;

import java.util.ArrayList;
import java.util.LinkedList;

class User {
    public User(int age, String name) {
        this.age = age;
        this.name = name;
    }

    int age;
    String name;

    @Override
    public String toString() {
        return "User{" +
                "age=" + age +
                ", name='" + name + '\'' +
                '}';
    }
}
public class Main {
    public static void main(String[] args) {
        testRandomElementExceptSelf();
//        testArrayCopy();
    }

    private static void testArrayCopy() {
        ArrayList<User> srcList = new ArrayList<>();
        srcList.add(new User(1, "1"));
        srcList.add(new User(2, "2"));
        srcList.add(new User(3, "3"));
        ArrayList<User> dstList = new ArrayList<>(srcList);
        System.out.println(srcList);
        System.out.println(dstList);
//        dstList.remove(0);
//        dstList.set(0, "change");
//        srcList.set(0, new User(9, "9"));
        dstList.remove(0);
        System.out.println("----------after-----------");
        System.out.println(srcList);
        System.out.println(dstList);
    }

    private static void testRandomElementExceptSelf() {
        ArrayList<String> arrayList = new ArrayList<>();
        arrayList.add("Sunday");
        arrayList.add("Monday");
        arrayList.add("Tuesday");
        arrayList.add("Wednesday");
        arrayList.add("Thursday");
        arrayList.add("Friday");
        arrayList.add("Saturday");
        String result = "Monday";
        for (int i = 0; i < 10; i++) {
            result = Collections.randomElementExceptSelf(arrayList, result);
            System.out.println(result);
        }

        LinkedList<Integer> list = new LinkedList<>();
        for (int i = 0; i < 50; i++) {
            list.add(i);
        }
        int resultInt = 12;
        for (int i = 0; i < 10; i++) {
            resultInt = Collections.randomElementExceptSelf(list, resultInt);
            System.out.println(resultInt);
        }
    }
}