public interface DataType {

    public DoublyLinkedList allKeys();

    public void add(int ein, String value);

    public void remove(int ein);

    public String getValues(int ein);

    public int nextKey(int ein);

    public int prevKey(int ein);

    public int rangeKey(int ein1, int ein2);
}
