package com.bibliotech.biblioTech.crosscutting.messages;

import com.bibliotech.biblioTech.crosscutting.exception.concrete.CrossCuttingBibliotechException;
import com.bibliotech.biblioTech.crosscutting.messages.enumerator.MessageCategory;
import com.bibliotech.biblioTech.crosscutting.messages.enumerator.MessageCode;
import com.bibliotech.biblioTech.crosscutting.messages.enumerator.MessageType;
import com.bibliotech.biblioTech.crosscutting.util.UtilObject;

import java.util.HashMap;
import java.util.Map;

public class MessagesCatalog {

    private static final String VERIFICAR_TRAZA = "Por favor verifique la traza completa del error presentado, para así poder "
            + "diagnosticar con mayor certeza, qué sucedió...";
    private static final String PROBLEMA_SQLEXCEPCION = "Se ha presentado un problema de tipo SQLException ";
    private static final String PROBLEMA_EXCEPCION = "Se ha presentado un problema inesperado de tipo Exception ";
    private static final String  METODO_CONSULTAR_POR_ID= " en el método consultarPorID de la clase CategoryPostgreSQL tratando de ";
    private static final Map<MessageCode, Message> MENSAJES = new HashMap<>();

    static {
        loadMessages();
    }

    public MessagesCatalog() {
        super();
    }

    private static final void loadMessages(){
        addMessage(Message.create(MessageCode.M00000001, MessageType.TECHNICIAN, MessageCategory.FATAL,
                "No se recibió el código de mensaje que se quería crear. No es posible continuar con el proceso..."));

        addMessage(Message.create(MessageCode.M00000002, MessageType.TECHNICIAN, MessageCategory.FATAL,
                "No existe un mensaje con el código indicado. No es posible continuar con el proceso..."));

        addMessage(Message.create(MessageCode.M00000003, MessageType.TECHNICIAN, MessageCategory.FATAL,
                "No es posible obtener un mensaje con un código vacío o nulo. No es posible continuar con el proceso..."));

        addMessage(Message.create(MessageCode.M00000004, MessageType.USER, MessageCategory.FATAL,
                "Se ha presentado un problema inesperado tratando de llevar a cabo la operación deseada. Por favor "
                        + "intente de nuevo y si el problema persiste, contacte al administrador de la aplicación"));

        addMessage(Message.create(MessageCode.M00000005, MessageType.TECHNICIAN, MessageCategory.ERROR,
                PROBLEMA_SQLEXCEPCION + " tratando de validar si la conexión SQL estaba abierta. "
                        + VERIFICAR_TRAZA));

        addMessage(Message.create(MessageCode.M00000006, MessageType.TECHNICIAN, MessageCategory.ERROR,
                PROBLEMA_EXCEPCION + " tratando de validar si la conexión SQL estaba abierta. " + VERIFICAR_TRAZA));

        addMessage(Message.create(MessageCode.M00000007, MessageType.TECHNICIAN, MessageCategory.FATAL,
                "No es posible cerrar una conexión que está nula..."));

        addMessage(Message.create(MessageCode.M00000008, MessageType.TECHNICIAN, MessageCategory.FATAL,
                "No es posible cerrar una conexión que ya está cerrada..."));

        addMessage(Message.create(MessageCode.M00000009, MessageType.TECHNICIAN, MessageCategory.FATAL,
                "No es posible validar si una conexión está abierta cuando es nula..."));

        addMessage(Message.create(MessageCode.M00000010, MessageType.TECHNICIAN, MessageCategory.FATAL,
                PROBLEMA_SQLEXCEPCION + "Se ha presentado un problema tratando de cerrar una conexión SQL. " + VERIFICAR_TRAZA));

        addMessage(Message.create(MessageCode.M00000011, MessageType.TECHNICIAN, MessageCategory.ERROR,
                PROBLEMA_EXCEPCION + " tratando de cerrar la conexión. " + VERIFICAR_TRAZA));

        addMessage(Message.create(MessageCode.M00000012, MessageType.TECHNICIAN, MessageCategory.FATAL,
                "No es posible iniciar una transacción con una conexión que está nula..."));

        addMessage(Message.create(MessageCode.M00000013, MessageType.TECHNICIAN, MessageCategory.FATAL,
                "No es posible iniciar una transaccion con una conexión cerrada..."));

        addMessage(Message.create(MessageCode.M00000014, MessageType.TECHNICIAN, MessageCategory.FATAL,
                "No es posible iniciar una transaccion que ya ha sido iniciada..."));

        addMessage(Message.create(MessageCode.M00000015, MessageType.TECHNICIAN, MessageCategory.FATAL,
                PROBLEMA_SQLEXCEPCION + " tratando de iniciar la transacción de una conexión SQL. " + VERIFICAR_TRAZA));

        addMessage(Message.create(MessageCode.M00000016, MessageType.TECHNICIAN, MessageCategory.ERROR,
                PROBLEMA_EXCEPCION + " tratando de iniciar una transacción de una conexión. " + VERIFICAR_TRAZA));

        addMessage(Message.create(MessageCode.M00000017, MessageType.TECHNICIAN, MessageCategory.FATAL,
                "No es posible confirmar una transacción con una conexión que está nula..."));

        addMessage(Message.create(MessageCode.M00000018, MessageType.TECHNICIAN, MessageCategory.FATAL,
                "No es posible confirmar una transaccion con una conexión cerrada..."));

        addMessage(Message.create(MessageCode.M00000019, MessageType.TECHNICIAN, MessageCategory.FATAL,
                "No es posible confirmar una transaccion que no fue iniciada..."));

        addMessage(Message.create(MessageCode.M00000020, MessageType.TECHNICIAN, MessageCategory.FATAL,
                PROBLEMA_SQLEXCEPCION + " tratando de confirmar la transacción de una conexión SQL. "
                        + VERIFICAR_TRAZA));

        addMessage(Message.create(MessageCode.M00000021, MessageType.TECHNICIAN, MessageCategory.ERROR,
                PROBLEMA_EXCEPCION + " tratando de confirmar la transacción de una conexión. " + VERIFICAR_TRAZA));

        addMessage(Message.create(MessageCode.M00000022, MessageType.TECHNICIAN, MessageCategory.FATAL,
                "No es posible cancelar una transacción con una conexión que está nula..."));

        addMessage(Message.create(MessageCode.M00000023, MessageType.TECHNICIAN, MessageCategory.FATAL,
                "No es posible cancelar una transaccion con una conexión cerrada..."));

        addMessage(Message.create(MessageCode.M00000024, MessageType.TECHNICIAN, MessageCategory.FATAL,
                "No es posible cancelar una transaccion que no fue iniciada..."));

        addMessage(Message.create(MessageCode.M00000025, MessageType.TECHNICIAN, MessageCategory.FATAL,
                PROBLEMA_SQLEXCEPCION + " tratando de cancelar la transacción de una conexión SQL. " + VERIFICAR_TRAZA));

        addMessage(Message.create(MessageCode.M00000026, MessageType.TECHNICIAN, MessageCategory.ERROR,
                PROBLEMA_EXCEPCION + " tratando de cancelar la transacción de una conexión. " + VERIFICAR_TRAZA));

        addMessage(Message.create(MessageCode.M00000027, MessageType.TECHNICIAN, MessageCategory.FATAL,
                "No es posible abrir la conexión. Se ha presentado un prooblema SQL..."));

        addMessage(Message.create(MessageCode.M00000028, MessageType.TECHNICIAN, MessageCategory.FATAL,
                "No es posible encontrar la clase para abrir la conexión..."));

        addMessage(Message.create(MessageCode.M00000029, MessageType.TECHNICIAN, MessageCategory.ERROR,
                PROBLEMA_EXCEPCION + " tratando de abrir la conexión. " + VERIFICAR_TRAZA));

        addMessage(Message.create(MessageCode.M00000030, MessageType.USER, MessageCategory.ERROR,
                "Se ha presentado un problema tratando de leer el archivo de configuración."));

        addMessage(Message.create(MessageCode.M00000031, MessageType.TECHNICIAN, MessageCategory.ERROR,
                "Se ha presentado un problema de tipo IOException en la clase Configuración tratando de leer el archivo "
                        + "de configuración. " + VERIFICAR_TRAZA));

        addMessage(Message.create(MessageCode.M00000032, MessageType.USER, MessageCategory.ERROR,
                "Se ha presentado un problema tratando de registar la información de la nueva categoría."));

        addMessage(Message.create(MessageCode.M00000033, MessageType.TECHNICIAN, MessageCategory.ERROR,
                PROBLEMA_SQLEXCEPCION + "en el método crear de la clase CategoryPostgreSQL tratando " +
                        "de llevar a cabo el registro de la nueva categoría. " + VERIFICAR_TRAZA));

        addMessage(Message.create(MessageCode.M00000034, MessageType.TECHNICIAN, MessageCategory.ERROR,
                PROBLEMA_EXCEPCION + "en el método crear de la clase CategoryPostgreSQL tratando " +
                        "de llevar a cabo el registro de la nueva categoría. " + VERIFICAR_TRAZA));

        addMessage(Message.create(MessageCode.M00000035, MessageType.TECHNICIAN, MessageCategory.ERROR,
                "Se ha presentado un problema tratando de crear el DAO deseado, debido a que la conexión " +
                        "actualmente está cerrada. Por lo que no hay una conexión válida disponible."));

        addMessage(Message.create(MessageCode.M00000036, MessageType.USER, MessageCategory.ERROR,
                "Se ha presentado un problema tratando de modificar la información de la categoría deseada."));

        addMessage(Message.create(MessageCode.M00000037, MessageType.TECHNICIAN, MessageCategory.ERROR,
                PROBLEMA_SQLEXCEPCION + "en el método modificar de la clase CategoryPostgreSQL tratando " +
                        "de llevar a cabo la actualización de los datos de la categoría deseada. " + VERIFICAR_TRAZA));

        addMessage(Message.create(MessageCode.M00000038, MessageType.TECHNICIAN, MessageCategory.ERROR,
                PROBLEMA_EXCEPCION + "en el método modificar de la clase CategoryPostgreSQL tratando " +
                        "de llevar a cabo la actualización de los datos de la categoría deseada. " + VERIFICAR_TRAZA));

        addMessage(Message.create(MessageCode.M00000039, MessageType.USER, MessageCategory.ERROR,
                "Se ha presentado un problema tratando de consultar la información de la categoría por el" +
                        " identificador deseado."));

        addMessage(Message.create(MessageCode.M00000040, MessageType.TECHNICIAN, MessageCategory.ERROR,
                PROBLEMA_SQLEXCEPCION + METODO_CONSULTAR_POR_ID +
                        "recuperar los datos de la consulta Categoría deseada " + VERIFICAR_TRAZA));

        addMessage(Message.create(MessageCode.M00000041, MessageType.TECHNICIAN, MessageCategory.ERROR,
                PROBLEMA_SQLEXCEPCION + METODO_CONSULTAR_POR_ID +
                        "preparar la sentencia SQL de la consulta de la Categoría deseada" + VERIFICAR_TRAZA));

        addMessage(Message.create(MessageCode.M00000042, MessageType.TECHNICIAN, MessageCategory.ERROR,
                PROBLEMA_EXCEPCION + METODO_CONSULTAR_POR_ID +
                        "preparar la sentencia SQL de la consulta de la Categoría deseada" + VERIFICAR_TRAZA));

        addMessage(Message.create(MessageCode.M00000043, MessageType.USER, MessageCategory.ERROR,
                "Se ha presentado un problema tratando de eliminar la información de la categoría por el" +
                        " identificador deseado."));

        addMessage(Message.create(MessageCode.M00000044, MessageType.TECHNICIAN, MessageCategory.ERROR,
                PROBLEMA_SQLEXCEPCION + "en el método eliminar de la clase CategoryPostgreSQL " +
                        "tratando de llevar a cabo la eliminación del Tipo de Identificación deseado." + VERIFICAR_TRAZA));

        addMessage(Message.create(MessageCode.M00000045, MessageType.TECHNICIAN, MessageCategory.ERROR,
                PROBLEMA_EXCEPCION + "en el método eliminar de la clase CategoryPostgreSQL " +
                        "tratando de llevar a cabo la eliminación del Tipo de Identificación deseado." + VERIFICAR_TRAZA));

        addMessage(Message.create(MessageCode.M00000046, MessageType.TECHNICIAN, MessageCategory.ERROR,
                PROBLEMA_EXCEPCION + METODO_CONSULTAR_POR_ID +
                        "recuperar los datos de la consulta Tipo de Identificación deseado. " + VERIFICAR_TRAZA));

        addMessage(Message.create(MessageCode.M00000047, MessageType.USER, MessageCategory.ERROR,
                "Se ha presentado un problema tratando de llevar a cabo la consulta de las Categorías..."));

        addMessage(Message.create(MessageCode.M00000048, MessageType.TECHNICIAN, MessageCategory.ERROR,
                PROBLEMA_SQLEXCEPCION + "en el método consultar de la clase CategoryPostgreSQL " +
                        "tratando de consultar la categoría deseada." + VERIFICAR_TRAZA));

        addMessage(Message.create(MessageCode.M00000049, MessageType.TECHNICIAN, MessageCategory.ERROR,
                PROBLEMA_EXCEPCION + "en el método consultar de la clase CategoryPostgreSQL " +
                        "tratando de consultar la categoría deseada." + VERIFICAR_TRAZA));

        addMessage(Message.create(MessageCode.M00000050, MessageType.TECHNICIAN, MessageCategory.ERROR,
                PROBLEMA_SQLEXCEPCION + "en el método putParametersQuery de la clase " +
                        "CategoryPostgreSQLDAO tratando de colocar los parámetros de la consulta SQL. " + VERIFICAR_TRAZA));

        addMessage(Message.create(MessageCode.M00000051, MessageType.TECHNICIAN, MessageCategory.ERROR,
                PROBLEMA_EXCEPCION + "en el método putParametersQuery de la clase " +
                        "CategoryPostgreSQLDAO tratando de colocar los parámetros de la consulta SQL. " + VERIFICAR_TRAZA));

        addMessage(Message.create(MessageCode.M00000052, MessageType.TECHNICIAN, MessageCategory.ERROR,
                PROBLEMA_SQLEXCEPCION + "en el método runQuery de la clase CategoryPostgreSQLDAO " +
                        "tratando de ejecutar la consulta SQL. " + VERIFICAR_TRAZA));

        addMessage(Message.create(MessageCode.M00000053, MessageType.TECHNICIAN, MessageCategory.ERROR,
                PROBLEMA_EXCEPCION + "en el método runQuery de la clase CategoryPostgreSQLDAO " +
                        "tratando de ejecutar la consulta SQL. " + VERIFICAR_TRAZA));

        addMessage(Message.create(MessageCode.M00000054, MessageType.TECHNICIAN, MessageCategory.ERROR,
                "No se pudieron obtener credenciales de la base de datos"));

        addMessage(Message.create(MessageCode.M00000055, MessageType.TECHNICIAN, MessageCategory.ERROR,
                "Ya existe una categoría con el código "));

        addMessage(Message.create(MessageCode.M00000056, MessageType.TECHNICIAN, MessageCategory.ERROR,
                "Ya existe una categoría con el nombre "));

        addMessage(Message.create(MessageCode.M00000057, MessageType.TECHNICIAN, MessageCategory.ERROR,
                "No existe una categoría a modificar con el identificador ingresado."));

        addMessage(Message.create(MessageCode.M00000058, MessageType.TECHNICIAN, MessageCategory.ERROR,
                "Ya existe una categoría con el código ingresado: "));

        addMessage(Message.create(MessageCode.M00000059, MessageType.TECHNICIAN, MessageCategory.ERROR,
                "Ya existe una categoría con el nombre ingresado: "));

        addMessage(Message.create(MessageCode.M00000060, MessageType.TECHNICIAN, MessageCategory.ERROR,
                "Se ha presentado un problema llevando a cabo la actualización de la información de la" +
                        " nueva categoría..."));

        addMessage(Message.create(MessageCode.M00000061, MessageType.TECHNICIAN, MessageCategory.ERROR,
                "Se ha presentado un problema en el método setFactoria de la clase ModifyCategoryUseCase," +
                        " debido a que la factoría con la que se desea actualizar está nula..."));

        addMessage(Message.create(MessageCode.M00000062, MessageType.TECHNICIAN, MessageCategory.ERROR,
                "El Id de la categoría no puede ser igual al Id por defecto..."));

        addMessage(Message.create(MessageCode.M00000063, MessageType.TECHNICIAN, MessageCategory.ERROR,
                "La longitud del código de la categoría no es valida. La longitud máxima es de 3 caracteres..."));

        addMessage(Message.create(MessageCode.M00000064, MessageType.TECHNICIAN, MessageCategory.ERROR,
                "El código de la categoría es un dato obligatorio..."));

        addMessage(Message.create(MessageCode.M00000065, MessageType.TECHNICIAN, MessageCategory.ERROR,
                "El código de la categoría debe contener solo letras..."));

        addMessage(Message.create(MessageCode.M00000066, MessageType.TECHNICIAN, MessageCategory.ERROR,
                "La longitud del nombre de la categoría no es valida. La longitud máxima es de 70 caracteres..."));

        addMessage(Message.create(MessageCode.M00000067, MessageType.TECHNICIAN, MessageCategory.ERROR,
                "El nombre de la categoría es un dato obligatorio..."));

        addMessage(Message.create(MessageCode.M00000068, MessageType.TECHNICIAN, MessageCategory.ERROR,
                "El nombre de la categoría debe contener solo letras, dígitos y espacios internos..."));

        addMessage(Message.create(MessageCode.M00000069, MessageType.TECHNICIAN, MessageCategory.ERROR,
                "No es posible llevar a cabo la operación deseada con la categoría, debido " +
                        "a que no existen datos para llevarla a cabo..."));

        addMessage(Message.create(MessageCode.M00000070, MessageType.USER, MessageCategory.ERROR,
                "Se ha presentado un problema llevando a cabo el registro de la información de la " +
                        "nueva categoría"));

        addMessage(Message.create(MessageCode.M00000071, MessageType.TECHNICIAN, MessageCategory.ERROR,
                "Se ha presentado un problema en el método setFactory de la clase RegisterCategoryUseCase," +
                        " debido a que la factoría con la que se desea crear está nula..."));

        addMessage(Message.create(MessageCode.M00000072, MessageType.TECHNICIAN, MessageCategory.ERROR,
                "Se ha presentado un problema en el metodo toDomain de la clase CategoryDTOMapper. " +
                        "No es posible mapear una categoría domain a partir de una entidad de Category dto nula..."));

        addMessage(Message.create(MessageCode.M00000073, MessageType.TECHNICIAN, MessageCategory.ERROR,
                "Se ha presentado un problema en el metodo toDto de la clase CategoryDTOMapper. No es " +
                        "posible mapear una categoría dto a partir de una entidad de Category domain nula..."));

        addMessage(Message.create(MessageCode.M00000074, MessageType.USER, MessageCategory.ERROR,
                "Se presento un problema tratando de registrar la nueva categoría"));

        addMessage(Message.create(MessageCode.M00000075, MessageType.TECHNICIAN, MessageCategory.ERROR,
                PROBLEMA_EXCEPCION+ "en la el método execute de la clase RegisterCategoryFacade, " +
                        "tratando de registrar la nueva categoría." + VERIFICAR_TRAZA));

        addMessage(Message.create(MessageCode.M00000076, MessageType.USER, MessageCategory.ERROR,
                "Se presento un problema tratando de modificar la categoría"));

        addMessage(Message.create(MessageCode.M00000077, MessageType.TECHNICIAN, MessageCategory.ERROR,
                PROBLEMA_EXCEPCION+ "en la el método execute de la clase ModifyCategoryFacade, " +
                        "tratando de modificar la categoría." + VERIFICAR_TRAZA));

        addMessage(Message.create(MessageCode.M00000078, MessageType.TECHNICIAN, MessageCategory.ERROR,
                "Se ha presentado un problema llevando a cabo la eliminación de la información de la" +
                        " categoría..."));

        addMessage(Message.create(MessageCode.M00000079, MessageType.TECHNICIAN, MessageCategory.ERROR,
                "Se ha presentado un problema en el método setFactory de la clase DeleteCategoryUseCase," +
                        " debido a que la factoría con la que se desea eliminar está nula..."));

        addMessage(Message.create(MessageCode.M00000080, MessageType.USER, MessageCategory.ERROR,
                "Se presento un problema tratando de eliminar la categoría"));

        addMessage(Message.create(MessageCode.M00000081, MessageType.TECHNICIAN, MessageCategory.ERROR,
                PROBLEMA_EXCEPCION+ "en la el método execute de la clase DeleteCategoryFacade, " +
                        "tratando de eliminar la categoría." + VERIFICAR_TRAZA));

        addMessage(Message.create(MessageCode.M00000082, MessageType.TECHNICIAN, MessageCategory.ERROR,
                "Se ha presentado un problema llevando a cabo la consulta de la información de la categoría..."));

        addMessage(Message.create(MessageCode.M00000083, MessageType.TECHNICIAN, MessageCategory.ERROR,
                "Se ha presentado un problema en el método setFactory de la clase SearchCategoryUseCase," +
                        " debido a que la factoría con la que se desea actualizar está nula..."));

        addMessage(Message.create(MessageCode.M00000084, MessageType.USER, MessageCategory.ERROR,
                "Se presento un problema tratando de consultar la categoría"));

        addMessage(Message.create(MessageCode.M00000085, MessageType.TECHNICIAN, MessageCategory.ERROR,
                PROBLEMA_EXCEPCION+ "en la el método execute de la clase SearchCategoryFacade, " +
                        "tratando de consultar la categoría." + VERIFICAR_TRAZA));

        addMessage(Message.create(MessageCode.M00000086, MessageType.USER, MessageCategory.ERROR,
                "La categoría fue registrada exitosamente"));

        addMessage(Message.create(MessageCode.M00000087, MessageType.USER, MessageCategory.ERROR,
                "La categoría fue modificada exitosamente"));

        addMessage(Message.create(MessageCode.M00000088, MessageType.TECHNICIAN, MessageCategory.ERROR,
                "La categoría fue consultada exitosamente"));

        addMessage(Message.create(MessageCode.M00000089, MessageType.USER, MessageCategory.ERROR,
                "Se ha presentado un problema tratando de llevar a cabo la consulta de datos de una categoría"));

        addMessage(Message.create(MessageCode.M00000090, MessageType.TECHNICIAN, MessageCategory.ERROR,
                "La categoría fue eliminada exitosamente"));

        addMessage(Message.create(MessageCode.M00000091, MessageType.USER, MessageCategory.ERROR,
                "Se ha presentado un problema tratando eliminar una categoría"));


        addMessage(Message.create(MessageCode.M00000092, MessageType.TECHNICIAN, MessageCategory.ERROR,
                "No existe una categoría a eliminar con el código ingresado."));

        addMessage(Message.create(MessageCode.M00000093, MessageType.TECHNICIAN, MessageCategory.ERROR,
                "No existe una categoría a modificar con el código ingresado."));

        addMessage(Message.create(MessageCode.M00000094, MessageType.TECHNICIAN, MessageCategory.ERROR,
                "La categoría fue consultada por código exitosamente"));

        addMessage(Message.create(MessageCode.M00000095, MessageType.USER, MessageCategory.ERROR,
                "Se ha presentado un problema tratando de llevar a cabo la consulta por " +
                        "código de una categoría"));
    }

    private static final void addMessage(final Message message) {
        MENSAJES.put(message.getCode(), message);
    }

    public static final Message getMessage(final MessageCode code){
        if (UtilObject.isNull(code)){
            var userMessage = getMessage(MessageCode.M00000004).getContent();
            var technicalMessage = getMessage(MessageCode.M00000003).getContent();
            throw CrossCuttingBibliotechException.create(userMessage, technicalMessage);
        }
        if (!MENSAJES.containsKey(code)){
            var userMessage = getMessage(MessageCode.M00000004).getContent();
            var technicalMessage = getMessage(MessageCode.M00000002).getContent();
            throw CrossCuttingBibliotechException.create(userMessage, technicalMessage);
        }
        return MENSAJES.get(code);
    }

    public static final String getMessageContent(final MessageCode code){
        return getMessage(code).getContent();
    }
}
