<h3>Your profile details:</h3>
<form  class="form form-horizontal" action="updateProfile.spring" method="post">
<input type="hidden" name="id" value="${user.id}" ><br/>
<div class="form-group">
<label>Name</label>
<input type="text"  class="form-control" name="name" value="${user.name}">
</div>
<div class="form-group">
<label>MailId</label>
<input type="text" name="mailId" class="form-control"
value="${user.mailId}">
</div>
<div class="form-group">
<label>Password</label>
<input type="password" name="password" class="form-control">
</div>
<div>
<button type="submit" class="btn btn-primary">update</button>
</div>
</form>









