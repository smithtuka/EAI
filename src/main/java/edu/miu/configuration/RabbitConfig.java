package edu.miu.configuration;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RabbitConfig {

    public static final String REQ_ORDERS = "requisition-queue";
    public static final String EXCHANGE_REQ = "requisition-exchange";

    @Bean
    Queue reqQueue() {
        return QueueBuilder.durable(REQ_ORDERS).build();
    }

    @Bean
    Exchange reqExchange() {
        return ExchangeBuilder.topicExchange(EXCHANGE_REQ).build();
    }

    @Bean
    Binding binding(Queue reqQueue, TopicExchange reqExchange) {
        return BindingBuilder.bind(reqQueue).to(reqExchange).with(REQ_ORDERS);
    }

    @Bean
    public RabbitTemplate rabbitTemplate(final ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(producerJackson2MessageConverter());
        return rabbitTemplate;
    }

    @Bean
    public Jackson2JsonMessageConverter producerJackson2MessageConverter() {
        return new Jackson2JsonMessageConverter();
    }
}
