package com.dmitryprod.producer.message.common;

import com.dmitryprod.producer.json.CustomLocalDateTimeDeserializer;
import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.databind.annotation.JsonDeserialize;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

import java.time.LocalDateTime;

import static com.fasterxml.jackson.annotation.JsonAutoDetect.*;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
@JsonAutoDetect(fieldVisibility = Visibility.ANY)
public class Message {

    @JsonProperty(required = true, value = "message_id")
    int messageId;

    @JsonDeserialize(using = CustomLocalDateTimeDeserializer.class)
    LocalDateTime date;
}
