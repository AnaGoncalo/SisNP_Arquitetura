<%-- 
    Document   : viewProjeto
    Created on : 10/11/2016, 08:46:17
    Author     : Ana Gonçalo
--%>

<%@page import="sisnp.ifrn.br.dominio.Meta"%>
<%@page import="java.util.ArrayList"%>
<%@page import="java.util.List"%>
<%@page import="sisnp.ifrn.br.dominio.Noticia"%>
<%@page import="sisnp.ifrn.br.dominio.Projeto"%>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<%
    Projeto projeto = (Projeto) request.getAttribute("projeto");
    List<Noticia> noticias = (List<Noticia>) request.getAttribute("noticias");
    List<Meta> metas = (List<Meta>) request.getAttribute("metas");
%>
<html>
    <head>
        <meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
        <title>JSP Page</title>
    </head>
    <body>
        <h1>Sistema gerenciador de Nucleo de Pesquisa</h1>
        <hr/>

        <h2><%= projeto.getTitulo()%></h2>

        <h3> Descrição </h3>
        <p><%= projeto.getDescricao()%></p>

        <h3>Equipe</h3>
        <ul>
            <c:forEach var="pesquisador" items="${equipe}">
                <li>${pesquisador.getNome()}</li>
                </c:forEach>
        </ul>

        <h3> Noticias </h3>
        <ul>
            <c:forEach var="noticia" items="${noticias}">
                <h4>${noticia.getTituloNoticia()}</h4>
                <p>${noticia.getTexto()}</p>
            </c:forEach>
        </ul>

        <h3>Metas</h3>
        <ol>
            <c:forEach var="meta" items="${metas}">
                <li>
                    <p>${meta.getNome()}</p>
                    <p>Entrega: ${meta.getDataEntrega()}</p>
                </li>
            </c:forEach>
        </ol>
    </body>
</html>
