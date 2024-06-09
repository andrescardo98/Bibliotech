package com.bibliotech.biblioTech.data.entity;

import com.bibliotech.biblioTech.data.entity.support.BookMainDetailsEntity;

import java.util.UUID;

public class BookEntity {
    private UUID id;
    private BookMainDetailsEntity mainDetails;
    private CategoryEntity category;
    private PublisherEntity publisher;
    private AuthorEntity author;
    private boolean status;
    private boolean borrowed;

    private BookEntity(final UUID id, final BookMainDetailsEntity mainDetails, final CategoryEntity category,
                       final PublisherEntity publisher, final AuthorEntity author, final boolean status, final boolean borrowed) {
        this.id = id;
        this.mainDetails = mainDetails;
        this.category = category;
        this.publisher = publisher;
        this.author = author;
        this.status = status;
        this.borrowed = borrowed;
    }

    public static final BookEntity create(final UUID id, final BookMainDetailsEntity mainDetails, final CategoryEntity category,
                                          final PublisherEntity publisher, final AuthorEntity author, final boolean status,
                                          final boolean borrowed) {
        return new BookEntity(id, mainDetails, category, publisher, author, status, borrowed);
    }

    public final UUID getId() {
        return id;
    }

    public final BookMainDetailsEntity getMainDetails() {
        return mainDetails;
    }

    public final CategoryEntity getCategory() {
        return category;
    }

    public final PublisherEntity getPublisher() {
        return publisher;
    }

    public final AuthorEntity getAuthor() {
        return author;
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

    public final void setMainDetails(final BookMainDetailsEntity mainDetails) {
        this.mainDetails = mainDetails;
    }

    public final void setCategory(final CategoryEntity category) {
        this.category = category;
    }

    public final void setPublisher(final PublisherEntity publisher) {
        this.publisher = publisher;
    }

    public final void setAuthor(final AuthorEntity author) {
        this.author = author;
    }

    public final void setStatus(final boolean status) {
        this.status = status;
    }

    public final void setBorrowed(final boolean borrowed) {
        this.borrowed = borrowed;
    }
}
