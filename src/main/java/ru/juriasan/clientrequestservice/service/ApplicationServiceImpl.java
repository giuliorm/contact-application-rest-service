package ru.juriasan.clientrequestservice.service;

import org.springframework.stereotype.Service;
import ru.juriasan.clientrequestservice.domain.Application;
import ru.juriasan.clientrequestservice.repository.ApplicationRepository;

import java.util.List;

@Service
public class ApplicationServiceImpl implements ApplicationService {

    private ApplicationRepository repository;

    public ApplicationServiceImpl(ApplicationRepository repository) {
        this.repository = repository;
    }

    @Override
    public void createOrUpdate(Application application) {
        repository.save(application);
    }

    @Override
    public Application get(Long applicationId) {
        return repository.findById(applicationId).orElse(null);
    }

    @Override
    public void delete(Application application) {
        repository.delete(application);
    }

    @Override
    public Application latest(Long contactId) {
        return repository.latest(contactId);
    }

    @Override
    public List<Application> findAll() {
        return repository.findAll();
    }
}
