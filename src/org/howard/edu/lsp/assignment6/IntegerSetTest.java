package org.howard.edu.lsp.assignment6;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

public class IntegerSetTest {
    // ------------------------------------------------------------------ //
    // clear()
    // ------------------------------------------------------------------ //

    @Test
    @DisplayName("clear(): removes all elements from a non-empty set")
    public void testClear() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        set.clear();
        assertEquals(0, set.length(), "Clear should result in an empty set");
    }

    @Test
    @DisplayName("clear(): empty set remains empty")
    public void testClearOnEmptySet() {
        IntegerSet set = new IntegerSet();
        set.clear();
        assertEquals(0, set.length(), "Clearing an already empty set should still result in an empty set");
    }

    // ------------------------------------------------------------------ //
    // length()
    // ------------------------------------------------------------------ //

    @Test
    @DisplayName("length(): empty set has length 0")
    public void testLengthEmptySet() {
        IntegerSet set = new IntegerSet();
        assertEquals(0, set.length(), "Length of an empty set should be 0");
    }

    @Test
    @DisplayName("length(): non-empty set returns correct size")
    public void testLengthNonEmptySet() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        set.add(3);
        assertEquals(3, set.length(), "Length should reflect the number of unique elements in the set");
    }

    // ------------------------------------------------------------------ //
    // equals()
    // ------------------------------------------------------------------ //

    @Test
    @DisplayName("equals(): identical sets are equal")
    public void testEqualsIdenticalSets() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set2.add(1);
        set2.add(2);
        assertTrue(set1.equals(set2), "Identical sets should be equal");
    }

    @Test
    @DisplayName("equals(): different sets are not equal")
    public void testEqualsDifferentSets() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(3);
        assertFalse(set1.equals(set2), "Different sets should not be equal");
    }

    @Test
    @DisplayName("equals(): two empty sets are equal")
    public void testEqualsEmptySets() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();
        assertTrue(set1.equals(set2), "Two empty sets should be equal");
    }

    @Test
    @DisplayName("equals(): sets with different lengths are not equal")
    public void testDifferentLengthSets() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set2.add(1);
        assertFalse(set1.equals(set2), "Sets of different lengths should not be equal");
    }

    @Test
    @DisplayName("equals(): same elements in different order are equal")
    public void testSameElementsDifferentOrder() {
        IntegerSet set1 = new IntegerSet();
        IntegerSet set2 = new IntegerSet();
        set1.add(1);
        set1.add(2);
        set2.add(2);
        set2.add(1);
        assertTrue(set1.equals(set2), "Sets with the same elements in different order should be equal");
    }

    // ------------------------------------------------------------------ //
    // contains()
    // ------------------------------------------------------------------ //

    @Test
    @DisplayName("contains(): returns true for existing element")
    public void testContainsExistingElement() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        assertTrue(set.contains(1), "Set should contain the added element");
    }

    @Test
    @DisplayName("contains(): returns false for non-existing element")
    public void testContainsNonExistingElement() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        assertFalse(set.contains(2), "Set should not contain an element that was not added");
    }

    @Test
    @DisplayName("contains(): empty set does not contain any value")
    public void testContainsEmptySet() {
        IntegerSet set = new IntegerSet();
        assertFalse(set.contains(1), "Empty set should not contain any elements");
    }



    // ------------------------------------------------------------------ //
    // largest()
    // ------------------------------------------------------------------ //

    @Test
    @DisplayName("largest(): returns maximum value in non-empty set")
    public void testLargestNonEmptySet() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(3);
        set.add(2);
        assertEquals(3, set.largest(), "Largest should return the maximum element in the set");
    }

    @Test
    @DisplayName("largest(): single-element set returns that element")
    public void testLargestSingleElementSet() {
        IntegerSet set = new IntegerSet();
        set.add(5);
        assertEquals(5, set.largest(), "Largest should return the only element in the set");
    }

    @Test
    @DisplayName("largest(): empty set throws RuntimeException")
    public void testLargestEmptySet() {
        IntegerSet set = new IntegerSet();
        assertThrows(RuntimeException.class, () -> set.largest());
    }

    @Test
    @DisplayName("largest(): does not return a non-maximum value")
    public void testIncorrectLargest() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        set.add(3);
        assertNotEquals(2, set.largest(), "Largest should not return a non-maximum element");
    }

    // ------------------------------------------------------------------ //
    // smallest()
    // ------------------------------------------------------------------ //

    @Test
    @DisplayName("smallest(): returns minimum value in non-empty set")
    public void testSmallestNonEmptySet() {
        IntegerSet set = new IntegerSet();
        set.add(3);
        set.add(1);
        set.add(2);
        assertEquals(1, set.smallest(), "Smallest should return the minimum element in the set");
    }

    @Test
    @DisplayName("smallest(): single-element set returns that element")
    public void testSmallestSingleElementSet() {
        IntegerSet set = new IntegerSet();
        set.add(5);
        assertEquals(5, set.smallest(), "Smallest should return the only element in the set");
    }

    @Test
    @DisplayName("smallest(): empty set throws RuntimeException")
    public void testSmallestEmptySet() {
        IntegerSet set = new IntegerSet();
        assertThrows(RuntimeException.class, () -> set.smallest());
    }

    // ------------------------------------------------------------------ //
    // add()
    // ------------------------------------------------------------------ //

    @Test
    @DisplayName("add(): inserts a new element into the set")
    public void testAddNewElement() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        assertTrue(set.contains(1), "Adding a new element should result in it being contained in the set");
    }

    @Test
    @DisplayName("add(): duplicate element does not increase set size")
    public void testAddDuplicateElement() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(1);
        assertEquals(1, set.length(), "Adding a duplicate element should not increase the length of the set");
    }

    @Test
    @DisplayName("add(): multiple unique elements increase set size")
    public void testAddMultipleElements() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.add(2);
        set.add(3);
        assertEquals(3, set.length(), "Adding multiple unique elements should increase the length accordingly");
    }

    // ------------------------------------------------------------------ //
    // remove()
    // ------------------------------------------------------------------ //

    @Test
    @DisplayName("remove(): deletes an existing element")
    public void testRemoveExistingElement() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.remove(1);
        assertFalse(set.contains(1), "Removing an existing element should result in it no longer being contained in the set");
    }

    @Test
    @DisplayName("remove(): removing non-existing element does not change set")
    public void testRemoveNonExistingElement() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        set.remove(2);
        assertTrue(set.contains(1), "Removing a non-existing element should not affect the existing elements in the set");
    }

    @Test
    @DisplayName("remove(): removing from empty set leaves it unchanged")
    public void testRemoveFromEmptySet() {
        IntegerSet set = new IntegerSet();
        set.remove(1);
        assertEquals(0, set.length(), "Removing from an empty set should not change the length of the set");
    }

    // ------------------------------------------------------------------ //
    // union()
    // ------------------------------------------------------------------ //

    @Test
    @DisplayName("union(): combines unique elements from two non-empty sets")
    public void testUnionWithNonEmptySets() {
        IntegerSet setA = new IntegerSet();
        IntegerSet setB = new IntegerSet();
        setA.add(1);
        setA.add(2);
        setB.add(2);
        setB.add(3);
        IntegerSet unionSet = setA.union(setB);
        assertTrue(unionSet.contains(1), "Union should contain elements from the first set");
        assertTrue(unionSet.contains(2), "Union should contain common elements from both sets");
        assertTrue(unionSet.contains(3), "Union should contain elements from the second set");
        assertEquals(3, unionSet.length(), "Union should have the correct number of unique elements");
    }

    @Test
    @DisplayName("union(): union with empty set returns original elements")
    public void testUnionWithEmptySet() {
        IntegerSet setA = new IntegerSet();
        IntegerSet setB = new IntegerSet();
        setA.add(1);
        IntegerSet unionSet = setA.union(setB);
        assertTrue(unionSet.contains(1), "Union with an empty set should contain all elements from the non-empty set");
        assertEquals(1, unionSet.length(), "Union with an empty set should have the same number of elements as the non-empty set");
    }

    @Test
    @DisplayName("union(): union with null set returns original elements")
    public void testUnionWithNullSet() {
        IntegerSet setA = new IntegerSet();
        setA.add(1);
        IntegerSet unionSet = setA.union(null);
        assertTrue(unionSet.contains(1), "Union with a null set should contain all elements from the original set");
        assertEquals(1, unionSet.length(), "Union with a null set should have the same number of elements as the original set");
    }

    @Test
    @DisplayName("union(): does not modify the original sets")
    public void testUnionDoesNotModifyOriginals() {
        IntegerSet setA = new IntegerSet();
        IntegerSet setB = new IntegerSet();
        setA.add(1);
        setB.add(2);
        setA.union(setB);
        assertTrue(setA.contains(1), "Original set A should not be modified by union");
        assertFalse(setA.contains(2), "Original set A should not contain elements from set B");
        assertTrue(setB.contains(2), "Original set B should not be modified by union");
        assertFalse(setB.contains(1), "Original set B should not contain elements from set A");
    }

    // ------------------------------------------------------------------ //
    // intersect()
    // ------------------------------------------------------------------ //

    @Test
    @DisplayName("intersect(): returns common elements from two non-empty sets")
    public void testIntersectWithNonEmptySets() {
        IntegerSet setA = new IntegerSet();
        IntegerSet setB = new IntegerSet();
        setA.add(1);
        setA.add(2);
        setB.add(2);
        setB.add(3);
        IntegerSet intersectSet = setA.intersect(setB);
        assertTrue(intersectSet.contains(2), "Intersect should contain common elements from both sets");
        assertFalse(intersectSet.contains(1), "Intersect should not contain elements that are only in the first set");
        assertFalse(intersectSet.contains(3), "Intersect should not contain elements that are only in the second set");
        assertEquals(1, intersectSet.length(), "Intersect should have the correct number of common elements");
    }

    @Test
    @DisplayName("intersect(): intersecting with empty set returns empty set")
    public void testIntersectWithEmptySet() {
        IntegerSet setA = new IntegerSet();
        IntegerSet setB = new IntegerSet();
        setA.add(1);
        IntegerSet intersectSet = setA.intersect(setB);
        assertEquals(0, intersectSet.length(), "Intersect with an empty set should result in an empty set");
    }

    @Test
    @DisplayName("intersect(): no overlap returns empty set")
    public void testNoOverlapIntersect() {
        IntegerSet setA = new IntegerSet();
        IntegerSet setB = new IntegerSet();
        setA.add(1);
        setA.add(2);
        setB.add(3);
        setB.add(4);
        IntegerSet intersectSet = setA.intersect(setB);
        assertEquals(0, intersectSet.length(), "Intersect of two sets with no common elements should result in an empty set");
    }

    // ------------------------------------------------------------------ //
    // diff()
    // ------------------------------------------------------------------ //

    @Test
    @DisplayName("diff(): returns elements only in the first set")
    public void testDiffWithNonEmptySets() {
        IntegerSet setA = new IntegerSet();
        IntegerSet setB = new IntegerSet();
        setA.add(1);
        setA.add(2);
        setB.add(2);
        setB.add(3);
        IntegerSet diffSet = setA.diff(setB);
        assertTrue(diffSet.contains(1), "Diff should contain elements that are only in the first set");
        assertFalse(diffSet.contains(2), "Diff should not contain common elements from both sets");
        assertFalse(diffSet.contains(3), "Diff should not contain elements that are only in the second set");
        assertEquals(1, diffSet.length(), "Diff should have the correct number of unique elements from the first set");
    }

    @Test
    @DisplayName("diff(): identical sets return empty set")
    public void testIdenticalDiff() {
        IntegerSet setA = new IntegerSet();
        setA.add(1);
        setA.add(2);
        IntegerSet diffSet = setA.diff(setA);
        assertEquals(0, diffSet.length(), "Diff of a set with itself should result in an empty set");
    }

    @Test
    @DisplayName("diff(): does not include common or second-set-only elements")
    public void testIncorrectDiff() {
        IntegerSet setA = new IntegerSet();
        IntegerSet setB = new IntegerSet();
        setA.add(1);
        setA.add(2);
        setB.add(2);
        setB.add(3);
        IntegerSet diffSet = setA.diff(setB);
        assertFalse(diffSet.contains(2), "Diff should not contain common elements from both sets");
        assertFalse(diffSet.contains(3), "Diff should not contain elements that are only in the second set");
        assertEquals(1, diffSet.length(), "Diff should have the correct number of unique elements from the first set");
    }

    @Test
    @DisplayName("diff(): diff with empty set returns original elements")
    public void testDiffWithEmptySet() {
        IntegerSet setA = new IntegerSet();
        IntegerSet setB = new IntegerSet();
        setA.add(1);
        IntegerSet diffSet = setA.diff(setB);
        assertTrue(diffSet.contains(1), "Diff with an empty set should contain all elements from the non-empty set");
        assertEquals(1, diffSet.length(), "Diff with an empty set should have the same number of elements as the non-empty set");
    }

    // ------------------------------------------------------------------ //
    // complement()
    // ------------------------------------------------------------------ //

    @Test
    @DisplayName("complement(): returns elements only in the second set")
    public void testComplementWithNonEmptySets() {
        IntegerSet setA = new IntegerSet();
        IntegerSet setB = new IntegerSet();
        setA.add(1);
        setA.add(2);
        setB.add(2);
        setB.add(3);
        IntegerSet complementSet = setA.complement(setB);
        assertFalse(complementSet.contains(1), "Complement should not contain elements that are only in the first set");
        assertFalse(complementSet.contains(2), "Complement should not contain common elements from both sets");
        assertTrue(complementSet.contains(3), "Complement should contain elements that are only in the second set");
        assertEquals(1, complementSet.length(), "Complement should have the correct number of unique elements from the second set");
    }

    @Test
    @DisplayName("complement(): complement with empty set returns empty set")
    public void testComplementWithEmptySet() {
        IntegerSet setA = new IntegerSet();
        IntegerSet setB = new IntegerSet();
        setA.add(1);
        IntegerSet complementSet = setA.complement(setB);
        assertEquals(0, complementSet.length(), "Complement with an empty set should result in an empty set");
    }

    @Test
    @DisplayName("complement(): disjoint sets return all elements from second set")
    public void testComplementDisjointSets() {
        IntegerSet setA = new IntegerSet();
        IntegerSet setB = new IntegerSet();
        setA.add(1);
        setA.add(2);
        setB.add(3);
        setB.add(4);
        IntegerSet complementSet = setA.complement(setB);
        assertTrue(complementSet.contains(3), "Complement should contain elements that are only in the second set");
        assertTrue(complementSet.contains(4), "Complement should contain elements that are only in the second set");
        assertFalse(complementSet.contains(1), "Complement should not contain elements that are only in the first set");
        assertFalse(complementSet.contains(2), "Complement should not contain elements that are only in the first set");
        assertEquals(2, complementSet.length(), "Complement should have the correct number of unique elements from the second set");
    }

    // ------------------------------------------------------------------ //
    // isEmpty()
    // ------------------------------------------------------------------ //

    @Test
    @DisplayName("isEmpty(): returns true for empty set")
    public void testIsEmptyOnEmptySet() {
        IntegerSet set = new IntegerSet();
        assertTrue(set.isEmpty(), "isEmpty should return true for an empty set");
    }

    @Test
    @DisplayName("isEmpty(): returns false for non-empty set")
    public void testIsEmptyOnNonEmptySet() {
        IntegerSet set = new IntegerSet();
        set.add(1);
        assertFalse(set.isEmpty(), "isEmpty should return false for a non-empty set");
    }

    // ------------------------------------------------------------------ //
    // toString()
    // ------------------------------------------------------------------ //

    @Test
    @DisplayName("toString(): empty set formats as []")
    public void testToStringEmptySet() {
        IntegerSet set = new IntegerSet();
        assertEquals("[]", set.toString(), "toString of an empty set should be []");
    }

    @Test
    @DisplayName("toString(): non-empty set formats in ascending order")
    public void testToStringNonEmptySet() {
        IntegerSet set = new IntegerSet();
        set.add(3);
        set.add(1);
        set.add(2);
        assertEquals("[1, 2, 3]", set.toString(), "toString should return a sorted list of elements in the set");
    }
}