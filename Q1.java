import java.util.ArrayList;
public class Q1 {
    public static void main(String[] args) {
        ArrayList<String> list=new ArrayList<String>();
        list.add("Mamta");
        list.add("Gaurav");
        list.add("Gauri");
        list.add("Harshal");

        System.out.println(list);

        System.out.println("Printing arraylist by For-each loop");

        for(String s:list)
        {
            System.out.println(s);
        }
    }
}
