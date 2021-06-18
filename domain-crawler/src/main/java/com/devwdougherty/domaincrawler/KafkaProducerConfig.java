package com.devwdougherty.domaincrawler;

import org.apache.kafka.clients.producer.ProducerConfig;
import org.apache.kafka.common.serialization.StringSerializer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.core.DefaultKafkaProducerFactory;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.kafka.core.ProducerFactory;
import org.springframework.kafka.support.serializer.JsonSerializer;

import java.util.HashMap;
import java.util.Map;

@Configuration
public class KafkaProducerConfig {

    /**
     * Kafka templated with custom producer factory injected.
     *
     * @return
     */
    @Bean
    public KafkaTemplate<String, Domain> kafkaTemplate() {

        return new KafkaTemplate<>(producerFactory());
    }

    /**
     * Custom producer factory to set a custom configuration in our Kafka Template like:
     * <Serializer our Key as String><Serializer our value publish message (Domain) as Json>
     *
     * @return
     */
    @Bean
    public ProducerFactory<String, Domain> producerFactory() {

        Map<String, Object> configs = new HashMap<>();

        configs.put(ProducerConfig.BOOTSTRAP_SERVERS_CONFIG, "127.0.0.1:9092");
        configs.put(ProducerConfig.KEY_SERIALIZER_CLASS_CONFIG, StringSerializer.class);
        configs.put(ProducerConfig.VALUE_SERIALIZER_CLASS_CONFIG, JsonSerializer.class);

        return new DefaultKafkaProducerFactory<>(configs);
    }
}
