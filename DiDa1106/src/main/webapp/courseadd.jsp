<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>滴答办公系统-学科新增</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="${pageContext.request.contextPath }/media/layui/css/layui.css" media="all">
</head>
<body>

	<div class="layui-container" style="margin-top: 5px">
		<form class="layui-form" action="/course/addCourse" method="post">
			<div class="layui-form-item">
				<label class="layui-form-label">学科名称</label>
				<div class="layui-input-block">
					<input type="text" name="name" lay-verify="name" autocomplete="off"
						placeholder="请输入名称" class="layui-input">
				</div>
			</div>
			
			<div class="layui-form-item">
				<label class="layui-form-label">成立日期</label>
				<div class="layui-input-block">
				 <input type="text" name="createdate" id="date" autocomplete="off" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">学科周期</label>
				<div class="layui-input-block">
					<input type="text" name="week" lay-verify="name" autocomplete="off"
						placeholder="请输入周期" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">学科类型</label>
				<div class="layui-input-block">
					<select name="type">
						<option value="普通">普通</option>
						<option value="精品">精品</option>
						<option value="业余">业余</option>
					</select>
				</div>
			</div>
		
			
			
			<div class="layui-form-item">
				<input class="layui-btn" style="margin-left: 10%" type="submit" value="确认新增">
			</div>
		</form>
	</div>


	<script src="media/layui/layui.js"></script>
	<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
	<script>
		layui
				.use(
						[ 'form', 'laydate' ],
						function() {
							var form = layui.form, layer = layui.layer, laydate = layui.laydate;

							//日期
							laydate.render({
								elem : '#date'
							});
							

							//自定义验证规则
							form.verify({
								title : function(value) {
									if (value.length < 5) {
										return '标题至少得5个字符啊';
									}
								},
								pass : [ /(.+){6,12}$/, '密码必须6到12位' ],
								content : function(value) {
									layedit.sync(editIndex);
								}
							});
		});
	</script>
</body>
</html>