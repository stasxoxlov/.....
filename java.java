1. Сортировка выбором
public class SelectionSort {
    public static void selectionSort(int[] arr) {
        for (int i = 0; i < arr.length - 1; i++) {
            int minIndex = i;
            for (int j = i + 1; j < arr.length; j++) {
                if (arr[j] < arr[minIndex]) {
                    minIndex = j;
                }
            }
            int temp = arr[minIndex];
            arr[minIndex] = arr[i];
            arr[i] = temp;
        }
    }
    
    public static void main(String[] args) {
        int[] testArray = {64, 25, 12, 22, 11};
        System.out.print("Исходный массив: ");
        for (int num : testArray) {
            System.out.print(num + " ");
        }
        
        selectionSort(testArray);
        
        System.out.print("\nОтсортированный массив: ");
        for (int num : testArray) {
            System.out.print(num + " ");
        }
    }
}
4. Сортировка слиянием

import java.util.Arrays;

public class MergeSort {
    public static int[] mergeSort(int[] arr) {
        if (arr.length <= 1) {
            return arr;
        }
        
        int mid = arr.length / 2;
        int[] left = Arrays.copyOfRange(arr, 0, mid);
        int[] right = Arrays.copyOfRange(arr, mid, arr.length);
        
        left = mergeSort(left);
        right = mergeSort(right);
        
        return merge(left, right);
    }
    
    private static int[] merge(int[] left, int[] right) {
        int[] result = new int[left.length + right.length];
        int i = 0, j = 0, k = 0;
        
        while (i < left.length && j < right.length) {
            if (left[i] < right[j]) {
                result[k++] = left[i++];
            } else {
                result[k++] = right[j++];
            }
        }
        
        while (i < left.length) {
            result[k++] = left[i++];
        }
        
        while (j < right.length) {
            result[k++] = right[j++];
        }
        
        return result;
    }
    
    public static void main(String[] args) {
        int[] array = {38, 27, 43, 3, 9, 82, 10};
        System.out.println("Исходный массив: " + Arrays.toString(array));
        
        int[] sortedArray = mergeSort(array);
        
        System.out.println("Отсортированный массив: " + Arrays.toString(sortedArray));
    }
}
7 Пирамидальная сортировка

public class HeapSort {
    public static void heapSort(int[] arr) {
        int n = arr.length;
        
        for (int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }
        
        for (int i = n - 1; i > 0; i--) {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;
            
            heapify(arr, i, 0);
        }
    }
    
    private static void heapify(int[] arr, int n, int i) {
        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;
        
        if (left < n && arr[left] > arr[largest]) {
            largest = left;
        }
        
        if (right < n && arr[right] > arr[largest]) {
            largest = right;
        }
        
        if (largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;
            
            heapify(arr, n, largest);
        }
    }
    
    public static void main(String[] args) {
        int[] arr = {12, 11, 13, 5, 6, 7};
        System.out.println("Исходный массив: " + java.util.Arrays.toString(arr));
        
        heapSort(arr);
        
        System.out.println("Отсортированный массив: " + java.util.Arrays.toString(arr));
    }
}
10. Интерполяционный поиск

public class InterpolationSearch {
    public static int interpolationSearch(int[] arr, int lo, int hi, int x) {
        if (lo <= hi && x >= arr[lo] && x <= arr[hi]) {
            int pos = lo + (((hi - lo) * (x - arr[lo])) / (arr[hi] - arr[lo]));
            
            if (arr[pos] == x) {
                return pos;
            }
            
            if (arr[pos] < x) {
                return interpolationSearch(arr, pos + 1, hi, x);
            }
            
            if (arr[pos] > x) {
                return interpolationSearch(arr, lo, pos - 1, x);
            }
        }
        return -1;
    }
    
    public static void main(String[] args) {
        int[] arr = {10, 12, 13, 16, 18, 19, 20, 21, 22, 23, 24, 33, 35, 42, 47};
        int x = 18;
        
        int result = interpolationSearch(arr, 0, arr.length - 1, x);
        
        if (result != -1) {
            System.out.println("Элемент найден на позиции: " + result);
        } else {
            System.out.println("Элемент не найден");
        }
    }
}
