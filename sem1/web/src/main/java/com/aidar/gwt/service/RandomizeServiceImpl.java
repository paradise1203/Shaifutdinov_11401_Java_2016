package com.aidar.gwt.service;

import com.aidar.gwt.client.RandomizeService;

import java.util.Random;

public class RandomizeServiceImpl implements RandomizeService
{

	@Override
	public Integer getRandomNumber()
	{
		Random rand = new Random();
		return rand.nextInt();
	}

}
