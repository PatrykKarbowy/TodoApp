package com.example.TODO.Comment;

import com.example.TODO.Commands.CreateCommentCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Slf4j
@RestController
@RequestMapping("/api/comment")
@RequiredArgsConstructor
public class CommentAPI {
    @Autowired
    private CommentService commentService;

    @PostMapping("/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@Valid @RequestBody CreateCommentCommand command) throws Exception{
        Response result;
        try{
            commentService.addNewComment(command);
            result = Response.status(Response.Status.OK).build();
        }
        catch (Exception ex){
            throw  new Exception(ex.getMessage());
        }
        return result;
    }
}
