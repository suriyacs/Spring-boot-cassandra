package com.example.demo.service.base;

import java.util.List;
import java.util.Map;

import javax.ws.rs.Path;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;
import javax.ws.rs.core.MediaType;

import org.springframework.stereotype.Component;

import com.example.demo.model.User;

@Component
@Path("/api")
public interface ExampleService {
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    @Path("/get-users/{userId}")
    List<User> getUserById(@PathParam("userId") int userId);
}
