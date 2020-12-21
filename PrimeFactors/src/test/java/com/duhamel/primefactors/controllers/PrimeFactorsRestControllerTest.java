package com.duhamel.primefactors.controllers;

import static org.mockito.Mockito.when;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;
import static org.hamcrest.Matchers.*;

import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import java.util.ArrayList;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.springframework.test.web.servlet.MockMvc;
import com.duhamel.primefactors.services.PrimeFactorsService;

@WebMvcTest
@ExtendWith(SpringExtension.class)
class PrimeFactorsRestControllerTest {
	
	@Autowired
	MockMvc mockMvc;
	
	@MockBean
	PrimeFactorsService primeFactorsService;

	@Test
	void validRequestProducesListOfValues() throws Exception {
		ArrayList factors = new ArrayList();
		factors.add(7);
		factors.add(7);
		factors.add(5);
		when(primeFactorsService.factor(245)).thenReturn(factors);
        mockMvc.perform(MockMvcRequestBuilders.get("/factors?number=245")
                .contentType(MediaType.APPLICATION_JSON)
        ).andExpect(jsonPath("$", containsInAnyOrder(5, 7, 7))).andExpect(status().isOk()).andDo(print());
	}

}
