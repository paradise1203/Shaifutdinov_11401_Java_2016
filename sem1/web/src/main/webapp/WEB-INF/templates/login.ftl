<#include "main_template.ftl"/>

<#macro content>
    <div class="container">
        <div class="row">
            <div class="col-md-4 col-md-offset-4">
                <div class="login-panel panel panel-default">
                    <div class="panel-heading">
                        <h3 class="panel-title">Please Sign In</h3>
                    </div>
                    <div class="panel-body">
                        <form role="form" action="/login/process" method="POST">
                            <fieldset>
                                <div class="form-group">
                                    <input class="form-control" placeholder="E-mail" name="email" type="email" autofocus>
                                </div>
                                <div class="form-group">
                                    <input class="form-control" placeholder="Password" name="password" type="password" value="">
                                </div>
                                <#--<div class="checkbox">-->
                                    <#--<label>-->
                                        <#--<input name="rem" type="checkbox" value="Remember Me">Remember Me-->
                                    <#--</label>-->
                                <#--</div>-->
                                <div class="form-group">
                                    <input class="btn btn-lg btn-success btn-block" type="submit" value="Sign in">
                                </div>
                            </fieldset>
                        </form>
                    </div>
                </div>
            </div>
        </div>
    </div>
</#macro>

<@main title="Sign in"/>