package com.bibliotech.biblioTech.crosscutting.util;

import com.bibliotech.biblioTech.crosscutting.exception.concrete.CrossCuttingBibliotechException;
import com.bibliotech.biblioTech.crosscutting.messages.MessagesCatalog;
import com.bibliotech.biblioTech.crosscutting.messages.enumerator.MessageCode;
import jdk.jshell.execution.Util;

import java.sql.Connection;
import java.sql.SQLException;

public final class UtilSQL {

    private UtilSQL() {
        super();
    }

    public static final boolean openConnection(final Connection connection){
        if (UtilObject.isNull(connection)){
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000004);
            var technicalMessage = MessagesCatalog.getMessageContent(MessageCode.M00000009);
            throw CrossCuttingBibliotechException.create(userMessage, technicalMessage);
        }

        try {
            return !UtilObject.isNull(connection) && !connection.isClosed();
        } catch (final SQLException exception){
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000004);
            var technicalMessage = MessagesCatalog.getMessageContent(MessageCode.M00000005);
            throw CrossCuttingBibliotechException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception){
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000004);
            var technicalMessage = MessagesCatalog.getMessageContent(MessageCode.M00000006);
            throw CrossCuttingBibliotechException.create(exception, userMessage, technicalMessage);
        }
    }

    public static final void closeConnection(final Connection connection){
        if (UtilObject.isNull(connection)){
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000004);
            var technicalMessage = MessagesCatalog.getMessageContent(MessageCode.M00000007);
            throw CrossCuttingBibliotechException.create(userMessage, technicalMessage);
        }
        try {
            if (!openConnection(connection)){
                var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000004);
                var technicalMessage = MessagesCatalog.getMessageContent(MessageCode.M00000008);
                throw CrossCuttingBibliotechException.create(userMessage, technicalMessage);
            }
            connection.close();
        } catch (final CrossCuttingBibliotechException exception){
            throw exception;
        }catch (final SQLException exception){
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000004);
            var technicalMessage = MessagesCatalog.getMessageContent(MessageCode.M00000010);
            throw CrossCuttingBibliotechException.create(exception, userMessage, technicalMessage);
        }catch (final Exception exception){
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000004);
            var technicalMessage = MessagesCatalog.getMessageContent(MessageCode.M00000011);
            throw CrossCuttingBibliotechException.create(exception, userMessage, technicalMessage);
        }
    }

    public static final void startTransaction(final Connection connection){
        if (UtilObject.isNull(connection)){
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000004);
            var technicalMessage = MessagesCatalog.getMessageContent(MessageCode.M00000012);
            throw CrossCuttingBibliotechException.create(userMessage, technicalMessage);
        }
        try {
            if (!openConnection(connection)){
                var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000004);
                var technicalMessage = MessagesCatalog.getMessageContent(MessageCode.M00000013);
                throw CrossCuttingBibliotechException.create(userMessage, technicalMessage);
            }
            if (!connection.getAutoCommit()){
                var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000004);
                var technicalMessage = MessagesCatalog.getMessageContent(MessageCode.M00000014);
                throw CrossCuttingBibliotechException.create(userMessage, technicalMessage);
            }
            connection.setAutoCommit(false);
        }catch (final CrossCuttingBibliotechException exception){
            throw exception;
        } catch (final SQLException exception){
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000004);
            var technicalMessage = MessagesCatalog.getMessageContent(MessageCode.M00000015);
            throw CrossCuttingBibliotechException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception){
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000004);
            var technicalMessage = MessagesCatalog.getMessageContent(MessageCode.M00000016);
            throw CrossCuttingBibliotechException.create(exception, userMessage, technicalMessage);
        }
    }

    public static final void confirmTransaction(final Connection connection){
        if (UtilObject.isNull(connection)){
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000004);
            var technicalMessage = MessagesCatalog.getMessageContent(MessageCode.M00000017);
            throw CrossCuttingBibliotechException.create(userMessage, technicalMessage);
        }
        try {
            if (!openConnection(connection)){
                var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000004);
                var technicalMessage = MessagesCatalog.getMessageContent(MessageCode.M00000018);
                throw CrossCuttingBibliotechException.create(userMessage, technicalMessage);
            }
            if (connection.getAutoCommit()){
                var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000004);
                var technicalMessage = MessagesCatalog.getMessageContent(MessageCode.M00000019);
                throw CrossCuttingBibliotechException.create(userMessage, technicalMessage);
            }
            connection.commit();
        } catch (final CrossCuttingBibliotechException exception){
            throw exception;
        } catch (final SQLException exception){
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000004);
            var technicalMessage = MessagesCatalog.getMessageContent(MessageCode.M00000020);
            throw CrossCuttingBibliotechException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception){
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000004);
            var technicalMessage = MessagesCatalog.getMessageContent(MessageCode.M00000021);
            throw CrossCuttingBibliotechException.create(exception, userMessage, technicalMessage);
        }
    }

    public static final void cancelTransaction(final Connection connection){
        if (UtilObject.isNull(connection)){
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000004);
            var technicalMessage = MessagesCatalog.getMessageContent(MessageCode.M00000022);
            throw CrossCuttingBibliotechException.create(userMessage, technicalMessage);
        }
        try {
            if (!openConnection(connection)){
                var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000004);
                var technicalMessage = MessagesCatalog.getMessageContent(MessageCode.M00000023);
                throw CrossCuttingBibliotechException.create(userMessage, technicalMessage);
            }
            if (connection.getAutoCommit()){
                var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000004);
                var technicalMessage = MessagesCatalog.getMessageContent(MessageCode.M00000024);
                throw CrossCuttingBibliotechException.create(userMessage, technicalMessage);
            }
            connection.rollback();
        } catch (final CrossCuttingBibliotechException exception){
            throw exception;
        } catch (final SQLException exception){
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000004);
            var technicalMessage = MessagesCatalog.getMessageContent(MessageCode.M00000025);
            throw CrossCuttingBibliotechException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception){
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000004);
            var technicalMessage = MessagesCatalog.getMessageContent(MessageCode.M00000026);
            throw CrossCuttingBibliotechException.create(exception, userMessage, technicalMessage);
        }
    }
}
