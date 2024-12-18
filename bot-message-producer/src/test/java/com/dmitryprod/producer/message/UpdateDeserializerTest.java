package com.dmitryprod.producer.message;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.ActiveProfiles;

@SpringBootTest(classes = {ObjectMapper.class})
@ActiveProfiles({"test"})
class UpdateDeserializerTest {

    @Autowired
    ObjectMapper objectMapper;


    @Test
    void deserialize_sentValidJson_returnValidUpdateObject() throws JsonProcessingException {
        //Given
        String jsonUpdate = """
                {
                "update_id":10000,
                "message":{
                  "date":1441645532,
                  "chat":{
                     "last_name":"Test Lastname",
                     "id":1111111,
                     "type": "private",
                     "first_name":"Test Firstname",
                     "username":"Testusername"
                  },
                  "message_id":1365,
                  "from":{
                     "last_name":"Test Lastname",
                     "id":1111111,
                     "first_name":"Test Firstname",
                     "username":"Testusername"
                  },
                  "text":"/start"
                 }
                }
                """;

        //When
        Update update = objectMapper.readValue(jsonUpdate, Update.class);
        System.out.println();
    }

}