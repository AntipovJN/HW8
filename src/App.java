import java.util.ArrayList;

public class App {

    public static void main(String[] args) {
       OwnArrayList<String> list = new OwnArrayList<>();
        list.add("1");
        list.add("2");
        list.add("3");
        list.add("4");
        System.out.println(list.isEmpty());
        System.out.println(list.toString());
        System.out.println(list.remove("4"));
        System.out.println(list.toString());
        list.add("5",2);
        System.out.println(list.toString());
    }
}
