<#assign pageTitle = "修改个人信息" />
<#include "../common/Header.ftl"/>
<#include "../common/MesssgeNotification.ftl"/>
<#if user??>
<strong>==修改==</strong><br/>
<p>
  用户名：<input name="name" type="text" value=${user.name} /> <br/>
电话号码：<input name="mobile" type="text" value=${user.mobile} /><br/>
	邮箱：<input name="email" type="text" value=${user.email} /> <br/>
</p>
</#if>
<anchor>修改
	<go href="modifyProfile.wml?sid=${sid}" method="post">
		<postfield name="name" value="$(name)" />
		<postfield name="mobile" value="$(mobile)" />
		<postfield name="email" value="$(email)" />
	</go>
</anchor>
<#include "../common/Footer.ftl"/>