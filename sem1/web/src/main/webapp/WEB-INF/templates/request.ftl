<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"]>

<#include "main_template.ftl"/>

<#macro content>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Requests info</h1>
    </div>
</div>

<div class="row">
    <div class="col-lg-12">
        <div class="panel panel-success">
            <div class="panel-heading">
                Request info
            </div>
            <div class="panel-body">
                <p class="lead">Needy: ${request.needy.name} ${request.needy.surname}</p>
                <p class="lead">Address: ${request.address}</p>
                <p class="lead">Created at: ${request.createdAt}</p>
                <p class="lead">Type of service: ${request.serviceType}</p>
                <p class="lead">Status: ${request.status}</p>
                <p class="lead">Volunteer: ${request.volunteer.name} ${request.volunteer.surname}</p>
            </div>
        </div>
    </div>
</div>
</#macro>

<@main title="Request info"/>