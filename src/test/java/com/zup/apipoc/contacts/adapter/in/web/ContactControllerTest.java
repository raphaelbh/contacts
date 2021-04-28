package com.zup.apipoc.contacts.adapter.in.web;

import static org.hamcrest.Matchers.hasSize;
import static org.hamcrest.Matchers.is;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import com.zup.apipoc.contacts.adapter.in.web.mappers.ContactResponseMapper;
import com.zup.apipoc.contacts.adapter.in.web.response.ContactResponse;
import com.zup.apipoc.contacts.application.port.in.CreateContactUseCase;
import com.zup.apipoc.contacts.application.port.in.ListContactsUseCase;
import com.zup.apipoc.contacts.domain.ContactDomain;
import org.junit.jupiter.api.Test;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.MockMvc;

import java.util.Arrays;
import java.util.List;

@WebMvcTest(controllers = ContactController.class)
class ContactControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private CreateContactUseCase createContactUseCase;

    @MockBean
    private ListContactsUseCase listContactsUseCase;

    @MockBean
    private ContactResponseMapper contactResponseMapper;

    @Test
    void createContact() throws Exception {

        var contactDomain = ContactDomain.builder()
                .id("123456")
                .name("John Doe")
                .phone("999999999")
                .email("doe@email.com").build();

        var contactResponse = ContactResponse.builder()
                .id("123456")
                .name("John Doe")
                .phone("999999999")
                .email("doe@email.com").build();

        when(createContactUseCase.execute(any())).thenReturn(contactDomain);
        when(contactResponseMapper.to(any(ContactDomain.class))).thenReturn(contactResponse);

        this.mockMvc.perform(post("/contacts")
                .content("{\"name\":\"John Doe\", " +
                        "\"phone\": \"999999999\", " +
                        "\"email\": \"doe@email.com\"}")
                .header(HttpHeaders.CONTENT_TYPE, MediaType.APPLICATION_JSON))
                .andDo(print())
                .andExpect(status().isCreated())
                .andExpect(jsonPath("$.id", is("123456")))
                .andExpect(jsonPath("$.name", is("John Doe")))
                .andExpect(jsonPath("$.phone", is("999999999")))
                .andExpect(jsonPath("$.email", is("doe@email.com")));
    }

    @Test
    void listContacts() throws Exception {

        var contactDomain = ContactDomain.builder()
                .id("123456")
                .name("John Doe")
                .phone("999999999")
                .email("doe@email.com").build();

        var contactResponse = ContactResponse.builder()
                .id("123456")
                .name("John Doe")
                .phone("999999999")
                .email("doe@email.com").build();

        when(listContactsUseCase.execute()).thenReturn(Arrays.asList(contactDomain));
        when(contactResponseMapper.to(any(List.class))).thenReturn(Arrays.asList(contactResponse));

        this.mockMvc.perform(get("/contacts"))
                .andDo(print())
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)));
    }

}
