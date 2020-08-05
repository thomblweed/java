package com.thomblweed;

import org.apache.activemq.ActiveMQConnectionFactory;
import org.apache.camel.CamelContext;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.component.jms.JmsComponent;
import org.apache.camel.impl.DefaultCamelContext;

import javax.jms.ConnectionFactory;

public class FileToActiveMQ {

    public static void main(String[] args) throws Exception {

        CamelContext context = new DefaultCamelContext();

        ConnectionFactory connectionFactory = new ActiveMQConnectionFactory();
        context.addComponent("activemq", JmsComponent.jmsComponentAutoAcknowledge(connectionFactory));

        context.addRoutes(new RouteBuilder() {

            @Override
            public void configure() throws Exception {

                from("file:input_box?noop=true")
                    .to("activemq:queue:my_queue");

            }

        });

        while(true) {
            context.start();
        }
    }
}
