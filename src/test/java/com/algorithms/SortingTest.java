package com.algorithms;

import static com.tasks.sorting.Sorting.bsInsertionSort;
import static com.tasks.sorting.Sorting.bubbleSort;
import static com.tasks.sorting.Sorting.countingSort;
import static com.tasks.sorting.Sorting.findInsertPositionBS;
import static com.tasks.sorting.Sorting.merge;
import static com.tasks.sorting.Sorting.mergeSort;
import static com.tasks.sorting.Sorting.quickSort;
import static com.tasks.sorting.Sorting.selectionSort;
import static com.tasks.sorting.Sorting.vanillaInsertionSort;

import org.junit.Assert;
import org.junit.Test;

import com.tasks.sorting.Sorting;


/**
 * Test cases for {@link Sorting} class functionality.
 * 
 * @author Polina Koleva
 *
 */
public class SortingTest {

	@Test
	public void vanillaInsertionSortTest() {
		int[] arr = { 1, 7, 3, 5 };
		int[] expArr = { 1, 3, 5, 7 };
		vanillaInsertionSort(arr);
		Assert.assertArrayEquals(expArr, arr);

		arr = new int[] { 2, 3, 4, 5, 6 };
		expArr = new int[] { 2, 3, 4, 5, 6 };
		vanillaInsertionSort(arr);
		Assert.assertArrayEquals(expArr, arr);

		arr = new int[] { 6, 5, 4, 3, 2, 1 };
		expArr = new int[] { 1, 2, 3, 4, 5, 6 };
		vanillaInsertionSort(arr);
		Assert.assertArrayEquals(expArr, arr);

		arr = new int[] { 2, 1 };
		expArr = new int[] { 1, 2 };
		vanillaInsertionSort(arr);
		Assert.assertArrayEquals(expArr, arr);

		arr = new int[] { 1, 3, 1 };
		expArr = new int[] { 1, 1, 3 };
		vanillaInsertionSort(arr);
		Assert.assertArrayEquals(expArr, arr);
	}

	@Test
	public void mergeTest() {
		int[] left = { 1, 3, 4, 5 };
		int[] right = { 1, 2, 5, 7 };
		int[] expArr = { 1, 1, 2, 3, 4, 5, 5, 7 };
		Assert.assertArrayEquals(expArr, merge(left, right));

		// single elements in the arrays
		left = new int[] { 1 };
		right = new int[] { 113 };
		expArr = new int[] { 1, 113 };
		Assert.assertArrayEquals(expArr, merge(left, right));

		// duplicates
		left = new int[] { 1 };
		right = new int[] { 1 };
		expArr = new int[] { 1, 1 };
		Assert.assertArrayEquals(expArr, merge(left, right));

		// two consecutive arrays
		left = new int[] { 5, 6, 7, 8, 9 };
		right = new int[] { 1, 2, 3, 4, 5 };
		expArr = new int[] { 1, 2, 3, 4, 5, 5, 6, 7, 8, 9 };
		Assert.assertArrayEquals(expArr, merge(left, right));

		// one empty array
		left = new int[] {};
		right = new int[] { 1 };
		expArr = new int[] { 1 };
		Assert.assertArrayEquals(expArr, merge(left, right));

		// empty arrays
		left = new int[] {};
		right = new int[] {};
		expArr = new int[] {};
		Assert.assertArrayEquals(expArr, merge(left, right));
	}
	
	@Test
	public void mergeSortTest() {
		int[] arr = { 1, 7, 3, 5 };
		int[] expArr = { 1, 3, 5, 7 };
		Assert.assertArrayEquals(expArr, mergeSort(arr, 0, arr.length - 1));

		arr = new int[] { 2, 3, 4, 5, 6 };
		expArr = new int[] { 2, 3, 4, 5, 6 };
		Assert.assertArrayEquals(expArr, mergeSort(arr, 0, arr.length - 1));

		arr = new int[] { 6, 5, 4, 3, 2, 1 };
		expArr = new int[] { 1, 2, 3, 4, 5, 6 };
		Assert.assertArrayEquals(expArr, mergeSort(arr, 0, arr.length - 1));

		arr = new int[] { 2, 1 };
		expArr = new int[] { 1, 2 };
		Assert.assertArrayEquals(expArr, mergeSort(arr, 0, arr.length - 1));

		arr = new int[] { 1, 3, 1 };
		expArr = new int[] { 1, 1, 3 };
		Assert.assertArrayEquals(expArr, mergeSort(arr, 0, arr.length - 1));
	}

	
	@Test
	public void bubleSortTest() {
		int[] arr = { 1, 7, 3, 5 };
		int[] expArr = { 1, 3, 5, 7 };
		Assert.assertArrayEquals(expArr, bubbleSort(arr));

		arr = new int[] { 2, 3, 4, 5, 6 };
		expArr = new int[] { 2, 3, 4, 5, 6 };
		Assert.assertArrayEquals(expArr, bubbleSort(arr));

		arr = new int[] { 6, 5, 4, 3, 2, 1 };
		expArr = new int[] { 1, 2, 3, 4, 5, 6 };
		Assert.assertArrayEquals(expArr, bubbleSort(arr));

		arr = new int[] { 2, 1 };
		expArr = new int[] { 1, 2 };
		Assert.assertArrayEquals(expArr, bubbleSort(arr));

		arr = new int[] { 1, 3, 1 };
		expArr = new int[] { 1, 1, 3 };
		Assert.assertArrayEquals(expArr, bubbleSort(arr));
	}
	
	@Test
	public void quickSortTest() {
		int[] arr = { 1, 7, 3, 5 };
		int[] expArr = { 1, 3, 5, 7 };
		quickSort(arr, 0 , arr.length - 1);
		Assert.assertArrayEquals(expArr, arr);

		arr = new int[] { 2, 3, 4, 5, 6 };
		expArr = new int[] { 2, 3, 4, 5, 6 };
		quickSort(arr, 0 , arr.length - 1);
		Assert.assertArrayEquals(expArr, arr);

		arr = new int[] { 6, 5, 4, 3, 2, 1 };
		expArr = new int[] { 1, 2, 3, 4, 5, 6 };
		quickSort(arr, 0 , arr.length - 1);
		Assert.assertArrayEquals(expArr, arr);

		arr = new int[] { 2, 1 };
		expArr = new int[] { 1, 2 };
		quickSort(arr, 0 , arr.length - 1);
		Assert.assertArrayEquals(expArr, arr);

		arr = new int[] { 1, 3, 1 };
		expArr = new int[] { 1, 1, 3 };
		quickSort(arr, 0 , arr.length - 1);
		Assert.assertArrayEquals(expArr, arr);
	}
	
	
	@Test
	public void selectionSortTest() {
		int[] arr = { 1, 7, 3, 5 };
		int[] expArr = { 1, 3, 5, 7 };
		selectionSort(arr);
		Assert.assertArrayEquals(expArr, arr);

		arr = new int[] { 2, 3, 4, 5, 6 };
		expArr = new int[] { 2, 3, 4, 5, 6 };
		selectionSort(arr);
		Assert.assertArrayEquals(expArr, arr);

		arr = new int[] { 6, 5, 4, 3, 2, 1 };
		expArr = new int[] { 1, 2, 3, 4, 5, 6 };
		selectionSort(arr);
		Assert.assertArrayEquals(expArr, arr);

		arr = new int[] { 2, 1 };
		expArr = new int[] { 1, 2 };
		selectionSort(arr);
		Assert.assertArrayEquals(expArr, arr);

		arr = new int[] { 1, 3, 1 };
		expArr = new int[] { 1, 1, 3 };
		selectionSort(arr);
		Assert.assertArrayEquals(expArr, arr);
	}
	
	@Test
	public void findInsertPositionBSTest() {
		int[] arr = { 1, 3, 5, 7 };
		Assert.assertEquals(1 , findInsertPositionBS(arr, 0, arr.length - 1, 1));
		Assert.assertEquals(2 , findInsertPositionBS(arr, 0, arr.length - 1, 4));
		Assert.assertEquals(1 , findInsertPositionBS(arr, 0, arr.length - 1, 2));
		Assert.assertEquals(4 , findInsertPositionBS(arr, 0, arr.length - 1, 8));	
		
		arr = new int[] { 1, 1, 3 };
		Assert.assertEquals(2 , findInsertPositionBS(arr, 0, arr.length - 1, 1));
		Assert.assertEquals(3 , findInsertPositionBS(arr, 0, arr.length - 1, 3));
		Assert.assertEquals(3 , findInsertPositionBS(arr, 0, arr.length - 1, 10));
		
		arr = new int[] { 2, 3, 3 };
		Assert.assertEquals(0 , findInsertPositionBS(arr, 0, arr.length - 1, 1));
	}
	
	@Test
	public void bsInsertionSortTest() {
		int[] arr = { 1, 7, 3, 5 };
		int[] expArr = { 1, 3, 5, 7 };
		bsInsertionSort(arr);
		Assert.assertArrayEquals(expArr, arr);

		arr = new int[] { 2, 3, 4, 5, 6 };
		expArr = new int[] { 2, 3, 4, 5, 6 };
		bsInsertionSort(arr);
		Assert.assertArrayEquals(expArr, arr);

		arr = new int[] { 6, 5, 4, 3, 2, 1 };
		expArr = new int[] { 1, 2, 3, 4, 5, 6 };
		bsInsertionSort(arr);
		Assert.assertArrayEquals(expArr, arr);

		arr = new int[] { 2, 1 };
		expArr = new int[] { 1, 2 };
		bsInsertionSort(arr);
		Assert.assertArrayEquals(expArr, arr);

		arr = new int[] { 1, 3, 1 };
		expArr = new int[] { 1, 1, 3 };
		bsInsertionSort(arr);
		Assert.assertArrayEquals(expArr, arr);
	}
	
	@Test
	public void countingSortTest() {
		int[] arr = { 1, 7, 3, 5 };
		int[] expArr = { 1, 3, 5, 7 };
		int[] result = countingSort(arr, 9);
		Assert.assertArrayEquals(expArr, result);

		arr = new int[] { 2, 3, 4, 5, 6 };
		expArr = new int[] { 2, 3, 4, 5, 6 };
		result = countingSort(arr, 9);
		Assert.assertArrayEquals(expArr, result);

		arr = new int[] { 6, 5, 4, 3, 2, 1 };
		expArr = new int[] { 1, 2, 3, 4, 5, 6 };
		result = countingSort(arr, 9);
		Assert.assertArrayEquals(expArr, result);

		arr = new int[] { 2, 1 };
		expArr = new int[] { 1, 2 };
		result = countingSort(arr, 3);
		Assert.assertArrayEquals(expArr, result);

		arr = new int[] { 1, 3, 1 };
		expArr = new int[] { 1, 1, 3 };
		result = countingSort(arr, 4);
		Assert.assertArrayEquals(expArr, result);
	}
	
}
