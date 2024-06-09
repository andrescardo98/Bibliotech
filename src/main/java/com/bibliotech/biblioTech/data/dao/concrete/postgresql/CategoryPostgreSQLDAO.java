package com.bibliotech.biblioTech.data.dao.concrete.postgresql;

import com.bibliotech.biblioTech.crosscutting.exception.concrete.DataBibliotechException;
import com.bibliotech.biblioTech.crosscutting.messages.MessagesCatalog;
import com.bibliotech.biblioTech.crosscutting.messages.enumerator.MessageCode;
import com.bibliotech.biblioTech.crosscutting.util.UtilObject;
import com.bibliotech.biblioTech.crosscutting.util.UtilText;
import com.bibliotech.biblioTech.crosscutting.util.UtilUUID;
import com.bibliotech.biblioTech.data.dao.base.SQLDAO;
import com.bibliotech.biblioTech.data.dao.CategoryDAO;
import com.bibliotech.biblioTech.data.entity.CategoryEntity;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;
import java.util.UUID;

public final class CategoryPostgreSQLDAO extends SQLDAO implements CategoryDAO {

    private static final String SENTENCE_WHERE = "WHERE id = ? ";

    public CategoryPostgreSQLDAO(final Connection connection) {
        super(connection);
    }

    @Override
    public final void create(final CategoryEntity entity) {
        final var sentence = new StringBuilder();

        sentence.append("INSERT INTO Category (id, code, name, description) ");
        sentence.append("VALUES (?, ?, ?, ?) ");

        try (final var preparedSentence = getConnection().prepareStatement(sentence.toString())){
            preparedSentence.setObject(1, entity.getId());
            preparedSentence.setString(2, entity.getName());
            preparedSentence.setString(3, entity.getDescription());
            preparedSentence.setString(4, entity.getCode());

            preparedSentence.executeUpdate();
        } catch (final SQLException exception){
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000032);
            var technicalMessage = MessagesCatalog.getMessageContent(MessageCode.M00000033);
            throw DataBibliotechException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception){
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000032);
            var technicalMessage = MessagesCatalog.getMessageContent(MessageCode.M00000034);
            throw DataBibliotechException.create(exception, userMessage, technicalMessage);
        }
    }

    @Override
    public final void modify(final CategoryEntity entity) {
        final var sentence = new StringBuilder();

        sentence.append("UPDATE Category ");
        sentence.append("SET name = ?, description = ?, code = ? ");
        sentence.append(SENTENCE_WHERE);

        try (final var preparedSentence = getConnection().prepareStatement(sentence.toString())){

            preparedSentence.setString(1, entity.getName());
            preparedSentence.setString(2, entity.getDescription());
            preparedSentence.setString(3, entity.getCode());
            preparedSentence.setObject(4, entity.getId());

            preparedSentence.executeUpdate();

        } catch (final SQLException exception){
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000036);
            var technicalMessage = MessagesCatalog.getMessageContent(MessageCode.M00000037);
            throw DataBibliotechException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception){
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000036);
            var technicalMessage = MessagesCatalog.getMessageContent(MessageCode.M00000038);
            throw DataBibliotechException.create(exception, userMessage, technicalMessage);
        }
    }

    @Override
    public final void delete(final UUID id) {
        final var sentence = new StringBuilder();

        sentence.append("DELETE FROM Category ");
        sentence.append(SENTENCE_WHERE);

        try (final var preparedSentence = getConnection().prepareStatement(sentence.toString())){

            preparedSentence.setObject(1, id);

            preparedSentence.executeUpdate();

        }catch (final SQLException exception){
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000043);
            var technicalMessage = MessagesCatalog.getMessageContent(MessageCode.M00000044);
            throw DataBibliotechException.create(exception, userMessage, technicalMessage);
        }catch (final Exception exception){
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000043);
            var technicalMessage = MessagesCatalog.getMessageContent(MessageCode.M00000045);
            throw DataBibliotechException.create(exception, userMessage, technicalMessage);
        }
    }

    @Override
    public final Optional<CategoryEntity> searchById(final UUID id) {
        final var sentence = new StringBuilder();
        sentence.append("SELECT id, name, description, code ");
        sentence.append("FROM Category ");
        sentence.append(SENTENCE_WHERE);

        Optional<CategoryEntity> result = Optional.empty();

        try (final var preparedSentence = getConnection().prepareStatement(sentence.toString())){
            preparedSentence.setObject(1, id);
            result = executeSearchById(preparedSentence);

        } catch (final DataBibliotechException exception){
            throw exception;
        } catch (final SQLException exception){
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000039);
            var technicalMessage = MessagesCatalog.getMessageContent(MessageCode.M00000041);
            throw DataBibliotechException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception){
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000039);
            var technicalMessage = MessagesCatalog.getMessageContent(MessageCode.M00000042);
            throw DataBibliotechException.create(exception, userMessage, technicalMessage);
        }
        return result;
    }

    private final Optional<CategoryEntity> executeSearchById(final PreparedStatement preparedStatement){
        Optional<CategoryEntity> result = Optional.empty();

        try (final var results = preparedStatement.executeQuery()){
            if (results.next()){
                var categoryEntity = CategoryEntity.create(UUID.fromString(results.getObject("id").toString()),
                        results.getString("name"), results.getString("description"),
                        results.getString("code"));

                result = Optional.of(categoryEntity);
            }
        } catch (final SQLException exception){
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000039);
            var technicalMessage = MessagesCatalog.getMessageContent(MessageCode.M00000040);
            throw DataBibliotechException.create(exception, userMessage, technicalMessage);
        }catch (final Exception exception){
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000039);
            var technicalMessage = MessagesCatalog.getMessageContent(MessageCode.M00000046);
            throw DataBibliotechException.create(exception, userMessage, technicalMessage);
        }

        return result;
    }

    @Override
    public final List<CategoryEntity> search(final CategoryEntity entity) {
        final var parameters = new ArrayList<Object>();
        final String sentence = formingSentenceQuery(entity, parameters);

        try (final var preparedSentence = getConnection().prepareStatement(sentence)){

            putParametersQuery(preparedSentence, parameters);
            return runQuery(preparedSentence);

        } catch (final DataBibliotechException exception){
            throw exception;
        } catch (final SQLException exception){
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000047);
            var technicalMessage = MessagesCatalog.getMessageContent(MessageCode.M00000048);
            throw DataBibliotechException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception){
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000047);
            var technicalMessage = MessagesCatalog.getMessageContent(MessageCode.M00000049);
            throw DataBibliotechException.create(exception, userMessage, technicalMessage);
        }
    }

    private final String formingSentenceQuery(final CategoryEntity entity, final List<Object> parameters){
        final var sentence = new StringBuilder();
        String conditionalOperator = "WHERE ";

        sentence.append("SELECT id, name, description, code ");
        sentence.append("FROM Category ");

        if (!UtilObject.isNull(entity)){
            if (!UtilUUID.isUUIDByDefault(entity.getId())){
                sentence.append(conditionalOperator).append(" id = ? ");
                conditionalOperator = "AND";
                parameters.add(entity.getId());
            }

            if (!UtilText.isEmpty(entity.getName())){
                sentence.append(conditionalOperator).append(" name = ? ");
                conditionalOperator = "AND";
                parameters.add(entity.getName());
            }

            if (!UtilText.isEmpty(entity.getDescription())){
                sentence.append(conditionalOperator).append(" description = ? ");
                conditionalOperator = "AND";
                parameters.add(entity.getDescription());
            }

            if (!UtilText.isEmpty(entity.getCode())){
                sentence.append(conditionalOperator).append(" code = ? ");
                parameters.add(entity.getCode());
            }
        }
        sentence.append("ORDER BY code ASC ");
        return sentence.toString();
    }

    private final void putParametersQuery(final PreparedStatement preparedStatement, final List<Object> parameters){
        try {
            for (int indice = 0; indice < parameters.size(); indice++) {
                preparedStatement.setObject(indice + 1, parameters.get(indice));
            }
        }catch (final SQLException exception){
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000047);
            var technicalMessage = MessagesCatalog.getMessageContent(MessageCode.M00000050);
            throw DataBibliotechException.create(exception, userMessage, technicalMessage);
        }catch (final Exception exception){
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000047);
            var technicalMessage = MessagesCatalog.getMessageContent(MessageCode.M00000051);
            throw DataBibliotechException.create(exception, userMessage, technicalMessage);
        }
    }

    private final List<CategoryEntity> runQuery(final PreparedStatement preparedStatement){

        final var resultsList = new ArrayList<CategoryEntity>();

        try (final var results = preparedStatement.executeQuery()){
            while (results.next()){
                var categoryEntity = CategoryEntity.create(
                        UUID.fromString(results.getObject("id").toString()),
                        results.getString("name"), results.getString("description"),
                        results.getString("code"));

                resultsList.add(categoryEntity);
            }
        } catch (final SQLException exception){
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000047);
            var technicalMessage = MessagesCatalog.getMessageContent(MessageCode.M00000052);
            throw DataBibliotechException.create(exception, userMessage, technicalMessage);
        } catch (final Exception exception){
            var userMessage = MessagesCatalog.getMessageContent(MessageCode.M00000047);
            var technicalMessage = MessagesCatalog.getMessageContent(MessageCode.M00000053);
            throw DataBibliotechException.create(exception, userMessage, technicalMessage);
        }
        return resultsList;
    }
}
