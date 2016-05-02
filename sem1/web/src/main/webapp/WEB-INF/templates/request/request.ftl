<#assign sec=JspTaglibs["http://www.springframework.org/security/tags"]>

<#include "../main_template.ftl"/>

<#macro content>
    <div class="row">
        <div class="col-lg-12">
            <h1 class="page-header">Request info</h1>
        </div>
    </div>

    <div class="row">
        <div class="col-lg-10">
            <div class="panel panel-info">
                <div class="panel-heading">
                    Request info
                    <input id="request" type="text" style="display: none" value="${request.id}">
                </div>
                <div class="panel-body">
                    <p class="lead">Needy: ${request.needy.name} ${request.needy.surname}</p>
                    <p class="lead">Address: ${request.address}</p>
                    <p class="lead">Created at: ${request.createdAt}</p>
                    <p class="lead">Type of service: ${request.serviceType.representation}</p>
                    <p class="lead">Status: ${request.status}</p>
                    <p class="lead">Volunteer:
                        <#if request.volunteer??>
                            ${request.volunteer.name} ${request.volunteer.surname}
                        <#else>
                            No yet
                        </#if>
                    </p>
                    <p class="lead">Show path:</p>
                    <div class="form-group">
                        <input type="text" class="address form-control" placeholder="Enter your address">
                    </div>
                    <div class="form-group">
                        <button type="button" class="path btn btn-primary btn-outline">Show path</button>
                    </div>

                    <#-- Needy location to display on Google map view -->
                    <input id="latitude" type="text" style="display: none" value="${request.latitude}">
                    <input id="longitude" type="text" style="display: none" value="${request.longitude}">
                    <#-- Google map view -->
                    <div id="map" style="width: 100%; height: 400px;"></div>

                    <p class="lead">Comments:</p>
                    <ul class="comments">
                        <#list request.comments as comment>
                            <li>
                                ${comment.text} by ${comment.author.name} ${comment.author.surname}
                                    at ${comment.createdAt}
                            </li>
                        </#list>
                    </ul>
                    <#if principal.id == request.needy.id || request.volunteer?? && principal.id == request.volunteer.id>
                        <p class="lead">Add new comment on this request:</p>
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
    <script src="https://maps.googleapis.com/maps/api/js?key=AIzaSyA7rnCajr0BEK6i-H2G6twiYW_2hJPchOc&callback=initMap"
        async defer></script>
</#macro>

<@main title="Request info" scripts=["/resources/custom/request.js"]/>