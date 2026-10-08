package pl.rokitowski.core.language.lambdas.sorting;

import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import pl.rokitowski.core.language.lambdas.model.Task;

import java.time.LocalDate;
import java.util.Arrays;
import java.util.List;

import static org.assertj.core.api.Assertions.assertThat;

class TaskSorterTest {
    @Test
    @DisplayName("Powinien posortować backlog zgodnie z regułami: status -> priorytet -> data (null na końcu) -> tytuł")
    void shouldSortBacklogCorrectly() {
        // 1. arrange
        Task t1 = new Task("Zadanie na wczoraj", 1, false, LocalDate.now().minusDays(1));
        Task t2 = new Task("Nieważne i zrobione", 5, true, LocalDate.now());
        Task t3 = new Task("Ważne bez terminu", 1, false, null);
        Task t4 = new Task("Zadanie na jutro", 1, false, LocalDate.now().plusDays(1));
        Task t5 = new Task("a zadanie z małej litery", 1, false, null);

        List<Task> backLog = Arrays.asList(t1,t2,t3,t4,t5);

        // 2. act

        backLog.sort(TaskSorter.getBackLogComparator());

        assertThat(backLog)
                .extracting(Task::getTitle)
                .containsExactly(
                        "Zadanie na wczoraj",
                        "Zadanie na jutro",
                        "a zadanie z małej litery",
                        "Ważne bez terminu",
                        "Nieważne i zrobione"
                );
    }
}