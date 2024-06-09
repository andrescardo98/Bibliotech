package com.bibliotech.biblioTech.service.businesslogic;

public interface UseCase<D> {

    void execute(D domain);
}
