package com.devwdougherty.domaincrawler;

import lombok.*;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode
public class Domain {

    String domain;

    String createDate;

    String updateDate;

    String country;

    boolean isDead;

    String A;

    String NS;

    String CNAME;

    String MX;

    String TXT;
}
