package org.howard.edu.lsp.finalexam.question3;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

import org.howard.edu.lsp.midterm.GradeCalculator;

/**
 * JUnit 5 test class for {@link GradeCalculator}.
 *
 * <p>Covers average(), letterGrade(), isPassing(), boundary values,
 * and exception cases.</p>
 */
public class GradeCalculatorTest {

    private GradeCalculator calculator;

    /** Initializes a fresh {@link GradeCalculator} before each test. */
    @BeforeEach
    public void setUp() {
        calculator = new GradeCalculator();
    }

    // ---------------------------------------------------------------
    // 1. average()
    // ---------------------------------------------------------------

    /** Tests that average() correctly computes the mean of three typical scores. */
    @Test
    public void testAverageOfThreeTypicalScores() {
        double result = calculator.average(80, 90, 70);
        assertEquals(80.0, result, 0.001);
    }

    // ---------------------------------------------------------------
    // 2. letterGrade()
    // ---------------------------------------------------------------

    /** Tests that letterGrade() returns the correct letter for each grade band. */
    @Test
    public void testLetterGradeForAllBands() {
        assertEquals("A", calculator.letterGrade(95));
        assertEquals("B", calculator.letterGrade(85));
        assertEquals("C", calculator.letterGrade(75));
        assertEquals("D", calculator.letterGrade(65));
        assertEquals("F", calculator.letterGrade(55));
    }

    // ---------------------------------------------------------------
    // 3. isPassing()
    // ---------------------------------------------------------------

    /** Tests that isPassing() returns true for a passing average and false for failing. */
    @Test
    public void testIsPassingReturnsTrueAbove60AndFalseBelow() {
        assertTrue(calculator.isPassing(75.0));
        assertFalse(calculator.isPassing(59.9));
    }

    // ---------------------------------------------------------------
    // 4. Boundary-value tests
    // ---------------------------------------------------------------

    /** Tests the exact boundary of 60.0 — the minimum passing average. */
    @Test
    public void testIsPassingAtExactBoundaryOf60() {
        assertTrue(calculator.isPassing(60.0));
    }

    /** Tests the exact boundary of 90.0 — minimum score for an "A". */
    @Test
    public void testLetterGradeAtExactBoundaryOf90() {
        assertEquals("A", calculator.letterGrade(90.0));
    }

    // ---------------------------------------------------------------
    // 5. Exception tests
    // ---------------------------------------------------------------

    /** Tests that average() throws IllegalArgumentException for a score above 100. */
    @Test
    public void testAverageThrowsExceptionForScoreAbove100() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.average(101, 50, 50));
    }

    /** Tests that average() throws IllegalArgumentException for a negative score. */
    @Test
    public void testAverageThrowsExceptionForNegativeScore() {
        assertThrows(IllegalArgumentException.class,
                () -> calculator.average(-1, 50, 50));
    }
}