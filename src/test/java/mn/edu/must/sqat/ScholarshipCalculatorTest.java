package mn.edu.must.sqat;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertThrows;

import org.junit.jupiter.api.Test;

class ScholarshipCalculatorTest {

    private final ScholarshipCalculator calc = new ScholarshipCalculator();

    // ---- letterGrade ----
    @Test
    void letterGradeHappyA() {
        assertEquals("A", calc.letterGrade(95));
    }

    @Test
    void letterGradeHappyB() {
        assertEquals("B", calc.letterGrade(85));
    }

    @Test
    void letterGradeHappyC() {
        assertEquals("C", calc.letterGrade(75));
    }

    @Test
    void letterGradeHappyD() {
        assertEquals("D", calc.letterGrade(65));
    }

    @Test
    void letterGradeHappyF() {
        assertEquals("F", calc.letterGrade(30));
    }

    @Test
    void letterGradeBelowZeroThrows() {
        assertThrows(IllegalArgumentException.class, () -> calc.letterGrade(-1));
    }

    @Test
    void letterGradeAbove100Throws() {
        assertThrows(IllegalArgumentException.class, () -> calc.letterGrade(101));
    }

    // ---- gpa ----
    @Test
    void gpaHappyTwoScores() {
        assertEquals(3.5, calc.gpa(new double[]{95, 85}), 0.0001);
    }

    @Test
    void gpaAllGradeTypes() {
        assertEquals(2.0, calc.gpa(new double[]{95, 85, 75, 65, 30}), 0.0001);
    }

    @Test
    void gpaNullThrows() {
        assertThrows(IllegalArgumentException.class, () -> calc.gpa(null));
    }

    @Test
    void gpaEmptyThrows() {
        assertThrows(IllegalArgumentException.class, () -> calc.gpa(new double[]{}));
    }

    // ---- scholarship ----
    @Test
    void scholarshipHappyFull() {
        assertEquals(100, calc.scholarship(3.9, 16, false));
    }

    @Test
    void scholarshipHappyHalf() {
        assertEquals(50, calc.scholarship(3.1, 10, false));
    }

    @Test
    void scholarshipNegativeGpaThrows() {
        assertThrows(IllegalArgumentException.class, () -> calc.scholarship(-0.1, 10, false));
    }

    @Test
    void scholarshipGpaAboveFourThrows() {
        assertThrows(IllegalArgumentException.class, () -> calc.scholarship(4.1, 10, false));
    }

    @Test
    void scholarshipNegativeCreditsThrows() {
        assertThrows(IllegalArgumentException.class, () -> calc.scholarship(3.0, -1, false));
    }

    @Test
    void scholarshipViolationGivesZero() {
        assertEquals(0, calc.scholarship(3.9, 16, true));
    }

    @Test
    void scholarshipHighGpaLowCreditsSeventy() {
        assertEquals(70, calc.scholarship(3.9, 14, false));
    }

    @Test
    void scholarshipSeventy() {
        assertEquals(70, calc.scholarship(3.5, 12, false));
    }

    @Test
    void scholarshipGoodGpaLowCreditsFifty() {
        assertEquals(50, calc.scholarship(3.5, 11, false));
    }

    @Test
    void scholarshipLowGpaZero() {
        assertEquals(0, calc.scholarship(2.5, 10, false));
    }

    // ---- Хэсэг C: gpa() давталтын заагууд (0 / 1 / 2+ удаа) ----
    @Test
    void gpaLoopZeroIterationsThrows() {
        assertThrows(IllegalArgumentException.class, () -> calc.gpa(new double[]{}));
    }

    @Test
    void gpaLoopOneIteration() {
        assertEquals(4.0, calc.gpa(new double[]{95}), 0.0001);
    }

    @Test
    void gpaLoopManyIterations() {
        assertEquals(3.0, calc.gpa(new double[]{85, 85, 85}), 0.0001);
    }

    // ---- Хэсэг D: letterGrade зааг утгууд (спецификаци: 60-69.99 = D) ----
    @Test
    void letterGradeBoundary60IsD() {
        assertEquals("D", calc.letterGrade(60));
    }

    @Test
    void letterGradeBoundary5999IsF() {
        assertEquals("F", calc.letterGrade(59.99));
    }

    @Test
    void letterGradeBoundary6999IsD() {
        assertEquals("D", calc.letterGrade(69.99));
    }

    @Test
    void letterGradeBoundary0IsF() {
        assertEquals("F", calc.letterGrade(0));
    }

    @Test
    void letterGradeBoundary100IsA() {
        assertEquals("A", calc.letterGrade(100));
    }

    @Test
    void letterGradeBoundary8999IsB() {
        assertEquals("B", calc.letterGrade(89.99));
    }

    @Test
    void letterGradeBoundary90IsA() {
        assertEquals("A", calc.letterGrade(90));
    }
}
