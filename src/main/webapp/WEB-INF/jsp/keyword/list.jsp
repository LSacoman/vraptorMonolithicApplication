<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:import url="/WEB-INF/jsp/inc/header.jsp"/>

<h1>Listagem de Keywords!</h1>
<table class="table table-striped">
    <thead class="thead-dark">
        <tr>
            <th>ID</th>
            <th>Keyword</th>
            <th>Ações</th>
        </tr>
    </thead>
    <c:forEach items="${keywordList}" var="keyword">
        <tr>
            <td>${keyword.id}</td>
            <td>${keyword.name}</td>
            <td>
                <a class="btn btn-secondary" href="${linkTo[KeywordController].update}${keyword.name}">Editar</a>
                <a class="btn btn-danger" href="${linkTo[KeywordController].delete}${keyword.name}">Deletar</a>
            </td>
        </tr>   
    </c:forEach>
</table>
<jsp:include page="/WEB-INF/jsp/inc/footer.jsp"/>