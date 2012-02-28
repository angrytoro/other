<#assign pageTitle = "${wml(name)}个人主页"/>
<#include "../common/Header.ftl"/>
<#include "../common/MesssgeNotification.ftl"/>
<p>
<big><strong>个人详细信息</strong></big>
<#if sid?? && sid == user.sid> <#--只有自己才能修改个人资料-->
<a href="showProfile.wml?sid=${sid}">修改个人信息</a>
<a href="enterModify.wml?sid=${sid}">账号设置</a>
</#if>
<br/>
用户名：${(name)!"***"}
<br/>
电话：${(user.mobile)!"还没填写！"} email:${(user.email)!"还没填写！"}
<br/>
发表帖子数：${postAmount!"0"} 回复数：${replyAmount!"0"}
<br />
积分：${(user.mark)!"0"} 金钱：${(user.money)!"0"}￥
<br/>
注册时间：${(user.reg_time)!"0"} 最近登录时间：${(user.login_time)!"0"}
</p>
<p>
<strong>==发表的帖子==</strong> 
<#if postAmount &gt; 10>
	<a href="showUserPost.wml?sid=${sid}&amp;name=${name}&amp;postAmount=${postAmount}">更多</a><br/>
</#if>
<#if posts??>
	<#assign floor = 1 />
	<#list posts as post>
		#{floor}.<a href="post.wml?sid=${sid}&amp;postId=#{post.id}">${wml(width(post.title, 24))}</a><br />
		<#assign floor = (floor + 1)/>
	</#list>
</#if>
</p>
<p>
<#if sid?? && sid == user.sid> <#--只有自己才能查看自己的回复-->
	<strong>==发表的帖子==</strong> 
	<#if replyAmount &gt; 10>
		<a href="">更多</a>
	</#if>
	<#if replys??>
		<#assign floor = 1 />
		<#list replys as reply>
			#{floor}.<a href="">回复的链接</a>
			<#assign floor = floor + 1>
		</#list>
	</#if>
</#if>
</p>
<#include "../common/Footer.ftl"/>