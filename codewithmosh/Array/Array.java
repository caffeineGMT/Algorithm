import java.util.NoSuchElementException;

public class Array {
    private int[] arr;
    private int count;

    public Array(int length) {
        arr = new int[length];
        count = 0;
    }

    public void insert(int item) {

        if (count == arr.length) {
            int[] temp = new int[arr.length * 2];
            for (int i = 0; i < count; i++)
                temp[i] = arr[i];
            arr = temp;
        }
        arr[count] = item;
        count++;
    }

    public void print() {
        for (int i = 0; i < count; i++) {
            System.err.println(arr[i]);
        }
    }

    public void removeAt(int index) {
        // check edge condition
        if (index < 0 || index >= count)
            throw new IllegalArgumentException();
        // create a new copy, copy left, copy right
        int[] temp = new int[arr.length];
        for (int i = 0; i < index; i++) {
            temp[i] = arr[i];
        }
        for (int i = index + 1; i < count; i++) {
            temp[i - 1] = arr[i];
        }
        arr = temp;
        count--;

        // another solution
        // if (index < 0 || index >= count)
        // throw new IllegalArgumentException();
        // // shift the list to left
        // for (int i = index; i < count; i++)
        // arr[i] = arr[i + 1];// this might cause out of bound exception
        // count--;
    }

    public int indexOf(int item) {
        for (int i = 0; i < count; i++) {
            if (arr[i] == item)
                return i;
        }
        return -1;
    }

    public int max() {
        if (count == 0)
            throw new NoSuchElementException();
        int max = arr[0];
        for (int item : arr) {
            if (item > max)
                max = item;
        }
        return max;
    }

    public Array intersect(Array other) {
        if (this.count == 0 || other.count == 0)
            throw new NoSuchElementException();
        if (this.count < other.count) {
            Array repo = new Array(this.count);
            for (int item : this.arr)
                if (other.contain(item))
                    repo.insert(item);
            return repo;
        } else {
            Array repo = new Array(other.count);
            for (int item : other.arr)
                if (this.contain(item))
                    repo.insert(item);
            return repo;
        }
    }

    public boolean contain(int target) {
        for (int i = 0; i < count; i++) {
            if (arr[i] == target)
                return true;
        }
        return false;
    }

    public Array reverse() {
        if (count == 0)
            throw new NoSuchElementException();
        for (int i = 0; i < count / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[count - i - 1];
            arr[count - i - 1] = temp;
        }
        return this;
    }

    public void insertAt(int item, int index) {
        // check if input is validate
        if (index < 0 || index > count)
            throw new IllegalArgumentException();
        // check if array is about to full, if so, resize the array first
        if (count == arr.length) {
            int[] temp = new int[arr.length * 2];
            for (int i = 0; i < count; i++)
                temp[i] = arr[i];
            arr = temp;
        }

        // arr[i]=arr[i-1]
        for (int i = count; i > index; i--) {
            arr[i] = arr[i - 1];
        }

        // add the item at target index
        arr[index] = item;
        count++;
    }

    public static void main(String[] args) {
        var test = new Array(10);
        test.insert(10);
        test.insert(20);
        test.insert(30);
        test.insert(40);
        test.insert(50);
        test.reverse();
        test.print();
        // System.out.println(test.intersect(b).print());
    }

}