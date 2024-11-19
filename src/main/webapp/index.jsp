<%--
  Created by IntelliJ IDEA.
  User: faig
  Date: 16.11.24
  Time: 00:16
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<body>
<%--doPost()--%>
<form action="currencies" method="post">
    <input type="hidden" name="action" value="add">
    Enter the info for the currency you want to add:
    <br>
    <input type="text" name="Code" placeholder="Currency Code">
    <input type="text" name="Full_name" placeholder="Currency name">
    <input type="text" name="Sign" placeholder="Currency sign">
    <input type="submit" value="Create Currency">
</form>
<%--doGet()--%>
<form action = "currencies" method="get">
    Get all currencies
    <button type="submit">Get all currencies</button>
</form>

<%--doPost()--%>
<form action = "currencies" method="post">
    <input type="hidden" name="action" value="update">
    <input type="text" name="Code" placeholder="Currency Code">
    <input type="text" name="Full_name" placeholder="Currency name">
    <input type="text" name="Sign" placeholder="Currency sign">
    <button type="submit">Update the currency</button>
</form>

<form action = "currencies" method="post">
    <input type="hidden" name="action" value="delete">
    <input type="text" name="Code" placeholder="Enter the currency code">
    <button type="submit">Delete the currency</button>
</form>

<form action = "currencies" method="post">
    <input type="hidden" name="action" value="getByCode">
    <input type="text" name="Code" placeholder="Enter the currency code">
    <button type="submit">Get the currency with the ID</button>
</form>

<form action = "exchangeRates" method="get">
    <input type="hidden" name="action" value="getAll">
    Get all exchangeRates
    <button type="submit">Get all exchangeRates</button>
</form>

<form action = "exchangeRates" method="get">
    <input type="hidden" name="action" value="conversion">
    Please, enter the values using their 3 letter codes (e.g. EUR):
    <br>
    <input type="text" name="from" placeholder="Enter the base value">
    <input type="text" name="to" placeholder="Enter the target value">
    <input type="text" name="amount" placeholder="Enter the amount">
    <button type="submit">Perform conversion</button>
</form>


</body>
</html>
