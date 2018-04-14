<%@ taglib prefix="form" uri="http://www.springframework.org/tags/form"%>
<h3>Registration Form</h3>
<form:form action="register.spring" class="form form-horizontal"   modelAttribute="user">
<div class="form-group">
<label>Name</label>
<form:input class="form-control" type="text" path="name" /><br/>
<p><form:errors path="name" class="text-warning"/></p>
</div>
<div class="form-group">
<label>MailId</label>
<form:input type="text" path="mailId" class="form-control"/><br/>
<p><form:errors path="mailId" class="text-warning"/> </p>
</div>
<div class="form-group">
<label>Password</label>
<form:input type="password" path="password" 
class="form-control"/><br/>
<p><form:errors path="password" class="text-warning"/> </p>
</div>
<div class="form-group">
<button type="submit" class="btn btn-primary">Register</button>
</div>
</form:form>







