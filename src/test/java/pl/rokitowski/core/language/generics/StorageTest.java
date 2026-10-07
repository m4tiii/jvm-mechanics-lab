package pl.rokitowski.core.language.generics;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.*;

class StorageTest {

    @Test
    @DisplayName("Sprawdzenie sumowania liczb zmiennoprzecinkowych")
    void shouldAddNumberToList(){
        // 1. arrange
        Storage<Double> storage = new Storage<>();

        // 2. act
        storage.add(10.5);

        // 3. assert
        assertThat(storage.sum()).isEqualTo(10.5);
    }

    @Test
    @DisplayName("Gdy magazyn jest pusty powinno zwrócić 0.0")
    void shouldReturnZeroWhenStorageIsEmpty(){
        // 1. act
        Storage<Integer> storage = new Storage<>();

        // 2. act & assert
        assertThat(storage.average()).isEqualTo(0);
    }

    @Test
    @DisplayName("Sprawdzenie czy porówna magazyny o różnych typach")
    void shouldReturnTrueWhenCompareOfDifferentStorageTypes(){
        // 1. arrange
        Storage<Integer> integerStorage = new Storage<>();
        integerStorage.add(7);
        integerStorage.add(2);

        Storage<Double> doubleStorage = new Storage<>();
        doubleStorage.add(10.5);
        doubleStorage.add(8.2);

        // 2. act & arrange
        assertThat(doubleStorage.hasGreaterThanAverage(integerStorage)).isTrue();
        assertThat(integerStorage.hasGreaterThanAverage(doubleStorage)).isFalse();
    }

    @Test
    @DisplayName("Sprawdzenie czy wyrzuci wyjątek jeśli wartość dodawana jest null")
    void shouldThrowExceptionWhenAddedValueIsNull(){
        // 1. arrange
        Storage<Integer> storage = new Storage<>();

        // 2. act & assert
        assertThatThrownBy(() -> storage.add(null))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("Element nie może być null");
    }
}