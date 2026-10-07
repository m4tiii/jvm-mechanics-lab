package pl.rokitowski.core.language.generics;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.assertj.core.api.Assertions.assertThatThrownBy;

class ResultTest {
    @Test
    @DisplayName("Gdy operacja się uda, getData powinno zwrócić poprawną wartość")
    void shouldReturnDataOnSuccess(){
        // 1. Arrange & act: Tworzymy sukces z liczbą 42
        Result<Integer, String> result = Result.success(42);

        // 2. Assert: sprawdzamy asercjami czy wszystko jest ok
        assertThat(result.isSuccess).isTrue();
        assertThat(result.getData()).isEqualTo(42);
        assertThat(result.orElse(0)).isEqualTo(42);
    }

    @Test
    @DisplayName("Gdy jest błąd, getData powinno zarzucić wyjątek z komunikatem błędu")
    void shouldThrownExceptionWhenGettingDataFromFailure(){
        // 1. Arrange: Tworzymy błąd
        Result<Integer, String> result = Result.failure("Brak połączenia z bazą");

        // 2. Assert stanu błędu
        assertThat(result.isSuccess).isFalse();
        assertThat(result.getError()).isEqualTo("Brak połączenia z bazą");

        // 3. Assert metody ratunkowej orElse, ma zwrócić 999 zamias rzucić błąd
        assertThat(result.orElse(999)).isEqualTo(999);

        // 4. Assert wyjątku: sprawdzamy czy wywołanie getData rzuci IllegalStateException
        assertThatThrownBy(() -> result.getData())
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("Nie można pobrać danych, bo opercja zakończyła się niepowodzeniem");
    }

    @Test
    @DisplayName("Gdy jest sukces, próba pobrania błędu powinna rzucić wyjątek")
    void shouldThrowExceptionWhenGettingErrorFromSuccess(){
        Result<String, String> result = Result.success("Wszystko ok");

        assertThatThrownBy(() -> result.getError())
                .isInstanceOf(IllegalStateException.class)
                .hasMessageContaining("Nie można pobrać błędu, bo operacja zakończyła się powodzeniem");
    }
}



