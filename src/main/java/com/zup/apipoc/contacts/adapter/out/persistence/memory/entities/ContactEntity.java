package com.zup.apipoc.contacts.adapter.out.persistence.memory.entities;

import lombok.Builder;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.Setter;

@Builder
@EqualsAndHashCode
public class ContactEntity {

    @Setter @Getter private String id;
    @Getter private String name;
    @Getter private String phone;
    @Getter private String email;

}
