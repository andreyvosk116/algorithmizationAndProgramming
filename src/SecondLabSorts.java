import java.util.Random;

public class SecondLabSorts {
    public static void main(String[] args) throws Exception {

        // Область рандомных массивов 

        // Простые короткие массивы и тесты к ним 
        int[] test1List1 = {1, 3, 4, 1, 4, 2, 4, 1, 5};
        int[] test1List2 = copyList(test1List1);
        int[] test1List3 = copyList(test1List1);

        bubbleSort(test1List1);
        shakeSort(test1List2);
        heapSort(test1List3);

        System.out.println("\nТесты со средними массивами\n");

        // Рандомные средние массивы и тесты к ним
        int[] test2List1 = createNewRandomList(1000);
        int[] test2List2 = copyList(test2List1);
        int[] test2List3 = copyList(test2List1);

        bubbleSort(test2List1);
        shakeSort(test2List2);
        heapSort(test2List3);

        
        System.out.println("\nТесты с большими массивами\n");

        // Рандомные большие массивы и тесты к ним 
        int[] test3List1 = createNewRandomList(10000);
        int[] test3List2 = copyList(test3List1);
        int[] test3List3 = copyList(test3List1);

        bubbleSort(test3List1);
        shakeSort(test3List2);
        heapSort(test3List3);

        // Область частично отсортированных массивов

        // малые массивы 

        System.out.println("\n-------------Тесты с частисно отсортированными массивами--------------------\n");

        System.out.println("\nТесты с малыми массивами\n");

        int[] test4List1 = createNewListWithProcent(10, 75);
        int[] test4List2 = copyList(test4List1);
        int[] test4List3 = copyList(test4List1);

        bubbleSort(test4List1);
        shakeSort(test4List2);
        heapSort(test4List3);

        // средние массивы 

        System.out.println("\nТесты со средними массивами\n");

        int[] test5List1 = createNewListWithProcent(1000, 75);
        int[] test5List2 = copyList(test5List1);
        int[] test5List3 = copyList(test5List1);

        bubbleSort(test5List1);
        shakeSort(test5List2);
        heapSort(test5List3);

        // большие массивы 

        System.out.println("\nТесты с большими массивами\n");

        int[] test6List1 = createNewListWithProcent(10000, 75);
        int[] test6List2 = copyList(test6List1);
        int[] test6List3 = copyList(test6List1);

        bubbleSort(test6List1);
        shakeSort(test6List2);
        heapSort(test6List3);

        System.out.println("\n-------------Тесты с обратно отсортированными массивами--------------------\n");

        // малые массивы

        System.out.println("\nТесты с малыми массивами\n");

        int[] test7List1 = createNewReversList(10);
        int[] test7List2 = copyList(test7List1);
        int[] test7List3 = copyList(test7List1);

        bubbleSort(test7List1);
        shakeSort(test7List2);
        heapSort(test7List3);


        // средние массивы 

        System.out.println("\nТесты со средними массивами\n");

        int[] test8List1 = createNewReversList(1000);
        int[] test8List2 = copyList(test8List1);
        int[] test8List3 = copyList(test8List1);

        bubbleSort(test8List1);
        shakeSort(test8List2);
        heapSort(test8List3);

        // большие массивы 

        System.out.println("\nТесты с большими массивами\n");

        int[] test9List1 = createNewReversList(1000);
        int[] test9List2 = copyList(test9List1);
        int[] test9List3 = copyList(test9List1);

        bubbleSort(test9List1);
        shakeSort(test9List2);
        heapSort(test9List3);

        System.out.println("\n-------------Тесты со множествами дубликатов--------------------\n");

        System.out.println("\nТесты с малыми массивами\n");

        int[] test10List1 = createArrayWithManyDuplicates(10);
        int[] test10List2 = copyList(test10List1);
        int[] test10List3 = copyList(test10List1);

        bubbleSort(test10List1);
        shakeSort(test10List2);
        heapSort(test10List3);

        System.out.println("\nТесты со средними массивами\n");

        int[] test11List1 = createArrayWithManyDuplicates(1000);
        int[] test11List2 = copyList(test11List1);
        int[] test11List3 = copyList(test11List1);

        bubbleSort(test11List1);
        shakeSort(test11List2);
        heapSort(test11List3);

        System.out.println("\nТесты с большими массивами\n");

        int[] test12List1 = createNewReversList(10000);
        int[] test12List2 = copyList(test12List1);
        int[] test12List3 = copyList(test12List1);

        bubbleSort(test12List1);
        shakeSort(test12List2);
        heapSort(test12List3);

                System.out.println("\n-------------Тесты с почти отсортированным масивом 90% дубликатов--------------------\n");

        System.out.println("\nТесты с малыми массивами\n");

        int[] test13List1 = createNewListWithProcent(10, 90);
        int[] test13List2 = copyList(test13List1);
        int[] test13List3 = copyList(test13List1);

        bubbleSort(test13List1);
        shakeSort(test13List2);
        heapSort(test13List3);

        System.out.println("\nТесты со средними массивами\n");

        int[] test14List1 = createNewListWithProcent(1000, 90);
        int[] test14List2 = copyList(test14List1);
        int[] test14List3 = copyList(test14List1);

        bubbleSort(test14List1);
        shakeSort(test14List2);
        heapSort(test14List3);

        System.out.println("\nТесты с большими массивами\n");

        int[] test15List1 = createNewListWithProcent(10000, 90);
        int[] test15List2 = copyList(test15List1);
        int[] test15List3 = copyList(test15List1);

        bubbleSort(test15List1);
        shakeSort(test15List2);
        heapSort(test15List3);



    }

    public static void bubbleSort(int[] arr) {
        // Пузырьковая сортировка 
        int lenArr = arr.length;

        double startTimeNano = System.nanoTime();
        double startTimeMile = System.currentTimeMillis();

        for(int i = 0; i < lenArr; i++) {
            for(int k = 0; k < lenArr - 1; k++) {
                if(arr[k] > arr[k + 1]){
                    int temp = arr[k];
                    arr[k] = arr[k + 1];
                    arr[k + 1] = temp;
                }
            }
        }

        double endTimeNano = System.nanoTime();
        double endTimeMile = System.currentTimeMillis();

        double resNano = endTimeNano - startTimeNano;
        double resMiles = endTimeMile - startTimeMile;

        System.out.printf("Время потраченное на пузырьковую сортировку в милисекундах = %f, в наносекундах = %f%n", resMiles, resNano);

    }

    public static void shakeSort(int[] arr) {
        // Сортировка перемешиванием
        int right = arr.length - 1;
        int left = 0;

        double startTimeNano = System.nanoTime();
        double startTimeMile = System.currentTimeMillis();
        
        while(left < right) {

            for(int i = left; i < right; i++) {
                if(arr[i] > arr[i + 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i + 1];
                    arr[i + 1] = temp;
                }
            }
            right--;

            for(int i = right; i > left; i--) {
                if(arr[i] < arr[i - 1]) {
                    int temp = arr[i];
                    arr[i] = arr[i - 1];
                    arr[i - 1] = temp;
                }
            }
            left++;
        }

        double endTimeNano = System.nanoTime();
        double endTimeMile = System.currentTimeMillis();

        double resNano = endTimeNano - startTimeNano;
        double resMiles = endTimeMile - startTimeMile;

        System.out.printf("Время потраченное на сортировку перемешиванием в милисекундах = %f, в наносекундах = %f%n", resMiles, resNano);

    }

    public static void heapSort(int[] arr) {

        int n = arr.length;

        double startTimeNano = System.nanoTime();
        double startTimeMile = System.currentTimeMillis();

        for(int i = n / 2 - 1; i >= 0; i--) {
            heapify(arr, n, i);
        }

        for (int i = n - 1; i >= 0; i--)
        {
            int temp = arr[0];
            arr[0] = arr[i];
            arr[i] = temp;

            heapify(arr, i, 0);
        }

        double endTimeNano = System.nanoTime();
        double endTimeMile = System.currentTimeMillis();

        double resNano = endTimeNano - startTimeNano;
        double resMiles = endTimeMile - startTimeMile;

        System.out.printf("Время потраченное на пирамидальную сортировку в милисекундах = %f, в наносекундах = %f%n", resMiles, resNano);

    }  

    public static void heapify(int[] arr, int n, int i) {
        // Процедура для преобразования в двоичную кучу поддерева с корневым узлом i

        int largest = i;
        int left = 2 * i + 1;
        int right = 2 * i + 2;

        if(left < n && arr[left] > arr[largest]) {
            largest = left;
        }

        if(right < n && arr[right] > arr[largest]) {
            largest = right;
        }

        if(largest != i) {
            int temp = arr[i];
            arr[i] = arr[largest];
            arr[largest] = temp;

            heapify(arr, n, largest);
        }

    }

    public static int[] copyList(int[] arr) {
        // Для копирования элементов массива 
        int[] newArr = new int[arr.length];

        for(int i = 0; i < newArr.length; i++) {
            newArr[i] = arr[i];
        }

        return newArr;
    }

    public static int[] createNewRandomList(int lenght) {
        int[] newList = new int[lenght];

        Random random = new Random();

        for(int i = 0; i < lenght; i++) {
            newList[i] = random.nextInt(1000);
        }

        return newList;
    }

    public static int[] createNewListWithProcent(int length, int procent) {
        // Метод для создания частично отсортированного массива с указанием процента количества отсортированных элементов
        int[] newList = new int[length];
        Random random = new Random();
    

        for(int i = 0; i < length; i++) {
            newList[i] = i;
        }

        int elementsToShuffle = length * (100 - procent) / 100;
        for(int i = 0; i < elementsToShuffle; i++) {
            int index = random.nextInt(length);
            newList[index] = random.nextInt(10000);
        }
        
        return newList;
    }

    public static int[] createNewReversList(int lenght) {
        
        int[] newList = new int[lenght];

        int elem = lenght;

        for(int i = 0; i > lenght; i--) {
            newList[i] = elem;
            elem--;
        }

        return newList;
    }

    

    public static int[] createArrayWithManyDuplicates(int length) {

        int[] newList = new int[length];
        Random random = new Random();
        
        int uniqueCount = length / 10;
        if (uniqueCount < 1) uniqueCount = 1;

        int[] uniqueValues = new int[uniqueCount];
        for (int i = 0; i < uniqueCount; i++) {
            uniqueValues[i] = random.nextInt(1000);
        }

        for (int i = 0; i < length; i++) {
            int randomIndex = random.nextInt(uniqueCount);
            newList[i] = uniqueValues[randomIndex];
        }
        
        return newList;
    
    }

}

