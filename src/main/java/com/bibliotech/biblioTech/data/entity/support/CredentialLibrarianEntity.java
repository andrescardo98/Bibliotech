package com.bibliotech.biblioTech.data.entity.support;

public class CredentialLibrarianEntity {
    private String username;
    private String password;

    private CredentialLibrarianEntity(String username, String password) {
        setUsername(username);
        setPassword(password);
    }

    public static final CredentialLibrarianEntity create(String username, String password){
        return new CredentialLibrarianEntity(username,password);
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
