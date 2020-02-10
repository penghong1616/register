<%@ page contentType="text/html;charset=utf-8"%>
<!DOCTYPE html>
<html lang="zh-CN">
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <!-- 上述3个meta标签*必须*放在最前面，任何其他内容都*必须*跟随其后！ -->
    <title>在家自学签到</title>

    <!-- Bootstrap -->
    <link href="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/css/bootstrap.min.css" rel="stylesheet">

    <!-- HTML5 shim 和 Respond.js 是为了让 IE8 支持 HTML5 元素和媒体查询（media queries）功能 -->
    <!-- 警告：通过 file:// 协议（就是直接将 html 页面拖拽到浏览器中）访问页面时 Respond.js 不起作用 -->
    <!--[if lt IE 9]>
    <script src="https://cdn.jsdelivr.net/npm/html5shiv@3.7.3/dist/html5shiv.min.js"></script>
    <script src="https://cdn.jsdelivr.net/npm/respond.js@1.4.2/dest/respond.min.js"></script>
    <![endif]-->
</head>
<body>
<h1 align="center">实训签到</h1>

<!-- jQuery (Bootstrap 的所有 JavaScript 插件都依赖 jQuery，所以必须放在前边) -->
<script src="https://cdn.jsdelivr.net/npm/jquery@1.12.4/dist/jquery.min.js"></script>
<!-- 加载 Bootstrap 的所有 JavaScript 插件。你也可以根据需要只加载单个插件。 -->
<script src="https://cdn.jsdelivr.net/npm/bootstrap@3.3.7/dist/js/bootstrap.min.js"></script>
<div class="container">
    <div class="row clearfix">
        <div class="col-md-4 column">
        </div>
        <div class="col-md-4 column">
            <form>
                <div class="form-group">
                    <label for="user" stype="display:inline;">姓名：</label>
                    <input type="text" class="form-control" id="user" name="name" style="display:inline;width:100%;"autocomplete="off" />
                </div>
                <div class="form-group">
                    <label for="cla" style="display:inline;">班级：</label>
                    <input type="text" class="form-control" id="cla" name="class" style="display:inline;width:100%;"autocomplete="off" />
                </div>
                <div>
                    <button type="reset" class="btn btn-primary btn-block">重置</button>
                    <button type="button" onclick="register()" class="btn btn-primary btn-block">签到</button>
                </div>
            </form>
        </div>
        <div class="col-md-4 column">
        </div>
    </div>
</div>
</body>
<script>
    function register(){
        var name=$("#user").val();
        var cla=$("#cla").val();
        if (name==''||cla==''){
            alert("姓名或班级为空");
            return;
        }
        $.ajax({
            //请求方式
            type : "POST",
            //请求的媒体类型
            contentType: "application/json;charset=UTF-8",
            //请求地址
            url : "/register/register?name="+name+"&cla="+cla,
            //数据，json字符串
            //data : {
             //   "cla":cla
           // },
            //请求成功
            success : function(result) {
                if (result==200){
                    alert("签到成功");
                }
            },
            //请求失败，包含具体的错误信息
            error : function(e){
                alert(e.status);
                alert("签到失败");
            }
        });

    }
</script>
</html>
