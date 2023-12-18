package ru.gb.family_tree;

import ru.gb.family_tree.comparators.ComparatorByAge;
import ru.gb.family_tree.comparators.ComparatorByName;
import ru.gb.family_tree.iterators.MemberIterator;
import ru.gb.family_tree.model.Gender;
import ru.gb.family_tree.model.Member;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class FamilyTree<T extends Member> implements Serializable, Iterable<T> {

    private final List<T> familyTree = new ArrayList<T>();


    public void addFamilyTreeMember(T member) {
        familyTree.add(member);
    }

    @Override
    public String toString() {
        StringBuilder stringBuilder = new StringBuilder();
        for (T member : familyTree) {
            stringBuilder.append(member);
        }
        return stringBuilder.toString();
    }

    public void addParent(T parent, T child) {
        if (parent.getGender().equals(Gender.MALE)) {
            child.setFather(parent);
        } else child.setMother(parent);
        parent.addChild(child);
    }

    public void sortByName() {
        familyTree.sort(new ComparatorByName<>());
    }
    public void sortByAge() { familyTree.sort(new ComparatorByAge<>());  }

    @Override
    public Iterator<T> iterator() {
        return new MemberIterator<>(familyTree);
    }
}
