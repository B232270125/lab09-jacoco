package mn.edu.must.sqat;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

class ScholarshipCalculatorTest {

    private final ScholarshipCalculator calc = new ScholarshipCalculator();

    @Test
    void letterGradeHappyA() {
        assertEquals("A", calc.letterGrade(95));
    }

    @Test
    void letterGradeHappyC() {
        assertEquals("C", calc.letterGrade(75));
    }

    @Test
    void gpaHappyTwoScores() {
        assertEquals(3.5, calc.gpa(new double[]{95, 85}), 0.0001);
    }

    @Test
    void scholarshipHappyFull() {
        assertEquals(100, calc.scholarship(3.9, 16, false));
    }

    @Test
    void scholarshipHappyHalf() {
        assertEquals(50, calc.scholarship(3.1, 10, false));
    }
}
