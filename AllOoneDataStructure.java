class Node {
    int count;
    HashSet<String> keys;
    Node prev;
    Node next;

    public Node(int count) {
        this.count = count;
        this.keys = new HashSet<>();
    }
}

class AllOne {
    private HashMap<String, Integer> keyCount;
    private HashMap<Integer, Node> countNode;
    private Node head;
    private Node tail;

    /** Initialize your data structure here. */
    public AllOne() {
        keyCount = new HashMap<>();
        countNode = new HashMap<>();
        head = new Node(Integer.MIN_VALUE); // Dummy head
        tail = new Node(Integer.MAX_VALUE); // Dummy tail
        head.next = tail;
        tail.prev = head;
    }

    private void insertNode(Node newNode, Node prevNode) {
        newNode.prev = prevNode;
        newNode.next = prevNode.next;
        prevNode.next.prev = newNode;
        prevNode.next = newNode;
        countNode.put(newNode.count, newNode);
    }

    private void removeNode(Node node) {
        countNode.remove(node.count);
        node.prev.next = node.next;
        node.next.prev = node.prev;
    }

    public void inc(String key) {
        int newCount = keyCount.getOrDefault(key, 0) + 1;
        keyCount.put(key, newCount);
        
        Node currentNode = countNode.get(newCount - 1);
        if (currentNode != null) {
            currentNode.keys.remove(key);
            if (currentNode.keys.isEmpty()) {
                removeNode(currentNode);
            }
        }

        Node nextNode = countNode.get(newCount);
        if (nextNode == null) {
            nextNode = new Node(newCount);
            insertNode(nextNode, head);
        }
        nextNode.keys.add(key);
    }

    public void dec(String key) {
        int newCount = keyCount.get(key) - 1;
        keyCount.put(key, newCount);
        
        Node currentNode = countNode.get(newCount + 1);
        currentNode.keys.remove(key);
        if (currentNode.keys.isEmpty()) {
            removeNode(currentNode);
        }

        if (newCount == 0) {
            keyCount.remove(key);
        } else {
            Node prevNode = countNode.get(newCount);
            if (prevNode == null) {
                prevNode = new Node(newCount);
                insertNode(prevNode, head);
            }
            prevNode.keys.add(key);
        }
    }

    public String getMaxKey() {
        return tail.prev == head ? "" : (String) tail.prev.keys.iterator().next();
    }

    public String getMinKey() {
        return head.next == tail ? "" : (String) head.next.keys.iterator().next();
    }
}