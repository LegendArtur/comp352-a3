/**
 * > This class is an abstract class that represents a data type
 */
public abstract class DataType {

    /**
     * Returns a list of all the keys in the dictionary.
     * 
     * @return A DoublyLinkedList of all the keys in the HashTable.
     */
    public abstract DoublyLinkedList allKeys();

    /**
     * This function adds a value to the list at the specified index.
     * 
     * @param ein   The EIN of the organization.
     * @param value The value to be added to the list.
     */
    public abstract void add(int ein, String value);

    /**
     * Remove the element at index ein.
     * 
     * @param ein The EIN of the organization to be removed.
     */
    public abstract void remove(int ein);

    /**
     * > This function returns a string of values for a given entity
     * 
     * @param ein The EIN of the organization you want to get information about.
     * @return The values of the variables in the class.
     */
    public abstract String getValues(int ein);

    /**
     * Return the next key in the dt after the given key, or -1 if there is no such
     * key.
     * 
     * @param ein The key to start searching from.
     * @return The next key in the list.
     */
    public abstract int nextKey(int ein);

    /**
     * "Return the key of the entry immediately before the entry with key ein, or -1
     * if there is no
     * such entry."
     * 
     * @param ein The key to search for.
     * @return The key of the previous element in the list.
     */
    public abstract int prevKey(int ein);

    /**
     * > The function `rangeKey` takes two integers, `ein1` and `ein2`, and returns
     * an integer
     * 
     * @param ein1 The first EIN to compare.
     * @param ein2 The second ein to be compared.
     * @return The rangeKey method is returning the value of the rangeKey variable.
     */
    public abstract int rangeKey(int ein1, int ein2);

    /**
     * PrintContents() prints the contents of the object.
     */
    public abstract void printContents();
}
