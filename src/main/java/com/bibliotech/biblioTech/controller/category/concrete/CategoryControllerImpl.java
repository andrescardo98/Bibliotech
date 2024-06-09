package com.bibliotech.biblioTech.controller.category.concrete;

import com.bibliotech.biblioTech.controller.category.CategoryController;
import com.bibliotech.biblioTech.controller.support.mapper.CategoryResponse;
import com.bibliotech.biblioTech.controller.support.request.RequestCategory;
import com.bibliotech.biblioTech.controller.support.response.Response;
import com.bibliotech.biblioTech.crosscutting.exception.BiblioTechException;
import com.bibliotech.biblioTech.crosscutting.messages.MessagesCatalog;
import com.bibliotech.biblioTech.crosscutting.messages.enumerator.MessageCode;
import com.bibliotech.biblioTech.service.dto.CategoryDTO;
import com.bibliotech.biblioTech.service.facade.concrete.category.DeleteCategoryFacade;
import com.bibliotech.biblioTech.service.facade.concrete.category.ModifyCategoryFacade;
import com.bibliotech.biblioTech.service.facade.concrete.category.RegisterCategoryFacade;
import com.bibliotech.biblioTech.service.facade.concrete.category.SearchCategoryFacade;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.UUID;

@CrossOrigin(origins = "http://127.0.0.1:5500")
@RestController
@RequestMapping("/api/v1/category")
public final class CategoryControllerImpl implements CategoryController {

    private final Logger logger = LoggerFactory.getLogger(CategoryControllerImpl.class);

    @GetMapping("/dummy")
    public RequestCategory getDummy() {
        return new RequestCategory();
    }

    @Override
    @GetMapping
    public ResponseEntity<Response<RequestCategory>> search(
            @RequestParam(name = "id", required = false)UUID uuid,
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "description", required = false) String description,
            @RequestParam(name = "code", required = false) String code) {

        final Response<RequestCategory> response = new Response<>();
        HttpStatusCode httpStatusCode = HttpStatus.BAD_REQUEST;
        var dto = CategoryDTO.create()
                .setId(uuid)
                .setName(name)
                .setDescription(description)
                .setCode(code);

        try {
            SearchCategoryFacade facade = new SearchCategoryFacade();
            response.setData(CategoryResponse.convertListToResponse(facade.execute(dto)));
            httpStatusCode = HttpStatus.OK;
            response.getMessages().add(MessagesCatalog.getMessageContent(MessageCode.M00000088));
        } catch (final BiblioTechException exception){
            response.getMessages().add(exception.getTechnicalMessage());
            logger.error(exception.getTechnicalMessage(), exception.getRootException());
        } catch (final Exception exception){
            httpStatusCode = HttpStatus.INTERNAL_SERVER_ERROR;
            response.getMessages().add(MessagesCatalog.getMessageContent(MessageCode.M00000089));
            logger.error(MessagesCatalog.getMessageContent(MessageCode.M00000089), exception);
        }
        return new ResponseEntity<>(response, httpStatusCode);
    }

    @Override
    @PostMapping
    public final ResponseEntity<Response<RequestCategory>> register(@RequestBody CategoryDTO dto) {
        Response<RequestCategory> response = new Response<>();
        HttpStatusCode httpStatusCode = HttpStatus.BAD_REQUEST;

        try {
            RegisterCategoryFacade facade = new RegisterCategoryFacade();
            facade.execute(dto);
            httpStatusCode = HttpStatus.OK;
            response.getMessages().add(MessagesCatalog.getMessageContent(MessageCode.M00000086));
        } catch (final BiblioTechException exception){
            response.getMessages().add(exception.getTechnicalMessage());
            logger.error(exception.getTechnicalMessage(), exception.getRootException());
        } catch (final Exception exception){
            response.getMessages().add(MessagesCatalog.getMessageContent(MessageCode.M00000032));
            logger.error(MessagesCatalog.getMessageContent(MessageCode.M00000032), exception);
        }

        return new ResponseEntity<>(response, httpStatusCode);
    }


    @PutMapping("/{id}")
    @Override
    public ResponseEntity<Response<RequestCategory>> modify(@PathVariable("id") UUID uuid, @RequestBody RequestCategory req) {
        final Response<RequestCategory> response = new Response<>();
        HttpStatusCode httpStatusCode = HttpStatus.BAD_REQUEST;

        try {
            ModifyCategoryFacade facade = new ModifyCategoryFacade();
            var dto = CategoryDTO.create()
                    .setId(uuid)
                    .setName(req.getName())
                    .setDescription(req.getDescription())
                    .setCode(req.getCode());
            facade.execute(dto);
            httpStatusCode = HttpStatus.OK;
            response.getMessages().add(MessagesCatalog.getMessageContent(MessageCode.M00000087));
        } catch (final BiblioTechException exception){
            response.getMessages().add(exception.getTechnicalMessage());
            logger.error(exception.getTechnicalMessage(), exception.getRootException());
        } catch (final Exception exception){
            response.getMessages().add(MessagesCatalog.getMessageContent(MessageCode.M00000077));
            logger.error(MessagesCatalog.getMessageContent(MessageCode.M00000077), exception);
        }

        return new ResponseEntity<>(response, httpStatusCode);
    }

    @Override
    @DeleteMapping("/code/{categoryCode}")
    public ResponseEntity<Response<RequestCategory>> delete(@PathVariable("categoryCode") String code) {
        final Response<RequestCategory> response = new Response<>();
        HttpStatus httpStatusCode = HttpStatus.BAD_REQUEST;

        try {
            DeleteCategoryFacade facade = new DeleteCategoryFacade();
            var dto = CategoryDTO.create()
                    .setCode(code);
            facade.execute(dto);
            httpStatusCode = HttpStatus.OK;
            response.getMessages().add(MessagesCatalog.getMessageContent(MessageCode.M00000090));
        } catch (final BiblioTechException exception){
            response.getMessages().add(exception.getTechnicalMessage());
            logger.error(exception.getTechnicalMessage(), exception.getRootException());
        } catch (final Exception exception){
            response.getMessages().add(MessagesCatalog.getMessageContent(MessageCode.M00000091));
            logger.error(MessagesCatalog.getMessageContent(MessageCode.M00000091), exception);
        }

        return new ResponseEntity<>(response, httpStatusCode);
    }
}
