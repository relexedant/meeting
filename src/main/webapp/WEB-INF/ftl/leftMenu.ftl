<div class="page-sidebar">
    <div class="sidebar-menugroup">
        <div class="sidebar-grouptitle">个人中心</div>
        <ul class="sidebar-menu">
            <li class="sidebar-menuitem"><a href="notifications">最新通知</a></li>
            <li class="sidebar-menuitem active"><a href="mybookings">我的预定</a></li>
            <li class="sidebar-menuitem"><a href="mymeetings">我的会议</a></li>
        </ul>
    </div>
    <div class="sidebar-menugroup">
        <div class="sidebar-grouptitle">人员管理</div>
        <ul class="sidebar-menu">

            <li class="sidebar-menuitem"><a href="register">员工注册</a></li>
                            <#if currentuser?? && (currentuser.role="2")>

<#--<#if currentuser.role="2" >-->
<#--    ${currentuser.role}-->
<#--</#if>-->

<#--            <#assign arg1>-->
<#--                ${currentuser.role}-->
<#--            </#assign>-->
<#--            ${arg1}-->
<#--&lt;#&ndash;            <#macro mo>&ndash;&gt;-->
<#--&lt;#&ndash;                ${currentuser.role}&ndash;&gt;-->
<#--&lt;#&ndash;            </#macro>&ndash;&gt;-->
<#--&lt;#&ndash;            <@mo />&ndash;&gt;-->
<#--            <#if '${arg1}'>-->
<#--                444-->
<#--            </#if>-->
<#--            <#if currentuser??>-->

            <li class="sidebar-menuitem"><a href="/admin/departments">部门管理</a></li>
            <li class="sidebar-menuitem"><a href="/admin/approveaccount">注册审批</a></li>
            <li class="sidebar-menuitem"><a href="/admin/searchemployees?status=1">搜索员工</a></li>
            <#--                </#if>-->
            </#if>
        </ul>

    </div>

    <div class="sidebar-menugroup">
        <div class="sidebar-grouptitle">会议预定</div>
        <ul class="sidebar-menu">

                        <#if currentuser?? && (currentuser.role="2")>
            <li class="sidebar-menuitem"><a href="/admin/addmeetingroom">添加会议室</a></li>
                        </#if>

            <li class="sidebar-menuitem"><a href="meetingrooms">查看会议室</a></li>
            <li class="sidebar-menuitem"><a href="bookmeeting">预定会议</a></li>
            <li class="sidebar-menuitem"><a href="searchmeetings">搜索会议</a></li>
        </ul>
    </div>
</div>