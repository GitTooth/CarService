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
            <form:form action="/CarService/update" modelAttribute="car">
            <div class="col-md-1" style="visibility: hidden">
                <form:input cssClass="form-control" path="carId"
                            value="${car.carId}"/>
            </div>
            <tr>
                <td>
                    <form:select multiple="single" path="mark.title" cssClass="btn btn-primary dropdown-toggle">
                        <form:option value="${car.mark.title}" />
                        <div class="dropdown-divider"></div>
                        <form:options items="${markList}"/>
                    </form:select>
                </td>
                <td><form:input path="model" value="${car.model}" cssClass="form-control"/></td>
                <td><form:input path="color" value="${car.color}" cssClass="form-control"/></td>
                <td><form:input path="releaseDate" value="${car.dateString}" cssClass="form-control"/></td>
                <td><form:input path="country" value="${car.country}" cssClass="form-control"/></td>
                <td><button class="btn btn-warning">Edit</button></td>
            </form:form>
            <td>
                <form:form action="/CarService/${car.carId}/delete" modelAttribute="car">
                    <button class="btn btn-danger">Delete</button>
                </form:form>
            </td>
            </tr>
        </c:forEach>
    <form:form action="/CarService/update" modelAttribute="car">
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
                <form:input path="color" cssClass="form-control"/>
                <form:errors path="color" cssClass="error"/>
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

