package ru.juriasan.clientrequestservice.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;

import javax.persistence.*;
import java.util.Collections;
import java.util.Set;

@Entity
public class Contact {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "contact_id")
    private long contactId;

    @OneToMany(fetch = FetchType.LAZY, mappedBy = "contact")
    private Set<Application> requests;

    public Contact() {

    }

    public long getContactId() {
        return this.contactId;
    }

    @JsonProperty
    public void setRequests(Set<Application> requests) {
        this.requests = requests;
    }

    @JsonIgnore
    public Set<Application> getRequests() {
        return Collections.unmodifiableSet(requests);
    }
}
