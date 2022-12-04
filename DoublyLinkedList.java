public class DoublyLinkedList {
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
        if (head == null) {
            head = new Node(key, value);
            tail = head;
        } else {
            Node current = head;
            while (current != null) {
                if (key < current.key) {
                    if (current.prev == null) {
                        current.prev = new Node(key, value);
                        current.prev.next = current;
                        head = current.prev;
                        break;
                    } else {
                        current = current.prev;
                    }
                } else if (key > current.key) {
                    if (current.next == null) {
                        current.next = new Node(key, value);
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

    public void addUnsorted(int key, String value) {
        Node node = new Node(key, value);
        if (head == null) {
            head = node;
            //System.out.println("test1");
            tail = head;
            //System.out.println("test2");
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
        if (key1 > key2) {
            return 0;
        }
        int num = 0;
        Node current = head;
        while (current != null) {
            if (key1 <= current.key && current.key <= key2) {
                num += 1;
            }
            current = current.next;
        }

        return num;
    }

    @Override
    public String toString() {
        String str = "";
        Node current = head;
        while (current != null) {
            str += current.key + " - " + current.value + "\n";
        }
        return str;
    }
    
}