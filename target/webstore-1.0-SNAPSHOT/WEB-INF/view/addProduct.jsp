<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
    <link rel="stylesheet" href="//netdna.bootstrapcdn.com/bootstrap/3.0.0/css/bootstrap.min.css">
    <title>Products</title>
</head>
<body>
<section>
    <div class="jumbotron">
        <a href="<c:url value="/j_spring_security_logout" />" class="btn btn-danger btn-mini pull-right">logout</a>

        <div class="pull-right" style="padding-right:50px">
            <a href="?language=en">English</a>|<a href="?language=nl">Dutch</a>
        </div>
        <div class="container">
            <h1>Products</h1>

            <p>Add products</p>
        </div>
    </div>
</section>
<section class="container">
    <form:form modelAttribute="newProduct" class="form-horizontal" enctype="multipart/form-data">
        <fieldset>
            <legend>Add new product</legend>

            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="productId"><spring:message
                        code="addProduct.form.productId.label"/></label>

                <div class="col-lg-10">
                    <form:input id="productId" path="productId" type="text" class="form:input-large"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="name"><spring:message
                        code="addProduct.form.name.label"/></label>

                <div class="col-lg-10">
                    <form:input id="name" path="name" type="text" class="form:input-large"/>
                </div>
            </div>

            <div class="form-group">
                <label class="control-label col-lg-2 col-lg-2" for="unitPrice"><spring:message
                        code="addProduct.form.unitPrice.label"/></label>

                <div class="col-lg-10">
                    <form:input id="unitPrice" path="unitPrice" type="number" class="form:input-large"/>
                </div>
            </div>

            <!-- Similarly bind  form:input tag for name,unitPrice,manufacturer,category,unitsInStock and unitsInOrder fields-->

            <div class="form-group">
                <label class="control-label col-lg-2" for="description"><spring:message
                        code="addProduct.form.description.label"/></label>

                <div class="col-lg-10">
                    <form:textarea id="description" path="description" rows="2"/>
                </div>
            </div>

                <%-- <div class="form-group">
                     <label class="control-label col-lg-2" for="unitsInOrder">Units In
                         Order</label>

                     <div class="col-lg-10">
                         <form:input id="unitsInOrder" path="unitsInOrder" type="text" class="form:input-large"/>
                     </div>
                 </div>

                 <div class="form-group">
                     <label class="control-label col-lg-2" for="discontinued">Discontinued</label>

                     <div class="col-lg-10">
                         <form:checkbox id="discontinued" path="discontinued"/>
                     </div>
                 </div>--%>

            <div class="form-group">
                <label class="control-label col-lg-2" for="condition"><spring:message
                        code="addProduct.form.condition.label"/></label>

                <div class="col-lg-10">
                    <form:radiobutton path="condition" value="New"/>New
                    <form:radiobutton path="condition" value="Old"/>Old
                    <form:radiobutton path="condition" value="Refurbished"/>Refurbished
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2" for="productImage">
                    <spring:message code="addProduct.form.productImage.label"/>
                </label>

                <div class="col-lg-10">
                    <form:input path="productImage" id="productImage" type="file"
                                class="form:input-large"/>
                </div>
            </div>
            <div class="form-group">
                <label class="control-label col-lg-2" for="productManual">
                    <spring:message code="addProduct.form.productManual.label"/>
                </label>

                <div class="col-lg-10">
                    <form:input path="productManual" id="productManual" type="file"
                                class="form:input-large"/>
                </div>
            </div>
            <div class="form-group">
                <div class="col-lg-offset-2 col-lg-10">
                    <input type="submit" id="btnAdd" class="btn btn-primary" value="Add" pattern="/add"/>
                </div>
            </div>
        </fieldset>
    </form:form>
</section>
</body>
</html>