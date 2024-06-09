package com.bibliotech.biblioTech.service.facade.concrete.category;

import com.bibliotech.biblioTech.crosscutting.exception.BiblioTechException;
import com.bibliotech.biblioTech.crosscutting.exception.concrete.CrossCuttingBibliotechException;
import com.bibliotech.biblioTech.crosscutting.exception.concrete.ServiceBibliotechException;
import com.bibliotech.biblioTech.crosscutting.messages.MessagesCatalog;
import com.bibliotech.biblioTech.crosscutting.messages.enumerator.MessageCode;
import com.bibliotech.biblioTech.data.dao.daofactory.DAOFactory;
import com.bibliotech.biblioTech.data.dao.daofactory.TypeDAOFactory;
import com.bibliotech.biblioTech.service.businesslogic.concrete.category.ModifyCategoryUseCase;
import com.bibliotech.biblioTech.service.businesslogic.concrete.category.SearchCategoryUseCase;
import com.bibliotech.biblioTech.service.businesslogic.validator.concrete.category.ModifyCategoryValidator;
import com.bibliotech.biblioTech.service.businesslogic.validator.concrete.category.SearchCategoryValidator;
import com.bibliotech.biblioTech.service.domain.category.CategoryDomain;
import com.bibliotech.biblioTech.service.dto.CategoryDTO;
import com.bibliotech.biblioTech.service.facade.Facade;
import com.bibliotech.biblioTech.service.facade.FacadeFind;
import com.bibliotech.biblioTech.service.mapper.dto.concrete.CategoryDTOMapper;

import java.util.ArrayList;
import java.util.List;

public class SearchCategoryFacade implements FacadeFind<CategoryDTO> {

    @Override
    public final List<CategoryDTO> execute (final CategoryDTO dto) {
        final CategoryDomain domain = CategoryDTOMapper.convertToDomain(dto);
        SearchCategoryValidator.ejecutar(domain);
        List<CategoryDTO> results = new ArrayList<>();

        DAOFactory daoFactory = DAOFactory.getDAOFactory(TypeDAOFactory.POSTGRESQL);

        try {
            daoFactory.startTransaction();
            var useCase = new SearchCategoryUseCase(daoFactory);
            results = CategoryDTOMapper.convertToListDTO(useCase.execute(domain));
            daoFactory.confirmTransaction();
        }catch (final BiblioTechException exception){
            daoFactory.cancelTransaction();
            throw exception;
        } catch (final Exception exception){
            daoFactory.cancelTransaction();
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000084);
            var technicalMessage = MessagesCatalog.getMessageContent(MessageCode.M00000085);
            throw ServiceBibliotechException.create(userMessage, technicalMessage);
        } finally {
            daoFactory.closeConnection();
        }
        return results;
    }
}
