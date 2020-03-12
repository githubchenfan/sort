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
		int[] a = CreateArray.create(5, 10);
//		int[] a = new int[]{7, 42, 43, 42, 18};
		System.out.println("before sort: " + Arrays.toString(a));

		quickSort(a, 0, a.length - 1);
		System.out.println("after sort: " + Arrays.toString(a));
	}

	/**
	 *
	 * @param a 数组对象
	 * @param q 数组需要排序区间的开始位置
	 * @param p 数组需要排序区间的结束位置
	 */
	public static void quickSort(int[] a, int q, int p)
	{
		if (q >= p)
		{
			return;
		}
		/**
		 * 将数组分为两部分，index之前的元素都小于a[index]，index之后的元素都大于等于a[index]；
		 * 后面递归处理这两部分，index位置的元素已经确定，后续不再操作a[index]元素
		 **/
		int index = findPivotIndex(a, q, p);
		quickSort(a, q, index-1);
		quickSort(a, index + 1, p);
	}

	/**
	 *  以游标 i 将 a[q,p] 分为两部分，a[q,i-1] 的元素都是小于分界元素的，称为已处理区间，a[i,p] 的元素为未处理区间；
	 *  遍历处理未处理区间的元素；
	 *  每次从未处理区间取出一个元素，如果该元素小于分界元素，则将该元素交换到已处理元素区间的末尾，即 a[i] 位置；即将当前元素和 a[i] 元素互换位置；
	 *  最后将分界元素和未处理区间的第一个元素交换位置
	 * @param a 需要排序的数组对象
	 * @param q 需要排序的数组区间的开始位置
	 * @param p 需要排序的数组区间的结束位置
	 * @return 有序区间的下一个位置下标
	 */
	private static int findPivotIndex(int[] a, int q, int p)
	{
		// 取最后一个元素为分界元素
		int pivot = a[p];

		int i = q;
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
		/**
		 * 将分界元素交换，此时分界元素的位置就已经确定；
		 * 后续的递归处理就不再操作该位置的分界元素，此时该元素已经有序，
		 * 前面的元素都小于它，后面的元素都大于等于它
		 **/
		a[p] = a[i];
		a[i] = pivot;
		return i;
	}

}
