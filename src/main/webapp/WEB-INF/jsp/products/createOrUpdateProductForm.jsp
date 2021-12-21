<%@ page session="false" trimDirectiveWhitespaces="true" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="petclinic" tagdir="/WEB-INF/tags" %>

<petclinic:layout pageName="products">

<div class="col-md-4 mx-auto">
    <div class="card mb-3">
        <div class="card-header">
            <h4>New product</h4>
        </div>
        <div class="card-body ">
            <form:form method="POST" action="/product/create" modelAttribute="product" class="form-horizontal" id="add-product-form">
                <div class="form-group has-feedback">
                    <petclinic:inputField label="First Name" name="firstName" />
                    <petclinic:inputField label="Last Name" name="lastName"/>
                    <label for="type">Product Type:</label>
                    <petclinic:selectField name="type" label="Pet Type" names="${productTypes}" size="2" />
                        <c:forEach items="${productTypes}" var="type">  
                            <option value="${type}">${type} </option>						
                        </c:forEach>  
                    </petclinic:selectField>
                </div>
                <div class="form-group">
                    <button class="btn btn-primary" type="submit">New product</button>
                </div>
            </form:form>
        </div>
    </div>
</div>

</petclinic:layout>
    
       

