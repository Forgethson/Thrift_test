package com.forgethson;

import com.forgethson.java_gen.User;
import com.forgethson.java_gen.UserService;
import org.apache.thrift.TException;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

public class UserServiceImpl implements UserService.Iface {

    Random random = new Random();

    @Override
    public User getUserByName(String name) throws TException {
        User user = new User();
        user.setName(name);
        user.setId(0);
        ArrayList<String> hobbies = new ArrayList<>();
        hobbies.add("game");
        hobbies.add("basketball");
        user.setHobbies(hobbies);
        user.setScore(9.88);
        return user;
    }

    @Override
    public boolean createUser(User user) throws TException {
        System.out.println("createUser: " + user);
        return random.nextBoolean();
    }
}
