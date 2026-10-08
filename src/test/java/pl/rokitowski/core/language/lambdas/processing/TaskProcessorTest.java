package pl.rokitowski.core.language.lambdas.processing;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.rokitowski.core.language.lambdas.model.Task;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;

import static org.assertj.core.api.Assertions.assertThat;


class TaskProcessorTest {
    @Test
    @DisplayName("Zwrócone wartości jeśli dane są poprawne")
    void shouldReturnInfo(){
        // 1. arrange
        Task task = new Task("Task One", 3 ,false, LocalDate.now());

        List<Task> mockDb = new ArrayList<>();

        Function<Task, Task> modifier = t -> {
            t.setTitle(t.getTitle() + " [DONE]");
            t.setCompleted(true);
            return t;
        };

        Consumer<Task> notifier = t -> mockDb.add(t);

        // 2. act
        TaskProcessor.processTask(task, modifier, notifier);

        // 3. assert
        assertThat(mockDb).hasSize(1);

        Task savedTask = mockDb.get(0);
        assertThat(savedTask.getTitle()).endsWith("[DONE]");
        assertThat(savedTask.isCompleted()).isTrue();
    }
}