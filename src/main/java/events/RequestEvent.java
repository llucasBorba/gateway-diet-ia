package events;

import java.time.Instant;

public record RequestEvent(
        long id,
        int age,
        long weight,
        long height,
        String caloricGoal,
        Instant createdAt) {}
