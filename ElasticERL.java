import java.util.Random;

public class ElasticERL {
    DataType erl;

    public ElasticERL() {
        erl = null;
    }
    
    public void SetEINTreshhold(int threshold) {
        erl = new DoubleDoublyLinkedList();
    }

    public int generate() {
        Random rand = new Random();
        int number; 
        do {
            number = rand.nextInt(10000000, 100000000);
        } while (numberAlreadyExists(number) || number < 10000000);
        return number;
    }

    private boolean numberAlreadyExists(int number) {
        return (erl.getValues(number)) != null;
    }

    public DoublyLinkedList allKeys() {
        return erl.allKeys();
    }

    public void add(int key, String value) {
        erl.add(key, value);
    }

    public void remove(int key) {
        erl.remove(key);
    }

    public String getValues(int key) {
        return erl.getValues(key);
    }

    public int nextKey(int key) {
        return erl.nextKey(key);
    }

    public int prevKey(int key) {
        return erl.prevKey(key);
    }

    public int rangeKey(int key1, int key2) {
        return erl.rangeKey(key1, key2);
    }

    public String toString() {
        return erl.toString();
    }

}
