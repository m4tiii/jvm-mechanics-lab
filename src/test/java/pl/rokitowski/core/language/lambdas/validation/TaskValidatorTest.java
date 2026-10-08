package pl.rokitowski.core.language.lambdas.validation;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.rokitowski.core.language.lambdas.model.Task;

import java.time.LocalDate;
import java.util.function.Predicate;

import static org.assertj.core.api.Assertions.assertThat;


class TaskValidatorTest {
    @Test
    @DisplayName("Gdy task idealny zostanie sprawdzony powinno pzejść")
    void shouldReturnTask() {
        // 1. arrange
        Task task = new Task("Task1", 4, false, LocalDate.now());

        Predicate<Task> validator = TaskValidator.isValidForSave();

        // 2. act
        boolean result = validator.test(task);

        // 3. assert
        assertThat(result).isTrue();
    }

    @Test
    @DisplayName("Gdy priority nie jest pomiędzy 1 i 5 włącznie powinno odrzucić")
    void shouldReturnFalseWhenPriorityIsDifferentFromOneToFive() {
        // 1. arrange
        Task task = new Task("Task1", 7, false, LocalDate.now());

        Predicate<Task> validator = TaskValidator.isValidForSave();

        // 2. act
        boolean result = validator.test(task);

        // 3. assert
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Gdy task jest zakończony powinno zwrócić false")
    void shouldReturnFalseWhenTaskIsCompleted() {
        // 1. arrange
        Task task = new Task("Task1", 4, true, LocalDate.now());

        Predicate<Task> validator = TaskValidator.isValidForSave();

        // 2. act
        boolean result = validator.test(task);

        // 3. assert
        assertThat(result).isFalse();
    }

    @Test
    @DisplayName("Gdy task jest null powinno zwrócić false")
    void shouldReturnFalseWhenTaskIsNull() {
        // 1. arrange
        Task task = null;

        Predicate<Task> validator = TaskValidator.isValidForSave();

        // 2. act
        boolean result = validator.test(task);

        // 3. assert
        assertThat(result).isFalse();
    }
}