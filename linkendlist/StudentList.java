package linkendlist;
import java.util.*;

public class StudentList {
    public static void students(String[] names){
        LinkedList<String> students = new LinkedList<>();
        
        for (String name : names) {
            students.add(name);
        }
    }
    public static void main(String[] args) {
        String[] names = {"kabano", "keza", "Crepine","kabano", "keza", "Crepine"};
        students(names);
        for (String name : names) {
            System.out.println(name);
        }
    }
}
