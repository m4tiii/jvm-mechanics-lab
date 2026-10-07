package pl.rokitowski.core.language.generics;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ArrayUtilsTest {

    @Test
    @DisplayName("Zmiana miejscami elementów tablicy")
    void shouldSwapNumbersInArray(){

        // 1. arrange
        Integer[] array = {1,2,4,3,5};
        int i = 2;
        int j = 3;

        // 2. act
        ArrayUtils.swap(array, i,j);

        // 3. Assert
        assertThat(array).containsExactly(1,2,3,4,5);
    }

    @Test
    @DisplayName("Znalezienie maxa w zbiorze liczb")
    void shouldReturnMaxNumber(){
        // 1. arrange
        String[] names = {"Tomasz", "Adam", "Zofia"};

        // 2. act & assert
        assertThat(ArrayUtils.findMax(names)).isEqualTo("Zofia");
    }

    @Test
    @DisplayName("Sprawdzenie czy wyrzuci wyjątek przy pustej tablicy w funkcji findMax")
    void shouldThrowExceptionWhenArrayIsBlank(){
        // 1. arrange
        Integer[] emptyArray = {};

        // 3. act & assert
        assertThatThrownBy(() -> ArrayUtils.findMax(emptyArray))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Tablica nie może być pusta lub null");
    }

    @Test
    @DisplayName("Zliczenie elementów większych od zadanej liczby")
    void shouldCountElementsWhenArrayElementIsGreaterThanNumber(){
        // 1. arrange
        int number = 5;
        Integer[] array = {1,7,3,6,8,2,3,7};

        // 2. act
        int count = ArrayUtils.countGreaterThan(array, number);

        // 3. assert
        assertThat(count).isEqualTo(4);
    }
}