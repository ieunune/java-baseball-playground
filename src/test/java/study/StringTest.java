package study;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.util.HashSet;
import java.util.Set;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;
import static org.junit.jupiter.api.Assertions.assertEquals;

public class StringTest {

    private Set<Integer> numbers;

    @BeforeEach
    void setUp() {
        numbers = new HashSet<>();
        numbers.add(1);
        numbers.add(1);
        numbers.add(2);
        numbers.add(3);
    }

    @Test
    void replace() {
        String actual = "abc".replace("b", "d");
        assertThat(actual).isEqualTo("adc");
    }

    @Test
    public void split_string_array() throws Exception {
        // given
        String numbers = "1,2";

        // when
        String[] results = numbers.split(",");

        // then
        assertThat(results).contains("1", "2");
    }

    @Test
    public void split_string_one() throws Exception {
        // given
        String numbers = "1";

        // when
        String[] results = numbers.split(",");

        // then
        assertThat(results).contains("1");
    }

    @Test
    public void split_bracket() throws Exception {
        // given
        String numbers = "(1,2)";

        // when
        String result = numbers.replaceAll("[()]", "");

        // then
        assertThat(result).isEqualTo("1,2");
    }

    @DisplayName("특정 위치의 문자를 가져올 때 범위를 벗어나면 예외 발생.")
    @Test
    public void getChar() throws Exception {
        // given
        String input = "abc";

        // when & then
        assertThatThrownBy(() -> {
            int index = 0;
            while(true) {
                input.charAt(index);
                index++;
            }
        }).isInstanceOf(StringIndexOutOfBoundsException.class)
                .hasMessageContaining("String index out of range: 3");
    }

    @Test
    public void checkSetSize() throws Exception {
        assertThat(numbers).hasSize(3);
    }

    @ParameterizedTest
    @ValueSource(ints = {1, 2, 3})
    void contains(int number) {
        assertThat(numbers.contains(number)).isTrue();
    }

    @ParameterizedTest
    @CsvSource(value = {"1:true","2:true","3:true","4:false","5:false"}, delimiter = ':')
    void containsOtherCase(int number, boolean expected) {
        assertEquals(expected, numbers.contains(number));
    }
}
