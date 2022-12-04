public class DoubleDoublyLinkedList implements DataType{

    DoublyLinkedList story;
    DoublyLinkedList sortedStory;

    public DoubleDoublyLinkedList() {
        story = new DoublyLinkedList();
        sortedStory = new DoublyLinkedList();
    }

    public DoublyLinkedList allKeys() {
        return sortedStory;
    }

    public void add(int key, String value) {
        story.addUnsorted(key, value);
        sortedStory.addSorted(key, value);
    }

    public void remove(int key) {
        story.remove(key);
        sortedStory.remove(key);
    }

    public String getValues(int key) {
        return sortedStory.getValues(key);
    }

    public int nextKey(int key) {
        return story.nextKey(key);
    }

    public int prevKey(int key) {
        return story.prevKey(key);
    }

    public int rangeKey(int key1, int key2) {
        return story.rangeKey(key1, key2);
    }
}
