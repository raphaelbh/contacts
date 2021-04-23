package com.zup.apipoc.contacts.adapter.in.web;

import com.zup.apipoc.contacts.adapter.in.web.mappers.ContactResponseMapper;
import com.zup.apipoc.contacts.adapter.in.web.request.CreateContactRequest;
import com.zup.apipoc.contacts.adapter.in.web.response.ContactResponse;
import com.zup.apipoc.contacts.application.port.in.CreateContactCommand;
import com.zup.apipoc.contacts.application.port.in.CreateContactUseCase;
import com.zup.apipoc.contacts.application.port.in.ListContactsUseCase;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/contacts")
@RequiredArgsConstructor
public class ContactController {

    private final ContactResponseMapper contactResponseMapper;
    private final CreateContactUseCase createContactUseCase;
    private final ListContactsUseCase listContactsUseCase;

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

    @GetMapping
    public ResponseEntity<List<ContactResponse>> listContacts() {

        var contacts = listContactsUseCase.execute();
        var contactsResponse = contactResponseMapper.to(contacts);

        return new ResponseEntity<>(contactsResponse, HttpStatus.OK);
    }

}
