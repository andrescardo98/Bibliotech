package com.bibliotech.biblioTech.controller.category;

import com.bibliotech.biblioTech.controller.support.request.RequestCategory;
import com.bibliotech.biblioTech.controller.support.response.Response;
import com.bibliotech.biblioTech.service.dto.CategoryDTO;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.UUID;

@Tag(name = "Category", description = "Ofrece apis de consumo para la categoría")
public interface CategoryController {

    @Operation(summary = "Obtener dummy", description = "Servicio encargado de obtener la estructura de una categoría")
    RequestCategory getDummy();


    @Operation(summary = "Obtener categoría", description = "Servicio encargado de obtener la información de las " +
            "categorías que cumplan los parámetros de consulta")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Categoría consultada exitosamente"),
        @ApiResponse(responseCode = "400", description = "Problema con consulta de categoría"),
        @ApiResponse(responseCode = "500", description = "Problema inesperado")})
    ResponseEntity<Response<RequestCategory>> search(
            @RequestParam(name = "id", required = false)UUID uuid,
            @RequestParam(name = "name", required = false) String name,
            @RequestParam(name = "description", required = false) String description,
            @RequestParam(name = "code", required = false) String code);


    @Operation(summary = "Registrar categoría", description = "Servicio encargado de registrar la información de una categoría")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Categoría registrada exitosamente"),
            @ApiResponse(responseCode = "400", description = "Categoría no registrada"),
            @ApiResponse(responseCode = "500", description = "Problema inesperado al registrar la categoría")})
    ResponseEntity<Response<RequestCategory>> register(@RequestBody CategoryDTO dto);


    @Operation(summary = "Modificar categoría", description = "Servicio encargado de modificar la información de una categoría")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Categoría modificada exitosamente"),
            @ApiResponse(responseCode = "400", description = "Categoría no modificada"),
            @ApiResponse(responseCode = "500", description = "Problema inesperado al modificar la categoría")})
    ResponseEntity<Response<RequestCategory>> modify(@PathVariable("id") UUID uuid, @RequestBody RequestCategory req);


    @Operation(summary = "Eliminar categoría", description = "Servicio encargado de eliminar de forma definitiva una categoría")
    @ApiResponses(value = {@ApiResponse(responseCode = "200", description = "Categoría eliminada exitosamente"),
            @ApiResponse(responseCode = "400", description = "Categoría no eliminada"),
            @ApiResponse(responseCode = "500", description = "Problema inesperado al eliminar la categoría")})
    ResponseEntity<Response<RequestCategory>> delete(@PathVariable("categoryCode") String code);
}
