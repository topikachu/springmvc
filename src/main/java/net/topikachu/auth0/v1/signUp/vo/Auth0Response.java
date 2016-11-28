package net.topikachu.auth0.v1.signUp.vo;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by gongy on 2016/11/28.
 */
public class Auth0Response {
    @JsonProperty("_id")
            private  String id;
    @JsonProperty("email_verified")
    private boolean emailVerified;

    private String email;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public boolean isEmailVerified() {
        return emailVerified;
    }

    public void setEmailVerified(boolean emailVerified) {
        this.emailVerified = emailVerified;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Override
    public String toString() {
        return "Auth0Response{" +
                "id='" + id + '\'' +
                ", emailVerified=" + emailVerified +
                ", email='" + email + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Auth0Response that = (Auth0Response) o;

        if (emailVerified != that.emailVerified) return false;
        if (id != null ? !id.equals(that.id) : that.id != null) return false;
        return email != null ? email.equals(that.email) : that.email == null;

    }

    @Override
    public int hashCode() {
        int result = id != null ? id.hashCode() : 0;
        result = 31 * result + (emailVerified ? 1 : 0);
        result = 31 * result + (email != null ? email.hashCode() : 0);
        return result;
    }
}
