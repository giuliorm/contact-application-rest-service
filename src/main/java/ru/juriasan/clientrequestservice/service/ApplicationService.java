package ru.juriasan.clientrequestservice.service;

import ru.juriasan.clientrequestservice.domain.Application;

import java.util.List;

public interface ApplicationService {

    void createOrUpdate(Application application);
    Application get(Long applicationId);
    void delete(Application application);
    Application latest(Long contactId);
    List<Application> findAll();
}
