/*
 * Project and Training 2 - HS23, Computer Science, Berner Fachhochschule
 */

package ch.bfh.stack;

import ch.bfh.exceptions.StackEmptyException;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Objects;

/**
 * An implementation of an array based stack
 *
 * @param <E> The type of the elements
 */
@SuppressWarnings("unchecked") //We don't need to check if elements in the data array are of type E.
                              // We are sure, that the elements are of type E because the add function only allows us to add elements of type E.

public class ArrayBasedStack<E> implements Stack<E> {
    private static final int INIT_CAPACITY = 16;
    private int size = 0;
    private int capacity = INIT_CAPACITY;
    private Object[] data = new Object[capacity];


    @Override
    public int size() {
        return size;
    }

    @Override
    public void clear() {
        capacity = INIT_CAPACITY;
        data = new Object[capacity];
        size = 0;
    }

    @Override
    public boolean contains(E e) {
        for (int i = 0; i < size; i++) {
            if (elementEquals(data[i], e)) {
                return true;
            }
        }
        return false;
    }


    @Override
    public E top() throws StackEmptyException {
        if (isEmpty()) {
            throw new StackEmptyException("Array is empty.");
        } else {
            return (E) data[size - 1];
        }
    }

    @Override
    public void push(E element) {
        if (size >= capacity) {
            resize(2 * capacity);
        }
        data[size] = element;
        size++;
    }

    @Override
    public E pop() throws StackEmptyException {
        if (isEmpty()) {
            throw new StackEmptyException("Array is empty.");
        } else {
            E element = (E) data[size - 1];
            data[size - 1] = null;
            size--;
            if (size <= capacity / 4 && capacity > INIT_CAPACITY) {
                resize(capacity / 2);
            }
            return element;
        }
    }

    private void resize(int newCapacity) {
        Object[] newData = new Object[newCapacity];
        for (int i = 0; i < size; i++) {
            newData[i] = data[i];
        }
        capacity = newCapacity;
        data = newData;
    }

    private boolean elementEquals(Object o1, Object o2) {
        if (o1 == null && o2 == null) {
            return true;
        }
        return o1 != null && o1.equals(o2);
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ArrayBasedStack<?> that = (ArrayBasedStack<?>) o;
        if (size != that.size) return false;
        for (int i = 0; i < size; i++) {
            if (!elementEquals(data[i], that.data[i])) return false;
        }
        return true;
    }

    @Override
    public int hashCode() {
        int result = Objects.hash(size, capacity);
        result = 31 * result + Arrays.hashCode(data);
        return result;
    }


}
