package com.bibliotech.biblioTech.data.entity;

import com.bibliotech.biblioTech.data.entity.support.CredentialLibrarianEntity;
import com.bibliotech.biblioTech.data.entity.support.FullNameLibrarianEntity;

import java.util.UUID;

public class LibrarianEntity {
    private UUID id;
    private FullNameLibrarianEntity fullName;
    private DocumentTypeEntity documentType;
    private String documentNumber;
    private String email;
    private String cellPhoneNumber;
    private CredentialLibrarianEntity credential;

    private LibrarianEntity(final UUID id, final FullNameLibrarianEntity fullName, final DocumentTypeEntity documentType,
                            final String documentNumber, final String email, final String cellPhoneNumber,
                            final CredentialLibrarianEntity credential) {
        setId(id);
        setFullName(fullName);
        setDocumentType(documentType);
        setDocumentNumber(documentNumber);
        setEmail(email);
        setCellPhoneNumber(cellPhoneNumber);
        setCredential(credential);
    }

    public static final LibrarianEntity create(final UUID id, final FullNameLibrarianEntity fullName, final DocumentTypeEntity documentType,
                                               final String documentNumber, final String email, final String cellPhoneNumber,
                                               final CredentialLibrarianEntity credential) {
        return new LibrarianEntity(id, fullName, documentType, documentNumber, email, cellPhoneNumber, credential);
    }

    public final UUID getId() {
        return id;
    }

    public final FullNameLibrarianEntity getFullName() {
        return fullName;
    }

    public final DocumentTypeEntity getDocumentType() {
        return documentType;
    }

    public final String getDocumentNumber() {
        return documentNumber;
    }

    public final String getEmail() {
        return email;
    }

    public final String getCellPhoneNumber() {
        return cellPhoneNumber;
    }

    public final CredentialLibrarianEntity getCredential() {
        return credential;
    }

    public final void setId(final UUID id) {
        this.id = id;
    }

    public final void setFullName(final FullNameLibrarianEntity fullName) {
        this.fullName = fullName;
    }

    public final void setDocumentType(final DocumentTypeEntity documentType) {
        this.documentType = documentType;
    }

    public final void setDocumentNumber(final String documentNumber) {
        this.documentNumber = documentNumber;
    }

    public final void setEmail(final String email) {
        this.email = email;
    }

    public final void setCellPhoneNumber(final String cellPhoneNumber) {
        this.cellPhoneNumber = cellPhoneNumber;
    }

    public final void setCredential(final CredentialLibrarianEntity credential) {
        this.credential = credential;
    }
}
