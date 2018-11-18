package com.skd.sort;

import java.util.Arrays;

/**
 * @TODO 归并排序
 * 
 *       采用分治思想，一般用递归实现 将一个无序数组从中间分成两个无序数组，然后对两个无序数组排序，
 *       排序之后再将两个有序数组合并为一个有序数组；
 * 
 * @Author virgosnail
 * @Date 2018年11月18日
 */
public class MergeSort
{
	public static void main(String[] args)
	{
		int[] a = CreateArray.create(10, 100);
		System.out.println("排序前：" + Arrays.toString(a));
		System.out.println("排序后：" + Arrays.toString(mergeSort(a,0, a.length-1)));
	}

	private static int[] mergeSort(int[] a, int start, int end)
	{
		// 终止条件
		if (start >= end) {
			return null;
		}
		//  把数组分为两个小数组ֵ
		int mid = start + (end - start) / 2;
		// 两个小数组继续排序
		mergeSort(a, start, mid);
		mergeSort(a, mid + 1, end);

		// 合并两个小数组
		merge(a, start, mid, end);
		return a;
	}

	private static void merge(int[] a, int p, int q, int r)
	{
		// 第一个数组的起始位置
		int i = p;
		// 第二个数组的起始位置
		int j = q + 1;
		int k = 0; 
		// 临时存放排序完的数组
		int[] tmp = new int[r - p + 1]; 
		// 当两个数组里面的元素都没排序完成时才继续
		// 即有一个数组的元素排序完成就可以停止
		while (i <= q && j <= r)
		{
			// 优先将第一个数组的元素排在前面，实现稳定排序
			if (a[i] <= a[j])
			{
				tmp[k++] = a[i++];
			} else
			{
				tmp[k++] = a[j++];
			}

			// 当有一个数组的所有元素排序完成后，就把剩下那个数组的剩余元素全部追加到临时数组后
			if (i == (q + 1))
			{
				while (j <= r)
				{
					tmp[k++] = a[j++];
				}
			}

			if (j == (r + 1))
			{
				while (i <= q)
				{
					tmp[k++] = a[i++];
				}
			}

		}

		// 将数组拷贝到原数组，空间复杂度O(n)
		for (i = 0; i <= r - p; ++i)
		{
			a[p + i] = tmp[i];
		}
	}

}