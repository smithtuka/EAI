package edu.miu.service.impl;

import edu.miu.configuration.RabbitConfig;
import edu.miu.domain.Requisition;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.validation.Valid;

@Service
public class RequisitionMessageSender {

    RabbitTemplate rabbitTemplate;

    @Autowired
    public RequisitionMessageSender(RabbitTemplate rabbitTemplate) {
        this.rabbitTemplate = rabbitTemplate;
    }

    public void sendOrder(@Valid Requisition requisition) {
        this.rabbitTemplate.convertAndSend(RabbitConfig.REQ_ORDERS, requisition);
    }
}
