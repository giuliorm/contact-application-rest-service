package ru.juriasan.clientrequestservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/")
public class HWController {

    @GetMapping(value = "/")
    public String HW () {
        return "Hello W!";
    }
}
