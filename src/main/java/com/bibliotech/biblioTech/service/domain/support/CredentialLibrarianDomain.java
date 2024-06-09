package com.bibliotech.biblioTech.service.domain.support;

public class CredentialLibrarianDomain {
    private String username;
    private String password;

    private CredentialLibrarianDomain(String username, String password) {
        setUsername(username);
        setPassword(password);
    }

    public static final CredentialLibrarianDomain create(String username, String password){
        return new CredentialLibrarianDomain(username,password);
    }

    public final String getUsername() {
        return username;
    }

    public final String getPassword() {
        return password;
    }

    public final void setUsername(final String username) {
        this.username = username;
    }

    public final void setPassword(final String password) {
        this.password = password;
    }
}
