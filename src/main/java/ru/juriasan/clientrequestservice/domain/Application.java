package ru.juriasan.clientrequestservice.domain;

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

    @Override
    public int hashCode() {
        return Objects.hash(applicationId, creation, productName);
    }

    @Override
    public boolean equals(Object o) {

        if (!(o instanceof Application)) {
            return false;
        }
        Application other = (Application) o;
        boolean contactsAreNotNull = contact != null && other.getClient() != null;
        if (!contactsAreNotNull) {
            return this == o;
        }
        return Objects.equals(other.getCreation(), this.creation)
                && Objects.equals(other.getProductName(), this.productName)
                && Objects.equals(contact.getContactId(), other.getClient().getContactId());
    }
}
