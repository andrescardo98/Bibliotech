package com.bibliotech.biblioTech.service.businesslogic.concrete.category;

import com.bibliotech.biblioTech.crosscutting.exception.concrete.ServiceBibliotechException;
import com.bibliotech.biblioTech.crosscutting.messages.MessagesCatalog;
import com.bibliotech.biblioTech.crosscutting.messages.enumerator.MessageCode;
import com.bibliotech.biblioTech.crosscutting.util.UtilObject;
import com.bibliotech.biblioTech.data.dao.CategoryDAO;
import com.bibliotech.biblioTech.data.dao.daofactory.DAOFactory;
import com.bibliotech.biblioTech.service.businesslogic.FindeUseCase;
import com.bibliotech.biblioTech.service.businesslogic.UseCase;
import com.bibliotech.biblioTech.service.businesslogic.validator.concrete.category.ModifyCategoryValidator;
import com.bibliotech.biblioTech.service.businesslogic.validator.concrete.category.SearchCategoryValidator;
import com.bibliotech.biblioTech.service.domain.category.CategoryDomain;
import com.bibliotech.biblioTech.service.mapper.entity.concrete.CategoryEntityMapper;

import java.util.List;
import java.util.UUID;

public class SearchCategoryUseCase implements FindeUseCase<CategoryDomain> {

    private DAOFactory factory;

    public SearchCategoryUseCase(final DAOFactory factory){
        setFactory(factory);
    }

    @Override
    public List<CategoryDomain> execute(CategoryDomain domain) {
        SearchCategoryValidator.ejecutar(domain);
        final var results = getCategoryDAO().search(CategoryEntityMapper.convertToEntity(domain));

        return CategoryEntityMapper.convertToListDomain(results);
    }

    private final DAOFactory getFactory() {
        return factory;
    }

    private final CategoryDAO getCategoryDAO(){
        return getFactory().getCategoryDAO();
    }

    private final void setFactory(final DAOFactory factory){
        if (UtilObject.isNull(factory)){
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000082);
            var technicalMessage = MessagesCatalog.getMessageContent(MessageCode.M00000083);
            throw ServiceBibliotechException.create(userMessage, technicalMessage);
        }
        this.factory = factory;
    }
}
