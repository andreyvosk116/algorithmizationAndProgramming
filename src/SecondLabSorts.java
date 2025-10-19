import java.util.Random;

public class SecondLabSorts {
    public static void main(String[] args) throws Exception {

        // Простые короткие массивы 
        int[] test1List1 = {1, 3, 4, 1, 4, 2, 4, 1, 5};
        int[] test1List2 = copyList(test1List1);
        int[] test1List3 = copyList(test1List1);





        bubbleSort(test1List1);
        shakeSort(test1List2);


        
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
        int lenArr = arr.length;

        double startTimeNano = System.nanoTime();
        double startTimeMile = System.currentTimeMillis();
        
        while(left < right) {

            for(int i = left; i < right; i++) {
                if(arr[left] > arr[i]) {
                    int temp = arr[left];
                    arr[left] = arr[i];
                    arr[i] = temp;
                }
            }
            left++;

            for(int i = right; i >= left; i--) {
                if(arr[right] < arr[i]) {
                    int temp = arr[right];
                    arr[right] = arr[i];
                    arr[i] = temp;
                }
            }
            right--;
        }

        double endTimeNano = System.nanoTime();
        double endTimeMile = System.currentTimeMillis();

        double resNano = endTimeNano - startTimeNano;
        double resMiles = endTimeMile - startTimeMile;

        System.out.printf("Время потраченное на сортировку перемешиванием в милисекундах = %f, в наносекундах = %f%n", resMiles, resNano);

    }

    public static void heapSort(int[] arr) {
        
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
}

