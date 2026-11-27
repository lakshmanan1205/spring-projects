package com.lionel.library_management_v1.rest;

import com.lionel.library_management_v1.dto.user.UserRequest;
import com.lionel.library_management_v1.dto.user.UserResponse;
import com.lionel.library_management_v1.service.UserService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/users")
public class UserController {
    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping
    public List<UserResponse> getAllUsers(){
        return userService.findAll();
    }

    @GetMapping("/{id}")
    public UserResponse getUser(@PathVariable Integer id){
      return userService.findByID(id);
    }

    @PostMapping
    public UserResponse createUser(@RequestBody UserRequest user){
        return userService.save(user);
    }

//    @PutMapping
//    public  UserResponse updateUser(@RequestBody UserRequest user){
//        return userService.update(user);
//    }
}
