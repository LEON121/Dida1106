<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="utf-8">
<title>滴答办公系统-员工新增</title>
<meta name="renderer" content="webkit">
<meta http-equiv="X-UA-Compatible" content="IE=edge,chrome=1">
<meta name="viewport"
	content="width=device-width, initial-scale=1, maximum-scale=1">
<link rel="stylesheet" href="${pageContext.request.contextPath }/media/layui/css/layui.css" media="all">
<script type="text/javascript" src="${pageContext.request.contextPath }/media/js/jquery.min.js"></script>
</head>
<body>
	<div class="layui-container" style="margin-top: 5px">
		<form class="layui-form" action="${pageContext.request.contextPath }/emp/update" method="post" >
			<div class="layui-form-item">
				<label class="layui-form-label">员工序号</label>
				<div class="layui-input-block">
					<input type="text" name="no" readonly="readonly" autocomplete="off"
						class="layui-input" id="f1" value="${emp.no }">
				</div>
			</div>
			<div class="layui-form-item">
				<label class="layui-form-label">员工姓名</label>
				<div class="layui-input-block">
					<input type="text" name="name" lay-verify="name" autocomplete="off"
						placeholder="请输入姓名" class="layui-input" value="${emp.name }">
				</div>
			</div>
			<div class="layui-form-item">
            <label class="layui-form-label">所属部门</label>
	            <div class="layui-input-block">
	                <select name="did"  id="cds">
	       				<option value="">--请选择部门--</option>
	      			</select>
	            </div>
            </div>
            <div class="layui-form-item">
				<label class="layui-form-label">性别</label>
				<div class="layui-input-block">
					<input type="radio" name="sex"  title="男" value="男"  ${emp.sex == '男'?"checked":"" }>
					<input type="radio" name="sex" title="女" value="女"  ${emp.sex == '女'?"checked":"" }>
				</div>
			</div>
	  		<div class="layui-form-item">
	            <label class="layui-form-label">邮箱</label>
	            <div class="layui-input-inline">
	                <input type="text" name="email" value="${emp.email }" lay-verify="required" placeholder="请输入有效邮箱" autocomplete="off" class="layui-input">
	            </div>
	        </div>
	  		<div class="layui-form-item">
	            <label class="layui-form-label">手机号</label>
	            <div class="layui-input-inline">
	                <input type="text" name="phone" value="${emp.phone}" lay-verify="required" placeholder="请输入手机号" autocomplete="off" class="layui-input">
	            </div>
	        </div>
	  		<div class="layui-form-item">
	            <label class="layui-form-label">QQ</label>
	            <div class="layui-input-inline">
	                <input type="text" name="qq" value="${emp.qq }" lay-verify="required" placeholder="请输入QQ号码" autocomplete="off" class="layui-input">
	            </div>
	        </div>
	  		<div class="layui-form-item">
	             <label class="layui-form-label">入职日期</label>
                <div class="layui-input-inline">
                    <input type="date" name="createdate" value="${emp.createdate }" id="date" autocomplete="off" class="layui-input">
                </div>
	        </div>
 			<div class="layui-form-item">
 				 <label class="layui-form-label">照片</label>
 				 <input id="pic1" name="pic" type="file"/>
				<div width="200px" height="300px">
					<img alt="个人一寸照片"  id="pic2" width="200px" height="300px" src="${pageContext.request.contextPath}/static/upload/${emp.photo}"/>
				</div>
 			</div>
			<div class="layui-form-item">
				<input class="layui-btn"  style="margin-left: 10%"  id="btn1"  type="submit" value="确认新增">
			</div>
		</form>
	</div>


	<script src="${pageContext.request.contextPath }/media/layui/layui.js"></script>
	<!-- 注意：如果你直接复制所有代码到本地，上述js路径需要改成你本地的 -->
	
	<script type="text/javascript">
		//图片自动预览
	    //此方法实现从本地位置打开图片
		    $("#pic1").change(function(){
		        //$("#previewImg").attr("src","file:///" + $("#myfile").val());
		        var pv = document.getElementById("pic2");
		        if (pv.filters && typeof(pv.filters.item) === 'function'){
		            pv.filters.item("DXImageTransform.Microsoft.AlphaImageLoader").src = el.value;
		        }else{
		            var oFile = document.getElementById('pic1').files[0];
		            var oReader = new FileReader();
		            oReader.onload = function(e){
		                $("#pic2").attr("src", e.target.result);
		            };
		            oReader.readAsDataURL(oFile);
		        }
		    });
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
			$.get("${pageContext.request.contextPath}/emp/departlist",null,function(arr){
				for(i=0;i<arr.length;i++){
					if(arr[i].id == ${emp.did}){
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