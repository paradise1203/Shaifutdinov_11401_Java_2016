package com.aidar.gwt.client;

import com.google.gwt.user.client.rpc.RemoteService;
import com.google.gwt.user.client.rpc.RemoteServiceRelativePath;

@RemoteServiceRelativePath("rpc/randomize")
public interface RandomizeService extends RemoteService
{
	Integer getRandomNumber();
}
