<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:import url="/WEB-INF/jsp/inc/header.jsp"/>
<div class="col-md-6 offset-md-3">
    <h1>Categoria (Cadastro)</h1>
    <c:if test="${not empty errors}">
        <c:forEach items="${errors}" var="err">
            <li>${err.category} ${err.message}</li>
            </c:forEach>
        </c:if>

    <c:if test="${not empty categoria.name}">
        <form action="${linkTo[CategoryController].atualiza}" method="POST">
            <input type="text" class="hidden" style="display: none; " name="category.id" value="${categoria.id}"/>
        </c:if>

        <c:if test="${empty categoria.name}">
            <form action="${linkTo[CategoryController].save}" method="POST">
            </c:if>


            <div class="form-group">
                <label>Categoria: </label>
                <input type="text" class="form-control" name="category.name" value="${categoria.name}"/>
            </div>
            <div>

                <button type="submit" class="btn btn-primary">Gravar</button>
            </div>
        </form>
</div>
<c:import url="/WEB-INF/jsp/inc/footer.jsp"/>
