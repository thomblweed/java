package com.thomblweed;

import org.apache.camel.CamelContext;
import org.apache.camel.ProducerTemplate;
import org.apache.camel.builder.RouteBuilder;
import org.apache.camel.impl.DefaultCamelContext;
import org.apache.camel.support.SimpleRegistry;

public class CallMethodUsingClassComponent {

    public static void main(String[] args) throws Exception {

        MyService myService = new MyService();

        SimpleRegistry simpleRegistry = new SimpleRegistry();
        simpleRegistry.put("myService", myService);

        CamelContext context = new DefaultCamelContext(simpleRegistry);
        context.addRoutes(new RouteBuilder() {

            @Override
            public void configure() throws Exception {

                from("direct:start")
                    .to("class:com.thomblweed.MyService?method=doSomething");

            }

        });

        context.start();

        ProducerTemplate producerTemplate = context.createProducerTemplate();
        producerTemplate.sendBody("direct:start", "Hello");
    }
}
