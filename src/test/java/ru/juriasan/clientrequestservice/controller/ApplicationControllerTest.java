package ru.juriasan.clientrequestservice.controller;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import ru.juriasan.clientrequestservice.TestDataSetupUtil;
import ru.juriasan.clientrequestservice.domain.Application;
import ru.juriasan.clientrequestservice.exception.DBEntityNotFoundException;
import ru.juriasan.clientrequestservice.repository.ApplicationRepository;
import ru.juriasan.clientrequestservice.repository.ContactRepository;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ApplicationControllerTest {

    @Autowired
    private ApplicationController applicationController;

    @Autowired
    private ApplicationRepository applicationRepository;

    @Autowired
    private ContactRepository contactRepository;

    @Test
    public void testGetLatestValidCaset() {
        try (TestDataSetupUtil util =
                     new TestDataSetupUtil(applicationRepository, contactRepository)) {
            Application latest = applicationController
                    .getLatest(util.getContact().getContactId());
            Assert.assertEquals(latest, util.getLatestApplication());
        }
    }

    @Test(expected = IllegalArgumentException.class)
    public void throwsIllegalArgumentExceptionOnNull() {
        applicationController.getLatest(null);
    }

    @Test(expected = DBEntityNotFoundException.class)
    public void thorwsExceptionIfEntityIsNotFound() {
        applicationController.getLatest((long)-1);
    }

    @Test
    public void testFindAll() {
        try (TestDataSetupUtil util =
                     new TestDataSetupUtil(applicationRepository, contactRepository)) {
            Assert.assertEquals(applicationController.getAll(), util.allApplications());
        }
    }
}

