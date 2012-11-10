<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@page import="java.util.*" %>
<%@page import="coreservlets.*" %>

<%!
  private PrimeList findPrimeList(Vector primeListVector,
                                  int numPrimes,
                                  int numDigits) {
    synchronized(primeListVector) {
      for(int i=0; i<primeListVector.size(); i++) {
        PrimeList primes =
          (PrimeList)primeListVector.elementAt(i);
        if ((numPrimes == primes.numPrimes()) &&
            (numDigits == primes.numDigits()))
          return(primes);
      }
      return(null);
    }
  }
%>

<%! private Vector primeListVector = new Vector(); %>
<%! private static final int MAX_PRIME_LIST = 30;%>
<%
    int numPrimes = Integer.parseInt(request.getParameter("numPrimes"));
    int numDigits = Integer.parseInt(request.getParameter("numDigits"));    
    PrimeList primeList =
      findPrimeList(primeListVector, numPrimes, numDigits);
    if (primeList == null) {
      primeList = new PrimeList(numPrimes, numDigits, true);
      // Multiple servlet request threads share the instance
      // variables (fields) of PrimeNumbers. So
      // synchronize all access to servlet fields.
      synchronized(primeListVector) {
        if (primeListVector.size() >= MAX_PRIME_LIST)
          primeListVector.removeElementAt(0);
        primeListVector.addElement(primeList);
      }
    }
    Vector currentPrimes = primeList.getPrimes();
    int numCurrentPrimes = currentPrimes.size();
    int numPrimesRemaining = (numPrimes - numCurrentPrimes);
    boolean isLastResult = (numPrimesRemaining == 0);
    if (!isLastResult) {
      response.setHeader("Refresh", "5");
    }
    String title = "Some " + numDigits + "-Digit Prime Numbers";

%>
<html>
    <head>
    </head>
    <BODY BGCOLOR=\"#FDF5E6\">
        <H2 ALIGN=CENTER> <%= title %></H2>
        <H3>Primes found with  <%= numDigits %> + or more digits: <%= numCurrentPrimes %></H3>
        <%
        if (isLastResult){
        %>
        <B>Done searching.</B>
        <% } else {%>
        <B>Still looking for <%= numPrimesRemaining %> more<BLINK>...</BLINK></B>
        <% } %>

        <OL>
            <%
            for(int i=0; i<numCurrentPrimes; i++) {
            %>
                <LI> <%= currentPrimes.elementAt(i) %>
            <% } %>
        </OL>
    </body>
</html>
