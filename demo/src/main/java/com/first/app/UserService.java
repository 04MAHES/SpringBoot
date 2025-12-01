package com.first.app;

import com.first.app.exceptions.UserNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class UserService {
    private Map<Integer, User> userMap = new HashMap<>();

    public User createUser(User user) {
        System.out.println(user.getEmail());
        userMap.putIfAbsent(user.getId(), user);
        return  user;
    }

    public User updateUser(User user) {
        if(!userMap.containsKey(user.getId()))
            throw new UserNotFoundException("User not found: "+ user.getId());
        return userMap.put(user.getId(), user);
    }

    public boolean deleteUser(int id) {
        if(!userMap.containsKey(id))
            throw new UserNotFoundException("User not found: "+ id);
        userMap.remove(id);
        return true;
    }

    public List<User> getAllUser() {
        return new ArrayList<>(userMap.values());
    }

    public User getUserById(int id) {
        if(!userMap.containsKey(id))
            return null;
        return userMap.get(id);
    }
}
