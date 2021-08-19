package edu.escuelaing.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import edu.escuelaing.ieti.data.User;
import edu.escuelaing.ieti.dto.UserDto;
import edu.escuelaing.ieti.services.UserService;
import java.util.List;

@RestController
@RequestMapping("api/v1/")
public class UserController {

    private final UserService userServices;

    public UserController(@Autowired UserService userService) {
        this.userServices = userService;
    }

    @GetMapping()
    public ResponseEntity<List<User>> all() {
        try {
            return ResponseEntity.ok().body(userServices.all());
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @GetMapping("/{id}")
    public ResponseEntity<User> findById(@PathVariable String id) {
        try {
            return ResponseEntity.ok().body(userServices.findById(id));
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PostMapping
    public ResponseEntity<User> create(@RequestBody UserDto userDto) {
        try {
            User newUser = new User("", userDto.getName(), userDto.getLastName(), userDto.getEmail(),
                    userDto.getCreated());
            userServices.create(newUser);
            return ResponseEntity.ok().body(newUser);

        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @PutMapping("/{id}")
    public ResponseEntity<User> update(@RequestBody UserDto userDto, @PathVariable String id) {
        try {
            User user = userServices.findById(id);
            if (user != null) {
                user.setName(userDto.getName());
                user.setLastName(userDto.getLastName());
                user.setEmail(userDto.getEmail());
                user.setCreated(userDto.getCreated());
                return ResponseEntity.ok().body(userServices.update(user, id));
            } else
                return ResponseEntity.status(404).build();
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Boolean> delete(@PathVariable String id) {
        try {
            boolean deleted = false;
            userServices.deleteById(id);
            deleted = userServices.findById(id) != null ? false : true;
            return ResponseEntity.ok().body(deleted);
        } catch (Exception e) {
            return ResponseEntity.status(500).build();
        }
    }
}
