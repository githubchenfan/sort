package com.skd.sort;

import java.util.Arrays;

/**
 * @TODO 插入排序
 * 
 *       将数组分为两个区间，一个有序区间，一个无序区间。开始默认第一个元素为有序区间； 
 *       从无序区间取一个元素，在有序区间找到合适的位置将其插入；
 *       重复这个过程，直到无序区间没有元素；
 * 
 * @Author virgosnail
 * @Date 2018年11月18日
 */
public class InsertSort
{
	public static void main(String[] args)
	{
		int[] a = CreateArray.create(10, 100);
		System.out.println("排序前：" + Arrays.toString(a));
		System.out.println("排序后：" + Arrays.toString(insertSort(a)));
	}

	public static int[] insertSort(int[] a)
	{
		// 判断是否需要排序
		if (a.length <= 1)
		{
			return a;
		}
		// 开始排序，从第二个元素开始
		for (int i = 1; i < a.length; i++)
		{
			// 保存插入的那个元素，后面排序时有序元素可能会依次后移，占用插入元素的位置
			int temp = a[i];
			// 有序元素的最后一个元素的下标
			int j = i - 1;
			/*
			 * 在有序区间从后往前寻找合适的插入位置
			 * 插入元素<有序区间的元素，有序元素后移一位
			 * 否则当前有序元素的下一位就是要插入的位置
			 *  1 2 5 3 4
			 */
			for (; j >= 0; j--)
			{
				if (temp < a[j])
				{
					a[j + 1] = a[j];
				} else
				{
					break;
				}
			}
			// 插入当前有序元素的下一位
			a[j + 1] = temp;
			System.out.println("第" + i + "次排序的结果：" + Arrays.toString(a));
		}

		return a;
	}

}
