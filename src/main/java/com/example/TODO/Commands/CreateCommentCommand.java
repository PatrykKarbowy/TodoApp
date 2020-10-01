package com.example.TODO.Commands;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class CreateCommentCommand {
    private String commentText;
    private Long taskId;
    private Long userId;
}
