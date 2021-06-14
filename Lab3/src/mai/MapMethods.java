package mai;

import mai.interfaces.Map;
import java.util.Objects;

public class MapMethods implements Map {

    public static class Node {
        String key;
        Integer value;
        int hash;
        Node next;

        public Node(int hash, String key, int value) {
        this.hash = hash;
        this.key = key;
        this.value = value;
        Node next;
        }

    }

    private static final double LOAD_FACTOR = 0.75;
    private final double loadFactor;
    private static final int DEFAULT_SIZE = 5;
    Node[] nodeBasket;
    int basketNumbers = 0;
    int elementsNumber = 0;

    public int hashCalc(String key) {
        int hashCode = 0;
        if (key != null) {
            for (int i = 0; i < key.length(); ++i) {
                hashCode += (int) (key.charAt(i));
            }
        }
        return hashCode;
    }

    private Node[] resize() {
        Node[] prevBasket = nodeBasket;
        basketNumbers *= 2;
        Node[] newBasket = new Node[basketNumbers];

        for (int i = 0; i < prevBasket.length; i++) {
            if (prevBasket[i] != null) {
                Node currentNode = prevBasket[i];
                do {
                    if (newBasket[currentNode.hash % newBasket.length] == null) {
                        newBasket[currentNode.hash % newBasket.length] = new Node(currentNode.hash, currentNode.key, currentNode.value);
                    } else {
                        Node nodeBuffer = newBasket[currentNode.hash % newBasket.length];
                        do {
                            if (nodeBuffer.next == null) {
                                nodeBuffer.next = new Node(currentNode.hash, currentNode.key, currentNode.value);
                                break;
                            }
                            nodeBuffer = nodeBuffer.next;
                        } while (nodeBuffer != null);
                    }
                    currentNode = currentNode.next;
                } while (currentNode != null);
            }
        }
        return newBasket;
    }

    public MapMethods(int basketNumbers, double loadFactor) {
        if (basketNumbers < 1 || loadFactor > 1 || loadFactor <= 0) {
            throw new IllegalArgumentException("illegal arguments");
        } else {
            this.basketNumbers = basketNumbers;
            nodeBasket = new Node[basketNumbers];
            this.loadFactor = loadFactor;
            elementsNumber = 0;
        }
    }

    public MapMethods() {
        this(DEFAULT_SIZE, LOAD_FACTOR);
    }

    public int size() {
        return elementsNumber;
    }

    public boolean isEmpty() {
        return elementsNumber == 0;
    }

    public boolean containsKey(String key) {
        int hash = hashCalc(key);
        if (nodeBasket[hash % basketNumbers] != null) {
            Node currentNode = nodeBasket[hash % basketNumbers];
            while (currentNode != null) {
                if (Objects.equals(currentNode.key, key)) {
                    return true;
                }
                currentNode = currentNode.next;
            }
        }
        return false;
    }

    public boolean containsValue(Integer value) {
        if (this.isEmpty()) {
            return false;
        }
        for (Node currentNode : nodeBasket) {
            if (currentNode != null) {
                do {
                    if (Objects.equals(currentNode.value, value)) {
                        return true;
                    }
                    currentNode = currentNode.next;
                } while (currentNode != null);
            }
        }
        return false;
    }

    public Integer get(String key) {

        int hash = hashCalc(key);
        if (nodeBasket[hash % nodeBasket.length] == null) {
            return null;
        }
        Node currentNode = nodeBasket[hash % nodeBasket.length];
        while (currentNode != null) {
            if (Objects.equals(currentNode.key, key)) {
                return currentNode.value;
            }
            currentNode = currentNode.next;
        }
        return null;
    }

    public Integer put(String key, Integer value) {
        int hash = hashCalc(key);
        if (nodeBasket[hash % basketNumbers] != null) {
            Node currentNode = nodeBasket[hash % basketNumbers];
            do {
                if (Objects.equals(currentNode.key, key)) {
                    int buffer = currentNode.value;
                    currentNode.value = value;
                    return buffer;
                }
                if (currentNode.next == null) {
                    Node nextNode = new Node(hash, key, value);
                    currentNode.next = nextNode;
                    elementsNumber++;
                    break;
                }
                currentNode = currentNode.next;
            } while (currentNode != null);
        } else {
            Node newNode = new Node(hash, key, value);
            newNode.next = null;
            elementsNumber++;
            nodeBasket[hash % basketNumbers] = newNode;
        }
        if (elementsNumber >= basketNumbers * loadFactor) {
            nodeBasket = resize();
        }
        return null;
    }

    public Integer remove(String key) {
        int hash = hashCalc(key);
        if (nodeBasket[hash % basketNumbers] != null) {
            Node currentNode = nodeBasket[hash % nodeBasket.length];
            Node bufferNode = null;
            while (currentNode != null) {
                if (Objects.equals(currentNode.key, key)) {
                    Integer returnInt = currentNode.value;
                    if (bufferNode == null) {
                        nodeBasket[hash % basketNumbers] = currentNode.next;
                    } else {
                        bufferNode.next = currentNode.next;
                    }
                    --elementsNumber;
                    return returnInt;
                }
                bufferNode = currentNode;
                currentNode = currentNode.next;
            }
        }
        return null;
    }

    public void putAll(Map map) {
        if (map != null) {

            MapMethods secondMap = (MapMethods) map;
            for (Node node : secondMap.nodeBasket) {
                if (node != null) {
                    do {
                        put(node.key, node.value);
                        node = node.next;
                    } while (node != null);
                }
            }
        }
    }

    public void clear() {
        elementsNumber = 0;
        basketNumbers = DEFAULT_SIZE;
        nodeBasket = new Node[DEFAULT_SIZE];
    }
}
