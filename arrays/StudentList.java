package arrays;
import java.util.ArrayList;

public class StudentList {
    public static void StudentsNames(String[] names){
        ArrayList<String> students = new ArrayList<>();
        for (String name : names) {
            students.add(name);
        }
    }
    public static void main(String[] args) {
        String[] names = {"kabano", "keza", "Crepine","kabano", "keza", "Crepine"};
        StudentsNames(names);
        for (String name : names) {
            System.out.println(name);
        }
    }
}
