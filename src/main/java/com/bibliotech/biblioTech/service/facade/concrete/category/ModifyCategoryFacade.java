package com.bibliotech.biblioTech.service.facade.concrete.category;

import com.bibliotech.biblioTech.crosscutting.exception.BiblioTechException;
import com.bibliotech.biblioTech.crosscutting.exception.concrete.CrossCuttingBibliotechException;
import com.bibliotech.biblioTech.crosscutting.exception.concrete.ServiceBibliotechException;
import com.bibliotech.biblioTech.crosscutting.messages.MessagesCatalog;
import com.bibliotech.biblioTech.crosscutting.messages.enumerator.MessageCode;
import com.bibliotech.biblioTech.data.dao.daofactory.DAOFactory;
import com.bibliotech.biblioTech.data.dao.daofactory.TypeDAOFactory;
import com.bibliotech.biblioTech.service.businesslogic.concrete.category.ModifyCategoryUseCase;
import com.bibliotech.biblioTech.service.businesslogic.concrete.category.RegisterCategoryUseCase;
import com.bibliotech.biblioTech.service.businesslogic.validator.concrete.category.ModifyCategoryValidator;
import com.bibliotech.biblioTech.service.businesslogic.validator.concrete.category.RegisterCategoryValidator;
import com.bibliotech.biblioTech.service.domain.category.CategoryDomain;
import com.bibliotech.biblioTech.service.dto.CategoryDTO;
import com.bibliotech.biblioTech.service.facade.Facade;
import com.bibliotech.biblioTech.service.mapper.dto.concrete.CategoryDTOMapper;

public class ModifyCategoryFacade implements Facade<CategoryDTO> {

    @Override
    public void execute(final CategoryDTO dto) {
        final CategoryDomain domain = CategoryDTOMapper.convertToDomain(dto);
        ModifyCategoryValidator.ejecutar(domain);

        DAOFactory daoFactory = DAOFactory.getDAOFactory(TypeDAOFactory.POSTGRESQL);

        try {
            daoFactory.startTransaction();
            var useCase = new ModifyCategoryUseCase(daoFactory);
            useCase.execute(domain);
            daoFactory.confirmTransaction();
        }catch (final BiblioTechException exception){
            daoFactory.cancelTransaction();
            throw exception;
        } catch (final Exception exception){
            daoFactory.cancelTransaction();
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000076);
            var technicalMessage = MessagesCatalog.getMessageContent(MessageCode.M00000077);
            throw ServiceBibliotechException.create(userMessage, technicalMessage);
        } finally {
            daoFactory.closeConnection();
        }

    }
}
