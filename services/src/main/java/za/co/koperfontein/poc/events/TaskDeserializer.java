package za.co.koperfontein.poc.events;

import io.quarkus.kafka.client.serialization.JsonbDeserializer;
import za.co.koperfontein.poc.domain.Task;

public class TaskDeserializer  extends JsonbDeserializer<Task> {
    public TaskDeserializer() {
        super(Task.class);
    }
}
