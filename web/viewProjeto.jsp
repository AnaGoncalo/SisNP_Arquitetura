<%-- 
    Document   : viewProjeto
    Created on : 10/11/2016, 08:46:17
    Author     : Ana Gonçalo
--%>

<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="sisnp.ifrn.br.dominio.Noticia"%>
<%@page import="sisnp.ifrn.br.dominio.Projeto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
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
        <h1>Sistema gerenciador de Nucleo de Pesquisa</h1>
        <hr/>
        
        <h2><%= projeto.getTitulo() %></h2>
        
        <h3> Descrição </h3>
        <p><%= projeto.getDescricao() %></p>
        
        <h3> Noticias </h3>
        <ul>
            <c:forEach var="noticia" items="${noticias}">
                <h5>${noticia.getTituloNoticia()}</h5>
                <p>${noticia.getTexto()}</p>
                <br/>
            </c:forEach>
        </ul>
        
        <h3>Metas</h3>
        <ul>
            
        </ul>
    </body>
</html>
