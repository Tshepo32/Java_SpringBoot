package za.ac.cput.domain;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
public class Contact implements Serializable {
    @Id
    private String email;
    private long mobile;
    private long workTelephone;

    protected Contact() {

    }

    public Contact(Builder builder) {
        this.email = builder.email;
        this.mobile = builder.mobile;
        this.workTelephone = builder.workTelephone;
    }

    public String getEmail() {
        return email;
    }

    public long getMobile() {
        return mobile;
    }

    public long getWorkTelephone() {
        return workTelephone;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Contact contact = (Contact) o;
        return Objects.equals(email, contact.email) && Objects.equals(mobile, contact.mobile) && Objects.equals(workTelephone, contact.workTelephone);
    }

    @Override
    public int hashCode() {
        return Objects.hash(email, mobile, workTelephone);
    }

    @Override
    public String toString() {
        return "email: " + email +
                "\nMobile: " + mobile +
                "\nWork Telephone: " + workTelephone;
    }

    public static class Builder {
        private String email;
        private long mobile;
        private long workTelephone;

        public Builder setEmail(String email) {
            this.email = email;
            return this;
        }

        public Builder setMobile(long mobile) {
            this.mobile = mobile;
            return this;
        }

        public Builder setWorkTelephone(long workTelephone) {
            this.workTelephone = workTelephone;
            return this;
        }

        public Builder copy(Contact contact) {
            this.email = contact.email;
            this.mobile = contact.mobile;
            this.workTelephone = contact.workTelephone;
            return this;
        }

        public Contact build() {

            return new Contact(this);
        }
    }
}
