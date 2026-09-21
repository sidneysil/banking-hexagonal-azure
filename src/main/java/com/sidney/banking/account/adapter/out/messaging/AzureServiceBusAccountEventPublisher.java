package com.sidney.banking.account.adapter.out.messaging;

import org.springframework.integration.support.MessageBuilder;
import org.springframework.stereotype.Component;

import com.azure.spring.messaging.servicebus.core.ServiceBusTemplate;
import com.sidney.banking.account.application.port.out.AccountEventPublisherPort;
import com.sidney.banking.account.domain.Account;

@Component
public class AzureServiceBusAccountEventPublisher
        implements AccountEventPublisherPort {

    private static final String QUEUE_NAME = "account-events";

    private final ServiceBusTemplate serviceBusTemplate;

    public AzureServiceBusAccountEventPublisher(
            ServiceBusTemplate serviceBusTemplate) {
        this.serviceBusTemplate = serviceBusTemplate;
    }

    @Override
    public void publishAccountCreated(Account account) {

        serviceBusTemplate.sendAsync(
                QUEUE_NAME,
                MessageBuilder.withPayload(account).build()

        );
    }
}
