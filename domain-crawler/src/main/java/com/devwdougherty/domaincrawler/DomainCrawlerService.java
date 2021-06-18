package com.devwdougherty.domaincrawler;

import org.springframework.http.MediaType;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Service
public class DomainCrawlerService {

    private final KafkaTemplate<String, Domain> kafkaTemplate;
    private final String KAFKA_TOPIC = "web-domains";

    public DomainCrawlerService(final KafkaTemplate<String, Domain> kafkaTemplate) {

        this.kafkaTemplate = kafkaTemplate;
    }

    public void crawl(String name) {

        Flux<DomainList> domainListMono = WebClient.create()
                .get()
                .uri("https://api.domainsdb.info/v1/domains/search?domain="+ name + "&zone=com")
                .accept(MediaType.APPLICATION_JSON)
                .retrieve()
                .bodyToFlux(DomainList.class);

        domainListMono.subscribe(domains -> {
            domains.domains
                    .forEach(domain -> {
                        kafkaTemplate.send(KAFKA_TOPIC, domain);
                        System.out.println("Domain message: " + domain.getDomain());
                    });
        });
    }
}
