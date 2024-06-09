package com.bibliotech.biblioTech.service.businesslogic.concrete.category;

import com.bibliotech.biblioTech.crosscutting.exception.concrete.ServiceBibliotechException;
import com.bibliotech.biblioTech.crosscutting.messages.MessagesCatalog;
import com.bibliotech.biblioTech.crosscutting.messages.enumerator.MessageCode;
import com.bibliotech.biblioTech.crosscutting.util.UtilObject;
import com.bibliotech.biblioTech.data.dao.CategoryDAO;
import com.bibliotech.biblioTech.data.dao.daofactory.DAOFactory;
import com.bibliotech.biblioTech.data.entity.CategoryEntity;
import com.bibliotech.biblioTech.service.businesslogic.UseCase;
import com.bibliotech.biblioTech.service.businesslogic.validator.concrete.category.ModifyCategoryValidator;
import com.bibliotech.biblioTech.service.domain.category.CategoryDomain;
import com.bibliotech.biblioTech.service.mapper.entity.concrete.CategoryEntityMapper;

import java.util.Optional;
import java.util.UUID;

public class ModifyCategoryUseCase implements UseCase<CategoryDomain> {

    private DAOFactory factory;

    public ModifyCategoryUseCase(final DAOFactory factory){
        setFactory(factory);
    }

    @Override
    public void execute(CategoryDomain domain) {
        ModifyCategoryValidator.ejecutar(domain);
        validateExistenceRegister(domain.getId());
        validateNonExistanceCategoryWithSameCode(domain.getCode());
        validateNonExistanceCategoryWithSameName(domain.getName());
        upload(domain);
    }

    private final void upload(final CategoryDomain domain){
        getCategoryDAO().modify(CategoryEntityMapper.convertToEntity(domain));
    }

    private final void validateExistenceRegister(final UUID uuid){
        final var results = getCategoryDAO().searchById(uuid);
        if (results.isEmpty()){
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000057);
            throw ServiceBibliotechException.create(userMessage);
        }
    }

    private final void validateNonExistanceCategoryWithSameCode(final String code){
        var domain = CategoryDomain.create(null, null, null, code);
        var entity = CategoryEntityMapper.convertToEntity(domain);
        var results = getCategoryDAO().search(entity);

        if (!results.isEmpty()){
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000058) + " " + code;
            throw ServiceBibliotechException.create(userMessage);
        }
    }

    private final void validateNonExistanceCategoryWithSameName(final String name){
        var domain = CategoryDomain.create(null, name, null, null);
        var entity = CategoryEntityMapper.convertToEntity(domain);
        var results = getCategoryDAO().search(entity);

        if (!results.isEmpty()){
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000059) + " " + name;
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
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000060);
            var technicalMessage = MessagesCatalog.getMessageContent(MessageCode.M00000061);
            throw ServiceBibliotechException.create(userMessage, technicalMessage);
        }
        this.factory = factory;
    }
}
