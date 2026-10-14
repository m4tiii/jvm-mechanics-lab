package pl.rokitowski.core.language.events;

import org.junit.jupiter.api.Test;

import java.time.Instant;

import static org.junit.jupiter.api.Assertions.*;

class EventBusTest {
    record OrderPaidEvent(double amount, Instant occurredAt) implements Event{
        @Override
        public Instant occuredAt() {
            return Instant.now();
        }
    }

    @Test
    void shouldHandleFilteredEvents(){
        EventBus bus = new EventBus();
        boolean[] executed = {false};

        bus.subscribe(
                OrderPaidEvent.class,
                a -> a.amount() > 1000,
                event -> executed[0] = true
        );

        bus.publish(new OrderPaidEvent(200.0, Instant.now()));

        assertFalse(executed[0]);

        bus.publish(new OrderPaidEvent(1500.0, Instant.now()));

        assertTrue(executed[0]);
    }

    @Test
    void shouldNotifyGlobalListener(){
        EventBus eventBus = new EventBus();
        int[] callCount = {0};

        eventBus.subscribe(Event.class, event -> callCount[0]++);

        eventBus.publish(new OrderPaidEvent(100.0, Instant.now()));

        assertEquals(1, callCount[0]);
    }



}