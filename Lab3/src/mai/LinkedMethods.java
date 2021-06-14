package mai;

import mai.interfaces.Linked;

import java.util.Objects;

public class LinkedMethods implements Linked {

    int elementsNumber = 0;

    public static class Node {
        String value;
        Node next;
    }

    Node first = null;
    Node last = null;

    public LinkedMethods() {
    }

    public void checkIndex(int index) {
        if (index >= elementsNumber || index < 0) {
            throw new IllegalArgumentException("Invalid indexes");
        }
    }

    public void checkAddIndex(int index) {
        if (index > elementsNumber || index < 0) {
            throw new IllegalArgumentException("Invalid indexes");
        }
    }

    public int size() {
        return elementsNumber;
    }

    public boolean isEmpty() {
        return elementsNumber == 0;
    }

    public boolean contains(String o) {
        return indexOf(o) != -1;
    }

    public String[] toArray() {
        String[] stringForReturn = new String[elementsNumber];
        if (first != null) {
            Node currentNode = first;
            for (int i = 0; i < elementsNumber
                    && currentNode.next != null; i++, currentNode = currentNode.next) {
                stringForReturn[i] = currentNode.value;
            }
            stringForReturn[elementsNumber - 1] = currentNode.value;
        }
        return stringForReturn;
    }

    public boolean add(String o) {
        Node currentNode = new Node();
        currentNode.value = o;
        if (first == null) {
            last = currentNode;
            first = currentNode;
        } else {
            last.next = currentNode;
            last = currentNode;
        }
        ++elementsNumber;
        return true;
    }

    public boolean addAll(Linked c) {
        if (c == null) {
            throw new IllegalArgumentException("Linked can not be null");
        } else if (c.size() <= 0) {
            return false;
        }
        addAll(elementsNumber, c);
        return true;
    }

    public boolean addAll(int index, Linked c) {
        checkAddIndex(index);
        if (c == null) {
            throw new IllegalArgumentException("Linked can not be null");
        } else {
            if (c.size() == 0) {
                return false;
            }
            for (int i = index; i < c.size() + index; ++i) {
                add(i, c.get(i - index));
            }
            return true;
        }
    }

    public void clear() {
        first = null;
        last = null;
        elementsNumber = 0;
    }

    public String get(int index) {
        checkIndex(index);
        Node currentNode = first;
        for (int i = 0; i < index; ++i) {
            if (i == index) {
                return currentNode.value;
            }
            currentNode = currentNode.next;
        }
        if (currentNode.value != null) {
            return currentNode.value;
        }
        return null;
    }

    public String set(int index, String element) {
        String buffer;
        checkIndex(index);
        Node currentNode = first;
        int i = 0;
        while (currentNode != null) {
            if (i == index) {
                buffer = currentNode.value;
                currentNode.value = element;
                return buffer;
            }
            currentNode = currentNode.next;
            i++;
        }
        return null;
    }

    public void add(int index, String element) {
        checkAddIndex(index);
        if (index == elementsNumber) {
            add(element);
        } else if (index == 0) {
            Node currentNode = new Node();
            currentNode.value = element;
            currentNode.next = first;
            first = currentNode;
            ++elementsNumber;
        } else {
            Node currentNode = first;
            int nodePos = 0;
            while (currentNode != null) {
                if (nodePos == index - 1) {
                    Node nextCurrentNode = currentNode.next;
                    Node newNode = new Node();
                    newNode.value = element;
                    newNode.next = nextCurrentNode;
                    currentNode.next = newNode;
                    ++elementsNumber;
                }
                nodePos++;
                currentNode = currentNode.next;
            }
        }
    }

    public String remove(int index) {
        checkIndex(index);
        Node currentNode = first;
        Node preNode = null;
        if (index == 0) {
            String buffer = first.value;
            first = first.next;
            --elementsNumber;
            if (size() == 0) {
                last = null;
            }
            return buffer;
        } else {
            for (int i = 0; i < elementsNumber; ++i) {
                if (i == index) {
                    --elementsNumber;
                    preNode.next = currentNode.next;
                    if (index == elementsNumber) {
                        last = preNode;
                    }
                    return currentNode.value;
                }
                preNode = currentNode;
                currentNode = currentNode.next;
            }
        }
        return null;
    }

    public boolean remove(Object o) {
        Node currentNode;
        int i = 0;
        for (currentNode = first; (currentNode != null && i < elementsNumber); currentNode = currentNode.next) {
            if (Objects.equals(get(i), o)) {
                remove(i);
                return true;
            }
            ++i;
        }
        return false;
    }

    public int indexOf(String o) {
        for (int i = 0; i < elementsNumber; ++i) {
            if (Objects.equals(o, get(i))) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(String o) {
        for (int i = (elementsNumber - 1); i >= 0; --i) {
            if (Objects.equals(o, get(i))) {
                return i;
            }
        }
        return -1;
    }

    public Linked subList(int fromIndex, int toIndex) {
        checkIndex(fromIndex);
        checkAddIndex(toIndex);
        if (fromIndex >= toIndex) {
            throw new IllegalArgumentException("invalid indexes");
        }
        Linked buffer = new LinkedMethods();
        Node currentNode = first;
        if (fromIndex == toIndex) {
            return buffer;
        } else {
            for (int i = 0; i < toIndex && currentNode != null; ++i) {
                if (i >= fromIndex) {
                    buffer.add(currentNode.value);
                }
                currentNode = currentNode.next;
            }
        }
        return buffer;
    }


    public boolean removeAll(Linked c) {
        int check = elementsNumber;
        if (c == null) {
            throw new IllegalArgumentException("Array can not be null");
        } else if (c.size() <= 0) {
            return false;
        } else {
            for (int i = 0; i < c.size(); ++i) {
                remove(c.get(i));
            }
        }
        return check != elementsNumber;
    }

    public boolean containsAll(Linked c) {
        int check = 0;
        if (c == null) {
            throw new IllegalArgumentException("Array can not be null");
        } else if (c.size() == 0) {
            return false;
        }
        for (int i = 0; i < c.size(); ++i) {
            if (contains(c.get(i))) {
                ++check;
            }
        }
        return check == c.size();
    }
}
