<HTML>
<BODY>
<H1>Random Number generator Access Counter</H1>
<%! 
  private String randomHeading() {
    if (Math.random() > .5)
        return"<H2>Have a <b><i>great</i></b> day</H2>";
    else
        return"<H2>Have a <b><i>lousy</i></b> day</H2>";
  }
%>
<%= randomHeading() %>
<%! private int accessCount = 0; %>
<H2>Accesses to page since server reboot: 
<%= ++accessCount %></H2>

</BODY>
</HTML>