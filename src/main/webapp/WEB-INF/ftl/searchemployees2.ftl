<!DOCTYPE html>
<html>
<#--分页实现页面-->
<head>
    <title>CoolMeeting会议管理系统</title>
    <link rel="stylesheet" href="/styles/common.css"/>
    <style type="text/css">

    </style>
</head>
<body>
<#include './top.ftl'>
<div class="page-body">
    <#include './leftMenu.ftl'>
    <div class="page-content">
        <div class="content-nav">
            会议预定 > 搜索员工
        </div>
        <form action="/admin/searchemployees" method="post">
            <fieldset>
                <legend>搜索会议</legend>
                <table class="formtable">
                    <tr>
                        <td>姓名：</td>
                        <td>
                            <input type="text" name="employeename" id="employeename"
                                   value="<#if employee.employeename??>${employee.employeename}</#if>" maxlength="20"/>
                        </td>
                        <td>账号名：</td>
                        <td>
                            <input type="text" name="username" id="accountname"
                                   value="<#if employee.username??>${employee.username}</#if>" maxlength="20"/>
                        </td>
                        <td>状态：</td>
                        <td>
                            <input type="radio" id="status" name="status" value="1"
                                   checked="checked"/><label>已批准</label>
                            <input type="radio" id="status" name="status" value="0"/><label>待审批</label>
                            <input type="radio" id="status" name="status" value="-1"/><label>已关闭</label>
                        </td>
                    </tr>
                    <tr>
                        <td colspan="6" class="command">
                            <input type="submit" class="clickbutton" value="查询"/>
                            <a type="reset" class="clickbutton" href="/admin/searchemployees?status=1">重置</a>
                        </td>
                    </tr>
                </table>
            </fieldset>
        </form>
        <div>
            <h3 style="text-align:center;color:black">查询结果</h3>
            <div class="pager-header">
                <div class="header-info">
                    共<span class="info-number">${pageInfo.total}</span>条结果，
                    分成<span class="info-number">${pageInfo.pages}</span>页显示，
                    当前第<span class="info-number">${pageInfo.pageNum}</span>页
                </div>
                <form action="/admin/searchemployees" method="get">
                    <div class="header-nav">
                        <#if pageInfo.pages=1>
                            <input type="submit" name="page" class="clickbutton" value='1'>
                        </#if>

                        <#if pageInfo.pages=2>
                            <input type="submit" name="page" class="clickbutton" value='1'>
                            <input type="submit" name="page" class="clickbutton" value='2'>
                        </#if>
                        <#if pageInfo.pages=3>
                            <input type="submit" name="page" class="clickbutton" value='1'>
                            <input type="submit" name="page" class="clickbutton" value='2'>
                            <input type="submit" name="page" class="clickbutton" value='2'>
                        </#if>
                        <#if pageInfo.pages=4>
                            <input type="submit" name="page" class="clickbutton" value='1'>
                            <input type="submit" name="page" class="clickbutton" value='2'>
                            <input type="submit" name="page" class="clickbutton" value='3'>
                            <input type="submit" name="page" class="clickbutton" value='4'>
                        </#if>
                        <#if pageInfo.pages gt 4>
                            <input type="submit" name="page" class="clickbutton" value='1'>

                            <#if (pageInfo.pageNum = 1 )>
                                <input type="submit" name="page" class="clickbutton" value='2'>
                                <input type="submit" name="page" class="clickbutton" value='3'>
                            <#elseif (pageInfo.pageNum = 2 )>
                                <input type="submit" name="page" class="clickbutton" value='2'>
                                <input type="submit" name="page" class="clickbutton" value='3'>
                            <#elseif (pageInfo.pageNum = (pageInfo.pages) )>
                                <input type="submit" name="page" class="clickbutton" value='${pageInfo.pages-2}'>
                                <input type="submit" name="page" class="clickbutton" value='${pageInfo.pages-1}'>
                            <#elseif (pageInfo.pageNum = (pageInfo.pages-1) )>
                                <input type="submit" name="page" class="clickbutton" value='${pageInfo.pages-2}'>
                                <input type="submit" name="page" class="clickbutton" value='${pageInfo.pages-1}'>
                            <#else >

                                <input type="submit" name="page" class="clickbutton"
                                       value='${(pageInfo.pageNum) - 1}'>
                                <input type="submit" name="page" class="clickbutton"
                                       value='${(pageInfo.pageNum)}'>
                                <input type="submit" name="page" class="clickbutton"
                                       value='${(pageInfo.pageNum)+1}'>

                            </#if>

                            <input type="submit" name="page" class="clickbutton" value='${pageInfo.pages}'>
                        </#if>

<#--                        跳到第<input type="text" id="pagenum" class="nav-number"/>页-->
<#--                        <input type="button" class="clickbutton" value="跳转"/>-->
                    </div>
                    <input type="hidden" name="employeename" value="<#if employee??>${employee.employeename!''}</#if>">
                    <input type="hidden" name="username" value="<#if employee??>${employee.username!''}</#if>">
                    <input type="hidden" name="status" value="<#if employee??>${employee.status!''}</#if>">
                </form>
            </div>
        </div>
        <table class="listtable">
            <tr class="listheader">
                <th>姓名</th>
                <th>账号名</th>
                <th>联系电话</th>
                <th>电子邮件</th>
                <#--                <th>操作</th>-->
            </tr>

            <#if pageInfo.list??>
                <#list pageInfo.list as emp>
                    <tr>
                        <td>${emp.employeename}</td>
                        <td>${emp.username}</td>
                        <td>${emp.phone}</td>
                        <td>${emp.email}</td>
                        <#--                        <td>-->
                        <#--                            <a class="clickbutton" href="shutdown?eid=${emp.employeeid}">关闭账号</a>-->
                        <#--                        </td>-->
                    </tr>
                </#list>
            </#if>


        </table>
    </div>
</div>
<div class="page-footer">
    <hr/>
    更多问题，欢迎联系<a href="mailto:webmaster@eeg.com">管理员</a>
    <img src="/images/footer.png" alt="CoolMeeting"/>
</div>
</body>
</html>