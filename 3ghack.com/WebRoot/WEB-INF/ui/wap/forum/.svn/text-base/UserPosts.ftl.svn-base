<#assign pageTitle="${name}发表的帖子"/>
<#include "../common/Header.ftl"/>
<#include "../common/MesssgeNotification.ftl"/>
<strong>==发表的帖子==</strong> 
<br/>
<#if posts??>
	<#assign floor = page * 15 + 1 />
	<#list posts as post>
		#{floor}.<a href="post.wml?sid=${sid}&amp;postId=#{post.id}">${wml(width(post.title, 24))}</a><br />
		<#assign floor = floor + 1>
	</#list>
	<#if page != 0>
		<a href="?sid=${sid}&amp;name=${name}&amp;postAmount=${postAmount}&amp;page=${page-1}">上一页</a>
	</#if>
	<#if postAmount &gt; 15>
		<a href="?sid=${sid}&amp;name=${name}&amp;postAmount=${postAmount}&amp;page=${page+1}">上一页</a>
	</#if>
</#if>
<#include "../common/Footer.ftl"/>