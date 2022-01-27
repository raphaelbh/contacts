package com.zup.contacts.contacts.adapter.out.persistence.dynamodb.repositories;

import com.zup.contacts.contacts.adapter.out.persistence.dynamodb.tables.ContactTable;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.context.annotation.Primary;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@EnableScan
@Repository
@Primary
public interface ContactRepository extends CrudRepository<ContactTable, String> {
}
