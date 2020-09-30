package com.example.TODO.User;

import com.example.TODO.Commands.AssignTaskToUserCommand;
import com.example.TODO.Commands.CreateUserCommand;
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
@RequestMapping("api/user")
@Slf4j
@RequiredArgsConstructor
public class UserAPI {
    @Autowired
    private UserService userService;

    @PostMapping("/add")
    @Produces(MediaType.APPLICATION_JSON)
    @Consumes(MediaType.APPLICATION_JSON)
    public Response create(@Valid @RequestBody CreateUserCommand user) throws Exception{
        Response result;
        try{
            UserDTO dto = userService.addNewUser(user);
            result = Response.status(Response.Status.OK).entity(dto).build();
        }
        catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
        return result;
    }

    @GetMapping("/show")
    public Response showAll() throws Exception{
        Response result;
        try{
            userService.findAll();
            result = Response.status(Response.Status.OK).entity(userService.findAll()).build();
        }
        catch(Exception ex){
            throw new Exception(ex.getMessage());
        }
        return result;
    }

    @PostMapping("/assign")
    public Response assignTask(@Valid @RequestBody AssignTaskToUserCommand assign) throws Exception{
        Response result;
        try{
            userService.assignTaskToUser(assign);
            result = Response.status(Response.Status.OK).build();
        }
        catch (Exception ex){
            throw  new Exception(ex.getMessage());
        }
        return result;
    }

}
