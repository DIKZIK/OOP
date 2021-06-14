package ru.mai;

public class LinkedMethods<T> {

    int elementsNumber = 0;

    public static class Node<T> {

        T value;
        Node<T> next;
    }

    Node<T> first;
    Node<T> last;

    public LinkedMethods() {

    }

    public int size() {

        return elementsNumber;
    }

    public boolean isEmpty() {

        return elementsNumber == 0;
    }

    public boolean contains(T o) {

        return indexOf(o) != -1;
    }

    @SuppressWarnings("unchecked")
    public T[] toArray() {

        T[] arrayForReturn = (T[]) new Object[elementsNumber];
        Node<T> currentNode;
        int i = 0;

        for (currentNode = first; (currentNode != null && i < elementsNumber); currentNode = currentNode.next) {

            arrayForReturn[i] = (T) currentNode.value;
            ++i;
        }
        return arrayForReturn;
    }

    public boolean add(T o) {

        Node<T> currentNode = new Node<>();
        currentNode.value = o;

        if (first == null) {
            last = currentNode;
            first = currentNode;
        } else {

            last.next = currentNode;
            last = currentNode;
        }
        elementsNumber++;
        return true;
    }

    public boolean addAll(LinkedMethods<T> c) {

        addAll(elementsNumber, c);
        return true;
    }

    public boolean addAll(int index, LinkedMethods<T> c) {

        T[] cToArray = (T[]) c.toArray();
        if (c.size() == 0 || index < 0) {

            return false;
        }
        for (int i = index; i < c.size() + index; ++i) {

            add(i, (cToArray[i - index]));
        }
        return true;
    }

    public void clear() {

        first = null;
        last = null;
        elementsNumber = 0;
    }

    public T get(int index) {

        if (index < elementsNumber && index >= 0) {

            Node<T> currentNode = first;
            for (int i = 0; i < index; ++i) {

                currentNode = currentNode.next;
            }

            return currentNode.value;
        } else {

            return null;
        }
    }

    public T set(int index, T element) {

        T buffer;
        if (index < elementsNumber && index >= 0) {

            Node<T> currentNode = first;
            for (int i = 0; i < index; ++i) {

                currentNode = currentNode.next;
            }

            buffer = currentNode.value;
            currentNode.value = element;

            return buffer;
        } else {

            return null;
        }
    }

    public void add(int index, T element) {

        Node<T> currentNode = first;
        int nodePos = 0;
        while (currentNode != null) {
            if (nodePos == index - 1) {

                Node<T> nextCurrentNode = currentNode.next;
                Node<T> newNode = new Node<>();
                newNode.value = element;
                newNode.next = nextCurrentNode;
                currentNode.next = newNode;
                elementsNumber++;
            }

            nodePos++;
            currentNode = currentNode.next;
        }
    }

    public T remove(int index) {

        if (index >= -1 && index < elementsNumber) {
            Node<T> currentNode = first;
            Node<T> preNode = new Node();
            if (index == 0) {

                preNode.value = first.value;
                first = first.next;
                --elementsNumber;

                return preNode.value;
            } else {
                for (int i = 0; i < elementsNumber; ++i) {
                    if (i == index) {
                        preNode.next = currentNode.next;
                        --elementsNumber;
                        return currentNode.value;
                    }
                    preNode = currentNode;
                    currentNode = currentNode.next;
                }
            }
        }
        return null;
    }

    public boolean remove(Object o) {

        Node<T> currentNode;
        int i = 0;

        for (currentNode = first; (currentNode != null && i < elementsNumber); currentNode = currentNode.next) {
            if (currentNode.value.equals(o)) {

                remove(i);
                return true;
            }
            ++i;
        }
        return false;
    }

    public int indexOf(T o) {

        Node<T> currentNode = first;
        int nodePos = 0;
        while (currentNode != null) {
            nodePos++;
            if (o.equals(currentNode.value)) {
                return nodePos;
            }
            currentNode = currentNode.next;
        }
        return -1;
    }

    public int lastIndexOf(T o) {

        Node<T> currentNode = first;
        int nodePos = elementsNumber;

        while (currentNode != null) {

            nodePos--;
            if (o.equals(currentNode.value)) {

                return nodePos;
            }
            currentNode = currentNode.next;
        }
        return -1;
    }

    public LinkedMethods<T> subList(int fromIndex, int toIndex) {

        LinkedMethods<T> buffer = new LinkedMethods<>();
        Node<T> currentNode = first;

        for (int i = fromIndex; i < toIndex || currentNode != null; ++i) {

            buffer.add(currentNode.value);
            currentNode = currentNode.next;
        }

        return buffer;
    }

    public boolean removeAll(LinkedMethods<T> c) {

        T[] array = c.toArray();

        for (int i = 0; i < elementsNumber; i++) {

            remove(array[i]);
        }
        return false;
    }

    public boolean containsAll(LinkedMethods<T> c) {

        for (T buffer : c.toArray()) {

            if (!contains(buffer)) {
                return false;
            }
        }
        return true;
    }
}
