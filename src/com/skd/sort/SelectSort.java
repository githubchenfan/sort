package com.skd.sort;

import java.util.Arrays;

/**
 * @TODO 选择排序
 * 
 *       将数组分为两个区间，一个有序区间，一个无序区间。开始默认数组为无序区间；
 *       从无序区间取最小的一个元素，将最小的元素与无序区间的第一个元素交换位置，即插入有序区间的末尾； 
 *       重复这个过程，直到无序区间没有元素；
 * 
 * @Author virgosnail
 * @Date 2018年11月18日
 */
public class SelectSort
{
	public static void main(String[] args)
	{
		int[] a = CreateArray.create(10, 100);
		System.out.println("排序前：" + Arrays.toString(a));
		System.out.println("排序后：" + Arrays.toString(selectSort(a)));
	}

	public static int[] selectSort(int[] a)
	{
		// 判断是否需要排序
		if (a.length <= 1)
		{
			return a;
		}
		// 开始排序
		for (int i = 0; i < a.length; i++)
		{
			// 最小元素，第一次取无序区间的第一个元素
			int temp = a[i];
			// 最小元素的位置
			int min = i;
			// 
			for (int j = i + 1; j < a.length; j++)
			{
				
				if (temp > a[j])
				{
					// 将较小的元素赋给temp
					temp = a[j];
					// 保存最小元素的下标位置
					min = j;
				}
			}
			// 将最小元素放到最前面
			a[min] = a[i];
			a[i] = temp;
			System.out.println("第" + i + "次排序的结果 :" + Arrays.toString(a));
		}

		return a;
	}
}
