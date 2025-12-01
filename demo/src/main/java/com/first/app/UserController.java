package com.first.app;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalTime;
import java.util.*;

@RestController
@RequestMapping("/user")
public class UserController {

    private Map<Integer, User> userMap = new HashMap<>();

    private UserService userService;

    public UserController(UserService userService) {
        this.userService = userService;
    }

    @GetMapping("/hello")
    public String resHello() {
        return "Hello World!";
    }

    @GetMapping("/user")
    public User resUser(){
        User user = new User(1,"springboot", "boot@exmaple.com");
        return user;
    }

    @RequestMapping(value = "/users", method = RequestMethod.GET)
    public Map<Integer, User> User(){
        return userMap;
    }

//    Get all Users
    @GetMapping
    public ResponseEntity<List<User>> getAllUser() {
        List<User> getAllUsers = userService.getAllUser();
        if(getAllUsers == null)
            return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
        return ResponseEntity.ok(getAllUsers);
    }

//    Get User by UserId
    @GetMapping("/{userId}")
    public ResponseEntity<User> getUserById(@PathVariable("userId") int id) {
        User userById = userService.getUserById(id);
        if(userById == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(userById);
    }

//    Create New User
    @PostMapping
    public ResponseEntity<User> addUser(@RequestBody User user) {
        User createUser = userService.createUser(user);
//        userMap.putIfAbsent(user.getId(), user);
        return ResponseEntity.ok(createUser);
    }

//  Update the User
    @PutMapping
    public ResponseEntity<String> updataUser(@RequestBody User user) {
        User updateUser = userService.updateUser(user);
        if(updateUser == null)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok("User Data Updated Successfully: " + updateUser.getName());
    }

//    Delete User By Id
    @DeleteMapping("/{userId}")
    public ResponseEntity<String> deleteUser(@PathVariable("userId") int id){
        boolean status = userService.deleteUser(id);
        if(!status)
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok("User deleted Successfully: "+ id);
    }


    @GetMapping("/user/{userID}/order/{orderID}")
    public ResponseEntity<User> getUserAndOrder(
            @PathVariable("userID") int id,
            @PathVariable int orderID
    ){
        System.out.println("OrderID: " + orderID);
        if(!userMap.containsKey(id))
            return ResponseEntity.status(HttpStatus.NOT_FOUND).build();
        return ResponseEntity.ok(userMap.get(id));
    }

    // We can define multiple end point in same function
    //    @GetMapping({"/user","/user/{id}"})

    @GetMapping("/search")
    public ResponseEntity<List<User>> getSpecificUser(@RequestParam String name) {
        System.out.println("Name: " + name);
        List<User> users = userMap.values().stream()
                .filter( user -> user.getName().equalsIgnoreCase(name))
                .toList();
        return ResponseEntity.ok(new ArrayList<User>(users));
    }

}
