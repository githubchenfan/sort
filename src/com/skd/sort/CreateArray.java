package com.skd.sort;

import java.util.Random;

public class CreateArray
{
	public static int[] create(int len, int random){
		
		int[] a = new int[len];
		for (int i = 0; i < a.length; i++)
		{
			a[i] = new Random().nextInt(random);
		}
		return a;
	}

}
