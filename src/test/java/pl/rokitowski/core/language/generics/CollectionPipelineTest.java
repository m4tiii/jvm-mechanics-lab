package pl.rokitowski.core.language.generics;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class CollectionPipelineTest {
    @Test
    @DisplayName("Sprawdzenie poprawności kopiowania listy do nadtypu")
    void shouldCopyList(){
        // 1. arrange
        List<Integer> integerList = new ArrayList<>();
        integerList.add(1);
        integerList.add(3);
        integerList.add(5);

        List<Number> numbers = new ArrayList<>();

        // 2. act

        CollectionPipeline.copyAll(integerList, numbers);

        // 3. assert
        assertThat(numbers).containsExactly(1,3,5);
    }

    @Test
    @DisplayName("Sprawdzenie poprawności filtrowania z nadrzędnym predykantem")
    void shouldCopyAllNumbersThatAreEven(){
        // 1. arrange
        List<Integer> ints = List.of(1,2,3);
        List<Number> nums = new ArrayList<>();
        Predicate<Number> isEven = n -> n.intValue()%2 ==0;

        // 2. act
        CollectionPipeline.filterAndTransfer(ints, nums, isEven);

        // 3. assert
        assertThat(nums).containsExactly(2);
    }

    @Test
    @DisplayName("Sprawdzenie czy jak przekaże null to rzuci błąd")
    void shouldThrowExceptionWhenNullValueIsGiven(){
        // 1. arrange
        List<Integer> integerList = null;


        List<Number> numbers = new ArrayList<>();

        // 2. act & assert

        assertThatThrownBy(() -> CollectionPipeline.copyAll(integerList, numbers))
                .isInstanceOf(IllegalArgumentException.class)
                .hasMessageContaining("List nie mogą być null");
    }
}