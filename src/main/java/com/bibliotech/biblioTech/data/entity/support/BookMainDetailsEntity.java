package com.bibliotech.biblioTech.data.entity.support;

public class BookMainDetailsEntity {
    private String tittle;
    private String summary;
    private String isbn;
    private String image;

    private BookMainDetailsEntity(final String tittle, final String summary, final String isbn, final String image) {
        setTittle(tittle);
        setSummary(summary);
        setIsbn(isbn);
        setImage(image);
    }

    public static final BookMainDetailsEntity create(final String tittle, final String summary, final String isbn, final String image) {
        return new BookMainDetailsEntity(tittle, summary, isbn, image);
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
