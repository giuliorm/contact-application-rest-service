package ru.juriasan.clientrequestservice.repository;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;
import ru.juriasan.clientrequestservice.domain.Contact;

@Repository
public interface ContactRepository extends CrudRepository<Contact, Long> {
}
