<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>滴答办公系统-学员更新</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="${pageContext.request.contextPath }/media/layui/css/layui.css" media="all">
<script type="text/javascript" src="${pageContext.request.contextPath }/media/js/jquery.min.js"></script>
</head>
<body>
	<div class="layui-container" style="margin-top: 5px">
		<form class="layui-form" action="/student/update" method="post">
			<!-- <div class="layui-form-item">
				<label class="layui-form-label">学员学号</label>
				<div class="layui-input-block">
					<input type="text" name="no" lay-verify="name" autocomplete="off"
						placeholder="请输入学号" id="no1" class="layui-input" value="">
				</div>
			</div> -->
			<div class="layui-form-item">
				<label class="layui-form-label">学员姓名</label>
				<div class="layui-input-block">
					<input type="text" name="name" lay-verify="name" autocomplete="off"
						placeholder="请输入姓名" class="layui-input" value="${stu.name }">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">所属班级</label>
				<div class="layui-input-block">
					<select name="gid" id="cds">
						<option value="-1">--请选择班级--</option>
					</select>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">性别</label>
				<div class="layui-input-block">
					<input type="radio" name="sex"  title="男" value="男"  ${stu.sex == '男'?"checked":"" }>
					<input type="radio" name="sex" title="女" value="女"  ${stu.sex == '女'?"checked":"" }>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">邮箱</label>
				<div class="layui-input-inline">
					<input type="text" name="email" lay-verify="required"
						placeholder="请输入有效" autocomplete="off" class="layui-input" value="${stu.email }">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">手机号</label>
				<div class="layui-input-inline">
					<input type="text" name="phone" lay-verify="required"
						placeholder="请输入手机号" autocomplete="off" class="layui-input" value="${stu.phone }">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">QQ</label>
				<div class="layui-input-inline">
					<input type="text" name="qq" lay-verify="required"
						placeholder="请输入QQ" autocomplete="off" class="layui-input" value="${stu.qq }">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">身份证号</label>
				<div class="layui-input-inline">
					<input type="text" name="cardno" lay-verify="required"
						placeholder="请输入身份证号" autocomplete="off" class="layui-input" value="${stu.cardno }">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">毕业学校</label>
				<div class="layui-input-inline">
					<input type="text" name="school" lay-verify="required"
						placeholder="请输入毕业学校" autocomplete="off" class="layui-input" value="${stu.school }">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">学历</label>
				<div class="layui-input-inline">
					<select name="education">
						<option value="初中" ${stu.education == '初中'?"selected":"" }>初中</option>
						<option value="高中" ${stu.education == '高中'?"selected":"" }>高中</option>
						<option value="专科" ${stu.education == '专科'?"selected":"" }>专科</option>
						<option value="本科" ${stu.education == '本科'?"selected":"" }>本科</option>
						<option value="硕士" ${stu.education == '硕士'?"selected":"" }>硕士</option>
						<option value="博士" ${stu.education == '博士'?"selected":"" }>博士</option>
					</select>
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">出生日期</label>
				<div class="layui-input-inline">
					<input type="date" name="birthday" id="date1" autocomplete="off"
						class="layui-input" value="${stu.birthday }">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">入学日期</label>
				<div class="layui-input-inline">
					<input type="date" name="createdate" id="date2" autocomplete="off"
						class="layui-input" value="${stu.createdate }">
				</div>
			</div>
			<div class="layui-form-item">
				<input class="layui-btn"  style="margin-left: 10%" id="btn1" type="submit"
					value="确认更新">
			</div>
		</form>
	</div>


	<script src="${pageContext.request.contextPath }/media/layui/layui.js"></script>
	<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
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
					if(arr[i].id == ${stu.gid}){
						$("#cds").append("<option value='"+arr[i].id+"' selected=true>"+arr[i].name+"</option>");
					}else{
						$("#cds").append("<option value='"+arr[i].id+"'>"+arr[i].name+"</option>");
					}
				}
				form.render("select");
			})
		}

	</script>
</body>
</html>