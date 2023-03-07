package study;


import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class CalculatorTest {

    public void 문자열계산기() throws Exception {
        // given
        // Scanner scanner = new Scanner(System.in); // 2 + 3 * 4 / 2
        // String input = scanner.nextLine();
        String input = "2 + 3 * 4 / 2";
        String[] values = input.split(" "); // [2][+][3][*][4][/][2]

        // when
        int result = Integer.parseInt(values[0]);
        for (int i = 1; i < values.length; i += 2) {
            int number = Integer.parseInt(values[i + 1]);
            switch (values[i]) {
                case "+":
                    result += number;
                    break;
                case "-":
                    result -= number;
                    break;
                case "*":
                    result *= number;
                    break;
                case "/":
                    result /= number;
                    break;
                default:
                    throw new IllegalArgumentException("지원하지 않는 연산자입니다.");
            }
        }
        // then
        assertThat(result).isEqualTo(10);
    }

    @Test
    void testCalculate() {
        Calculator calculator = new Calculator();
        String input = "2 + 3 * 4 / 2";
        int result = calculator.calculate(input);
        assertEquals(10, result);
    }

    @Test
    void testCalculateWithNegativeNumber() {
        Calculator calculator = new Calculator();
        String input = "2 + -3 * 4 / 2";
        int result = calculator.calculate(input);
        assertEquals(-4, result);
    }
}
