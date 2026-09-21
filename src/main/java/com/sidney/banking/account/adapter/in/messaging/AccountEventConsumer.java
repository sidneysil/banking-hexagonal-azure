package com.sidney.banking.account.adapter.in.messaging;

import org.springframework.stereotype.Component;

import com.azure.spring.messaging.servicebus.implementation.core.annotation.ServiceBusListener;

@Component
public class AccountEventConsumer {

    @ServiceBusListener(destination = "account-events")
    public void receive(byte[] payload) {

        String message = new String(payload);

        System.out.println(
                "SERVICE BUS CONSUMER: mensagem recebida -> " + message
        );
    }
}