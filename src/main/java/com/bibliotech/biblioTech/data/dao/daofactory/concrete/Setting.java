package com.bibliotech.biblioTech.data.dao.daofactory.concrete;

import com.bibliotech.biblioTech.crosscutting.exception.concrete.CrossCuttingBibliotechException;
import com.bibliotech.biblioTech.crosscutting.messages.MessagesCatalog;
import com.bibliotech.biblioTech.crosscutting.messages.enumerator.MessageCode;

import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public final class Setting {

    private static final Properties PROPERTIES = new Properties();

    static {
        try (InputStream input = ClassLoader.getSystemResourceAsStream("config.properties")){
            PROPERTIES.load(input);
        }catch (final IOException exception){
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000030);
            var technicalMessage = MessagesCatalog.getMessageContent(MessageCode.M00000031);
            throw CrossCuttingBibliotechException.create(exception, userMessage, technicalMessage);
        }
    }

    public static String getURL() {
        return PROPERTIES.getProperty("db.url");
    }

    public static String getUser() {
        return PROPERTIES.getProperty("db.usuario");
    }

    public static String getPassword() {
        return PROPERTIES.getProperty("db.contrasenia");
    }
}
