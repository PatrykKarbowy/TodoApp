package com.example.TODO.Todo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class AddTaskDTO {

    private String topic;
    private String description;

    public static AddTaskDTO from(Todo todo){
        AddTaskDTO dto = new AddTaskDTO();
        dto.setDescription(todo.getDescription());
        dto.setTopic(todo.getTopic());
        return dto;
    }
}
