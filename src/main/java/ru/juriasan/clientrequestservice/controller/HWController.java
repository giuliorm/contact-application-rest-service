package ru.juriasan.clientrequestservice.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HWController {

    @GetMapping(value = "/")
    public String HW () {
        return "HW";
    }
}
