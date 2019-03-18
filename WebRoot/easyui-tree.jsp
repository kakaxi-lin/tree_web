<%@ page language="java" import="java.util.*" pageEncoding="UTF-8"%>
<%
String path = request.getContextPath();
String basePath = request.getScheme()+"://"+request.getServerName()+":"+request.getServerPort()+path+"/";
%>

<!DOCTYPE HTML PUBLIC>
<html>
<head>
	<meta charset="UTF-8">
	<title>Basic Tree - jQuery EasyUI Demo</title>
	<link rel="stylesheet" type="text/css" href="<%=path %>/themes/default/easyui.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/themes/icon.css">
	<link rel="stylesheet" type="text/css" href="<%=path %>/themes/demo.css">
	<script type="text/javascript" src="<%=path %>/js/jquery.min.js"></script>
	<script type="text/javascript" src="<%=path %>/js/jquery.easyui.min.js"></script>
	<script type="text/javascript">
	$(function(){
		console.log("cccc");
		$('#test_tree').tree({
			url:"<%=path %>/treeServlet",
			loadFilter: function(data){
				console.log(data);
					return data;
		    }
		});
	})
	</script>
</head>
<body>
	<h2>Basic Tree</h2>
	<p>Click the arrow on the left to expand or collapse nodes.</p>
	<div style="margin:20px 0;"></div>
	<div class="easyui-panel" style="padding:5px">
		<ul id="test_tree" class="easyui-tree"></ul>
	</div>

</body>
</html>