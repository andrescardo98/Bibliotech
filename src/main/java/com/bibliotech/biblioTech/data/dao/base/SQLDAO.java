package com.bibliotech.biblioTech.data.dao.base;

import com.bibliotech.biblioTech.crosscutting.exception.concrete.CrossCuttingBibliotechException;
import com.bibliotech.biblioTech.crosscutting.messages.MessagesCatalog;
import com.bibliotech.biblioTech.crosscutting.messages.enumerator.MessageCode;
import com.bibliotech.biblioTech.crosscutting.util.UtilSQL;

import java.sql.Connection;

public class SQLDAO {

    private Connection connection;

    protected SQLDAO(final Connection connection){
        setConnection(connection);
    }

    public Connection getConnection() {
        return connection;
    }

    private final void setConnection(final Connection connection) {
        if (!UtilSQL.openConnection(connection)){
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000004);
            var technicalMessage = MessagesCatalog.getMessageContent(MessageCode.M00000035);
            throw CrossCuttingBibliotechException.create(userMessage, technicalMessage);
        }
        this.connection = connection;
    }
}
