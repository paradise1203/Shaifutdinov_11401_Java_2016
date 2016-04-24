<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"]>

<#include "main_template.ftl"/>

<#macro content>
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Requests</h1>
        </div>
    </div>

    <div class="row">
        <div class="col-lg-12">
            <div class="panel panel-default">
                <div class="panel-heading">
                    Requests
                </div>
                <div class="panel-body">
                    <@sec.authorize access="hasRole('ROLE_ADMIN')">
                    <div class="dataTable_wrapper">
                        <table class="table table-striped table-bordered table-hover" id="dataTables-example">
                            <thead>
                                <tr>
                                    <th>Needy</th>
                                    <th>Address</th>
                                    <th>Created at</th>
                                    <th>Type of service</th>
                                    <th>Status</th>
                                </tr>
                            </thead>
                            <tbody>
                                <#list requests as request>
                                    <tr>
                                        <td>${request.needy.name} ${request.needy.surname}</td>
                                        <td>${request.address}</td>
                                        <td>${request.createdAt}</td>
                                        <td>${request.serviceType.representation}</td>
                                        <td>${request.status}</td>
                                    </tr>
                                </#list>
                            </tbody>
                        </table>
                    </div>
                    </@sec.authorize>
                    <@sec.authorize access="hasRole('ROLE_USER')">
                        <ul class="nav nav-tabs">
                            <li>
                                <a id="all" href="#">All</a>
                            </li>
                            <li>
                                <a id="my" href="#">My</a>
                            </li>
                            <li>
                                <a id="pending" href="#">Pending</a>
                            </li>
                        </ul><br>

                        <div class="tab-content">
                            Choose filtering
                        </div>
                    </@sec.authorize>
                </div>
            </div>
        </div>
    </div>
</#macro>

<@main title="Requests"
       styles=["/resources/landing/bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.css"]
       scripts=["//cdn.datatables.net/1.10.11/js/jquery.dataTables.min.js",
                "/resources/landing/bower_components/datatables-plugins/integration/bootstrap/3/dataTables.bootstrap.min.js",
                "/resources/custom/requests.js"]
/>