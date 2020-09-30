package com.example.TODO.User;

import com.example.TODO.Commands.AssignTaskToUserCommand;
import com.example.TODO.Commands.CreateUserCommand;
import com.example.TODO.Todo.Todo;
import com.example.TODO.Todo.TodoRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class UserService {
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private TodoRepository todoRepository;

    public List<User> findAll(){
        return userRepository.findAll();
    }

    public Optional<User> findById(Long id){
        return userRepository.findById(id);
    }

    public UserDTO addNewUser(CreateUserCommand user){
        User newUser = User.builder().nickname(user.getNickname()).lastName(user.getLastName()).firstName(user.getFirstName()).build();
        userRepository.save(newUser);
        return UserDTO.from(newUser);
    }

    public void assignTaskToUser(AssignTaskToUserCommand command){
        Optional<User> userOptional = userRepository.findById((command.getUserId()));
        User user = new User();
        if(userOptional.isPresent()){
            user = userOptional.get();
        }
        Optional<Todo> taskOptional = todoRepository.findById((command.getTaskId()));
        Todo todo = new Todo();
        if(taskOptional.isPresent()){
            todo = taskOptional.get();
        }
        assignTaskToTheUser(user, todo);
    }

    private void assignTaskToTheUser(User user, Todo todo){
        if(user != null && todo != null){
            user.getTasks().add(todo);
            userRepository.save(user);
        }
    }
}
