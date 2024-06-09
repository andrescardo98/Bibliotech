package com.bibliotech.biblioTech.data.dao.daofactory.concrete;

import com.bibliotech.biblioTech.crosscutting.exception.concrete.DataBibliotechException;
import com.bibliotech.biblioTech.crosscutting.messages.MessagesCatalog;
import com.bibliotech.biblioTech.crosscutting.messages.enumerator.MessageCode;
import com.bibliotech.biblioTech.crosscutting.util.UtilSQL;
import com.bibliotech.biblioTech.data.dao.*;
import com.bibliotech.biblioTech.data.dao.concrete.postgresql.CategoryPostgreSQLDAO;
import com.bibliotech.biblioTech.data.dao.daofactory.DAOFactory;

import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

public final class PostgreSQLDAOFactory extends DAOFactory {

    private Connection connection;

    public PostgreSQLDAOFactory(){
        openConnection();
    }

    @Override
    protected final void openConnection() {

        try {
            Properties properties = new Properties();
            InputStream input = getClass().getResourceAsStream("/application.properties");
            properties.load(input);
            String url = properties.getProperty("db.url");
            String user = properties.getProperty("db.user");
            String password = properties.getProperty("db.password");

            if (url == null || url.isEmpty() || user == null || user.isEmpty() || password == null || password.isEmpty()){
                var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000004);
                var technicalMessage = MessagesCatalog.getMessageContent(MessageCode.M00000054);
                throw DataBibliotechException.create(userMessage, technicalMessage);
            }
            connection = DriverManager.getConnection(url, user, password);
        }catch (final SQLException exception){
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000004);
            var technicalMessage = MessagesCatalog.getMessageContent(MessageCode.M00000027);
            throw DataBibliotechException.create(userMessage, technicalMessage);
        } catch (final Exception exception){
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000004);
            var technicalMessage = MessagesCatalog.getMessageContent(MessageCode.M00000029);
            throw DataBibliotechException.create(userMessage, technicalMessage);
        }
    }

    @Override
    public void closeConnection() {
        UtilSQL.closeConnection(connection);
    }

    @Override
    public void startTransaction() {
        UtilSQL.startTransaction(connection);
    }

    @Override
    public void confirmTransaction() {
        UtilSQL.confirmTransaction(connection);
    }

    @Override
    public void cancelTransaction() {
        UtilSQL.cancelTransaction(connection);
    }

    @Override
    public CategoryDAO getCategoryDAO() {
        return new CategoryPostgreSQLDAO(connection);
    }

    @Override
    public AuthorDAO getAuthorDAO() {
        return null;
    }

    @Override
    public BookDAO getBookDAO() {
        return null;
    }

    @Override
    public DocumentTypeDAO getDocumentTypeDAO() {
        return null;
    }

    @Override
    public LibrarianDAO getLibrarianDAO() {
        return null;
    }

    @Override
    public PublisherDAO getPublisherDAO() {
        return null;
    }
}
