package ru.alx.natera;

import ru.alx.graph.Edge;

import java.util.Iterator;
import java.util.List;

public class Util {

    static public <T> boolean checkEdgeListsEquality(List<Edge<T>> l1, List<Edge<T>> l2) {
        Iterator<Edge<T>> it1 = l1.iterator();
        Iterator<Edge<T>> it2 = l2.iterator();
        boolean equal = true;
        while (it1.hasNext() && it2.hasNext()) {
            Edge el1 = it1.next();
            Edge el2 = it2.next();
            if (!el1.getSource().equals(el2.getSource()) ||
                    !el1.getTarget().equals(el2.getTarget())) {
                equal = false;
                break;
            }
        }

        return equal;
    }
}
