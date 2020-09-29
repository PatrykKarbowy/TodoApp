package com.example.TODO.Todo;

import com.example.TODO.Commands.CreateTaskCommand;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.List;
import java.util.Optional;
@Service
@RequiredArgsConstructor
public class TodoService {
    @Autowired
    private TodoRepository todoRepository;

    public List<Todo> findAll(){
        return todoRepository.findAll();
    }
    public Optional<Todo> findById(Long id){
        return todoRepository.findById(id);
    }
    public AddTaskDTO addNewTask(CreateTaskCommand task){
        Todo newTask = Todo.builder().description(task.getDescription()).topic(task.getTopic()).build();
        todoRepository.save(newTask);
        return AddTaskDTO.from(newTask);
    }
}
