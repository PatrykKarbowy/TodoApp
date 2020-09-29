package com.example.TODO.Todo;

import com.example.TODO.Commands.CreateTaskCommand;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import javax.ws.rs.Consumes;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@RestController
@RequestMapping("api/todo")
@Slf4j
@RequiredArgsConstructor
public class TodoAPI {
    @Autowired
    private TodoService todoService;

    @PostMapping("/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@Valid @RequestBody CreateTaskCommand task) throws Exception{
        Response result;
        try{
            AddTaskDTO dto = todoService.addNewTask(task);
            result = Response.status(Response.Status.OK).entity(dto).build();
        }
        catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
        return result;
    }

    @GetMapping("show")
    public Response showAll() throws Exception{
        Response result;
        try{
            todoService.findAll();
            result = Response.status(Response.Status.OK).entity(todoService.findAll()).build();
        }
        catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
        return result;
    }


}
