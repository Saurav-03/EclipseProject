
<html>
<head>
<link rel="stylesheet" href="css/bootstrap.css" type="text/css">
<script src="js/jquery-1.11.2.js"></script>
<script src="js/bootstrap.js"></script>
<title>MVC App</title>
</head>
<body>
<div class="container">
<div class="row">
<jsp:include page="pages/header.jsp" />
</div>
<hr/>
<div class="row">
<h3>Existing user login</h3>
<jsp:include page="pages/loginForm.jsp" />
<a href="registerForm.spring">New user sign up</a>
</div>
<hr/>
<div class="row">
<jsp:include page="pages/footer.jsp" />
</div>
</div>
</body>
</html>