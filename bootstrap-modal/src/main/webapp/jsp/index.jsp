<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2019/1/10 0010
  Time: 21:07
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Index</title>
</head>
<script src="https://cdn.bootcss.com/jquery/3.3.1/jquery.js"></script>
<script src="https://cdn.bootcss.com/twitter-bootstrap/3.0.1/js/bootstrap.min.js"></script>
<body>
<button type="button" id="addBtn" class="btn btn-primary">新增用户</button>
<!-- 弹出模态窗口-->
<div class="modal fade" style="top:13%;" tabindex="-1" role="dialog" id="showModal">
    <div class="modal-dialog" role="document">
        <div class="modal-content">
            <!-- 内容会加载到这里 -->
        </div>
    </div><!-- /.modal-content -->
</div><!-- /.modal-dialog -->
</div><!-- /.modal -->
</body>
<script>
    $("#addBtn").click(function () {
        // 打开模态框
        $("#showModal").modal({
            backdrop: 'static',  	// 点击空白不关闭
            keyboard: false,		// 按键盘esc也不会关闭
            remote: 'remote' 	// 从远程加载内容的地址;该属性在3.3.0以上版本已删除，请使用jquery.load()方法
        });
    });
</script>
</html>
