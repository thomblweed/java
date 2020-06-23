package com.thomblweed.userservice.user;

import java.net.URI;
import java.util.List;
import javax.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
@RequestMapping("/users")
public class UserResource {

    @Autowired
    private UserDaoService userService;

    @GetMapping(path = "/getAll")
    public List<User> getAllUsers() {
        return userService.getAllUsers();
    }

    @GetMapping(path = "/{id}")
    public User getUserById(@PathVariable int id) {
        User user = userService.findById(id);
        if (user == null) {
            throw new UserNotFoundException("id : " + id);
        }
        return user;
    }

    @DeleteMapping(path = "/{id}")
    public void deleteUserById(@PathVariable int id) {
        User user = userService.deleteById(id);

        if (user == null) {
            throw new UserNotFoundException("id : " + id);
        }
    }

    @PostMapping(path = "/newUser", produces = "application/json")
    public ResponseEntity<Object> createUser(@Valid @RequestBody(required = false) User user) {

        if (user == null || user.getName() == null || user.getBirthDate() == null) {
            throw new BadRequestException(
                    "Request body for new User is null or missing required parameters");
        }

        User newUser = userService.save(user);
        URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}")
                .buildAndExpand(newUser.getId()).toUri();

        return ResponseEntity.created(location).build();
    }
}
