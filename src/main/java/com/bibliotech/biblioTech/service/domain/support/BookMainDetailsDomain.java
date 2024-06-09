package com.bibliotech.biblioTech.service.domain.support;

public class BookMainDetailsDomain {
    private String tittle;
    private String summary;
    private String isbn;
    private String image;

    private BookMainDetailsDomain(final String tittle, final String summary, final String isbn, final String image) {
        setTittle(tittle);
        setSummary(summary);
        setIsbn(isbn);
        setImage(image);
    }

    public static final BookMainDetailsDomain create(final String tittle, final String summary, final String isbn, final String image) {
        return new BookMainDetailsDomain(tittle, summary, isbn, image);
    }

    public final String getTittle() {
        return tittle;
    }

    public final String getSummary() {
        return summary;
    }

    public final String getIsbn() {
        return isbn;
    }

    public final String getImage() {
        return image;
    }

    public final void setTittle(final String tittle) {
        this.tittle = tittle;
    }

    public final void setSummary(final String summary) {
        this.summary = summary;
    }

    public final void setIsbn(final String isbn) {
        this.isbn = isbn;
    }

    public final void setImage(final String image) {
        this.image = image;
    }
}
