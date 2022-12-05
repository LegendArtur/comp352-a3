/**
 * The DoublyLinkedList class is a doubly linked list that stores key-value pairs
 */
public class DoublyLinkedList extends DataType{
    public class Node {
        Node prev;
        Node next;
        int key;
        String value;

        Node(int key, String value) {
            this.key = key;
            this.value = value;
        }
    }

    Node head;
    Node tail;
    int length;

    public DoublyLinkedList() {
        head = null;
        tail = null;
    }

    public void addSorted(int key, String value) {
        Node node = new Node(key, value);
        if (head == null) {
            head = node;
            tail = head;
        } else {
            Node current = head;
            while (current != null) {
                if (key < current.key) {
                    if (current.prev == null) {
                        current.prev = node;
                        current.prev.next = current;
                        head = current.prev;
                        break;
                    } else {
                        node.prev = current.prev;
                        node.next = current;
                        node.prev.next = node;
                        current.prev = node;
                        break;
                    }
                } else if (key > current.key) {
                    if (current.next == null) {
                        current.next = node;
                        current.next.prev = current;
                        tail = current.next;
                        break;
                    } else {
                        current = current.next;
                    }
                } else {
                    current.value = value;
                    break;
                }
            }
        }
        length++;
    }

    public void add(int key, String value) {
        if (search(key) != null) {
            return;
        }
        Node node = new Node(key, value);
        if (head == null) {
            head = node;
            tail = head;
        } else {
            node.next = head;
            head.prev = node;
            head = node;
        }
        length++;
    }

    public void remove(int key) {
        Node current = head;
        while (current != null) {
            if (key == current.key) {
                if (current.prev == null) {
                    head = current.next;
                    if (head != null) {
                        head.prev = null;
                    }
                } else if (current.next == null) {
                    tail = current.prev;
                    if (tail != null) {
                        tail.next = null;
                    }
                } else {
                    current.prev.next = current.next;
                    current.next.prev = current.prev;
                }
                break;
            } else {
                current = current.next;
            }
        }
        length--;
    }

    public Node search(int key) {
        Node current = head;
        while (current != null) {
            if (key == current.key) {
                return current;
            } else {
                current = current.next;
            }
        }
        return null;

    }

    public String getValues(int key) {
        Node node = search(key);
        return (node != null) ? node.value : null;
    }

    public int nextKey(int key) {
        Node node = search(key);
        if (node != null) {
            if (node.next != null) {
                return node.next.key;
            }
        }
        return -1;
    }

    public int prevKey(int key) {
        Node node = search(key);
        if (node != null) {
            if (node.prev != null) {
                return node.prev.key;
            }
        }
        return -1;
    }

    public int rangeKey(int key1, int key2) {
        
        int num = 0;
        int flag = 0;
        Node current = head;
        while (current != null) {
            if (key1 == current.key) {
                flag = 1;
            }
            else if (flag == 1) {
                if (key2 == current.key){
                    return num;
                }
                num++;
            }
            current = current.next;
        }
        return (current == null) ? 0 : num;
    }

    public DoublyLinkedList allKeys() {
        DoublyLinkedList list = new DoublyLinkedList();
        Node current = head;
        while (current != null) {
            list.addSorted(current.key, current.value);
            current = current.next;
        }
        return list;
    }

    public String toString() {
        String str = "";
        Node current = head;
        if (length < 7) {
            while (current != null) {
                str += String.format("%08d", current.key) + "-" + current.value + " -> ";
                current = current.next;
            }
        } else {
            for (int i = 0; i < 3; i++) {
                str += String.format("%08d", current.key) + "-" + current.value + " -> ";
                current = current.next;
            }
            str += " ... " + (length - 6) + " Hidden Nodes ... -> ";
            current = tail;
            for (int i = 0; i < 3; i++) {
                current = current.prev;
            }
            for (int i = 0; i < 3; i++) {
                str += String.format("%08d", current.key) + "-" + current.value + " -> ";
                current = current.next;
            }
        }
        return str;
    }

    public void printContents() {
        System.out.println(this);
    }

    public int getLength() {
        return length;
    }
}