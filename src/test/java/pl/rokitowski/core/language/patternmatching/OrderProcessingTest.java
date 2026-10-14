package pl.rokitowski.core.language.patternmatching;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class OrderProcessingTest {
    sealed interface OrderStatus
            permits OrderStatus.Pending, OrderStatus.Shipped, OrderStatus.Cancelled {
        record Pending(int daysToShip) implements OrderStatus {
        }

        record Shipped(String trackingNumber) implements OrderStatus {
        }

        record Cancelled(String reason) implements OrderStatus {
        }
    }

    String formatStatus(OrderStatus status) {
        return switch (status) {
            case OrderStatus.Pending(int days) -> "Oczekuje: " + days + " dni";
            case OrderStatus.Shipped(String tracking) -> "Wysłano: " + tracking;
            case OrderStatus.Cancelled(String reason) -> "Anulowano: " + reason;
        };
    }

    @Test
    void shouldFormatDifferentStatuses() {
        assertEquals("Oczekuje: 3 dni", formatStatus(new OrderStatus.Pending(3)));
        assertEquals("Wysłano: DPD123", formatStatus(new OrderStatus.Shipped("DPD123")));
        assertEquals("Anulowano: brak towaru", formatStatus(new OrderStatus.Cancelled("brak towaru")));
    }
}