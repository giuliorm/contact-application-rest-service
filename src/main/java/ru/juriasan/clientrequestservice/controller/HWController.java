package ru.juriasan.clientrequestservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.ServletException;
import java.sql.*;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/")
public class HWController {

    @GetMapping(value = "/")
    public String HW() {
        return "Hello W!";
    }

}
