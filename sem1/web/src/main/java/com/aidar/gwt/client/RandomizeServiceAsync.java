package com.aidar.gwt.client;

import com.google.gwt.user.client.rpc.AsyncCallback;

public interface RandomizeServiceAsync
{
	void getRandomNumber(AsyncCallback<Integer> callback);
}
