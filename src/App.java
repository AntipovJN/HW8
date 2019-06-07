import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
       OwnArrayList<String> list = new OwnArrayList<>();
        list.add("first");
        list.add("second  for remove");
        list.add("second string for remove");
        System.out.println(list.isEmpty());
        System.out.println(list.toString());
        System.out.println(list.remove("first"));
        System.out.println(list.toString());
        System.out.println(list.remove(1) + list.remove(0));
        System.out.println(list.toString());
        System.out.println(list.isEmpty());
    }
}
