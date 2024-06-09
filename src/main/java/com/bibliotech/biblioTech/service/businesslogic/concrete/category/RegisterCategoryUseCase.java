package com.bibliotech.biblioTech.service.businesslogic.concrete.category;

import com.bibliotech.biblioTech.crosscutting.exception.concrete.DataBibliotechException;
import com.bibliotech.biblioTech.crosscutting.exception.concrete.ServiceBibliotechException;
import com.bibliotech.biblioTech.crosscutting.messages.MessagesCatalog;
import com.bibliotech.biblioTech.crosscutting.messages.enumerator.MessageCode;
import com.bibliotech.biblioTech.crosscutting.util.UtilObject;
import com.bibliotech.biblioTech.data.dao.CategoryDAO;
import com.bibliotech.biblioTech.data.dao.daofactory.DAOFactory;
import com.bibliotech.biblioTech.data.entity.CategoryEntity;
import com.bibliotech.biblioTech.service.businesslogic.UseCase;
import com.bibliotech.biblioTech.service.domain.category.CategoryDomain;
import com.bibliotech.biblioTech.service.mapper.entity.concrete.CategoryEntityMapper;

import java.util.Optional;
import java.util.UUID;

public class RegisterCategoryUseCase implements UseCase<CategoryDomain> {

    private DAOFactory factory;

    public RegisterCategoryUseCase(final DAOFactory factory){
        setFactory(factory);
    }

    @Override
    public void execute(CategoryDomain domain) {
        validateNonExistanceCategoryWithSameCode(domain.getCode());
        validateNonExistanceCategoryWithSameName(domain.getName());
        domain = getIdCategory(domain);
        register(domain);
    }

    private final void register(final CategoryDomain domain){
        var entity = CategoryEntityMapper.convertToEntity(domain);
        getCategoryDAO().create(entity);
    }

    private final void validateNonExistanceCategoryWithSameCode(final String code){
        var domain = CategoryDomain.create(null, null, null, code);
        var entity = CategoryEntityMapper.convertToEntity(domain);
        var results = getCategoryDAO().search(entity);

        if (!results.isEmpty()){
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000055) + " " + code;
            throw ServiceBibliotechException.create(userMessage);
        }
    }

    private final void validateNonExistanceCategoryWithSameName(final String name){
        var domain = CategoryDomain.create(null, name, null, null);
        var entity = CategoryEntityMapper.convertToEntity(domain);
        var results = getCategoryDAO().search(entity);

        if (!results.isEmpty()){
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000056) + " " + name;
            throw ServiceBibliotechException.create(userMessage);
        }
    }

    private final CategoryDomain getIdCategory(final CategoryDomain domain){
        Optional<CategoryEntity> optional;
        UUID uuid;

        do {
            uuid = UUID.randomUUID();
            optional = getCategoryDAO().searchById(uuid);
        } while (optional.isPresent());
        return CategoryDomain.create(uuid, domain.getCode(), domain.getName(), domain.getDescription());
    }

    private final DAOFactory getFactory() {
        return factory;
    }

    private final CategoryDAO getCategoryDAO(){
        return getFactory().getCategoryDAO();
    }

    private final void setFactory(final DAOFactory factory){
        if (UtilObject.isNull(factory)){
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000070);
            var technicalMessage = MessagesCatalog.getMessageContent(MessageCode.M00000071);
            throw ServiceBibliotechException.create(userMessage, technicalMessage);
        }
        this.factory = factory;
    }
}
