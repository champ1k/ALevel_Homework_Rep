package com.alvl.nix.homework.lesson16;

public class Node<E> {
    E value;

    Node<E> next;

    public Node(E value) {
        this.value = value;
    }

    public Node(E value, Node<E> next) {
        this.value = value;
        this.next = next;
    }

}
