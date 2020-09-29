package com.example.TODO.User;

import com.example.TODO.Commands.CreateUserCommand;
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
}
