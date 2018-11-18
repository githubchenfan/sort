package com.skd.sort;

import java.util.Arrays;

/**
 * @TODO 基数排序
 * 
 * 从低位到高位排序，而且每一位的排序算法必须是稳定的，
 * 否则高位排序时不考虑低位排序，低位排序就没有意义了。
 * 
 * @Author virgosnail
 * @Date 2018年11月15日
 */
public class CardinalitySort
{
	public static void main(String[] args)
	{
		int[] a  = new int[]{132,145,125,147,258,369,951};
		System.out.println(Arrays.toString(cardinalitySort(a)));
	}

	public static int[] cardinalitySort(int[] a)
	{
		int max = 0;
		for (int i = 0; i < a.length; i++)
		{
			if (a[i]>max)
			{
				max = a[i];
			}
		}
		
		for (int i = 1; max/i >0; i*=10)
		{
			bitSort(a,i);
		}

		return a;
	}


	/**
	 * @TODO  位排序参考计数排序
	 * @param a
	 * @param exp
	
	 * @Author virgosnail
	 * @Date 2018年11月18日
	 */
	private static void bitSort(int[] a, int exp)
	{
		int[] temp = new int[a.length];
		int[] bucket = new int[10];
		
		for (int i = 0; i < a.length; i++)
		{
			bucket[(a[i]/exp)%10]++;
		}
		
		for (int i = 1; i < bucket.length; i++)
		{
			bucket[i] = bucket[i-1]+bucket[i];
			System.out.println(Arrays.toString(bucket));
		}
		
		for (int i = (a.length-1); i >= 0; i--)
		{
			temp[bucket[ (a[i]/exp)%10 ] - 1] = a[i];
			bucket[ (a[i]/exp)%10 ]--;
			
		}
		
		for (int i = 0; i < a.length; i++)
		{
			a[i] = temp[i];
		}
		
	}
}
