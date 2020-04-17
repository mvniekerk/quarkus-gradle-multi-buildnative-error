package za.co.koperfontein.poc.service;

import lombok.extern.slf4j.Slf4j;
import lombok.val;
import org.springframework.stereotype.Service;
import za.co.koperfontein.poc.domain.Task;
import za.co.koperfontein.poc.repository.TaskRepository;

import javax.inject.Inject;
import java.util.Optional;

@Service
@Slf4j
public class TaskService {
    @Inject TaskRepository taskRepository;

    public Task addTask(Task task) {
        val ret = new Task().setName(task.getName());
        return taskRepository.save(ret);
    }

    public Optional<Task> getTask(Long id) {
        return taskRepository.findById(id);
    }
}
