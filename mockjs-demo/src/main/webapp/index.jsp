<%--
  Created by IntelliJ IDEA.
  User: 12419
  Date: 2019/4/29
  Time: 17:09
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <%-- 通过cdn的形式引入mockjs --%>
    <script src="https://cdn.bootcss.com/Mock.js/1.0.0/mock-min.js"></script>
</head>
<body>

<h2>mock</h2>
</body>

    <script>
        var mockData = Mock.mock({
            'user|3-10': [
                {
                    // 正则生成姓名
                    // 'name':/^Kingdee_[a-zA-Z]{4,6}/,
                    // 占位符生成中文名字
                    // 'name':'@cname',
                    // 占位符生成英文名字
                    'name':'@name',
                    'age|10-100': 1,
                    'gender': /[01]/,
                    // 使用正则表达式生成邮箱
                    // 'email':/^1[0-9]{9}@qq[.]com/,
                    // 使用占位符生成邮箱
                    'email':'@email',
                    'birthday':'@datetime'
                }
            ]
        });

        console.log(mockData);

    </script>


</html>
