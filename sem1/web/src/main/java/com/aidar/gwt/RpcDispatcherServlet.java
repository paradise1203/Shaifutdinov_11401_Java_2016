package com.aidar.gwt;

import com.google.gwt.user.client.rpc.IncompatibleRemoteServiceException;
import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.SerializationException;
import com.google.gwt.user.server.rpc.RPC;
import com.google.gwt.user.server.rpc.RPCRequest;
import com.google.gwt.user.server.rpc.RemoteServiceServlet;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.web.util.UrlPathHelper;

import javax.servlet.http.HttpServletRequest;
import java.util.Map;

/**
 * Created by paradise on 11.05.16.
 */
@Component
public class RpcDispatcherServlet extends RemoteServiceServlet {

    private static final UrlPathHelper pathHelper = new UrlPathHelper();

    @Autowired
    private Map<String, RemoteService> springRPCServices;

    @Override
    public String processCall(String payload) throws SerializationException {
        try {
            RemoteService handler = retrieveSpringBean(getThreadLocalRequest());
            RPCRequest rpcRequest = RPC.decodeRequest(payload, handler.getClass(), this);
            onAfterRequestDeserialized(rpcRequest);
            return RPC.invokeAndEncodeResponse(
                    handler, rpcRequest.getMethod(), rpcRequest.getParameters(), rpcRequest.getSerializationPolicy());
        } catch (IncompatibleRemoteServiceException e) {
            return RPC.encodeResponseForFailure(null, e);
        }
    }

    protected RemoteService retrieveSpringBean(HttpServletRequest request) {
        String serviceURL = pathHelper.getPathWithinServletMapping(request);
        return springRPCServices.get(serviceURL);
    }

}
