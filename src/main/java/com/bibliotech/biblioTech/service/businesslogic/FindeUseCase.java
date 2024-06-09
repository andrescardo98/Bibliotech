package com.bibliotech.biblioTech.service.businesslogic;

import java.util.List;

public interface FindeUseCase<D> {

    List<D> execute(D domain);
}
