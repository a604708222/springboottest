<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
    <script type="application/javascript" src="../js/jquery-1.11.3.js"></script>
    <script type="application/javascript">

        console.info(123456);
        $(function(){
            $.ajax({
                url:"/book/testquery",
                type:"json",
                data:{
                    "name":"zhangsan",
                    "age":"6",
                },
                method:"post",
                success:function (data) {
                    console.log(data);
                },
            })
        })  ;
    </script>
</head>

<body>
<a href="/book/bookAdd">添加</a>
<a href="/book/testquery">测试查询</a>
<table>
    <tr>
        <th>编号</th>
        <th>图书名称</th>
        <th>图书作者</th>
        <th>操作</th>
    </tr>
    <c:forEach items="${bookList }" var="book">
        <tr>
            <td>${book.id}</td>
            <td>${book.name}</td>
            <td>${book.author}</td>
            <td>
                <a href="/book/preUpdate/${book.id}">修改</a>
                <a href="/book/delete?id=${book.id}">删除</a>
            </td>
        </tr>

    </c:forEach>
</table>
</body>
</html>

