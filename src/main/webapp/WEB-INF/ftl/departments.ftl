<!DOCTYPE html>
<html>
<head>
    <title>CoolMeeting会议管理系统</title>
    <link rel="stylesheet" href="/styles/common.css"/>
    <script src="https://cdn.bootcdn.net/ajax/libs/jquery/3.5.1/jquery.js"></script>
</head>
<body>
<#include './top.ftl'>
</div>
<div class="page-body">
    <#include './leftMenu.ftl'>
    <div class="page-content">
        <div class="content-nav">
            人员管理 > 部门管理
        </div>
        <form action="/admin/adddep" method="post">
            <fieldset>
                <legend>添加部门</legend>
                部门名称:
                <input type="text" name="department" id="departmentname" maxlength="20"/>
                <input type="submit" class="clickbutton" value="添加"/>
            </fieldset>
        </form>
        <table class="listtable">
            <caption>所有部门:</caption>
            <tr class="listheader">
                <th>部门编号</th>
                <th>部门名称</th>
                <th>操作</th>
            </tr>

            <#if deps??>
                <#list deps as dep>
                    <tr>
                        <td>${dep.departmentid}</td>
                        <td id="depname${dep.departmentid}">${dep.departmentname}</td>
                        <td>
                            <a class="clickbutton" id="edit${dep.departmentid}" onclick="editDep(${dep.departmentid})"
                               href="#">编辑</a>
                            <a class="clickbutton" style="display: none" id="cancle${dep.departmentid}"
                               onclick="cancle(${dep.departmentid},'${dep.departmentname}')" href="#">编辑</a>
                            <a class="clickbutton" href="/admin/deleteDep?depid=${dep.departmentid}">删除</a>
                        </td>
                    </tr>
                </#list>
            </#if>
            <tr>
                <td>1</td>
                <td>技术部</td>
                <td>
                    <a class="clickbutton" href="#">编辑</a>
                    <a class="clickbutton" href="/admin/deleteDep">删除</a>
                </td>
            </tr>
            <tr>
                <td>2</td>
                <td>
                    <input type="text" value="销售部"/>
                </td>
                <td>
                    <a class="clickbutton" href="#">编辑</a>
                    <a class="clickbutton" href="#">取消</a>
                    <a class="clickbutton" href="#">删除</a>
                </td>
            </tr>

        </table>
    </div>
</div>
<div class="page-footer">
    <hr/>
    更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a>
    <img src="/images/footer.png" alt="CoolMeeting"/>
</div>
<script>
    <#--function cancle(depid,depname) {-->
    <#--    var editBtn = ${"#edit"+depid};-->
    <#--    var cancleBtn = ${"#cancle"+depid};-->
    <#--    var ele =${"#depname"+depid};-->
    <#--    cancleBtn.css('display','none');-->
    <#--    editBtn.html('编辑');-->
    <#--    ele.html(depname);-->
    <#--}-->
    <#--function editDep(depid) {-->
    <#--    var editBtn = ${"#edit"+depid};-->
    <#--    var cancleBtn = ${"#cancle"+depid};-->
    <#--    var ele =${"#depname"+depid};-->
    <#--    if (cancleBtn.css('display') == 'none') {-->
    <#--        cancleBtn.css('display', 'inline');-->
    <#--        editBtn.html('确定');-->
    <#--        var depName = ele.text();-->
    <#--        ele.html('<input type="text" value="+depName+" /> ');-->


    <#--    } else {-->

    <#--    }-->


    }
</script>
</body>
</html>