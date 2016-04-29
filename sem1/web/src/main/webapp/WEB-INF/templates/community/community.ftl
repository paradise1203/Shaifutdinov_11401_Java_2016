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
                <a href="#" class="subscribe" style="float: right">Subscribe</a>
            </div>
            <div class="panel-body">
                <p class="lead">Name: ${community.name} </p>
                <p class="lead">Description: ${community.description}</p>
                <p class="lead">Founded by ${community.founder.name} ${community.founder.surname}</p>
                <p class="lead">Created at: ${community.createdAt}</p>
            </div>
        </div>
    </div>
</div>
</#macro>

<@main title="Request info" scripts=["/resources/custom/community.js"]/>