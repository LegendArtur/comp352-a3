// public class DoublyLinkedAVLTree extends DataType {
//     class Node {
//         Node left;
//         Node right;
//         Node parent;

//         Node prev;
//         Node next;

//         int key;
//         String value;
//         int height;

//         Node(int key, String value) {
//             this.key = key;
//             this.value = value;
//             this.height = 1;
//         }

//         Node(int key, String value, Node left, Node right, Node parent) {
//             this.key = key;
//             this.value = value;
//             this.left = left;
//             this.right = right;
//             this.parent = parent;
//             this.height = 1;
//         }
//     }

//     Node root;
//     Node head;
//     Node tail;

//     public DoublyLinkedAVLTree() {
//         root = null;
//         head = null;
//         tail = null;
//     }

//     public void add(int key, String value) {
//         if (root == null) {
//             root = new Node(key, value);
//             head = root;
//             tail = root;
//         } else {
//             Node current = root;
//             while (current != null) {
//                 if (key < current.key) {
//                     if (current.left == null) {
//                         current.left = new Node(key, value, null, null, current);
//                         current.left.prev = head;
//                         head.next = current.left;
//                         head = current.left;

//                         break;
//                     } else {
//                         current = current.left;
//                     }
//                 } else if (key > current.key) {
//                     if (current.right == null) {
//                         current.right = new Node(key, value, null, null, current);
//                         current.right.prev = head;
//                         head.next = current.right;
//                         head = current.right;
//                         break;
//                     } else {
//                         current = current.right;
//                     }
//                 } else {
//                     break;
//                 }
//             }
//         }
//     }

//     private void updateHeight(Node node) {
//         int leftHeight = height(node.left);
//         int rightHeight = height(node.right);
//         node.height = Math.max(leftHeight, rightHeight) + 1;
//     }
    
//     private int height(Node node) {
//         return node != null ? node.height : -1;
//     }

//     private int getBalance(Node node) {
//         return (node == null) ? 0 : height(node.right) - height(node.left);
//     }

//     private Node rotateLeft(Node node) {
//         Node right = node.right;

//         right.parent = node.parent;
//         if (node == root) {
//             root = right;
//         } else {
//             right.parent.left = right;
//         }
//         node.right = right.left;
//         if (node.right != null) {
//             node.right.parent = node;
//         }
//         right.left = node;
//         node.parent = right;
//         updateHeight(node);
//         updateHeight(right);
//         return right;
//     }

//     private Node rotateRight(Node node) {
//         Node left = node.left;

//         left.parent = node.parent;
//         if (node == root) {
//             root = left;
//         }
//         else {
//             left.parent.right = left;
//         }
//         node.left = left.right;
//         if (node.left != null) {
//             node.left.parent = node;
//         }
//         left.right = node;
//         node.parent = left;
//         updateHeight(node);
//         updateHeight(left);
//         return left;
//     }

//     private Node restructure(Node node) {
//         updateHeight(node);
//         int balance = getBalance(node);
//         if (balance > 1) {
//             if (getBalance(node.right) < 0) {
//                 node.right = rotateRight(node.right);
//             }
//             return rotateLeft(node);
//         } else if (balance < -1) {
//             if (getBalance(node.left) > 0) {
//                 node.left = rotateLeft(node.left);
//             }
//             return rotateRight(node);
//         }
//         return node;
//     }

//     private Node add(Node node, int key, String value) {
//         if (node == null) {
//             return new Node(key, value);
//         }
//         if (key < node.key) {
//             node.left = add(node.left, key, value);
//             node.left.parent = node;
//         } else if (key > node.key) {
//             node.right = add(node.right, key, value);
//             node.right.parent = node;
//         } else {
//             node.value = value;
//         }
//         return restructure(node);
//     }

//     private Node remove(Node node, int key) {
//         if (node == null) {
//             return node;
//         } else if (node.key > key) {
//             node.left = remove(node.left, key);
//         } else if (node.key < key) {
//             node.right = remove(node.right, key);
//         } else {
//             if (node.left == null || node.right == null) {
//                 node = (node.left == null) ? node.right : node.left;
//             } else {
//                 Node nextKey = getMostLeftChild(node.right);
//                 node.key = nextKey.key;
//                 node.right = remove(node.right, node.key);
//             }
//         }
//         if (node != null) {
//             node = restructure(node);
//         }
//         return node;
//     }

//     private Node getMostLeftChild(Node node) {
//         while (node.left != null) {
//             node = node.left;
//         }
//         return node;
//     }
// }
