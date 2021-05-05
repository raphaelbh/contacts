package com.zup.contacts.contact.adapter.in.web;

import com.zup.contacts.contact.adapter.in.web.mappers.ContactResponseMapper;
import com.zup.contacts.contact.adapter.in.web.request.CreateContactRequest;
import com.zup.contacts.contact.adapter.in.web.response.ContactResponse;
import com.zup.contacts.contact.application.port.in.CreateContactCommand;
import com.zup.contacts.contact.application.port.in.CreateContactUseCase;
import com.zup.contacts.contact.application.port.in.ListContactsUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.media.Content;
import io.swagger.v3.oas.annotations.media.Schema;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.responses.ApiResponses;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/contacts")
@Tag(name = "Contact", description = "gathers all endpoints referring to the contacts resource")
public class ContactController {

    private final ContactResponseMapper contactResponseMapper;
    private final CreateContactUseCase createContactUseCase;
    private final ListContactsUseCase listContactsUseCase;

    @Operation(description = "Endpoint to create new contact", summary = "create contact")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "201", description = "successfully created contact",
            content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ContactResponse.class))}),
            @ApiResponse(responseCode = "400", description = "Request with invalid format", content = @Content),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @PostMapping
    public ResponseEntity<ContactResponse> createContact(@RequestBody final CreateContactRequest request) {

        var command = CreateContactCommand.builder()
                .email(request.getEmail())
                .name(request.getName())
                .phone(request.getPhone()).build();

        var contact = createContactUseCase.execute(command);
        var contactResponse = contactResponseMapper.domainToResponse(contact);

        return new ResponseEntity<>(contactResponse, HttpStatus.CREATED);
    }

    @Operation(description = "Endpoint to list all contacts", summary = "List all contacts")
    @ApiResponses(value = {
            @ApiResponse(responseCode = "200", description = "list all contacts registered in the database",
                    content = { @Content(mediaType = "application/json", schema = @Schema(implementation = ContactResponse.class))}),
            @ApiResponse(responseCode = "500", description = "Internal server error", content = @Content)
    })
    @GetMapping
    public ResponseEntity<List<ContactResponse>> listContacts() {

        var contacts = listContactsUseCase.execute();
        var contactsResponse = contactResponseMapper.domainToResponse(contacts);

        return new ResponseEntity<>(contactsResponse, HttpStatus.OK);
    }

}
