package mai;

import mai.interfaces.Array;

import java.util.Arrays;
import java.util.Objects;

public class ArrayMethods implements Array {

    String[] array;
    int arraySize;
    int elementsNumber = 0;
    private static final int DEFAULT_SIZE = 5;

    public ArrayMethods() {
        this(DEFAULT_SIZE);
    }

    public ArrayMethods(int size) {
        if (size > 0) {
            array = new String[size];
            arraySize = size;
        } else {
            throw new IllegalArgumentException("Size must be greater than 0" + size);
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
        return Arrays.copyOf(array, elementsNumber);
    }

    public boolean add(String o) {
        if (arraySize > elementsNumber) {
            array[elementsNumber] = o;
        } else {
            arraySize *= 2;
            array = Arrays.copyOf(array, arraySize);
            array[elementsNumber] = o;
        }
        elementsNumber++;
        return true;
    }

    public boolean addAll(Array c) {
        if (c == null) {
            throw new IllegalArgumentException("Array can not be null");
        } else if (c.size() == 0) {
            return false;
        } else {
            for (int i = 0; i < c.size(); ++i) {
                add(c.get(i));
            }
            return true;
        }
    }


    public boolean addAll(int index, Array c) {
        int prevSize = elementsNumber;
        if (c == null) {
            throw new IllegalArgumentException("Array can not be null");
        }
        if (index < 0 || index > elementsNumber) {
            throw new IndexOutOfBoundsException("Invalid indexes");
        } else {
            if (c.size() == 0) {
                return false;
            }
            for (int i = 0; i < c.size(); ++i) {
                add(index + i, c.get(i));
            }
        }
        return elementsNumber != prevSize;
    }

    public void clear() {
        array = new String[DEFAULT_SIZE];
        arraySize = DEFAULT_SIZE;
        elementsNumber = 0;
    }

    public String get(int index) {
        if (index < 0 || (index > elementsNumber - 1)) {
            throw new IndexOutOfBoundsException("Invalid indexes");
        } else {
            return array[index];
        }
    }

    public String set(int index, String element) {
        if (index < 0 || index > (elementsNumber - 1)) {
            throw new IndexOutOfBoundsException("Invalid indexes");
        } else {
            String buffer = array[index];
            array[index] = element;
            return buffer;
        }
    }

    public void add(int index, String element) {
        if (index > elementsNumber || index < 0) {
            throw new IndexOutOfBoundsException("Invalid indexes");
        } else if (index == elementsNumber) {
            add(element);
        } else {
            if (elementsNumber == arraySize) {
                array = Arrays.copyOf(array, arraySize * 2);
                arraySize *= 2;
            }
            System.arraycopy(array, index, array, index + 1, elementsNumber - index);
            array[index] = element;
            ++elementsNumber;
        }
    }

    public String remove(int index) {
        if (index < 0 || index > (elementsNumber - 1)) {
            throw new IndexOutOfBoundsException("Invalid indexes");
        } else {
            String buffer = array[index];
            --elementsNumber;
            System.arraycopy(array, index + 1, array, index, elementsNumber - index);
            array[elementsNumber] = null;
            return buffer;
        }
    }

    public boolean remove(Object o) {
        for (int i = 0; i < elementsNumber; ++i) {
            if (Objects.equals(o, array[i])) {
                remove(i);
                return true;
            }
        }
        return false;
    }

    public int indexOf(String o) {
        for (int i = 0; i < elementsNumber; ++i) {
            if (Objects.equals(o, array[i])) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(String o) {
        for (int i = elementsNumber - 1; i >= 0; --i) {
            if (Objects.equals(o, array[i])) {
                return i;
            }
        }
        return -1;
    }

    public Array subList(int fromIndex, int toIndex) {
        if (toIndex > (elementsNumber) || fromIndex < 0 || fromIndex >= toIndex || fromIndex >= elementsNumber) {
            throw new IndexOutOfBoundsException("Invalid indexes");
        } else {
            Array newArray = new ArrayMethods(toIndex - fromIndex);
            for (int i = fromIndex; i < toIndex; ++i) {
                newArray.add(array[i]);
            }
            return newArray;
        }
    }

    public boolean removeAll(Array c) {
        if (c == null) {
            throw new IllegalArgumentException("Array can not be null");
        }
        int prevSize = elementsNumber;
        if (c.size() <= 0) {
            return false;
        } else {
            for (int i = 0; i < c.size(); ++i) {
                remove(c.get(i));
            }
        }
        return elementsNumber != prevSize;
    }

    public boolean containsAll(Array c) {
        if (c == null) {
            throw new IllegalArgumentException("Array can not be null");
        }
        int check = 0;
        for (int i = 0; i < c.size(); ++i) {
            for (int j = 0; j < elementsNumber; ++j) {
                if (Objects.equals(c.get(i), array[j])) {
                    ++check;
                }
            }
        }
        return check == c.size();
    }
}
