/**
 * A node in the AVL tree is a key-value pair, where the key is an integer and the value is a string
 */
class Node {
    int key, height;
    Node left, right, next, prev;
    String value;

    Node(int k, String v) {
        key = k;
        value = v;
        height = 1;
    }
}

/**
 * This class implements a doubly linked AVL tree with a root node, a recent node, and an oldest node
 */
class DoublyLinkedAVLTree extends DataType {
    int length;

    Node root;
    Node recent;
    Node oldest;

    public DoublyLinkedAVLTree() {
        root = null;
        recent = null;
        oldest = null;
    }

    private int height(Node N) {
        if (N == null)
            return 0;
        return N.height;
    }

    private int max(int a, int b) {
        return (a > b) ? a : b;
    }

    private Node rightRotate(Node node1) {
        Node leftNode = node1.left;
        Node x = leftNode.right;

        leftNode.right = node1;
        node1.left = x;

        node1.height = max(height(node1.left), height(node1.right)) + 1;
        leftNode.height = max(height(leftNode.left), height(leftNode.right)) + 1;

        return leftNode;
    }

    private Node leftRotate(Node node) {
        Node rightNode = node.right;
        Node x = rightNode.left;

        rightNode.left = node;
        node.right = x;

        node.height = max(height(node.left), height(node.right)) + 1;
        rightNode.height = max(height(rightNode.left), height(rightNode.right)) + 1;

        return rightNode;
    }

    private int getBalance(Node N) {
        if (N == null)
            return 0;
        return height(N.left) - height(N.right);
    }

    private Node insert(Node node, int key, String value) {
        if (node == null) {
            Node newNode = new Node(key, value);
            if (recent == null) {
                recent = newNode;
                oldest = newNode;
            } else {
                recent.prev = newNode;
                newNode.next = recent;
                recent = newNode;
            }

            return newNode;
        }

        if (key < node.key)
            node.left = insert(node.left, key, value);
        else if (key > node.key)
            node.right = insert(node.right, key, value);
        else 
            return node;

        node.height = 1 + max(height(node.left),height(node.right));

        int balance = getBalance(node);

        if (balance > 1 && key < node.left.key)
            return rightRotate(node);

        if (balance < -1 && key > node.right.key)
            return leftRotate(node);

        if (balance > 1 && key > node.left.key) {
            node.left = leftRotate(node.left);
            return rightRotate(node);
        }

        if (balance < -1 && key < node.right.key) {
            node.right = rightRotate(node.right);
            return leftRotate(node);
        }

        return node;
    }

    
    private Node findMostLeftNode(Node node) {
        Node current = node;

        while (current.left != null)
        current = current.left;
        
        return current;
    }
    
    private Node deleteNode(Node root, int key) {
        if (root == null)
        return root;
        
        if (key < root.key)
        root.left = deleteNode(root.left, key);
        else if (key > root.key)
        root.right = deleteNode(root.right, key);
        else {
            if (root.prev != null) {
                root.prev.next = root.next;
            } else {
                oldest = root.next;
            }
            if (root.next != null) {
                root.next.prev = root.prev;
            } else {
                recent = root.prev;
            }
            if ((root.left == null) || (root.right == null)) {
                Node temp = null;
                if (temp == root.left)
                temp = root.right;
                else
                temp = root.left;
                
                if (temp == null) {
                    temp = root;
                    root = null;
                } else 
                root = temp;
            } else {
                
                Node temp = findMostLeftNode(root.right);
                
                root.key = temp.key;
                root.value = temp.value;
                root.next = temp.next;
                root.prev = temp.prev;
                root.prev.next = root;
                root.next.prev = root;
                
                root.right = deleteNode(root.right, temp.key);
            }
        }
        
        if (root == null)
        return root;
        
        root.height = max(height(root.left), height(root.right)) + 1;
        
        int balance = getBalance(root);
        
        
        // Left Left Case
        if (balance > 1 && getBalance(root.left) >= 0)
        return rightRotate(root);
        
        // Left Right Case
        if (balance > 1 && getBalance(root.left) < 0) {
            root.left = leftRotate(root.left);
            return rightRotate(root);
        }
        
        // Right Right Case
        if (balance < -1 && getBalance(root.right) <= 0)
        return leftRotate(root);

        // Right Left Case
        if (balance < -1 && getBalance(root.right) > 0) {
            root.right = rightRotate(root.right);
            return leftRotate(root);
        }
        
        return root;
    }
    
    private Node search(int key) {
        Node current = root;
        while (current != null) {
            if (current.key == key) {
                break;
            }
            current = current.key < key ? current.right : current.left;
        }
        return current;
    }

    public void add(int key, String value) {
        if (search(key) != null) {
            return;
        }
        root = insert(root, key, value);
        length++;
    }

    public void remove(int key) {
        root = deleteNode(root, key);
        length--;
    }

    public String getValues(int key) {
        Node node = search(key);
        return node == null ? null : node.value;
    }

    public int nextKey(int key) {
        Node node = search(key);
        if (node == null) {
            System.out.println(key + " doesn't exist");
            return -1;
        }
        return node.next == null ? null : node.next.key;
    }

    public int prevKey(int key) {
        Node node = search(key);
        if (node == null) {
            System.out.println(key + " doesn't exist");
            return -1;
        }
        return node.prev == null ? null : node.prev.key;
    }

    public int rangeKey(int key1, int key2) {
        Node node = search(key1);
        int count = 0;
        while (node != null && node.key != key2) {
            count++;
            node = node.next;
        }
        return count;
    }

    public DoublyLinkedList allKeys() {
        DoublyLinkedList list = new DoublyLinkedList();
        reverseInOrder(root, list);
        return list;
    }

    private void reverseInOrder(Node node, DoublyLinkedList list) {
        if (node != null) {
            reverseInOrder(node.right, list);
            list.addSorted(node.key, node.value);
            reverseInOrder(node.left, list);
        }
    }

    public String toString() {
        String str = "";
        Node current = recent;
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
            current = oldest;
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

    public int getLength() {
        return length;
    }

    public void printContents() {
        System.out.println(this);
    }
}