package com.zup.apipoc.contacts.adapter.in.web;

import com.zup.apipoc.contacts.adapter.in.web.mappers.ContactResponseMapper;
import com.zup.apipoc.contacts.adapter.in.web.request.CreateContactRequest;
import com.zup.apipoc.contacts.adapter.in.web.response.ContactResponse;
import com.zup.apipoc.contacts.application.port.in.CreateContactCommand;
import com.zup.apipoc.contacts.application.port.in.CreateContactUseCase;
import com.zup.apipoc.contacts.application.port.in.ListContactsUseCase;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
@RequiredArgsConstructor
@Tag(name = "Contact")
public class ContactController {

    private final ContactResponseMapper contactResponseMapper;
    private final CreateContactUseCase createContactUseCase;
    private final ListContactsUseCase listContactsUseCase;

    @Operation(description = "Endpoint to create new contact", summary = "Create new contact")
    @PostMapping
    public ResponseEntity<ContactResponse> createContact(@RequestBody final CreateContactRequest request) {

        var command = CreateContactCommand.builder()
                .email(request.getEmail())
                .name(request.getName())
                .phone(request.getPhone()).build();

        var contact = createContactUseCase.execute(command);
        var contactResponse = contactResponseMapper.to(contact);

        return new ResponseEntity<>(contactResponse, HttpStatus.CREATED);
    }

    @Operation(description = "Endpoint to list all contacts", summary = "List all contacts")
    @GetMapping
    public ResponseEntity<List<ContactResponse>> listContacts() {

        var contacts = listContactsUseCase.execute();
        var contactsResponse = contactResponseMapper.to(contacts);

        return new ResponseEntity<>(contactsResponse, HttpStatus.OK);
    }

}
