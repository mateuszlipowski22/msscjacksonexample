package guru.springframework.msscjacksonexample.model;

import com.fasterxml.jackson.core.JsonProcessingException;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.autoconfigure.json.JsonTest;
import org.springframework.test.context.ActiveProfiles;

import static org.hamcrest.CoreMatchers.containsString;
import static org.hamcrest.MatcherAssert.assertThat;

@JsonTest
@ActiveProfiles("snake")
public class BeerDtoSnakeTest extends BaseTest{

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
}
