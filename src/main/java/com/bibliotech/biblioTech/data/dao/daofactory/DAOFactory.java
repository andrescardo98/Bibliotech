package com.bibliotech.biblioTech.data.dao.daofactory;

import com.bibliotech.biblioTech.crosscutting.exception.concrete.CrossCuttingBibliotechException;
import com.bibliotech.biblioTech.crosscutting.exception.concrete.DataBibliotechException;
import com.bibliotech.biblioTech.crosscutting.messages.MessagesCatalog;
import com.bibliotech.biblioTech.crosscutting.messages.enumerator.MessageCode;
import com.bibliotech.biblioTech.data.dao.*;
import com.bibliotech.biblioTech.data.dao.daofactory.concrete.PostgreSQLDAOFactory;

public abstract class DAOFactory {

    public static final DAOFactory getDAOFactory(final TypeDAOFactory factory){
        switch (factory){
            case SQLSERVER:{
                var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000004);
                var technicalMessage = MessagesCatalog.getMessageContent(MessageCode.M00000091);
                throw DataBibliotechException.create(userMessage, technicalMessage);
            }

            case POSTGRESQL:{
                return new PostgreSQLDAOFactory();
            }
            case MYSQL:{
                var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000004);
                var technicalMessage = MessagesCatalog.getMessageContent(MessageCode.M00000091);
                throw DataBibliotechException.create(userMessage, technicalMessage);
            }
            case ORACLE:{
                var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000004);
                var technicalMessage = MessagesCatalog.getMessageContent(MessageCode.M00000091);
                throw DataBibliotechException.create(userMessage, technicalMessage);
            }
            default:
                var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000004);
                var technicalMessage = MessagesCatalog.getMessageContent(MessageCode.M00000091);
                throw DataBibliotechException.create(userMessage, technicalMessage);
        }
    }

    protected abstract void openConnection();

    public abstract void closeConnection();

    public abstract void startTransaction();

    public abstract void confirmTransaction();

    public abstract void cancelTransaction();

    public abstract CategoryDAO getCategoryDAO();

    public abstract AuthorDAO getAuthorDAO();

    public abstract BookDAO getBookDAO();

    public abstract DocumentTypeDAO getDocumentTypeDAO();

    public abstract LibrarianDAO getLibrarianDAO();

    public abstract PublisherDAO getPublisherDAO();
}
