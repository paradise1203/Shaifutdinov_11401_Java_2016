<#assign sf=JspTaglibs["http://www.springframework.org/tags/form"]>

<#include "main_template.ftl"/>

<#macro content>
<div class="row">
    <div class="col-lg-12">
        <h1 class="page-header">New request</h1>
    </div>
</div>

<div class="row">
    <div class="col-lg-6">
        <div class="panel panel-default">
            <div class="panel-heading">
                New request
            </div>
            <div class="panel-body">
                <div class="row">
                    <div class="col-lg-8">
                        <@sf.form role="form" action="/requests/create" method="post" modelAttribute="request">
                            <fieldset>
                                <div class="form-group">
                                    <@sf.label path="address">Your location</@sf.label>
                                    <@sf.input path="address" cssClass="form-control" placeholder="Enter your current address" type="text"/>
                                    <@sf.errors path="address" cssClass="help-block"/>
                                </div>
                                <div class="form-group">
                                    <label for="serviceType">Type of service</label>
                                    <select id="serviceType" name="serviceType" class="form-control">
                                        <#list serviceTypes as s>
                                            <option value="${s}">${s.representation}</option>
                                        </#list>
                                    </select>
                                </div>
                                <div class="form-group">
                                    <input class="btn btn-primary" type="submit" value="Help!">
                                </div>
                            </fieldset>
                        </@sf.form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</div>
</#macro>

<@main title="Request"/>