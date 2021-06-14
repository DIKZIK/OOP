package ru.mai;

import java.util.Objects;

import java.util.HashSet;

public class MapMethods<T, V> {

    public static class Node<T, V> {

        private T key;
        private V value;
        private int hash;
        private Node<T, V> next;

    }

    public int hashCalc(T key) {

        return Objects.hashCode(key);
    }

    public static final int DEFAULT_SIZE = 5;

    HashSet<Node<T, V>> nodes = new HashSet<>();
    Node<T, V>[] nodeBasket;
    int basketNumbers = 0;
    int elementsNumber = 0;


    @SuppressWarnings("unchecked")
    public MapMethods(int basketNumbers) {

        if (basketNumbers < 1) {

            nodeBasket = new Node[DEFAULT_SIZE];
            basketNumbers = DEFAULT_SIZE;
        } else {

            this.basketNumbers = basketNumbers;
            nodeBasket = new Node[basketNumbers];
        }
    }

    public MapMethods() {

        this(DEFAULT_SIZE);
    }

    public int size() {

        return elementsNumber;
    }


    public boolean isEmpty() {

        return elementsNumber == 0;
    }

    public boolean containsKey(T key) {

        int hash = hashCalc(key);
        if (nodeBasket[hash % basketNumbers] != null) {

            Node<T, V> currentNode = nodeBasket[hash % basketNumbers];
            while (currentNode != null) {

                if (currentNode.key.equals(key)) {

                    return true;
                }
                currentNode = currentNode.next;
            }
        }
        return false;
    }

    public boolean containsValue(V value) {

        for (Node<T, V> currentNode : nodeBasket) {

            if (currentNode != null) {
                do {

                    if (currentNode.value.equals(value)) {

                        return true;
                    }

                    currentNode = currentNode.next;
                } while (currentNode != null);
            }
        }
        return false;
    }

    public V get(T key) {

        if (key != null) {
            for (Node<T, V> node : nodeBasket) {

                if (node != null && node.key.equals(key)) {

                    return node.value;
                }
            }
        }

        return null;
    }


    @SuppressWarnings("unchecked")
    public V put(T key, V value) {

        int hash = hashCalc(key);

        if (nodeBasket[hash % basketNumbers] != null) {

            Node<T, V> currentNode = nodeBasket[hash % basketNumbers];
            do {
                if (currentNode.key.equals(key)) {

                    V buffer = currentNode.value;
                    currentNode.value = value;
                    return buffer;
                }
                if (currentNode.next == null) {

                    Node<T, V> nextNode = new Node<>();
                    nextNode.value = value;
                    nextNode.key = key;
                    nextNode.hash = hash;
                    currentNode.next = nextNode;
                    elementsNumber++;
                }

                currentNode = currentNode.next;

            } while (currentNode.next != null);
        } else {

            Node<T, V> newNode = new Node<>();
            newNode.key = key;
            newNode.value = value;
            newNode.hash = hash;
            newNode.next = null;
            elementsNumber++;
            nodeBasket[hash % basketNumbers] = newNode;
        }
        if (elementsNumber == basketNumbers) {

            Node<T, V>[] tempNodeBasket = nodeBasket;
            basketNumbers *= 2;
            nodeBasket = new Node[basketNumbers];
            elementsNumber = 0;
            for (Node<T, V> node : tempNodeBasket) {

                if (node != null) {

                    do {

                        put(node.key, node.value);
                        node = node.next;
                    } while (node != null);
                }
            }
        }
        return null;
    }

    public V remove(T key) {

        int hash = hashCalc(key);
        Node<T, V> currentNode = nodeBasket[hash % basketNumbers];
        Node<T, V> bufferNode = null;

        if (nodeBasket[hash % basketNumbers] != null) {

            while (currentNode != null) {

                if (currentNode.value.equals(key)) {

                    V returnInt = currentNode.value;

                    nodes.remove(currentNode);

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

    public void putAll(MapMethods<T, V> map) {

        MapMethods<T, V> secondMap = map;
        for (Node<T, V> node : secondMap.nodeBasket) {

            if (node != null) {

                put(node.key, node.value);
            }
        }
    }

    @SuppressWarnings("unchecked")
    public void clear() {

        elementsNumber = 0;
        basketNumbers = DEFAULT_SIZE;
        nodeBasket = new Node[DEFAULT_SIZE];
    }
}
