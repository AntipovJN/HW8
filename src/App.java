import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
       ownArrayList<String> list = new ownArrayList<>();
        list.add("first");
        list.add("second  for remove");
        list.add("second string for remove");
        list.add("second string for remove");
        System.out.println(list.isEmpty());
        System.out.println(list.toString());
        System.out.println(list.remove("first"));
        System.out.println(list.toString());
        System.out.println(list.remove(0));
        System.out.println(list.toString());
        System.out.println(list.isEmpty());
    }
}
