<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"]>

<#include "../main_template.ftl"/>

<#macro content>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">Request info</h1>
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
                <p class="lead">Volunteer:
                    <#if request.volunteer??>
                        ${request.volunteer.name} ${request.volunteer.surname}
                    <#else>
                        No yet
                    </#if>
                </p>
                <p class="lead">Comments:</p>
                <ul>
                    <#list request.comments as comment>
                        <li>
                            ${comment.text} by ${comment.author.name} ${comment.author.surname}
                                at ${comment.createdAt}
                        </li>
                    </#list>
                </ul>
                <#if principal.id == request.needy.id || request.volunteer?? && principal.id == request.volunteer.id>
                    <p class="lead">Add new comment on this request:</p>
                    <form role="form" action="/requests/${request.id}/comments/create" method="post">
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
</div>
</#macro>

<@main title="Request info"/>