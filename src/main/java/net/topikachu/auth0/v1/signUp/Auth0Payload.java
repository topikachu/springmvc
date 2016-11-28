package net.topikachu.auth0.v1.signUp;

import com.fasterxml.jackson.annotation.JsonProperty;

/**
 * Created by gongy on 2016/11/28.
 */
public class Auth0Payload {
    @JsonProperty("client_id")
    private String clientId;
    private String email;
    private String password;
    private String connection;
    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getConnection() {
        return connection;
    }

    public void setConnection(String connection) {
        this.connection = connection;
    }

    @Override
    public String toString() {
        return "Auth0Payload{" +
                "clientId='" + clientId + '\'' +
                ", email='" + email + '\'' +
                ", connection='" + connection + '\'' +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Auth0Payload that = (Auth0Payload) o;

        if (clientId != null ? !clientId.equals(that.clientId) : that.clientId != null) return false;
        if (email != null ? !email.equals(that.email) : that.email != null) return false;
        if (password != null ? !password.equals(that.password) : that.password != null) return false;
        return connection != null ? connection.equals(that.connection) : that.connection == null;

    }

    @Override
    public int hashCode() {
        int result = clientId != null ? clientId.hashCode() : 0;
        result = 31 * result + (email != null ? email.hashCode() : 0);
        result = 31 * result + (password != null ? password.hashCode() : 0);
        result = 31 * result + (connection != null ? connection.hashCode() : 0);
        return result;
    }
}
