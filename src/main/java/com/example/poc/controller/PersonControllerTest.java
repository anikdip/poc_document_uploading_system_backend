package com.example.poc.controller;

import com.example.poc.model.Person;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;
import java.util.List;
import static java.util.Collections.singletonList;
import static org.hamcrest.collection.IsCollectionWithSize.hasSize;
import static org.hamcrest.core.Is.is;
import static org.mockito.BDDMockito.given;
import static org.springframework.http.MediaType.APPLICATION_JSON;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.jsonPath;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

@RunWith(SpringRunner.class)
@WebMvcTest(PersonController.class)
public class PersonControllerTest {

    @Autowired
    private MockMvc mockMvc;

    @MockBean
    private PersonController personController;

    @Test
    public void getPerson() throws Exception{
        Person person = new Person();
        person.setFirstName("A");
        person.setLastName("B");
        person.setMobileno(0);
        person.setMothername("C");
        person.setFathername("D");
        person.setEmailId("a@gmail.com");
        person.setBirthdate("31-12-1991");

        List<Person> allPerson = singletonList(person);

        given(personController.getAllPerson()).willReturn(allPerson);

        mockMvc.perform(get("all")
                .contentType(APPLICATION_JSON))
                .andExpect(status().isOk())
                .andExpect(jsonPath("$", hasSize(1)))
                .andExpect(jsonPath("$[0].person", is(person.getFirstName())));
    }

    /* Other test case are doing accordingly */
}
