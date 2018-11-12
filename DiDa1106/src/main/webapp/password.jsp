<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>滴答办公系统-班级新增</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="${pageContext.request.contextPath }/media/layui/css/layui.css" media="all">
<script type="text/javascript" src="${pageContext.request.contextPath }/media/js/jquery.min.js"></script>
<script type="text/javascript">

function chpwd(){
   layui.use('table', function() {
	   //alert(delId);
	  
		   $.ajax({
	     	   url:"/user/chpwd/",
	     	   type:"post",
	     	   dataType:"json",
	     	   success:function(result){
	     		  //alert("result:"+result);
	     		  if(true == result){
	     			 layer.msg("密码已更改", {icon : 6});
	     			 location.reload(true);	
	     			 //location.href="/course/list/1";
	     		  }else{
	     			 layer.msg("原密码错误", {icon : 5});
	     		  }
	     	   }
	        });
	 
	})
}

function validate() {
	var pwd1 = document.getElementById("newpwd").value;
	var pwd2 = document.getElementById("password").value;
	//alert("new="+pwd1+",new2="+pwd2);
			<!-- 对比两次输入的密码 -->
	if(pwd1 == pwd2) {
		//document.getElementById("tishi").innerHTML="<font color='green'>两次密码相同</font>";
		document.getElementById("submit").disabled = false;
	}else {
		document.getElementById("tishi").innerHTML="<font color='red'>两次密码不相同</font>";
		document.getElementById("submit").disabled = true;
	}
}

</script>



</head>
<body>
	<div class="layui-container" style="margin-top: 5px">
		<form class="layui-form" action="/user/chpwd" method="post">
			<div class="layui-form-item">
				<label class="layui-form-label">原始密码</label>
				<div class="layui-input-block">
					<input type="text" name="prepwd"  lay-verify="name" autocomplete="off"
						placeholder="请输入密码" class="layui-input">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">新密码</label>
				<div class="layui-input-block">
				 <input type="password" name="newpwd" id="newpwd" class="layui-input">
				</div>
			</div>
			<!-- 小眼睛密码可见功能   待实现 -->
			<div class="layui-form-item">
				<label class="layui-form-label">确认新密码</label>
				<div class="layui-input-block">
			      <input type="password" name="password" id="password" class="layui-input" onblur="validate();">
				</div>
			</div>
			<div class="layui-form-item">
				<input class="layui-btn"  style="margin-left: 10%" type="submit" id="submit" value="确认修改"  onclick="chpwd();">
				<a id="tishi" style="color:red"></a>
				
			</div>
		</form>
	</div>


	<script src="media/layui/layui.js"></script>
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
						
		});
		
	</script>
</body>
</html>