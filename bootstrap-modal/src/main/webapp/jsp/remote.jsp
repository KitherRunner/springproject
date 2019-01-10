<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<div class="modal-header">
    <button type="button" class="close" data-dismiss="modal" aria-label="Close"><span aria-hidden="true">&times;</span>
    </button>
    <h4 class="modal-title">添加用户</h4>
</div>
<div class="modal-body">
    <form id="addForm">
        <div class="form-group">
            <label for="account">账号</label>
            <input type="text" class="form-control" id="account" name="account" placeholder="账号（用于登录）">
        </div>
        <div class="form-group">
            <label for="username">用户名</label>
            <input type="text" class="form-control" id="username" name="username" placeholder="用户名">
        </div>
        <div class="form-group">
            <label for="password">密码</label>
            <input type="password" class="form-control" id="password" name="password" placeholder="Password">
        </div>
    </form>
</div>
<div class="modal-footer">
    <button type="button" id="resetBtn" class="btn btn-default">重置</button>
    <button type="button" id="saveBtn" class="btn btn-primary">提交</button>
</div>