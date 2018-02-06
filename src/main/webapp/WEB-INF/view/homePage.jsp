<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<%@ include file="include/begin.jsp"%>

<table class="table table-striped table-bordered table-hover table-responsive">
    <thead class="thead-light">
        <tr class="success">
            <td><b>Mark</b></td>
            <td><b>Model</b></td>
            <td><b>Color</b></td>
            <td><b>Release date</b></td>
            <td><b>Country</b></td>
            <td><b>Edit</b></td>
            <td><b>Delete</b></td>
        </tr>
    </thead>

        <c:forEach items="${carList}" var="car">
            <form:form action="/CarService/${car.carId}" modelAttribute="car" method="PUT">
            <tr>
                <td>
                    <form:select multiple="single" path="mark.title" cssClass="btn btn-primary dropdown-toggle">
                        <form:option value="${car.mark.title}" />
                        <div class="dropdown-divider"></div>
                        <form:options items="${markList}"/>
                    </form:select>
                </td>
                <td><form:input path="model" value="${car.model}" cssClass="form-control"/></td>
                <td>
                    <form:select multiple="single" path="colour.name" cssClass="btn btn-primary dropdown-toggle">
                        <form:option value="${car.colour.name}" />
                        <div class="dropdown-divider"></div>
                        <form:options items="${colourList}"/>
                    </form:select>
                </td>
                <td><form:input path="releaseDate" value="${car.dateString}" cssClass="form-control"/></td>
                <td><form:input path="country" value="${car.country}" cssClass="form-control"/></td>
                <td><button class="btn btn-warning">Edit</button></td>
            </form:form>
            <td>
                <form:form action="/CarService/${car.carId}" modelAttribute="car" method="DELETE">
                    <button class="btn btn-danger">Delete</button>
                </form:form>
            </td>
            </tr>
        </c:forEach>
    <form:form method="POST" modelAttribute="car">
        <tr>
            <td>
                <form:select multiple="single" path="mark.title" cssClass="btn btn-primary dropdown-toggle">
                    <form:options items="${markList}"/>
                </form:select>
                <form:errors path="mark" cssClass="error"/>
            </td>
            <td>
                <form:input path="model" cssClass="form-control"/>
                <form:errors path="model" cssClass="error"/>
            </td>
            <td>
                <form:select multiple="single" path="colour.name" cssClass="btn btn-primary dropdown-toggle">
                    <form:options items="${colourList}"/>
                </form:select>
                <form:errors path="colour" cssClass="error"/>
            </td>
            <td>
                <form:input path="releaseDate" cssClass="form-control" placeholder="dd/MM/yyyy"/>
                <form:errors path="releaseDate" cssClass="error"/>
            </td>
            <td>
                <form:input path="country" cssClass="form-control"/>
                <form:errors path="country" cssClass="error"/>
            </td>
            <th colspan="2"><button class="btn btn-success btn-block">Create</button></th>

        </tr>
    </form:form>
</table>

<%@ include file="include/end.jsp"%>

