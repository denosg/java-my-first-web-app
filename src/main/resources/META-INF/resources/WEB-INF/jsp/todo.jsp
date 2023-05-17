<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<%@ taglib uri="http://www.springframework.org/tags/form" prefix="form" %>

<html>
	<head>
	    <link href="webjars/bootstrap/5.1.3/css/bootstrap.min.css" rel="stylesheet">
	    <link href="webjars/bootstrap-datepicker/1.9.0/css/bootstrap-datepicker.standalone.min.css" rel="stylesheet">
		<title>Add Todo Page</title>
	</head>
	<body>
	    <div class="container">
            <div>Welcome ${name} !</div>
            <hr>
            <h1>Enter Todo Details</h1>
            <form:form method="post" modelAttribute="todo">
            <fieldset class="mb-3">
                <form:label path="description">Description</form:label>
                <form:input type="text" path="description" required="required"/>
            </fieldset>
                <form:input type="hidden" path="id"/>
                <form:input type="hidden" path="done"/>
            <fieldset class="mb-3">
                 <form:label path="targetDate">Target Date</form:label>
                 <form:input type="text" path="targetDate" required="required"/>
            </fieldset>
                <input type="submit" class="btn btn-success"/>

                <form:errors path="description" cssClass="text-warning"/>
            </form:form>
		</div>
		<script src="webjars/bootstrap/5.1.3/js/bootstrap.js"></script>
		<script src="webjars/jquery/3.6.0/jquery.min.js"></script>
		<script src="webjars/bootstrap-datepicker/1.9.0/js/bootstrap-datepicker.min.js"></script>

		<script type="text/javascript">$('#targetDate').datepicker({
                                           format: 'dd-mm-yyyy',});
        </script>
	</body>
</html>