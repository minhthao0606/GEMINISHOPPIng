<%-- 
    Document   : history.jsp
    Created on : Jul 21, 2020, 1:01:57 PM
    Author     : gf63
--%>

<%@page import="model.History"%>
<%@page import="model.History"%>
<%@page import="java.util.ArrayList"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>

    <html>
        <head>
            <meta http-equiv="Content-Type" content="text/html; charset=UTF-8"/>
            <title>JSP Page</title>
             <style>
            table, th, td{
                border: 1px solid black;
                border-collapse: collapse;   
                text-align: center;
            }
            table{
                background-image: linear-gradient(to bottom right, #9ACD32, #FFCFD1);

            }

            td, th, a{
                padding: 30px;
                color: #F5FFFA;
            }

        </style>
        </head>
        <body>
            <%
               ArrayList < History > historys = (ArrayList) request.getAttribute("data");
                %>
                
                <table border='1px' width='70%'>
                <tr>
                    <th>Buy Date</th>
                    <th>Name</th>
                    <th>Image</th>
                    <th>Unit Price</th>
                    <th>Quantity</th>
                    <th>Amount</th>
                </tr>
                <%  for (History history : historys) {
                %>
                <tr>
                    <td> <%= history.getBuyDate()  %> </td>
                    <td> <%= history.getName() %> </td>
                    <td> <img src="/view/client/view/image/<%= history.getImage()%>" alt="<%= history.getImage() %>" />  </td>
                    <td> <%= history.getUnitPrice() %> </td>
                    <td> <%= history.getQuantity() %> </td>
                    <td> <%= history.getAmount() %> </td>
                  
                </tr>


                <%
                    }

                %>
            </table>
        </body>
    </html>
