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
                <input id="community" type="text" style="display: none" value="${community.id}">
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

                <#if membership>
                    <p class="lead">News:</p>
                    <ul class="news">
                        <#list news as n>
                            <li>${n.text} by ${n.author.name} ${n.author.surname} at ${n.createdAt}</li>
                        </#list>
                    </ul>
                    <p class="lead">Add news:</p>
                    <div class="form-group">
                        <label>Text:</label>
                        <textarea name="text" class="text form-control" rows="3" cols="30"></textarea>
                    </div>
                    <div class="form-group">
                        <button type="button" class="send btn btn-primary btn-outline">Send news</button>
                    </div>
                </#if>
            </div>
        </div>
    </div>
</div>
</#macro>

<@main title="Request info" scripts=["/resources/custom/community.js"]/>