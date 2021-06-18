package com.devwdougherty.domaincrawler;

import lombok.*;

import java.util.List;
import java.util.Objects;

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
