<html>
  <head>
    <title>Calculator</title>
    <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
  </head>
  <body>
      <form action="CalculatorServlet">
          <input name="lhs" type="text"/>
          <select name="operator">
                <option>+</option>
                <option>-</option>
                <option>*</option>
                <option>/</option>
            </select>

          <input name="rhs" type="text" />
          <input type="submit" value="="/>
      </form>
  </body>
</html>