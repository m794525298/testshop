<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ include file ="admin_menu.jsp" %>
    <!--/sidebar-->
    <div class="main-wrap">

        <div class="crumb-wrap">
            <div class="crumb-list"><i class="icon-font"></i><a href="/jscss/admin/design/">首页</a><span class="crumb-step">&gt;</span><a class="crumb-name" href="admin_user.jsp">用户管理</a><span class="crumb-step">&gt;</span><span>新增用户</span></div>
        </div>
        <div class="result-wrap">
            <div class="result-content">
                <form action="/testshop/manage/admin_douseradd" method="post" id="myform" name="myform" >
                    <table class="insert-tab" width="100%">
                        <tbody>
                            <tr>
                                <th><i class="require-red">*</i>用户ID：</th>
                                <td>
                                    <input class="common-text required" id="USERID" name="USERID" size="50" value="" type="text">
                                </td>
                            </tr>
                             <tr>
                                <th><i class="require-red">*</i>用户NAME：</th>
                                <td>
                                    <input class="common-text required" id="USERNAME" name="USERNAME" size="50" value="" type="text">
                                </td>
                            </tr>
                             <tr>
                                <th><i class="require-red">*</i>用户PASSWORD：</th>
                                <td>
                                    <input class="common-text required" id="USERPASSWORD" name="USERPASSWORD" size="50" value="" type="text">
                                </td>
                            </tr>
                             <tr>
                                <th><i class="require-red">*</i>用户IDENTITY：</th>
                                <td>
                                    <input class="common-text required" id="USERIDENTITY" name="USERIDENTITY" size="50" value="" type="text">
                                </td>
                            </tr>
                            <tr>
                                <th>用户EMAIL：</th>
                                <td><input class="common-text" name="USEREMAIL" size="50" value="" type="text"></td>
                            </tr>
                             <tr>
                                <th>用户STUNUM：</th>
                                <td><input class="common-text" name="USERSTUNUM" size="50" value="2017302580123" type="text"></td>
                            </tr>
                           <tr>
                                <th>用户QQ：</th>
                                <td><input class="common-text" name="USERQQ" size="50" value="794525298" type="text"></td>
                            </tr>
                           
                            <tr>
                                <th></th>
                                <td>
                                    <input class="btn btn-primary btn6 mr10" value="提交" type="submit">
                                    <input class="btn btn6" onClick="history.go(-1)" value="返回" type="button">
                                </td>
                            </tr>
                        </tbody></table>
                </form>
            </div>
        </div>

    </div>
    <!--/main-->
</div>
</body>
</html>