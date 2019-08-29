package com.example.hateoasDemo.resource;

import com.example.hateoasDemo.model.User;
import org.springframework.hateoas.mvc.ControllerLinkBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.Arrays;
import java.util.List;

@RestController
@RequestMapping("/hello")
public class HelloResource {

    @GetMapping(value = "/users",  produces = { "application/hal+json" })
    public List<User> getUsers() {
        User user1 = new User("abc", " 12345", "abc@gmail.com");
        user1.add(ControllerLinkBuilder.linkTo(HelloResource.class)
                .slash(user1.getName()).withSelfRel());
        User user2 = new User("xyz", " 98760", "xyz@gmail.com");
        user2.add(ControllerLinkBuilder.linkTo(HelloResource.class)
                .slash(user2.getName()).withSelfRel());

        return Arrays.asList(user1, user2);
        //List.of(user1, user2);
    }
}
