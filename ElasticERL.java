import java.util.Random;

public class ElasticERL {
    // A variable that is used to store the data structure that is used to store the data.
    DataType erl;

    public ElasticERL() {
        erl = null;
    }
    
    /**
     * If the threshold is less than 50000, then the erl is a doubly linked list, otherwise it's a
     * doubly linked AVL tree
     * 
     * @param threshold the threshold value for the number of elements in the list
     */
    public void SetEINTreshhold(int threshold) {
        if (threshold < 50000) {
            erl = new DoublyLinkedList();
        } else {
            erl = new DoublyLinkedAVLTree();
        }
        
        
    }
    
    /**
     * Generate a random number between 10000000 and 100000000, and if the number already exists in the
     * database, or if the number is less than 10000000, then generate another number
     * 
     * @return A random number between 10000000 and 100000000.
     */
    public int generate() {
        Random rand = new Random();
        int number; 
        do {
            number = rand.nextInt(10000000, 100000000);
        } while (numberAlreadyExists(number) || number < 10000000);
        return number;
    }

    // Checking if the number already exists in the database.
    private boolean numberAlreadyExists(int number) {
        return (erl.getValues(number)) != null;
    }

    /**
     * This function returns a doubly linked list of all the keys in the hash table
     * 
     * @return The keys of the entries in the hash table.
     */
    public DoublyLinkedList allKeys() {
        return erl.allKeys();
    }

    /**
     * The function takes in a key and a value, and adds the key and value to the end of the list
     * 
     * @param key The key to be added to the hash table.
     * @param value The value to be added to the list.
     */
    public void add(int key, String value) {
        erl.add(key, value);
        
    }

    /**
     * It adds a value to the erl.
     * 
     * @param value The value to be added to the erl.
     */
    public void add(String value) {
        erl.add(generate(), value);
    }

    
    /**
     * It removes the key from the erl.
     * 
     * @param key The key of the element to be removed.
     */
    public void remove(int key) {
        erl.remove(key);
    }

    /**
     * The function takes an integer as an argument and returns a string
     * 
     * @param key The key to search for
     * @return The value of the key.
     */
    public String getValues(int key) {
        return erl.getValues(key);
    }

    /**
     * > Given a key, return the next key in the map
     * 
     * @param key the key to search for
     * @return The next key in the map.
     */
    public int nextKey(int key) {
        return erl.nextKey(key);
    }

    /**
     * It returns the previous key in the map.
     * 
     * @param key the key to search for
     * @return The key of the previous node.
     */
    public int prevKey(int key) {
        return erl.prevKey(key);
    }

    // Returning the range of keys between key1 and key2.
    public int rangeKey(int key1, int key2) {
        return erl.rangeKey(key1, key2);
    }

    /**
     * The function printContents() is a public function that takes no parameters and returns nothing.
     * It calls the printContents() function from the erl object
     */
    public void printContents() {
        erl.printContents();
    }

}
