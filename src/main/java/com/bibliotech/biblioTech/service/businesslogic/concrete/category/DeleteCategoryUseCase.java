package com.bibliotech.biblioTech.service.businesslogic.concrete.category;

import com.bibliotech.biblioTech.crosscutting.exception.concrete.ServiceBibliotechException;
import com.bibliotech.biblioTech.crosscutting.messages.MessagesCatalog;
import com.bibliotech.biblioTech.crosscutting.messages.enumerator.MessageCode;
import com.bibliotech.biblioTech.crosscutting.util.UtilObject;
import com.bibliotech.biblioTech.data.dao.CategoryDAO;
import com.bibliotech.biblioTech.data.dao.daofactory.DAOFactory;
import com.bibliotech.biblioTech.service.businesslogic.UseCase;
import com.bibliotech.biblioTech.service.businesslogic.validator.concrete.category.DeleteCategoryValidator;
import com.bibliotech.biblioTech.service.businesslogic.validator.concrete.category.ModifyCategoryValidator;
import com.bibliotech.biblioTech.service.domain.category.CategoryDomain;
import com.bibliotech.biblioTech.service.mapper.entity.concrete.CategoryEntityMapper;

import java.util.UUID;

public class DeleteCategoryUseCase implements UseCase<CategoryDomain> {

    private DAOFactory factory;

    public DeleteCategoryUseCase(final DAOFactory factory){
        setFactory(factory);
    }

    @Override
    public void execute(CategoryDomain domain) {
        DeleteCategoryValidator.ejecutar(domain);
        //validateExistenceRegisterById(domain.getId());
        validateExistenceRegisterByCode(domain.getCode());
        //delete(domain.getId());
        deleteByCode(domain.getCode());
    }

    private final void delete(final UUID uuid){
        getCategoryDAO().delete(uuid);
    }

    private final void deleteByCode(final String code){
        getCategoryDAO().deleteByCode(code);
    }

    private final void validateExistenceRegisterById(final UUID uuid){
        final var results = getCategoryDAO().searchById(uuid);
        if (results.isEmpty()){
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000057);
            throw ServiceBibliotechException.create(userMessage);
        }
    }

    private final void validateExistenceRegisterByCode(final String code){
        final var results = getCategoryDAO().searchByCode(code);
        if (results.isEmpty()){
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000092);
            throw ServiceBibliotechException.create(userMessage);
        }
    }

    private final DAOFactory getFactory() {
        return factory;
    }

    private final CategoryDAO getCategoryDAO(){
        return getFactory().getCategoryDAO();
    }

    private final void setFactory(final DAOFactory factory){
        if (UtilObject.isNull(factory)){
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000078);
            var technicalMessage = MessagesCatalog.getMessageContent(MessageCode.M00000079);
            throw ServiceBibliotechException.create(userMessage, technicalMessage);
        }
        this.factory = factory;
    }
}
