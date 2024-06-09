package com.bibliotech.biblioTech.crosscutting.util;

import java.util.UUID;

public class UtilUUID {

    public static final UUID UUID_DEFAULT = new UUID(0L, 0L);

    private UtilUUID() {
        super();
    }

    public static final UUID getUuidDefault(final UUID uuid){
        return UtilObject.getDefaultValue(uuid, UUID_DEFAULT);
    }

    public static final boolean uuidEqual(final UUID uuidOne, final UUID uuidTwo){
        return getUuidDefault(uuidOne).equals(getUuidDefault(uuidTwo));
    }

    public static final UUID getNewUUID(){
        UUID uuid;

        do {
            uuid = UUID.randomUUID();
        } while (isUUIDByDefault(uuid));
        return uuid;
    }

    public static final boolean isUUIDByDefault(final UUID uuid) {
        return uuidEqual(uuid, UUID_DEFAULT);
    }

    public static final UUID getDefaultValue(final UUID uuid, final UUID defaultValue){
        return isNull(uuid) ? defaultValue : uuid;
    }

    public static final UUID getDefaultValue(final UUID defaultValue){
        return getDefaultValue(defaultValue, UUID_DEFAULT);
    }

    public static final UUID generateUUIDEmpty(){
        return UUID_DEFAULT;
    }

    public static final boolean isNull(final UUID uuid) {
        return (uuid == null) || (uuid == UUID_DEFAULT);
    }
}
