<#if post??>
	<#assign pageTitle="${wml(post.title)}_3ghack.com" />
<#else>
	<#assign pageTitle="帖子不存在_3ghack.com" />
</#if>
<#include "../common/Header.ftl"/>
<#if sessionUser??>
	<#include "../common/MesssgeNotification.ftl"/>
<#else>
	欢迎你<a href="../user/login.wml">登录/注册</a><br />
</#if>
<#if post??>
	标题:${wml(post.title)}(阅#{post.viewCount})<br />
	楼主:<a href="../user/user.wml?sid=${sid}&amp;userId=#{post.userId}">${wml(post.authorName)}</a>(ID:#{post.userId})<br />
	时间:${post.createTime?datetime}<br />
	帖子ID：#{post.id}<br />
	----------<br />
	<#if viewRemain>
		<a href="post.wml?sid=${sid}&amp;postId=#{post.id}">分页查看</a><br />
	</#if>
	<#if page &gt; 1>
		续:
	<#else>
		<#if maxPage &gt; 1 && !viewRemain>
			<a href="post.wml?sid=${sid}&amp;postId=#{post.id}&amp;page=1&amp;viewRemain=1">全部(#{maxPage})页</a><br />
		</#if>
	</#if>
	${ubb(content)}<br />
	<#if page &lt; maxPage && !viewRemain>
		<a href="post.wml?sid=${sid}&amp;postId=#{post.id}&amp;page=${page+1}">下页</a>
		<a href="post.wml?sid=${sid}&amp;postId=#{post.id}&amp;page=${page+1}&amp;viewRemain=1">余下全文</a>
		${page}/${maxPage}页
		<br />
	</#if>
	----------<br />
	发帖.<br />
	=最新回复=
	<#if post.mark &lt; 0>
		[抢分${post.mark}]
	</#if>
	<br />
	<#if replies?size==0>
		本帖暂无回复,欢迎您的参与! <br />
	<#else>
		<#assign floor = post.replyCount />
		<#list replies as reply>
			<#if reply.top>[置顶]
			<#else>[#{floor}楼]<#assign floor = (floor - 1) />
			</#if>
			${ubb(reply.content)}(${reply.createTime?datetime})<br />
			作者:<a href="../user/user.wml?sid=${sid}&amp;userId=#{reply.userId}">${wml(reply.userName)}</a><br />
		</#list>
		<a href="reply.wml?sid=${sid}&amp;postId=#{post.id}">回复(#{post.replyCount})条</a> <a href="reply.wml?sid=${sid}&amp;postId=#{post.id}&amp;replyUserId=#{post.userId}">只看楼主</a><br />
	</#if>
	<#if post.lock>
		该帖子已被锁定,你不能参与回复!
	<#elseif post.end>
		该帖子已结束,你不能参与回复!
	<#else>
		=快速回复=<br />
		<a href="addReply.wml?sid=${sid}&amp;postId=#{post.id}$amp;content=hkqy2011">我顶.</a><a href="replyPost.wml?sid=${sid}&amp;postId=#{post.id}$amp;content=hkqy2012">支持.</a><a href="replyPost.wml?sid=${sid}&amp;postId=#{post.id}$amp;content=hkqy2013">我踩.</a>
		<br />
		<input name="content" maxlength="8000"/><br />
		<anchor>快速回复
		<go href="addReply.wml?sid=${sid}&amp;postId=#{post.id}" method='post'>
			<postfield name="content" value="$(content)" />
		</go></anchor>图铃回复<br />
	</#if>
<#else><!-- 帖子不存在的情况 -->
</#if>
<#include "../common/Footer.ftl"/>