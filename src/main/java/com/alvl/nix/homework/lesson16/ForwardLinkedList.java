package com.alvl.nix.homework.lesson16;

import java.util.AbstractSequentialList;
import java.util.Collection;
import java.util.Iterator;
import java.util.ListIterator;

public class ForwardLinkedList<E> extends AbstractSequentialList<E> {
    private int size = 0;
    private Node<E> head;

    public ForwardLinkedList() {
    }


    public ForwardLinkedList(Collection<E> elements) {
        if (elements.isEmpty()) return;
        size = 1;
        var iterator = elements.iterator();
        head = new Node<>(iterator.next());
        var current = head;
        while (iterator.hasNext()) {
            var next = new Node<>(iterator.next());
            current.next = next;
            current = next;
            size++;
        }
    }

    private Node<E> node(int i) {
        var current = head;
        for (int j = 0; j < i; j++) {
            current = current.next;
        }
        return current;
    }


    @Override
    public E get(int i) {
        this.checkElementIndex(i);
        return this.node(i).value;
    }

    public E set(int i, E e) {

        var node = node(i);
        var value = node.value;
        node.value = e;
        return value;
    }

    @Override
    public void add(int i, E e) {
        this.checkElementIndex(i);
        if (i == 0) {
            head = new Node<>(e, head);
        } else {
            var prev = node(i - 1);
            prev.next = new Node<>(e, prev.next);
        }
        size++;
    }

    @Override
    public E remove(int i) {
        checkElementIndex(i);
        final E value;
        if (i == 0) {
            value = head.value;
            head = head.next;
        } else {
            var before = node(i - 1);
            var removed = before.next;
            before.next = removed.next;
            value = removed.value;
        }
        size--;
        return value;
    }

    @Override
    public ListIterator<E> listIterator(int i) {
        var it = new ListIterator<E>() {


            Node<E> current;

            Node<E> previous;

            Node<E> next = head;
            boolean moved;

            private int currentIndex = -1;

            @Override
            public boolean hasNext() {
                return currentIndex + 1 < size();
            }

            @Override
            public E next() {
                currentIndex++;
                previous = current;
                current = next;
                next = next.next;
                moved = false;
                return current.value;
            }

            @Override
            public boolean hasPrevious() {
                return currentIndex > 0;
            }

            @Override
            public E previous() {
                current = previous;
                next = current.next;
                if (--currentIndex == 0) {
                    previous = null;
                } else {
                    previous = node(currentIndex);
                }
                moved = false;
                return current.value;


            }

            @Override
            public int nextIndex() {
                return currentIndex + 1;
            }

            @Override
            public int previousIndex() {
                return Math.max(currentIndex - 1, -1);
            }

            @Override
            public void remove() {
                if (currentIndex == 0) {
                    head = head.next;
                } else {
                    previous.next = next;
                }
                size--;
                moved = true;

            }

            @Override
            public void set(E e) {
                current.value = e;
            }

            @Override
            public void add(E e) {
                this.next = current;
                current = new Node<>(e, this.current);
                if (currentIndex == 0) {
                    head = current;
                } else {
                    previous.next = current;
                }
                size++;
                moved = true;

            }
        };
        return it;
    }

    @Override
    public Iterator<E> iterator() {
        return this.listIterator();
    }

    @Override
    public int size() {
        return this.size;
    }

    protected void checkElementIndex(int index) {
        if (!this.isElementIndex(index)) {
            throw new IndexOutOfBoundsException("Out of bound!");
        }
    }

    private boolean isElementIndex(int index) {
        return index >= 0 && index < this.size;
    }
}
