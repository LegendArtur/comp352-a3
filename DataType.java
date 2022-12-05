public abstract class DataType {

    public abstract DoublyLinkedList allKeys();

    public abstract void add(int ein, String value);

    public abstract void remove(int ein);

    public abstract String getValues(int ein);

    public abstract int nextKey(int ein);

    public abstract int prevKey(int ein);

    public abstract int rangeKey(int ein1, int ein2);
}
