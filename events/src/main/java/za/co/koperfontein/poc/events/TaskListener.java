package za.co.koperfontein.poc.events;

import lombok.extern.slf4j.Slf4j;
import org.eclipse.microprofile.reactive.messaging.Incoming;
import za.co.koperfontein.poc.domain.Task;
import za.co.koperfontein.poc.service.TaskService;

import javax.enterprise.context.ApplicationScoped;
import javax.inject.Inject;

@ApplicationScoped
@Slf4j
public class TaskListener {
    @Inject TaskService taskService;
    @Incoming("receiver-events")
    public void consume(Task task) {
        taskService.addTask(task);
    }
}
