package ru.juriasan.clientrequestservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import ru.juriasan.clientrequestservice.domain.Application;
import ru.juriasan.clientrequestservice.exception.DBEntityNotFoundException;
import ru.juriasan.clientrequestservice.service.ApplicationService;
import java.util.List;

@RestController
@RequestMapping("/api/application")
public class ApplicationController {

    @Autowired
    private ApplicationService applicationService;

    @RequestMapping(value = "/latest/{contactId}", produces = {"application/json", "application/xml"},
            method = RequestMethod.GET)
    public Application getLatest(@PathVariable("contactId") Long contactId) {
        if (contactId == null) {
            throw new IllegalArgumentException("Path variable 'contactId' is null");
        }
        Application latest = applicationService.latest(contactId);
        if (latest == null) {
            throw new DBEntityNotFoundException(
                    String.format("Latest application with contact id %d is not found", contactId));
        }
        return latest;
    }

    @RequestMapping(value = "/all", produces = {"application/json", "application/xml"}, method = RequestMethod.GET)
    public List<Application> getAll() {
        List<Application> applications = applicationService.findAll();
        if (applications == null || applications.isEmpty()) {
            throw new DBEntityNotFoundException("None of the applications has been found in the DB");
        }
        return applications;
    }
}
