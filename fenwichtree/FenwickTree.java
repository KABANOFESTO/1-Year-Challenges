package fenwichtree;

public class FenwickTree {
    private long[] tree;
 
    public FenwickTree(int size) {
        tree = new long[size + 1];
    }

    public FenwickTree(long[] values){
        if(values == null)
            throw new IllegalArgumentException("Input array cannot be null");
        this.tree = values.clone();
        for(int i = 1; i < tree.length; i++){
            int parent = i + (i & -i);
            if(parent < tree.length)
                tree[parent] += tree[i];
        }
    }

    private int lsb(int index){
        return index & -index;
    } 
 
    private long prefixSum(int index){
        long sum = 0;
        while(index > 0){
            sum += tree[index];
            index -= index & -index; 
        } 
        return sum;
    }  

    public long rangeSum(int left, int right){
        if(left < 1 || right >= tree.length || left > right)
            throw new IllegalArgumentException("Invalid range");
        return prefixSum(right) - prefixSum(left - 1);
    } 
 
    public void add(int index, long value){
        if(index < 1 || index >= tree.length)
            throw new IllegalArgumentException("Index out of bounds");
        while(index < tree.length){
            tree[index] += value;
            index += index & -index;
        }
    } 

    public void set(int index, long value){
        if(index < 1 || index >= tree.length)
            throw new IllegalArgumentException("Index out of bounds");
        long currentValue = rangeSum(index, index);
        long delta = value - currentValue;
        add(index, delta);
    }

    @Override 
    public String toString(){
        return java.util.Arrays.toString(tree);
    }

    public static void main(String[] args) {
        long[] values = {0, 1, 2, 3, 4}; 
        FenwickTree fenwickTree = new FenwickTree(values);
        System.out.println(fenwickTree);
        System.out.println("Range sum (1, 3): " + fenwickTree.rangeSum(1, 3));
        fenwickTree.add(2, 5);
        System.out.println("After adding 5 to index 2: " + fenwickTree);
        fenwickTree.set(3, 10);
        System.out.println("After setting index 3 to 10: " + fenwickTree);
    }
}