package com.skd.sort;

import java.util.Arrays;

/**
 * @TODO 计数排序
 * 
 * @Author virgosnail
 * @Date 2018年11月15日
 */
public class CountSort
{
	public static void main(String[] args)
	{
		int[] a = CreateArray.create(15, 100);
		System.out.println(Arrays.toString(countSort2(a)));
	}

	/**
	 * @TODO 简书：https://www.jianshu.com/p/e6ba35133375
	 * 		  注释是自己写的
	 */
	public static int[] countSort(int[] a)
	{
		// 找到数组中最大的值
		int max = 0;
		for (int i = 0; i < a.length; i++)
		{
			if (a[i] > max)
			{
				max = a[i];
			}
		}
		// 创建一个 max+1 长度的数组
		int[] b = new int[max + 1];
		// b中指定下标i的值等于value，代表a中有value个i;
		// 假设a中有3个5，在b[5]=3；a中有1个2，在b[2]=1；
		for (int i = 0; i < a.length; i++)
		{
			b[a[i]]++;
		}

		int index = 0;
		// b[i]等于多少，a中就有多少个i
		// 从b的头部开始遍历
		// a中的元素将从小到大排序
		for (int i = 0; i < b.length; i++)
		{
			//
			while ((b[i]--) > 0)
			{
				a[index++] = i;
			}
		}

		return a;
	}

	/**
	 * @TODO 极客时间王铮老师的demo
	 * 		  注释是自己写的
	 */
	public static int[] countSort2(int[] a)
	{
		// 找到数组中最大的值
		int max = 0;
		for (int i = 0; i < a.length; i++)
		{
			if (a[i] > max)
			{
				max = a[i];
			}
		}
		// 创建一个 max+1 长度的数组
		int[] b = new int[max + 1];
		// b中指定下标i的值等于value，代表a中有value个i;
		// 假设a中有3个5，在b[5]=3；a中有1个2，在b[2]=1；
		for (int i = 0; i < a.length; i++)
		{
			b[a[i]]++;
		}
		// 依次累加，每个下标的值表示它自己和它之前总共还有多少个元素
		for (int i = 1; i < b.length; i++)
		{
			b[i] =b[i-1] + b[i];
		}
		// 临时数组,存储排序后的结果
		int[] c = new int[a.length];
		// 从后往前遍历时是稳定排序
		for (int i= (c.length-1); i >=0; i--)
		{
			/* a = 3 3 3 2 2 1
			 * b = 0 1 3 6
			 * i = 5
			 * index = 0
			 * c[0] = 1
			 * b = 0 0 3 6 
			 * 按照这个例子在本子上画一下就明白了
			 */
			// b[a[i]]表示 a[i] 和 a[i] 之前元素的总个数
			// 将b中下标为a[i]的值存储到临时数组c,然后它的个数减一
			int index = b[a[i]]-1;
			c[index] = a[i];
			b[a[i]]--;
		}
		
		for (int i = 0; i < c.length; i++)
		{
			a[i] = c[i];
		}
		
		return a;
	}

}
