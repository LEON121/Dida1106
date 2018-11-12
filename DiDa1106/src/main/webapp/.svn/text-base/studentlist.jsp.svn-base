<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>滴答办公系统-学员列表</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="${pageContext.request.contextPath}/media/layui/css/layui.css" media="all">
<script src="${pageContext.request.contextPath}/media/js/jquery.min.js"></script>

<script type="text/javascript">

	//跳转页码
	function goPage(pageIndex){
		var pageSize=$("#psize").val();//页码
		$("#stuform").attr("action","${pageContext.request.contextPath}/student/list/"+pageIndex+"?pageSize="+pageSize);
		$("#stuform").submit(); //提交表单参数
	}
	
	//更新页面大小
	function changeSize(obj){
		var size=obj.value;
		$("#stuform").attr("action","${pageContext.request.contextPath}/student/list/1?pageSize="+size);
		$("#stuform").submit(); //提交表单参数
	}

</script>




</head>

<body>
<form id="stuform" action="${pageContext.request.contextPath}/student/list/1">
<div class="layui-container">
    <div class="layui-row" style="margin-top: 10px">
        <div class="layui-col-xs3" style="margin-right: 20px">
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">姓名：</label>
                <div class="layui-input-block">
                    <input type="text" id="no" name="stuName" class="layui-input" placeholder="学生姓名">
                </div>
            </div>
        </div>
        <div class="layui-col-xs3" style="margin-right: 20px">
            <div class="layui-form-item layui-form-text">
                <label class="layui-form-label">班级：</label>
                <div class="layui-input-block">
                    <select class="layui-input" id="fg" name="gradeid">
                        <option value="">--请选择班级--</option>
                    </select>
                </div>
            </div>
        </div>
        <div class="layui-col-xs2">
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <button class="layui-btn" type="submit"><i class="layui-icon layui-icon-search">搜索</i></button>
                </div>
            </div>
        </div>
        <div class="layui-col-xs2">
            <div class="layui-form-item">
                <div class="layui-input-block">
                    <a class="layui-btn layui-btn-mini layui-btn-mini" href="javascript:alert('导出中...');" lay-event="detail">导出Excel</a>
                </div>
            </div>
        </div>
    </div>
</div>
</form>
	<div class="layui-container">
		<table class="layui-table" id="tbdata" lay-filter="tbop">
			<thead>
				<tr>
					<td>学号</td>
					<td>姓名</td>
					<td>班级</td>
					<td>性别</td>
					<td>手机号</td>
					<td>邮箱</td>
					<td>操作</td>
				</tr>
			</thead>
			<tbody>
			<c:forEach items="${pageBean.list}" var="s">
				<tr>
					<td>${s.no}</td>
					<td>${s.name}</td>
					<td>${s.grade.name}</td>
					<td>${s.sex}</td>
					<td>${s.phone}</td>
					<td>${s.email}</td>
					<td><a class="layui-btn layui-btn-mini" href="/student/goUpdate/${s.id}">编辑</a>
						<a class="layui-btn layui-btn-mini layui-btn-mini" lay-event="detail" onclick="godetails(${s.id});">查看详情</a>
						<a class="layui-btn layui-btn-danger layui-btn-mini"
						lay-event="del" onclick="deleteCourse(${s.id});">删除</a>
					</td>
				</tr>
				</c:forEach>
			</tbody>
		</table>
		<!-- 分页 -->
		<div align="center" class="layui-box layui-laypage layui-laypage-default"
			id="layui-laypage-1">
			<a href="javascript:;" class="layui-laypage-prev layui-disabled" data-page="0">
			 	<i class="layui-icon">
			 		<!-- 上一页 -->
			 		<c:if test="${hasPrevious == true }">
			 			<a href="#" onclick="goPage(${pageBean.pageIndex-1});">&lt;</a>
			 		</c:if>
			 	</i>
			</a>

			<c:forEach begin="${pageBean.startNum}" end="${pageBean.endNum}"
				step="1" var="i">
				<c:if test="${pageBean.pageIndex==i}">
					<span style="color: #009688; font-weight: bold;">${i}</span>
				</c:if>
				<c:if test="${pageBean.pageIndex!=i}">
					<a href="#" onclick="goPage(${i})">${i}</a>
				</c:if>
			</c:forEach>

			<a href="javascript:;" class="layui-laypage-next layui-disabled" data-page="2">
			  <i class="layui-icon">
			  	 <c:if test="${hasNext == true }">
			 	 	<!-- 下一页 -->
					<a href="#" onclick="goPage(${pageBean.pageIndex+1});">&gt;</a>
				</c:if>
			 </i>
			</a> 
			<span class="layui-laypage-skip">到第 <input type="text" min="1" value="1" class="layui-input">页
				<button type="button" class="layui-laypage-btn">确定</button>
			</span> 
			<span class="layui-laypage-count">共${pageBean.totalCount}条</span>
			 <span class="layui-laypage-limits"> <select name="#" onchange="changeSize(this);">
					<option value="5" selected>5 条/页</option>
					<option value="10">10条/页</option>
					<option value="15">15 条/页</option>
					<option value="20">20 条/页</option>
			</select>
			</span>
		</div>
	</div>
	
	
	<script src="${pageContext.request.contextPath}/media/layui/layui.js"></script>
	
	<script type="text/javascript">
		function godetails(stuId){
			//alert("id="+stuId);
			 location.href="${pageContext.request.contextPath}/student/details/"+stuId;
		}
		
	   function deleteCourse(delId){
		   layui.use('table', function() {
			   layer.confirm('是否确认删除学生?',function(index) {
				   location.href="${pageContext.request.contextPath}/student/del/"+delId;
			   });
		   });
	   }
	</script>
	<script>
	    
		var form;
		layui.use([ 'form', 'laydate' ],
				function() {
					form = layui.form, layer = layui.layer, laydate = layui.laydate;
							//日期
							laydate.render({
								elem : '#date'
							});
							initData();
		});
		
		//初始化数据
		function initData() {
			$.get("${pageContext.request.contextPath}/student/gradelist",null,function(arr){
				for(i=0;i<arr.length;i++){
					
						$("#fg").append("<option value='"+arr[i].id+"'>"+arr[i].name+"</option>");
					
				}
				form.render("select");
			})
		}

	</script>
	
</body>
</html>