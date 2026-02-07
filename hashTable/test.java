package hashTable;

import java.util.Hashtable;

public class test {
    public static void main(String[] args) {
        Hashtable<Integer, String> table = new Hashtable<>(10, 0.5f);

        table.put(100, "kabano");
        table.put(123, "keza");
        table.put(321, "rocky");
        table.put(555, "diane");
        table.put(777, "atasa");

        for (Integer key : table.keySet()) {
            System.out.println(key.hashCode() % 10 + "\t" + key + "\t" + table.get(key));
        }
    }

}
