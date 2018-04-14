package ru.juriasan.clientrequestservice.service;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.juriasan.clientrequestservice.TestDataSetupUtil;
import ru.juriasan.clientrequestservice.domain.Application;
import ru.juriasan.clientrequestservice.repository.ApplicationRepository;
import ru.juriasan.clientrequestservice.repository.ContactRepository;

import java.text.ParseException;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationServiceTest {



    @Autowired
    private ContactRepository contactRepository;

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private ApplicationService applicationService;

    @Test
    public void testFindAll() {
        try (TestDataSetupUtil util = new TestDataSetupUtil(applicationRepository,
                contactRepository)) {
            List<Application> allExpected = util.allApplications();
            List<Application> allActual = applicationService.findAll();
            Assert.assertEquals(allExpected, allActual);
        }
    }

    @Test
    public void testLatest() {

        try (TestDataSetupUtil util = new TestDataSetupUtil(applicationRepository,
                contactRepository)) {
            Application latest = applicationService.latest(util.getContact().getContactId());
            Assert.assertEquals(latest, util.getLatestApplication());
        }
    }
}
