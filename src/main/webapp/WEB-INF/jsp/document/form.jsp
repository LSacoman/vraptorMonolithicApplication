<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@page contentType="text/html" pageEncoding="UTF-8"%>
<c:import url="/WEB-INF/jsp/inc/header.jsp"/>
<div class="col-md-6 offset-md-3">
    <h1>Documento (Cadastro)</h1>
    <c:if test="${not empty errors}">
        <c:forEach items="${errors}" var="err">
            <li>${err.category} ${err.message}</li>
        </c:forEach>
    </c:if>

    <form action="${linkTo[DocumentController].save}" method="POST">
        <div class="form-group">
            <label>Descrição:</label>
            <input type="text" class="form-control" name="description" required/>
        </div>
        <div class="form-group">
            <label>Nome do Arquivo:</label>
            <input type="text" class="form-control" name="fileName" required/>
        </div>
        <div class="form-group">
            <label>Data:</label>
            <input type="date" class="form-control" name="date"/>
        </div>
        <div class="form-group">
            <label>Ultima Atualização:</label>
            <input type="date" class="form-control" name="lastUpdate"/>
        </div>
        <div class="form-group">
            <label>Categoria:</label>
            <select class="form-control" name="selectedCategoryName" required>
                <c:forEach items="${categorias}" var="categoria">
                    <option value="${categoria.name}">${categoria.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="form-group">
            <label>Keywords:</label>
            <select class="form-control" name="keywords[]" size="10" multiple required>
                <c:forEach items="${keywords}" var="keyword">
                    <option value="${keyword.name}">${keyword.name}</option>
                </c:forEach>
            </select>
        </div>
        <div>
            <button type="submit" class="btn btn-primary">Gravar</button>
        </div>
    </form>
</div>
<c:import url="/WEB-INF/jsp/inc/footer.jsp"/>
