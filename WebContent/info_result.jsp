<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<% request.setCharacterEncoding("utf-8"); %>
<%@ page import="java.util.*" %>
<%@ page import="info.*" %>

<!DOCTYPE html>
<html>
  <head>
    <meta charset="UTF-8">
    <title>Insert title here</title>
  </head>

  <body>
    <%
        String _cpcode = request.getParameter("cpcode");
        String _ccode = _cpcode.substring(0, 1);
        String _pcode = _cpcode.substring(1, 4);
        Date today = new Date ();
        
        InfoDAO infoDAO = new InfoDAO();
        InfoVO vo = infoDAO.read(_ccode, _pcode);
        
        out.print("<h3>제조사 조회 결과</h3>");
        out.print("<table border=1>");
        out.print("	    <tr>");
        out.print("         <td colspan='2' align='center'>제조사 조회 결과</td>");
        out.print("     </tr>");
        out.print("     <tr>");
        out.print("         <td align='center'>제품코드</td>");
        out.print("         <td>"+ _cpcode + "</td>");
        out.print("     </tr>");
        out.print("     <tr>");
        out.print("         <td align='center'>제조사명</td>");
        if( vo != null)
            out.print("         <td>"+ vo.getCname() + "</td>");
        else
        	out.print("         <td>등록되지 않은 제품입니다 !!!</td>");
        out.print("     </tr>");
        out.print("     <tr>");
        out.print("         <td align='center'>조회일시</td>");
        out.print("         <td>"+ today + "</td>");
        out.print("     </tr>");
        out.print("</table>");
    %>
  </body>
</html>