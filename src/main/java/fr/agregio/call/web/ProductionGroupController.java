package fr.agregio.call.web;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import jakarta.validation.Valid;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

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
     * @param productionGroupDTO the group of production to be created, without an id specified
     * @return the persisted GroupOfProduction entity
     */
    //TODO add correct JSON body formatting to description
    @Operation(
            summary = "Create a new group of production",
            description = """
            Endpoint to create a new group of production, hereby called producer, based on details provided in the request body.
            A valid body must be of the following format:
            {
                "type": "SOLAR",
                "max_power": {{ max power produced  for sharing kW :: double }} 
            """,
            operationId = "producerCreation",
            tags = "producer"
    )
    @ApiResponses (value = {
            @ApiResponse(responseCode = "201", description = "Group of production created."),
            @ApiResponse(responseCode = "400", description = "Bad request.")
    })
//    @Secured({"ROLE_ADMIN"})
    @PostMapping("/producers")
    ResponseEntity<ProductionGroupDTO> create(@Valid @RequestBody ProductionGroupDTO productionGroupDTO);
}
