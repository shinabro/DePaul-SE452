package edu.depaul.se.servlet;

import junit.framework.Assert;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class HelloHTMLServletTest {

	@Test
	public void testHandleRequest() throws Exception {
		MockHttpServletRequest request = new MockHttpServletRequest();
		MockHttpServletResponse response = new MockHttpServletResponse();
		HelloHTML servlet = new HelloHTML();
		servlet.doGet(request, response);
		
		String expectResponse = "Hello Colorful World";
		Assert.assertTrue("Message should contain " + expectResponse, response.getContentAsString().contains(expectResponse));
	}
}
