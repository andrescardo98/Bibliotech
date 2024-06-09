package com.bibliotech.biblioTech.service.domain.book;

import com.bibliotech.biblioTech.service.domain.support.BookMainDetailsDomain;
import com.bibliotech.biblioTech.service.domain.category.CategoryDomain;
import com.bibliotech.biblioTech.service.domain.publisher.PublisherDomain;
import com.bibliotech.biblioTech.service.domain.author.AuthorDomain;

import java.util.UUID;

public class BookDomain {
    private UUID id;
    private BookMainDetailsDomain mainDetails;
    private CategoryDomain categoryDomain;
    private PublisherDomain publisherDomain;
    private AuthorDomain authorDomain;
    private boolean status;
    private boolean borrowed;

    private BookDomain(final UUID id, final BookMainDetailsDomain mainDetails, final CategoryDomain categoryDomain, final PublisherDomain publisherDomain,
                       final AuthorDomain authorDomain, final boolean status, final boolean borrowed) {
        this.id = id;
        this.mainDetails = mainDetails;
        this.categoryDomain = categoryDomain;
        this.publisherDomain = publisherDomain;
        this.authorDomain = authorDomain;
        this.status = status;
        this.borrowed = borrowed;
    }

    public static final BookDomain create(final UUID id, final BookMainDetailsDomain mainDetails, final CategoryDomain categoryDomain, final PublisherDomain publisherDomain,
                                          final AuthorDomain authorDomain, final boolean status, final boolean borrowed) {
        return new BookDomain(id, mainDetails, categoryDomain, publisherDomain, authorDomain, status, borrowed);
    }

    public final UUID getId() {
        return id;
    }

    public final BookMainDetailsDomain getMainDetails() {
        return mainDetails;
    }

    public final CategoryDomain getCategory() {
        return categoryDomain;
    }

    public final PublisherDomain getPublisher() {
        return publisherDomain;
    }

    public final AuthorDomain getAuthor() {
        return authorDomain;
    }

    public final boolean isStatus() {
        return status;
    }

    public final boolean isBorrowed() {
        return borrowed;
    }

    public final void setId(final UUID id) {
        this.id = id;
    }

    public final void setMainDetails(final BookMainDetailsDomain mainDetails) {
        this.mainDetails = mainDetails;
    }

    public final void setCategory(final CategoryDomain categoryDomain) {
        this.categoryDomain = categoryDomain;
    }

    public final void setPublisher(final PublisherDomain publisherDomain) {
        this.publisherDomain = publisherDomain;
    }

    public final void setAuthor(final AuthorDomain authorDomain) {
        this.authorDomain = authorDomain;
    }

    public final void setStatus(final boolean status) {
        this.status = status;
    }

    public final void setBorrowed(final boolean borrowed) {
        this.borrowed = borrowed;
    }
}
