package ru.juriasan.clientrequestservice;

import ru.juriasan.clientrequestservice.domain.Application;
import ru.juriasan.clientrequestservice.domain.Contact;
import ru.juriasan.clientrequestservice.repository.ApplicationRepository;
import ru.juriasan.clientrequestservice.repository.ContactRepository;

import java.io.Closeable;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class TestDataSetupUtil implements Closeable  {

    private Contact client;
    private Application application;
    private Application latestApplication;
    private ApplicationRepository applicationRepository;
    private ContactRepository contactRepository;

    public TestDataSetupUtil(ApplicationRepository applicationRepository,
                             ContactRepository contactRepository) {

        this.applicationRepository = applicationRepository;
        this.contactRepository = contactRepository;

        SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
        client = new Contact();
        client = contactRepository.save(client);

        latestApplication = new Application(client);
        application = new Application(client);

        try {
            latestApplication.setCreation(sdf.parse("21/12/3000"));
            application.setCreation(sdf.parse("21/12/2011"));
        }
        catch (ParseException ex) {
            throw new RuntimeException(ex.getMessage());
        }
        applicationRepository.save(application);
        applicationRepository.save(latestApplication);
    }

    public List<Application> allApplications() {
        return applicationRepository.findAll();
    }

    public Application getLatestApplication() {
        return latestApplication;
    }

    public Contact getContact() {
        return client;
    }

    @Override
    public void close() {
        applicationRepository.delete(application);
        applicationRepository.delete(latestApplication);
        contactRepository.delete(client);
    }
}
