package com.skd.sort;

import java.util.Arrays;

/**
 * @TODO 冒泡排序
 * 
 *       每次比较相邻的两个元素，判断元素是否满足排序关系，若不满足则进行交换；
 *       一次冒泡至少把一个元素移动到它应该在的位置，重复N次，就可以将元素排序完成；
 *       优化：若某次冒泡过程未发生数据交换，则说明元素完全有序，不需要进行排序了；
 * 
 * @Author virgosnail
 * @Date 2018年11月18日
 */
public class BubbleSort
{
	public static void main(String[] args)
	{
		int[] a = CreateArray.create(10, 100);
		
		System.out.println(Arrays.toString(bubbleSort(a)));
//		System.out.println(Arrays.toString(bubbleSortWithFlag(a)));
	}

	public static int[] bubbleSort(int[] a)
	{
		// 判断是否需要排序
		int len = a.length;
		if (len <= 1)
		{
			return a;
		}
		// 开始排序
		for (int i = 0; i < len; i++)
		{
			//  每次把最大的元素放在最后，然后下次该元素不参与比较
			for (int j = 0; j < len - i - 1; j++)
			{
				// 把较大的元素放在后面
				if (a[j] > a[j + 1])
				{
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
			System.out.println("第" + i + "次排序结果： " + Arrays.toString(a));
		}
		
		return a;
	}

	/**
	 * 	添加排序标志位优化
	 */
	public static int[] bubbleSortWithFlag(int[] a)
	{
		// 判断是否需要排序
		int len = a.length;
		if (len < 1)
		{
			return a;
		}

		for (int i = 0; i < len; i++)
		{
			// 此次循环是否有排序操作的标志位
			boolean flag = false;
			for (int j = 0; j < len - i - 1; j++)
			{
				if (a[j] > a[j + 1])
				{
					flag = true;
					int temp = a[j];
					a[j] = a[j + 1];
					a[j + 1] = temp;
				}
			}
			// 若没有排序操作，说明元素已经有序
			if (!flag)
			{
				break;
			}
			System.out.println("第" + i + "次排序结果： " + Arrays.toString(a));
		}
		return a;
	}

}
