package com.zup.contacts.contact.adapter.in.web.response;

import lombok.*;

@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ContactResponse {

    @Getter @Setter private String id;
    @Getter @Setter private String name;
    @Getter @Setter private String phone;
    @Getter @Setter private String email;

}
