public class MergeSortExplicado {

    // Método para ordenar el arreglo usando Merge Sort
    public static void mergeSort(int[] arr, int left, int right) {
        // Paso 1: Divide el arreglo en dos mitades
        if (left < right) {
            // Encuentra el punto medio del arreglo
            int mid = (left + right) / 2;

            // Ordena la primera mitad ( Ordena recursivamente cada mitad)
            mergeSort(arr, left, mid);
            // Ordena la segunda mitad ( Ordena recursivamente cada mitad)
            mergeSort(arr, mid + 1, right);

            // Combina las dos mitades ordenadas
            merge(arr, left, mid, right);
        }
    }

    // Método para combinar dos subarreglos de arr[]
    private static void merge(int[] arr, int left, int mid, int right) {
        // Calcula el tamaño de los dos subarreglos para combinar
        int sizeLeft = mid - left + 1;
        int sizeRight = right - mid;

        // Crea arreglos temporales
        int[] tempLeft = new int[sizeLeft];
        int[] tempRight = new int[sizeRight];

        // Copia los datos a los arreglos temporales
        for (int i = 0; i < sizeLeft; i++) {
            tempLeft[i] = arr[left + i];
        }
        for (int j = 0; j < sizeRight; j++) {
            tempRight[j] = arr[mid + 1 + j];
        }

        // Índices iniciales de los subarreglos y del arreglo combinado
        int i = 0, j = 0;
        int k = left;

        // Combina los arreglos temporales
        while (i < sizeLeft && j < sizeRight) {
            if (tempLeft[i] <= tempRight[j]) {
                arr[k] = tempLeft[i];
                i++;
            } else {
                arr[k] = tempRight[j];
                j++;
            }
            k++;
        }

        // Copia los elementos restantes de tempLeft[], si hay alguno
        while (i < sizeLeft) {
            arr[k] = tempLeft[i];
            i++;
            k++;
        }

        // Copia los elementos restantes de tempRight[], si hay alguno
        while (j < sizeRight) {
            arr[k] = tempRight[j];
            j++;
            k++;
        }
    }

    
    public static void main(String[] args) {
        // Crea un arreglo de ejemplo
        int[] arr = {38, 27, 43, 3, 82, 0};
        int n = arr.length;

        // Ordena el arreglo usando Merge Sort
        mergeSort(arr, 0, n - 1);

        // Imprime el arreglo ordenado
        System.out.println("Arreglo ordenado:");
        for (int num : arr) {
            System.out.println(num + " ");
        }
    }
}
