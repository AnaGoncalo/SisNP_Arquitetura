<%-- 
    Document   : viewProjeto
    Created on : 10/11/2016, 08:46:17
    Author     : Ana Gonçalo
--%>

<%@page import="java.util.List"%>
<%@page import="sisnp.ifrn.br.dominio.Noticia"%>
<%@page import="sisnp.ifrn.br.dominio.Projeto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<!DOCTYPE html>
<%
    Projeto projeto = (Projeto) session.getAttribute("projeto");
    List<Noticia> noticias = (List<Noticia>) session.getAttribute("noticias");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Visão Geral do Projeto <%= projeto.getTitulo() %></h1>
        <h3> Descrição </h3>
        <p><%= projeto.getDescricao() %></p>
        <h3> Noticias </h3>
        <ul>
            <c:forEach var="noticia" items="${noticias}">
                <li>${noticia.getIdNoticia()}, ${noticia.getTituloNoticia()}</li>
            </c:forEach>
        </ul>
    </body>
</html>
