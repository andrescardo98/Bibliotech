package com.bibliotech.biblioTech.service.domain.librarian;

import com.bibliotech.biblioTech.service.domain.documenttype.DocumentTypeDomain;
import com.bibliotech.biblioTech.service.domain.support.CredentialLibrarianDomain;
import com.bibliotech.biblioTech.service.domain.support.FullNameLibrarianDomain;

import java.util.UUID;

public class LibrarianDomain {
    private UUID id;
    private FullNameLibrarianDomain fullName;
    private DocumentTypeDomain documentTypeDomain;
    private String documentNumber;
    private String email;
    private String cellPhoneNumber;
    private CredentialLibrarianDomain credential;

    private LibrarianDomain(final UUID id, final FullNameLibrarianDomain fullName, final DocumentTypeDomain documentTypeDomain, final String documentNumber,
                            final String email, final String cellPhoneNumber, final CredentialLibrarianDomain credential) {
        setId(id);
        setFullName(fullName);
        setDocumentType(documentTypeDomain);
        setDocumentNumber(documentNumber);
        setEmail(email);
        setCellPhoneNumber(cellPhoneNumber);
        setCredential(credential);
    }

    public static final LibrarianDomain create(final UUID id, final FullNameLibrarianDomain fullName, final DocumentTypeDomain documentTypeDomain,
                                               final String documentNumber, final String email, final String cellPhoneNumber,
                                               final CredentialLibrarianDomain credential) {
        return new LibrarianDomain(id, fullName, documentTypeDomain, documentNumber, email, cellPhoneNumber, credential);
    }

    public final UUID getId() {
        return id;
    }

    public final FullNameLibrarianDomain getFullName() {
        return fullName;
    }

    public final DocumentTypeDomain getDocumentType() {
        return documentTypeDomain;
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

    public final CredentialLibrarianDomain getCredential() {
        return credential;
    }

    public final void setId(final UUID id) {
        this.id = id;
    }

    public final void setFullName(final FullNameLibrarianDomain fullName) {
        this.fullName = fullName;
    }

    public final void setDocumentType(final DocumentTypeDomain documentTypeDomain) {
        this.documentTypeDomain = documentTypeDomain;
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

    public final void setCredential(final CredentialLibrarianDomain credential) {
        this.credential = credential;
    }
}
