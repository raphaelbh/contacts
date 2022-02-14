package com.zup.contacts.contacts.adapter.in.web.response;

import lombok.*;

import java.io.Serializable;

@Builder
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class ContactResponse implements Serializable {

    @Getter @Setter private String id;
    @Getter @Setter private String name;
    @Getter @Setter private String phone;
    @Getter @Setter private String email;

}
