package com.thomblweed.patterns;

import java.util.Map;

public class Hello {

    public String doStuff(byte responseCode) {
        SeverityResponses severityResponse = new SeverityResponses();

        Map<Byte, Severity> doThing = severityResponse.instantiantResponses();

        return doThing.get(responseCode).addResponse();
    }
}
