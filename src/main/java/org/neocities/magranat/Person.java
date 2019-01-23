package org.neocities.magranat;

import javax.persistence.Entity;
import javax.persistence.Column;
import javax.persistence.Id;
import java.util.Date;

@Entity
public class Person {
    @Id
    @Column(name = "ID")
    private Integer id;
    @Column(name = "FIRST_NAME")
    private String firstName;
    @Column(name = "LAST_NAME")
    private String lastName;
    @Column(name = "MODIFIED_DATETIME")
    private Date modified;

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }

    public String toString() {
        return getFirstName() + " " + getLastName() + " (" + getModified() + ")";
    }

    public Date getModified() {
        return modified;
    }

    public void setModified(Date modified) {
        this.modified = modified;
    }
}
