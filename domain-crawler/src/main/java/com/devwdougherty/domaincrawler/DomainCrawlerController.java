package com.devwdougherty.domaincrawler;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/domain")
public class DomainCrawlerController {

    private final DomainCrawlerService domainCrawlerService;

    public DomainCrawlerController(final DomainCrawlerService domainCrawlerService) {

        this.domainCrawlerService = domainCrawlerService;
    }

    @GetMapping("/lookup/{name}")
    public String lookup(@PathVariable("name") String name) {

        domainCrawlerService.crawl(name);

        return "Domain crawler has scrapped your data";
    }
}
