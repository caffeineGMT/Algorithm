import java.util.Arrays;

public class ArrayDemo {
    public static void main(String[] args) {
        int[] a = new int[3];
        int[] b = { 10, 20, 30 };
        b[0] = 20;
        System.out.println(a.length);
        System.out.println(Arrays.toString(b));
    }
}