package com.zup.apipoc.contacts.adapter.out.persistence.entities;

import lombok.*;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.UUID;

@Entity
@Table(name = "contact")
@Data
@AllArgsConstructor
@NoArgsConstructor

public class ContactJpaEntity {

    @Id
    @GeneratedValue
    @Getter @Setter private UUID id;

    @Getter @Setter private String nome;

    @Getter @Setter private String telefone;

    @Getter @Setter private String email;

}
