<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path;
%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<style type="text/css">
	* {margin:0; padding:0;}
	div {
	margin:0 auto;
	width:600px;
	}
	#tip {
	text-align:center;
	height:50px;
	line-height:50px;
	}
	table{
	margin:0 auto;
	width:600px;
	border-collapse: collapse;
	}
	table td ,.h{
	text-align:center;
	}
	.title {
	font-weight:bolder;
	background-color:#408080;
	}
	table:first-of-type {
	height:80px;
	line-height:80px;
	}
	table:first-of-type td {
	font-size:18px;
	font-weight:bolder;
	}
	.tit tr:nth-child(even){
	background:#E8E8D0;
	}
</style>
  </head>
  
  <body>
  
  	<h2 class="h">常见问题检索</h2>
    <table>
        <tr>
            <td>
                <form action="showList.win" method="POST">
                    <label>请输入查询关键字：</label>
                    <input type="text" name="title"  />
                    <%-- <input type="hidden" name="currPageNo" value="${pager.currPageNo}"/>
	        		<input type="hidden" name="pageSize" value="${pager.pageSize}"/> --%>
                    &nbsp;<input type="submit" value="查询"/>
                </form>
            </td>
           <td><a href="showClasses.win">添加常见问题</a></td> 
        </tr>
    </table>
    <h3 class="h">检索结果</h3>
    <table border="1" cellpadding="0" cellspacing="0" class="tit">
    	<!-- <tr>
    		<td colspan="8">常见问题检索</td>
    	</tr> -->
	    <tr class="title">
	        <td>编号</td>
	        <td>标题</td>
	        <td>分类</td>
	        <td>创建时间</td>
	    </tr>
	    <c:if test="${empty list}">
			<tr>
				<td colspan="8"><h2>未查到符合您的查询条件的理财产品！</h2></td>
			</tr>
		</c:if>
		<c:if test="${not empty list}">
	    <c:forEach var="classes" items="${list}">
	    	<c:forEach var="faqs" items="${classes.faqsList}">
				<tr>
			        <td>${faqs.id }</td>
			        <td><a href="showKey.win?id=${faqs.id}">${faqs.title}</a></td>
			        <td>${faqs.classid }</td>
			        <td>${faqs.createdate }</td>
			    </tr>
		    </c:forEach>
	    </c:forEach>
	    </c:if>
		
	</table>
</body>
</html>