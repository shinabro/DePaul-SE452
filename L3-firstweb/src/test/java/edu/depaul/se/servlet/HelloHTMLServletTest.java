package edu.depaul.se.servlet;

import static org.junit.Assert.assertTrue;
import org.junit.Before;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class HelloHTMLServletTest {

    private MockHttpServletRequest request;
    private MockHttpServletResponse response;
    private HelloHTML servlet;

    @Before
    public void setUp() {
        servlet = new HelloHTML();
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
    }

    @Test
    public void testHandleRequest() throws Exception {
        servlet.doGet(request, response);

        String expectResponse = "Hello Colorful World";
        assertTrue("Message should contain " + expectResponse, response.getContentAsString().contains(expectResponse));
    }
}
