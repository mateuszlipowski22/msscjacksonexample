package guru.springframework.msscjacksonexample.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.json.JsonTest;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.junit.jupiter.api.Assertions.*;

@JsonTest
class BeerDtoTest extends BaseTest{

    @Autowired
    ObjectMapper objectMapper;

    @Test
    void testSerializationDto() throws JsonProcessingException {
        BeerDto beerDto = getDto();

        String jsonString = objectMapper.writeValueAsString(beerDto);

        assertThat(jsonString, containsString("BeerName"));
        assertThat(jsonString, containsString("Ale"));
        assertThat(jsonString, containsString("12.99"));
        assertThat(jsonString, containsString("123123123123"));

        System.out.println(jsonString);

    }

    @Test
    void testDeserializationJson() throws JsonProcessingException {
        String json="{\"id\":\"cbcda84f-36f0-4175-83e3-3cd7d270d95d\",\"beerName\":\"BeerName\",\"beerStyle\":\"Ale\",\"upc\":123123123123,\"price\":12.99,\"createdDate\":\"2023-05-06T22:30:59.902139569\",\"lastModifiedDate\":\"2023-05-06T22:30:59.902174951\"}\n";

        BeerDto beerDto = objectMapper.readValue(json, BeerDto.class);

        assertEquals("BeerName", beerDto.getBeerName());
        assertEquals("Ale", beerDto.getBeerStyle());
        assertEquals("12.99", beerDto.getPrice().toString());
        assertEquals(123123123123L, beerDto.getUpc());

        System.out.println(beerDto);
    }

}