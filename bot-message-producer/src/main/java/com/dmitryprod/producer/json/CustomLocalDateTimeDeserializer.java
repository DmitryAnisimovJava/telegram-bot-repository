package com.dmitryprod.producer.json;

import com.fasterxml.jackson.core.JacksonException;
import com.fasterxml.jackson.core.JsonParser;
import com.fasterxml.jackson.databind.DeserializationContext;
import com.fasterxml.jackson.databind.deser.std.StdDeserializer;

import java.io.IOException;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.ZoneId;

public class CustomLocalDateTimeDeserializer extends StdDeserializer<LocalDateTime> {

    private static final ZoneId ZONE_ID = ZoneId.systemDefault();

    public CustomLocalDateTimeDeserializer() {
        this(null);
    }

    protected CustomLocalDateTimeDeserializer(Class<?> vc) {
        super(vc);
    }

    @Override
    public LocalDateTime deserialize(JsonParser p, DeserializationContext ctxt) throws IOException, JacksonException {
        long unixTime = p.getLongValue();
        Instant instant = Instant.ofEpochSecond(unixTime);
        return instant.atZone(ZONE_ID).toLocalDateTime();
    }
}
