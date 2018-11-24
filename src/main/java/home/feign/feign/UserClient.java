package home.feign.feign;

import home.feign.model.User;
import org.springframework.web.bind.annotation.*;

import java.util.List;

public interface UserClient {

    @PostMapping("/users")
    User createUser(User user);

    @GetMapping("/users")
    List<User> getUsers();

    @GetMapping("/users/{userId}")
    User getUser(@PathVariable("userId") Long userId);

    @PutMapping("/users/{userId}")
    User updateUser(@PathVariable("userId") Long userId, User user);

    @DeleteMapping("/users/{userId}")
    void deleteUser(@PathVariable("userId") Long userId);
}