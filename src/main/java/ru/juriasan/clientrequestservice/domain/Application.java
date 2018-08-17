package ru.juriasan.clientrequestservice.domain;

import com.fasterxml.jackson.annotation.JsonFormat;

import javax.persistence.*;
import java.util.Date;
import java.util.Objects;

@Entity
public class Application {

    public Application() {

    }

    public Application(Contact client) {
        this.contact = client;
    }

    @Id
    @Column(name = "application_id")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long applicationId;

    @Column(name = "dt_created")
    @JsonFormat(shape = JsonFormat.Shape.STRING, pattern = "dd-MM-yyyy hh:mm:ss")
    @Temporal(TemporalType.DATE)
    private Date creation;

    @Column(name = "product_name")
    private String productName;

    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name="contact_id", nullable = false)
    private Contact contact;

    public long getAppicationId() {
        return applicationId;
    }

    public Date getCreation() {
        return this.creation;
    }

    public void setCreation(Date date) {
        this.creation = date;
    }

    public Contact getClient() {
        return contact;
    }

    public void setClient(Contact client) {
        this.contact = client;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
