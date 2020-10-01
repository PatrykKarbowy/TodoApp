package com.example.TODO.Comment;

import com.example.TODO.Commands.CreateCommentCommand;
import com.example.TODO.Todo.Todo;
import com.example.TODO.Todo.TodoRepository;
import com.example.TODO.User.User;
import com.example.TODO.User.UserRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
@RequiredArgsConstructor
public class CommentService {
    @Autowired
    private CommentRepository commentRepository;
    @Autowired
    private TodoRepository todoRepository;
    @Autowired
    private UserRepository userRepository;

    public List<Comment> findAll(){
        return commentRepository.findAll();
    }
    public Optional<Comment> findById(Long id){
        return commentRepository.findById(id);
    }

    public void addNewComment(CreateCommentCommand comment){
        Optional<Todo> taskOptional = todoRepository.findById(comment.getTaskId());
        Todo todo = new Todo();
        if(taskOptional.isPresent()){
            todo = taskOptional.get();
        }
        Optional<User> userOptional = userRepository.findById(comment.getUserId());
        User user = new User();
        if(userOptional.isPresent()){
            user = userOptional.get();
        }
        Comment commentText = Comment.builder().commentText(comment.getCommentText()).build();
        commentRepository.save(commentText);
        if(user != null && todo != null){
            todo.getComments().add(commentText);
            user.getComments().add(commentText);
            userRepository.save(user);
            todoRepository.save(todo);
        }
    }

}
