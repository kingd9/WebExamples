<%@ tag language="java" pageEncoding="ISO-8859-1"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>


<%-- Attributes to show/hide different implicit variable scopes --%>
<%@ attribute name="showApplication" required="false" %>
<%@ attribute name="showSession" required="false" %>
<%@ attribute name="showRequest" required="false" %>
<%@ attribute name="showPageContext" required="false" %>

<%-- 
pageScope - a Map that maps page-scoped attribute names to their values
requestScope - a Map that maps request-scoped attribute names to their values
sessionScope - a Map that maps session-scoped attribute names to their values
applicationScope - a Map that maps application-scoped attribute names to their values
--%>

<c:if test="${not empty showApplication}">
	<h2>Application Scope</h2>
	<c:forEach items="${applicationScope}" var="entry">
		<div><span class="label">KEY:</span>${entry.key}</div>
		<div><span class="label">KEY:</span>${entry.value}</div>
	</c:forEach>
</c:if>

<c:if test="${not empty showSession}">
	<h2>Session Scope</h2>
	<c:forEach items="${sessionScope}" var="entry">
		<div><span class="label">KEY:</span>${entry.key}</div>
		<div><span class="label">KEY:</span>${entry.value}</div>
	</c:forEach>
</c:if>
<c:if test="${not empty requestScope}">
	<h2>Request Scope</h2>
	<c:forEach items="${requestScope}" var="entry">
		<div><span class="label">KEY:</span>${entry.key}</div>
		<div><span class="label">KEY:</span>${entry.value}</div>
	</c:forEach>
</c:if>
<c:if test="${not empty pageScope}">
	<h2>Page Scope</h2>
	<c:forEach items="${pageScope}" var="entry">
		<div><span class="label">KEY:</span>${entry.key}</div>
		<div><span class="label">KEY:</span>${entry.value}</div>
	</c:forEach>
</c:if>

<%-- Add any other objects to display here --%>
