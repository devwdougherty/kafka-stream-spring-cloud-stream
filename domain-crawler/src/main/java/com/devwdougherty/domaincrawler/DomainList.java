package com.devwdougherty.domaincrawler;

import lombok.*;

import java.util.ArrayList;
import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Getter
@Setter
@EqualsAndHashCode
public class DomainList {

    List<Domain> domains;
}
