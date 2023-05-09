package guru.springramework.msscbeerservice.web.controller;

import com.fasterxml.jackson.databind.ObjectMapper;
import guru.springramework.msscbeerservice.web.model.BeerDto;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.MockMvc;

import java.util.UUID;

import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.*;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@WebMvcTest(BeerController.class)
class BeerControllerTest {

    private static final String BASE_URL = "/api/v1/beer/";

    @Autowired
    private MockMvc mockMvc;
    @Autowired
    ObjectMapper mapper;

    @Test
    void shouldGet() throws Exception {
        UUID id = UUID.randomUUID();
        mockMvc.perform(get(BASE_URL + id)
                .accept(APPLICATION_JSON))
            .andExpect(status().isOk());
    }

    @Test
    void shouldCreate() throws Exception {
        UUID id = UUID.randomUUID();
        BeerDto beer = BeerDto.builder().id(id).build();
        String beerStr = mapper.writeValueAsString(beer);

        mockMvc.perform(post(BASE_URL)
                .contentType(APPLICATION_JSON)
                .content(beerStr))
            .andExpect(status().isCreated());
    }

    @Test
    void shouldUpdate() throws Exception {
        UUID id = UUID.randomUUID();
        BeerDto beer = BeerDto.builder().id(id).build();
        String beerStr = mapper.writeValueAsString(beer);

        mockMvc.perform(put(BASE_URL + id)
                .contentType(APPLICATION_JSON)
                .content(beerStr))
            .andExpect(status().isNoContent());
    }
}