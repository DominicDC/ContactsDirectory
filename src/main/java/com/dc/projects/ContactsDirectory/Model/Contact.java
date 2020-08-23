package com.dc.projects.ContactsDirectory.Model;

import javax.persistence.*;

@Entity
@Table(name="Contacts")
public class Contact extends Person {

    private String workPhone;

    @Embedded
    private Address address;

    @Enumerated(EnumType.STRING)
    private Relationship relation;

    @ManyToOne
    @JoinColumn(name="user_id")
    private User user;

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getWorkPhone() {
        return workPhone;
    }

    public void setWorkPhone(String workPhone) {
        this.workPhone = workPhone;
    }

    public Relationship getRelation() {
        return relation;
    }

    public void setRelation(Relationship relation) {
        this.relation = relation;
    }

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    @Override
    public String toString() {
        return "Contact{" +
                "address=" + address +
                ", workPhone='" + workPhone + '\'' +
                ", relation=" + relation +
                '}';
    }
}
