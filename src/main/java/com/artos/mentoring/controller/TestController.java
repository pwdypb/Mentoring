package com.artos.mentoring.controller;

import com.artos.mentoring.dao.UserDao;
import com.artos.mentoring.model.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

@Controller
public class TestController {

    private static final String INDEX_MAPPING = "/";
    private static final String INDEX_VIEW = "index";
    private static final String SPEC_MAPPING = "/test";
    private static final String SPEC_VIEW = "test";
    private static final String TEST_ATTRIBUTE = "testList";

    @Autowired
    private UserDao userDao;

    @RequestMapping(value = INDEX_MAPPING)
    public String index(Model model) {
        return INDEX_VIEW;
    }

    @RequestMapping(value = SPEC_MAPPING)
    public String test(Model model) {
        List<Integer> testList = Arrays.asList(1, 2, 3);
        model.addAttribute(TEST_ATTRIBUTE, testList);
        return SPEC_VIEW;
    }

    @RequestMapping(value = "/create")
    @ResponseBody
    public String create(String email) {
        User user = new User(email);

        userDao.save(user);

        return "User successfully created! (email: " + user.getEmail() + ")";
    }

    @RequestMapping(value = "/delete")
    @ResponseBody
    public String delete(String email) {
        User user = userDao.findByEmail(email);

        userDao.delete(user);

        return "User successfully deleted";
    }

    @RequestMapping(value = "/get")
    @ResponseBody
    public String getAll() {
        Iterable<User> users = userDao.findAll();

        return StreamSupport.stream(users.spliterator(), false)
            .map(User::getEmail)
            .collect(Collectors.joining(", "));
    }
}
