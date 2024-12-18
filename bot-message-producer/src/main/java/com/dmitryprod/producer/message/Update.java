package com.dmitryprod.producer.message;

import com.dmitryprod.producer.message.common.Message;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.AccessLevel;
import lombok.Data;
import lombok.experimental.FieldDefaults;

@Data
@FieldDefaults(level = AccessLevel.PRIVATE)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Update {

    @JsonProperty(required = true, value = "update_id")
    int updateId;

    @JsonProperty(value = "message")
    Message message;
}
