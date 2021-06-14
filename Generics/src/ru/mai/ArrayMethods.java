package ru.mai;

import java.util.Arrays;

public class ArrayMethods<T> {

    T[] array;
    int arraySize;
    int elementsNumber = 0;
    private static final int DEFAULT_SIZE = 5;

    @SuppressWarnings("unchecked")
    public ArrayMethods() {

        this.array = ((T[]) new Object[DEFAULT_SIZE]);
        arraySize = DEFAULT_SIZE;
    }

    @SuppressWarnings("unchecked")
    public ArrayMethods(int size) {

        if (size > 0) {

            array = ((T[]) new Object[size]);
            arraySize = size;
        } else {
            array = ((T[]) new Object[DEFAULT_SIZE]);
            arraySize = 0;
        }
    }

    public int size() {

        return elementsNumber;
    }


    public boolean isEmpty() {

        return elementsNumber == 0;
    }


    public boolean contains(T o) {
        return indexOf((String) o) != -1;
    }

    @SuppressWarnings("unchecked")
    public T[] toArray() {

        return (T[]) Arrays.copyOf(array, arraySize);
    }

    @SuppressWarnings("unchecked")
    public boolean add(T o) {

        if (arraySize > elementsNumber) {
            array[elementsNumber] = o;
            elementsNumber++;
        } else {
            T[] copyArray = ((T[]) new Object[elementsNumber]);
            System.arraycopy(array, 0, copyArray, 0, arraySize);
            arraySize *= 2;
            array = ((T[]) new Object[arraySize]);
            System.arraycopy(copyArray, 0, array, 0, arraySize);
            array[arraySize + 1] = o;
        }
        return true;
    }

    public boolean addAll(ArrayMethods<T> c) {

        if (c.size() == 0) {
            return false;
        }
        for (T cElements : c.toArray()) {
            add(cElements);
        }
        return true;
    }


    @SuppressWarnings("unchecked")
    public boolean addAll(int index, ArrayMethods<T> c) {

        if (c.size() == 0) {
            return false;
        }
        T[] copyArray = ((T[]) new Object[elementsNumber]);
        System.arraycopy(array, 0, copyArray, 0, elementsNumber);
        if (arraySize < elementsNumber + c.size()) {
            arraySize *= 2;
        }
        array = ((T[]) new Object[arraySize]);
        elementsNumber = 0;
        for (int i = 0; i < index; ++i) {
            array[i] = copyArray[i];
            ++elementsNumber;
        }
        for (int i = 0; i < c.size(); ++i) {
            add(c.get(i));
        }
        if (index != elementsNumber) {
            for (int i = index + c.size(); i < copyArray.length; ++i) {
                ++elementsNumber;
                array[i] = copyArray[i - c.size()];

            }
        }
        return true;
    }

    @SuppressWarnings("unchecked")
    public void clear() {

        array = ((T[]) new Object[DEFAULT_SIZE]);
        elementsNumber = 0;

    }

    public T get(int index) {

        return (T) array[index];
    }

    public T set(int index, String element) {

        return array[index] = (T) element;
    }

    @SuppressWarnings("unchecked")
    public void add(int index, T element) {

        if (index > arraySize || index < 0) {
            System.out.println("Error");
        } else if (index == arraySize) {

            add(element);
        } else {

            T[] copyArray = ((T[]) new Object[elementsNumber]);
            System.arraycopy(array, 0, copyArray, 0, arraySize);
            for (int i = 0; i < index; ++i) {

                array[i] = copyArray[i];
            }
            array[index] = element;
            for (int i = index + 1; i < arraySize; ++i) {
                array[i] = copyArray[i - 1];
            }
            ++arraySize;

        }
    }

    public T remove(int index) {
        T buffer = array[index];
        --arraySize;
        --elementsNumber;
        System.arraycopy(array, index + 1, array, index, arraySize - index);
        array[elementsNumber] = null;
        return buffer;
    }

    public boolean remove(Object o) {

        for (int i = 0; i < elementsNumber; ++i) {
            if (array[i].equals(o)) {

                remove(i);
                return true;
            }
        }

        return false;
    }

    public int indexOf(Object o) {
        for (int i = 0; i < elementsNumber; ++i) {
            if (array[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    public int lastIndexOf(T o) {
        for (int i = arraySize - 1; i > 0; --i) {
            if (array[i].equals(o)) {
                return i;
            }
        }
        return -1;
    }

    public ArrayMethods<T> subList(int fromIndex, int toIndex) {

        ArrayMethods<T> newArray = new ArrayMethods<T>(toIndex - fromIndex);
        for (int i = 0; i < newArray.size(); i++) {
            for (int j = fromIndex; j < toIndex; j++) {
                newArray.add(array[j]);
            }
        }
        return newArray;
    }

    public boolean removeAll(ArrayMethods<T> c) {

        for (int i = 0; i < c.size(); i++) {
            remove(c.get(i));
        }
        return true;
    }

    public boolean containsAll(ArrayMethods<T> c) {

        boolean check = true;
        for (int i = 0; i < c.size(); i++) {
            check = contains(c.get(i));
        }
        return check;
    }
}
