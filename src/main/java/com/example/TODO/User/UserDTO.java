package com.example.TODO.User;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
public class UserDTO {

    private String nickname;
    private String firstName;
    private String lastName;

    public static UserDTO from(User user){
        UserDTO dto = new UserDTO();
        dto.setNickname(user.getNickname());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        return dto;
    }
}
