package org.howard.edu.lsp.assignment6;

import java.util.ArrayList;
import java.util.Collections;

/**
 * Name: Nicholas Abram
 * IntegerSet models a mathematical set of integers.
 * A set does not allow duplicate values.
 */
public class IntegerSet {
    private ArrayList<Integer> set = new ArrayList<Integer>();

    /**
     * Default constructor that creates an empty set.
     */
    public IntegerSet() {
    }

    /**
     * Clears the internal representation of the set.
     */
    public void clear() {
        set.clear();
    }

    /**
     * Returns the number of elements in the set.
     *
     * @return number of elements in the set
     */
    public int length() {
        return set.size();
    }

    /**
     * Returns true if two sets contain exactly the same elements.
     *
     * @param b the other IntegerSet
     * @return true if both sets are equal, false otherwise
     */
    public boolean equals(IntegerSet b) {
        if (b == null) {
            return false;
        }

        if (this.length() != b.length()) {
            return false;
        }

        ArrayList<Integer> thisCopy = new ArrayList<Integer>(this.set);
        ArrayList<Integer> otherCopy = new ArrayList<Integer>(b.set);

        Collections.sort(thisCopy);
        Collections.sort(otherCopy);

        return thisCopy.equals(otherCopy);
    }

    /**
     * Returns true if the set contains the given value.
     *
     * @param value the value to search for
     * @return true if value exists in the set, false otherwise
     */
    public boolean contains(int value) {
        return set.contains(value);
    }

    /**
     * Returns the largest item in the set.
     *
     * @return largest integer in the set
     * @throws RuntimeException if the set is empty
     */
    public int largest() {
        if (set.isEmpty()) {
            throw new RuntimeException("IntegerSet is empty");
        }
        return Collections.max(set);
    }

    /**
     * Returns the smallest item in the set.
     *
     * @return smallest integer in the set
     * @throws RuntimeException if the set is empty
     */
    public int smallest() {
        if (set.isEmpty()) {
            throw new RuntimeException("IntegerSet is empty");
        }
        return Collections.min(set);
    }

    /**
     * Adds an item to the set if it is not already present.
     *
     * @param item the integer to add
     */
    public void add(int item) {
        if (!set.contains(item)) {
            set.add(item);
        }
    }

    /**
     * Removes an item from the set if it exists.
     *
     * @param item the integer to remove
     */
    public void remove(int item) {
        set.remove(Integer.valueOf(item));
    }

    /**
     * Returns a new set that is the union of this set and another set.
     * The original sets are not modified.
     *
     * @param intSetb the other IntegerSet
     * @return new IntegerSet containing all unique elements from both sets
     */
    public IntegerSet union(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();

        for (int value : this.set) {
            result.add(value);
        }

        if (intSetb != null) {
            for (int value : intSetb.set) {
                result.add(value);
            }
        }

        return result;
    }

    /**
     * Returns a new set containing only elements common to both sets.
     * The original sets are not modified.
     *
     * @param intSetb the other IntegerSet
     * @return new IntegerSet containing common elements
     */
    public IntegerSet intersect(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();

        if (intSetb == null) {
            return result;
        }

        for (int value : this.set) {
            if (intSetb.contains(value)) {
                result.add(value);
            }
        }

        return result;
    }

    /**
     * Returns a new set containing elements in this set but not in intSetb.
     * The original sets are not modified.
     *
     * @param intSetb the other IntegerSet
     * @return new IntegerSet containing the difference
     */
    public IntegerSet diff(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();

        if (intSetb == null) {
            for (int value : this.set) {
                result.add(value);
            }
            return result;
        }

        for (int value : this.set) {
            if (!intSetb.contains(value)) {
                result.add(value);
            }
        }

        return result;
    }

    /**
     * Returns a new set containing elements in intSetb but not in this set.
     * The original sets are not modified.
     *
     * @param intSetb the other IntegerSet
     * @return new IntegerSet containing the complement
     */
    public IntegerSet complement(IntegerSet intSetb) {
        IntegerSet result = new IntegerSet();

        if (intSetb == null) {
            return result;
        }

        for (int value : intSetb.set) {
            if (!this.contains(value)) {
                result.add(value);
            }
        }

        return result;
    }

    /**
     * Returns true if the set is empty.
     *
     * @return true if set has no elements, false otherwise
     */
    public boolean isEmpty() {
        return set.isEmpty();
    }

    /**
     * Returns a string representation of the set in ascending order.
     * Example: [1, 2, 3]
     *
     * @return string representation of the set
     */
    @Override
    public String toString() {
        ArrayList<Integer> sortedSet = new ArrayList<Integer>(set);
        Collections.sort(sortedSet);
        return sortedSet.toString();
    }
}