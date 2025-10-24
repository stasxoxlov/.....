2. Сортировка обменом
def bubble_sort(arr):
    n = len(arr)
    for i in range(n-1):
        for j in range(0, n-i-1):
            if arr[j] > arr[j+1]:
                arr[j], arr[j+1] = arr[j+1], arr[j]

if __name__ == "__main__":
    test_array = [64, 34, 25, 12, 22, 11, 90]
    print("Исходный массив:", test_array)
    bubble_sort(test_array)
    print("Отсортированный массив:", test_array)
  5. Сортировка Шелла 

def shell_sort(arr):
    n = len(arr)
    gap = n // 2
    
    while gap > 0:
        for i in range(gap, n):
            temp = arr[i]
            j = i
            while j >= gap and arr[j - gap] > temp:
                arr[j] = arr[j - gap]
                j -= gap
            arr[j] = temp
        gap //= 2

if __name__ == "__main__":
    arr = [12, 34, 54, 2, 3]
    print("Исходный массив:", arr)
    shell_sort(arr)
    print("Отсортированный массив:", arr)
  8. Линейный поиск 
def linear_search(arr, target):
    for i in range(len(arr)):
        if arr[i] == target:
            return i
    return -1

if __name__ == "__main__":
    array = [3, 5, 2, 7, 9, 1, 4]
    target = 7
    
    result = linear_search(array, target)
    
    if result != -1:
        print(f"Элемент найден на позиции: {result}")
    else:
        print("Элемент не найден")
11. Поиск Фибоначчи
def fibonacci_search(arr, x):
    n = len(arr)
    fib_m2 = 0
    fib_m1 = 1
    fib_m = fib_m2 + fib_m1
    
    while fib_m < n:
        fib_m2 = fib_m1
        fib_m1 = fib_m
        fib_m = fib_m2 + fib_m1
    
    offset = -1
    
    while fib_m > 1:
        i = min(offset + fib_m2, n - 1)
        
        if arr[i] < x:
            fib_m = fib_m1
            fib_m1 = fib_m2
            fib_m2 = fib_m - fib_m1
            offset = i
        elif arr[i] > x:
            fib_m = fib_m2
            fib_m1 = fib_m1 - fib_m2
            fib_m2 = fib_m - fib_m1
        else:
            return i
    
    if fib_m1 and offset + 1 < n and arr[offset + 1] == x:
        return offset + 1
    
    return -1

if __name__ == "__main__":
    arr = [10, 22, 35, 40, 45, 50, 80, 82, 85, 90, 100]
    x = 85
    
    result = fibonacci_search(arr, x)
    
    if result != -1:
        print(f"Элемент найден на позиции: {result}")
    else:
        print("Элемент не найден")
