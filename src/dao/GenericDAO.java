package dao;

import java.util.*;

public class GenericDAO<T> {
    private List<T> items = new ArrayList<>();

    public void add(T obj) {
        items.add(obj);
    }

    public List<T> getAll() {
        return items;
    }
}