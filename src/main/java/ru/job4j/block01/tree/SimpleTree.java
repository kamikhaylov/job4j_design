package ru.job4j.block01.tree;

import java.util.*;
import java.util.function.Predicate;

class SimpleTree<E> implements Tree<E> {
    private final Node<E> root;

    public SimpleTree(final E root) {
        this.root = new Node<>(root);
    }

    @Override
    public boolean add(E parent, E child) {
        boolean rsl = false;
        Optional<Node<E>> elParent = findBy(parent);
        Optional<Node<E>> elChild = findBy(child);
        if (elParent.isPresent() && !elChild.isPresent()) {
            elParent.get().getChildren().add(new Node<>(child));
            rsl = true;
        }
        return rsl;
    }

    @Override
    public Optional<Node<E>> findBy(E value) {
        return findByPredicate(p -> p.getValue().equals(value));
    }

    @Override
    public boolean isBinary() {
        Optional<Node<E>> rsl = findByPredicate(p -> p.getChildren().size() > 2);
        return rsl.isPresent() ? false : true;
    }

    private Optional<Node<E>> findByPredicate(Predicate<Node<E>> condition) {
        Optional<Node<E>> rsl = Optional.empty();
        Queue<Node<E>> data = new LinkedList<>();
        data.offer(this.root);
        while (!data.isEmpty()) {
            Node<E> el = data.poll();
            if (condition.test(el)) {
                rsl = Optional.of(el);
                break;
            }
            data.addAll(el.getChildren());
        }
        return rsl;
    }
}