<%--
  Created by IntelliJ IDEA.
  User: Administrator
  Date: 2018/7/23
  Time: 14:46
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <title>Title</title>
    <script type="text/javascript" src="/js/jquery-1.11.2.min.js"></script>
    <script>
        $(function(){
            $("#sub").click(function(){
                $.ajax({
                    data:{name:$("#name").val(),age:$("#age").val(),phone:$("#phone").val()},
                    dataType:"json",
                    type:"get",
                    url:"/foo1",
                    success:function(data){
                        if(data.status==200)
                        {
                            alert("ok");
                        }
                        else {
                            alert("error");
                            $("#errormsg").css("color","red").html(data.errors[0]);

                        }
                    }
                })
            })
        })
    </script>
</head>
<body>
        <input type="text" name="name" id="name" value="zhangli"/>
        <input type="text" name="phone" id="phone" value="15295523127"/>
        <input type="text" name="age" id="age" value="12"/>
        <input type="button" id="sub" value="提交"/>
        <label id="errormsg" ></label>
</body>
</html>
