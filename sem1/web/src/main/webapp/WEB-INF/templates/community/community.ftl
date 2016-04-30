<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"]>

<#include "../main_template.ftl"/>

<#macro content>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Community info</h1>
    </div>
</div>

<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-success">
            <div class="panel-heading">
                Community info
                <p class="community_id" style="display: none;">${community.id}</p>
                <#if membership>
                    <a href="#" class="unsubscribe" style="float: right">Unsubscribe</a>
                <#else>
                    <a href="#" class="subscribe" style="float: right">Subscribe</a>
                </#if>
            </div>
            <div class="panel-body">
                <p class="lead">Name: ${community.name} </p>
                <p class="lead">Description: ${community.description}</p>
                <p class="lead">Founded by ${community.founder.name} ${community.founder.surname}</p>
                <p class="lead">Created at: ${community.createdAt}</p>
            </div>
            <#if membership>
                <p class="lead">News</p>
                <ul>
                    <#list news as n>
                        <li>${n.text} by ${n.author.name} ${n.author.surname} at ${n.createdAt}</li>
                    </#list>
                </ul>
                <p class="lead">Add news:</p>
                <form role="form" action="/communities/${community.id}/news/create" method="post">
                    <div class="form-group">
                        <label>Text:
                            <textarea name="text" class="form-control" rows="3" cols="30"></textarea>
                        </label>
                    </div>
                    <div class="form-group">
                        <input class="btn btn-primary" type="submit" value="Add">
                    </div>
                </form>
            </#if>
        </div>
    </div>
</div>
</#macro>

<@main title="Request info" scripts=["/resources/custom/community.js"]/>