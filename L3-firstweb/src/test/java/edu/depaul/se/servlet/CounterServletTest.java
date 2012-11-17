package edu.depaul.se.servlet;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;


public class CounterServletTest {

	@Test
	public void testHandleRequest() throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		CounterServlet servlet = new CounterServlet();
		servlet.doGet(request, response);
		
		assertEquals("<h1>Hello world</h1>Number of visits is <b>1</b>", response.getContentAsString());
	}
	
}
