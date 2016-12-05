<%@page contentType="text/html"%>
<%@page pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<div class="panel panel-primary">
  <div class="panel-heading">秒杀列表</div>
  <div class="panel-body">
  	<table class="table table-hover table-bordered">
    	<thead>
    		<tr>
    			<th>名称</th>
    			<th>库存</th>
    			<th>开始时间</th>
    			<th>结束时间</th>
    			<th>创建时间</th>
    			<th>操作</th>
    		</tr>
    	</thead>
    	<tbody>
		<c:forEach var="sk" items="${list}">
          <tr>
            <td>${sk.name}</td>
            <td>${sk.number}</td>
            <td>
              <fmt:formatDate value="${sk.startTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
            </td>
            <td>
              <fmt:formatDate value="${sk.endTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
            </td>
            <td>
              <fmt:formatDate value="${sk.createTime}" pattern="yyyy-MM-dd HH:mm:ss"/>
            </td>
            <td>
              <a class="btn btn-info link" href="javascript:void(0);" link="seckill/${sk.seckillId}/detail">link</a>
            </td>
          </tr>
        </c:forEach>
    	</tbody>
    </table>
  </div>
</div>
<script>
	$(function(){
		$('a.link').on('click',function(){
			$('#content').load($(this).attr('link'));
		});
	});
</script>