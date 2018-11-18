package com.skd.sort;

import java.util.Arrays;

/**
 * @TODO 快速排序
 * 
 *       在数组中找一个分界元素，将数组分为两个区间，小于分界元素的全部放在分界元素之前，其他的放在分界元素之后；
 *       在分出来的两个区间（不包括分界元素）重复上述过程，直到区间缩小为1；
 * 
 * @Author virgosnail
 * @Date 2018年11月18日
 */
public class QuickSort
{
	public static void main(String[] args)
	{
		int[] a = CreateArray.create(10, 100);
		System.out.println(Arrays.toString(a));

		quickSort(a, 0, a.length - 1);
		System.out.println(Arrays.toString(a));
	}

	public static void quickSort(int[] a, int q, int p)
	{
		// 终止条件
		if (q >= p)
		{
			return;
		}
		// 把小于分界元素的放在分界元素之前，把大于分界元素的放在分界元素之后
		int index = findPivotIndex(a, q, p);
		quickSort(a, q, index - 1);
		quickSort(a, index + 1, p);
	}

	/*
	 * 在一个无序数组中，取数组的最后一个元素为分界元素。 把小于分界元素的放在分界元素之前，剩下的就是大于分界元素的元素
	 * 遍历该数组（遍历到倒数第二个元素，最后一个元素是分界元素自己），
	 * 第一次遇到比分界元素小的元素时，将该元素与数组的第一个元素交换位置； 
	 * 第二次遇到比分界元素小的元素时，将该元素与数组的第二个元素交换位置；
	 * 遍历完成后将分界元素 与 上一次较小元素的下一个元素 交换位置
	 */
	private static int findPivotIndex(int[] a, int q, int p)
	{
		// 取最后一个元素为分界元素
		int pivot = a[p];
		// 下一个小于分界元素的存储位置
		int i = q;
		// 1 3 7 9 5 
		for (int j = q; j < p; j++)
		{
			if (a[j] < pivot)
			{
				int temp = a[i];
				a[i] = a[j];
				a[j] = temp;
				i++;
			}
		}
		// 将分界元素放到合适的位置
		a[p] = a[i];
		a[i] = pivot;
		return i;
	}

}
