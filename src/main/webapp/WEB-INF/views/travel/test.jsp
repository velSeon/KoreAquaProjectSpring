<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"%>
<c:forEach var="xx" items="${list }" varStatus="status">
				${xx.RIMAGE}
			</c:forEach>  