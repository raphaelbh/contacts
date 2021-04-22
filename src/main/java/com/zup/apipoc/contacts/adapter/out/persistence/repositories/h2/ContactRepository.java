package com.zup.apipoc.contacts.adapter.out.persistence.repositories.h2;

import com.zup.apipoc.contacts.adapter.out.persistence.entities.ContactJpaEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ContactRepository extends JpaRepository<ContactJpaEntity, Long> {
}
