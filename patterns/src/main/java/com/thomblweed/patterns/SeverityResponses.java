package com.thomblweed.patterns;

import java.util.HashMap;
import java.util.Map;

public class SeverityResponses {

    private StringBuilder builder = new StringBuilder();
    private Map<Byte, Severity> responses = new HashMap<Byte, Severity>();

    public Map<Byte, Severity> instantiantResponses() {

        responses.put((byte) 0, new Severity() {
            @Override
            public String addResponse() {
                return builder.append("Oh yeah it a 1").toString();
            }
        });

        responses.put((byte) 1, new Severity() {
            @Override
            public String addResponse() {
                return builder.append("Severity 1 response").toString();
            }
        });

        responses.put((byte) 2, new Severity() {
            @Override
            public String addResponse() {
                return builder.append("Severity 2 response bananas").toString();
            }
        });

        return responses;
    }
}
