package com.example.TODO.Comment;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@EqualsAndHashCode
@Data
public class AddCommentDTO {
    private String commentText;

    public static AddCommentDTO from(Comment comment){
        AddCommentDTO dto = new AddCommentDTO();
        dto.setCommentText(comment.getCommentText());
        return dto;
    }
}
