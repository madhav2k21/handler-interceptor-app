package com.techleads.app;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.when;

import org.junit.jupiter.api.Test;
import org.mockito.ArgumentMatcher;
import org.mockito.ArgumentMatchers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.web.servlet.WebMvcTest;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.http.MediaType;
import org.springframework.mock.web.MockHttpServletResponse;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.ResultActions;
import org.springframework.test.web.servlet.request.MockHttpServletRequestBuilder;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.techleads.app.controller.MessageController;
import com.techleads.app.model.Message;
import com.techleads.app.service.MessageService;

//@SpringBootTest
@WebMvcTest(value = MessageController.class)
class HandlerInterceptorAppApplicationTests {

	@MockBean
	private MessageService service;
	@Autowired
	private MockMvc mockMvc;

	@Test
	public void testMessage200Status() throws Exception {
		when(service.myMessage()).thenReturn("Pay the airtel bill");
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/messages");
		ResultActions perform = mockMvc.perform(builder);
		MvcResult mvcResult = perform.andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();
		assertEquals(200, response.getStatus());
		String contentAsString = response.getContentAsString();
		assertEquals("Pay the airtel bill", contentAsString);
	}

	@Test
	public void testMessageContent() throws Exception {
		when(service.myMessage()).thenReturn("Buy vegetables");
		MockHttpServletRequestBuilder builder = MockMvcRequestBuilders.get("/messages");
		ResultActions perform = mockMvc.perform(builder);
		MvcResult mvcResult = perform.andReturn();
		MockHttpServletResponse response = mvcResult.getResponse();
		String contentAsString = response.getContentAsString();
		assertEquals("Buy vegetables", contentAsString);
	}

	@Test
	public void testMessageSave() throws Exception {
		String msg = "message is saved with id: " + 101;

		when(service.saveMessage(ArgumentMatchers.any())).thenReturn(msg);

		Message message = new Message(101, "Please start onboarding process");
		ObjectMapper mapper = new ObjectMapper();
		String msgJson = mapper.writeValueAsString(message);
		 MockHttpServletRequestBuilder requestBuilder = MockMvcRequestBuilders.post("/messages")
		 .contentType(MediaType.APPLICATION_JSON)
		 .content(msgJson);
		 
		 ResultActions perform = mockMvc.perform(requestBuilder);
		 
		 MvcResult result = perform.andReturn();
		 MockHttpServletResponse response = result.getResponse();
		 assertEquals(201, response.getStatus());
	}

//	@Test
//	void contextLoads() {
//	}

}
