package pl.rokitowski.core.language.events;

import java.time.Instant;

public interface Event {
    Instant occuredAt();
}
