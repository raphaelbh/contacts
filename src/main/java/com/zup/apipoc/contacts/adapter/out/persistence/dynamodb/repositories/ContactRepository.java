package com.zup.apipoc.contacts.adapter.out.persistence.dynamodb.repositories;

import com.zup.apipoc.contacts.adapter.out.persistence.dynamodb.tables.ContactTable;
import org.socialsignin.spring.data.dynamodb.repository.EnableScan;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@EnableScan
@Repository
public interface ContactRepository extends CrudRepository<ContactTable, String> {
}
