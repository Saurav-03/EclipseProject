<%@ taglib uri="http://tiles.apache.org/tags-tiles" prefix="tiles" %>
<html>
<head>
<link rel="stylesheet" href="http://localhost:8080/mvcApp/css/bootstrap.css" type="text/css">
<script src="http://localhost:8080/mvcApp/js/jquery-1.11.2.js"></script>
<script src="http://localhost:8080/mvcApp/js/bootstrap.js"></script>
<title>
<tiles:getAsString name="title"/>
</title>
</head>
<body>
<div class="container">
<div class="row">
<tiles:insertAttribute name="header"/>
</div>
<hr/>
<div class="row">
<tiles:insertAttribute name="contents"/>
</div>
<hr/>
<div class="row">
<jsp:include page="footer.jsp" />
</div>
</div>
</body>
</html>