package edu.depaul.se.servlet;

import static org.junit.Assert.assertEquals;
import org.junit.Before;

import org.junit.Test;
import org.springframework.mock.web.MockHttpServletRequest;
import org.springframework.mock.web.MockHttpServletResponse;

public class CounterServletTest {

    private MockHttpServletRequest request;
    private MockHttpServletResponse response;
    private CounterServlet servlet;

    @Before
    public void setUp() {
        servlet = new CounterServlet();
        request = new MockHttpServletRequest();
        response = new MockHttpServletResponse();
    }

    @Test
    public void testHandleRequest() throws Exception {
        servlet.doGet(request, response);

        assertEquals("<h1>Hello world</h1>Number of visits is <b>1</b>", response.getContentAsString());
    }

}
