package fr.agregio.call.web;

import fr.agregio.call.service.dto.ProductionGroupDto;
import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.net.URISyntaxException;

@OpenAPIDefinition(
        info = @io.swagger.v3.oas.annotations.info.Info(
                description = "These endpoints are used to manage groups of production, also called producers or power plants",
                version = "0.0.1",
                title = "Controller for handling groups of production"
        )
)
@RestController
@RequestMapping("/v1")
public interface ProductionGroupController {

    /**
     * Creating a new GroupOfProduction entity
     * @param productionGroupDto the group of production to be created, without an id specified
     * @return the persisted GroupOfProduction entity
     */
    @Operation(
            summary = "Create a new group of production",
            description = """
            Endpoint to create a new group of production, hereby called producer, based on details provided in the request body.
            A valid body must be of the following format:
            {
                "type": "SOLAR",
                "productionCost": 1.424
                "powerAgreement": {
                    "minPower": 1,
                    "maxPower": 2
                },
                "blockProducerForecast": []
                ""
            BY convention, 'productionCost' is in €/MWh, while 'minPower' and 'maxPower' are in MW.
            """,
            operationId = "producerCreate",
            tags = "producer"
    )
    @ApiResponses (value = {
            @ApiResponse(responseCode = "201", description = "Group of production created."),
            @ApiResponse(responseCode = "400", description = "Bad request.")
    })
//    @Secured({"ROLE_AGREGIO_GESTIONNAIRE", "ROLE_ADMIN_IT"})
    @PostMapping("/producers")
    ResponseEntity<ProductionGroupDto> create(@Valid @RequestBody ProductionGroupDto productionGroupDto) throws URISyntaxException;

    /**
     * Getting an existing GroupOfProduction entity
     * @param id the ID of group of production to be retrieved
     * @return the GroupOfProduction entity
     */
    @Operation(
            summary = "Get a new group of production by ID",
            description = """
            Endpoint to get a group of production, hereby called producer, based on its ID.
            """,
            operationId = "producerGet",
            tags = "producer"
    )
    @ApiResponses (value = {
            @ApiResponse(responseCode = "200", description = "Group of production retrieved."),
            @ApiResponse(responseCode = "400", description = "Bad request.")
    })
//    @Secured({"ROLE_AGREGIO_GESTIONNAIRE", "ROLE_AGREGIO_TRADER", "ROLE_ADMIN_IT"})
    @GetMapping(value = "/producers/{id}")
    ResponseEntity<ProductionGroupDto> get(@PathVariable("id") final Long id);


    /**
     * Updating an existing GroupOfProduction entity
     * @param productionGroupDto the group of production updated
     * @return the updated persisted GroupOfProduction entity
     */
    @Operation(
            summary = "Update a group of production",
            description = """
            Endpoint to get a group of production, hereby called producer. JSON Body must be a valid ProductionGroupDto 
            object.
            """,
            operationId = "producerUpdate",
            tags = "producer"
    )
    @ApiResponses (value = {
            @ApiResponse(responseCode = "200", description = "Group of production updated."),
            @ApiResponse(responseCode = "400", description = "Bad request.")
    })
    //    @Secured({"ROLE_AGREGIO_GESTIONNAIRE", "ROLE_ADMIN_IT"})
    @PutMapping(value = "/producers/{id}")
    ResponseEntity<ProductionGroupDto> update(@Valid @RequestBody ProductionGroupDto productionGroupDto);


    /**
     * Deleting a GroupOfProduction entity
     * @param id the ID of group of production to be retrieved
     * @return the confirmation that it's been deleted
     */
    @Operation(
            summary = "Delete a group of production",
            description = """
            Endpoint to get a group of production, hereby called producer, based on its ID.
            """,
            operationId = "producerDelete",
            tags = "producer"
    )
    @ApiResponses (value = {
            @ApiResponse(responseCode = "200", description = "Group of production deleted."),
            @ApiResponse(responseCode = "400", description = "Bad request.")
    })
    @DeleteMapping(value = "/producers/{id}")
    ResponseEntity<Void> delete(@PathVariable("id") final Long id);

}
