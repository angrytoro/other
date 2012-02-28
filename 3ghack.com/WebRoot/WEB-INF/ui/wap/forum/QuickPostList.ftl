<#assign CATALOG_NEW = 0 /><#t/>
<#assign CATALOG_HOT = 1 /><#t/>
<#assign CATALOG_WELL = 2 /><#t/>
<#assign CATALOG_RECOMMEND = 3 /><#t/>
<#assign CATALOG_MARK = 4 /><#t/>
<#if catalog = CATALOG_NEW>
	<#assign pageTitle="查看新帖" />
<#elseif catalog = CATALOG_HOT>
	<#assign pageTitle="查看热帖" />
<#elseif catalog = CATALOG_WELL>
	<#assign pageTitle="查看精帖" />
<#elseif catalog = CATALOG_RECOMMEND>
	<#assign pageTitle="查看荐帖" />
<#elseif catalog = CATALOG_MARK>
	<#assign pageTitle="查看赏分帖" />
</#if>
<#include "../common/Header.ftl"/>
<#include "../common/MesssgeNotification.ftl"/>
<#if catalog = CATALOG_NEW>新帖<#else><a href="viewNewPost.wml?sid=${sid}">新帖</a></#if>
<#if catalog = CATALOG_HOT>热帖<#else><a href="viewHotPost.wml?sid=${sid}">热帖</a></#if>
<#if catalog = CATALOG_WELL>精帖<#else><a href="viewWellPost.wml?sid=${sid}">精帖</a></#if>
<#if catalog = CATALOG_RECOMMEND>荐帖<#else><a href="viewRcmPost.wml?sid=${sid}">荐帖</a></#if>
<#if catalog = CATALOG_MARK>赏分<#else><a href="viewMarkPost.wml?sid=${sid}">赏分</a></#if>
<br />
----------<br />
<#assign floor = (page-1) * 15 + 1 />
<#list posts as post>
#{floor}.<a href="post.wml?sid=${sid}&amp;postId=#{post.id}">${wml(width(post.title, 24))}</a><br />
<#assign floor = (floor + 1) />
</#list>
<#if page &lt; maxPage>
	<a href="?sid=${sid}&amp;page=${page+1}">下一页</a>
</#if>
<#if page != 1>
	<a href="?sid=${sid}&amp;page=${page-1}">上一页</a>
</#if>
<br />
[${page}/${maxPage}页150帖]<input name="page" type="text" size="2" format="*N"/><a href="?sid=${sid}&amp;page=$(page)">页</a><br />
----------<br />
<#include "../common/Footer.ftl"/>