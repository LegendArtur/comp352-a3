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
        } while (numberAlreadyExists(number));
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

    public void add(String value) {
        erl.add(generate(), value);
    }

    public void remove(ElasticERL erl, String key) {
    }

    public int[] getValues(ElasticERL erl, String key) {
        return null;
    }

    public void nextKey(ElasticERL erl, String key) {
    }

    public void prevKey(ElasticERL erl, String key) {
    }

    public void rangeKey(String key1, String key2) {
    }

}
